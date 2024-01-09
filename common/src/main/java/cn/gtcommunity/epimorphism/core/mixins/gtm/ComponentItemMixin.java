package cn.gtcommunity.epimorphism.core.mixins.gtm;

import cn.gtcommunity.epimorphism.client.item.IRendererMetaInfo;
import com.gregtechceu.gtceu.api.item.ComponentItem;
import com.gregtechceu.gtceu.api.item.component.ICustomRenderer;
import com.gregtechceu.gtceu.api.item.component.IItemComponent;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.List;

@Mixin(value = ComponentItem.class, remap = false)
public abstract class ComponentItemMixin extends Item implements IRendererMetaInfo {
    @Shadow
    protected List<IItemComponent> components;

    public ComponentItemMixin(Properties properties) {
        super(properties);
    }

    @Override
    public ICustomRenderer getMetaInfo() {
        for (IItemComponent component : components) {
            if (component instanceof ICustomRenderer customRenderer) {
                return customRenderer;
            }
        }
        return null;
    }
}