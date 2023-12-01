package cn.gtcommunity.epimorphism.api.block;

import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class IntegerTierType<T extends Block> extends TierType<T> {

    private final int tier;

    public IntegerTierType(Supplier<T> supplier, int tier) {
        super(supplier);
        this.tier = tier;
    }

    @Override
    public Integer getTier() {
        return tier;
    }
}
