package cn.gtcommunity.epimorphism.api.block;

import cn.gtcommunity.epimorphism.api.blockentity.EnhanceBlockEntityBase;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public abstract class EnhanceEntityBlock<T extends EnhanceBlockEntityBase> extends EnhanceBlockBase implements IEnhanceEntityBlock {
    public EnhanceEntityBlock(Properties properties) {
        super(properties);
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int id, int data) {
        super.triggerEvent(state, world, pos, id, data);
        BlockEntity tile = world.getBlockEntity(pos);
        return tile != null && tile.triggerEvent(id, data);
    }
}
