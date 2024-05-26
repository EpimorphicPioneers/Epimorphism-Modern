package cn.gtcommunity.epimorphism.common.item.behaviors.renderer;

import com.epimorphismmc.monomorphism.client.renderer.item.MOItemRenderers;
import com.epimorphismmc.monomorphism.item.component.IHaloEffect;
import com.lowdragmc.lowdraglib.Platform;
import net.minecraft.resources.ResourceLocation;

public record HaloItemBehavior(int haloSize, int haloColour, ResourceLocation haloTexture, boolean shouldDrawHalo,
                               boolean shouldDrawPulse) implements IHaloEffect {
    public HaloItemBehavior(int haloSize, int haloColour, ResourceLocation haloTexture, boolean shouldDrawHalo, boolean shouldDrawPulse) {
        this.haloSize = haloSize;
        this.haloColour = haloColour;
        this.haloTexture = haloTexture;
        this.shouldDrawHalo = shouldDrawHalo;
        this.shouldDrawPulse = shouldDrawPulse;
        if (Platform.isClient()) {
            MOItemRenderers.HALO_ITEM_RENDERER.addTexture(haloTexture);
        }
    }
}
