package cn.gtcommunity.epimorphism.utils;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class EPItemUtil {
    public static void fillInventory(Player player, List<ItemStack> list) {
        for (var stack : list) {
            if (!player.getInventory().add(stack)) {
                player.drop(stack, true);
            }
        }
    }
}
