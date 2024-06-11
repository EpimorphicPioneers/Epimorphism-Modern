package com.epimorphismmc.epimorphism.common.block;

import com.epimorphismmc.epimorphism.api.block.tier.IFluidTankCell;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.block.RendererBlock;
import com.gregtechceu.gtceu.utils.FormattingUtil;
import com.gregtechceu.gtceu.utils.GTUtil;

import com.lowdragmc.lowdraglib.client.renderer.IRenderer;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.math.BigInteger;
import java.util.List;

public class FluidTankCellBlock extends RendererBlock {

    @Getter
    private final IFluidTankCell data;

    public FluidTankCellBlock(Properties properties, IFluidTankCell data, IRenderer renderer) {
        super(properties, renderer);
        this.data = data;
    }

    @Override
    public void appendHoverText(
            @NotNull ItemStack stack,
            @Nullable BlockGetter level,
            @NotNull List<Component> tooltip,
            @NotNull TooltipFlag flag) {
        super.appendHoverText(stack, level, tooltip, flag);
        if (data == null) return;

        if (GTUtil.isShiftDown()) {
            String tier = GTValues.VNF[data.tier()];
            String capacity = FormattingUtil.formatNumbers(data.getCapacity());
            tooltip.add(Component.translatable("epimorphism.universal.desc.tier", tier));
            tooltip.add(Component.translatable("epimorphism.universal.desc.fluid_capacity", capacity));
        } else {
            tooltip.add(Component.translatable("epimorphism.desc_extended_info"));
        }
    }

    public enum FluidCellType implements IFluidTankCell {
        CELL_1(GTValues.HV, BigInteger.TEN.pow(6)),
        CELL_2(GTValues.EV, BigInteger.TEN.pow(8)),
        CELL_3(GTValues.IV, BigInteger.TEN.pow(10)),
        CELL_4(GTValues.LuV, BigInteger.TEN.pow(12)),
        CELL_5(GTValues.ZPM, BigInteger.TEN.pow(14)),
        CELL_6(GTValues.UV, BigInteger.TEN.pow(16)),
        CELL_7(GTValues.UHV, BigInteger.TEN.pow(18)),
        CELL_8(GTValues.UEV, BigInteger.TEN.pow(20)),
        CELL_9(GTValues.UIV, BigInteger.TEN.pow(22)),
        CELL_10(GTValues.UXV, BigInteger.TEN.pow(24));

        private final int tier;
        private final BigInteger capacity;

        FluidCellType(int tier, BigInteger capacity) {
            this.tier = tier;
            this.capacity = capacity;
        }

        @Override
        public BigInteger getCapacity() {
            return capacity;
        }

        @Override
        public int tier() {
            return tier;
        }

        @Override
        public String typeName() {
            return name().toLowerCase();
        }
    }
}
