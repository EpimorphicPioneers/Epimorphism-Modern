package cn.gtcommunity.epimorphism.api.chemical.material.info;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.common.item.behaviors.renderer.HaloRenderItemBehavior;
import net.minecraft.resources.ResourceLocation;

public class EPMaterialIconSet {
    public static final RenderMaterialIconSet CUSTOM_INFINITY = new RenderMaterialIconSet("infinity", null, true,
            new HaloRenderItemBehavior(10, 0xFF000000, new ResourceLocation(Epimorphism.MOD_ID, "sprite/halo"), true, true));

    public static final RenderMaterialIconSet CUSTOM_NEUTRONIUM = new RenderMaterialIconSet("neutronium", null, true,
            new HaloRenderItemBehavior(8, 0x99FFFFFF, new ResourceLocation(Epimorphism.MOD_ID, "sprite/halo_noise"), true, false));

    public static void init() {/**/}
}