package com.epimorphismmc.epimorphism.common;

import com.epimorphismmc.epimorphism.Epimorphism;
import com.epimorphismmc.epimorphism.api.data.tag.EPTagPrefix;
import com.epimorphismmc.epimorphism.api.event.GTRecipeEvent;
import com.epimorphismmc.epimorphism.common.block.BlockMaps;
import com.epimorphismmc.epimorphism.common.block.BlockTypeAdditions;
import com.epimorphismmc.epimorphism.common.data.EPBlocks;
import com.epimorphismmc.epimorphism.common.data.EPCovers;
import com.epimorphismmc.epimorphism.common.data.EPCreativeModeTabs;
import com.epimorphismmc.epimorphism.common.data.EPDimensionTypes;
import com.epimorphismmc.epimorphism.common.data.EPElements;
import com.epimorphismmc.epimorphism.common.data.EPItems;
import com.epimorphismmc.epimorphism.common.data.EPMachines;
import com.epimorphismmc.epimorphism.common.data.EPMaterials;
import com.epimorphismmc.epimorphism.common.data.EPParticleTypes;
import com.epimorphismmc.epimorphism.common.data.EPRecipeConditions;
import com.epimorphismmc.epimorphism.common.data.EPRecipeTypes;
import com.epimorphismmc.epimorphism.common.data.EPRecipes;
import com.epimorphismmc.epimorphism.data.recipe.GTRecipeManager;
import com.epimorphismmc.epimorphism.data.recipe.handler.GTRecipeHandlerManager;

import com.epimorphismmc.monomorphism.proxy.base.ICommonProxyBase;

import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.cover.CoverDefinition;
import com.gregtechceu.gtceu.api.data.chemical.Element;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialRegistryEvent;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.api.recipe.RecipeCondition;
import com.gregtechceu.gtceu.common.data.GTCreativeModeTabs;
import com.gregtechceu.gtceu.common.unification.material.MaterialRegistryManager;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class CommonProxy implements ICommonProxyBase {

    public CommonProxy() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.register(this);
        EPParticleTypes.register(eventBus);
        Epimorphism.logger().info("Epimorphism's Initialization Completed!");
    }

    public void init() {
        EPItems.init();
        EPDimensionTypes.init();
        EPParticleTypes.init();
    }

    /* -------------------------------------------------- Registration Methods -------------------------------------------------- */

    @Override
    public void registerEventHandlers() {}

    @Override
    public void registerCapabilities() {}

    @Override
    public void registerTagPrefixes() {
        EPTagPrefix.init();
    }

    @Override
    public void registerElements(GTCEuAPI.RegisterEvent<String, Element> event) {
        EPElements.init();
    }

    @Override
    public void registerCoverDefinitions(
            GTCEuAPI.RegisterEvent<ResourceLocation, CoverDefinition> event) {
        EPCovers.init();
    }

    @Override
    public void registerMachineDefinitions(
            GTCEuAPI.RegisterEvent<ResourceLocation, MachineDefinition> event) {
        EPCreativeModeTabs.init();
        EPBlocks.init();
        EPMachines.init();
    }

    @Override
    public void registerRecipeTypes(GTCEuAPI.RegisterEvent<ResourceLocation, GTRecipeType> event) {
        EPRecipeTypes.init();
    }

    @Override
    public void registerRecipeConditions(
            GTCEuAPI.RegisterEvent<String, Class<? extends RecipeCondition>> event) {
        EPRecipeConditions.init();
    }

    @Override
    public void registerMaterials(MaterialEvent event) {
        EPMaterials.init();
    }

    @Override
    public void registerMaterialRegistry(MaterialRegistryEvent event) {
        Epimorphism.registrate().creativeModeTab(GTCreativeModeTabs.MATERIAL_ITEM);
        MaterialRegistryManager.getInstance().createRegistry(Epimorphism.MOD_ID);
    }

    @SubscribeEvent
    public void onCommonSetup(FMLCommonSetupEvent event) {
        BlockMaps.init();
        BlockTypeAdditions.init();
        GTRecipeManager.onCommonSetup();
    }

    @SubscribeEvent
    public void registerRecipeHandler(GTRecipeEvent.RegisterHandler event) {
        GTRecipeHandlerManager.register(event);
    }

    @SubscribeEvent
    public void removeRecipe(GTRecipeEvent.RemoveRecipe event) {
        EPRecipes.remove(event);
    }
}
