package com.epimorphismmc.epimorphism.common.item.behaviors;

import com.epimorphismmc.epimorphism.api.data.chemical.material.properties.EPPropertyKeys;
import com.epimorphismmc.epimorphism.client.renderer.handler.item.GrindBallRenderer;

import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.item.ComponentItem;
import com.gregtechceu.gtceu.api.item.component.ICustomRenderer;
import com.gregtechceu.gtceu.api.item.component.IMaterialPartItem;
import com.gregtechceu.gtceu.api.item.component.ISubItemHandler;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import com.lowdragmc.lowdraglib.client.renderer.IRenderer;

import net.minecraft.ChatFormatting;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import org.jetbrains.annotations.NotNull;

import java.util.*;

import javax.annotation.Nullable;

public class GrindBallBehaviour implements IMaterialPartItem, ICustomRenderer, ISubItemHandler {

    @Override
    public void fillItemCategory(Item item, CreativeModeTab category, NonNullList<ItemStack> items) {
        GTCEuAPI.materialManager.getRegisteredMaterials().stream()
                .filter(mat -> mat.hasProperty(EPPropertyKeys.GRIND_BALL))
                .forEach(mat -> {
                    var grindBall = new ItemStack(item);
                    var behavior = getBehaviour(grindBall);
                    if (behavior != null) {
                        behavior.setPartMaterial(grindBall, mat);
                        items.add(grindBall);
                    }
                });
    }

    @Override
    public Material getPartMaterial(ItemStack itemStack) {
        CompoundTag compound = this.getPartStatsTag(itemStack);
        Material defaultMaterial = GTMaterials.Neutronium;
        if (compound != null && compound.contains("Material", 8)) {
            String materialName = compound.getString("Material");
            Material material = GTMaterials.get(materialName);
            return material != null ? material : defaultMaterial;
        } else {
            return defaultMaterial;
        }
    }

    @Override
    public void setPartMaterial(ItemStack itemStack, @NotNull Material material) {
        CompoundTag compound = this.getOrCreatePartStatsTag(itemStack);
        compound.putString("Material", material.getName());
    }

    @Override
    public int getPartMaxDurability(ItemStack itemStack) {
        var property = getPartMaterial(itemStack).getProperty(EPPropertyKeys.GRIND_BALL);
        return property == null ? -1 : property.getDurability();
    }

    @Override
    public void appendHoverText(
            ItemStack stack,
            @Nullable Level level,
            List<Component> tooltipComponents,
            TooltipFlag isAdvanced) {
        tooltipComponents.add(Component.translatable("item.epimorphism.grind_ball.desc"));
        IMaterialPartItem.super.appendHoverText(stack, level, tooltipComponents, isAdvanced);
        tooltipComponents.add(Component.translatable(
                "item.epimorphism.grind_ball.desc.yield_multiplier",
                ChatFormatting.YELLOW + "%.1f×".formatted(getYieldMultiplier(stack))));
        tooltipComponents.add(Component.translatable(
                "item.epimorphism.grind_ball.desc.energy_cons_multiplier",
                ChatFormatting.YELLOW + "%.1f×".formatted(getEnergyConsMultiplier(stack))));
    }

    public float getYieldMultiplier(ItemStack stack) {
        var property = getPartMaterial(stack).getProperty(EPPropertyKeys.GRIND_BALL);
        return property == null ? -1 : property.getYieldMultiplier();
    }

    public float getEnergyConsMultiplier(ItemStack stack) {
        var property = getPartMaterial(stack).getProperty(EPPropertyKeys.GRIND_BALL);
        return property == null ? -1 : property.getEnergyConsumptionMultiplier();
    }

    public ICustomRenderer getCustomRenderer(ItemStack stack) {
        var property = getPartMaterial(stack).getProperty(EPPropertyKeys.GRIND_BALL);
        return property == null ? null : property.getRenderer();
    }

    @NotNull @Override
    public IRenderer getRenderer() {
        return GrindBallRenderer.INSTANCE;
    }

    @Nullable public static GrindBallBehaviour getBehaviour(@NotNull ItemStack itemStack) {
        if (itemStack.getItem() instanceof ComponentItem componentItem) {
            for (var component : componentItem.getComponents()) {
                if (component instanceof GrindBallBehaviour behaviour) {
                    return behaviour;
                }
            }
        }
        return null;
    }
}
