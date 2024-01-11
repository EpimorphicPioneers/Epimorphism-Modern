package cn.gtcommunity.epimorphism.common.data;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.common.worldgen.SuperSpaceLevelSource;
import com.mojang.serialization.Codec;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;

public class EPDimensionTypes {
    private static final DeferredRegister<Codec<? extends ChunkGenerator>> CHUNK_GENERATOR_REGISTER = DeferredRegister.create(Registries.CHUNK_GENERATOR, Epimorphism.MOD_ID);
    public static final ResourceKey<DimensionType> SUPER_SPACE_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE, Epimorphism.id("super_space"));

    public static void init() {
        initGenerator();
    }

    public static void register(IEventBus bus) {
        CHUNK_GENERATOR_REGISTER.register(bus);
    }

    public static void initGenerator() {
        CHUNK_GENERATOR_REGISTER.register(EPBiomes.SUPER_SPACE.location().getPath(), () -> SuperSpaceLevelSource.CODEC);
    }
}
