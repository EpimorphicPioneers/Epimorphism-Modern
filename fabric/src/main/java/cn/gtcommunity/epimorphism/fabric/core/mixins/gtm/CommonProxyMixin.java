package cn.gtcommunity.epimorphism.fabric.core.mixins.gtm;

import cn.gtcommunity.epimorphism.EPGTAddon;
import cn.gtcommunity.epimorphism.common.block.BlockTypeAdditions;
import com.gregtechceu.gtceu.common.CommonProxy;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = CommonProxy.class, remap = false)
public class CommonProxyMixin {
    @Inject(
            method = "init()V",
            at = @At(
                    value = "INVOKE",
                    target = "Lcom/gregtechceu/gtceu/common/data/GTFeatures;register()V",
                    shift = At.Shift.AFTER
            )
    )
    private static void init(CallbackInfo ci) {
        EPGTAddon.postInitializeAddon();
    }
}
