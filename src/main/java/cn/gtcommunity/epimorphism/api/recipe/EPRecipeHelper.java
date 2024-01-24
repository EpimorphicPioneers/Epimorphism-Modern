package cn.gtcommunity.epimorphism.api.recipe;

import com.gregtechceu.gtceu.api.capability.recipe.ItemRecipeCapability;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.content.Content;
import com.gregtechceu.gtceu.api.recipe.ingredient.SizedIngredient;
import com.gregtechceu.gtceu.common.item.IntCircuitBehaviour;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

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

    public static Content itemStack(ItemStack itemStack, float chance, float tierChanceBoost) {
        return new Content(ItemRecipeCapability.CAP.of(SizedIngredient.create(itemStack)), chance, tierChanceBoost, null, null);
    }

    public static Content itemStack(Item item, int amount, float chance, float tierChanceBoost) {
        return new Content(ItemRecipeCapability.CAP.of(SizedIngredient.create(new ItemStack(item, amount))), chance, tierChanceBoost, null, null);
    }
}
