package cn.gtcommunity.epimorphism.common.block;

import cn.gtcommunity.epimorphism.common.data.EPBlocks;
import cn.gtcommunity.epimorphism.utils.EPMathUtil;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.PlantType;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class FertilizedFarmlandBlock extends FarmBlock {
    public FertilizedFarmlandBlock(Properties properties) {
        super(properties);
        registerDefaultState(getStateDefinition().any().setValue(FarmBlock.MOISTURE, FarmBlock.MAX_MOISTURE));
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

    public static void turnToRichSoil(BlockState state, Level worldIn, BlockPos pos) {
        worldIn.setBlock(pos, Block.pushEntitiesUp(state, EPBlocks.FERTILIZED_DIRT.get().defaultBlockState(), worldIn, pos), Block.UPDATE_ALL);
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean canBeReplaced(BlockState state, BlockPlaceContext useContext) {
        return super.canBeReplaced(state, useContext);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockState aboveState = level.getBlockState(pos.above());
        return super.canSurvive(state, level, pos) || aboveState.getBlock() instanceof StemBlock;
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!state.canSurvive(level, pos)) {
            turnToRichSoil(state, level, pos);
        }
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        BlockState aboveState = level.getBlockState(pos.above());
        Block aboveBlock = aboveState.getBlock();

        // Do nothing if the plant is unaffected by rich soil farmland
        if (/*aboveState.isIn(TagsRegistry.UNAFFECTED_BY_RICH_SOIL) || */aboveBlock instanceof TallFlowerBlock) {
            return;
        }

        // If all else fails, and it's a plant, give it a growth boost now and then!
        if ((aboveBlock instanceof BonemealableBlock crop && EPMathUtil.RAND.nextFloat() <= 0.5
                && crop.isValidBonemealTarget(level, pos.above(), aboveState, false))) {
            crop.performBonemeal(level, level.getRandom(), pos.above(), aboveState);
            if (!level.isClientSide()) {
                level.globalLevelEvent(LevelEvent.PARTICLES_PLANT_GROWTH, pos.above(), 0);
            }
        }
    }


    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return !defaultBlockState().canSurvive(context.getLevel(), context.getClickedPos()) ? EPBlocks.FERTILIZED_DIRT.get().defaultBlockState() : super.getStateForPlacement(context);
    }

    @Override
    public void fallOn(Level level, BlockState state, BlockPos pos, Entity entity, float fallDistance) {/**/}
}
