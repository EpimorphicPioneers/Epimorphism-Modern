package cn.gtcommunity.epimorphism.common.item.behaviors.renderer;

import cn.gtcommunity.epimorphism.client.renderer.handler.item.TierItemRenderer;
import com.gregtechceu.gtceu.api.item.component.ICustomRenderer;
import com.lowdragmc.lowdraglib.Platform;
import com.lowdragmc.lowdraglib.client.renderer.IRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public record TierRenderItemBehavior(ResourceLocation tierTexture) implements ICustomRenderer {

    public TierRenderItemBehavior(ResourceLocation tierTexture) {
        this.tierTexture = tierTexture;
        if (Platform.isClient()) {
            TierItemRenderer.INSTANCE.addTexture(tierTexture);
        }
    }

    @NotNull
    @Override
    public IRenderer getRenderer() {
        return TierItemRenderer.INSTANCE;
    }
}
