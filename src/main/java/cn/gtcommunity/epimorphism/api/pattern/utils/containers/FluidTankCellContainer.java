package cn.gtcommunity.epimorphism.api.pattern.utils.containers;

import cn.gtcommunity.epimorphism.api.block.IFluidTankCell;
import cn.gtcommunity.epimorphism.api.structure.block.tier.ITierType;
import cn.gtcommunity.epimorphism.api.structure.utils.SimpleValueContainer;
import lombok.Getter;
import net.minecraft.world.level.block.Block;

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
    public void operate(Block block, ITierType data) {
        super.operate(block, data);
        maxTier = Math.max(maxTier, data.tier());
    }
}
