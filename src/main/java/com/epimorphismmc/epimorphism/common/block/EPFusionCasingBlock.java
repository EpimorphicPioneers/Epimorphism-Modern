package com.epimorphismmc.epimorphism.common.block;

import com.epimorphismmc.epimorphism.Epimorphism;
import com.epimorphismmc.epimorphism.common.data.EPBlocks;

import com.gregtechceu.gtceu.api.block.IFusionCasingType;
import com.gregtechceu.gtceu.common.block.FusionCasingBlock;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.block.Block;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.common.data.GTBlocks.*;

public class EPFusionCasingBlock extends FusionCasingBlock {
    public EPFusionCasingBlock(Properties properties, IFusionCasingType casingType) {
        super(properties, casingType);
    }

    public static Block getCasingState(int tier) {
        return switch (tier) {
            case LuV -> FUSION_CASING.get();
            case ZPM -> FUSION_CASING_MK2.get();
            case UV -> FUSION_CASING_MK3.get();
            case UHV -> EPBlocks.FUSION_CASING_MK4.get();
            default -> EPBlocks.FUSION_CASING_MK5.get();
        };
    }

    public static IFusionCasingType getCasingType(int tier) {
        return switch (tier) {
            case LuV -> FusionCasingBlock.CasingType.FUSION_CASING;
            case ZPM -> FusionCasingBlock.CasingType.FUSION_CASING_MK2;
            case UV -> FusionCasingBlock.CasingType.FUSION_CASING_MK3;
            case UHV -> EPFusionCasingBlock.CasingType.FUSION_CASING_MK4;
            default -> EPFusionCasingBlock.CasingType.FUSION_CASING_MK5;
        };
    }

    public enum CasingType implements IFusionCasingType, StringRepresentable {
        FUSION_CASING_MK4("fusion_casing_mk4", 3),
        FUSION_CASING_MK5("fusion_casing_mk5", 3);

        private final String name;

        @Getter
        private final int harvestLevel;

        CasingType(String name, int harvestLevel) {
            this.name = name;
            this.harvestLevel = harvestLevel;
        }

        @Override
        public @NotNull String getSerializedName() {
            return this.name;
        }

        @Override
        public ResourceLocation getTexture() {
            return Epimorphism.id("block/casings/fusion/%s".formatted(this.name));
        }
    }
}
