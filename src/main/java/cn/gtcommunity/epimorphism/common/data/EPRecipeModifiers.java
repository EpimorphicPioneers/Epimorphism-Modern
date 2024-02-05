package cn.gtcommunity.epimorphism.common.data;

import cn.gtcommunity.epimorphism.api.machine.feature.stats.IParallelMachine;
import cn.gtcommunity.epimorphism.api.machine.multiblock.ParallelCoilMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiController;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.OverclockingLogic;
import com.gregtechceu.gtceu.api.recipe.RecipeHelper;
import lombok.val;
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

    public static GTRecipe advEBFOverclock(MetaMachine machine, @Nonnull GTRecipe recipe) {
        if (machine instanceof ParallelCoilMultiblockMachine coilMachine) {
            val blastFurnaceTemperature = coilMachine.getCoilType().getCoilTemperature();
            if (!recipe.data.contains("ebf_temp") || recipe.data.getInt("ebf_temp") > blastFurnaceTemperature) {
                return null;
            }
            if (RecipeHelper.getRecipeEUtTier(recipe) > coilMachine.getTier()) {
                return null;
            }
            return RecipeHelper.applyOverclock(new OverclockingLogic((recipe1, recipeEUt, maxVoltage, duration, amountOC) -> {
                var pair = OverclockingLogic.heatingCoilOverclockingLogic(
                        Math.abs(recipeEUt),
                        maxVoltage,
                        duration,
                        amountOC,
                        blastFurnaceTemperature,
                        recipe.data.contains("ebf_temp") ? recipe.data.getInt("ebf_temp") : 0);
                var eu = pair.firstLong() * 0.9;
                var dur = pair.secondInt() * 0.45;
                pair.first((long) Math.max(1, eu)).second((int) Math.max(1, dur));
                return pair;
            }), recipe, coilMachine.getMaxVoltage());
        }
        return null;
    }
}
