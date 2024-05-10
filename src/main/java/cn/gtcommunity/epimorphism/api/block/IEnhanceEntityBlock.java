package cn.gtcommunity.epimorphism.api.block;

import cn.gtcommunity.epimorphism.api.blockentity.EnhanceBlockEntityType;
import cn.gtcommunity.epimorphism.api.blockentity.IEnhanceBlockEntity;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public interface IEnhanceEntityBlock extends EntityBlock {

    @Nullable
    @Override
    @SuppressWarnings("unchecked")
    default <TE extends BlockEntity> BlockEntityTicker<TE> getTicker(Level level, BlockState state, BlockEntityType<TE> type) {
        if (type instanceof EnhanceBlockEntityType<?> enhanceType && enhanceType.isTicking()) {
            return (l, p, s, t) -> {
                if (t instanceof IEnhanceBlockEntity enhanceBlockEntity) {
                    enhanceBlockEntity.tick();
                }
            };
        }
        return EntityBlock.super.getTicker(level, state, type);
    }
}
