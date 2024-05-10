package cn.gtcommunity.epimorphism.common.machine.multiblock.part;

import cn.gtcommunity.epimorphism.utils.EPLangUtil;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.TickableSubscription;
import com.gregtechceu.gtceu.api.machine.multiblock.part.TieredIOPartMachine;
import com.gregtechceu.gtceu.api.machine.trait.NotifiableFluidTank;
import com.lowdragmc.lowdraglib.gui.widget.*;
import com.lowdragmc.lowdraglib.side.fluid.FluidStack;
import com.lowdragmc.lowdraglib.syncdata.ISubscription;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.server.TickTask;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.material.Fluids;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class InfiniteWaterHatchPartMachine extends TieredIOPartMachine {
    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(InfiniteWaterHatchPartMachine.class, TieredIOPartMachine.MANAGED_FIELD_HOLDER);
    @Nullable
    protected TickableSubscription productSubs;
    @Nullable
    protected ISubscription tankSubs;

    @Persisted
    public final NotifiableFluidTank tank;

    public InfiniteWaterHatchPartMachine(IMachineBlockEntity holder) {
        super(holder, GTValues.IV, IO.IN);
        this.tank = createTank();
        this.tankSubs = tank.addChangedListener(this::updateTankSubscription);
    }

    //////////////////////////////////////
    //*****     Initialization    ******//
    //////////////////////////////////////

    protected NotifiableFluidTank createTank(Object... args) {
        return new NotifiableFluidTank(this, 1, Long.MAX_VALUE, io, IO.NONE);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        if (getLevel() instanceof ServerLevel serverLevel) {
            serverLevel.getServer().tell(new TickTask(0, this::updateTankSubscription));
        }
    }

    @Override
    public void onUnload() {
        super.onUnload();
        if (tankSubs != null) {
            tankSubs.unsubscribe();
            tankSubs = null;
        }
    }

    //////////////////////////////////////
    //******    Product Water    *******//
    //////////////////////////////////////

    protected void updateTankSubscription() {
        if (isWorkingEnabled()) {
            productSubs = subscribeServerTick(productSubs, this::productWater);
        } else unsubscribe();
    }

    protected void productWater() {
        boolean isFilled = tank.fillInternal(FluidStack.create(Fluids.WATER, Long.MAX_VALUE), false) == 0;

        if (isFilled) unsubscribe();
        else updateTankSubscription();
    }

    private void unsubscribe() {
        if (productSubs != null) {
            productSubs.unsubscribe();
            productSubs = null;
        }
    }

    //////////////////////////////////////
    //**********     GUI     ***********//
    //////////////////////////////////////

    @Override
    public Widget createUIWidget() {
        var group = new WidgetGroup(0, 0, 89, 63);

        group.addWidget(new ImageWidget(4, 4, 81, 55, GuiTextures.DISPLAY))
                .addWidget(new LabelWidget(8, 8, "gtceu.gui.fluid_amount"))
                .addWidget(new LabelWidget(8, 18, () -> EPLangUtil.abbreviate(tank.getFluidInTank(0).getAmount()) + " mB").setTextColor(-1).setDropShadow(true))
                .addWidget(new TankWidget(tank.getStorages()[0], 67, 22, false, false).setBackground(GuiTextures.FLUID_SLOT));

        group.setBackground(GuiTextures.BACKGROUND_INVERSE);
        return group;
    }

    //////////////////////////////////////
    //**********     Data     **********//
    //////////////////////////////////////

    @Override
    public void setWorkingEnabled(boolean workingEnabled) {
        super.setWorkingEnabled(workingEnabled);
        updateTankSubscription();
    }

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

}
