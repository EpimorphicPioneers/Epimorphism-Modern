package com.epimorphismmc.epimorphism.common.block;

import com.epimorphismmc.epimorphism.api.block.tier.ITierGlassType;

import com.epimorphismmc.monomorphism.block.tier.ITierBlock;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.block.RendererGlassBlock;

import com.lowdragmc.lowdraglib.client.renderer.IRenderer;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import javax.annotation.Nonnull;

public class TierGlassBlock extends RendererGlassBlock implements ITierBlock {

    public TierGlassBlock(Properties properties, IRenderer renderer, ITierGlassType glassType) {
        super(properties, renderer);
        setTierType(glassType);
    }

    @Override
    public void appendHoverText(
            @NotNull ItemStack stack,
            @Nullable BlockGetter level,
            @NotNull List<Component> tooltip,
            @NotNull TooltipFlag flag) {
        String id = stack.getDescriptionId();
        tooltip.add(Component.translatable(id + ".desc"));
        super.appendHoverText(stack, level, tooltip, flag);
    }

    public enum GlassType implements ITierGlassType {
        PMMA_GLASS("pmma_glass", GTValues.UHV, false),
        CBDO_POLYCARBONATE_GLASS("cbdo_polycarbonate_glass", GTValues.UIV, false);

        private final String name;
        private final int tier;
        private final boolean isOpticalGlass;

        GlassType(String name, int tier, boolean isOpticalGlass) {
            this.name = name;
            this.tier = tier;
            this.isOpticalGlass = isOpticalGlass;
        }

        @Override
        public boolean isOpticalGlass() {
            return isOpticalGlass;
        }

        @Override
        public int tier() {
            return tier;
        }

        @Override
        public String typeName() {
            return name;
        }

        @Nonnull
        @Override
        public String toString() {
            return typeName();
        }
    }
}
