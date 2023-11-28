package cn.gtcommunity.epimorphism.fabric;

import cn.gtcommunity.epimorphism.Epimorphism;
import com.gregtechceu.gtceu.config.ConfigHolder;
import com.lowdragmc.lowdraglib.Platform;
import net.fabricmc.api.ModInitializer;

public class EpimorphismFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        if (Platform.isDatagen()) { // Force these to load for data generation
            ConfigHolder.init(); // force init GTCEu ConfigHolder
        }
        Epimorphism.init();
    }
}
