package cn.gtcommunity.epimorphism.api.structure.block.tier;

import com.gregtechceu.gtceu.api.GTValues;
import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

public interface ITierType extends StringRepresentable{
    String typeName();

    int tier();

    @Override
    @NotNull
    default String getSerializedName() {
        return typeName();
    }

    enum TierBlockType implements ITierType {
        ULV(GTValues.ULV),
        LV(GTValues.LV),
        MV(GTValues.MV),
        HV(GTValues.HV),
        EV(GTValues.EV),
        IV(GTValues.IV),
        LuV(GTValues.LuV),
        ZPM(GTValues.ZPM),
        UV(GTValues.UV),
        UHV(GTValues.UHV),
        UEV(GTValues.UEV),
        UIV(GTValues.UIV),
        UXV(GTValues.UXV),
        OpV(GTValues.OpV),
        MAX(GTValues.MAX);

        private final int tier;

        TierBlockType(int tier) {
            this.tier = tier;
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
