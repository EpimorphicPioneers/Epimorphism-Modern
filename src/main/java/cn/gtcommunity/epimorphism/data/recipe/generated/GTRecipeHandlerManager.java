package cn.gtcommunity.epimorphism.data.recipe.generated;

import cn.gtcommunity.epimorphism.api.event.GTRecipeEvent;

import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.ASSEMBLER_RECIPES;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.ASSEMBLY_LINE_RECIPES;

public class GTRecipeHandlerManager {
    public static void register(GTRecipeEvent.RegisterHandler event) {
        event.register(ASSEMBLY_LINE_RECIPES, ComponentAssemblyLineRecipeHandler::init);
        event.register(ASSEMBLER_RECIPES, ComponentAssemblyLineRecipeHandler::init);
    }
}
