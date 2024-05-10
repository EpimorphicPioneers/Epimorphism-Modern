package cn.gtcommunity.epimorphism.common;

import cn.gtcommunity.epimorphism.EPGTAddon;
import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.api.event.GTRecipeEvent;
import cn.gtcommunity.epimorphism.common.registry.EPRegistration;
import cn.gtcommunity.epimorphism.common.data.EPParticleTypes;
import cn.gtcommunity.epimorphism.common.data.*;
import cn.gtcommunity.epimorphism.common.data.EPItems;
import cn.gtcommunity.epimorphism.config.EPConfigHolder;
import cn.gtcommunity.epimorphism.data.EPDatagen;
import cn.gtcommunity.epimorphism.data.EPProviderTypes;
import cn.gtcommunity.epimorphism.data.recipe.GTRecipeManager;
import cn.gtcommunity.epimorphism.data.recipe.generated.GTRecipeHandlerManager;
import cn.gtcommunity.epimorphism.network.EPNetworking;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialRegistryEvent;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.config.ConfigHolder;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class CommonProxy {

    public CommonProxy() {
        ConfigHolder.init();
        EPConfigHolder.init();
        EPProviderTypes.init();
        EPNetworking.init();

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.register(this);
        EPParticleTypes.register(eventBus);
        eventBus.addGenericListener(GTRecipeType.class, this::registerRecipeTypes);
        eventBus.addGenericListener(MachineDefinition.class, this::registerMachine);

        EPRegistration.EP_REGISTRATE.registerRegistrate();
        Epimorphism.LOGGER.info("Epimorphism's Initialization Completed!");
    }

    public void init() {
        EPItems.init();
        EPDatagen.init();
        EPDimensionTypes.init();
        EPParticleTypes.init();
    }

    public void registerRecipeTypes(GTCEuAPI.RegisterEvent<ResourceLocation, GTRecipeType> event) {
        EPRecipeTypes.init();
    }

    public void registerMachine(GTCEuAPI.RegisterEvent<ResourceLocation, MachineDefinition> event) {
        EPCreativeModeTabs.init();
        EPBlocks.init();
        EPBlockEntities.init();
        EPMachines.init();
    }

    @SubscribeEvent
    public void onCommonSetup(FMLCommonSetupEvent event) {
        EPGTAddon.postInitializeAddon();
        GTRecipeManager.onCommonSetup();
    }

    @SubscribeEvent
    public void registerMaterialRegistry(MaterialRegistryEvent event) {
    }

    @SubscribeEvent
    public void registerMaterials(MaterialEvent event) {
        EPMaterials.init();
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
