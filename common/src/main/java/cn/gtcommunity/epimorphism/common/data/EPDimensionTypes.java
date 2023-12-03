package cn.gtcommunity.epimorphism.common.data;

import cn.gtcommunity.epimorphism.Epimorphism;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.dimension.DimensionType;

public class EPDimensionTypes {
    public static final ResourceKey<DimensionType> SUPER_SPACE_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE, Epimorphism.id("super_space"));

    public static void init() {
        initGenerator();
    }

    @ExpectPlatform
    public static void initGenerator() {
        throw new AssertionError();
    }
}
