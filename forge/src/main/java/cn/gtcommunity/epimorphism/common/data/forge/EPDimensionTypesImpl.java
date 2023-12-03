package cn.gtcommunity.epimorphism.common.data.forge;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.common.data.EPBiomes;
import cn.gtcommunity.epimorphism.common.worldgen.SuperSpaceLevelSource;
import com.mojang.serialization.Codec;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;

public class EPDimensionTypesImpl {
    private static final DeferredRegister<Codec<? extends ChunkGenerator>> CHUNK_GENERATOR_REGISTER = DeferredRegister.create(Registries.CHUNK_GENERATOR, Epimorphism.MOD_ID);

    public static void register(IEventBus bus) {
        CHUNK_GENERATOR_REGISTER.register(bus);
    }

    public static void initGenerator() {
        CHUNK_GENERATOR_REGISTER.register(EPBiomes.SUPER_SPACE.location().getPath(), () -> SuperSpaceLevelSource.CODEC);
    }
}
