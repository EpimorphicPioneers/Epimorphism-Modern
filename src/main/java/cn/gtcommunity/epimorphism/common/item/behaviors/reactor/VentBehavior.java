package cn.gtcommunity.epimorphism.common.item.behaviors.reactor;

import cn.gtcommunity.epimorphism.api.item.component.IReactorComponent;
import cn.gtcommunity.epimorphism.common.machine.generator.NuclearReactorMachine;
import net.minecraft.world.item.ItemStack;

public class VentBehavior implements IReactorComponent {

    private final int maxHeat;
    private final int selfVent;
    private final int hullDraw;
    private final int sideVent;

    public VentBehavior(final int maxHeat, final int selfVent, final int hullDraw, final int sideVent) {
        this.maxHeat = maxHeat;
        this.selfVent = selfVent;
        this.hullDraw = hullDraw;
        this.sideVent = sideVent;
    }

    @Override
    public int getMaxDurability(ItemStack itemStack) {
        return -1;
    }

    @Override
    public int getComponentMaxHeat(ItemStack itemStack) {
        return maxHeat;
    }

//    @Override
//    public int dissipate(NuclearReactorMachine.ReactorContext context) {
//        int row = context.getRow();
//        int col = context.getColumn();
//        var currentItem = context.getComponentItem(row, col);
//        int deltaHeat = Math.min(hullDraw, context.getHeat());
//        int dissipation = 0;
//        dissipation += deltaHeat;
//        this.adjustCurrentHeat(currentItem, deltaHeat);
//        final int currentDissipation = Math.min(selfVent, getComponentHeat(currentItem));
//        context.ventHeat(currentDissipation);
//        adjustCurrentHeat(currentItem, -currentDissipation);
//        if (sideVent > 0) {
//            List<ReactorItem> coolableNeighbors = new ArrayList<>(4);
//            ReactorItem component = context.getComponentAt(row - 1, col);
//            if (component != null && component.isCoolable()) {
//                coolableNeighbors.add(component);
//            }
//            component = context.getComponentAt(row, col + 1);
//            if (component != null && component.isCoolable()) {
//                coolableNeighbors.add(component);
//            }
//            component = context.getComponentAt(row + 1, col);
//            if (component != null && component.isCoolable()) {
//                coolableNeighbors.add(component);
//            }
//            component = context.getComponentAt(row, col - 1);
//            if (component != null && component.isCoolable()) {
//                coolableNeighbors.add(component);
//            }
//            for (ReactorItem coolableNeighbor : coolableNeighbors) {
//                double rejectedCooling = coolableNeighbor.adjustCurrentHeat(-sideVent);
//                double tempDissipatedHeat = sideVent + rejectedCooling;
//                context.ventHeat(tempDissipatedHeat);
//            }
//        }
//        return currentDissipation;
//    }

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
        return RComponentType.VENT;
    }
}
