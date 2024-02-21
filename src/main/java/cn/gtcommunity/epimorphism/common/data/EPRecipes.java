package cn.gtcommunity.epimorphism.common.data;

import cn.gtcommunity.epimorphism.data.recipe.generated.BouleRecipeHandler;
import cn.gtcommunity.epimorphism.data.recipe.generated.RadiationHatchRecipeHandler;
import cn.gtcommunity.epimorphism.data.recipe.generated.WrapItemRecipeHandler;
import cn.gtcommunity.epimorphism.data.recipe.misc.NeutronActivatorLoader;
import cn.gtcommunity.epimorphism.data.recipe.serialized.oreprocessing.NaquadahProcessing;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

public class EPRecipes {
    public static void recipeAddition(Consumer<FinishedRecipe> consumer) {
        NeutronActivatorLoader.init(consumer);
        WrapItemRecipeHandler.init(consumer);
        RadiationHatchRecipeHandler.init(consumer);
        BouleRecipeHandler.init(consumer);

        initOreProcessings(consumer);
    }

    private static void initOreProcessings(Consumer<FinishedRecipe> consumer) {
        NaquadahProcessing.init(consumer);
    }
}
