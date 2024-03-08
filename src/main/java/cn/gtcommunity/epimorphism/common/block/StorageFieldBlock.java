package cn.gtcommunity.epimorphism.common.block;

import cn.gtcommunity.epimorphism.api.block.IStorageFieldBlock;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.block.RendererBlock;
import com.gregtechceu.gtceu.utils.FormattingUtil;
import com.gregtechceu.gtceu.utils.GTUtil;
import com.lowdragmc.lowdraglib.client.renderer.IRenderer;
import lombok.Getter;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class StorageFieldBlock extends RendererBlock {

    @Getter
    private final IStorageFieldBlock data;

    public StorageFieldBlock(Properties properties, IStorageFieldBlock data, IRenderer renderer) {
        super(properties, renderer);
        this.data = data;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable BlockGetter level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
        super.appendHoverText(stack, level, tooltip, flag);
        if (data == null) return;

        if (GTUtil.isShiftDown()) {
            String capacity = FormattingUtil.formatNumbers(data.getCapacity());
            String powerDraw = FormattingUtil.formatNumbers(data.getCost());
            tooltip.add(Component.translatable("epimorphism.universal.desc.fluid_capacity", capacity));
            tooltip.add(Component.translatable("epimorphism.universal.desc.power_cost", powerDraw));
        } else {
            tooltip.add(Component.translatable("epimorphism.desc_extended_info"));
        }
    }

    public enum FieldBlockType implements IStorageFieldBlock {
        BLOCK_1(GTValues.HV, Math.pow(2, 0), 1),
        BLOCK_2(GTValues.EV, Math.pow(2, 2), 2),
        BLOCK_3(GTValues.IV, Math.pow(2, 4), 5),
        BLOCK_4(GTValues.LuV, Math.pow(2, 6), 14),
        BLOCK_5(GTValues.ZPM, Math.pow(2, 8), 42),
        BLOCK_6(GTValues.UV, Math.pow(2, 11), 132),
        BLOCK_7(GTValues.UHV, Math.pow(2, 17), 429),
        BLOCK_8(GTValues.UEV, Math.pow(2, 23), 1430),
        BLOCK_9(GTValues.UIV, Math.pow(2, 29), 4863),
        BLOCK_10(GTValues.UXV, Math.pow(2, 40), 0);

        private final int tier;
        private final long capacity;
        private final int cost;

        FieldBlockType(int tier, Number capacity, int cost) {
            this.tier = tier;
            this.capacity = capacity.longValue() * 1_000_000L;
            this.cost = cost;
        }

        @Override
        public int tier() {
            return tier;
        }

        @Override
        public long getCapacity() {
            return capacity;
        }

        @Override
        public int getCost() {
            return cost;
        }

        @Override
        public String typeName() {
            return name().toLowerCase();
        }
    }
}
