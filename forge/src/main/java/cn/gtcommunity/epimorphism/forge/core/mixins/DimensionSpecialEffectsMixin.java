package cn.gtcommunity.epimorphism.forge.core.mixins;

import cn.gtcommunity.epimorphism.client.dimension.forge.ClientModSkiesImpl;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.world.level.dimension.DimensionType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DimensionSpecialEffects.class)
public class DimensionSpecialEffectsMixin {
    @Inject(
            method = "forType",
            at = @At(
                    value = "HEAD"
            ),
            cancellable = true
    )
    private static void forType(DimensionType type, CallbackInfoReturnable<DimensionSpecialEffects> cir) {
        if (ClientModSkiesImpl.DIMENSION_SPECIAL_EFFECTS.containsKey(type.effectsLocation())) {
            cir.setReturnValue(ClientModSkiesImpl.DIMENSION_SPECIAL_EFFECTS.get(type.effectsLocation()));
        }
    }
}
