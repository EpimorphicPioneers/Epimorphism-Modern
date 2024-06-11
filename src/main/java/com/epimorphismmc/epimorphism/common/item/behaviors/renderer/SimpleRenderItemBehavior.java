package com.epimorphismmc.epimorphism.common.item.behaviors.renderer;

import com.gregtechceu.gtceu.api.item.component.ICustomRenderer;

import com.lowdragmc.lowdraglib.client.renderer.IRenderer;

import org.jetbrains.annotations.NotNull;

public class SimpleRenderItemBehavior implements ICustomRenderer {

    private final IRenderer renderer;

    public SimpleRenderItemBehavior(IRenderer renderer) {
        this.renderer = renderer;
    }

    @NotNull @Override
    public IRenderer getRenderer() {
        return renderer;
    }
}
