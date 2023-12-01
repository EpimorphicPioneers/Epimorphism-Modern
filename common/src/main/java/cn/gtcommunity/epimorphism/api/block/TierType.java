package cn.gtcommunity.epimorphism.api.block;

import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class TierType<T extends Block> implements ITierType {

    private final Supplier<T> supplier;

    public TierType(Supplier<T> supplier) {
        this.supplier = supplier;
    }

    @Override
    public String getName() {
        return supplier.get().getDescriptionId();
    }
}
