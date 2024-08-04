package com.epimorphismmc.epimorphism;

import com.epimorphismmc.epimorphism.api.data.chemical.material.info.EPMaterialIconSet;
import com.epimorphismmc.epimorphism.api.data.chemical.material.info.EPMaterialIconType;
import com.epimorphismmc.epimorphism.api.data.tag.EPTagPrefix;
import com.epimorphismmc.epimorphism.common.data.EPDimensionTypes;
import com.epimorphismmc.epimorphism.common.data.EPItems;
import com.epimorphismmc.epimorphism.common.data.EPParticleTypes;
import com.epimorphismmc.epimorphism.data.recipe.GTRecipeManager;


import com.gregtechceu.gtceu.api.addon.GTAddon;

import com.gregtechceu.gtceu.api.addon.IGTAddon;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Consumer;

@GTAddon
public class EPGTAddon implements IGTAddon {

    @Override
    public String addonModId() {
        return Epimorphism.MOD_ID;
    }

    @Override
    public GTRegistrate getRegistrate() {
        return EpimorphismCommon.registrate();
    }

    @Override
    public boolean requiresHighTier() {
        return true;
    }

    @Override
    public void initializeAddon() {
        EPMaterialIconSet.init();
        EPMaterialIconType.init();
        GTRecipeManager.onGTPostInitialization();
        EPItems.init();
        EPDimensionTypes.init();
        EPParticleTypes.init();
        Epimorphism.LOGGER.info("Epimorphism's GT Addon Loaded!");
    }

    @Override
    public void registerTagPrefixes() {
        EPTagPrefix.init();
    }

    @Override
    public void addRecipes(Consumer<FinishedRecipe> provider) {
        GTRecipeManager.onGTRecipeAddition(provider);
    }

    @Override
    public void removeRecipes(Consumer<ResourceLocation> consumer) {}
}
