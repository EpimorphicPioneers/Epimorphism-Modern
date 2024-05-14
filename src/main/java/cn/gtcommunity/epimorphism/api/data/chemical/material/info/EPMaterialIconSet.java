package cn.gtcommunity.epimorphism.api.data.chemical.material.info;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.client.renderer.handler.item.StereoscopicItemRenderer;
import cn.gtcommunity.epimorphism.common.item.behaviors.renderer.HaloRenderItemBehavior;
import cn.gtcommunity.epimorphism.common.item.behaviors.renderer.SimpleRenderItemBehavior;
import com.epimorphismmc.monomorphism.data.chemical.material.info.MOMaterialIconSet;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import net.minecraft.resources.ResourceLocation;

public class EPMaterialIconSet {
    public static final MOMaterialIconSet CUSTOM_INFINITY = new MOMaterialIconSet("infinity", null, true,
            new HaloRenderItemBehavior(10, 0xFF000000, new ResourceLocation(Epimorphism.MOD_ID, "sprite/halo"), true, true));

    public static final MOMaterialIconSet CUSTOM_NEUTRONIUM = new MOMaterialIconSet("neutronium", null, true,
            new HaloRenderItemBehavior(8, 0x99FFFFFF, new ResourceLocation(Epimorphism.MOD_ID, "sprite/halo_noise"), true, false));

    public static final MOMaterialIconSet CUSTOM_TRANSCENDENT_MENTAL = new MOMaterialIconSet("transcendent_mental", MaterialIconSet.DULL, false, new SimpleRenderItemBehavior(StereoscopicItemRenderer.INSTANCE));

    public static void init() {/**/}
}