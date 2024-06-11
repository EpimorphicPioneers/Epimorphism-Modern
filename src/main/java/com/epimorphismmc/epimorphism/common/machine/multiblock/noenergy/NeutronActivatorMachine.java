package com.epimorphismmc.epimorphism.common.machine.multiblock.noenergy;

import com.epimorphismmc.epimorphism.common.data.items.EPPhysicsItems;
import com.epimorphismmc.epimorphism.common.machine.multiblock.part.NeutronAcceleratorPartMachine;
import com.epimorphismmc.epimorphism.common.machine.multiblock.part.NeutronSensorPartMachine;
import com.epimorphismmc.epimorphism.common.recipe.NeutronEnergyCondition;

import com.epimorphismmc.monomorphism.machine.multiblock.NoEnergyMultiblockMachine;
import com.epimorphismmc.monomorphism.pattern.utils.containers.IValueContainer;
import com.epimorphismmc.monomorphism.recipe.MORecipeHelper;
import com.epimorphismmc.monomorphism.utility.MOFormattingUtils;

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

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.chat.Component;

import it.unimi.dsi.fastutil.longs.Long2ObjectMaps;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

import javax.annotation.ParametersAreNonnullByDefault;

import static com.epimorphismmc.monomorphism.MOValues.*;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class NeutronActivatorMachine extends NoEnergyMultiblockMachine
        implements IExplosionMachine {
    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(
            NeutronActivatorMachine.class, NoEnergyMultiblockMachine.MANAGED_FIELD_HOLDER);

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

    private Set<NeutronSensorPartMachine> sensorMachines;
    private Set<ItemBusPartMachine> busMachines;
    private Set<NeutronAcceleratorPartMachine> acceleratorMachines;

    private static final int MAX_ENERGY = 1200 * M;

    public NeutronActivatorMachine(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
        this.neutronEnergySubs =
                new ConditionalSubscriptionHandler(this, this::neutronEnergyUpdate, this::isFormed);
        this.moderateSubs =
                new ConditionalSubscriptionHandler(this, this::moderateUpdate, () -> eV > 0);
        this.absorptionSubs =
                new ConditionalSubscriptionHandler(this, this::absorptionUpdate, () -> eV > 0);
    }

    //////////////////////////////////////
    // ***    Multiblock LifeCycle    ***//
    //////////////////////////////////////

    @Override
    public void onStructureFormed() {
        super.onStructureFormed();
        IValueContainer<?> container =
                getMultiblockState().getMatchContext().getOrCreate("SpeedPipeValue", IValueContainer::noop);
        if (container.getValue() instanceof Integer integer) {
            height = integer;
        }

        Map<Long, IO> ioMap =
                getMultiblockState().getMatchContext().getOrCreate("ioMap", Long2ObjectMaps::emptyMap);
        for (IMultiPart part : getParts()) {
            if (part instanceof ItemBusPartMachine itemBusPartMachine) {
                busMachines = Objects.requireNonNullElseGet(busMachines, HashSet::new);
                busMachines.add(itemBusPartMachine);
            }
            if (part instanceof NeutronSensorPartMachine neutronSensorMachine) {
                sensorMachines = Objects.requireNonNullElseGet(sensorMachines, HashSet::new);
                sensorMachines.add(neutronSensorMachine);
            }
            if (part instanceof NeutronAcceleratorPartMachine neutronAccelerator) {
                acceleratorMachines = Objects.requireNonNullElseGet(acceleratorMachines, HashSet::new);
                acceleratorMachines.add(neutronAccelerator);
            }

            IO io = ioMap.getOrDefault(part.self().getPos().asLong(), IO.BOTH);
            if (io == IO.NONE) continue;
            for (var handler : part.getRecipeHandlers()) {
                var handlerIO = handler.getHandlerIO();
                // If IO not compatible
                if (io != IO.BOTH && handlerIO != IO.BOTH && io != handlerIO) continue;
                if (handler.getCapability() == EURecipeCapability.CAP
                        && handler instanceof IEnergyContainer) {
                    traitSubscriptions.add(handler.addChangedListener(neutronEnergySubs::updateSubscription));
                    traitSubscriptions.add(handler.addChangedListener(moderateSubs::updateSubscription));
                }

                if (handler.getCapability() == ItemRecipeCapability.CAP
                        && handler instanceof IItemTransfer) {
                    if (handlerIO == IO.IN || handlerIO == IO.BOTH) {
                        traitSubscriptions.add(handler.addChangedListener(absorptionSubs::updateSubscription));
                    }
                }
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
    // ******     Recipe Logic    *******//
    //////////////////////////////////////

    @Override
    public boolean alwaysTryModifyRecipe() {
        return true;
    }

    @Override
    protected @Nullable GTRecipe getRealRecipe(GTRecipe recipe) {
        var conditions = recipe.conditions.stream()
                .filter(NeutronEnergyCondition.class::isInstance)
                .toArray(NeutronEnergyCondition[]::new);
        GTRecipe newRecipe = recipe.copy();
        newRecipe.duration = (int) Math.round(Math.max(newRecipe.duration * getVelocityFactor(), 1));
        if (conditions.length > 0) {
            var condition = conditions[0];
            if (eV > condition.getEvMax() || eV < condition.getEvMin()) {
                newRecipe.outputs.clear();
                newRecipe.outputs.put(
                        ItemRecipeCapability.CAP,
                        List.of(MORecipeHelper.itemContent(EPPhysicsItems.RADIOACTIVE_WASTE.asStack(), 1, 0)));
            }
        }
        return super.getRealRecipe(newRecipe);
    }

    //////////////////////////////////////
    // ***  Multiblock Subscriptions  ***//
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
                    var dustBeryllium =
                            ChemicalHelper.get(TagPrefix.dust, GTMaterials.Beryllium).getItem();
                    var dustGraphite =
                            ChemicalHelper.get(TagPrefix.dust, GTMaterials.Graphite).getItem();
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
    // ***        Multiblock UI       ***//
    //////////////////////////////////////

    @Override
    public void addDisplayText(List<Component> textList) {
        super.addDisplayText(textList);
        textList.add(
                Component.translatable("block.epimorphism.neutron_activator.ev", processNumber(eV)));
        if (isFormed()) {
            textList.add(Component.translatable(
                    "block.epimorphism.neutron_activator.height", FormattingUtil.formatNumbers(height + 2)));
            textList.add(Component.translatable(
                    "block.epimorphism.neutron_activator.efficiency",
                    FormattingUtil.formatNumbers(getEfficiencyFactor() * 100)));
        }
    }

    private String processNumber(int num) {
        return MOFormattingUtils.abbreviate1F(num).replaceAll("(\\d)([a-zA-Z])", "$1 $2");
    }

    //////////////////////////////////////
    // ***       Multiblock Data      ***//
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
