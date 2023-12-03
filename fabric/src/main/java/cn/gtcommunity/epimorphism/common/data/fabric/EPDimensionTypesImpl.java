package cn.gtcommunity.epimorphism.common.data.fabric;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.common.worldgen.SuperSpaceLevelSource;
import com.gregtechceu.gtceu.api.registry.GTRegistries;
import net.minecraft.core.registries.BuiltInRegistries;

public class EPDimensionTypesImpl {
    public static void initGenerator() {
        GTRegistries.register(BuiltInRegistries.CHUNK_GENERATOR, Epimorphism.id("super_space"), SuperSpaceLevelSource.CODEC);
    }
}
