package cn.gtcommunity.epimorphism.core.mixins.mc;

import cn.gtcommunity.epimorphism.api.block.tier.ITierGlassType;
import com.epimorphismmc.monomorphism.block.tier.ITierBlock;
import com.epimorphismmc.monomorphism.block.tier.ITierType;
import com.gregtechceu.gtceu.utils.GTUtil;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.AbstractGlassBlock;
import net.minecraft.world.level.block.GlassBlock;
import net.minecraft.world.level.block.StainedGlassBlock;
import net.minecraft.world.level.block.TintedGlassBlock;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;

import java.util.List;

@Mixin({GlassBlock.class, StainedGlassBlock.class, TintedGlassBlock.class})
public abstract class BlockGlassMixin extends AbstractGlassBlock implements ITierBlock {
    public ITierGlassType glassType;

    protected BlockGlassMixin(Properties properties) {
        super(properties);
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
