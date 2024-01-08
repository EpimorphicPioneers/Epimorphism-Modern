package cn.gtcommunity.epimorphism.common.fabric;

import cn.gtcommunity.epimorphism.common.CommonProxy;
import cn.gtcommunity.epimorphism.common.data.EPItems;
import cn.gtcommunity.epimorphism.common.item.fabric.VajraItemImpl;
import cn.gtcommunity.epimorphism.network.EPNetworking;
import cn.gtcommunity.epimorphism.network.s2c.PacketVajraDestroy;
import cn.gtcommunity.epimorphism.utils.EPBlockUtil;
import cn.gtcommunity.epimorphism.utils.EPItemUtil;
import com.google.common.collect.ImmutableMap;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

public class CommonProxyImpl {
    public static void onGTCEuSetup() {
        CommonProxy.init();
    }

    public static void init() {
        AttackBlockCallback.EVENT.register(CommonProxyImpl::onPlayerLeftClickBlock);
    }

    private static InteractionResult onPlayerLeftClickBlock(Player player, Level world, InteractionHand hand, BlockPos pos, Direction direction) {
        if (!world.isClientSide()) {
            var block = world.getBlockState(pos);
            var stack = player.getItemInHand(hand);
            if (!player.isCreative() && stack.is(EPItems.VAJRA.asItem()) && VajraItemImpl.canDestroyBlock(stack)) {
                if (block.getBlock().defaultDestroyTime() >= 0) {
                    var list = EPBlockUtil.getBlockDrops((ServerLevel) world, pos, player, ImmutableMap.of(Enchantments.BLOCK_FORTUNE, 5));
                    if (world.destroyBlock(pos, false)) {
                        VajraItemImpl.discharge(stack);
                        EPItemUtil.fillInventory(player, list);
                        EPNetworking.NETWORK.sendToPlayer(new PacketVajraDestroy(true), (ServerPlayer) player);
                    }
                }
            }
        }
        return InteractionResult.PASS;
    }
}
