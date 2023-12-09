package cn.gtcommunity.epimorphism.api.structure.utils;

import cn.gtcommunity.epimorphism.api.structure.block.tier.ITierType;
import net.minecraft.world.level.block.Block;

public interface IValueContainer {
    void operate(Block block, ITierType data);
    Object getValue();

    static IValueContainer noop() {
        return new NOOP();
    }

    class NOOP implements IValueContainer{

        @Override
        public void operate(Block block, ITierType data) {/**/}

        @Override
        public Object getValue() {
            return null;
        }
    }
}
