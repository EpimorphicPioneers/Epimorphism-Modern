package cn.gtcommunity.epimorphism.common.machine.multiblock.storage;

import cn.gtcommunity.epimorphism.api.fluid.TankFluidStack;
import cn.gtcommunity.epimorphism.api.gui.widget.FluidTankMapWidget;
import cn.gtcommunity.epimorphism.api.pattern.utils.containers.StorageFieldBlockContainer;
import cn.gtcommunity.epimorphism.api.structure.utils.IValueContainer;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.gui.fancy.ConfiguratorPanel;
import com.gregtechceu.gtceu.api.gui.fancy.IFancyUIProvider;
import com.gregtechceu.gtceu.api.gui.fancy.TooltipsPanel;
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
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TFFTMachine extends WorkableMultiblockMachine implements IFancyUIMachine, IDisplayUIMachine {
    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(TFFTMachine.class, WorkableMultiblockMachine.MANAGED_FIELD_HOLDER);

    @Persisted
    public final NotifiableItemStackHandler inventory;
    private TFFTMachine.TFFTFluidTank fluidTank;
    public TFFTMachine(IMachineBlockEntity holder) {
        super(holder);
        inventory = new NotifiableItemStackHandler(this, 1, IO.IN, IO.BOTH);
    }

    //////////////////////////////////////
    //***    Multiblock LifeCycle    ***//
    //////////////////////////////////////

    @Override
    public void onStructureFormed() {
        super.onStructureFormed();
        IValueContainer<?> container = getMultiblockState().getMatchContext().getOrCreate("StorageFieldBlockValue", IValueContainer::noop);

        // get the capacity and initialize the tank
        if (container instanceof StorageFieldBlockContainer blockContainer) {
            if (this.fluidTank == null) {
                this.fluidTank = new TFFTMachine.TFFTFluidTank(this, blockContainer.getValue(), blockContainer.getBlockNumber());
            } else {
                this.fluidTank = fluidTank.rebuild(blockContainer.getValue(), blockContainer.getBlockNumber());
            }
        }
    }

    @Override
    public void onStructureInvalid() {
        super.onStructureInvalid();
    }

    //////////////////////////////////////
    //***        Multiblock UI       ***//
    //////////////////////////////////////

    @Override
    public Widget createUIWidget() {
        var group = new WidgetGroup(0, 0, 170 + 8, 129 + 8);
        var container = new WidgetGroup(4, 4, 170, 129);
        container.addWidget(new DraggableScrollableWidgetGroup(4, 4, 162, 121).setBackground(getScreenTexture())
                .addWidget(new LabelWidget(4, 5, self().getBlockState().getBlock().getDescriptionId()))
                .addWidget(new ComponentPanelWidget(4, 17, this::addDisplayText)
                        .setMaxWidthLimit(150)
                        .clickHandler(this::handleDisplayClick)));
        container.setBackground(GuiTextures.BACKGROUND_INVERSE);
        group.addWidget(container);
        return group;
    }

    @Override
    public ModularUI createUI(Player entityPlayer) {
        return IFancyUIMachine.super.createUI(entityPlayer);
    }

    @Override
    public List<IFancyUIProvider> getSubTabs() {
        List<IFancyUIProvider> list = new ArrayList<>();

        list.add(new IFancyUIProvider() {
            @Override
            public Widget createMainPage() {
                var group = new WidgetGroup(0, 0, 170 + 8, 129 + 8);

                var slotContainer = new WidgetGroup(4, 4, 18 + 8, 18 + 8);
                slotContainer.addWidget(new SlotWidget(inventory.storage, 0, 4, 4, true, true)
                        .setBackground(GuiTextures.SLOT));
                slotContainer.setBackground(GuiTextures.BACKGROUND_INVERSE);

                group.addWidget(slotContainer);
                group.addWidget(new FluidTankMapWidget(2, 2, 170, 129));

                return group;
            }

            @Override
            public IGuiTexture getTabIcon() {
                return TFFTMachine.this.getTabIcon();
            }

            @Override
            public void attachConfigurators(ConfiguratorPanel configuratorPanel) {

            }

            @Override
            public void attachTooltips(TooltipsPanel tooltipsPanel) {

            }
        });

        list.addAll(getParts().stream().filter(IFancyUIProvider.class::isInstance).map(IFancyUIProvider.class::cast).toList());
        return list;
    }

    @Override
    public void attachTooltips(TooltipsPanel tooltipsPanel) {
        for (IMultiPart part : getParts()) {
            part.attachFancyTooltipsToController(this, tooltipsPanel);
        }
    }

    @Override
    public void addDisplayText(List<Component> textList) {

    }

    //////////////////////////////////////
    //***       Multiblock Data      ***//
    //////////////////////////////////////

    @Override
    public @NotNull ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    @Override
    public void loadCustomPersistedData(@NotNull CompoundTag tag) {
        super.loadCustomPersistedData(tag);
        fluidTank.readFromNBT(tag.getCompound("TFFT"));
    }

    @Override
    public void saveCustomPersistedData(@NotNull CompoundTag tag, boolean forDrop) {
        super.saveCustomPersistedData(tag, forDrop);
        CompoundTag tankTag = fluidTank.writeToNBT(new CompoundTag());
        tag.put("TFFT", tankTag);
    }

    //////////////////////////////////////
    //***  Multiblock Subscriptions  ***//
    //////////////////////////////////////


    //////////////////////////////////////
    //***      Multiblock Traits     ***//
    //////////////////////////////////////

    public static class TFFTFluidTank extends MachineTrait {

        private static final String NBT_SIZE = "TFFT_Size";

        private TankFluidStack[] tankFluidStacks;

        protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(TFFTMachine.TFFTFluidTank.class);

        public TFFTFluidTank(MetaMachine machine, BigInteger capacity, int tanks) {
            super(machine);
            tankFluidStacks = new TankFluidStack[tanks];
        }

        public void readFromNBT(CompoundTag storageTag) {
            tankFluidStacks = new TankFluidStack[storageTag.getInt(NBT_SIZE)];
            for (int i = 0; i < tankFluidStacks.length; i++) {
                var tag = storageTag.getCompound("Tank_%s".formatted(i));
                if (!tag.isEmpty()) {
                    tankFluidStacks[i] = TankFluidStack.loadFromTag(tag);
                }
            }
        }

        public CompoundTag writeToNBT(CompoundTag compound) {
            compound.putInt(NBT_SIZE, tankFluidStacks.length);
            for (int i = 0; i < tankFluidStacks.length; i++) {
                var tank = tankFluidStacks[i];
                var tag = new CompoundTag();
                tank.saveToTag(tag);
                compound.put("Tank_%s".formatted(i), tag);
            }
            return compound;
        }

        public TFFTFluidTank rebuild(@NotNull BigInteger capacity, int tanks) {
            var tank = new TFFTFluidTank(this.machine, capacity, tanks);
            var stacks = Arrays.copyOf(tankFluidStacks, tanks);
            var tankCapacity = capacity.divide(BigInteger.valueOf(tanks));
            for (var stack : stacks) {
                stack.rebuild(tankCapacity);
            }
            tank.tankFluidStacks = stacks;
            return tank;
        }

        @Override
        public ManagedFieldHolder getFieldHolder() {
            return MANAGED_FIELD_HOLDER;
        }
    }
}
