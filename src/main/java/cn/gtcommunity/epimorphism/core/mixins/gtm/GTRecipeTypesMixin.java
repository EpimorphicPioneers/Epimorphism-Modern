package cn.gtcommunity.epimorphism.core.mixins.gtm;

import cn.gtcommunity.epimorphism.EPGTAddon;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = GTRecipeTypes.class, remap = false)
public abstract class GTRecipeTypesMixin {
    @Inject(
            method = "init()V",
            at = @At(
                    value = "RETURN"
            )
    )
    private static void init(CallbackInfo ci) {
        EPGTAddon.onPostInitializeRecipeTypes();
    }
}
