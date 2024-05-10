package cn.gtcommunity.epimorphism.common.block;

import cn.gtcommunity.epimorphism.common.blockentity.EOHBlockEntity;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

import static cn.gtcommunity.epimorphism.common.data.EPBlockEntities.*;
import static cn.gtcommunity.epimorphism.common.data.EPBlocks.EOH_RENDERER_BLOCK;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class EOHRendererBlock extends Block implements EntityBlock {
    public EOHRendererBlock(Properties properties) {
        super(properties);
    }

//    @Override
//    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
//        return Shapes.empty();
//    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.INVISIBLE;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return EOH_BLOCK_ENTITY.create(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        if (level.isClientSide && blockEntityType == EOH_BLOCK_ENTITY.get()) {
            return (pLevel, pPos, pState, pTile) -> {
                if (pTile instanceof EOHBlockEntity blockEntity) {
                    blockEntity.clientTick();
                }
            };
        }
        return null;
    }

}
