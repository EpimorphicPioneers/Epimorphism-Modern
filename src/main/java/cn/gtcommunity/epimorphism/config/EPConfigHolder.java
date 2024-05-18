package cn.gtcommunity.epimorphism.config;

import cn.gtcommunity.epimorphism.Epimorphism;
import dev.toma.configuration.Configuration;
import dev.toma.configuration.config.Config;
import dev.toma.configuration.config.Configurable;
import dev.toma.configuration.config.format.ConfigFormats;

@Config(id = Epimorphism.MOD_ID)
public class EPConfigHolder {

    public static EPConfigHolder INSTANCE;

    public static void init() {
        if (INSTANCE == null) {
            INSTANCE = Configuration.registerConfig(EPConfigHolder.class, ConfigFormats.yaml()).getConfigInstance();
        }
    }

    @Configurable
    public MachineConfigs machines = new MachineConfigs();

    @Configurable
    public EUNetworkConfigs EUNetworks = new EUNetworkConfigs();

    public static class MachineConfigs {
        @Configurable
        @Configurable.Comment({"Wether to add a \"Processing Array\"", "Default: true"})
        public boolean doProcessingArray = true;
    }

    public static class EUNetworkConfigs {
        @Configurable
        @Configurable.Comment({"", "Default: 1"})
        public int maximumPerPlayer = 1;
    }
}
