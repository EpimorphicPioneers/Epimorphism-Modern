package com.epimorphismmc.epimorphism.data.recipe.misc;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.epimorphismmc.epimorphism.common.data.EPRecipeTypes.*;
import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.common.data.GTBlocks.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

public class ConcreteBackfillerRecipes {

    public static void init(Consumer<FinishedRecipe> provider) {
        CONCRETE_BACKFILLER_RECIPES
                .recipeBuilder("concrete")
                .inputFluids(Concrete.getFluid(144))
                .outputItems(LIGHT_CONCRETE)
                .EUt(EV)
                .duration(20)
                .save(provider);
    }
}
