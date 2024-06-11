package com.epimorphismmc.epimorphism.common.block;

import com.epimorphismmc.epimorphism.api.block.tier.ITierGlassType;

import com.epimorphismmc.monomorphism.block.tier.ITierBlock;

import com.gregtechceu.gtceu.api.GTValues;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StainedGlassBlock;

import java.util.function.Supplier;

import static com.gregtechceu.gtceu.common.data.GTBlocks.*;
import static net.minecraft.world.level.block.Blocks.*;

public class BlockTypeAdditions {
    public static void init() {
        //  Stained Glass
        stainedGlassTierTypeAdd(WHITE_STAINED_GLASS);
        stainedGlassTierTypeAdd(ORANGE_STAINED_GLASS);
        stainedGlassTierTypeAdd(MAGENTA_STAINED_GLASS);
        stainedGlassTierTypeAdd(LIGHT_BLUE_STAINED_GLASS);
        stainedGlassTierTypeAdd(YELLOW_STAINED_GLASS);
        stainedGlassTierTypeAdd(LIME_STAINED_GLASS);
        stainedGlassTierTypeAdd(PINK_STAINED_GLASS);
        stainedGlassTierTypeAdd(GRAY_STAINED_GLASS);
        stainedGlassTierTypeAdd(LIGHT_GRAY_STAINED_GLASS);
        stainedGlassTierTypeAdd(CYAN_STAINED_GLASS);
        stainedGlassTierTypeAdd(PURPLE_STAINED_GLASS);
        stainedGlassTierTypeAdd(BLUE_STAINED_GLASS);
        stainedGlassTierTypeAdd(BROWN_STAINED_GLASS);
        stainedGlassTierTypeAdd(GREEN_STAINED_GLASS);
        stainedGlassTierTypeAdd(RED_STAINED_GLASS);
        stainedGlassTierTypeAdd(BLACK_STAINED_GLASS);

        glassTierTypeAdd(TINTED_GLASS, TierGlassBlock.GlassType.TINTED_GLASS);
        glassTierTypeAdd(GLASS, TierGlassBlock.GlassType.BLOCK_GLASS);
        glassTierTypeAdd(CLEANROOM_GLASS, TierGlassBlock.GlassType.CLEANROOM_GLASS);
        glassTierTypeAdd(FUSION_GLASS, TierGlassBlock.GlassType.FUSION_GLASS);
        glassTierTypeAdd(CASING_LAMINATED_GLASS, TierGlassBlock.GlassType.CASING_LAMINATED_GLASS);
        glassTierTypeAdd(CASING_TEMPERED_GLASS, TierGlassBlock.GlassType.CASING_TEMPERED_GLASS);
    }

    private static void glassTierTypeAdd(Block block, ITierGlassType type) {
        ((ITierBlock) block).setTierType(type);
        BlockMaps.ALL_GLASSES.put(type, () -> block);
        BlockMaps.SHAPE_GLASSES.put(type, () -> block);
    }

    private static void glassTierTypeAdd(Supplier<Block> blockSupplier, ITierGlassType type) {
        var block = blockSupplier.get();
        glassTierTypeAdd(block, type);
    }

    private static void stainedGlassTierTypeAdd(Block block) {
        ITierGlassType type = new ITierGlassType.SimpleTierGlassType(
                ((StainedGlassBlock) block).getColor().getName(), GTValues.LV, false);
        ((ITierBlock) block).setTierType(type);
        BlockMaps.ALL_GLASSES.put(type, () -> block);
    }
}
