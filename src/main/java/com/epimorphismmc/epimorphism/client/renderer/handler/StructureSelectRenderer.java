package com.epimorphismmc.epimorphism.client.renderer.handler;

import com.epimorphismmc.epimorphism.common.item.behaviors.StructureWriteBehavior;

import com.lowdragmc.lowdraglib.client.utils.RenderBufferUtils;

import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;

@OnlyIn(Dist.CLIENT)
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
            RenderSystem.blendFunc(
                    GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
            Tesselator tesselator = Tesselator.getInstance();
            BufferBuilder buffer = tesselator.getBuilder();

            buffer.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);
            RenderSystem.setShader(GameRenderer::getPositionColorShader);

            RenderBufferUtils.renderCubeFace(
                    poseStack,
                    buffer,
                    poses[0].getX(),
                    poses[0].getY(),
                    poses[0].getZ(),
                    poses[1].getX() + 1,
                    poses[1].getY() + 1,
                    poses[1].getZ() + 1,
                    0.2f,
                    0.2f,
                    1f,
                    0.25f,
                    true);

            tesselator.end();

            buffer.begin(VertexFormat.Mode.LINES, DefaultVertexFormat.POSITION_COLOR_NORMAL);
            RenderSystem.setShader(GameRenderer::getRendertypeLinesShader);
            RenderSystem.lineWidth(3);

            RenderBufferUtils.renderCubeFrame(
                    poseStack,
                    buffer,
                    poses[0].getX(),
                    poses[0].getY(),
                    poses[0].getZ(),
                    poses[1].getX() + 1,
                    poses[1].getY() + 1,
                    poses[1].getZ() + 1,
                    0.0f,
                    0.0f,
                    1f,
                    0.5f);

            tesselator.end();

            RenderSystem.enableCull();

            RenderSystem.disableBlend();
            RenderSystem.enableDepthTest();
            poseStack.popPose();
        }
    }
}
