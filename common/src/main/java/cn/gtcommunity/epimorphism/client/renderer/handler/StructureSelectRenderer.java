package cn.gtcommunity.epimorphism.client.renderer.handler;

import cn.gtcommunity.epimorphism.client.ClientUtil;
import cn.gtcommunity.epimorphism.client.model.geometry.BoxModel;
import cn.gtcommunity.epimorphism.client.renderer.CubeRenderer;
import cn.gtcommunity.epimorphism.common.item.behaviors.StructureWriteBehavior;
import com.lowdragmc.lowdraglib.side.fluid.FluidHelper;
import com.lowdragmc.lowdraglib.side.fluid.FluidStack;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.Vec3;

@Environment(EnvType.CLIENT)
public class StructureSelectRenderer {
    public static void renderStructureSelect(PoseStack poseStack, Camera camera) {
        var mc = Minecraft.getInstance();
        var level = mc.level;
        var player = mc.player;
        if (level == null || player == null) return;

        ItemStack held = player.getMainHandItem();
        if (StructureWriteBehavior.isItemStructureWriter(held)) {
            BlockPos[] poses = StructureWriteBehavior.getPos(held);
            if (poses == null) return;
            Vec3 pos = camera.getPosition();

            poseStack.pushPose();
            poseStack.translate(-pos.x, -pos.y, -pos.z);

            RenderSystem.disableDepthTest();
            RenderSystem.enableBlend();
            RenderSystem.disableCull();
            RenderSystem.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
            Tesselator tesselator = Tesselator.getInstance();
            BufferBuilder buffer = tesselator.getBuilder();

//            buffer.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);
//            RenderSystem.setShader(GameRenderer::getPositionColorShader);
//
//            RenderBufferUtils.renderCubeFace(poseStack, buffer, poses[0].getX(), poses[0].getY(), poses[0].getZ(), poses[1].getX() + 1, poses[1].getY() + 1, poses[1].getZ() + 1, 0.2f, 0.2f, 1f, 0.25f, true);
//
//            tesselator.end();
            CubeRenderer.renderCube(new BoxModel.Model3D().bounds(poses[0].getX(), poses[0].getY(), poses[0].getZ(), poses[1].getX() + 1, poses[1].getY() + 1, poses[1].getZ() + 1).prepFlowing(FluidStack.create(Fluids.WATER, 1)),
                                poseStack, ClientUtil.mc().renderBuffers().bufferSource().getBuffer(Sheets.translucentCullBlockSheet()), FluidHelper.getColor(FluidStack.create(Fluids.WATER, 1)) | 0xff000000, LightTexture.FULL_BRIGHT, OverlayTexture.NO_OVERLAY, CubeRenderer.FaceDisplay.BOTH, camera, null);

//            buffer.begin(VertexFormat.Mode.LINES, DefaultVertexFormat.POSITION_COLOR_NORMAL);
//            RenderSystem.setShader(GameRenderer::getRendertypeLinesShader);
//            RenderSystem.lineWidth(3);
//
//            RenderBufferUtils.renderCubeFrame(poseStack, buffer, poses[0].getX(), poses[0].getY(), poses[0].getZ(), poses[1].getX() + 1, poses[1].getY() + 1, poses[1].getZ() + 1, 0.0f, 0.0f, 1f, 0.5f);
//
//            tesselator.end();

            RenderSystem.enableCull();

            RenderSystem.disableBlend();
            RenderSystem.enableDepthTest();
            poseStack.popPose();
        }
    }
}
