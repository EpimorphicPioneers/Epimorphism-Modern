package com.epimorphismmc.epimorphism.common.machine.multiblock.storage;

import com.epimorphismmc.epimorphism.api.gui.widget.FluidTankMapWidget;
import com.epimorphismmc.epimorphism.api.machine.feature.multiblock.ITankProvider;
import com.epimorphismmc.epimorphism.api.machine.trait.ITankTrait;
import com.epimorphismmc.epimorphism.api.pattern.utils.StorageFieldBlockContainer;
import com.epimorphismmc.epimorphism.utils.EPFluidUtil;

import com.epimorphismmc.monomorphism.pattern.utils.containers.IValueContainer;

import com.gregtechceu.gtceu.api.capability.recipe.FluidRecipeCapability;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.gui.fancy.*;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.feature.IFancyUIMachine;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IDisplayUIMachine;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiPart;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.trait.MachineTrait;
import com.gregtechceu.gtceu.api.machine.trait.NotifiableItemStackHandler;

import com.lowdragmc.lowdraglib.gui.modular.ModularUI;
import com.lowdragmc.lowdraglib.gui.texture.IGuiTexture;
import com.lowdragmc.lowdraglib.gui.widget.*;
import com.lowdragmc.lowdraglib.misc.FluidStorage;
import com.lowdragmc.lowdraglib.misc.FluidTransferList;
import com.lowdragmc.lowdraglib.side.fluid.FluidStack;
import com.lowdragmc.lowdraglib.side.fluid.IFluidTransfer;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import com.lowdragmc.lowdraglib.syncdata.managed.IRef;

import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.material.Fluid;

import it.unimi.dsi.fastutil.longs.Long2ObjectMaps;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TFFTMachine extends WorkableMultiblockMachine
        implements IFancyUIMachine, IDisplayUIMachine, ITankProvider {
    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER =
            new ManagedFieldHolder(TFFTMachine.class, WorkableMultiblockMachine.MANAGED_FIELD_HOLDER);

    public static final int BASE_DISTINCT_FLUIDS = 25;
    public static final int DISTINCT_FLUIDS_PER_LAYER = 3;

    @Persisted
    public final NotifiableItemStackHandler inventory;

    private TFFTMachine.TFFTFluidTank fluidTank;

    private FluidTransferList inputHatches;
    private FluidTransferList outputHatches;

    //    protected ScheduledSubscriptionHandler tickSubscription;
    public TFFTMachine(IMachineBlockEntity holder) {
        super(holder);
        this.inventory = new NotifiableItemStackHandler(this, 1, IO.IN, IO.BOTH);
        //        this.fluidTank = new TFFTFluidTank(this, BigInteger.ZERO, 1);
    }

    //////////////////////////////////////
    // ***    Multiblock LifeCycle    ***//
    //////////////////////////////////////

    @Override
    public void onStructureFormed() {
        IValueContainer<?> container = getMultiblockState()
                .getMatchContext()
                .getOrCreate("StorageFieldBlockValue", IValueContainer::noop);

        // get the capacity and initialize the tank
        if (container instanceof StorageFieldBlockContainer blockContainer) {
            int tanks =
                    BASE_DISTINCT_FLUIDS + (blockContainer.getBlockNumber() / 9) * DISTINCT_FLUIDS_PER_LAYER;
            if (this.fluidTank == null) {
                this.fluidTank = new TFFTMachine.TFFTFluidTank(this, blockContainer.getValue(), tanks);
            } else {
                this.fluidTank = fluidTank.rebuild(blockContainer.getValue(), tanks);
                //                this.fluidTank.getSyncStorage().markAllDirty();
            }
        }

        super.onStructureFormed();

        // get IO
        List<IFluidTransfer> inputs = new ArrayList<>();
        List<IFluidTransfer> outputs = new ArrayList<>();
        Map<Long, IO> ioMap =
                getMultiblockState().getMatchContext().getOrCreate("ioMap", Long2ObjectMaps::emptyMap);
        for (IMultiPart part : getParts()) {
            IO io = ioMap.getOrDefault(part.self().getPos().asLong(), IO.BOTH);
            if (io == IO.NONE) continue;
            for (var handler : part.getRecipeHandlers()) {
                var handlerIO = handler.getHandlerIO();
                // If IO not compatible
                if (io != IO.BOTH && handlerIO != IO.BOTH && io != handlerIO) continue;
                if (handler.getCapability() == FluidRecipeCapability.CAP
                        && handler instanceof IFluidTransfer fluidContainer) {
                    if (handlerIO == IO.IN) {
                        inputs.add(fluidContainer);
                    } else if (handlerIO == IO.OUT) {
                        outputs.add(fluidContainer);
                    }
                    //
                    // traitSubscriptions.add(handler.addChangedListener(tickSubscription::updateSubscription));
                }
            }
        }
        this.inputHatches = new FluidTransferList(inputs);
        this.outputHatches = new FluidTransferList(outputs);
    }

    @Override
    public void onStructureInvalid() {
        super.onStructureInvalid();
    }

    //////////////////////////////////////
    // ***        Multiblock UI       ***//
    //////////////////////////////////////

    @Override
    public Widget createUIWidget() {
        var group = new WidgetGroup(0, 0, 182 + 8, 117 + 8);
        group.addWidget(new DraggableScrollableWidgetGroup(4, 4, 182, 117)
                .setBackground(getScreenTexture())
                .addWidget(new LabelWidget(4, 5, self().getBlockState().getBlock().getDescriptionId()))
                .addWidget(new ComponentPanelWidget(4, 17, this::addDisplayText)
                        .setMaxWidthLimit(150)
                        .clickHandler(this::handleDisplayClick)));
        group.setBackground(GuiTextures.BACKGROUND_INVERSE);
        return group;
    }

    @Override
    public ModularUI createUI(Player entityPlayer) {
        return new ModularUI(198, 208, this, entityPlayer)
                .widget(new FancyMachineUIWidget(this, 198, 208));
    }

    @Override
    public void attachSideTabs(TabsWidget sideTabs) {
        IFancyUIMachine.super.attachSideTabs(sideTabs);
        sideTabs.attachSubTab(new IFancyUIProvider() {
            @Override
            public Widget createMainPage(FancyMachineUIWidget fancyMachineUIWidget) {
                var group = new WidgetGroup(0, 0, 182 + 8, 129 + 8);

                var slotContainer = new WidgetGroup(4, 4, 18 + 8, 18 + 8);
                slotContainer.addWidget(
                        new SlotWidget(inventory.storage, 0, 4, 4, true, true).setBackground(GuiTextures.SLOT));
                slotContainer.setBackground(GuiTextures.BACKGROUND_INVERSE);

                group.addWidget(slotContainer);
                group.addWidget(new FluidTankMapWidget(2, 2, 182, 129, fluidTank.storages));

                return group;
            }

            @Override
            public IGuiTexture getTabIcon() {
                return TFFTMachine.this.getTabIcon();
            }

            @Override
            public Component getTitle() {
                return Component.translatable("tfft");
            }

            @Override
            public void attachConfigurators(ConfiguratorPanel configuratorPanel) {}

            @Override
            public void attachTooltips(TooltipsPanel tooltipsPanel) {}
        });
    }

    @Override
    public void attachTooltips(TooltipsPanel tooltipsPanel) {
        for (IMultiPart part : getParts()) {
            part.attachFancyTooltipsToController(this, tooltipsPanel);
        }
    }

    @Override
    public void addDisplayText(List<Component> textList) {
        IDisplayUIMachine.super.addDisplayText(textList);
        if (isFormed()) {
            if (!isWorkingEnabled()) {
                textList.add(Component.translatable("gtceu.multiblock.work_paused"));

            } else if (isActive()) {
                textList.add(Component.translatable("gtceu.multiblock.running"));
            } else {
                textList.add(Component.translatable("gtceu.multiblock.idling"));
            }

            if (recipeLogic.isWaiting()) {
                textList.add(Component.translatable("gtceu.multiblock.waiting")
                        .setStyle(Style.EMPTY.withColor(ChatFormatting.RED)));
            }
        }
        getDefinition().getAdditionalDisplay().accept(this, textList);
    }

    //////////////////////////////////////
    // ***       Multiblock Data      ***//
    //////////////////////////////////////

    @SuppressWarnings("unused")
    private boolean onTankDirty(TFFTFluidTank tank) {
        if (tank != null) {
            for (IRef ref : tank.getSyncStorage().getNonLazyFields()) {
                ref.update();
            }
            return tank.getSyncStorage().hasDirtySyncFields()
                    || tank.getSyncStorage().hasDirtyPersistedFields();
        }
        return false;
    }

    @SuppressWarnings("unused")
    private CompoundTag serializeTank(TFFTFluidTank tank) {
        return new CompoundTag();
    }

    @SuppressWarnings("unused")
    private TFFTFluidTank deserializeTank(CompoundTag uid) {
        return new TFFTFluidTank(this, BigInteger.ZERO, 1);
    }

    @Override
    public @NotNull ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    //////////////////////////////////////
    // ***  Multiblock Subscriptions  ***//
    //////////////////////////////////////

    @Override
    public ITankTrait getTank() {
        return fluidTank;
    }

    //////////////////////////////////////
    // ***      Multiblock Traits     ***//
    //////////////////////////////////////

    public static class TFFTFluidTank extends MachineTrait implements ITankTrait {

        protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER =
                new ManagedFieldHolder(TFFTMachine.TFFTFluidTank.class);

        @Persisted
        @Getter
        private final TankStorage[] storages;

        public TFFTFluidTank(MetaMachine machine, BigInteger capacity, int tanks) {
            super(machine);
            this.storages = new TankStorage[tanks];
            long tankCapacity = capacity.divide(BigInteger.valueOf(tanks)).longValue();
            for (int i = 0; i < this.storages.length; i++) {
                this.storages[i] = new TankStorage(tankCapacity);
                this.storages[i].setOnContentsChanged(this::onContentsChanged);
            }
        }

        public TFFTFluidTank rebuild(@NotNull BigInteger capacity, int tanks) {
            var tank = new TFFTFluidTank(machine, capacity, tanks);
            var storages =
                    Arrays.stream(this.storages).filter(TankStorage::hasFluid).toArray(TankStorage[]::new);

            for (TankStorage storage : storages) {
                var fluid = storage.getFluid().getFluid();
                var amount = storage.getFluid().getAmount();
                tank.fill(fluid, amount, false);
            }

            return tank;
        }

        @Override
        public int getTanks() {
            return storages.length;
        }

        @NotNull @Override
        public Fluid getFluidInTank(int tank) {
            return storages[tank].getFluid().getFluid();
        }

        @Override
        public long getFluidAmountInTank(int tank) {
            return storages[tank].getFluid().getAmount();
        }

        @Override
        public long getTankCapacity(int tank) {
            return storages[tank].getCapacity();
        }

        @Override
        public long fill(Fluid fluid, long amount, boolean simulate, boolean notifyChanges) {
            if (amount <= 0 || EPFluidUtil.isDefaultFluid(fluid)) return 0;

            long filled = 0;
            int emptyStorage = 0;
            boolean findEmpty = false;
            for (int i = 0; i < getTanks(); i++) {
                if (hasFluid(i)) {
                    if (fluid.isSame(getFluidInTank(i))) {
                        filled += fill(i, fluid, amount, simulate, false);
                        break;
                    }
                } else {
                    if (findEmpty) continue;
                    emptyStorage = i;
                    findEmpty = true;
                }
            }

            if (filled == 0 && findEmpty) {
                filled += fill(emptyStorage, fluid, amount, simulate, false);
            }

            if (notifyChanges && filled > 0 && !simulate) {
                onContentsChanged();
            }
            return filled;
        }

        @Override
        public long fill(int tank, Fluid fluid, long amount, boolean simulate, boolean notifyChanges) {
            return storages[tank].fill(fluid, amount, simulate, notifyChanges);
        }

        @Override
        public boolean supportsFill(int tank) {
            return storages[tank].supportsFill(tank);
        }

        @Override
        public long drain(Fluid fluid, long amount, boolean simulate, boolean notifyChanges) {
            if (amount <= 0 || EPFluidUtil.isDefaultFluid(fluid)) return 0;

            long drained = 0;
            for (int i = 0; i < getTanks(); i++) {
                drained += drain(i, fluid, amount, simulate, false);
                if (drained != 0) break;
            }
            if (notifyChanges && drained > 0 && !simulate) {
                onContentsChanged();
            }
            return drained;
        }

        @Override
        public long drain(int tank, Fluid fluid, long amount, boolean simulate, boolean notifyChanges) {
            return storages[tank].drain(fluid, amount, simulate, notifyChanges);
        }

        @Override
        public boolean supportsDrain(int tank) {
            return storages[tank].supportsDrain(tank);
        }

        @Override
        public void onContentsChanged() {
            ITankTrait.super.onContentsChanged();
            onChanged();
        }

        public boolean hasFluid(int tank) {
            return storages[tank].hasFluid();
        }

        @Override
        public ManagedFieldHolder getFieldHolder() {
            return MANAGED_FIELD_HOLDER;
        }
    }

    public static class TankStorage extends FluidStorage {

        @Getter
        @Setter
        private boolean isLocked;

        @Getter
        @Setter
        private boolean isVoiding;

        @Getter
        @Setter
        private boolean isSelected;

        public TankStorage(long capacity) {
            super(capacity);
        }

        public long fill(Fluid pFluid, long amount, boolean simulate, boolean notifyChange) {
            if (amount <= 0 || EPFluidUtil.isDefaultFluid(pFluid)) {
                return 0;
            }
            if (simulate) {
                if (fluid.isEmpty()) {
                    return Math.min(capacity, amount);
                }
                if (!fluid.getFluid().isSame(pFluid)) {
                    return 0;
                }
                return Math.min(capacity - fluid.getAmount(), amount);
            }
            if (fluid.isEmpty()) {
                fluid = FluidStack.create(pFluid, Math.min(capacity, amount));
                if (notifyChange) {
                    onContentsChanged();
                }
                return fluid.getAmount();
            }
            if (!fluid.getFluid().isSame(pFluid)) {
                return 0;
            }
            long filled = capacity - fluid.getAmount();

            if (amount < filled) {
                fluid.grow(amount);
                filled = amount;
            } else {
                fluid.setAmount(capacity);
            }
            if (filled > 0 && notifyChange) onContentsChanged();
            return filled;
        }

        public long drain(Fluid pFluid, long amount, boolean simulate, boolean notifyChange) {
            if (amount <= 0 || EPFluidUtil.isDefaultFluid(pFluid) || !fluid.getFluid().isSame(pFluid)) {
                return 0;
            }

            long drained = Math.min(fluid.getAmount(), amount);
            if (!simulate) {
                fluid.shrink(drained);
                if (notifyChange && drained > 0) {
                    onContentsChanged();
                }
            }

            return drained;
        }

        public boolean hasFluid() {
            return !fluid.isEmpty();
        }

        @Override
        public CompoundTag serializeNBT() {
            var tag = super.serializeNBT();
            tag.putBoolean("Locked", isLocked);
            tag.putBoolean("Voiding", isVoiding);
            tag.putBoolean("Selected", isSelected);
            return tag;
        }

        @Override
        public void deserializeNBT(CompoundTag nbt) {
            super.deserializeNBT(nbt);
            this.isLocked = nbt.getBoolean("Locked");
            this.isVoiding = nbt.getBoolean("Voiding");
            this.isSelected = nbt.getBoolean("Selected");
        }
    }
}
