package cn.gtcommunity.epimorphism.api.block;

import cn.gtcommunity.epimorphism.utils.EPUniverUtil;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.client.TooltipHelper;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public interface ITierGlassType extends ITierType {
    @Override
    default Integer getTier() {
        return this.getGlassTier();
    }
    @Override
    default String getName() {
        return this.getGlassName();
    }

    boolean isOpticalGlass();
    int getGlassTier();
    String getGlassName();

    ResourceLocation getTexture();

    default long getTireVoltage(){
        return GTValues.V[getGlassTier()];
    }

    default String getTireName(){
        return GTValues.VN[getGlassTier()];
    }

    default String getTireNameColored(){
        return GTValues.VNF[getGlassTier()];
    }

    default Component getOpticalTierName() {
        return Component.translatable("epimorphism.optical_glass_tier.tooltip." + EPUniverUtil.getOpticalGlassTier(getGlassTier()))
                .withStyle(TooltipHelper.BLINKING_CYAN.getCurrent());
    }
}
