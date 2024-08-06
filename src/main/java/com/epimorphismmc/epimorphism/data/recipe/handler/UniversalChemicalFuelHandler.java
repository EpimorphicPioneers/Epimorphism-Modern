package com.epimorphismmc.epimorphism.data.recipe.handler;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.data.recipe.builder.GTRecipeBuilder;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.epimorphismmc.epimorphism.common.data.EPRecipeTypes.*;

/**
 * 通用化学燃料相关配方
 */
public class UniversalChemicalFuelHandler {

    public static void init(GTRecipeBuilder recipeBuilder, Consumer<FinishedRecipe> provider) {
        var builder = recipeBuilder.copy(GTCEu.id("ucf_" + recipeBuilder.id.getPath()));
        builder.addData("efficiency_factor", getFactor(builder));
        builder.recipeType = UNIVERSAL_CHEMICAL_FUELS;
        builder.onSave = null;
        builder.save(provider);
    }

    private static float getFactor(GTRecipeBuilder recipeBuilder) {
        var recipeType = recipeBuilder.recipeType;
        if (recipeType == ROCKET_ENGINE_FUELS) {
            return 0.005f;
        } else {
            return 0.04f;
        }
    }
}
