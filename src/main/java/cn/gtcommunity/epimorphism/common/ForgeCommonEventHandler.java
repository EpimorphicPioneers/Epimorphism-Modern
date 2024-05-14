package cn.gtcommunity.epimorphism.common;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.api.event.GTRecipeEvent;
import cn.gtcommunity.epimorphism.common.data.EPRecipes;
import cn.gtcommunity.epimorphism.common.item.VajraItem;
import cn.gtcommunity.epimorphism.network.EPNetworking;
import cn.gtcommunity.epimorphism.network.s2c.PacketVajraDestroy;
import cn.gtcommunity.epimorphism.utils.EPBlockUtil;
import com.epimorphismmc.monomorphism.utility.MOTransferUtils;
import com.google.common.collect.ImmutableMap;
import com.gregtechceu.gtceu.common.data.GTDamageTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static cn.gtcommunity.epimorphism.common.data.EPItems.*;

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

            if (!player.isCreative() && stack.is(VAJRA.asItem()) && VajraItem.canDestroyBlock(stack)) {
                if (block.getBlock().defaultDestroyTime() >= 0) {
                    var list = EPBlockUtil.getBlockDrops((ServerLevel) level, pos, player, ImmutableMap.of(Enchantments.BLOCK_FORTUNE, 5));
                    if (level.destroyBlock(pos, false)) {
                        VajraItem.discharge(event.getItemStack());
                        MOTransferUtils.fillPlayerInventory(player, list);
                        EPNetworking.NETWORK.sendToPlayer(new PacketVajraDestroy(true), (ServerPlayer) player);
                    }
                }
            }

        }
    }

    @SubscribeEvent
    public static void onLivingAttack(LivingAttackEvent event) {
        var entity = event.getEntity();
        var damageSource = event.getSource();
        if (entity instanceof ServerPlayer player) {
            if (!player.isCreative()) {
                var mainHandItem = player.getMainHandItem();
                var offhandItem = player.getOffhandItem();
                if (damageSource.is(GTDamageTypes.HEAT.key)) {
                    ItemStack item = null;
                    InteractionHand handIn;
                    if (mainHandItem.is(MITTS.asItem())) {
                        item = mainHandItem;
                        handIn = InteractionHand.MAIN_HAND;
                    } else if (offhandItem.is(MITTS.asItem())) {
                        item = offhandItem;
                        handIn = InteractionHand.OFF_HAND;
                    } else {
                        handIn = null;
                    }

                    if (item != null) {
                        event.setCanceled(true);
                        var tag = item.getOrCreateTag();
                        var key = "HeatDamageCount";
                        int count = tag.getInt(key) + 1;
                        if (count >= 5) {
                            item.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(handIn));
                        }
                        if (!item.isEmpty()) {
                            tag.putInt(key, count % 5);
                        }
                    }
                }
            } else {

            }
        }
    }

    @SubscribeEvent
    public static void addRecipes(GTRecipeEvent.AddRecipe event) {
        event.register(EPRecipes::init);
    }
}
