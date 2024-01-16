package cn.gtcommunity.epimorphism.api.recipe;

import com.gregtechceu.gtceu.api.capability.recipe.IRecipeCapabilityHolder;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.data.recipe.builder.GTRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GeneralRecipeType extends GTRecipeType {
    private final GTRecipeType recipe_1;
    private final GTRecipeType recipe_2;
    private final GTRecipeType recipe_3;
    public GeneralRecipeType(ResourceLocation registryName, String group, GTRecipeType recipe_1, GTRecipeType recipe_2, GTRecipeType recipe_3) {
        super(registryName, group);
        this.recipe_1 = recipe_1;
        this.recipe_2 = recipe_2;
        this.recipe_3 = recipe_3;
    }

    @Override
    public List<GTRecipe> searchRecipe(RecipeManager recipeManager, IRecipeCapabilityHolder holder) {
        if (!holder.hasProxies()) return Collections.emptyList();
        List<GTRecipe> matches;
        do {

            if (checkCircuit(holder, 20)) {
                var list = matchRecipe(recipe_1, 20, recipeManager, holder);
                if (!list.isEmpty()) {
                    matches = list;
                    break;
                }
            }

            if (checkCircuit(holder, 21)) {
                var list = matchRecipe(recipe_2, 21, recipeManager, holder);
                if (!list.isEmpty()) {
                    matches = list;
                    break;
                }
            }

            if (checkCircuit(holder, 22)) {
                var list = matchRecipe(recipe_3, 22, recipeManager, holder);
                if (!list.isEmpty()) {
                    matches = list;
                    break;
                }
            }

            matches = new ArrayList<>();

        } while (false);


        for (List<GTRecipe> recipes : proxyRecipes.values()) {
            var found = recipes.parallelStream()
                    .filter(recipe -> !recipe.isFuel && recipe.matchRecipe(holder).isSuccess() && recipe.matchTickRecipe(holder).isSuccess())
                    .toList();
            matches.addAll(found);
        }
        return matches;
    }

    private boolean checkCircuit(IRecipeCapabilityHolder holder, int configuration) {
        return GTRecipeBuilder.ofRaw().circuitMeta(configuration).buildRawRecipe().matchRecipe(holder).isSuccess();
    }

    private List<GTRecipe> matchRecipe(GTRecipeType recipeType, int configuration, RecipeManager recipeManager, IRecipeCapabilityHolder holder) {
        return recipeManager.getAllRecipesFor(recipeType).parallelStream()
                .map(recipe -> EPRecipeHelper.addCircuitMeta(recipe, configuration))
                .filter(recipe -> !recipe.isFuel && recipe.matchRecipe(holder).isSuccess() && recipe.matchTickRecipe(holder).isSuccess())
                .toList();
    }
}
