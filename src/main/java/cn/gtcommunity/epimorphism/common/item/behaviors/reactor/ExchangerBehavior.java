package cn.gtcommunity.epimorphism.common.item.behaviors.reactor;

import cn.gtcommunity.epimorphism.api.item.component.IReactorComponent;
import cn.gtcommunity.epimorphism.common.machine.generator.NuclearReactorMachine;
import net.minecraft.world.item.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class ExchangerBehavior implements IReactorComponent {
    private final int maxHeat;
    private final int switchSide;
    private final int switchReactor;

    public ExchangerBehavior(final int maxHeat, final int switchSide, final int switchReactor) {
        this.maxHeat = maxHeat;
        this.switchSide = switchSide;
        this.switchReactor = switchReactor;
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
    public int transfer(NuclearReactorMachine.ReactorContext context) {
        Map<ItemStack, IReactorComponent> heatableNeighbors = new HashMap<>(4);
        int row = context.getRow();
        int col = context.getColumn();
        var component = context.getComponent(row, col - 1);
        var item = context.getComponentItem(row, col - 1);
        if (component != null && component.isHeatAcceptor(item)) {
            heatableNeighbors.put(item, component);
        }
        component = context.getComponent(row, col + 1);
        item = context.getComponentItem(row, col + 1);
        if (component != null && component.isHeatAcceptor(item)) {
            heatableNeighbors.put(item, component);
        }
        component = context.getComponent(row - 1, col);
        item = context.getComponentItem(row - 1, col);
        if (component != null && component.isHeatAcceptor(item)) {
            heatableNeighbors.put(item, component);
        }
        component = context.getComponent(row + 1, col);
        item = context.getComponentItem(row + 1, col);
        if (component != null && component.isHeatAcceptor(item)) {
            heatableNeighbors.put(item, component);
        }

        int myHeat = 0;
        int toHeat = 0;
        var currentItem = context.getComponentItem(row, col);
        int currentHeat = getComponentHeat(currentItem);
        int currentMaxHeat = getComponentMaxHeat(currentItem);
        if (switchSide > 0) {
            for (var heatableNeighbor : heatableNeighbors.entrySet()) {
                var neighborComponent = heatableNeighbor.getValue();
                var neighborItem = heatableNeighbor.getKey();
                int neighborHeat = neighborComponent.getComponentHeat(neighborItem);
                int neighborMaxHeat = neighborComponent.getComponentMaxHeat(neighborItem);
                double mymed = currentHeat * 100.0 / currentMaxHeat;
                double heatablemed = neighborHeat * 100.0 / neighborMaxHeat;

                int add = (int) (neighborMaxHeat / 100.0 * (heatablemed + mymed / 2.0));
                if (add > switchSide) {
                    add = switchSide;
                }
                if (heatablemed + mymed / 2.0 < 1.0) {
                    add = switchSide / 2;
                }
                if (heatablemed + mymed / 2.0 < 0.75) {
                    add = switchSide / 4;
                }
                if (heatablemed + mymed / 2.0 < 0.5) {
                    add = switchSide / 8;
                }
                if (heatablemed + mymed / 2.0 < 0.25) {
                    add = 1;
                }
                if (Math.round(heatablemed * 10.0) / 10.0 > Math.round(mymed * 10.0) / 10.0) {
                    add -= 2 * add;
                } else if (Math.round(heatablemed * 10.0) / 10.0 == Math.round(mymed * 10.0) / 10.0) {
                    add = 0;
                }
                myHeat -= add;
                add = neighborComponent.adjustCurrentHeat(neighborItem, add);
                myHeat += add;
            }
        }
        if (switchReactor > 0) {
            int reactorHeat = context.getHeat();
            int reactorMaxHeat = context.getMaxHeat();
            double mymed = currentHeat * 100.0 / currentMaxHeat;
            double reactormed = reactorHeat * 100.0 / reactorMaxHeat;

            int add = (int) Math.round(reactorMaxHeat / 100.0 * (reactormed + mymed / 2.0));
            if (add > switchReactor) {
                add = switchReactor;
            }
            if (reactormed + mymed / 2.0 < 1.0) {
                add = switchSide / 2;
            }
            if (reactormed + mymed / 2.0 < 0.75) {
                add = switchSide / 4;
            }
            if (reactormed + mymed / 2.0 < 0.5) {
                add = switchSide / 8;
            }
            if (reactormed + mymed / 2.0 < 0.25) {
                add = 1;
            }
            if (Math.round(reactormed * 10.0) / 10.0 > Math.round(mymed * 10.0) / 10.0) {
                add -= 2 * add;
            } else if (Math.round(reactormed * 10.0) / 10.0 == Math.round(mymed * 10.0) / 10.0) {
                add = 0;
            }
            myHeat -= add;
            toHeat += add;
        }
        adjustCurrentHeat(currentItem, myHeat);
        return toHeat;
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
        return RComponentType.EXCHANGER;
    }
}
