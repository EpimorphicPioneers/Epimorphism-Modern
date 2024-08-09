package com.epimorphismmc.epimorphism.core.mixins.gtm;

import com.epimorphismmc.epimorphism.EpimorphismCommon;
import com.epimorphismmc.epimorphism.common.data.EPCreativeModeTabs;

import com.gregtechceu.gtceu.common.data.GTFluids;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = GTFluids.class, remap = false)
public abstract class GTFluidsMixin {

    @Inject(
            method = "init",
            at =
                    @At(
                            value = "INVOKE",
                            target =
                                    "Lcom/gregtechceu/gtceu/api/registry/registrate/GTRegistrate;creativeModeTab(Ljava/util/function/Supplier;)V",
                            ordinal = 0))
    private static void setFluidCreativeModeTab(CallbackInfo ci) {
        EpimorphismCommon.registrate().creativeModeTab(() -> EPCreativeModeTabs.EP_MATERIAL_FLUID);
    }
}
