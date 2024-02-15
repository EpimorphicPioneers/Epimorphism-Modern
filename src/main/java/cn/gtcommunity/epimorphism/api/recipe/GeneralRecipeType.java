package cn.gtcommunity.epimorphism.api.recipe;

import com.gregtechceu.gtceu.api.capability.recipe.IRecipeCapabilityHolder;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.data.recipe.builder.GTRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.Iterator;

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
    public Iterator<GTRecipe> searchRecipe(RecipeManager recipeManager, IRecipeCapabilityHolder holder) {
        if (!holder.hasProxies()) return null;

        if (checkCircuit(holder, 20)) {
            return matchRecipe(recipe_1, 20, holder);
        }

        if (checkCircuit(holder, 21)) {
            return matchRecipe(recipe_2, 21, holder);
        }

        if (checkCircuit(holder, 22)) {
            return matchRecipe(recipe_3, 22, holder);
        }

        return null;
    }

    private boolean checkCircuit(IRecipeCapabilityHolder holder, int configuration) {
        return GTRecipeBuilder.ofRaw().circuitMeta(configuration).buildRawRecipe().matchRecipe(holder).isSuccess();
    }

    private Iterator<GTRecipe> matchRecipe(GTRecipeType recipeType, int configuration, IRecipeCapabilityHolder holder) {
        return recipeType.getLookup().getRecipeIterator(holder, recipe -> {
            var newRecipe = EPRecipeHelper.addCircuitMeta(recipe, configuration);
            return !newRecipe.isFuel
                    && newRecipe.matchRecipe(holder).isSuccess()
                    && newRecipe.matchTickRecipe(holder).isSuccess();});
    }
}
