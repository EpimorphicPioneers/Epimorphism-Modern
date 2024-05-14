package cn.gtcommunity.epimorphism.client.particle;

import com.epimorphismmc.monomorphism.client.utils.RenderHelper;
import com.epimorphismmc.monomorphism.utility.MOMathUtils;
import com.gregtechceu.gtceu.api.GTValues;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.model.data.ModelData;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@OnlyIn(Dist.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class CropFX extends Particle {

    private static final PoseStack POSE_STACK = new PoseStack();
    private final int cropAge;

    protected CropFX(ClientLevel level, double x, double y, double z, int lifeTime) {
        super(level, x, y, z);
        setLifetime(lifeTime);
        this.cropAge = GTValues.RNG.nextInt(8);
    }

    @Override
    public void render(VertexConsumer buffer, Camera renderInfo, float partialTicks) {
        Vec3 vec3 = renderInfo.getPosition();
        float x = (float)(Mth.lerp(partialTicks, this.xo, this.x) - vec3.x());
        float y = (float)(Mth.lerp(partialTicks, this.yo, this.y) - vec3.y());
        float z = (float)(Mth.lerp(partialTicks, this.zo, this.z) - vec3.z());

        var state = getState(Blocks.WHEAT, cropAge);
        BakedModel bakedmodel = RenderHelper.getBlockRendererDispatcher().getBlockModel(state);
        POSE_STACK.pushPose();
        POSE_STACK.translate(x, y, z);
        RenderHelper.getBlockRenderer().renderModel(POSE_STACK.last(), buffer, state, bakedmodel, 1, 1, 1, LightTexture.FULL_BRIGHT, OverlayTexture.NO_OVERLAY, ModelData.EMPTY, RenderType.cutout());
        POSE_STACK.popPose();
    }

    @Override
    public void tick() {
        if (this.age++ >= this.lifetime) {
            this.remove();
        }
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.TERRAIN_SHEET;
    }

    private BlockState getState(Block block, int age) {
        age = MOMathUtils.clamp(age, 0, 7);
        return block.defaultBlockState().setValue(CropBlock.AGE, age);
    }

    @OnlyIn(Dist.CLIENT)
    public static class Factory implements ParticleProvider<CropParticleData> {
        @Nullable
        @Override
        public Particle createParticle(CropParticleData type, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            return new CropFX(level, x, y, z, type.getLifeTime());
        }
    }
}
