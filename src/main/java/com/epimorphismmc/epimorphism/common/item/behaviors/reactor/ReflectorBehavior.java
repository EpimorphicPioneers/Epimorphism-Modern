package com.epimorphismmc.epimorphism.common.item.behaviors.reactor;

import com.epimorphismmc.epimorphism.api.item.component.IReactorComponent;
import com.epimorphismmc.epimorphism.common.machine.generator.NuclearReactorMachine;

import net.minecraft.world.item.ItemStack;

public class ReflectorBehavior implements IReactorComponent {

    private final int maxDurability;

    public ReflectorBehavior(final int maxDurability) {
        this.maxDurability = maxDurability;
    }

    @Override
    public int getMaxDurability(ItemStack itemStack) {
        return maxDurability;
    }

    @Override
    public int getComponentMaxHeat(ItemStack itemStack) {
        return -1;
    }

    @Override
    public boolean isNeutronReflector(ItemStack stack) {
        return !isBroken(stack);
    }

    @Override
    public int generateHeat(NuclearReactorMachine.ReactorContext context) {
        int row = context.getRow();
        int col = context.getColumn();
        var currentItem = context.getComponentItem(row, col);
        var component = context.getComponent(row - 1, col);
        if (component != null) {
            applyDamage(currentItem, component.getRodCount());
        }
        component = context.getComponent(row, col + 1);
        if (component != null) {
            applyDamage(currentItem, component.getRodCount());
        }
        component = context.getComponent(row + 1, col);
        if (component != null) {
            applyDamage(currentItem, component.getRodCount());
        }
        component = context.getComponent(row, col - 1);
        if (component != null) {
            applyDamage(currentItem, component.getRodCount());
        }
        return 0;
    }

    @Override
    public RComponentType getComponentType() {
        return RComponentType.REFLECTOR;
    }
}
