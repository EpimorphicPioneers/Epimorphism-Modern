package com.epimorphismmc.epimorphism.api.machine.trait;

import com.epimorphismmc.epimorphism.utils.EPFluidUtil;

import net.minecraft.world.level.material.Fluid;

import org.jetbrains.annotations.ApiStatus;

import javax.annotation.Nonnull;

public interface ITankTrait {

    int getTanks();

    @Nonnull
    Fluid getFluidInTank(int tank);

    long getFluidAmountInTank(int tank);

    long getTankCapacity(int tank);

    @ApiStatus.Internal
    long fill(int tank, Fluid fluid, long amount, boolean simulate, boolean notifyChanges);

    boolean supportsFill(int tank);

    @ApiStatus.Internal
    long drain(int tank, Fluid fluid, long amount, boolean simulate, boolean notifyChanges);

    boolean supportsDrain(int tank);

    default long fill(Fluid fluid, long amount, boolean simulate, boolean notifyChanges) {
        if (amount <= 0 || EPFluidUtil.isDefaultFluid(fluid)) return 0;
        long filled = 0;
        for (int i = 0; i < getTanks(); i++) {
            filled += fill(i, fluid, amount, simulate, false);
            if (filled == amount) break;
        }
        if (notifyChanges && filled > 0 && !simulate) {
            onContentsChanged();
        }
        return filled;
    }

    default long fill(Fluid fluid, long amount, boolean simulate) {
        return fill(fluid, amount, simulate, !simulate);
    }

    default long drain(Fluid fluid, long amount, boolean simulate, boolean notifyChanges) {
        if (amount <= 0 || EPFluidUtil.isDefaultFluid(fluid)) return 0;
        long drained = 0;
        for (int i = 0; i < getTanks(); i++) {
            drained += drain(i, fluid, amount, simulate, false);
            if (drained == amount) break;
        }
        if (notifyChanges && drained > 0 && !simulate) {
            onContentsChanged();
        }
        return drained;
    }

    default long drain(Fluid fluid, long amount, boolean simulate) {
        return drain(fluid, amount, simulate, !simulate);
    }

    default void onContentsChanged() {}
}
