package com.epimorphismmc.epimorphism.common.data;

import com.epimorphismmc.epimorphism.api.event.GTRecipeEvent;
import com.epimorphismmc.epimorphism.data.recipe.circuits.OpticalCircuits;
import com.epimorphismmc.epimorphism.data.recipe.configurable.RecipeAddition;
import com.epimorphismmc.epimorphism.data.recipe.generated.BouleRecipeHandler;
import com.epimorphismmc.epimorphism.data.recipe.generated.ComponentAsslineRecipeHandler;
import com.epimorphismmc.epimorphism.data.recipe.generated.PartsRecipeHandler;
import com.epimorphismmc.epimorphism.data.recipe.generated.WrapItemRecipeHandler;
import com.epimorphismmc.epimorphism.data.recipe.misc.FuelRecipes;
import com.epimorphismmc.epimorphism.data.recipe.misc.LargeNaquadahReactorLoader;
import com.epimorphismmc.epimorphism.data.recipe.misc.RadiationHatchLoader;
import com.epimorphismmc.epimorphism.data.recipe.serialized.oreprocessing.NaquadahProcessing;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

public class EPRecipes {
    public static void init(Consumer<FinishedRecipe> provider) {
        RecipeAddition.init(provider);

        OpticalCircuits.init(provider);

        WrapItemRecipeHandler.init(provider);
        BouleRecipeHandler.init(provider);
        PartsRecipeHandler.init(provider);

        FuelRecipes.init(provider);

        LargeNaquadahReactorLoader.init(provider);
        RadiationHatchLoader.init(provider);

        initOreProcessings(provider);
        ComponentAsslineRecipeHandler.finish(provider);
    }

    public static void remove(GTRecipeEvent.RemoveRecipe event) {}

    private static void initOreProcessings(Consumer<FinishedRecipe> consumer) {
        NaquadahProcessing.init(consumer);
    }
}
