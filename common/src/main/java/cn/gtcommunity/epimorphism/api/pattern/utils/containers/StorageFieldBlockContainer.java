package cn.gtcommunity.epimorphism.api.pattern.utils.containers;

import cn.gtcommunity.epimorphism.api.block.IStorageFieldBlock;
import cn.gtcommunity.epimorphism.api.structure.block.tier.ITierType;
import cn.gtcommunity.epimorphism.api.structure.utils.SimpleValueContainer;
import lombok.Getter;
import net.minecraft.world.level.block.Block;

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
    public void operate(Block block, ITierType data) {
        super.operate(block, data);
        blockNumber++;
    }
}
