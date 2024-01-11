package cn.gtcommunity.epimorphism.common.block;

import cn.gtcommunity.epimorphism.common.data.EPBlocks;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.PlantType;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class FertilizedDirtBlock extends Block {
    public FertilizedDirtBlock(Properties properties)
    {
        super(properties);
    }

    @Override
    public BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        if (toolAction.equals(ToolActions.HOE_TILL) && context.getLevel().getBlockState(context.getClickedPos().above()).isAir()) {
            return EPBlocks.FERTILIZED_FARMLAND.get().defaultBlockState();
        }
        return null;
    }

    @Override
    public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction facing, IPlantable plantable) {
        var plantType = plantable.getPlantType(world, pos.relative(facing));
        return plantType != PlantType.CROP && plantType != PlantType.NETHER && plantType != PlantType.WATER;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!level.isClientSide()) {
            BlockPos abovePos = pos.above();
            BlockState aboveState = level.getBlockState(abovePos);
            Block aboveBlock = aboveState.getBlock();

            // Do nothing if the plant is unaffected by rich soil
            if (/*aboveState.is(TagsRegistry.UNAFFECTED_BY_RICH_SOIL) || */aboveBlock instanceof TallFlowerBlock) {
                return;
            }

            // Try to convert mushrooms to colonies if it's dark enough or if is a plant, then give it growth boost
            if ((aboveBlock instanceof BonemealableBlock crop /*&& EPMathUtil.RAND.nextFloat() <= 0.5*/
                    && crop.isValidBonemealTarget(level, pos.above(), aboveState, false))) {
                crop.performBonemeal(level, level.getRandom(), pos.above(), aboveState);
                level.globalLevelEvent(LevelEvent.PARTICLES_PLANT_GROWTH, pos.above(), 0);
            }
        }
    }
}
