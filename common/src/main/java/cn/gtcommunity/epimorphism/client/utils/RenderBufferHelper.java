package cn.gtcommunity.epimorphism.client.utils;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.texture.OverlayTexture;

@Environment(EnvType.CLIENT)
public class RenderBufferHelper {
    public static void putVertex(
            VertexConsumer b, PoseStack mat,
            float x, float y, float z,
            float u, float v,
            float nX, float nY, float nZ,
            int light
    ) {
        b.vertex(mat.last().pose(), x, y, z)
                .color(1F, 1F, 1F, 1F)
                .uv(u, v)
                .overlayCoords(OverlayTexture.NO_OVERLAY)
                .uv2(light)
                .normal(mat.last().normal(), nX, nY, nZ)
                .endVertex();
    }
}
