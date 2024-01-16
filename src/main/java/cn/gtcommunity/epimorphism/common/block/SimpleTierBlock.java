package cn.gtcommunity.epimorphism.common.block;

import cn.gtcommunity.epimorphism.api.structure.block.tier.ITierType;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.block.AppearanceBlock;
import com.gregtechceu.gtceu.utils.GTUtil;
import com.lowdragmc.lowdraglib.client.renderer.IBlockRendererProvider;
import com.lowdragmc.lowdraglib.client.renderer.IRenderer;
import lombok.Getter;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SimpleTierBlock extends AppearanceBlock implements IBlockRendererProvider {
    private final IRenderer renderer;

    @Getter
    private final ITierType data;

    private final List<Component> tooltips = new ArrayList<>();

    public SimpleTierBlock(Properties properties, ITierType data, IRenderer renderer) {
        super(properties);
        this.data = data;
        this.renderer = renderer;
    }

    public void addTooltip(Component... components) {
        tooltips.addAll(List.of(components));
    }

    @Nullable
    @Override
    public IRenderer getRenderer(BlockState state) {
        return renderer;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable BlockGetter level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
        super.appendHoverText(stack, level, tooltip, flag);
        if (!tooltips.isEmpty()) {
            tooltip.addAll(tooltips);
        }

        if (data == null) return;

        if (GTUtil.isShiftDown()) {
            tooltip.add(Component.translatable("epimorphism.block_tier.desc", GTValues.VNF[data.tier()]));
        } else {
            tooltip.add(Component.translatable("epimorphism.desc_extended_info"));
        }
    }
}
