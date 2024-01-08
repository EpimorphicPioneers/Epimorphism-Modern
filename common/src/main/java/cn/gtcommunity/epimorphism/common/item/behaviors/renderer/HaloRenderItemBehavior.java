package cn.gtcommunity.epimorphism.common.item.behaviors.renderer;

import cn.gtcommunity.epimorphism.client.renderer.handler.item.HaloItemRenderer;
import com.lowdragmc.lowdraglib.Platform;
import com.lowdragmc.lowdraglib.client.renderer.IRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public record HaloRenderItemBehavior(int haloSize, int haloColour, ResourceLocation haloTexture, boolean shouldDrawHalo,
                                     boolean shouldDrawPulse) implements IHaloRenderBehavior {
    public HaloRenderItemBehavior(int haloSize, int haloColour, ResourceLocation haloTexture, boolean shouldDrawHalo, boolean shouldDrawPulse) {
        this.haloSize = haloSize;
        this.haloColour = haloColour;
        this.haloTexture = haloTexture;
        this.shouldDrawHalo = shouldDrawHalo;
        this.shouldDrawPulse = shouldDrawPulse;
        if (Platform.isClient()) {
            HaloItemRenderer.INSTANCE.addTexture(haloTexture);
        }
    }

    @NotNull
    @Override
    public IRenderer getRenderer() {
        return HaloItemRenderer.INSTANCE;
    }
}
