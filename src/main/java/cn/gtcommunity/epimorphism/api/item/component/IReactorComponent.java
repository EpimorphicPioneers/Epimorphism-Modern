package cn.gtcommunity.epimorphism.api.item.component;

import cn.gtcommunity.epimorphism.common.machine.generator.NuclearReactorMachine;
import com.epimorphismmc.monomorphism.item.component.IDurabilityItem;
import com.gregtechceu.gtceu.api.item.ComponentItem;
import com.gregtechceu.gtceu.api.item.component.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface IReactorComponent extends IItemComponent, IAddInformation, IDurabilityItem {

    int getComponentMaxHeat(ItemStack itemStack);

    RComponentType getComponentType();

    @Nullable
    default CompoundTag getComponentStatsTag(ItemStack itemStack) {
        return itemStack.getTagElement("EP.RComponentStats");
    }

    default CompoundTag getOrCreateComponentStatsTag(ItemStack itemStack) {
        return itemStack.getOrCreateTagElement("EP.RComponentStats");
    }

    @Override
    default int getDamage(ItemStack itemStack) {
        var compound = getComponentStatsTag(itemStack);
        if (compound == null || !compound.contains("Damage", Tag.TAG_ANY_NUMERIC)) {
            return 0;
        }
        return compound.getInt("Damage");
    }

    @Override
    default void setDamage(ItemStack itemStack, int damage) {
        var compound = getOrCreateComponentStatsTag(itemStack);
        compound.putInt("Damage", Math.min(getMaxDurability(itemStack), damage));
    }

    default int getComponentHeat(ItemStack itemStack) {
        var compound = getComponentStatsTag(itemStack);
        if (compound == null || !compound.contains("Heat", Tag.TAG_ANY_NUMERIC)) {
            return 0;
        }
        return compound.getInt("Heat");
    }

    default void setComponentHeat(ItemStack itemStack, int heat) {
        var compound = getOrCreateComponentStatsTag(itemStack);
        compound.putInt("Heat", Math.min(getComponentMaxHeat(itemStack), heat));
    }

    default int adjustCurrentHeat(ItemStack stack, final int heat) {
        if (isHeatAcceptor(stack)) {
            int result = 0;
            int tempHeat = getComponentHeat(stack);
            tempHeat += heat;
            if (tempHeat > getComponentMaxHeat(stack)) {
                result = tempHeat - getComponentMaxHeat(stack);
                stack.shrink(1);
            } else if (tempHeat < 0) {
                result = getComponentHeat(stack);
                tempHeat = 0;
            }
            setComponentHeat(stack, tempHeat);
            return result;
        }
        return 0;
    }

    /**
     * Checks if this component can accept heat. (e.g. from adjacent fuel rods, or from an exchanger)
     * @return true if this component can accept heat, false otherwise.
     */
    default boolean isHeatAcceptor(ItemStack stack) {
        // maxHeat of 1 means this component never accepts heat (though it might take damage instead)
        return getComponentMaxHeat(stack) > 1 && !isBroken(stack);
    }

    /**
     * Determines if this component can be cooled down, such as by a component heat vent.
     * @return true if this component can be cooled down, false otherwise.
     */
    default boolean isCoolable(ItemStack stack) {
        return getComponentMaxHeat(stack) > 1 && !(getComponentType() == RComponentType.CONDENSATOR);
    }

    /**
     * Checks if this component acts as a neutron reflector, and boosts performance of adjacent fuel rods,
     * either by being a "neutron reflector" item or by being a fuel rod.
     * @return true if this component reflects neutrons, false otherwise.
     */
    default boolean isNeutronReflector(ItemStack stack) {
        return false;
    }

    /**
     * Generate heat if appropriate for component type, and spread to reactor or adjacent cells.
     * @return the amount of heat generated by this component.
     */
    default int generateHeat(NuclearReactorMachine.ReactorContext context) {
        return 0;
    }

    /**
     * Generate energy if appropriate for component type.
     * @return the number of EU generated by this component during the current reactor tick.
     */
    default long generateEnergy(NuclearReactorMachine.ReactorContext context) {
        return 0;
    }

    /**
     * Dissipate (aka vent) heat if appropriate for component type.
     * @return the amount of heat successfully vented during the current reactor tick.
     */
    default int dissipate(NuclearReactorMachine.ReactorContext context) {
        return 0;
    }

    /**
     * Transfer heat between component, neighbors, and/or reactor, if appropriate for component type.
     */
    default int transfer(NuclearReactorMachine.ReactorContext context) {
        return 0;
    }

    /**
     * Determines if this component is broken in the current tick of the simulation
     * @return true if the component has broken either from damage (e.g. neutron reflectors, fuel rods) or from heat (e.g. heat vents, coolant cells), false otherwise.
     */
    default boolean isBroken(ItemStack stack) {
        return getComponentHeat(stack) >= getComponentMaxHeat(stack) || getDamage(stack) >= getMaxDurability(stack);
    }

    /**
     * The number of fuel rods in this component (0 for non-fuel-rod components).
     * @return The number of fuel rods in this component, or 0 if this component has no fuel rods.
     */
    default int getRodCount() {
        return 0;
    }

    /**
     * Gets a value added in the formula for calculating explosion power.
     * @return the additive value for explosion power caused by this component,
     * or 0 if this component doesn't affect the addition part of the explosion calculation.
     */
    default float getExplosionPowerOffset(ItemStack stack) {
        if (!isBroken(stack)) {
            if (getRodCount() == 0 && isNeutronReflector(stack)) {
                return -1;
            }
            return 2 * getRodCount(); // all known fuel rods (including those from GT) use this formula, and non-rod components return 0 for getRodCount
        }
        return 0;
    }

    /**
     * Gets a value multiplied in the formula for calculating explosion power.
     * @return the multiplier value for explosion power caused by this component,
     * or 1 if this component doesn't affect the multiplication part of the explosion calculation.
     */
    default float getExplosionPowerMultiplier() {
        return 1;
    }

    /**
     * Gets a value multiplied in the formula for calculating explosion power.
     * @return the multiplier value for explosion power caused by this component,
     * or 1 if this component doesn't affect the multiplication part of the explosion calculation.
     */
    default int getHeatAdjustment() {
        return 0;
    }

    /**
     * Determines if this component needs input from a Reactor Coolant Injector.
     * Simply returns false for non-condensator items.
     * @return true if this is a condensator that has absorbed enough heat to require the appropriate item added to repair it, false otherwise.
     */
    default boolean needsCoolantInjected(ItemStack stack) {
        return false;
    }

    /**
     * Simulates having a coolant item added by a Reactor Coolant Injector.
     */
    default void injectCoolant(ItemStack stack) {
        // do nothing by default.
    }

    @Override
    default void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag isAdvanced) {
        var maxDurability = getMaxDurability(stack);
        var damage = getDamage(stack);
        var maxHeat = getComponentMaxHeat(stack);
        var heat = getComponentHeat(stack);
        if (maxDurability > 0) {
            tooltipComponents.add(Component.translatable("metaitem.tool.tooltip.durability", maxDurability - damage, maxDurability));
        }
        if (maxHeat > 0) {
            tooltipComponents.add(Component.translatable("item.epimorphism.reactor_component.desc.heat", heat, maxHeat));
        }
    }

    @Nullable
    static IReactorComponent getBehaviour(@NotNull ItemStack itemStack) {
        if (itemStack.getItem() instanceof ComponentItem componentItem) {
            for (var component : componentItem.getComponents()) {
                if (component instanceof IReactorComponent behaviour) {
                    return behaviour;
                }
            }
        }
        return null;
    }

    enum RComponentType {
        CONDENSATOR,
        COOLANT_CELL,
        EXCHANGER,
        FUEL_ROD,
        PLATING,
        REFLECTOR,
        VENT
    }

}
