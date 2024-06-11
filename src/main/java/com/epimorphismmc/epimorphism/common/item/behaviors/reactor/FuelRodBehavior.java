package com.epimorphismmc.epimorphism.common.item.behaviors.reactor;

import com.epimorphismmc.epimorphism.api.item.component.IReactorComponent;
import com.epimorphismmc.epimorphism.common.machine.generator.NuclearReactorMachine;

import com.gregtechceu.gtceu.api.item.ComponentItem;
import com.gregtechceu.gtceu.api.item.component.IItemComponent;
import com.gregtechceu.gtceu.api.item.component.IMaterialPartItem;

import net.minecraft.client.color.item.ItemColor;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.HashMap;
import java.util.Map;

public class FuelRodBehavior implements IReactorComponent {
    private final int maxDurability;
    private final int energyMult;
    private final float heatMult;
    private final int rodCount;
    private final boolean moxStyle;

    public FuelRodBehavior(
            final int maxDurability,
            final int energyMult,
            final float heatMult,
            final int rodCount,
            final boolean moxStyle) {
        this.maxDurability = maxDurability;
        this.energyMult = energyMult;
        this.heatMult = heatMult;
        this.rodCount = rodCount;
        this.moxStyle = moxStyle;
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
    public void applyDamage(ItemStack itemStack, int damageApplied) {
        if (getMaxDurability(itemStack) < 1) return;
        int maxDurability = getMaxDurability(itemStack);
        int resultDamage = getDamage(itemStack) + damageApplied;
        if (resultDamage <= maxDurability) {
            setDamage(itemStack, resultDamage);
        }
    }

    @Override
    public boolean isNeutronReflector(ItemStack stack) {
        return !isBroken(stack);
    }

    private int countNeutronNeighbors(NuclearReactorMachine.ReactorContext context) {
        int neutronNeighbors = 0;
        int row = context.getRow();
        int col = context.getColumn();
        var component = context.getComponent(row + 1, col);
        var item = context.getComponentItem(row + 1, col);
        if (component != null && component.isNeutronReflector(item)) {
            neutronNeighbors++;
        }
        component = context.getComponent(row - 1, col);
        item = context.getComponentItem(row - 1, col);
        if (component != null && component.isNeutronReflector(item)) {
            neutronNeighbors++;
        }
        component = context.getComponent(row, col - 1);
        item = context.getComponentItem(row, col - 1);
        if (component != null && component.isNeutronReflector(item)) {
            neutronNeighbors++;
        }
        component = context.getComponent(row, col + 1);
        item = context.getComponentItem(row, col + 1);
        if (component != null && component.isNeutronReflector(item)) {
            neutronNeighbors++;
        }
        return neutronNeighbors;
    }

    protected int handleHeat(NuclearReactorMachine.ReactorContext context, final int heat) {
        Map<ItemStack, IReactorComponent> heatableNeighbors = new HashMap<>(4);
        int row = context.getRow();
        int col = context.getColumn();
        var component = context.getComponent(row + 1, col);
        var item = context.getComponentItem(row + 1, col);
        if (component != null && component.isHeatAcceptor(item)) {
            heatableNeighbors.put(item, component);
        }
        component = context.getComponent(row - 1, col);
        item = context.getComponentItem(row - 1, col);
        if (component != null && component.isHeatAcceptor(item)) {
            heatableNeighbors.put(item, component);
        }
        component = context.getComponent(row, col - 1);
        item = context.getComponentItem(row, col - 1);
        if (component != null && component.isHeatAcceptor(item)) {
            heatableNeighbors.put(item, component);
        }
        component = context.getComponent(row, col + 1);
        item = context.getComponentItem(row, col + 1);
        if (component != null && component.isHeatAcceptor(item)) {
            heatableNeighbors.put(item, component);
        }
        if (heatableNeighbors.isEmpty()) {
            return heat;
        } else {
            int tHeat = heat / heatableNeighbors.size();
            int remainderHeat = heat % heatableNeighbors.size();
            for (var heatableNeighbor : heatableNeighbors.entrySet()) {
                int accepted = heatableNeighbor
                        .getValue()
                        .adjustCurrentHeat(heatableNeighbor.getKey(), tHeat + remainderHeat);
                remainderHeat += (tHeat - accepted);
            }
            return remainderHeat;
        }
    }

    @Override
    public int generateHeat(NuclearReactorMachine.ReactorContext context) {
        int pulses = countNeutronNeighbors(context) + (rodCount == 1 ? 1 : (rodCount == 2) ? 2 : 3);
        int heat = (int) (heatMult * pulses * (pulses + 1));
        if (moxStyle && context.isFluid() && (float) context.getHeat() / context.getMaxHeat() > 0.5) {
            heat *= 2;
        }
        return handleHeat(context, heat);
    }

    @Override
    public long generateEnergy(NuclearReactorMachine.ReactorContext context) {
        int pulses = countNeutronNeighbors(context) + (rodCount == 1 ? 1 : (rodCount == 2) ? 2 : 3);
        double energy = energyMult * pulses * 10;
        if (moxStyle) {
            energy *= 10 * (1 + 1.5 * context.getHeat() / context.getMaxHeat());
        }
        applyDamage(context.getComponentItem(context.getRow(), context.getColumn()), 1);
        return (long) energy;
    }

    @Override
    public int getRodCount() {
        return rodCount;
    }

    @Override
    public RComponentType getComponentType() {
        return RComponentType.FUEL_ROD;
    }

    @OnlyIn(Dist.CLIENT)
    static ItemColor getItemStackColor() {
        return (itemStack, i) -> {
            if (itemStack.getItem() instanceof ComponentItem componentItem) {
                for (IItemComponent component : componentItem.getComponents()) {
                    if (component instanceof IMaterialPartItem materialPartItem) {
                        return materialPartItem.getPartMaterial(itemStack).getMaterialARGB();
                    }
                }
            }
            return -1;
        };
    }
}
