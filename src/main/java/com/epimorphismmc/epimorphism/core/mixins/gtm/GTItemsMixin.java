package com.epimorphismmc.epimorphism.core.mixins.gtm;

import com.epimorphismmc.epimorphism.EpimorphismCommon;
import com.epimorphismmc.epimorphism.common.data.EPCreativeModeTabs;

import com.gregtechceu.gtceu.common.data.GTItems;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = GTItems.class, remap = false)
public class GTItemsMixin {

    @Inject(
            method = "generateMaterialItems",
            at =
                    @At(
                            value = "INVOKE",
                            target =
                                    "Lcom/gregtechceu/gtceu/api/registry/registrate/GTRegistrate;creativeModeTab(Ljava/util/function/Supplier;)V",
                            ordinal = 0))
    private static void setItemCreativeModeTab(CallbackInfo ci) {
        EpimorphismCommon.registrate().creativeModeTab(() -> EPCreativeModeTabs.EP_MATERIAL_ITEM);
    }

    @Inject(
            method = "generateTools",
            at =
                    @At(
                            value = "INVOKE",
                            target =
                                    "Lcom/gregtechceu/gtceu/api/registry/registrate/GTRegistrate;creativeModeTab(Ljava/util/function/Supplier;)V",
                            ordinal = 0))
    private static void setToolCreativeModeTab(CallbackInfo ci) {
        EpimorphismCommon.registrate().creativeModeTab(() -> EPCreativeModeTabs.EP_TOOL);
    }
}
