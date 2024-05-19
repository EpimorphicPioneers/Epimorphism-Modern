package cn.gtcommunity.epimorphism.api.pattern.utils;

import cn.gtcommunity.epimorphism.api.block.tier.IFluidTankCell;
import com.epimorphismmc.monomorphism.block.tier.ITierType;
import com.epimorphismmc.monomorphism.pattern.utils.containers.SimpleValueContainer;
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
    public void operate(Block block, Object data) {
        super.operate(block, data);
        if (data instanceof ITierType tierType) {
            maxTier = Math.max(maxTier, tierType.tier());
        }
    }
}