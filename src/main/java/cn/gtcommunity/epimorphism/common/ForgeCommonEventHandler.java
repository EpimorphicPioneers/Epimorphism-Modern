package cn.gtcommunity.epimorphism.common;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.common.data.EPItems;
import cn.gtcommunity.epimorphism.common.item.VajraItem;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Epimorphism.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeCommonEventHandler {
    @SubscribeEvent
    public static void onPlayerLeftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
        var stack = event.getItemStack();
        var player = event.getEntity();
        if (!player.isCreative() && stack.is(EPItems.VAJRA.asItem()) && VajraItem.canDestroyBlock(stack)) {
            Epimorphism.proxy.onPlayerLeftClickBlock(event);
        }
    }
}
