package com.epimorphismmc.epimorphism.common.machine.generator;

import com.epimorphismmc.epimorphism.api.gui.EPGuiTextures;
import com.epimorphismmc.epimorphism.api.gui.widget.DisabledSlotWidget;
import com.epimorphismmc.epimorphism.api.item.component.IReactorComponent;
import com.epimorphismmc.epimorphism.api.transfer.item.LockableItemStackTransfer;
import com.epimorphismmc.epimorphism.common.data.EPMachines;

import com.gregtechceu.gtceu.api.capability.IWorkable;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.feature.IFancyUIMachine;
import com.gregtechceu.gtceu.api.machine.feature.IMachineLife;
import com.gregtechceu.gtceu.api.machine.feature.IMachineModifyDrops;
import com.gregtechceu.gtceu.api.machine.trait.NotifiableItemStackHandler;

import com.lowdragmc.lowdraglib.gui.widget.ImageWidget;
import com.lowdragmc.lowdraglib.gui.widget.LabelWidget;
import com.lowdragmc.lowdraglib.gui.widget.ProgressWidget;
import com.lowdragmc.lowdraglib.gui.widget.Widget;
import com.lowdragmc.lowdraglib.gui.widget.WidgetGroup;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.server.TickTask;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.BlockHitResult;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class NuclearReactorMachine extends MetaMachine
        implements IFancyUIMachine, IMachineLife, IWorkable, IMachineModifyDrops {
    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER =
            new ManagedFieldHolder(NuclearReactorMachine.class, MetaMachine.MANAGED_FIELD_HOLDER);

    @Getter
    @Persisted
    private final NotifiableItemStackHandler inventory = this.createInventoryItemHandler();

    private int chambers;

    @Getter
    @Persisted
    private int heat;

    @Getter
    @Persisted
    private int maxHeat = 1;

    public NuclearReactorMachine(IMachineBlockEntity holder) {
        super(holder);

        for (int i = 3; i < 9; ++i) {
            this.getStorage().disableColumn(i, true);
        }
    }

    protected NotifiableItemStackHandler createInventoryItemHandler() {
        return new NotifiableItemStackHandler(
                this, 54, IO.BOTH, IO.BOTH, ReactorItemStackTransfer::new);
    }

    public boolean shouldOpenUI(Player player, InteractionHand hand, BlockHitResult hit) {
        return !player.getMainHandItem().is(EPMachines.REACTOR_CHAMBER.getItem())
                && IFancyUIMachine.super.shouldOpenUI(player, hand, hit);
    }

    public Widget createUIWidget() {
        int rowSize = 9;
        int colSize = 6;
        WidgetGroup group = new WidgetGroup(0, 0, 18 * rowSize + 16, 18 * colSize + 39);
        WidgetGroup slotContainer = new WidgetGroup(4, 4, 18 * rowSize + 8, 18 * colSize + 8);
        ReactorItemStackTransfer handler = this.getStorage();
        int index = 0;

        for (int y = 0; y < colSize; ++y) {
            for (int x = 0; x < rowSize; ++x) {
                int slot = index;
                slotContainer.addWidget((new DisabledSlotWidget(
                                this.getInventory().storage,
                                index++,
                                4 + x * 18,
                                4 + y * 18,
                                () -> handler.isLock(slot),
                                b -> handler.setLock(slot, b)))
                        .setBackground(GuiTextures.SLOT));
            }
        }
        slotContainer.setBackground(GuiTextures.BACKGROUND_INVERSE);

        var barContainer = new WidgetGroup(4, 18 * colSize + 14, 18 * rowSize + 8, 20);
        barContainer.addWidget(
                new ImageWidget(0, 0, 18 * rowSize + 8, 10, EPGuiTextures.BAR_CONTAINER) {
                    @Override
                    public void updateScreen() {
                        super.updateScreen();
                        setHoverTooltips("aaa");
                    }
                });
        var reactorHeat = new ProgressWidget(
                () -> (double) heat / maxHeat, 3, 3, 164, 4, EPGuiTextures.PROGRESS_BAR_REACTOR_HEAT);
        barContainer.addWidget(reactorHeat);

        var textContainer = new WidgetGroup(4, 18 * colSize + 26, 18 * rowSize + 8, 20);
        textContainer.addWidget(new ImageWidget(4, 4, 18 * rowSize, 12, GuiTextures.DISPLAY));
        textContainer.addWidget(new LabelWidget(6, 7, "EU Output: 360 EU/t"));
        textContainer.setBackground(GuiTextures.BACKGROUND_INVERSE);

        group.addWidget(slotContainer);
        group.addWidget(barContainer);
        group.addWidget(textContainer);
        return group;
    }

    public void onLoad() {
        super.onLoad();
        if (this.getLevel() instanceof ServerLevel serverLevel) {
            serverLevel.getServer().tell(new TickTask(0, () -> this.searchChamber(this)));
        }
    }

    public void onMachinePlaced(@Nullable LivingEntity player, ItemStack stack) {
        IMachineLife.super.onMachinePlaced(player, stack);
        this.searchChamber(this);
    }

    public void onMachineRemoved() {
        IMachineLife.super.onMachineRemoved();
        this.searchChamber(null);
    }

    public void onNeighborChanged(Block block, BlockPos fromPos, boolean isMoving) {
        super.onNeighborChanged(block, fromPos, isMoving);
        this.searchChamber(this);
    }

    private void searchChamber(@Nullable NuclearReactorMachine nuclearReactor) {
        BlockPos pos = this.getPos();
        if (this.getLevel() instanceof ServerLevel serverLevel) {
            int num = 0;
            BlockPos[] neighbours =
                    new BlockPos[] {pos.above(), pos.below(), pos.east(), pos.south(), pos.west(), pos.north()
                    };
            for (BlockPos neighbour : neighbours) {
                if (getMachine(serverLevel, neighbour) instanceof ReactorChamberMachine chamber) {
                    chamber.setNuclearReactor(nuclearReactor);
                    ++num;
                }
            }

            if (nuclearReactor != null && this.chambers != num) {
                int i;
                if (this.chambers > num) {
                    for (i = 3 + num; i < this.chambers + 3; ++i) {
                        this.getStorage().disableColumn(i, true);
                    }
                } else {
                    for (i = 3 + this.chambers; i < num + 3; ++i) {
                        this.getStorage().disableColumn(i, false);
                    }
                }
                this.chambers = num;
            }
        }
    }

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    private ReactorItemStackTransfer getStorage() {
        return (ReactorItemStackTransfer) this.inventory.storage;
    }

    @Override
    public int getProgress() {
        return 0;
    }

    @Override
    public int getMaxProgress() {
        return 0;
    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public boolean isWorkingEnabled() {
        return false;
    }

    @Override
    public void setWorkingEnabled(boolean b) {}

    @Override
    public void onDrops(List<ItemStack> drops, Player entity) {
        clearInventory(drops, getStorage());
    }

    public static class ReactorContext {

        private final NuclearReactorMachine reactor;

        @Getter
        private int row, column;

        public ReactorContext(NuclearReactorMachine reactor) {
            this.reactor = reactor;
        }

        protected void setPosition(int row, int column) {
            this.row = row;
            this.column = column;
        }

        @Nullable public IReactorComponent getComponent(int row, int column) {
            return IReactorComponent.getBehaviour(reactor.getStorage().getStackIn(row, column));
        }

        public ItemStack getComponentItem(int row, int column) {
            return reactor.getStorage().getStackIn(row, column);
        }

        public void setComponentItem(int row, int column, ItemStack stack) {
            if (row >= 0 && row < 6 && column >= 0 && column < 9) {
                reactor.getStorage().setStackInSlot(row * 9 + column, stack);
            }
        }

        public int getHeat() {
            return reactor.getHeat();
        }

        public int getMaxHeat() {
            return reactor.getHeat();
        }

        public boolean isFluid() {
            return false;
        }
    }

    private class ReactorItemStackTransfer extends LockableItemStackTransfer {
        public ReactorItemStackTransfer(int size) {
            super(size);
        }

        @Override
        public int getSlotLimit(int slot) {
            return 1;
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            return IReactorComponent.getBehaviour(stack) != null && super.isItemValid(slot, stack);
        }

        public ItemStack getStackIn(int row, int column) {
            return row >= 0 && row < 6 && column >= 0 && column < 9
                    ? this.getStackInSlot(row * 9 + column)
                    : ItemStack.EMPTY;
        }

        public List<ItemStack> getStackInColumn(int column) {
            if (column >= 0 && column < 9) {
                List<ItemStack> list = new ArrayList<>();

                for (int i = 0; i < 6; ++i) {
                    list.add(this.getStackInSlot(i * 9 + column));
                }

                return list;
            } else {
                return Collections.emptyList();
            }
        }

        public List<ItemStack> getStackInRow(int row) {
            if (row >= 0 && row < 6) {
                List<ItemStack> list = new ArrayList<>();

                for (int i = 0; i < 9; ++i) {
                    list.add(this.getStackInSlot(row * 9 + i));
                }

                return list;
            } else {
                return Collections.emptyList();
            }
        }

        public void disableColumn(int column, boolean disable) {
            if (column >= 0 && column < 9) {
                for (int i = 0; i < 6; ++i) {
                    if (disable) {
                        ItemStack stackInSlot = this.getStackInSlot(i * 9 + column);
                        //                        if (!stackInSlot.m_41619_()) {
                        //                            inventory.setStackInSlot(i, ItemStack.f_41583_);
                        //                            inventory.onContentsChanged();
                        //                            itemBuffer.add(stackInSlot);
                        //                        }
                    }
                    this.setLock(i * 9 + column, disable);
                }
            }
        }
    }
}
