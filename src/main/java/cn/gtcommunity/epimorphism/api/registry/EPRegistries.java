package cn.gtcommunity.epimorphism.api.registry;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.common.data.EPMachines;
import cn.gtcommunity.epimorphism.common.data.EPMaterials;
import cn.gtcommunity.epimorphism.common.data.EPRecipeTypes;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialRegistryEvent;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Epimorphism.MOD_ID,  bus = Mod.EventBusSubscriber.Bus.MOD)
public class EPRegistries {
    public static final GTRegistrate EP_REGISTRATE = GTRegistrate.create(Epimorphism.MOD_ID);

    // EP Registry

    @SubscribeEvent
    public static void registerMaterialRegistry(MaterialRegistryEvent event) {
    }

    @SubscribeEvent
    public static void registerMaterials(MaterialEvent event) {
        EPMaterials.init();
    }

    public static void registerRecipeTypes(GTCEuAPI.RegisterEvent<ResourceLocation, GTRecipeType> event) {
        EPRecipeTypes.init();
    }

    public static void registerMachine(GTCEuAPI.RegisterEvent<ResourceLocation, MachineDefinition> event) {
        EPMachines.init();
    }
}
