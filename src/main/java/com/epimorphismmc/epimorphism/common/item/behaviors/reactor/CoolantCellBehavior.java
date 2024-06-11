package com.epimorphismmc.epimorphism.common.item.behaviors.reactor;

import com.epimorphismmc.epimorphism.api.item.component.IReactorComponent;

import net.minecraft.world.item.ItemStack;

public class CoolantCellBehavior implements IReactorComponent {

    private final int maxHeat;

    public CoolantCellBehavior(final int maxHeat) {
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
    public float getDurabilityForDisplay(ItemStack itemStack) {
        return (float) getComponentHeat(itemStack) / getComponentMaxHeat(itemStack);
    }

    @Override
    public boolean showEmptyBar(ItemStack itemStack) {
        return getComponentMaxHeat(itemStack) > 0;
    }

    @Override
    public RComponentType getComponentType() {
        return RComponentType.COOLANT_CELL;
    }
}
