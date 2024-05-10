package cn.gtcommunity.epimorphism.api.block.tier;

import cn.gtcommunity.epimorphism.api.block.tier.ITierType;

import java.math.BigInteger;

public interface IFluidTankCell extends ITierType {
    BigInteger getCapacity();
}
