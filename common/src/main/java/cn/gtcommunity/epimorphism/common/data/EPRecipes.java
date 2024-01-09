package cn.gtcommunity.epimorphism.common.data;

import cn.gtcommunity.epimorphism.data.recipe.generated.WrapItemRecipeHandler;
import cn.gtcommunity.epimorphism.data.recipe.misc.NeutronActivatorLoader;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

public class EPRecipes {
    public static void recipeAddition(Consumer<FinishedRecipe> consumer) {
        NeutronActivatorLoader.init(consumer);
        WrapItemRecipeHandler.init(consumer);
    }
}
