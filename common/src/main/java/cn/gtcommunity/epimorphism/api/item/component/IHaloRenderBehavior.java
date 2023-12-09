package cn.gtcommunity.epimorphism.api.item.component;

import com.gregtechceu.gtceu.api.item.component.ICustomRenderer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.resources.ResourceLocation;

public interface IHaloRenderBehavior extends ICustomRenderer {
    @Environment(EnvType.CLIENT)
    boolean shouldDrawHalo();

    @Environment(EnvType.CLIENT)
    ResourceLocation getHaloTexture();

    @Environment(EnvType.CLIENT)
    int getHaloColour();

    @Environment(EnvType.CLIENT)
    int getHaloSize();

    @Environment(EnvType.CLIENT)
    boolean shouldDrawPulse();
}
