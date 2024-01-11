package cn.gtcommunity.epimorphism.core.mixins.gtm;

import cn.gtcommunity.epimorphism.client.item.IRendererMetaInfo;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.item.TagPrefixItem;
import com.gregtechceu.gtceu.api.item.component.ICustomRenderer;
import com.lowdragmc.lowdraglib.Platform;
import com.lowdragmc.lowdraglib.client.renderer.IItemRendererProvider;
import com.lowdragmc.lowdraglib.client.renderer.IRenderer;
import lombok.Setter;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = TagPrefixItem.class, remap = false)
public abstract class TagPrefixItemMixin extends Item implements IItemRendererProvider, IRendererMetaInfo {
    @Setter
    @Unique
    private ICustomRenderer customRenderer;

    private TagPrefixItemMixin(Properties properties) {
        super(properties);
    }

    @Inject(
            method = "<init>(Lnet/minecraft/world/item/Item$Properties;Lcom/gregtechceu/gtceu/api/data/tag/TagPrefix;Lcom/gregtechceu/gtceu/api/data/chemical/material/Material;)V",
            at = @At(
                    value = "RETURN"
            )
    )
    private void TagPrefixItem(Properties properties, TagPrefix tagPrefix, Material material, CallbackInfo ci) {
        if (Platform.isClient()) {
            if (material.getMaterialIconSet() instanceof IRendererMetaInfo metaInfo) setCustomRenderer(metaInfo.getMetaInfo());

            if (tagPrefix instanceof IRendererMetaInfo metaInfo) setCustomRenderer(metaInfo.getMetaInfo());
        }
    }

    @Override
    public ICustomRenderer getMetaInfo() {
        return customRenderer;
    }

    @Nullable
    @Override
    public IRenderer getRenderer(ItemStack stack) {
        if (customRenderer != null) {
            return customRenderer.getRenderer();
        }
        return null;
    }
}
