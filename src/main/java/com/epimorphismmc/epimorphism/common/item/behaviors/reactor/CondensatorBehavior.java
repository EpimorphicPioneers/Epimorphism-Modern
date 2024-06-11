package com.epimorphismmc.epimorphism.common.item.behaviors.reactor;

import com.epimorphismmc.epimorphism.api.item.component.IReactorComponent;

import net.minecraft.world.item.ItemStack;

public class CondensatorBehavior implements IReactorComponent {

    private final int maxHeat;

    public CondensatorBehavior(final int maxHeat) {
        this.maxHeat = maxHeat;
    }

    @Override
    public int getMaxDurability(ItemStack itemStack) {
        return -1;
    }

    @Override
    public int getComponentMaxHeat(ItemStack itemStack) {
        return maxHeat;
    }

    @Override
    public int adjustCurrentHeat(ItemStack stack, final int heat) {
        if (heat < 0.0) {
            return heat;
        }
        int acceptedHeat = Math.min(heat, getComponentMaxHeat(stack) - heat);
        int result = heat - acceptedHeat;
        setComponentHeat(stack, getComponentHeat(stack) + acceptedHeat);
        return result;
    }

    @Override
    public boolean needsCoolantInjected(ItemStack stack) {
        return getComponentHeat(stack) > 0.85 * getComponentMaxHeat(stack);
    }

    @Override
    public void injectCoolant(ItemStack stack) {
        setComponentHeat(stack, 0);
    }

    @Override
    public float getDurabilityForDisplay(ItemStack itemStack) {
        return (float) getComponentHeat(itemStack) / getComponentMaxHeat(itemStack);
    }

    @Override
    public boolean showEmptyBar(ItemStack itemStack) {
        return getComponentMaxHeat(itemStack) > 0;
    }

    @Override
    public RComponentType getComponentType() {
        return RComponentType.CONDENSATOR;
    }
}
