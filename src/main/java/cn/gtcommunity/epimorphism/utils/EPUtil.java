package cn.gtcommunity.epimorphism.utils;

import com.lowdragmc.lowdraglib.misc.FluidTransferList;
import com.lowdragmc.lowdraglib.side.fluid.FluidStack;

import java.util.ArrayList;
import java.util.List;
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

}
