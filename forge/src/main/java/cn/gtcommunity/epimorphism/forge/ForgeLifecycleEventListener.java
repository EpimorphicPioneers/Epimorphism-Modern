package cn.gtcommunity.epimorphism.forge;

import cn.gtcommunity.epimorphism.EPGTAddon;
import cn.gtcommunity.epimorphism.Epimorphism;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;

@Mod.EventBusSubscriber(modid = Epimorphism.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ForgeLifecycleEventListener {
    @SubscribeEvent
    public static void onPostInit(FMLLoadCompleteEvent event) {
        EPGTAddon.postInitializeAddon();
    }
}
