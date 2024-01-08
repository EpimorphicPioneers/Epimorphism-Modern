package cn.gtcommunity.epimorphism.forge;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.common.data.EPItems;
import cn.gtcommunity.epimorphism.common.item.forge.VajraItemImpl;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Epimorphism.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeCommonEventHandler {
    @SubscribeEvent
    public static void onPlayerLeftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
        var stack = event.getItemStack();
        var player = event.getEntity();
        if (!player.isCreative() && stack.is(EPItems.VAJRA.asItem()) && VajraItemImpl.canDestroyBlock(stack)) {
            EpimorphismForge.proxy.onPlayerLeftClickBlock(event);
        }
    }
}
