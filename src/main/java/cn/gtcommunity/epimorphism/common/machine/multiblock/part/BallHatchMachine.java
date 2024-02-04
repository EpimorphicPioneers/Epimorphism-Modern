package cn.gtcommunity.epimorphism.common.machine.multiblock.part;

import cn.gtcommunity.epimorphism.api.gui.EPGuiTextures;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.IMachineModifyDrops;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiController;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IWorkableMultiController;
import com.gregtechceu.gtceu.api.machine.multiblock.part.TieredPartMachine;
import com.gregtechceu.gtceu.api.machine.trait.NotifiableItemStackHandler;
import com.gregtechceu.gtceu.api.syncdata.RequireRerender;
import com.lowdragmc.lowdraglib.gui.widget.SlotWidget;
import com.lowdragmc.lowdraglib.gui.widget.Widget;
import com.lowdragmc.lowdraglib.gui.widget.WidgetGroup;
import com.lowdragmc.lowdraglib.syncdata.annotation.DescSynced;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
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

    @Getter @Setter
    @Persisted @DescSynced @RequireRerender
    private boolean isWorking;

    @Getter @Setter
    @Persisted @DescSynced @RequireRerender
    private boolean isForm;

    @Persisted
    public final NotifiableItemStackHandler inventory;

    public BallHatchMachine(IMachineBlockEntity holder) {
        super(holder, GTValues.IV);
        this.inventory = new NotifiableItemStackHandler(this, 1, IO.NONE, IO.BOTH);
    }

    //////////////////////////////////////
    //*****     Initialization    ******//
    //////////////////////////////////////

    @Override
    public void addedToController(IMultiController controller) {
        super.addedToController(controller);
        this.isForm = true;
    }

    @Override
    public void removedFromController(IMultiController controller) {
        super.removedFromController(controller);
        this.isForm = false;
    }



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

    //////////////////////////////////////
    //**********     GUI     ***********//
    //////////////////////////////////////
    @Override
    public Widget createUIWidget() {
        var group = new WidgetGroup(0, 0, 18 + 16, 18 + 16);
        var container = new WidgetGroup(4, 4, 18 + 8, 18 + 8);
        container.addWidget(new SlotWidget(inventory.storage, 0, 4, 4, true, true)
                .setBackground(GuiTextures.SLOT, EPGuiTextures.BALL_OVERLAY));
        container.setBackground(GuiTextures.BACKGROUND_INVERSE);
        group.addWidget(container);
        return group;
    }

    //////////////////////////////////////
    //**********     Data     **********//
    //////////////////////////////////////

    @Override
    public void onDrops(List<ItemStack> list, Player player) {
        clearInventory(list, inventory.storage);
    }

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }
}
