package com.epimorphismmc.epimorphism.api.block.tier;

import com.epimorphismmc.monomorphism.block.tier.ITierType;

import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nonnull;

public interface IChemicalPlantCasing extends ITierType {
    ResourceLocation texture();

    record CPCasingType(String typeName, int tier, ResourceLocation texture)
            implements IChemicalPlantCasing {
        @Nonnull
        @Override
        public String toString() {
            return typeName();
        }
    }
}
