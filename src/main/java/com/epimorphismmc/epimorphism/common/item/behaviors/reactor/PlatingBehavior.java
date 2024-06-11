package com.epimorphismmc.epimorphism.common.item.behaviors.reactor;

import com.epimorphismmc.epimorphism.api.item.component.IReactorComponent;

import net.minecraft.world.item.ItemStack;

import lombok.Getter;

public class PlatingBehavior implements IReactorComponent {

    @Getter
    private final int heatAdjustment;

    @Getter
    private final float explosionPowerMultiplier;

    public PlatingBehavior(final int heatAdjustment, final float explosionPowerMultiplier) {
        this.heatAdjustment = heatAdjustment;
        this.explosionPowerMultiplier = explosionPowerMultiplier;
    }

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
