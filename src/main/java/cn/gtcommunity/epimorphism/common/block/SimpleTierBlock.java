package cn.gtcommunity.epimorphism.common.block;

import cn.gtcommunity.epimorphism.api.block.tier.ITierType;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.utils.GTUtil;
import com.lowdragmc.lowdraglib.client.renderer.IRenderer;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SimpleTierBlock extends CasingBlock {

    @Getter
    private final ITierType data;

    @Setter @Accessors(chain = true)
    private boolean useNumberTier;

    public SimpleTierBlock(Properties properties, ITierType data, IRenderer renderer) {
        super(properties, renderer);
        this.data = data;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable BlockGetter level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
        super.appendHoverText(stack, level, tooltip, flag);
        if (data == null) return;

        if (GTUtil.isShiftDown()) {
            if (useNumberTier) {
                tooltip.add(Component.translatable("epimorphism.universal.desc.tier", data.tier()));
            } else {
                tooltip.add(Component.translatable("epimorphism.universal.desc.tier", GTValues.VNF[data.tier()]));
            }
        } else {
            tooltip.add(Component.translatable("epimorphism.desc_extended_info"));
        }
    }
}
