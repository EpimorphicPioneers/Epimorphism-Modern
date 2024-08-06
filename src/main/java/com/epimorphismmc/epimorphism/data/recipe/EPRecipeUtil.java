package com.epimorphismmc.epimorphism.data.recipe;

import com.epimorphismmc.epimorphism.common.recipe.CPCasingCondition;
import com.epimorphismmc.epimorphism.common.recipe.HeatCapacityCondituon;
import com.epimorphismmc.epimorphism.common.recipe.NeutronEnergyCondition;
import com.epimorphismmc.epimorphism.common.recipe.PACasingCondition;

import com.gregtechceu.gtceu.data.recipe.builder.GTRecipeBuilder;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import static com.epimorphismmc.epimorphism.common.data.EPRecipeTypes.CHEMICAL_PLANT_RECIPES;

@SuppressWarnings("all")
public class EPRecipeUtil {

    public static GTRecipeBuilder chemicalPlantRecipe(String name, int tier, Item... catalysts) {
        var builder = CHEMICAL_PLANT_RECIPES.recipeBuilder(name).addCondition(CPCasing(tier));
        builder.slotName("catalyst");
        for (int i = 0; i < catalysts.length; i++) {
            builder.inputItems(new ItemStack(catalysts[i]));
        }
        builder.slotName(null);
        return builder;
    }

    public static int second(double seconds) {
        return (int) (seconds * 20d);
    }

    public static CPCasingCondition CPCasing(int tier) {
        return new CPCasingCondition(tier);
    }

    public static PACasingCondition PACasing(int tier) {
        return new PACasingCondition(tier);
    }

    public static HeatCapacityCondituon heatCapacity(int heatCapacity) {
        return new HeatCapacityCondituon(heatCapacity);
    }

    public static NeutronEnergyCondition neutronEnergy(int min, int max) {
        return new NeutronEnergyCondition(min, max);
    }
}
