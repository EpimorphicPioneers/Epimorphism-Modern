package cn.gtcommunity.epimorphism;

import cn.gtcommunity.epimorphism.common.data.EPElements;
import cn.gtcommunity.epimorphism.common.data.EPMaterials;
import com.gregtechceu.gtceu.api.addon.GTAddon;
import com.gregtechceu.gtceu.api.addon.IGTAddon;

@GTAddon
public class EPGTAddon implements IGTAddon {

    @Override
    public void initializeAddon() {

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
    public boolean requiresHighTier() {
        return true;
    }
}
