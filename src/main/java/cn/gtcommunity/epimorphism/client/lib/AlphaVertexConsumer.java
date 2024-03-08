package cn.gtcommunity.epimorphism.client.lib;

import com.mojang.blaze3d.MethodsReturnNonnullByDefault;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.model.pipeline.VertexConsumerWrapper;

@OnlyIn(Dist.CLIENT)
@MethodsReturnNonnullByDefault
public class AlphaVertexConsumer extends VertexConsumerWrapper {
    private final int alpha;

    public AlphaVertexConsumer(VertexConsumer inner, int alpha) {
        super(inner);
        this.alpha = alpha;
    }

    public AlphaVertexConsumer(VertexConsumer inner, double alpha) {
        super(inner);
        this.alpha = (int) (alpha * 255F);
    }

    @Override
    public VertexConsumer color(int red, int green, int blue, int alpha) {
        parent.color(red, green, blue, this.alpha);
        return this;
    }
}
