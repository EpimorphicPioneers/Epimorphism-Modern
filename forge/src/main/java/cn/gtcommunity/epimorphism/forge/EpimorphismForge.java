package cn.gtcommunity.epimorphism.forge;

import cn.gtcommunity.epimorphism.EPGTAddon;
import dev.architectury.platform.forge.EventBuses;
import cn.gtcommunity.epimorphism.Epimorphism;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Epimorphism.MOD_ID)
public class EpimorphismForge {
    public EpimorphismForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(Epimorphism.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        var bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.register(this);
        Epimorphism.init();
    }

    @SubscribeEvent
    public void onPostInit(FMLLoadCompleteEvent event) {
        EPGTAddon.postInitializeAddon();
    }
}
