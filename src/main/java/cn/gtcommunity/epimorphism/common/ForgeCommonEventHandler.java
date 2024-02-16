package cn.gtcommunity.epimorphism.common;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.common.data.EPItems;
import cn.gtcommunity.epimorphism.common.item.VajraItem;
import cn.gtcommunity.epimorphism.network.EPNetworking;
import cn.gtcommunity.epimorphism.network.s2c.PacketVajraDestroy;
import cn.gtcommunity.epimorphism.utils.EPBlockUtil;
import cn.gtcommunity.epimorphism.utils.EPItemUtil;
import com.google.common.collect.ImmutableMap;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Epimorphism.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeCommonEventHandler {
    @SubscribeEvent
    public static void onPlayerLeftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
        var stack = event.getItemStack();
        var level = event.getLevel();
        var pos = event.getPos();
        var player = event.getEntity();
        var block = level.getBlockState(pos);

        if (event.getSide().isServer()) {

            if (!player.isCreative() && stack.is(EPItems.VAJRA.asItem()) && VajraItem.canDestroyBlock(stack)) {
                if (block.getBlock().defaultDestroyTime() >= 0) {
                    var list = EPBlockUtil.getBlockDrops((ServerLevel) level, pos, player, ImmutableMap.of(Enchantments.BLOCK_FORTUNE, 5));
                    if (level.destroyBlock(pos, false)) {
                        VajraItem.discharge(event.getItemStack());
                        EPItemUtil.fillInventory(player, list);
                        EPNetworking.NETWORK.sendToPlayer(new PacketVajraDestroy(true), (ServerPlayer) player);
                    }
                }
            }

        }
    }
}
