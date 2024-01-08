package cn.gtcommunity.epimorphism.common.block.fabric;

import cn.gtcommunity.epimorphism.common.block.FertilizedFarmlandBlock;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class FertilizedFarmlandBlockImpl extends FertilizedFarmlandBlock {
    protected FertilizedFarmlandBlockImpl(Properties properties) {
        super(properties);
    }

    public static Block create(BlockBehaviour.Properties properties) {
        return new FertilizedFarmlandBlockImpl(properties);
    }
}
