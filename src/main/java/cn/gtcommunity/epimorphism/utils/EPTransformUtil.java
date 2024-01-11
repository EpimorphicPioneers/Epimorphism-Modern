package cn.gtcommunity.epimorphism.utils;

import com.google.gson.Gson;
import com.lowdragmc.lowdraglib.side.fluid.FluidStack;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import org.jetbrains.annotations.NotNull;

public class EPTransformUtil {
    private static final Fluid EMPTY = BuiltInRegistries.FLUID.get(BuiltInRegistries.FLUID.getDefaultKey());

    public static final Gson GSON = new Gson();

    //  Fluid
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

    //  Entity
    public static String entityToString(Entity entity) {
        return EntityType.getKey(entity.getType()).toString();
    }

    public static Entity stringToEntity(@NotNull String key, @NotNull Level level, CompoundTag compoundTag, boolean withTag) {
       Entity entity = EntityType.byString(key)
               .filter(EntityType::canSummon)
               .map(type -> level.isClientSide() ? null : type.create(level))
               .orElse(null);

       if (entity != null && withTag) {
           entity.load(compoundTag);
       }

       return entity;
    }
}
