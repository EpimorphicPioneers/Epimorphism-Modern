package cn.gtcommunity.epimorphism.utils;

import com.lowdragmc.lowdraglib.side.fluid.FluidStack;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;

import javax.annotation.Nullable;

public class EPFluidUtil {
    @Nullable
    @ExpectPlatform
    @Environment(EnvType.CLIENT)
    public static TextureAtlasSprite getFlowingTexture(FluidStack fluidStack) {
        throw new AssertionError();
    }
}
