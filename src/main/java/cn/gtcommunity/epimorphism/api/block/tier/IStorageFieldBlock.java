package cn.gtcommunity.epimorphism.api.block.tier;

import cn.gtcommunity.epimorphism.api.block.tier.ITierType;

public interface IStorageFieldBlock extends ITierType {
    long getCapacity();
    int getCost();
}
