package cn.gtcommunity.epimorphism.core;

import cn.gtcommunity.epimorphism.api.block.ITierType;

public interface ITierBlockType {
    default ITierType getTierType() {
        return null;
    }

    default void setType(ITierType type) {/**/}
}
