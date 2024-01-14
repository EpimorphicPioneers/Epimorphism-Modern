package cn.gtcommunity.epimorphism.common.block;

import cn.gtcommunity.epimorphism.api.block.IChemicalPlantCasing;
import cn.gtcommunity.epimorphism.api.block.ITierGlassType;
import cn.gtcommunity.epimorphism.api.structure.block.tier.ITierType;
import cn.gtcommunity.epimorphism.api.structure.block.tier.WrappedTierType;
import cn.gtcommunity.epimorphism.core.ITierBlockType;
import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTValues;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StainedGlassBlock;

import java.util.Map;
import java.util.function.Supplier;

import static cn.gtcommunity.epimorphism.common.block.BlockMaps.*;
import static com.gregtechceu.gtceu.common.data.GTBlocks.*;
import static net.minecraft.world.level.block.Blocks.*;

public class BlockTypeAdditions {
    public static void init() {
        {
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


        {
            //  ALL_CP_TUBES Init
            simpleTierTypeAdd(ALL_CP_TUBES, CASING_BRONZE_PIPE, 1);
            simpleTierTypeAdd(ALL_CP_TUBES, CASING_STEEL_PIPE, 2);
            simpleTierTypeAdd(ALL_CP_TUBES, CASING_TITANIUM_PIPE, 5);
            simpleTierTypeAdd(ALL_CP_TUBES, CASING_TUNGSTENSTEEL_PIPE, 6);

            //  ALL_CP_CASINGS Init
            CPTierTypeAdd(CASING_BRONZE_BRICKS, 1, GTCEu.id("block/casings/solid/machine_casing_bronze_plated_bricks"));
            CPTierTypeAdd(CASING_STEEL_SOLID, 2, GTCEu.id("block/casings/solid/machine_casing_solid_steel"));
            CPTierTypeAdd(CASING_ALUMINIUM_FROSTPROOF, 3, GTCEu.id("block/casings/solid/machine_casing_frost_proof"));
            CPTierTypeAdd(CASING_STAINLESS_CLEAN, 4, GTCEu.id("block/casings/solid/machine_casing_clean_stainless_steel"));
            CPTierTypeAdd(CASING_TITANIUM_STABLE, 5, GTCEu.id("block/casings/solid/machine_casing_stable_titanium"));
            CPTierTypeAdd(CASING_TUNGSTENSTEEL_ROBUST, 6, GTCEu.id("block/casings/solid/machine_casing_robust_tungstensteel"));
        }
    }

    private static void glassTierTypeAdd(Block block, ITierGlassType type) {
        ((ITierBlockType) block).setType(type);
        BlockMaps.ALL_GLASSES.put(type, () -> block);
        BlockMaps.SHAPE_GLASSES.put(type, () -> block);
    }

    private static void glassTierTypeAdd(Supplier<Block> blockSupplier, ITierGlassType type) {
        var block = blockSupplier.get();
        glassTierTypeAdd(block, type);
    }
    
    private static void stainedGlassTierTypeAdd(Block block) {
        ITierGlassType type = new ITierGlassType.SimpleTierGlassType(((StainedGlassBlock)block).getColor().getName(), GTValues.LV, false);
        ((ITierBlockType) block).setType(type);
        BlockMaps.ALL_GLASSES.put(type, () -> block);
    }

    private static void simpleTierTypeAdd(Map<ITierType, Supplier<Block>> map, Supplier<Block> blockSupplier, int tier) {
        map.put(new WrappedTierType<>(blockSupplier, tier), blockSupplier);
    }

    private static void CPTierTypeAdd(Supplier<Block> blockSupplier, int tier, ResourceLocation location) {
        ALL_CP_CASINGS.put(new IChemicalPlantCasing.CPCasingType(blockSupplier.get().getDescriptionId(), tier, location), blockSupplier);
    }
}
