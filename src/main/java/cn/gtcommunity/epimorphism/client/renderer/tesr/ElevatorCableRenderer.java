//package cn.gtcommunity.epimorphism.client.renderer.tesr;
//
//import cn.gtcommunity.epimorphism.Epimorphism;
//import cn.gtcommunity.epimorphism.client.ClientUtil;
//import cn.gtcommunity.epimorphism.common.blockentity.ElevatorCableBlockEntity;
//import com.mojang.blaze3d.vertex.PoseStack;
//import net.minecraft.MethodsReturnNonnullByDefault;
//import net.minecraft.client.renderer.LightTexture;
//import net.minecraft.client.renderer.MultiBufferSource;
//import net.minecraft.client.renderer.RenderType;
//import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
//import net.minecraft.client.renderer.texture.OverlayTexture;
//import net.minecraft.client.resources.model.BakedModel;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.api.distmarker.OnlyIn;
//import net.minecraftforge.client.model.data.ModelData;
//import org.joml.Quaternionf;
//
//import javax.annotation.ParametersAreNonnullByDefault;
//
//@OnlyIn(Dist.CLIENT)
//@ParametersAreNonnullByDefault
//@MethodsReturnNonnullByDefault
//public class ElevatorCableRenderer implements BlockEntityRenderer<ElevatorCableBlockEntity> {
//
//    private static final BakedModel CLIMBER_MODEL = ClientUtil.getBakedModel(Epimorphism.id("block/obj/climber"));
//
//    /** Offset of the climber from the Space Elevator Cable block */
//    private static final int CLIMBER_OFFSET = 50;
//    /** Min Y level that the climber should have */
//    private static final int MIN_CLIMBER_HEIGHT = 100;
//
//    /** Distance from center to edge of cable octagon */
//    private static final float LONG_DISTANCE = (float) (1.0f + Math.sqrt(2.0f)) / 5.4f;
//    /** Distance from center to end of parallel side */
//    private static final float SHORT_DISTANCE = 1.0f / 5.4f;
//    /** Height of the full rendered cable */
//    private static final double CABLE_HEIGHT = 512.0;
//    /** X edges of the helix */
//    private static final float[] edgeX = { LONG_DISTANCE, LONG_DISTANCE, SHORT_DISTANCE, -SHORT_DISTANCE,
//            -LONG_DISTANCE, -LONG_DISTANCE, -SHORT_DISTANCE, SHORT_DISTANCE };
//    /** Z edges of the helix */
//    private static final float[] edgeZ = { SHORT_DISTANCE, -SHORT_DISTANCE, -LONG_DISTANCE, -LONG_DISTANCE,
//            -SHORT_DISTANCE, SHORT_DISTANCE, LONG_DISTANCE, LONG_DISTANCE };
//
//    @Override
//    public void render(ElevatorCableBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
//        if (!blockEntity.shouldRender()) return;
//
//        var pos = blockEntity.getBlockPos();
//        int x = pos.getX();
//        int y = pos.getY();
//        int z = pos.getZ();
//        poseStack.pushPose();
//        renderCable(x, y, z, poseStack, buffer);
//        poseStack.popPose();
//
//        poseStack.pushPose();
//        // If the Space Elevator is build on a low Y level the climber should reach a minimum height
//        poseStack.translate(
//                x + 0.5,
//                y + 0.5
//                        + blockEntity.getClimberHeight()
//                        + ((CLIMBER_OFFSET + y) < MIN_CLIMBER_HEIGHT ? MIN_CLIMBER_HEIGHT
//                        : CLIMBER_OFFSET),
//                z + 0.5);
//        poseStack.mulPose(new Quaternionf().fromAxisAngleDeg(0F, 1F, 0F, blockEntity.getClimberRotation()));
//        renderClimber(poseStack, buffer);
//        poseStack.popPose();
//    }
//
//    private void renderClimber(PoseStack poseStack, MultiBufferSource buffer) {
////        // Initiate open GL for proper climber rendering
////        GL11.glDisable(GL11.GL_LIGHTING);
////        GL11.glDisable(GL11.GL_CULL_FACE);
////        GL11.glEnable(GL11.GL_BLEND);
////        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
////        this.bindTexture(climberTexture);
//        poseStack.scale(4F, 4F, 4F);
//        ClientUtil.modelRenderer().renderModel(poseStack.last(),
//                buffer.getBuffer(RenderType.cutout()),
//                null, CLIMBER_MODEL,
//                1.0F, 0.4F, 0.05F,
//                LightTexture.FULL_BRIGHT, OverlayTexture.NO_OVERLAY,
//                ModelData.EMPTY, RenderType.cutout());
//        // Reset open GL
////        GL11.glDisable(GL11.GL_BLEND);
////        GL11.glDepthMask(true);
////        GL11.glEnable(GL11.GL_LIGHTING);
//    }
//
//    /**
//     * Render the cable of the Space Elevator
//     *
//     * @param x X coordinate of the block
//     * @param y Y coordinate of the block
//     * @param z Z coordinate of the block
//     */
//    private void renderCable(double x, double y, double z, PoseStack poseStack, MultiBufferSource buffer) {
//        // Initiate open GL for proper cable rendering
////        GL11.glAlphaFunc(GL11.GL_GREATER, 0.1F);
////        Tessellator tessellator = Tessellator.instance;
//        GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, 10497.0F);
//        GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, 10497.0F);
////        GL11.glDisable(GL11.GL_LIGHTING);
////        GL11.glEnable(GL11.GL_BLEND);
////        GL11.glDepthMask(true);
////        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
//        // Draw the cable
////        tessellator.setColorOpaque_F(1F, 1F, 1F);
//        renderFullHelix(x, y, z, poseStack, buffer);
////        // Reset open GL
////        GL11.glDisable(GL11.GL_BLEND);
////        OpenGlHelper.glBlendFunc(770, 771, 1, 0);
////        GL11.glDepthMask(false);
////        GL11.glEnable(GL11.GL_LIGHTING);
////        GL11.glEnable(GL11.GL_TEXTURE_2D);
////        GL11.glDepthMask(true);
//    }
//
//
//    private void motorGlow(double x, double y, double z, float minU, float maxU, float minV,
//                           float maxV, PoseStack poseStack, MultiBufferSource buffer) {
//        var consumer = buffer.getBuffer(RenderType.cutout());
//        consumer.vertex(x + 0.5f - 2.51f, y - 22f,          z + 0.5f + 0.5f).uv(minU, maxV).endVertex();
//        consumer.vertex(x + 0.5f - 2.51f, y + 0.5f + 0.5f,  z + 0.5f + 0.5f).uv(minU, minV).endVertex();
//        consumer.vertex(x + 0.5f - 2.51f, y + 0.5f + 0.5f,  z + 0.5f - 0.5f).uv(maxU, minV).endVertex();
//        consumer.vertex(x + 0.5f - 2.51f, y - 22f,          z + 0.5f - 0.5f).uv(maxU, maxV).endVertex();
//
//        consumer.vertex(x + 0.5f + 2.51f, y - 22f,          z + 0.5f - 0.5f).uv(minU, maxV).endVertex();
//        consumer.vertex(x + 0.5f + 2.51f, y + 0.5f + 0.5f,  z + 0.5f - 0.5f).uv(minU, minV).endVertex();
//        consumer.vertex(x + 0.5f + 2.51f, y + 0.5f + 0.5f,  z + 0.5f + 0.5f).uv(maxU, minV).endVertex();
//        consumer.vertex(x + 0.5f + 2.51f, y - 22f,          z + 0.5f + 0.5f).uv(maxU, maxV).endVertex();
//
//        consumer.vertex(x + 0.5f + 0.5f, y - 22f,          z + 0.5f + 2.51f).uv(minU, maxV).endVertex();
//        consumer.vertex(x + 0.5f + 0.5f, y + 0.5f + 0.5f,  z + 0.5f + 2.51f).uv(minU, minV).endVertex();
//        consumer.vertex(x + 0.5f - 0.5f, y + 0.5f + 0.5f,  z + 0.5f + 2.51f).uv(maxU, minV).endVertex();
//        consumer.vertex(x + 0.5f - 0.5f, y - 22f,          z + 0.5f + 2.51f).uv(maxU, maxV).endVertex();
//
//        consumer.vertex(x + 0.5f - 0.5f, y - 22f,          z + 0.5f - 2.51f).uv(minU, maxV).endVertex();
//        consumer.vertex(x + 0.5f - 0.5f, y + 0.5f + 0.5f,  z + 0.5f - 2.51f).uv(minU, minV).endVertex();
//        consumer.vertex(x + 0.5f + 0.5f, y + 0.5f + 0.5f,  z + 0.5f - 2.51f).uv(maxU, minV).endVertex();
//        consumer.vertex(x + 0.5f + 0.5f, y - 22f,          z + 0.5f - 2.51f).uv(maxU, maxV).endVertex();
//    }
//
//    /**
//     * Draw a clockwise helix part of the cable
//     *
//     * @param tes    Tessellator used for rendering
//     * @param x      X coordinate of the cable
//     * @param y      Y coordinate of the cable
//     * @param z      Z coordinate of the cable
//     * @param offset Vertical offset
//     * @param side   Side of the helix
//     * @param width  Width of the helix
//     * @param minU   Minimum U coordinate of the texture
//     * @param maxU   Maximum U coordinate of the texture
//     * @param minV   Minimum V coordinate of the texture
//     * @param maxV   Maximum V coordinate of the texture
//     */
//    private void clockwiseHelixPart(double x, double y, double z, int offset, double side,
//                                    double width, double minU, double maxU, double minV, double maxV, PoseStack poseStack, MultiBufferSource buffer) {
//
//        double sectionHeight = 8 * side;
//        int sections = (int) Math.ceil(CABLE_HEIGHT / sectionHeight);
//        // spotless:off
//        for (int i = 0; i < 8 * sections; i++) {
//            int j = (i + offset) % 8;
//            int k = (i + 1 + offset) % 8;
//            if (i % 4 == 0) {
//                // Light section
//                IIcon cableLight = BlockSpaceElevatorCable.textures[2 + ((i / 4) % 80)];
//                GTNHIntergalactic.instance.markTextureUsed(cableLight);
//                double lightMinU = cableLight.getMinU();
//                double lightMaxU = cableLight.getMaxU();
//                double lightMinV = cableLight.getMinV();
//                double lightMaxV = cableLight.getMaxV();
//
//                tes.addVertexWithUV(x + 0.5f + edgeX[k], y + side * i + side, z + 0.5f + edgeZ[k], lightMinU, lightMaxV);
//                tes.addVertexWithUV(x + 0.5f + edgeX[k], y + side * i + (side + width), z + 0.5f + edgeZ[k], lightMinU, lightMinV);
//                tes.addVertexWithUV(x + 0.5f + edgeX[j], y + side * i + width, z + 0.5f + edgeZ[j], lightMaxU, lightMinV);
//                tes.addVertexWithUV(x + 0.5f + edgeX[j], y + side * i, z + 0.5f + edgeZ[j], lightMaxU, lightMaxV);
//            } else {
//                tes.addVertexWithUV(x + 0.5f + edgeX[k], y + side * i + side, z + 0.5f + edgeZ[k], minU, maxV);
//                tes.addVertexWithUV(x + 0.5f + edgeX[k], y + side * i + (side + width), z + 0.5f + edgeZ[k], minU, minV);
//                tes.addVertexWithUV(x + 0.5f + edgeX[j], y + side * i + width, z + 0.5f + edgeZ[j], maxU, minV);
//                tes.addVertexWithUV(x + 0.5f + edgeX[j], y + side * i, z + 0.5f + edgeZ[j], maxU, maxV);
//            }
//
//            // Inner side
//            tes.addVertexWithUV(x + 0.5f + edgeX[j], y + side * i, z + 0.5f + edgeZ[j], maxU, maxV);
//            tes.addVertexWithUV(x + 0.5f + edgeX[j], y + side * i + width, z + 0.5f + edgeZ[j], maxU, minV);
//            tes.addVertexWithUV(x + 0.5f + edgeX[k], y + side * i + (side + width), z + 0.5f + edgeZ[k], minU, minV);
//            tes.addVertexWithUV(x + 0.5f + edgeX[k], y + side * i + side, z + 0.5f + edgeZ[k], minU, maxV);
//        }
//        // spotless:on
//    }
//
//    /**
//     * Render the cable helix of the Space Elevator
//     *
//     * @param tes Used tessellator for rendering
//     * @param x   X coordinate of the cable
//     * @param y   Y coordinate of the cable
//     * @param z   Z coordinate of the cable
//     */
//    private void renderFullHelix(double x, double y, double z, PoseStack poseStack, MultiBufferSource buffer) {
//        this.bindTexture(TextureMap.locationBlocksTexture);
//        IIcon cablePart = BlockSpaceElevatorCable.textures[0];
//        IIcon motorGlow = BlockSpaceElevatorCable.motorGlow;
//        double minU = cablePart.getMinU();
//        double maxU = cablePart.getMaxU();
//        double minV = cablePart.getMinV();
//        double maxV = cablePart.getMaxV();
//
//        double motorGlowMinU = motorGlow.getMinU();
//        double motorGlowMaxU = motorGlow.getMaxU();
//        double motorGlowMinV = motorGlow.getMinV();
//        double motorGlowMaxV = motorGlow.getMaxV();
//
//        tes.startDrawingQuads();
//        clockwiseHelixPart(tes, x, y - 23.0, z, 0, 2.0 / 5.4, 0.75, minU, maxU, minV, maxV);
//        tes.draw();
//        tes.startDrawingQuads();
//        clockwiseHelixPart(tes, x, y - 23.0, z, 2, 2.0 / 5.4, 0.75, minU, maxU, minV, maxV);
//        tes.draw();
//        tes.startDrawingQuads();
//        clockwiseHelixPart(tes, x, y - 23.0, z, 4, 2.0 / 5.4, 0.75, minU, maxU, minV, maxV);
//        tes.draw();
//        tes.startDrawingQuads();
//        clockwiseHelixPart(tes, x, y - 23.0, z, 6, 2.0 / 5.4, 0.75, minU, maxU, minV, maxV);
//        tes.draw();
//
//        tes.startDrawingQuads();
//        motorGlow(x, y, z, motorGlowMinU, motorGlowMaxU, motorGlowMinV, motorGlowMaxV, poseStack, buffer);
//        tes.draw();
//    }
//
//}
