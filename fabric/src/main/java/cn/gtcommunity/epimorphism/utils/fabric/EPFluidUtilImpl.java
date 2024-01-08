package cn.gtcommunity.epimorphism.utils.fabric;

import com.lowdragmc.lowdraglib.side.fluid.FluidStack;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import org.jetbrains.annotations.Nullable;

public class EPFluidUtilImpl {
    @Environment(EnvType.CLIENT)
    @Nullable
    public static TextureAtlasSprite getFlowingTexture(FluidStack fluidStack) {
        return FluidRenderHandlerRegistry.INSTANCE.get(fluidStack.getFluid())
                .getFluidSprites(null, null, fluidStack.getFluid().defaultFluidState())[1];
    }
}
