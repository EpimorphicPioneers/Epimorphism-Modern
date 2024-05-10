package cn.gtcommunity.epimorphism.common.machine.multiblock.part;

import cn.gtcommunity.epimorphism.api.machine.feature.multiblock.IReinforcedRotorHolder;
import cn.gtcommunity.epimorphism.common.machine.multiblock.generator.MegaTurbineMachine;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.feature.IMachineModifyDrops;
import com.gregtechceu.gtceu.api.machine.multiblock.part.TieredPartMachine;
import com.gregtechceu.gtceu.api.machine.trait.NotifiableItemStackHandler;
import com.gregtechceu.gtceu.common.item.TurbineRotorBehaviour;
import com.lowdragmc.lowdraglib.gui.widget.SlotWidget;
import com.lowdragmc.lowdraglib.gui.widget.Widget;
import com.lowdragmc.lowdraglib.gui.widget.WidgetGroup;
import com.lowdragmc.lowdraglib.syncdata.ISubscription;
import com.lowdragmc.lowdraglib.syncdata.annotation.DescSynced;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.annotation.RequireRerender;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import lombok.Setter;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.Set;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ReinforcedRotorHolderPartMachine extends TieredPartMachine implements IMachineModifyDrops, IReinforcedRotorHolder {

    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(ReinforcedRotorHolderPartMachine.class, TieredPartMachine.MANAGED_FIELD_HOLDER);

    @Persisted
    public final NotifiableItemStackHandler inventory;
    @Setter
    @Persisted @DescSynced @RequireRerender
    public int rotorColor; // 0 - no rotor
    @Nullable
    protected ISubscription rotorInvSubs;
    @Nullable
    protected ISubscription controllerChangedSubs;
    @Nullable
    protected ISubscription speedChangedSubs;

    public ReinforcedRotorHolderPartMachine(IMachineBlockEntity holder, int tier) {
        super(holder, tier);
        this.inventory = new NotifiableItemStackHandler(this, 1, IO.NONE, IO.BOTH);
    }

    //////////////////////////////////////
    //*****     Initialization    ******//
    //////////////////////////////////////

    @Override
    public void onLoad() {
        super.onLoad();
        if (!isRemote()) {
            rotorInvSubs = this.inventory.addChangedListener(this::onRotorInventoryChanged);
        } else {
            controllerChangedSubs = addSyncUpdateListener("controllerPositions", this::onControllerChanged);
        }
    }

    @Override
    public void onUnload() {
        super.onUnload();
        if (rotorInvSubs != null) {
            rotorInvSubs.unsubscribe();
        }
        if (controllerChangedSubs != null) {
            controllerChangedSubs.unsubscribe();
        }
    }

    //////////////////////////////////////
    //******     Rotor Holder     ******//
    //////////////////////////////////////

    private void onRotorInventoryChanged() {
        var stack = getRotorStack();
        var rotorBehaviour = TurbineRotorBehaviour.getBehaviour(stack);
        var color = 0;
        if (rotorBehaviour != null) {
            color = rotorBehaviour.getPartMaterial(stack).getMaterialARGB();
        }
        this.rotorColor = color;
    }

    @Override
    public boolean hasRotor() {
        return rotorColor != 0;
    }

    @Override
    public ItemStack getRotorStack() {
        return inventory.getStackInSlot(0);
    }

    @Override
    public void setRotorStack(ItemStack rotorStack) {
        inventory.setStackInSlot(0, rotorStack);
        inventory.onContentsChanged();
    }

    @Override
    public MegaTurbineMachine getTurbine() {
        for (var blockPos : controllerPositions) {
            if (MetaMachine.getMachine(getLevel(), blockPos) instanceof MegaTurbineMachine turbine) {
                return turbine;
            }
        }
        return null;
    }

    //////////////////////////////////////
    //**********     GUI     ***********//
    //////////////////////////////////////
    @Override
    public Widget createUIWidget() {
        var group = new WidgetGroup(0, 0, 18 + 16, 18 + 16);
        var container = new WidgetGroup(4, 4, 18 + 8, 18 + 8);
        container.addWidget(new SlotWidget(inventory.storage, 0, 4, 4, true, true)
                .setBackground(GuiTextures.SLOT, GuiTextures.TURBINE_OVERLAY));
        container.setBackground(GuiTextures.BACKGROUND_INVERSE);
        group.addWidget(container);
        return group;
    }

    //////////////////////////////////////
    //**********     Data     **********//
    //////////////////////////////////////

    @Override
    @OnlyIn(Dist.CLIENT)
    public int tintColor(int index) {
        if (index == 2) {
            return rotorColor;
        }
        return super.tintColor(index);
    }

    @Override
    public boolean canShared() {
        return false;
    }

    @Override
    public void onDrops(List<ItemStack> drops, Player entity) {
        clearInventory(drops, inventory.storage);
    }

    void onControllerChanged(String changedField, Set<BlockPos> newValue, Set<BlockPos> oldValue) {
        if (changedField.equals("controllerPositions")) {
            if (speedChangedSubs != null) {
                speedChangedSubs.unsubscribe();
            }
            for (var blockPos : newValue) {
                if (MetaMachine.getMachine(getLevel(), blockPos) instanceof MegaTurbineMachine turbine) {
                    speedChangedSubs = turbine.addSyncUpdateListener("rotorSpeed", this::scheduleRender);
                }
            }
        }
    }

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }
}
