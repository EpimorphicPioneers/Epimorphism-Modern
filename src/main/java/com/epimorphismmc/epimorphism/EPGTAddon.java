package com.epimorphismmc.epimorphism;

import com.epimorphismmc.epimorphism.api.data.chemical.material.info.EPMaterialIconSet;
import com.epimorphismmc.epimorphism.api.data.chemical.material.info.EPMaterialIconType;
import com.epimorphismmc.epimorphism.data.recipe.GTRecipeManager;

import com.epimorphismmc.monomorphism.MOGTAddon;

import com.gregtechceu.gtceu.api.addon.GTAddon;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Consumer;

@GTAddon
public class EPGTAddon extends MOGTAddon {

    public EPGTAddon() {
        super(Epimorphism.MOD_ID);
    }

    @Override
    public boolean requiresHighTier() {
        return true;
    }

    @Override
    public void initializeAddon() {
        EPMaterialIconSet.init();
        EPMaterialIconType.init();
        Epimorphism.proxy().init();
        GTRecipeManager.onGTPostInitialization();
        Epimorphism.logger().info("Epimorphism's GT Addon Loaded!");
    }

    @Override
    public void addRecipes(Consumer<FinishedRecipe> provider) {
        GTRecipeManager.onGTRecipeAddition(provider);
    }

    @Override
    public void removeRecipes(Consumer<ResourceLocation> consumer) {}
}
