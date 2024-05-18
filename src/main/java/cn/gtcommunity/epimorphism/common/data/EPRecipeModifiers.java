package cn.gtcommunity.epimorphism.common.data;

import com.epimorphismmc.monomorphism.machine.feature.multiblock.stats.IParallelMachine;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiController;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.RecipeHelper;
import com.gregtechceu.gtceu.api.recipe.modifier.RecipeModifier;
import com.mojang.datafixers.util.Pair;

import javax.annotation.Nonnull;

import static com.gregtechceu.gtceu.common.data.GTRecipeModifiers.accurateParallel;

public class EPRecipeModifiers {

    public static final RecipeModifier EP_PARALLEL = (machine, recipe) -> EPParallel(machine, recipe, false).getFirst();

    public static Pair<GTRecipe, Integer> EPParallel(MetaMachine machine, @Nonnull GTRecipe recipe, boolean modifyDuration) {
        if (machine instanceof IMultiController controller && controller.isFormed()) {
            if (machine instanceof IParallelMachine parallelMachine) {
                int parallel = parallelMachine.getParallelNumber();
                if (machine instanceof WorkableElectricMultiblockMachine electricMachine) {
                    parallel = (int) Math.min(parallel, Math.max(electricMachine.getMaxVoltage() / RecipeHelper.getInputEUt(recipe), 1));
                }
                return accurateParallel(machine, recipe, parallel, modifyDuration);
            }
        }
        return new Pair<>(recipe, 1);
    }

}
