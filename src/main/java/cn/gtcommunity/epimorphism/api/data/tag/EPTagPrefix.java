package cn.gtcommunity.epimorphism.api.data.tag;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.api.data.chemical.material.info.EPMaterialIconType;
import cn.gtcommunity.epimorphism.common.data.EPBlocks;
import cn.gtcommunity.epimorphism.common.item.behaviors.renderer.HaloItemBehavior;
import com.epimorphismmc.monomorphism.data.tag.MOTagPrefix;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.api.item.tool.GTToolType;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import static cn.gtcommunity.epimorphism.api.data.chemical.material.info.EPMaterialFlags.*;
import static cn.gtcommunity.epimorphism.api.data.tag.EPTagPrefix.Conditions.hasGas;
import static cn.gtcommunity.epimorphism.common.data.items.EPChemistryItem.CATALYST_ITEMS;
import static com.gregtechceu.gtceu.api.GTValues.M;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.CRYSTALLIZABLE;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.NO_SMASHING;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.Conditions.*;

public class EPTagPrefix {
    public static final TagPrefix singularity = new MOTagPrefix("singularity",
            new HaloItemBehavior(4, 0xFF000000, new ResourceLocation(Epimorphism.MOD_ID, "sprite/halo"), true, false))
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
            .defaultTagPath("seed_crystal/%s")
            .unformattedTagPath("seed_crystal")
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

    public static final TagPrefix nanites = new TagPrefix("nanites")
            .defaultTagPath("nanites/%s")
            .unformattedTagPath("nanites")
            .materialAmount(-1)
            .materialIconType(EPMaterialIconType.nanites)
            .unificationEnabled(true)
            .generateItem(true)
            .generationCondition(hasDustProperty.and(mat -> mat.hasFlag(GENERATE_NANITES) && !mat.hasFlag(NO_SMASHING)));

    public static final TagPrefix laserEmitter = new TagPrefix("laserEmitter")
            .defaultTagPath("laser_emitter/%s")
            .unformattedTagPath("laser_emitter")
            .materialAmount(-1)
            .materialIconType(EPMaterialIconType.laserEmitter)
            .unificationEnabled(true)
            .generateItem(true)
            .generationCondition(hasGas.and(mat -> mat.hasFlag(GENERATE_LASER_EMITTER)));

    public static final TagPrefix catalyst = new TagPrefix("catalyst")
            .defaultTagPath("catalyst/%s")
            .unformattedTagPath("catalyst")
            .itemTable(() -> CATALYST_ITEMS)
            .materialAmount(-1)
            .materialIconType(EPMaterialIconType.catalyst)
            .unificationEnabled(true);

    public static final TagPrefix crucible = new TagPrefix("crucible")
            .defaultTagPath("crucible/%s")
            .unformattedTagPath("crucible")
            .itemTable(() -> EPBlocks.CRUCIBLE_BLOCKS)
            .miningToolTag(GTToolType.WRENCH.harvestTags.get(0))
            .materialAmount(M * 8)
            .materialIconType(EPMaterialIconType.crucible)
            .blockProperties(() -> RenderType::cutout, UnaryOperator.identity())
            .unificationEnabled(true);

    public static final TagPrefix fence = new TagPrefix("fence")
            .defaultTagPath("fences/%s")
            .unformattedTagPath("fences")
            .unformattedTagPath("fences", true)
            .itemTable(() -> EPBlocks.FENCE_BLOCKS)
            .miningToolTag(GTToolType.WRENCH.harvestTags.get(0))
            .materialAmount(M * 6)
            .materialIconType(EPMaterialIconType.fence)
            .blockProperties(() -> RenderType::cutout, p -> p.forceSolidOn().instrument(NoteBlockInstrument.BASS))
            .unificationEnabled(true);

    public static class Conditions {
        public static final Predicate<Material> hasGas = mat -> mat.hasProperty(PropertyKey.FLUID)
                && mat.getProperty(PropertyKey.FLUID).getStorage().getEntry(FluidStorageKeys.GAS) != null;
    }

    public static void init() {/**/}
}
