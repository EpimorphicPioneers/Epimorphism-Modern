package cn.gtcommunity.epimorphism.core.mixins.mc;

import cn.gtcommunity.epimorphism.client.dimension.ClientModSkies;
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
        if (ClientModSkies.DIMENSION_SPECIAL_EFFECTS.containsKey(type.effectsLocation())) {
            cir.setReturnValue(ClientModSkies.DIMENSION_SPECIAL_EFFECTS.get(type.effectsLocation()));
        }
    }
}
