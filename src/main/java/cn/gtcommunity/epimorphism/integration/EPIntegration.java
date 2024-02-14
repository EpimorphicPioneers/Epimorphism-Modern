package cn.gtcommunity.epimorphism.integration;

import cn.gtcommunity.epimorphism.api.EPValues;
import com.gregtechceu.gtceu.api.GTValues;
import com.lowdragmc.lowdraglib.LDLib;

public class EPIntegration {
    public static boolean isKubeJSLoaded() {
        return LDLib.isModLoaded(GTValues.MODID_KUBEJS);
    }
    public static boolean isCreateLoaded() {
        return LDLib.isModLoaded(GTValues.MODID_CREATE);
    }
    public static boolean isAE2Loaded() {
        return LDLib.isModLoaded(GTValues.MODID_APPENG);
    }
    public static boolean isAdAstraLoaded() {
        return LDLib.isModLoaded(EPValues.MODID_AD_ASTRA);
    }
    public static boolean isBotaniaLoaded() {
        return LDLib.isModLoaded(EPValues.MODID_BOTANIA);
    }
    public static boolean isEmbersLoaded() {
        return LDLib.isModLoaded(EPValues.MODID_EMBERS);
    }
    public static boolean isTwilightForestLoaded() {
        return LDLib.isModLoaded(EPValues.MODID_TWILIGHT_FOREST);
    }
}
