package com.epimorphismmc.epimorphism.data.recipe.misc;

import com.epimorphismmc.epimorphism.common.data.EPRecipeTypes;

import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.Locale;
import java.util.function.Consumer;

public class RadiationHatchRecipeHandler {
    public static void init(Consumer<FinishedRecipe> provider) {
        registerRadioactiveMaterial(GTMaterials.Bismuth, 198 * 20, 83, provider);
        registerRadioactiveMaterial(GTMaterials.Uranium235, 80 * 20, 92, provider);
        registerRadioactiveMaterial(GTMaterials.Uranium238, 80 * 20, 92, provider);
        registerRadioactiveMaterial(GTMaterials.Plutonium239, 66 * 20, 94, provider);
        registerRadioactiveMaterial(GTMaterials.Plutonium241, 66 * 20, 94, provider);
        registerRadioactiveMaterial(GTMaterials.Naquadah, (int) (14.5 * 20), 130, provider);
        registerRadioactiveMaterial(GTMaterials.NaquadahEnriched, (int) (10.5 * 20), 140, provider);
        registerRadioactiveMaterial(GTMaterials.Naquadria, 8 * 20, 150, provider);
    }

    private static void registerRadioactiveMaterial(
            Material material, int duration, int radioactivity, Consumer<FinishedRecipe> provider) {
        if (material.hasFlag(MaterialFlags.GENERATE_ROD)) {
            EPRecipeTypes.RADIATION_HATCH_LIST
                    .recipeBuilder(
                            "radioactive_material_rod.%s".formatted(material.getName().toLowerCase(Locale.ROOT)))
                    .inputItems(ChemicalHelper.get(TagPrefix.rod, material, 1))
                    .duration(duration)
                    .addData("radioactivity", radioactivity)
                    .addData("mass", 1)
                    .save(provider);
        }

        if (material.hasFlag(MaterialFlags.GENERATE_LONG_ROD)) {
            EPRecipeTypes.RADIATION_HATCH_LIST
                    .recipeBuilder("radioactive_material_long_rod.%s"
                            .formatted(material.getName().toLowerCase(Locale.ROOT)))
                    .inputItems(ChemicalHelper.get(TagPrefix.rodLong, material, 1))
                    .duration(duration)
                    .addData("radioactivity", radioactivity)
                    .addData("mass", 2)
                    .save(provider);
        }
    }
}
