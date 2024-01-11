package cn.gtcommunity.epimorphism.common.block;

import cn.gtcommunity.epimorphism.api.block.IFluidTankCell;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.block.AppearanceBlock;
import com.gregtechceu.gtceu.utils.FormattingUtil;
import com.gregtechceu.gtceu.utils.GTUtil;
import com.lowdragmc.lowdraglib.client.renderer.IBlockRendererProvider;
import com.lowdragmc.lowdraglib.client.renderer.IRenderer;
import lombok.Getter;
import net.minecraft.network.chat.Component;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.math.BigInteger;
import java.util.List;

public class FluidTankCellBlock extends AppearanceBlock implements IBlockRendererProvider {

    private final IRenderer renderer;

    @Getter
    private final IFluidTankCell data;

    public FluidTankCellBlock(Properties properties, IFluidTankCell data, IRenderer renderer) {
        super(properties);
        this.data = data;
        this.renderer = renderer;
    }

    @Nullable
    @Override
    public IRenderer getRenderer(BlockState state) {
        return renderer;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable BlockGetter level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
        super.appendHoverText(stack, level, tooltip, flag);
        if (data == null) return;

        if (GTUtil.isShiftDown()) {
            String tier = GTValues.VNF[data.tier()];
            String capacity = FormattingUtil.formatNumbers(data.getCapacity());
            tooltip.add(Component.translatable("cn.gtcommunity.epimorphism.block_tier.tooltip", tier));
            tooltip.add(Component.translatable("cn.gtcommunity.epimorphism.fluid_capacity.tooltip", capacity));
        } else {
            tooltip.add(Component.translatable("cn.gtcommunity.epimorphism.tooltip_extended_info"));
        }
    }

    public enum FluidCellType implements StringRepresentable, IFluidTankCell {
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

        @Override
        public @NotNull String getSerializedName() {
            return typeName();
        }
    }
}
