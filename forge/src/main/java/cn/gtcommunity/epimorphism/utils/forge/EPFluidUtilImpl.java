package cn.gtcommunity.epimorphism.utils.forge;

import com.lowdragmc.lowdraglib.client.model.ModelFactory;
import com.lowdragmc.lowdraglib.side.fluid.FluidStack;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import org.jetbrains.annotations.Nullable;

import static com.lowdragmc.lowdraglib.side.fluid.forge.FluidHelperImpl.*;

public class EPFluidUtilImpl {
    @OnlyIn(Dist.CLIENT)
    @Nullable
    public static TextureAtlasSprite getFlowingTexture(FluidStack fluidStack) {
        var texture = IClientFluidTypeExtensions.of(fluidStack.getFluid()).getFlowingTexture(toFluidStack(fluidStack));
        return texture == null ? null : ModelFactory.getBlockSprite(texture);
    }
}
