package cn.gtcommunity.epimorphism.integration;

import cn.gtcommunity.epimorphism.api.EPValues;
import com.gregtechceu.gtceu.api.GTValues;
import com.lowdragmc.lowdraglib.Platform;

public class EPIntegration {
    public static boolean isKubeJSLoaded() {
        return Platform.isModLoaded(GTValues.MODID_KUBEJS);
    }
    public static boolean isCreateLoaded() {
        return Platform.isModLoaded(GTValues.MODID_CREATE);
    }
    public static boolean isAE2Loaded() {
        return Platform.isModLoaded(GTValues.MODID_APPENG);
    }
    public static boolean isAdAstraLoaded() {
        return Platform.isModLoaded(EPValues.MODID_AD_ASTRA);
    }
    public static boolean isBotaniaLoaded() {
        return Platform.isModLoaded(EPValues.MODID_BOTANIA);
    }
    public static boolean isEmbersLoaded() {
        return Platform.isModLoaded(EPValues.MODID_EMBERS);
    }
    public static boolean isTwilightForestLoaded() {
        return Platform.isModLoaded(EPValues.MODID_TWILIGHT_FOREST);
    }
}
