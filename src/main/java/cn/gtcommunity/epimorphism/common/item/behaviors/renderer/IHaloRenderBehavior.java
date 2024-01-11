package cn.gtcommunity.epimorphism.common.item.behaviors.renderer;

import com.gregtechceu.gtceu.api.item.component.ICustomRenderer;
import net.minecraft.resources.ResourceLocation;

public interface IHaloRenderBehavior extends ICustomRenderer {
    ResourceLocation haloTexture();

    boolean shouldDrawHalo();

    int haloColour();

    int haloSize();

    boolean shouldDrawPulse();
}
