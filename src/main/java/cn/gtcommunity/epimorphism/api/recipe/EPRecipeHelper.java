package cn.gtcommunity.epimorphism.api.recipe;

import com.gregtechceu.gtceu.api.capability.recipe.ItemRecipeCapability;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.content.Content;
import com.gregtechceu.gtceu.api.recipe.ingredient.SizedIngredient;
import com.gregtechceu.gtceu.common.item.IntCircuitBehaviour;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class EPRecipeHelper {
    private static final Map<String, GTRecipe> CACHE = new ConcurrentHashMap<>();
    public static GTRecipe addCircuitMeta(GTRecipe recipe, int configuration) {
        var stack = IntCircuitBehaviour.stack(configuration);
        return CACHE.computeIfAbsent("%s_%s".formatted(recipe.id.toString(), configuration), key -> {
            var newRecipe = recipe.copy();
            newRecipe.inputs.computeIfAbsent(ItemRecipeCapability.CAP, capability -> new ArrayList<>()).add(new Content(ItemRecipeCapability.CAP.of(SizedIngredient.create(stack)), 0, 0, null, null));
            return newRecipe;
        });
    }
}
