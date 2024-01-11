package cn.gtcommunity.epimorphism.core.mixins.mc;

import cn.gtcommunity.epimorphism.common.data.EPBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.BiConsumer;

@Mixin(TrunkPlacer.class)
public abstract class TrunkPlacerMixin {
    @Inject(
            method = "setDirtAt(Lnet/minecraft/world/level/LevelSimulatedReader;Ljava/util/function/BiConsumer;Lnet/minecraft/util/RandomSource;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/levelgen/feature/configurations/TreeConfiguration;)V",
            at = @At(
                    value = "HEAD"
            ),
            cancellable = true
    )
    private static void setDirtAt(LevelSimulatedReader level, BiConsumer<BlockPos, BlockState> blockSetter, RandomSource random, BlockPos pos, TreeConfiguration config, CallbackInfo ci) {
        if (level.isStateAtPosition(pos, state -> state.is(EPBlocks.FERTILIZED_DIRT.get()))) {
            ci.cancel();
        }
    }
}
