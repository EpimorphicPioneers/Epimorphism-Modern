package cn.gtcommunity.epimorphism.common.block;

import cn.gtcommunity.epimorphism.api.block.ITierGlassType;
import cn.gtcommunity.epimorphism.api.block.SimpleTierGlassType;
import cn.gtcommunity.epimorphism.core.ITierBlockType;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StainedGlassBlock;

public class BlockTypeAdditions {
    public static void init() {
        stainedGlassTierTypeAdd(Blocks.WHITE_STAINED_GLASS);
        stainedGlassTierTypeAdd(Blocks.ORANGE_STAINED_GLASS);
        stainedGlassTierTypeAdd(Blocks.MAGENTA_STAINED_GLASS);
        stainedGlassTierTypeAdd(Blocks.LIGHT_BLUE_STAINED_GLASS);
        stainedGlassTierTypeAdd(Blocks.YELLOW_STAINED_GLASS);
        stainedGlassTierTypeAdd(Blocks.LIME_STAINED_GLASS);
        stainedGlassTierTypeAdd(Blocks.PINK_STAINED_GLASS);
        stainedGlassTierTypeAdd(Blocks.GRAY_STAINED_GLASS);
        stainedGlassTierTypeAdd(Blocks.LIGHT_GRAY_STAINED_GLASS);
        stainedGlassTierTypeAdd(Blocks.CYAN_STAINED_GLASS);
        stainedGlassTierTypeAdd(Blocks.PURPLE_STAINED_GLASS);
        stainedGlassTierTypeAdd(Blocks.BLUE_STAINED_GLASS);
        stainedGlassTierTypeAdd(Blocks.BROWN_STAINED_GLASS);
        stainedGlassTierTypeAdd(Blocks.GREEN_STAINED_GLASS);
        stainedGlassTierTypeAdd(Blocks.RED_STAINED_GLASS);
        stainedGlassTierTypeAdd(Blocks.BLACK_STAINED_GLASS);
        glassTierTypeAdd(Blocks.TINTED_GLASS, TierGlassBlock.GlassType.TINTED_GLASS);
        glassTierTypeAdd(Blocks.GLASS, TierGlassBlock.GlassType.BLOCK_GLASS);
        glassTierTypeAdd(GTBlocks.CLEANROOM_GLASS.get(), TierGlassBlock.GlassType.CLEANROOM_GLASS);
        glassTierTypeAdd(GTBlocks.FUSION_GLASS.get(), TierGlassBlock.GlassType.FUSION_GLASS);
        glassTierTypeAdd(GTBlocks.CASING_LAMINATED_GLASS.get(), TierGlassBlock.GlassType.CASING_LAMINATED_GLASS);
        glassTierTypeAdd(GTBlocks.CASING_TEMPERED_GLASS.get(), TierGlassBlock.GlassType.CASING_TEMPERED_GLASS);
    }

    private static void glassTierTypeAdd(Block block, ITierGlassType type) {
        ((ITierBlockType) block).setType(type);
        BlockMaps.ALL_GLASSES.put(type, () -> block);
    }
    
    private static void stainedGlassTierTypeAdd(Block block) {
        ITierGlassType type = new SimpleTierGlassType(((StainedGlassBlock)block).getColor().getName(), GTValues.LV, false);
        ((ITierBlockType) block).setType(type);
        BlockMaps.ALL_GLASSES.put(type, () -> block);
    }
}
