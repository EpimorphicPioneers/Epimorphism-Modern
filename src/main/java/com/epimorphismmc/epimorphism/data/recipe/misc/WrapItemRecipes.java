package com.epimorphismmc.epimorphism.data.recipe.misc;

import com.epimorphismmc.epimorphism.Epimorphism;

import com.epimorphismmc.monomorphism.utility.RegisteredObjects;

import com.gregtechceu.gtceu.common.data.GTRecipeTypes;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.epimorphismmc.epimorphism.common.data.items.EPWrapItem.WRAP_CIRCUIT_MAP;
import static com.epimorphismmc.epimorphism.common.data.items.EPWrapItem.WRAP_ITEM_MAP;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

/**
 * 封装物品相关配方
 */
public class WrapItemRecipes {
    public static void init(Consumer<FinishedRecipe> provider) {
        WRAP_CIRCUIT_MAP.object2ObjectEntrySet().fastForEach(entry -> {
            var item = entry.getValue().asItem();
            var tag = entry.getKey();
            GTRecipeTypes.ASSEMBLER_RECIPES
                    .recipeBuilder(Epimorphism.id("wrap_" + tag.location().getPath().replace('/', '_')))
                    .inputItems(tag, 16)
                    .inputFluids(Polyethylene.getFluid(72))
                    .circuitMeta(16)
                    .outputItems(item, 1)
                    .duration(600)
                    .EUt(30)
                    .save(provider);
        });

        WRAP_ITEM_MAP.object2ObjectEntrySet().fastForEach(entry -> {
            var item = entry.getValue().asItem();
            var wrappedItem = entry.getKey().asItem();
            GTRecipeTypes.ASSEMBLER_RECIPES
                    .recipeBuilder(Epimorphism.id(
                            "wrap_" + RegisteredObjects.getKeyOrThrow(wrappedItem).getPath()))
                    .inputItems(wrappedItem, 16)
                    .inputFluids(Polyethylene.getFluid(72))
                    .circuitMeta(16)
                    .outputItems(item, 1)
                    .duration(600)
                    .EUt(30)
                    .save(provider);
        });
    }
}
