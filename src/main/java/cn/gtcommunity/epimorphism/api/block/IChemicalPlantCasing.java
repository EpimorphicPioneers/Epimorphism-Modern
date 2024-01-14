package cn.gtcommunity.epimorphism.api.block;

import cn.gtcommunity.epimorphism.api.structure.block.tier.ITierType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nonnull;

public interface IChemicalPlantCasing extends ITierType {
    ResourceLocation texture();

    record CPCasingType(String typeName, int tier, ResourceLocation texture) implements IChemicalPlantCasing {
        @Nonnull
        @Override
        public String toString() {
            return typeName();
        }
    }
}
