package cn.gtcommunity.epimorphism;

import cn.gtcommunity.epimorphism.api.data.chemical.material.info.EPMaterialIconSet;
import cn.gtcommunity.epimorphism.api.data.chemical.material.info.EPMaterialIconType;
import cn.gtcommunity.epimorphism.api.data.tag.EPTagPrefix;
import cn.gtcommunity.epimorphism.common.registry.EPRegistration;
import cn.gtcommunity.epimorphism.common.block.BlockMaps;
import cn.gtcommunity.epimorphism.common.block.BlockTypeAdditions;
import cn.gtcommunity.epimorphism.common.data.EPRecipeConditions;
import cn.gtcommunity.epimorphism.data.recipe.GTRecipeManager;
import com.gregtechceu.gtceu.api.addon.GTAddon;
import com.gregtechceu.gtceu.api.addon.IGTAddon;
import cn.gtcommunity.epimorphism.common.data.EPCovers;
import cn.gtcommunity.epimorphism.common.data.EPElements;
import com.gregtechceu.gtceu.api.addon.events.KJSRecipeKeyEvent;
import com.gregtechceu.gtceu.api.addon.events.MaterialCasingCollectionEvent;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Consumer;

@GTAddon
public class EPGTAddon implements IGTAddon {

    @Override
    public void initializeAddon() {
        EPMaterialIconSet.init();
        EPMaterialIconType.init();
        Epimorphism.proxy.init();
        GTRecipeManager.onGTPostInitialization();
        Epimorphism.LOGGER.info("Epimorphism's GT Addon Loaded!");
    }

    @Override
    public GTRegistrate getRegistrate() {
        return EPRegistration.EP_REGISTRATE;
    }

    public static void postInitializeAddon() {
        BlockMaps.init();
        BlockTypeAdditions.init();
    }

    @Override
    public String addonModId() {
        return Epimorphism.MOD_ID;
    }

    @Override
    public void registerTagPrefixes() {
        EPTagPrefix.init();
    }

    @Override
    public void registerElements() {
        EPElements.init();
    }

    @Override
    public void collectMaterialCasings(MaterialCasingCollectionEvent event) {
        IGTAddon.super.collectMaterialCasings(event);
    }

    @Override
    public void registerCovers() {
        EPCovers.init();
    }

    @Override
    public void addRecipes(Consumer<FinishedRecipe> provider) {
        GTRecipeManager.onGTRecipeAddition(provider);
    }

    @Override
    public void removeRecipes(Consumer<ResourceLocation> consumer) {

    }

    @Override
    public void registerRecipeKeys(KJSRecipeKeyEvent event) {
        IGTAddon.super.registerRecipeKeys(event);
    }

    @Override
    public void registerRecipeCapabilities() {
        IGTAddon.super.registerRecipeCapabilities();
    }

    @Override
    public void registerRecipeConditions() {
        EPRecipeConditions.init();
    }

    @Override
    public boolean requiresHighTier() {
        return true;
    }
}
