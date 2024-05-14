package cn.gtcommunity.epimorphism.common.block;

import cn.gtcommunity.epimorphism.common.blockentity.EOHBlockEntity;
import com.epimorphismmc.monomorphism.block.MOEntityBlockBase;
import com.epimorphismmc.monomorphism.block.property.MOPropertyConfiguration;
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

import java.util.function.BiFunction;

import static cn.gtcommunity.epimorphism.common.data.EPBlockEntities.*;
import static cn.gtcommunity.epimorphism.common.data.EPBlocks.EOH_RENDERER_BLOCK;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class EOHRendererBlock extends MOEntityBlockBase<EOHBlockEntity> {
    public EOHRendererBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MOPropertyConfiguration getPropertyConfiguration() {
        return null;
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

    @Override
    public BiFunction<BlockPos, BlockState, EOHBlockEntity> getTileEntityFactory() {
        return null;
    }


}
