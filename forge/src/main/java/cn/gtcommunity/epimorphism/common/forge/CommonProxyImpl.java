package cn.gtcommunity.epimorphism.common.forge;

import cn.gtcommunity.epimorphism.EPGTAddon;
import cn.gtcommunity.epimorphism.common.CommonProxy;
import cn.gtcommunity.epimorphism.common.item.forge.VajraItemImpl;
import cn.gtcommunity.epimorphism.network.EPNetworking;
import cn.gtcommunity.epimorphism.network.s2c.PacketVajraDestroy;
import cn.gtcommunity.epimorphism.utils.EPBlockUtil;
import cn.gtcommunity.epimorphism.utils.EPItemUtil;
import com.google.common.collect.ImmutableMap;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class CommonProxyImpl {
    private static final Object LOCK = new Object();
    private static boolean isGTCEuSetup = false;

    public static void onGTCEuSetup() {
        synchronized (LOCK) {
            isGTCEuSetup = true;
            LOCK.notify();
        }
    }

    public CommonProxyImpl() {
        // used for forge events (ClientProxy + CommonProxy)
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.register(this);
        // init common features
        synchronized (LOCK) {
            if (!isGTCEuSetup) {
                try {
                    LOCK.wait();
                } catch (InterruptedException ignored) {
                }
            }
        }
        CommonProxy.init();
    }

    @SubscribeEvent
    public void onCommonSetup(FMLCommonSetupEvent event) {
        EPGTAddon.postInitializeAddon();
    }

    public void onPlayerLeftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
        var level = event.getLevel();
        var pos = event.getPos();
        var player = event.getEntity();
        var block = level.getBlockState(pos);
        if (block.getBlock().defaultDestroyTime() >= 0) {
            var list = EPBlockUtil.getBlockDrops((ServerLevel) level, pos, player, ImmutableMap.of(Enchantments.BLOCK_FORTUNE, 5));
            if (level.destroyBlock(pos, false)) {
                VajraItemImpl.discharge(event.getItemStack());
                EPItemUtil.fillInventory(player, list);
                EPNetworking.NETWORK.sendToPlayer(new PacketVajraDestroy(true), (ServerPlayer) player);
            }
        }
    }
}
