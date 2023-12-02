package cn.gtcommunity.epimorphism.api.block;

import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nonnull;

public class SimpleTierGlassType implements ITierGlassType{

    private final String name;
    private final int tier;
    private final boolean isOpticalGlass;

    public SimpleTierGlassType(String name, int tier, boolean isOpticalGlass) {
        this.name = name;
        this.tier = tier;
        this.isOpticalGlass = isOpticalGlass;
    }

    @Override
    public boolean isOpticalGlass() {
        return isOpticalGlass;
    }

    @Override
    public int getGlassTier() {
        return tier;
    }

    @Override
    public String getGlassName() {
        return name;
    }

    @Override
    public ResourceLocation getTexture() {
        return null;
    }

    @Nonnull
    @Override
    public String toString() {
        return getName();
    }
}
