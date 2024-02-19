package cn.gtcommunity.epimorphism.common.machine.multiblock.part;

import cn.gtcommunity.epimorphism.api.gui.EPGuiTextures;
import cn.gtcommunity.epimorphism.api.gui.widget.LockableSlotWidget;
import cn.gtcommunity.epimorphism.api.transfer.item.LockableItemStackTransfer;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.IMachineModifyDrops;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IWorkableMultiController;
import com.gregtechceu.gtceu.api.machine.multiblock.part.TieredPartMachine;
import com.gregtechceu.gtceu.api.machine.trait.NotifiableItemStackHandler;
import com.lowdragmc.lowdraglib.gui.widget.Widget;
import com.lowdragmc.lowdraglib.gui.widget.WidgetGroup;
import com.lowdragmc.lowdraglib.syncdata.annotation.DescSynced;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.annotation.RequireRerender;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class BallHatchMachine extends TieredPartMachine implements IMachineModifyDrops {

    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(BallHatchMachine.class, TieredPartMachine.MANAGED_FIELD_HOLDER);
    public static final int SIZE = 25;

    @Getter @Setter
    @Persisted @DescSynced @RequireRerender
    private boolean isWorking;

    @Getter
    @Persisted
    private final NotifiableItemStackHandler inventory;

    public BallHatchMachine(IMachineBlockEntity holder, Object... args) {
        super(holder, GTValues.IV);
        this.inventory = createInventoryItemHandler(args);
    }

    //////////////////////////////////////
    //*****     Initialization     *****//
    //////////////////////////////////////

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    protected NotifiableItemStackHandler createInventoryItemHandler(Object... args) {
        return new NotifiableItemStackHandler(this, SIZE, IO.BOTH, IO.BOTH, LockableItemStackTransfer::new);
    }

    //////////////////////////////////////
    //**********     GUI     ***********//
    //////////////////////////////////////

    @Override
    public Widget createUIWidget() {
        int rowSize = (int) Math.sqrt(SIZE);
        int colSize = rowSize;
        if (SIZE == 8) {
            rowSize = 4;
            colSize = 2;
        }
        var group = new WidgetGroup(0, 0, 18 * rowSize + 16, 18 * colSize + 16);
        var container = new WidgetGroup(4, 4, 18 * rowSize + 8, 18 * colSize + 8);
        var handler = (LockableItemStackTransfer) inventory.storage;
        int index = 0;
        for (int y = 0; y < colSize; y++) {
            for (int x = 0; x < rowSize; x++) {
                int slot = index;
                container.addWidget(new LockableSlotWidget(getInventory().storage, index++, 4 + x * 18, 4 + y * 18, () -> handler.isLock(slot), b -> handler.setLock(slot, b))
                        .setBackground(GuiTextures.SLOT, EPGuiTextures.BALL_OVERLAY));
            }
        }

        container.setBackground(GuiTextures.BACKGROUND_INVERSE);
        group.addWidget(container);

        return group;
    }

    //////////////////////////////////////
    //**********     Data     **********//
    //////////////////////////////////////

    @Override
    public void beforeWorking(IWorkableMultiController controller) {
        super.beforeWorking(controller);
        this.isWorking = true;
    }

    @Override
    public void afterWorking(IWorkableMultiController controller) {
        super.afterWorking(controller);
        this.isWorking = false;
    }

    @Override
    public void onDrops(List<ItemStack> list, Player player) {
        clearInventory(list, getInventory().storage);
    }
}
