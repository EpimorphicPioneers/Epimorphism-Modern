package cn.gtcommunity.epimorphism.config;

import cn.gtcommunity.epimorphism.Epimorphism;
import dev.toma.configuration.Configuration;
import dev.toma.configuration.config.Config;
import dev.toma.configuration.config.format.ConfigFormats;

@Config(id = Epimorphism.MOD_ID)
public class EPConfigHolder {

    public static EPConfigHolder INSTANCE;

    public static void init() {
        if (INSTANCE == null) {
            INSTANCE = Configuration.registerConfig(EPConfigHolder.class, ConfigFormats.yaml()).getConfigInstance();
        }
    }



}
