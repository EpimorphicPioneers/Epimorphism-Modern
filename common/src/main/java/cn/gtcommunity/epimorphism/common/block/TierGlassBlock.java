package cn.gtcommunity.epimorphism.common.block;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.api.block.ITierGlassType;
import cn.gtcommunity.epimorphism.core.ITierBlockType;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.block.RendererGlassBlock;
import com.lowdragmc.lowdraglib.client.renderer.IRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.StringRepresentable;

import javax.annotation.Nonnull;

public class TierGlassBlock extends RendererGlassBlock implements ITierBlockType {

    public TierGlassBlock(Properties properties, IRenderer renderer, ITierGlassType glassType) {
        super(properties, renderer);
        setType(glassType);
    }

    public enum GlassType implements StringRepresentable, ITierGlassType {
        BLOCK_GLASS("glass", GTValues.LV, false, null),
        TINTED_GLASS("tinted", GTValues.LV, false, null),
        CLEANROOM_GLASS("cleanroom", GTValues.HV, false, null),
        FUSION_GLASS("fusion", GTValues.UV, false, null),
        CASING_LAMINATED_GLASS("laminated", GTValues.IV, false, null),
        CASING_TEMPERED_GLASS("tempered", GTValues.HV, false, null),
        SILICATE_GLASS("boron_silicate", GTValues.HV, true, Epimorphism.id("block/casings/glass/boron_silicate_glass")),
        TI_BORON_SILICATE_GLASS("ti_boron_silicate", GTValues.EV, true, Epimorphism.id("block/casings/glass/ti_boron_silicate_glass")),
        W_BORON_SILICATE_GLASS("w_boron_silicate", GTValues.IV, true, Epimorphism.id("block/casings/glass/w_boron_silicate_glass")),
        OSMIR_BORON_SILICATE_GLASS("osmir_boron_silicate",GTValues.LuV, true, Epimorphism.id("block/casings/glass/osmir_boron_silicate_glass")),
        NAQ_BORON_SILICATE_GLASS("naq_boron_silicate", GTValues.ZPM, true, Epimorphism.id("block/casings/glass/naq_boron_silicate_glass")),
        THY_BORON_SILICATE_GLASS("thy_boron_silicate", GTValues.EV, true, Epimorphism.id("block/casings/glass/thy_boron_silicate_glass")),
        INFINITY_GLASS("infinity", GTValues.OpV, false, Epimorphism.id("block/casings/glass/infinity_glass")),
        PMMA_GLASS("pmma", GTValues.UHV, false, Epimorphism.id("block/casings/glass/pmma_glass")),
        NEU_PMMA_GLASS("neu_pmma", GTValues.UIV, true, Epimorphism.id("block/casings/glass/neu_pmma_glass")),
        BPA_POLYCARBONATE_GLASS("bpa_polycarbonate", GTValues.ZPM, false, Epimorphism.id("block/casings/glass/bpa_polycarbonate_glass")),
        CBDO_POLYCARBONATE_GLASS("cbdo_polycarbonate", GTValues.UIV, false, Epimorphism.id("block/casings/glass/cbdo_polycarbonate_glass"));

        private final String name;
        private final int tier;
        private final boolean isOpticalGlass;
        private final ResourceLocation texture;

        GlassType(String name, int tier, boolean isOpticalGlass, ResourceLocation texture) {
            this.name = name;
            this.tier = tier;
            this.isOpticalGlass = isOpticalGlass;
            this.texture = texture;
        }

        @Override
        public boolean isOpticalGlass() {
            return isOpticalGlass;
        }

        @Override
        public int getGlassTier() {
            return tier;
        }

        @Override
        public String getGlassName() {
            return name;
        }

        @Override
        public ResourceLocation getTexture() {
            return texture;
        }

        @Nonnull
        @Override
        public String toString() {
            return getName();
        }

        @Nonnull
        @Override
        public String getSerializedName() {
            return getName();
        }
    }
}