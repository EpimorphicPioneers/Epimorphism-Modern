package cn.gtcommunity.epimorphism.fabric.core.mixins.mc;

import cn.gtcommunity.epimorphism.common.data.EPBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({PitcherCropBlock.class, CropBlock.class, AttachedStemBlock.class, StemBlock.class})
public abstract class CropsMixin extends BushBlock {
    public CropsMixin(Properties properties) {
        super(properties);
    }

    @Inject(
            method = "mayPlaceOn",
            at = @At(
                    value = "TAIL"
            ),
            cancellable = true
    )
    private void mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        if (state.is(EPBlocks.FERTILIZED_FARMLAND.get())) {
            cir.setReturnValue(true);
        }
    }
}
