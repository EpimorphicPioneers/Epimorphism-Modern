package cn.gtcommunity.epimorphism.common.block;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.common.data.EPBlocks;
import cn.gtcommunity.epimorphism.utils.EPMathUtil;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.piston.MovingPistonBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class FertilizedDirtBlock extends Block {
    protected FertilizedDirtBlock(Properties properties)
    {
        super(properties);
    }

    @ExpectPlatform
    public static Block create(Properties properties) {
        throw new AssertionError();
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
