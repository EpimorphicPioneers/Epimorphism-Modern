package cn.gtcommunity.epimorphism.api.block;

import cn.gtcommunity.epimorphism.api.structure.block.tier.ITierType;

public interface IStorageFieldBlock extends ITierType {
    long getCapacity();
    int getCost();
}
