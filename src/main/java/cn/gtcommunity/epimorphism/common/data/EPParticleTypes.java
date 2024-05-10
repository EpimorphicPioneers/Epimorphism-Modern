package cn.gtcommunity.epimorphism.common.data;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.client.particle.CropParticleData;
import com.mojang.serialization.Codec;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;

public class EPParticleTypes {
    private static final DeferredRegister<ParticleType<?>> PARTICLE_TYPE_REGISTER = DeferredRegister.create(Registries.PARTICLE_TYPE, Epimorphism.MOD_ID);

    public static final ParticleType<CropParticleData> CROP = new ParticleType<>(false,
            CropParticleData.DESERIALIZER) {
        @Override
        public Codec<CropParticleData> codec() {
            return null;
        }
    };

    public static void init() {
        initParticleTypes();
    }

    public static void register(IEventBus bus) {
        PARTICLE_TYPE_REGISTER.register(bus);
    }

    public static void initParticleTypes() {
        PARTICLE_TYPE_REGISTER.register("crop_fx", () -> CROP);
    }
}
