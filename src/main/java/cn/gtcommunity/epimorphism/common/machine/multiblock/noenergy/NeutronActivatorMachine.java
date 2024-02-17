package cn.gtcommunity.epimorphism.common.machine.multiblock.noenergy;

import cn.gtcommunity.epimorphism.api.machine.multiblock.NoEnergyMultiblockMachine;
import cn.gtcommunity.epimorphism.api.recipe.EPRecipeHelper;
import cn.gtcommunity.epimorphism.api.structure.utils.IValueContainer;
import cn.gtcommunity.epimorphism.api.structure.utils.UniverUtil;
import cn.gtcommunity.epimorphism.common.data.EPItems;
import cn.gtcommunity.epimorphism.common.machine.multiblock.part.NeutronAcceleratorMachine;
import cn.gtcommunity.epimorphism.common.machine.multiblock.part.NeutronSensorMachine;
import cn.gtcommunity.epimorphism.common.recipe.NeutronKineticEnergyCondition;
import cn.gtcommunity.epimorphism.utils.EPLangUtil;
import com.gregtechceu.gtceu.api.capability.IEnergyContainer;
import com.gregtechceu.gtceu.api.capability.recipe.*;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.machine.ConditionalSubscriptionHandler;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.IExplosionMachine;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiPart;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.machine.multiblock.part.ItemBusPartMachine;
import com.gregtechceu.gtceu.utils.FormattingUtil;
import com.lowdragmc.lowdraglib.side.item.IItemTransfer;
import com.lowdragmc.lowdraglib.syncdata.annotation.DescSynced;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import it.unimi.dsi.fastutil.longs.Long2ObjectMaps;
import lombok.Getter;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static cn.gtcommunity.epimorphism.utils.EPMathUtil.*;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class NeutronActivatorMachine extends NoEnergyMultiblockMachine implements IExplosionMachine {
    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(NeutronActivatorMachine.class, NoEnergyMultiblockMachine.MANAGED_FIELD_HOLDER);
    @Getter
    @Persisted
    private int height = 0;
    @Getter
    @Persisted
    @DescSynced
    private int eV;
    @Persisted
    private boolean isWorking;

    protected ConditionalSubscriptionHandler neutronEnergySubs;
    protected ConditionalSubscriptionHandler moderateSubs;
    protected ConditionalSubscriptionHandler absorptionSubs;

    private Set<NeutronSensorMachine> sensorMachines;
    private Set<ItemBusPartMachine> busMachines;
    private Set<NeutronAcceleratorMachine> acceleratorMachines;

    private final static int MAX_ENERGY = 1200 * M;

    public NeutronActivatorMachine(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
        this.neutronEnergySubs = new ConditionalSubscriptionHandler(this, this::neutronEnergyUpdate, this::isFormed);
        this.moderateSubs = new ConditionalSubscriptionHandler(this, this::moderateUpdate, () -> eV > 0);
        this.absorptionSubs = new ConditionalSubscriptionHandler(this, this::absorptionUpdate, () -> eV > 0);
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
                if (handler.getCapability() == EURecipeCapability.CAP && handler instanceof IEnergyContainer) {
                    traitSubscriptions.add(handler.addChangedListener(neutronEnergySubs::updateSubscription));
                    traitSubscriptions.add(handler.addChangedListener(moderateSubs::updateSubscription));
                }

                if (handler.getCapability() == ItemRecipeCapability.CAP && handler instanceof IItemTransfer) {
                    if (handlerIO == IO.IN || handlerIO == IO.BOTH) {
                        traitSubscriptions.add(handler.addChangedListener(absorptionSubs::updateSubscription));
                    }
                }
            }

            if (part instanceof ItemBusPartMachine itemBusPartMachine) {
                busMachines = UniverUtil.getOrDefault(busMachines, HashSet::new);
                busMachines.add(itemBusPartMachine);
            }
            if (part instanceof NeutronSensorMachine neutronSensorMachine) {
                sensorMachines = UniverUtil.getOrDefault(sensorMachines, HashSet::new);
                sensorMachines.add(neutronSensorMachine);
            }
            if (part instanceof NeutronAcceleratorMachine neutronAccelerator) {
                acceleratorMachines = UniverUtil.getOrDefault(acceleratorMachines, HashSet::new);
                acceleratorMachines.add(neutronAccelerator);
            }
        }

        neutronEnergySubs.initialize(getLevel());
    }

    @Override
    public void onLoad() {
        super.onLoad();
        moderateSubs.initialize(getLevel());
    }

    @Override
    public void onStructureInvalid() {
        super.onStructureInvalid();
        height = 0;
        sensorMachines = null;
        busMachines = null;
        acceleratorMachines = null;
    }

    //////////////////////////////////////
    //******     Recipe Logic    *******//
    //////////////////////////////////////

    @Override
    public boolean alwaysTryModifyRecipe() {
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
        if (acceleratorMachines == null) return;

        boolean anyWorking = false;
        for (var accelerator : acceleratorMachines) {
            long increase = accelerator.consumeEnergy();
            if (increase > 0) {
                anyWorking = true;
                this.eV += (int) Math.round(Math.max(increase * getEfficiencyFactor(), 1));
            }
        }

        this.isWorking = anyWorking;

        if (this.eV > MAX_ENERGY) doExplosion(4 * 32);

        if (!isWorking) neutronEnergySubs.unsubscribe();
    }

    protected void moderateUpdate() {
        if (!isWorking && getOffsetTimer() % 20 == 0) {
            this.eV = Math.max(eV - 72 * K, 0);
        }
        if (this.eV < 0) this.eV = 0;

        if (!isFormed() || sensorMachines == null) return;
        sensorMachines.forEach(sensor -> sensor.update(eV));
    }

    protected void absorptionUpdate() {
        if (busMachines == null || eV <= 0) return;

        boolean hasSlower = false;
        for (var bus : busMachines) {
            var inv = bus.getInventory();
            var io = inv.getHandlerIO();
            if (io == IO.IN || io == IO.BOTH) {
                for (int i = 0; i < inv.getSlots(); i++) {
                    var dustBeryllium = ChemicalHelper.get(TagPrefix.dust, GTMaterials.Beryllium).getItem();
                    var dustGraphite = ChemicalHelper.get(TagPrefix.dust, GTMaterials.Graphite).getItem();
                    var stack = inv.getStackInSlot(i);
                    if (stack.is(dustBeryllium) || stack.is(dustGraphite)) {
                        hasSlower = true;
                        int consume = Math.min(Math.max(eV / (10 * M), 1), stack.getCount());
                        inv.extractItemInternal(i, consume, false);
                        this.eV -= 10 * M * consume;
                    }
                }
            }
        }

        if (!hasSlower) absorptionSubs.unsubscribe();
    }

    //////////////////////////////////////
    //***        Multiblock UI       ***//
    //////////////////////////////////////

    @Override
    public void addDisplayText(List<Component> textList) {
        super.addDisplayText(textList);
        textList.add(Component.translatable("block.epimorphism.neutron_activator.ev", processNumber(eV)));
        if (isFormed()) {
            textList.add(Component.translatable("block.epimorphism.neutron_activator.height", FormattingUtil.formatNumbers(height + 2)));
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
