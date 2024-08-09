package com.epimorphismmc.epimorphism.data.recipe.misc;

import com.epimorphismmc.epimorphism.Epimorphism;
import com.epimorphismmc.epimorphism.common.data.EPMaterials;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.epimorphismmc.epimorphism.common.data.EPRecipeTypes.*;
import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

public class ConcreteBackfillerRecipes {

    public static void init(Consumer<FinishedRecipe> provider) {
        concrete(provider, Concrete);

        for (Material concrete : EPMaterials.CONCRETES) {
            concrete(provider, concrete);
        }
    }

    private static void concrete(Consumer<FinishedRecipe> provider, Material material) {
        CONCRETE_BACKFILLER_RECIPES
                .recipeBuilder(Epimorphism.id(material.getName()))
                .inputFluids(material.getFluid(144))
                .outputItems(block, material)
                .EUt(EV)
                .duration(20)
                .save(provider);
    }
}
