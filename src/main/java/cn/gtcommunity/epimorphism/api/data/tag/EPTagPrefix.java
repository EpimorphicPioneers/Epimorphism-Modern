package cn.gtcommunity.epimorphism.api.data.tag;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.api.chemical.material.info.EPMaterialIconType;
import cn.gtcommunity.epimorphism.common.item.behaviors.renderer.HaloRenderItemBehavior;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import net.minecraft.resources.ResourceLocation;

public class EPTagPrefix {
    public static final TagPrefix singularity = new RenderTagPrefix("singularity",
            new HaloRenderItemBehavior(4, 0xFF000000, new ResourceLocation(Epimorphism.MOD_ID, "sprite/halo"), true, false))
            .defaultTagPath("singularity/%s")
            .unformattedTagPath("singularity")
            .langValue("%s Singularity")
            .materialAmount(-1)
            .materialIconType(EPMaterialIconType.singularity)
            .unificationEnabled(true)
            .generateItem(true)
            .generationCondition(Material::isElement);

    public static void init() {/**/}
}
