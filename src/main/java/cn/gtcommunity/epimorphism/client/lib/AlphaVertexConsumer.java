package cn.gtcommunity.epimorphism.client.lib;

import com.mojang.blaze3d.MethodsReturnNonnullByDefault;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
@MethodsReturnNonnullByDefault
public class AlphaVertexConsumer implements VertexConsumer {

    private final int alpha;
    protected final VertexConsumer inner;

    public AlphaVertexConsumer(VertexConsumer inner, int alpha) {
        this.inner = inner;
        this.alpha = alpha;
    }

    public AlphaVertexConsumer(VertexConsumer inner, double alpha) {
        this.inner = inner;
        this.alpha = (int) (alpha * 255F);
    }

    @Override
    public VertexConsumer vertex(double x, double y, double z) {
        inner.vertex(x, y, z);
        return this;
    }

    @Override
    public VertexConsumer color(int red, int green, int blue, int alpha) {
        inner.color(red, green, blue, this.alpha);
        return this;
    }

    @Override
    public VertexConsumer uv(float u, float v) {
        inner.uv(u, v);
        return this;
    }

    @Override
    public VertexConsumer overlayCoords(int u, int v) {
        inner.overlayCoords(u, v);
        return this;
    }

    @Override
    public VertexConsumer uv2(int u, int v) {
        inner.uv2(u, v);
        return this;
    }

    @Override
    public VertexConsumer normal(float x, float y, float z) {
        inner.normal(x, y, z);
        return this;
    }

    @Override
    public void endVertex() {
        inner.endVertex();
    }

    @Override
    public void defaultColor(int defaultR, int defaultG, int defaultB, int defaultA) {
        inner.defaultColor(defaultR, defaultG, defaultB, defaultA);
    }

    @Override
    public void unsetDefaultColor() {
        inner.unsetDefaultColor();
    }
}
