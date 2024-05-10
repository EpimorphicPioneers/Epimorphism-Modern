package cn.gtcommunity.epimorphism.client.particle;

import cn.gtcommunity.epimorphism.common.data.EPParticleTypes;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import lombok.Getter;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.network.FriendlyByteBuf;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class CropParticleData implements ParticleOptions {

    @Getter
    private final int lifeTime;

    public CropParticleData(int lifeTime) {
        this.lifeTime = lifeTime;
    }

    @Override
    public ParticleType<?> getType() {
        return EPParticleTypes.CROP;
    }

    @Override
    public void writeToNetwork(FriendlyByteBuf buffer) {
        buffer.writeVarInt(lifeTime);
    }

    @Override
    public String writeToString() {
        return String.valueOf(lifeTime);
    }

    public static final Deserializer<CropParticleData> DESERIALIZER = new Deserializer<>() {
        @Override
        public CropParticleData fromCommand(ParticleType<CropParticleData> particleTypeIn, StringReader reader)
                throws CommandSyntaxException {
            reader.expect(' ');
            int lifeTime = reader.readInt();
            return new CropParticleData(lifeTime);
        }

        @Override
        public CropParticleData fromNetwork(ParticleType<CropParticleData> particleTypeIn, FriendlyByteBuf buffer) {
            int lifeTime = buffer.readVarInt();
            return new CropParticleData(lifeTime);
        }
    };
}
