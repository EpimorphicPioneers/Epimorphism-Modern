package cn.gtcommunity.epimorphism.utils;

import com.lowdragmc.lowdraglib.client.model.ModelFactory;
import com.lowdragmc.lowdraglib.side.fluid.FluidStack;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;

import javax.annotation.Nullable;

import java.util.function.Predicate;

import static com.lowdragmc.lowdraglib.side.fluid.forge.FluidHelperImpl.toFluidStack;

public class EPFluidUtil {
    private static final Fluid EMPTY = BuiltInRegistries.FLUID.get(BuiltInRegistries.FLUID.getDefaultKey());

    public static final Predicate<Fluid> ANY_FLUID = fluid -> true;

    public static final Predicate<Fluid> NOT_LAVA = fluid -> !fluid.equals(Fluids.LAVA);

    @OnlyIn(Dist.CLIENT)
    @Nullable
    public static TextureAtlasSprite getFlowingTexture(FluidStack fluidStack) {
        var texture = IClientFluidTypeExtensions.of(fluidStack.getFluid()).getFlowingTexture(toFluidStack(fluidStack));
        return texture == null ? null : ModelFactory.getBlockSprite(texture);
    }

    public static Fluid stringToFluid(String name) {
        ResourceLocation fluidName = new ResourceLocation(name);
        return BuiltInRegistries.FLUID.get(fluidName);
    }

    public static String fluidToString(Fluid fluid) {
        return BuiltInRegistries.FLUID.getKey(fluid).toString();
    }

    public static String fluidToName(Fluid fluid) {
        return FluidStack.create(fluid, 1).getDisplayName().getString();
    }

    public static Fluid getDefaultFluid() {
        return EMPTY;
    }

    public static boolean isDefaultFluid(Fluid fluid) {
        return EMPTY.isSame(fluid);
    }

    public static boolean isDefaultFluid(FluidStack fluid) {
        return EMPTY.isSame(fluid.getFluid());
    }
}
