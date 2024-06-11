package com.epimorphismmc.epimorphism.common.item;

import com.epimorphismmc.epimorphism.common.item.behaviors.GrindBallBehaviour;

import com.epimorphismmc.monomorphism.item.IMOItemRendererProvider;

import com.gregtechceu.gtceu.api.item.ComponentItem;
import com.gregtechceu.gtceu.api.item.component.ICustomRenderer;
import com.gregtechceu.gtceu.api.item.component.IItemComponent;

import net.minecraft.world.item.ItemStack;

public class GrindBallItem extends ComponentItem implements IMOItemRendererProvider {
    public GrindBallItem(Properties properties) {
        super(properties);
    }

    @Override
    public ICustomRenderer getRenderInfo(ItemStack itemStack) {
        for (IItemComponent component : components) {
            if (component instanceof GrindBallBehaviour grindBallBehaviour) {
                return grindBallBehaviour.getCustomRenderer(itemStack);
            }
        }
        return null;
    }
}
