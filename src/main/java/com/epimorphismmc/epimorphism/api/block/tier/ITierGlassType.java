package com.epimorphismmc.epimorphism.api.block.tier;

import com.epimorphismmc.monomorphism.block.tier.ITierType;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.client.util.TooltipHelper;

import net.minecraft.network.chat.Component;

import javax.annotation.Nonnull;

public interface ITierGlassType extends ITierType {

    boolean isOpticalGlass();

    default long getTireVoltage() {
        return GTValues.V[tier()];
    }

    default String getTireName() {
        return GTValues.VN[tier()];
    }

    default String getTireNameColored() {
        return GTValues.VNF[tier()];
    }

    default int getOpticalGlassTier() {
        return (int) (Math.floor(tier() / 2D) + tier() % 2 - 2);
    }

    default Component getOpticalTierName() {
        return Component.translatable("epimorphism.optical_glass_tier.desc." + getOpticalGlassTier())
                .withStyle(TooltipHelper.BLINKING_CYAN.getCurrent());
    }

    record SimpleTierGlassType(String typeName, int tier, boolean isOpticalGlass)
            implements ITierGlassType {

        @Nonnull
        @Override
        public String toString() {
            return typeName();
        }
    }
}
