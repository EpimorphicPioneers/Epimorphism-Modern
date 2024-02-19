package cn.gtcommunity.epimorphism.api.data.tag;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.api.chemical.material.info.EPMaterialIconType;
import cn.gtcommunity.epimorphism.common.data.EPBlocks;
import cn.gtcommunity.epimorphism.common.item.behaviors.renderer.HaloRenderItemBehavior;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.item.tool.GTToolType;
import net.minecraft.resources.ResourceLocation;

import static cn.gtcommunity.epimorphism.api.chemical.material.info.EPMaterialFlags.*;
import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.Conditions.*;

public class EPTagPrefix {
    public static final TagPrefix singularity = new RenderTagPrefix("singularity",
            new HaloRenderItemBehavior(4, 0xFF000000, new ResourceLocation(Epimorphism.MOD_ID, "sprite/halo"), true, false))
            .defaultTagPath("singularity/%s")
            .unformattedTagPath("singularity")
            .materialAmount(-1)
            .materialIconType(EPMaterialIconType.singularity)
            .unificationEnabled(true)
            .generateItem(true)
            .generationCondition(Material::isElement);

    public static final TagPrefix milled = new TagPrefix("milled")
            .defaultTagPath("milled/%s")
            .unformattedTagPath("milled")
            .materialAmount(-1)
            .materialIconType(EPMaterialIconType.milled)
            .unificationEnabled(true)
            .generateItem(true)
            .generationCondition(hasOreProperty.and(mat -> mat.hasFlag(GENERATE_MILLED)));

    public static final TagPrefix seedCrystal = new TagPrefix("seedCrystal")
            .defaultTagPath("seedCrystal/%s")
            .unformattedTagPath("seedCrystal")
            .materialAmount(M / 9)
            .materialIconType(EPMaterialIconType.seedCrystal)
            .unificationEnabled(true)
            .generateItem(true)
            .generationCondition(hasGemProperty.and(mat -> mat.hasFlag(GENERATE_BOULE) || (mat.hasFlag(CRYSTALLIZABLE) && !mat.hasFlag(DISABLE_CRYSTALLIZATION))));

    public static final TagPrefix boule = new TagPrefix("boule")
            .defaultTagPath("boule/%s")
            .unformattedTagPath("boule")
            .materialAmount(M * 4)
            .materialIconType(EPMaterialIconType.boule)
            .unificationEnabled(true)
            .generateItem(true)
            .generationCondition(hasGemProperty.and(mat -> mat.hasFlag(GENERATE_BOULE) || (mat.hasFlag(CRYSTALLIZABLE) && !mat.hasFlag(DISABLE_CRYSTALLIZATION))));

    public static final TagPrefix crucible = new TagPrefix("crucible")
            .itemTable(() -> EPBlocks.CRUCIBLE_BLOCKS)
            .miningToolTag(GTToolType.WRENCH.harvestTags.get(0))
            .materialAmount(M * 8)
            .materialIconType(EPMaterialIconType.crucible)
            .unificationEnabled(true);

    public static void init() {/**/}
}
