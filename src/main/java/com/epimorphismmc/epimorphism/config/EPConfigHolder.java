package com.epimorphismmc.epimorphism.config;

import com.epimorphismmc.epimorphism.Epimorphism;

import dev.toma.configuration.Configuration;
import dev.toma.configuration.config.Config;
import dev.toma.configuration.config.Configurable;
import dev.toma.configuration.config.format.ConfigFormats;

@Config(id = Epimorphism.MOD_ID)
public class EPConfigHolder {

    public static EPConfigHolder INSTANCE;

    public static void init() {
        if (INSTANCE == null) {
            INSTANCE = Configuration.registerConfig(EPConfigHolder.class, ConfigFormats.yaml())
                    .getConfigInstance();
        }
    }

    @Configurable
    public MachineConfigs machines = new MachineConfigs();

    @Configurable
    public ItemConfigs items = new ItemConfigs();

    public static class MachineConfigs {
        @Configurable
        @Configurable.Comment({"Wether to add a \"Processing Array\"", "Default: true"})
        public boolean doProcessingArray = true;
    }

    public static class ItemConfigs {
        @Configurable
        @Configurable.Comment({
            "The subscript used to warp items",
            "When true, use like \"I\" to subscript",
            "Default: true"
        })
        public boolean perfRomanSubscript = true;
    }
}
