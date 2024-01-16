package cn.gtcommunity.epimorphism.api.data.tag;

import cn.gtcommunity.epimorphism.client.item.IRendererMetaInfo;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.item.component.ICustomRenderer;

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
    public ICustomRenderer getMetaInfo() {
        return customRenderer;
    }
}