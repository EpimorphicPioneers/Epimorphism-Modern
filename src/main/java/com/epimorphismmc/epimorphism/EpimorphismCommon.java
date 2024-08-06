package com.epimorphismmc.epimorphism;

import com.epimorphismmc.epimorphism.api.event.GTRecipeEvent;
import com.epimorphismmc.epimorphism.common.block.BlockMaps;
import com.epimorphismmc.epimorphism.common.block.BlockTypeAdditions;
import com.epimorphismmc.epimorphism.common.data.EPBlocks;
import com.epimorphismmc.epimorphism.common.data.EPCovers;
import com.epimorphismmc.epimorphism.common.data.EPCreativeModeTabs;
import com.epimorphismmc.epimorphism.common.data.EPElements;
import com.epimorphismmc.epimorphism.common.data.EPMachines;
import com.epimorphismmc.epimorphism.common.data.EPMaterials;
import com.epimorphismmc.epimorphism.common.data.EPParticleTypes;
import com.epimorphismmc.epimorphism.common.data.EPRecipeConditions;
import com.epimorphismmc.epimorphism.common.data.EPRecipeTypes;
import com.epimorphismmc.epimorphism.common.data.EPRecipes;
import com.epimorphismmc.epimorphism.config.EPConfigHolder;
import com.epimorphismmc.epimorphism.data.DataGenerators;
import com.epimorphismmc.epimorphism.data.recipe.GTRecipeManager;
import com.epimorphismmc.epimorphism.data.recipe.handler.GTRecipeHandlerManager;
import com.epimorphismmc.epimorphism.network.s2c.PacketVajraDestroy;

import com.epimorphismmc.monomorphism.registry.registrate.MORegistrate;

import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.cover.CoverDefinition;
import com.gregtechceu.gtceu.api.data.chemical.Element;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialRegistryEvent;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.api.recipe.RecipeCondition;
import com.gregtechceu.gtceu.common.unification.material.MaterialRegistryManager;

import com.lowdragmc.lowdraglib.networking.INetworking;
import com.lowdragmc.lowdraglib.networking.LDLNetworking;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class EpimorphismCommon implements Epimorphism {

    private static EpimorphismCommon instance;
    private static final MORegistrate REGISTRATE = MORegistrate.create(MOD_ID);
    private static final INetworking NETWORK =
            LDLNetworking.createNetworking(new ResourceLocation(MOD_ID, "networking"), "0.0.1");

    public EpimorphismCommon() {
        instance = this;

        EPConfigHolder.init();

        registerPackets(NETWORK);
        registerEventHandlers();

        DataGenerators.init();

        Epimorphism.LOGGER.info("Epimorphism's Initialization Completed!");
    }

    public void registerPackets(INetworking network) {
        network.registerS2C(PacketVajraDestroy.class);
    }

    public void registerEventHandlers() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.register(this);

        REGISTRATE.registerEventListeners(eventBus);

        EPParticleTypes.register(eventBus);

        eventBus.addGenericListener(Element.class, this::registerElements);
        eventBus.addGenericListener(GTRecipeType.class, this::registerRecipeTypes);
        eventBus.addGenericListener(
                (Class<Class<? extends RecipeCondition>>) RecipeCondition.class.getClass(),
                this::registerRecipeConditions);
        eventBus.addGenericListener(MachineDefinition.class, this::registerMachineDefinitions);
        eventBus.addGenericListener(CoverDefinition.class, this::registerCoverDefinitions);
    }

    public static EpimorphismCommon instance() {
        return instance;
    }

    public static MORegistrate registrate() {
        return REGISTRATE;
    }

    public static INetworking network() {
        return NETWORK;
    }

    public void registerElements(GTCEuAPI.RegisterEvent<String, Element> event) {
        EPElements.init();
    }

    public void registerCoverDefinitions(
            GTCEuAPI.RegisterEvent<ResourceLocation, CoverDefinition> event) {
        EPCovers.init();
    }

    public void registerMachineDefinitions(
            GTCEuAPI.RegisterEvent<ResourceLocation, MachineDefinition> event) {
        EPCreativeModeTabs.init();
        EPBlocks.init();
        EPMachines.init();
    }

    public void registerRecipeTypes(GTCEuAPI.RegisterEvent<ResourceLocation, GTRecipeType> event) {
        EPRecipeTypes.init();
    }

    public void registerRecipeConditions(
            GTCEuAPI.RegisterEvent<String, Class<? extends RecipeCondition>> event) {
        EPRecipeConditions.init();
    }

    @SubscribeEvent
    public void registerMaterials(MaterialEvent event) {
        EPMaterials.init();
    }

    @SubscribeEvent
    public void registerMaterialRegistry(MaterialRegistryEvent event) {
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
