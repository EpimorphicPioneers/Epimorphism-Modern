package com.epimorphismmc.epimorphism.api.pattern.utils;

import com.epimorphismmc.epimorphism.api.block.tier.IStorageFieldBlock;

import com.epimorphismmc.monomorphism.pattern.utils.containers.SimpleValueContainer;

import net.minecraft.world.level.block.Block;

import lombok.Getter;

import java.math.BigInteger;

public class StorageFieldBlockContainer extends SimpleValueContainer<BigInteger> {
    @Getter
    private int blockNumber;

    public StorageFieldBlockContainer() {
        super(BigInteger.ZERO, (value, block, data) -> {
            if (data instanceof IStorageFieldBlock blockData) {
                value = value.add(BigInteger.valueOf(blockData.getCapacity()));
            }
            return value;
        });
    }

    @Override
    public void operate(Block block, Object data) {
        super.operate(block, data);
        blockNumber++;
    }
}
