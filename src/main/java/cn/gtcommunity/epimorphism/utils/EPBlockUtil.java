package cn.gtcommunity.epimorphism.utils;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;
import java.util.Map;

public class EPBlockUtil {
    public static ItemStack getBlockItem(BlockState state, int amount) {
        return new ItemStack(state.getBlock(), amount);
    }

    public static ItemStack getBlockItem(BlockState state) {
        return getBlockItem(state, 1);
    }

    public static List<ItemStack> getBlockDrops (ServerLevel level, BlockPos pos, Player player, Map<Enchantment, Integer> enchantments) {
        var state = level.getBlockState(pos);
        var blockEntity = level.getBlockEntity(pos);
        var harvestTool = createHarvestTool(state, enchantments);
        var harvestToolItem = harvestTool.item();
        return Block.getDrops(state, level, pos, blockEntity, player, harvestToolItem);
    }

    private static HarvestTool createHarvestTool(BlockState state, Map<Enchantment, Integer> enchantments) {
        ItemStack tool;
        boolean fallback = false;

        if (state.is(BlockTags.MINEABLE_WITH_PICKAXE)) {
            tool = new ItemStack(Items.DIAMOND_PICKAXE, 1);
        } else if (state.is(BlockTags.MINEABLE_WITH_AXE)) {
            tool = new ItemStack(Items.DIAMOND_AXE, 1);
        } else if (state.is(BlockTags.MINEABLE_WITH_SHOVEL)) {
            tool = new ItemStack(Items.DIAMOND_SHOVEL, 1);
        } else if (state.is(BlockTags.MINEABLE_WITH_HOE)) {
            tool = new ItemStack(Items.DIAMOND_HOE, 1);
        } else {
            // Use a pickaxe for everything else, to allow enchanting it
            tool = new ItemStack(Items.DIAMOND_PICKAXE, 1);
            fallback = true;
        }

        if (enchantments != null) {
            // For silk touch / fortune purposes, enchant the fake tool
            EnchantmentHelper.setEnchantments(enchantments, tool);

            // Setting fallback to false ensures it'll be used even if not strictly required
            fallback = false;
        }

        return new HarvestTool(tool, fallback);
    }

    record HarvestTool(ItemStack item, boolean fallback) {
    }
}
