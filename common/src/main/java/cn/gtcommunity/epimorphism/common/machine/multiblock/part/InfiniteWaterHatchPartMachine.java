package cn.gtcommunity.epimorphism.common.machine.multiblock.part;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.TickableSubscription;
import com.gregtechceu.gtceu.api.machine.multiblock.part.TieredIOPartMachine;
import com.gregtechceu.gtceu.api.machine.trait.NotifiableFluidTank;
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
        super(holder, GTValues.UHV, IO.IN);
        this.tank = createTank();
    }

    //////////////////////////////////////
    //*****     Initialization    ******//
    //////////////////////////////////////
    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    protected NotifiableFluidTank createTank(Object... args) {
        return new NotifiableFluidTank(this, 1, Long.MAX_VALUE, io, IO.NONE);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        if (getLevel() instanceof ServerLevel serverLevel) {
            serverLevel.getServer().tell(new TickTask(0, this::updateTankSubscription));
        }
        tankSubs = tank.addChangedListener(this::updateTankSubscription);
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
        if (isWorkingEnabled() && tank.fillInternal(FluidStack.create(Fluids.WATER, 1L), true) != 0L) {
            productSubs = subscribeServerTick(productSubs, this::productWater);
        } else if (productSubs != null && !tank.isEmpty()) {
            productSubs.unsubscribe();
            productSubs = null;
        }
    }

    protected void productWater() {
        tank.fillInternal(FluidStack.create(Fluids.WATER, Long.MAX_VALUE), false);
    }

    @Override
    public void setWorkingEnabled(boolean workingEnabled) {
        super.setWorkingEnabled(workingEnabled);
        updateTankSubscription();
    }
}
