package cn.gtcommunity.epimorphism;

import cn.gtcommunity.epimorphism.api.registry.EPRegistries;
import cn.gtcommunity.epimorphism.common.block.BlockTypeAdditions;
import cn.gtcommunity.epimorphism.common.data.*;
import cn.gtcommunity.epimorphism.data.EPDatagen;
import com.gregtechceu.gtceu.api.addon.GTAddon;
import com.gregtechceu.gtceu.api.addon.IGTAddon;

@GTAddon
public class EPGTAddon implements IGTAddon {

    @Override
    public void initializeAddon() {
        Epimorphism.LOGGER.info("Epimorphism's GT Addon Loaded!");
    }

    public static void postInitializeAddon() {
        BlockTypeAdditions.init();
    }

    @Override
    public String addonModId() {
        return Epimorphism.MOD_ID;
    }

    @Override
    public void registerElements() {
        EPElements.init();
    }

    @Override
    public void registerMaterials() {
        EPMaterials.init();
    }

    @Override
    public void registerCovers() {
        EPCovers.init();
    }

    @Override
    public boolean requiresHighTier() {
        return true;
    }
}
