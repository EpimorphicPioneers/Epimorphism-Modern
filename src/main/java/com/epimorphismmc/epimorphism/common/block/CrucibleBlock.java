package com.epimorphismmc.epimorphism.common.block;

import com.epimorphismmc.epimorphism.api.data.chemical.material.properties.EPPropertyKeys;
import com.epimorphismmc.epimorphism.api.data.tag.EPTagPrefix;

import com.gregtechceu.gtceu.api.block.MaterialBlock;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;

import lombok.Getter;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class CrucibleBlock extends MaterialBlock {

    @Getter
    private final int heatCapacity;

    public CrucibleBlock(Properties properties, Material material) {
        super(properties, EPTagPrefix.crucible, material, true);
        this.heatCapacity = material.getProperty(EPPropertyKeys.CRUCIBLE).getHeatCapacity();
    }

    @Override
    public void appendHoverText(
            ItemStack stack, @Nullable BlockGetter level, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, level, tooltip, flag);
        tooltip.add(Component.translatable("epimorphism.universal.desc.heat", getHeatCapacity()));
    }
}
