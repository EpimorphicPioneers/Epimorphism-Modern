package com.epimorphismmc.epimorphism.data.recipe.misc;


import com.epimorphismmc.epimorphism.common.block.BorosilicateGlassBlock;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;

import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.epimorphismmc.epimorphism.common.data.EPBlocks.*;
import static com.epimorphismmc.epimorphism.common.data.EPMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;


public class BorosilicateGlassRecipe {
    public static void init(Consumer<FinishedRecipe> provider) {
        addBorosilicateGlassRecipe(provider, TITANIUM_BOROSILICATE_GLASS, Titanium);
        addBorosilicateGlassRecipe(provider, TUNGSTEN_BOROSILICATE_GLASS, Tungsten);
        addBorosilicateGlassRecipe(provider, IRIDIUM_BOROSILICATE_GLASS, Iridium);
        addBorosilicateGlassRecipe(provider, OSMIUM_BOROSILICATE_GLASS, Osmium);
        addBorosilicateGlassRecipe(provider, DURANIUM_BOROSILICATE_GLASS, Duranium);
        addBorosilicateGlassRecipe(provider, NEUTRONIUM_BOROSILICATE_GLASS, Neutronium);
        addBorosilicateGlassRecipe(provider, COSMIC_NEUTRONIUM_BOROSILICATE_GLASS, CosmicNeutronium);
        addBorosilicateGlassRecipe(provider, INFINITY_BOROSILICATE_GLASS, Infinity);
        addBorosilicateGlassRecipe(provider, TRANSCENDENT_MENTAL_BOROSILICATE_GLASS, TranscendentMental);
        addBorosilicateGlassRecipe(provider, WHITE_DWARF_MATTER_BOROSILICATE_GLASS, WhiteDwarfMatter);
    }

    public static void addBorosilicateGlassRecipe(Consumer<FinishedRecipe> provider, BlockEntry<BorosilicateGlassBlock> glass, Material material) {
        GTRecipeTypes.FLUID_SOLIDFICATION_RECIPES.recipeBuilder(glass.get())
                .inputItems(BOROSILICATE_GLASS.asStack(1))
                .inputFluids(material.getFluid(8 * 144))
                .outputItems(glass.asStack(1))
                .EUt(GTValues.VA[glass.get().getTierType().tier() - 1])
                .duration(40 * 20)
                .save(provider);
    }
}
