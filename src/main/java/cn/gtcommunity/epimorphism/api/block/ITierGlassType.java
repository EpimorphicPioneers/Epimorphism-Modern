package cn.gtcommunity.epimorphism.api.block;

import cn.gtcommunity.epimorphism.api.structure.block.tier.ITierType;
import cn.gtcommunity.epimorphism.utils.EPUniverUtil;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.client.TooltipHelper;
import net.minecraft.network.chat.Component;

public interface ITierGlassType extends ITierType {

    boolean isOpticalGlass();

    default long getTireVoltage(){
        return GTValues.V[tier()];
    }

    default String getTireName(){
        return GTValues.VN[tier()];
    }

    default String getTireNameColored(){
        return GTValues.VNF[tier()];
    }

    default Component getOpticalTierName() {
        return Component.translatable("epimorphism.optical_glass_tier.tooltip." + EPUniverUtil.getOpticalGlassTier(tier()))
                .withStyle(TooltipHelper.BLINKING_CYAN.getCurrent());
    }
}
