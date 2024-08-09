package com.epimorphismmc.epimorphism.data.recipe.misc;

import com.epimorphismmc.epimorphism.Epimorphism;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.DyeColor;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

import static com.epimorphismmc.epimorphism.common.data.EPMaterials.*;
import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;

public class ConcreteRecipes {
    public static void init(Consumer<FinishedRecipe> provider) {
        for (int i = 0; i < DyeColor.values().length; i++) {
            var color = DyeColor.values()[i];
            String dyeName = color.getName();
            MIXER_RECIPES
                    .recipeBuilder(Epimorphism.id(dyeName + "_concrete"))
                    .inputItems(Tags.Items.SAND, 4)
                    .inputItems(Tags.Items.GRAVEL, 4)
                    .inputFluids(CHEMICAL_DYES[color.ordinal()].getFluid(L))
                    .inputFluids(Water.getFluid(1000))
                    .outputFluids(CONCRETES[i].getFluid(144 * 8))
                    .duration(200)
                    .EUt(VA[ULV])
                    .save(provider);
        }
    }
}
