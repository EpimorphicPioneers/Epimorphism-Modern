package com.epimorphismmc.epimorphism.data.recipe.misc;

import com.epimorphismmc.epimorphism.common.block.BorosilicateGlassBlock;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;

import net.minecraft.data.recipes.FinishedRecipe;

import com.tterrag.registrate.util.entry.BlockEntry;

import java.util.function.Consumer;

import static com.epimorphismmc.epimorphism.common.data.EPBlocks.*;
import static com.epimorphismmc.epimorphism.common.data.EPMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

public class BorosilicateGlassRecipes {
    public static void init(Consumer<FinishedRecipe> provider) {
        addGlassRecipe(provider, TITANIUM_BOROSILICATE_GLASS, Titanium);
        addGlassRecipe(provider, TUNGSTEN_BOROSILICATE_GLASS, Tungsten);
        addGlassRecipe(provider, IRIDIUM_BOROSILICATE_GLASS, Iridium);
        addGlassRecipe(provider, OSMIUM_BOROSILICATE_GLASS, Osmium);
        addGlassRecipe(provider, DURANIUM_BOROSILICATE_GLASS, Duranium);
        addGlassRecipe(provider, NEUTRONIUM_BOROSILICATE_GLASS, Neutronium);
        addGlassRecipe(provider, COSMIC_NEUTRONIUM_BOROSILICATE_GLASS, CosmicNeutronium);
        addGlassRecipe(provider, INFINITY_BOROSILICATE_GLASS, Infinity);
        addGlassRecipe(provider, TRANSCENDENT_METAL_BOROSILICATE_GLASS, TranscendentMetal);
        addGlassRecipe(provider, WHITE_DWARF_MATTER_BOROSILICATE_GLASS, WhiteDwarfMatter);
    }

    public static void addGlassRecipe(
            Consumer<FinishedRecipe> provider,
            BlockEntry<BorosilicateGlassBlock> glass,
            Material material) {
        GTRecipeTypes.FLUID_SOLIDFICATION_RECIPES
                .recipeBuilder(glass.get())
                .inputItems(BOROSILICATE_GLASS.asStack(1))
                .inputFluids(material.getFluid(8 * 144))
                .outputItems(glass.asStack(1))
                //                .EUt(GTValues.VA[glass.get().getTierType().tier() - 1])
                .duration(40 * 20)
                .save(provider);
    }
}
