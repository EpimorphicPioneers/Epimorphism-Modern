package cn.gtcommunity.epimorphism.api.data.tag;

import cn.gtcommunity.epimorphism.api.item.IRendererMetaInfo;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.item.component.ICustomRenderer;
import net.minecraft.world.item.ItemStack;

public class RenderTagPrefix extends TagPrefix implements IRendererMetaInfo {
    private final ICustomRenderer customRenderer;
    public RenderTagPrefix(String name, ICustomRenderer customRenderer) {
        super(name);
        this.customRenderer = customRenderer;
    }

    public RenderTagPrefix(String name, boolean invertedName, ICustomRenderer customRenderer) {
        super(name, invertedName);
        this.customRenderer = customRenderer;
    }

    @Override
    public ICustomRenderer getMetaInfo(ItemStack itemStack) {
        return customRenderer;
    }
}
