package com.epimorphismmc.epimorphism.common.data;

import com.epimorphismmc.monomorphism.machine.feature.multiblock.stats.IParallelMachine;

import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiController;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.OverclockingLogic;
import com.gregtechceu.gtceu.api.recipe.RecipeHelper;
import com.gregtechceu.gtceu.api.recipe.modifier.RecipeModifier;
import com.gregtechceu.gtceu.common.data.GTRecipeModifiers;

import com.mojang.datafixers.util.Pair;

import javax.annotation.Nonnull;

import static com.gregtechceu.gtceu.common.data.GTRecipeModifiers.accurateParallel;

public class EPRecipeModifiers {

    public static final RecipeModifier EP_PARALLEL =
            (machine, recipe) -> EPParallel(machine, recipe, false).getFirst();

    public static final RecipeModifier NON_PERFECT_OC =
            GTRecipeModifiers.ELECTRIC_OVERCLOCK.apply(OverclockingLogic.NON_PERFECT_OVERCLOCK);

    public static final RecipeModifier PERFECT_OC =
            GTRecipeModifiers.ELECTRIC_OVERCLOCK.apply(OverclockingLogic.PERFECT_OVERCLOCK);

    public static Pair<GTRecipe, Integer> EPParallel(
            MetaMachine machine, @Nonnull GTRecipe recipe, boolean modifyDuration) {
        if (machine instanceof IMultiController controller && controller.isFormed()) {
            if (machine instanceof IParallelMachine parallelMachine) {
                int parallel = parallelMachine.getParallelNumber();
                if (machine instanceof WorkableElectricMultiblockMachine electricMachine) {
                    parallel = (int) Math.min(
                            parallel,
                            Math.max(electricMachine.getMaxVoltage() / RecipeHelper.getInputEUt(recipe), 1));
                }
                return accurateParallel(machine, recipe, parallel, modifyDuration);
            }
        }
        return new Pair<>(recipe, 1);
    }

    public static RecipeModifier factor(float durFactor, float eutFactor) {
        return (machine, recipe) -> {
            var newRecipe = recipe.copy();
            int newDuration = Math.round(recipe.duration * durFactor);
            long newEUt = Math.round(RecipeHelper.getInputEUt(recipe) * eutFactor);
            newRecipe.duration = Math.max(newDuration, 1);
            RecipeHelper.setInputEUt(newRecipe, Math.max(newEUt, 1));
            return newRecipe;
        };
    }
}
