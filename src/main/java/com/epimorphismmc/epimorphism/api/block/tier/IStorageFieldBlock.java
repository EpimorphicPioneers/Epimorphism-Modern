package com.epimorphismmc.epimorphism.api.block.tier;

import com.epimorphismmc.monomorphism.block.tier.ITierType;

public interface IStorageFieldBlock extends ITierType {
    long getCapacity();

    int getCost();
}
