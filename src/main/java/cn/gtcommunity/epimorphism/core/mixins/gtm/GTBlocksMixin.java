package cn.gtcommunity.epimorphism.core.mixins.gtm;

import cn.gtcommunity.epimorphism.api.block.tier.WrappedTierType;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static cn.gtcommunity.epimorphism.common.block.BlockMaps.*;

@Mixin(value = GTBlocks.class, remap = false)
public abstract class GTBlocksMixin {
    @Inject(
            method = "createMachineCasingBlock(I)Lcom/tterrag/registrate/util/entry/BlockEntry;",
            at = @At(
                    value = "TAIL"
            )
    )
    private static void createMachineCasingBlock(int tier, CallbackInfoReturnable<BlockEntry<Block>> cir) {
        var block = cir.getReturnValue();
        ALL_MACHINE_CASINGS.put(new WrappedTierType<>(block, tier), block);
    }
}
