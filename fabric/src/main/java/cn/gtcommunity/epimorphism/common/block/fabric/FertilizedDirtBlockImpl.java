package cn.gtcommunity.epimorphism.common.block.fabric;

import cn.gtcommunity.epimorphism.common.block.FertilizedDirtBlock;
import cn.gtcommunity.epimorphism.common.data.EPBlocks;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

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
    @SuppressWarnings("deprecation")
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getItemInHand(hand);
        if (itemStack.getItem() instanceof HoeItem && state.is(EPBlocks.FERTILIZED_DIRT.get()) &&
                hit.getDirection() != Direction.DOWN && level.getBlockState(pos.above()).isAir()) {
            level.playSound(player, pos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.f, 1.f);
            if (!level.isClientSide()) {
                level.setBlock(pos, EPBlocks.FERTILIZED_FARMLAND.get().defaultBlockState(), Block.UPDATE_ALL);
                itemStack.hurtAndBreak(1, player, playerEntity -> playerEntity.broadcastBreakEvent(hand));
            }

            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }
}
