//package cn.gtcommunity.epimorphism.common.block;
//
//import cn.gtcommunity.epimorphism.common.blockentity.EOHBlockEntity;
//import com.epimorphismmc.monomorphism.block.MOEntityBlockBase;
//import com.epimorphismmc.monomorphism.block.property.MOPropertyConfiguration;
//import net.minecraft.MethodsReturnNonnullByDefault;
//import net.minecraft.core.BlockPos;
//import net.minecraft.world.level.block.RenderShape;
//import net.minecraft.world.level.block.state.BlockState;
//
//import javax.annotation.ParametersAreNonnullByDefault;
//
//import java.util.function.BiFunction;
//
//import static cn.gtcommunity.epimorphism.common.data.EPBlockEntities.*;
//
//@ParametersAreNonnullByDefault
//@MethodsReturnNonnullByDefault
//public class EOHRendererBlock extends MOEntityBlockBase<EOHBlockEntity> {
//    public EOHRendererBlock(Properties properties) {
//        super(properties);
//    }
//
//    @Override
//    protected MOPropertyConfiguration getPropertyConfiguration() {
//        return null;
//    }
//
////    @Override
////    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
////        return Shapes.empty();
////    }
//
//    @Override
//    public RenderShape getRenderShape(BlockState state) {
//        return RenderShape.INVISIBLE;
//    }
//
//    @Override
//    public EOHBlockEntity newBlockEntity(BlockPos pos, BlockState state) {
//        return EOH_BLOCK_ENTITY.create(pos, state);
//    }
//
//    @Override
//    public BiFunction<BlockPos, BlockState, EOHBlockEntity> getTileEntityFactory() {
//        return null;
//    }
//
//
//}
