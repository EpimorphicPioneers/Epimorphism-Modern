package cn.gtcommunity.epimorphism.common.data;

import cn.gtcommunity.epimorphism.api.machine.feature.multiblock.stats.IParallelMachine;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiController;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.OverclockingLogic;
import net.minecraft.Util;
import net.minecraft.util.Tuple;

import javax.annotation.Nonnull;
import java.util.function.BiFunction;
import java.util.function.Function;

import static com.gregtechceu.gtceu.common.data.GTRecipeModifiers.*;

public class EPRecipeModifiers {

    public static final BiFunction<OverclockingLogic, Function<OverclockingLogic, BiFunction<MetaMachine, GTRecipe, GTRecipe>>, BiFunction<MetaMachine, GTRecipe, GTRecipe>> EP_PARALLEL = Util.memoize((overclockingLogic, function) -> ((machine, recipe) -> {
        var paralleledRecipe = EPParallel(machine, recipe, false);
        return function.apply(overclockingLogic).apply(machine, paralleledRecipe.getA());
    }));

    public static Tuple<GTRecipe, Integer> EPParallel(MetaMachine machine, @Nonnull GTRecipe recipe, boolean modifyDuration) {
        if (machine instanceof IMultiController controller && controller.isFormed()) {
            if (machine instanceof IParallelMachine parallelMachine) {
                return accurateParallel(machine, recipe, parallelMachine.getParallelNumber(), modifyDuration);
            }
        }
        return new Tuple<>(recipe, 1);
    }
}
