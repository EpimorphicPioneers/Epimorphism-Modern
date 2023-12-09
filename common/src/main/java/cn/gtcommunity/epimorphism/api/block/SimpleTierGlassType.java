package cn.gtcommunity.epimorphism.api.block;

import cn.gtcommunity.epimorphism.api.block.ITierGlassType;

import javax.annotation.Nonnull;

public record SimpleTierGlassType(String typeName, int tier, boolean isOpticalGlass) implements ITierGlassType {

    @Nonnull
    @Override
    public String toString() {
        return typeName();
    }
}
