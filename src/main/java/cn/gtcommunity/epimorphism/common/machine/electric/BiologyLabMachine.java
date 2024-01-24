package cn.gtcommunity.epimorphism.common.machine.electric;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.TieredEnergyMachine;
import com.gregtechceu.gtceu.api.machine.feature.IAutoOutputItem;
import com.gregtechceu.gtceu.api.machine.feature.IFancyUIMachine;
import com.gregtechceu.gtceu.api.machine.feature.IMachineModifyDrops;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class BiologyLabMachine extends TieredEnergyMachine implements IAutoOutputItem, IFancyUIMachine, IMachineModifyDrops {
    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(BiologyLabMachine.class, TieredEnergyMachine.MANAGED_FIELD_HOLDER);

    public BiologyLabMachine(IMachineBlockEntity holder, int tier, Object... args) {
        super(holder, tier, args);
    }

    //////////////////////////////////////
    //*****     Initialization     *****//
    //////////////////////////////////////



    //////////////////////////////////////
    //*******     Auto Output    *******//
    //////////////////////////////////////

    @Override
    public boolean isAutoOutputItems() {
        return false;
    }

    @Override
    public void setAutoOutputItems(boolean b) {

    }

    @Override
    public boolean isAllowInputFromOutputSideItems() {
        return false;
    }

    @Override
    public void setAllowInputFromOutputSideItems(boolean b) {

    }

    @Override
    public @Nullable Direction getOutputFacingItems() {
        return null;
    }

    @Override
    public void setOutputFacingItems(@Nullable Direction direction) {

    }

    //////////////////////////////////////
    //**********     GUI     ***********//
    //////////////////////////////////////



    //////////////////////////////////////
    //*******       Data        ********//
    //////////////////////////////////////
    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    @Override
    public void onDrops(List<ItemStack> list, Player player) {

    }
}
