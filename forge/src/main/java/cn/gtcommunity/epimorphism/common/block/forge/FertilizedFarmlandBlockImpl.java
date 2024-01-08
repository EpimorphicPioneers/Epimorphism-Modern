package cn.gtcommunity.epimorphism.common.block.forge;

import cn.gtcommunity.epimorphism.common.block.FertilizedFarmlandBlock;
import cn.gtcommunity.epimorphism.common.data.EPBlocks;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.PlantType;

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

    @Override
    public boolean isFertile(BlockState state, BlockGetter world, BlockPos pos) {
        return state.is(EPBlocks.FERTILIZED_FARMLAND.get());
    }

    @Override
    public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction facing, IPlantable plantable) {
        var plantType = plantable.getPlantType(world, pos.relative(facing));
        return plantType == PlantType.CROP || plantType == PlantType.PLAINS;
    }
}
