package com.epimorphismmc.epimorphism.common;

import com.epimorphismmc.epimorphism.Epimorphism;
import com.epimorphismmc.epimorphism.EpimorphismCommon;
import com.epimorphismmc.epimorphism.api.event.GTRecipeEvent;
import com.epimorphismmc.epimorphism.common.data.EPRecipes;
import com.epimorphismmc.epimorphism.common.item.VajraItem;
import com.epimorphismmc.epimorphism.network.s2c.PacketVajraDestroy;
import com.epimorphismmc.epimorphism.utils.EPBlockUtil;

import com.gregtechceu.gtceu.common.data.GTDamageTypes;

import com.lowdragmc.lowdraglib.side.item.ItemTransferHelper;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import com.google.common.collect.ImmutableMap;

import static com.epimorphismmc.epimorphism.common.data.EPItems.MITTS;
import static com.epimorphismmc.epimorphism.common.data.EPItems.VAJRA;

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
                    var list = EPBlockUtil.getBlockDrops(
                            (ServerLevel) level, pos, player, ImmutableMap.of(Enchantments.BLOCK_FORTUNE, 5));
                    if (level.destroyBlock(pos, false)) {
                        VajraItem.discharge(event.getItemStack());
                        list.forEach(s -> ItemTransferHelper.giveItemToPlayer(player, s));

                        EpimorphismCommon.network()
                                .sendToPlayer(new PacketVajraDestroy(true), (ServerPlayer) player);
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
