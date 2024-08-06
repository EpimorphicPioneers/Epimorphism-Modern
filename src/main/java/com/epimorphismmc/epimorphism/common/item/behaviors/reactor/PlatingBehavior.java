package com.epimorphismmc.epimorphism.common.item.behaviors.reactor;

import com.epimorphismmc.epimorphism.api.item.component.IReactorComponent;

import net.minecraft.world.item.ItemStack;

public record PlatingBehavior(int heatAdjustment, float explosionPowerMultiplier)
        implements IReactorComponent {

    @Override
    public int getMaxDurability(ItemStack itemStack) {
        return -1;
    }

    @Override
    public int getComponentMaxHeat(ItemStack itemStack) {
        return -1;
    }

    @Override
    public RComponentType getComponentType() {
        return RComponentType.PLATING;
    }
}
