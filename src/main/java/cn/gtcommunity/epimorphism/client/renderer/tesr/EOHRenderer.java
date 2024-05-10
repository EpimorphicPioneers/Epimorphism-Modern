package cn.gtcommunity.epimorphism.client.renderer.tesr;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.client.ClientUtil;
import cn.gtcommunity.epimorphism.client.utils.AlphaVertexConsumer;
import cn.gtcommunity.epimorphism.common.block.DimensionDisplayBlock;
import cn.gtcommunity.epimorphism.common.blockentity.EOHBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.model.data.ModelData;
import org.joml.Quaternionf;

import javax.annotation.ParametersAreNonnullByDefault;

import static com.lowdragmc.lowdraglib.client.model.forge.LDLRendererModel.RendererBakedModel.*;

@OnlyIn(Dist.CLIENT)
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class EOHRenderer implements BlockEntityRenderer<EOHBlockEntity> {

    private static final BakedModel STAR_MODEL_0 = ClientUtil.getBakedModel(Epimorphism.id("block/obj/star_0"));;
    private static final BakedModel STAR_MODEL_1 = ClientUtil.getBakedModel(Epimorphism.id("block/obj/star_1"));
    private static final BakedModel STAR_MODEL_2 = ClientUtil.getBakedModel(Epimorphism.id("block/obj/star_2"));
    private static final BakedModel SPACE_MODEL = ClientUtil.getBakedModel(Epimorphism.id("block/obj/space"));

    private static final float STAR_RESCALE = 0.2f;

    public EOHRenderer(BlockEntityRendererProvider.Context context) {

    }

    @Override
    public void render(EOHBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
        poseStack.pushPose();
        poseStack.translate(0.5, 0.5, 0.5);

        renderOuterSpaceShell(poseStack, buffer);
        renderOrbitObjects(blockEntity, poseStack, buffer, partialTick);
        renderStar(blockEntity, poseStack, buffer, partialTick);

        poseStack.popPose();
    }

    private void renderOrbitObjects(final EOHBlockEntity blockEntity, PoseStack poseStack, MultiBufferSource buffer, float partialTick) {
        if (blockEntity.getOrbitingObjects() != null) {
            if (blockEntity.getOrbitingObjects().isEmpty()) {
                blockEntity.generateImportantInfo();
            }

            for (EOHBlockEntity.OrbitingObject object : blockEntity.getOrbitingObjects()) {
                renderOrbit(blockEntity, object, poseStack, buffer, partialTick);
            }
        }
    }

    private void renderOrbit(final EOHBlockEntity EOHRenderTile, final EOHBlockEntity.OrbitingObject orbitingObject, PoseStack poseStack, MultiBufferSource buffer, float partialTick) {
        float scale = orbitingObject.scale();
        poseStack.pushPose();
        poseStack.mulPose(new Quaternionf().fromAxisAngleDeg(0F, 0F, 1F, orbitingObject.zAngle()));
        poseStack.mulPose(new Quaternionf().fromAxisAngleDeg(1F, 0F, 0F, orbitingObject.xAngle()));
        poseStack.mulPose(new Quaternionf().fromAxisAngleDeg(0F, 1F, 0F, (orbitingObject.rotationSpeed() * (EOHRenderTile.angle + partialTick)) % 360F));
        poseStack.translate(-0.2 - orbitingObject.distance() - STAR_RESCALE * EOHRenderTile.getSize(), 0, 0);
        poseStack.mulPose(new Quaternionf().fromAxisAngleDeg(0F, 1F, 0F, (orbitingObject.orbitSpeed() * (EOHRenderTile.angle + partialTick)) % 360F));
        poseStack.scale(scale, scale, scale);

        ClientUtil.blockRenderer().renderSingleBlock(orbitingObject.block().defaultBlockState(),
                poseStack, buffer, LightTexture.FULL_BRIGHT, OverlayTexture.NO_OVERLAY,
                ModelData.builder().with(IRENDERER, ((DimensionDisplayBlock)orbitingObject.block()).renderer).build(),
                RenderType.solid());

        poseStack.popPose();
    }

    public static void renderStar(EOHBlockEntity blockEntity, PoseStack poseStack, MultiBufferSource buffer, float partialTick) {
        poseStack.pushPose();
        poseStack.mulPose(new Quaternionf().fromAxisAngleDeg(0F, 1F, 0F, 180F));

        renderStarLayer(2, blockEntity, STAR_MODEL_2, poseStack, buffer, RenderType.translucent(), 0.2F, partialTick);
        renderStarLayer(1, blockEntity, STAR_MODEL_1, poseStack, buffer, RenderType.translucentNoCrumbling(), 0.4F, partialTick);
        renderStarLayer(0, blockEntity, STAR_MODEL_0, poseStack, buffer, RenderType.solid(), 1.0F, partialTick);

        poseStack.popPose();
    }

    private static void renderStarLayer(int layer, EOHBlockEntity blockEntity, BakedModel model, PoseStack poseStack, MultiBufferSource buffer, RenderType renderType, float alpha, float partialTick) {
        float scale = 0.02f;
        float angle = blockEntity.angle;
        scale *= (float) Math.pow(1.04, layer);
        poseStack.pushPose();
        poseStack.scale(scale, scale, scale);
        switch (layer) {
            case 0 -> poseStack.mulPose(new Quaternionf().fromAxisAngleDeg(0F, 1F, 1F, 130F + ((angle + partialTick) * 0.8F) % 360F));
            case 1 -> poseStack.mulPose(new Quaternionf().fromAxisAngleDeg(1F, 1F, 0F, -49F + ((angle + partialTick) * 0.8F) % 360F));
            case 2 -> poseStack.mulPose(new Quaternionf().fromAxisAngleDeg(1F, 0F, 1F, 67F + ((angle + partialTick) * 0.8F) % 360F));
        }

        ClientUtil.modelRenderer().renderModel(poseStack.last(),
                new AlphaVertexConsumer(buffer.getBuffer(renderType), alpha),
                null, model,
                1.0F, 0.4F, 0.05F,
                LightTexture.FULL_BRIGHT, OverlayTexture.NO_OVERLAY,
                ModelData.EMPTY, renderType);

        poseStack.popPose();
    }

    public void renderOuterSpaceShell(PoseStack poseStack, MultiBufferSource buffer) {
        float scale = 0.01F * 17.5F;
        poseStack.pushPose();
        poseStack.scale(scale, scale, scale);

        ClientUtil.modelRenderer().renderModel(poseStack.last(),
                buffer.getBuffer(RenderType.solid()),
                null, SPACE_MODEL,
                1.0F,1.0F,1.0F,
                LightTexture.FULL_BRIGHT, OverlayTexture.NO_OVERLAY,
                ModelData.EMPTY, RenderType.solid());

        poseStack.popPose();
    }
}
