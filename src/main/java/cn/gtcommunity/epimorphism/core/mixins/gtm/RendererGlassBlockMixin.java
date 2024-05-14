package cn.gtcommunity.epimorphism.core.mixins.gtm;

import cn.gtcommunity.epimorphism.api.block.tier.ITierGlassType;
import com.epimorphismmc.monomorphism.block.tier.ITierBlock;
import com.epimorphismmc.monomorphism.block.tier.ITierType;
import com.gregtechceu.gtceu.api.block.RendererBlock;
import com.gregtechceu.gtceu.api.block.RendererGlassBlock;
import com.gregtechceu.gtceu.utils.GTUtil;
import com.lowdragmc.lowdraglib.client.renderer.IRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;

import java.util.List;

@Mixin(value = RendererGlassBlock.class, remap = false)
public abstract class RendererGlassBlockMixin extends RendererBlock implements ITierBlock {

    public ITierGlassType glassType;

    public RendererGlassBlockMixin(Properties properties, IRenderer renderer) {
        super(properties, renderer);
    }

    @Override
    public void setTierType(ITierType type) {
        this.glassType = (ITierGlassType) type;
    }

    @Override
    public ITierType getTierType() {
        return glassType;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable BlockGetter level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
        super.appendHoverText(stack, level, tooltip, flag);
        if (glassType == null) return;
        if (GTUtil.isShiftDown()) {
            tooltip.add(Component.translatable("epimorphism.glass_tier.desc", glassType.getTireNameColored()));
            if (glassType.isOpticalGlass()) {
                tooltip.add(glassType.getOpticalTierName());
            }
        } else {
            tooltip.add(Component.translatable("epimorphism.desc_extended_info"));
        }
    }
}
