package cn.gtcommunity.epimorphism.common.block.forge;

import cn.gtcommunity.epimorphism.common.block.FertilizedDirtBlock;
import cn.gtcommunity.epimorphism.common.data.EPBlocks;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.PlantType;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class FertilizedDirtBlockImpl extends FertilizedDirtBlock {
    protected FertilizedDirtBlockImpl(Properties properties) {
        super(properties);
    }

    public static Block create(BlockBehaviour.Properties properties) {
        return new FertilizedDirtBlockImpl(properties);
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
}
