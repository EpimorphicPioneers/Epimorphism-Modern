package cn.gtcommunity.epimorphism.api.registry;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.common.data.EPBlocks;
import cn.gtcommunity.epimorphism.common.data.EPCreativeModeTabs;
import cn.gtcommunity.epimorphism.common.data.EPMachines;
import cn.gtcommunity.epimorphism.common.data.EPRecipeTypes;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import net.minecraft.resources.ResourceLocation;

public class EPRegistries {
    public static final GTRegistrate EP_REGISTRATE = GTRegistrate.create(Epimorphism.MOD_ID);

    // EP Registry

    public static void registerRecipeTypes(GTCEuAPI.RegisterEvent<ResourceLocation, GTRecipeType> event) {
        EPRecipeTypes.init();
    }

    public static void registerMachine(GTCEuAPI.RegisterEvent<ResourceLocation, MachineDefinition> event) {
        EPCreativeModeTabs.init();
        EPBlocks.init();
        EPMachines.init();
    }
}
