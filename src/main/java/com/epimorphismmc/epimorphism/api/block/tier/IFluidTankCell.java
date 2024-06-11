package com.epimorphismmc.epimorphism.api.block.tier;

import com.epimorphismmc.monomorphism.block.tier.ITierType;

import java.math.BigInteger;

public interface IFluidTankCell extends ITierType {
    BigInteger getCapacity();
}
