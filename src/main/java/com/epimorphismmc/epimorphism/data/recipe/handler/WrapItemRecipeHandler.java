package com.epimorphismmc.epimorphism.data.recipe.handler;

import com.epimorphismmc.epimorphism.common.data.items.EPWrapItem;

import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

/**
 * 封装物品相关配方
 */
public class WrapItemRecipeHandler {
    public static void init(Consumer<FinishedRecipe> provider) {
        EPWrapItem.WRAP_CIRCUIT_MAP.object2ObjectEntrySet().fastForEach(entry -> {
            var item = entry.getValue().asItem();
            var tag = entry.getKey();
            GTRecipeTypes.ASSEMBLER_RECIPES
                    .recipeBuilder("wrap_" + tag.location().getPath().replace('/', '_'))
                    .inputItems(tag, 16)
                    .inputFluids(GTMaterials.Polyethylene.getFluid(72))
                    .circuitMeta(16)
                    .outputItems(item, 1)
                    .duration(600)
                    .EUt(30)
                    .save(provider);
        });

        EPWrapItem.WRAP_ITEM_MAP.object2ObjectEntrySet().fastForEach(entry -> {
            var item = entry.getValue().asItem();
            var wrappedItem = entry.getKey().asItem();
            GTRecipeTypes.ASSEMBLER_RECIPES
                    .recipeBuilder("wrap_" + wrappedItem.asItem().getDescriptionId())
                    .inputItems(wrappedItem, 16)
                    .inputFluids(GTMaterials.Polyethylene.getFluid(72))
                    .circuitMeta(16)
                    .outputItems(item, 1)
                    .duration(600)
                    .EUt(30)
                    .save(provider);
        });
    }
}
