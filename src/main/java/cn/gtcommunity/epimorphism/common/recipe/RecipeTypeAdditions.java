package cn.gtcommunity.epimorphism.common.recipe;

import cn.gtcommunity.epimorphism.data.recipe.generated.ComponentAssemblyLineRecipeHandler;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;

public class RecipeTypeAdditions {
    public static void init() {
        GTRecipeTypes.ASSEMBLY_LINE_RECIPES.onRecipeBuild(ComponentAssemblyLineRecipeHandler::init);
        GTRecipeTypes.ASSEMBLER_RECIPES.onRecipeBuild(ComponentAssemblyLineRecipeHandler::init);
    }
}
