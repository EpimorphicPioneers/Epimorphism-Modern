package cn.gtcommunity.epimorphism;

import cn.gtcommunity.epimorphism.api.registry.EPRegistries;
import cn.gtcommunity.epimorphism.common.data.*;
import com.gregtechceu.gtceu.api.addon.GTAddon;
import com.gregtechceu.gtceu.api.addon.IGTAddon;

@GTAddon
public class EPGTAddon implements IGTAddon {

    @Override
    public void initializeAddon() {
        Epimorphism.LOGGER.info("Epimorphism's GT Addon Loaded!");
        EPCreativeModeTabs.init();
        EPBlocks.init();
        EPItems.init();
        EPRegistries.EP_REGISTRATE.registerRegistrate();
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
