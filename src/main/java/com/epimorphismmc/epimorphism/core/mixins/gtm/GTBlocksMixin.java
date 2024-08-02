package com.epimorphismmc.epimorphism.core.mixins.gtm;

import com.epimorphismmc.epimorphism.Epimorphism;
import com.epimorphismmc.epimorphism.common.data.EPCreativeModeTabs;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = GTBlocks.class, remap = false)
@Debug(export = true)
public class GTBlocksMixin {
    @Inject(
            method = "init",
            at = @At(value = "INVOKE", target = "Lcom/gregtechceu/gtceu/api/registry/registrate/GTRegistrate;creativeModeTab(Ljava/util/function/Supplier;)V", ordinal = 0)
    )
    private static void setBlockCreativeModeTab(CallbackInfo ci) {
        Epimorphism.registrate().creativeModeTab(() -> EPCreativeModeTabs.EP_MATERIAL_BLOCK);
    }

    @Inject(
            method = "init",
            at = @At(value = "INVOKE", target = "Lcom/gregtechceu/gtceu/api/registry/registrate/GTRegistrate;creativeModeTab(Ljava/util/function/Supplier;)V", ordinal = 1)
    )
    private static void setPipeCreativeModeTab(CallbackInfo ci) {
        Epimorphism.registrate().creativeModeTab(() -> EPCreativeModeTabs.EP_MATERIAL_PIPE);
    }
}
