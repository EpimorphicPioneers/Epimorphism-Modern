package com.epimorphismmc.epimorphism.utils;

import com.lowdragmc.lowdraglib.misc.FluidTransferList;
import com.lowdragmc.lowdraglib.side.fluid.FluidStack;

import net.minecraft.world.level.Level;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class EPUtil {

    /**
     * The returned List is immutable.
     */
    public static List<FluidStack> fluidHandlerToList(FluidTransferList fluidTransferList) {
        List<FluidStack> list = new ArrayList<>();
        for (int i = 0; i < fluidTransferList.getTanks(); i++) {
            list.add(fluidTransferList.getFluidInTank(i));
        }
        return list.stream().filter(Predicate.not(FluidStack::isEmpty)).toList();
    }

    /**
     * @param world the {@link Level} to get the average tick time of
     * @return the mean tick time
     */
    public static double getMeanTickTime(@NotNull Level world) {
        return EPMath.mean(Objects.requireNonNull(world.getServer()).tickTimes) * 1.0E-6D;
    }
}
