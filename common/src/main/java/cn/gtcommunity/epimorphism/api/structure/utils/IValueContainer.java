package cn.gtcommunity.epimorphism.api.structure.utils;

import cn.gtcommunity.epimorphism.api.structure.block.tier.ITierType;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

public interface IValueContainer<T> {
    void operate(Block block, ITierType data);
    T getValue();

    static IValueContainer<Object> noop() {
        return new NOOP();
    }

    class NOOP implements IValueContainer<Object> {

        @Override
        public void operate(Block block, ITierType data) {/**/}

        @Override
        public @Nullable Object getValue() {
            return null;
        }
    }
}
