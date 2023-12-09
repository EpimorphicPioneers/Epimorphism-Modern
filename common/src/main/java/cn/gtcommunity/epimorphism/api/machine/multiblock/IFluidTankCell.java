package cn.gtcommunity.epimorphism.api.machine.multiblock;

import cn.gtcommunity.epimorphism.api.structure.block.tier.ITierType;

import java.math.BigInteger;

public interface IFluidTankCell extends ITierType {
    BigInteger getCapacity();
}
