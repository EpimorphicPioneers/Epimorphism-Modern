package cn.gtcommunity.epimorphism.common;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.api.data.tag.EPTagPrefix;
import cn.gtcommunity.epimorphism.api.event.GTRecipeEvent;
import cn.gtcommunity.epimorphism.common.block.BlockMaps;
import cn.gtcommunity.epimorphism.common.block.BlockTypeAdditions;
import cn.gtcommunity.epimorphism.common.data.*;
import cn.gtcommunity.epimorphism.data.recipe.GTRecipeManager;
import cn.gtcommunity.epimorphism.data.recipe.generated.GTRecipeHandlerManager;
import com.epimorphismmc.monomorphism.proxy.base.ICommonProxyBase;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.cover.CoverDefinition;
import com.gregtechceu.gtceu.api.data.chemical.Element;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialEvent;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.api.recipe.RecipeCondition;
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
    public void registerEventHandlers() {

    }

    @Override
    public void registerCapabilities() {

    }

    @Override
    public void registerTagPrefixes() {
        EPTagPrefix.init();
    }

    @Override
    public void registerElements(GTCEuAPI.RegisterEvent<ResourceLocation, Element> event) {
        EPElements.init();
    }

    @Override
    public void registerCoverDefinitions(GTCEuAPI.RegisterEvent<ResourceLocation, CoverDefinition> event) {
        EPCovers.init();
    }

    @Override
    public void registerMachineDefinitions(GTCEuAPI.RegisterEvent<ResourceLocation, MachineDefinition> event) {
        EPCreativeModeTabs.init();
        EPBlocks.init();
        EPMachines.init();
    }

    @Override
    public void registerRecipeTypes(GTCEuAPI.RegisterEvent<ResourceLocation, GTRecipeType> event) {
        EPRecipeTypes.init();
    }

    @Override
    public void registerRecipeConditions(GTCEuAPI.RegisterEvent<ResourceLocation, RecipeCondition> event) {
        EPRecipeConditions.init();
    }

    @Override
    public void registerMaterials(MaterialEvent event) {
        EPMaterials.init();
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
