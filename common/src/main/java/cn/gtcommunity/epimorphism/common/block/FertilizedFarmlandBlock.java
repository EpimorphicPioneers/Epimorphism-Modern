package cn.gtcommunity.epimorphism.common.block;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.common.data.EPBlocks;
import cn.gtcommunity.epimorphism.utils.EPMathUtil;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class FertilizedFarmlandBlock extends FarmBlock {
    protected FertilizedFarmlandBlock(Properties properties) {
        super(properties);
        registerDefaultState(getStateDefinition().any().setValue(MOISTURE, MAX_MOISTURE));
    }

    @ExpectPlatform
    public static Block create(Properties properties) {
        throw new AssertionError();
    }

    public static void turnToRichSoil(BlockState state, Level worldIn, BlockPos pos) {
        worldIn.setBlock(pos, pushEntitiesUp(state, EPBlocks.FERTILIZED_DIRT.get().defaultBlockState(), worldIn, pos), Block.UPDATE_ALL);
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
