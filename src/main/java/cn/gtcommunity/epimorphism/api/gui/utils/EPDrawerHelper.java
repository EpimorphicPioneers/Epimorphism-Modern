package cn.gtcommunity.epimorphism.api.gui.utils;

import com.mojang.blaze3d.vertex.BufferUploader;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class EPDrawerHelper {
    public static void renderStackCount(GuiGraphics guiGraphics, String count, int x, int y) {
        var mc = Minecraft.getInstance();
        var font = mc.font;
        PoseStack poseStack = guiGraphics.pose();
        poseStack.pushPose();
        poseStack.translate(0.0D, 0.0D, 200.0F);
        float scale = Math.min(1f, (float) 16 / font.width(count));
        if (scale < 1f) {
            poseStack.scale(scale, scale, 1.0F);
        }
        MultiBufferSource.BufferSource renderBuffer = MultiBufferSource.immediate(Tesselator.getInstance().getBuilder());
        font.drawInBatch(count,
                (x + 19 - 2 - (font.width(count) * scale)) / scale,
                (y + 6 + 3 + (1 / (scale * scale) - 1)) / scale,
                16777215, true, poseStack.last().pose(), renderBuffer, Font.DisplayMode.NORMAL, 0, LightTexture.FULL_BRIGHT);
        renderBuffer.endBatch();
        poseStack.popPose();
    }
}
