package cn.gtcommunity.epimorphism.api.data.tag;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.api.chemical.material.info.EPMaterialIconType;
import cn.gtcommunity.epimorphism.common.item.behaviors.renderer.HaloRenderItemBehavior;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import net.minecraft.resources.ResourceLocation;

import static cn.gtcommunity.epimorphism.api.chemical.material.info.EPMaterialFlags.*;
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

    public static void init() {/**/}
}
