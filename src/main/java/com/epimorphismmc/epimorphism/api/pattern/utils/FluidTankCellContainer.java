package com.epimorphismmc.epimorphism.api.pattern.utils;

import com.epimorphismmc.epimorphism.api.block.tier.IFluidTankCell;

import com.epimorphismmc.monomorphism.block.tier.ITierType;
import com.epimorphismmc.monomorphism.pattern.utils.containers.SimpleValueContainer;

import net.minecraft.world.level.block.Block;

import lombok.Getter;

import java.math.BigInteger;

public class FluidTankCellContainer extends SimpleValueContainer<BigInteger> {

    @Getter
    private int maxTier;

    public FluidTankCellContainer() {
        super(BigInteger.ZERO, (value, block, data) -> {
            if (data instanceof IFluidTankCell cellData) {
                value = value.add(cellData.getCapacity());
            }
            return value;
        });
    }

    @Override
    public void operate(Block block, Object data) {
        super.operate(block, data);
        if (data instanceof ITierType tierType) {
            maxTier = Math.max(maxTier, tierType.tier());
        }
    }
}
