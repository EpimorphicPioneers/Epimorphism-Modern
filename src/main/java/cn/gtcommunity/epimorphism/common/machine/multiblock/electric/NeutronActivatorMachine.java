package cn.gtcommunity.epimorphism.common.machine.multiblock.electric;

import cn.gtcommunity.epimorphism.api.machine.multiblock.NoEnergyMultiblockMachine;
import cn.gtcommunity.epimorphism.api.recipe.EPRecipeHelper;
import cn.gtcommunity.epimorphism.api.structure.utils.IValueContainer;
import cn.gtcommunity.epimorphism.api.structure.utils.UniverUtil;
import cn.gtcommunity.epimorphism.common.data.EPItems;
import cn.gtcommunity.epimorphism.common.machine.multiblock.part.NeutronAcceleratorMachine;
import cn.gtcommunity.epimorphism.common.recipe.NeutronKineticEnergyCondition;
import cn.gtcommunity.epimorphism.utils.EPLangUtil;
import com.gregtechceu.gtceu.api.capability.IEnergyContainer;
import com.gregtechceu.gtceu.api.capability.recipe.*;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.machine.ConditionalSubscriptionHandler;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.IExplosionMachine;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiPart;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.ingredient.SizedIngredient;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.data.recipe.builder.GTRecipeBuilder;
import com.gregtechceu.gtceu.utils.FormattingUtil;
import com.lowdragmc.lowdraglib.side.item.IItemTransfer;
import com.lowdragmc.lowdraglib.syncdata.annotation.DescSynced;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import it.unimi.dsi.fastutil.longs.Long2ObjectMaps;
import lombok.Getter;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.chat.Component;
import net.minecraft.server.TickTask;
import net.minecraft.server.level.ServerLevel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static cn.gtcommunity.epimorphism.utils.EPMathUtil.*;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class NeutronActivatorMachine extends NoEnergyMultiblockMachine implements IExplosionMachine {
    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(NeutronActivatorMachine.class, NoEnergyMultiblockMachine.MANAGED_FIELD_HOLDER);
    @Getter @Persisted
    private int height = 0;
    @Getter @Persisted @DescSynced
    private int eV;

    protected ConditionalSubscriptionHandler neutronEnergySubs;
    protected ConditionalSubscriptionHandler moderateSubs;

    private final static int MAX_ENERGY = 1200 * M;

    public NeutronActivatorMachine(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
        this.neutronEnergySubs = new ConditionalSubscriptionHandler(this, this::neutronEnergyUpdate, () -> this.isFormed);
        this.moderateSubs = new ConditionalSubscriptionHandler(this, this::moderateUpdate, () -> this.isFormed && eV > 0);
    }

    //////////////////////////////////////
    //***    Multiblock LifeCycle    ***//
    //////////////////////////////////////

    @Override
    public void onStructureFormed() {
        super.onStructureFormed();
        IValueContainer<?> container = getMultiblockState().getMatchContext().getOrCreate("SpeedPipeValue", IValueContainer::noop);
        if (container.getValue() instanceof Integer integer) {
            height = integer;
        }

        Map<Long, IO> ioMap = getMultiblockState().getMatchContext().getOrCreate("ioMap", Long2ObjectMaps::emptyMap);
        for (IMultiPart part : getParts()) {
            IO io = ioMap.getOrDefault(part.self().getPos().asLong(), IO.BOTH);
            if (io == IO.NONE) continue;
            for (var handler : part.getRecipeHandlers()) {
                var handlerIO = handler.getHandlerIO();
                // If IO not compatible
                if (io != IO.BOTH && handlerIO != IO.BOTH && io != handlerIO) continue;
                if (handler.getCapability() == ItemRecipeCapability.CAP && handler instanceof IItemTransfer) {
                    traitSubscriptions.add(handler.addChangedListener(moderateSubs::updateSubscription));
                }

                if (handler.getCapability() == EURecipeCapability.CAP && handler instanceof IEnergyContainer) {
                    traitSubscriptions.add(handler.addChangedListener(neutronEnergySubs::updateSubscription));
                }
            }
        }

        if (getLevel() instanceof ServerLevel serverLevel) {
            serverLevel.getServer().tell(new TickTask(0, neutronEnergySubs::updateSubscription));
        }
    }

    @Override
    public void onLoad() {
        super.onLoad();
        if (getLevel() instanceof ServerLevel serverLevel) {
            serverLevel.getServer().tell(new TickTask(0, neutronEnergySubs::updateSubscription));
        }
    }

    @Override
    public void onStructureInvalid() {
        super.onStructureInvalid();
        height = 0;
    }

    //////////////////////////////////////
    //******     Recipe Logic    *******//
    //////////////////////////////////////

    @Override
    public boolean alwaysTryModifyRecipe(){
        return true;
    }

    @Override
    protected @Nullable GTRecipe getRealRecipe(GTRecipe recipe) {
        var conditions = recipe.conditions.stream().filter(NeutronKineticEnergyCondition.class::isInstance).toArray(NeutronKineticEnergyCondition[]::new);
        GTRecipe newRecipe = recipe.copy();
        newRecipe.duration = (int) Math.round(Math.max(newRecipe.duration * getVelocityFactor(), 1));
        if (conditions.length > 0) {
            var condition = conditions[0];
            if (eV > condition.getEvMax() || eV < condition.getEvMin()) {
                newRecipe.outputs.clear();
                newRecipe.outputs.put(ItemRecipeCapability.CAP, List.of(EPRecipeHelper.itemStack(EPItems.RADIOACTIVE_WASTE.asStack(), 1, 0)));
            }
        }
        return super.getRealRecipe(newRecipe);
    }

    //////////////////////////////////////
    //***  Multiblock Subscriptions  ***//
    //////////////////////////////////////

    protected void neutronEnergyUpdate() {
        boolean anyWorking = false;
        if (!isRemote()) {
            for (IMultiPart part : getParts()) {
                if (part instanceof NeutronAcceleratorMachine neutronAccelerator) {
                    long increase = neutronAccelerator.consumeEnergy();
                    if (increase > 0) {
                        anyWorking = true;
                        this.eV += (int) Math.round(Math.max(increase * getEfficiencyFactor(), 1));
                    }
                }
            }

            if (!anyWorking && getOffsetTimer() % 20 == 0) {
                this.eV = Math.max(eV - 72 * K, 0);
            }
            if (this.eV < 0) this.eV = 0;

            if (this.eV > MAX_ENERGY) doExplosion(4 * 32);
        }
    }

    protected void moderateUpdate() {
        moderate(GTMaterials.Beryllium);
        moderate(GTMaterials.Graphite);
    }

    private void moderate(Material material) {
        if (eV <= 0) return;

        List<IRecipeHandler<?>> handlers = UniverUtil.getOrDefault(getCapabilitiesProxy().get(IO.IN, ItemRecipeCapability.CAP), Collections::emptyList);
        int consume = Math.max(eV / (10 * M), 1);
        var stack = ChemicalHelper.get(TagPrefix.dust, material, consume);
        GTRecipe recipe = GTRecipeBuilder.ofRaw().inputItems(stack).buildRawRecipe();
        List<?> list = List.of(SizedIngredient.of(stack));
        for (var handler : handlers) {
            list = UniverUtil.getOrDefault(handler.handleRecipe(IO.IN, recipe, list, null, false), Collections::emptyList);
        }

        if (!list.isEmpty()) {
            stack.shrink(((SizedIngredient) list.get(0)).getAmount());
        }
        this.eV = Math.max(0, 10 * M * stack.getCount());
    }


    //////////////////////////////////////
    //***        Multiblock UI       ***//
    //////////////////////////////////////

    @Override
    public void addDisplayText(List<Component> textList) {
        super.addDisplayText(textList);
        if (isFormed()) {
            textList.add(Component.translatable("block.epimorphism.neutron_activator.ev", processNumber(eV)));
            textList.add(Component.translatable("block.epimorphism.neutron_activator.height", FormattingUtil.formatNumbers(height)));
            textList.add(Component.translatable("block.epimorphism.neutron_activator.efficiency", FormattingUtil.formatNumbers(getEfficiencyFactor() * 100)));
        }
    }

    private String processNumber(int num) {
        return EPLangUtil.abbreviate1F(num).replaceAll("(\\d)([a-zA-Z])", "$1 $2");
    }

    //////////////////////////////////////
    //***       Multiblock Data      ***//
    //////////////////////////////////////

    private double getVelocityFactor() {
        return Math.pow(0.9, Math.max(height - 4, 0));
    }

    private double getEfficiencyFactor() {
        return Math.pow(0.95, Math.max(height - 4, 0));
    }

    @Override
    public @NotNull ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }
}
