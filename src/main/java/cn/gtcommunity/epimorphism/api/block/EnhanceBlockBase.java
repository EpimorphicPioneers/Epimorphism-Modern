package cn.gtcommunity.epimorphism.api.block;

import cn.gtcommunity.epimorphism.api.block.property.EnhanceProperty;
import cn.gtcommunity.epimorphism.api.block.property.EnhancePropertyConfiguration;
import com.mojang.blaze3d.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class EnhanceBlockBase extends Block {

    public EnhanceBlockBase(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getPropertyConfiguration().defineDefault(this.getStateDefinition().any()));
    }

    @Override
    protected final void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        this.getPropertyConfiguration().fillStateContainer(builder);
    }

    protected abstract EnhancePropertyConfiguration getPropertyConfiguration();

    @Override
    @Deprecated
    @SuppressWarnings("deprecation")
    public final BlockState rotate(BlockState state, Rotation rot) {
        return this.getPropertyConfiguration().handleRotation(state, rot);
    }

    @Override
    @Deprecated
    @SuppressWarnings("deprecation")
    public final BlockState mirror(BlockState state, Mirror mirror) {
        return this.getPropertyConfiguration().handleMirror(state, mirror);
    }

    @Override
    @Deprecated
    @SuppressWarnings("deprecation")
    public FluidState getFluidState(BlockState state) {
        if(this.getPropertyConfiguration().isWaterLoggable()) {
            if(EnhanceProperty.Defaults.waterlogged().fetch(state)) {
                return Fluids.WATER.getSource(false);
            }
        }
        if(this.getPropertyConfiguration().isLavaLoggable()) {
            if(EnhanceProperty.Defaults.lavalogged().fetch(state)) {
                return Fluids.LAVA.getSource(false);
            }
        }
        if(this.getPropertyConfiguration().isFluidLoggable()) {
            return EnhanceProperty.Defaults.fluidlogged().fetch(state).getFluid().defaultFluidState();
        }
        return super.getFluidState(state);
    }

    @Override
    @Deprecated
    @SuppressWarnings("deprecation")
    public BlockState updateShape(BlockState ownState, Direction dir, BlockState otherState, LevelAccessor world, BlockPos pos, BlockPos otherPos) {
        if (this.getPropertyConfiguration().isWaterLoggable() && EnhanceProperty.Defaults.waterlogged().fetch(ownState)) {
            world.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
        }
        if (this.getPropertyConfiguration().isLavaLoggable() && EnhanceProperty.Defaults.lavalogged().fetch(ownState)) {
            world.scheduleTick(pos, Fluids.LAVA, Fluids.LAVA.getTickDelay(world));
        }
        if (this.getPropertyConfiguration().isFluidLoggable()) {
            Fluid fluid = EnhanceProperty.Defaults.fluidlogged().fetch(ownState).getFluid();
            if(fluid != Fluids.EMPTY) {
                world.scheduleTick(pos, fluid, fluid.getTickDelay(world));
            }
        }
        return super.updateShape(ownState, dir, otherState, world, pos, otherPos);
    }

    public final BlockState fluidlog(BlockState state, Level world, BlockPos pos) {
        if(this.getPropertyConfiguration().isWaterLoggable()) {
            FluidState fluid = world.getFluidState(pos);
            state = EnhanceProperty.Defaults.waterlogged().apply(state, fluid.getType() == Fluids.WATER);
        }
        if(this.getPropertyConfiguration().isLavaLoggable()) {
            FluidState fluid = world.getFluidState(pos);
            state = EnhanceProperty.Defaults.lavalogged().apply(state, fluid.getType() == Fluids.LAVA);
        }
        if(this.getPropertyConfiguration().isFluidLoggable()) {
            FluidState fluid = world.getFluidState(pos);
            state = EnhanceProperty.Defaults.fluidlogged().apply(state, EnhanceProperty.FluidLogged.get(fluid));
        }
        return state;
    }

    public boolean addToInventoryOrDrop(ItemStack stack, Level world, BlockPos pos, @Nullable Player player) {
        if(player != null) {
            if(player.addItem(stack)) {
                return true;
            }
        }
        ItemEntity entity = new ItemEntity(world, pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D, stack);
        return world.addFreshEntity(entity);
    }
}
