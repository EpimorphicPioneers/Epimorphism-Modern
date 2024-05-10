package cn.gtcommunity.epimorphism.data.recipe.misc;

import cn.gtcommunity.epimorphism.common.recipe.HeatCapacityCondituon;
import cn.gtcommunity.epimorphism.common.recipe.NeutronEnergyCondition;
import cn.gtcommunity.epimorphism.common.recipe.PACasingCondition;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMachines;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static cn.gtcommunity.epimorphism.common.data.EPRecipeTypes.*;
import static cn.gtcommunity.epimorphism.utils.EPMathUtil.*;

public class NeutronActivatorLoader {
    public static void init(Consumer<FinishedRecipe> provider) {
        NEUTRON_ACTIVATOR_RECIPES.recipeBuilder("test1")
                .inputItems(GTBlocks.SUPERCONDUCTING_COIL.asStack())
                .inputItems(CustomTags.ZPM_CIRCUITS, 4)
                .inputItems(TagPrefix.plateDouble, GTMaterials.Plutonium241)
                .inputItems(TagPrefix.plateDouble, GTMaterials.Osmiridium)
                .inputItems(GTItems.FIELD_GENERATOR_IV, 2)
                .inputItems(GTItems.ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT, 64)
                .inputFluids(GTMaterials.SolderingAlloy.getFluid(GTValues.L * 8))
                .outputItems(GTMachines.FUSION_REACTOR[GTValues.LuV].asStack())
                .addCondition(new NeutronEnergyCondition(400 * K, 500 * M))
                .duration(800).save(provider);
        PRECISE_ASSEMBLER_RECIPES.recipeBuilder("test2")
                .inputItems(GTBlocks.SUPERCONDUCTING_COIL.asStack())
                .inputItems(CustomTags.ZPM_CIRCUITS, 4)
                .inputFluids(GTMaterials.SolderingAlloy.getFluid(GTValues.L * 8))
                .outputItems(GTMachines.FUSION_REACTOR[GTValues.LuV].asStack())
                .addCondition(new PACasingCondition(PACasingCondition.MK_3))
                .duration(800).EUt(30).save(provider);
        MOLECULAR_BEAM_RECIPES.recipeBuilder("test3")
                .inputItems(GTBlocks.SUPERCONDUCTING_COIL.asStack())
                .inputItems(CustomTags.ZPM_CIRCUITS, 4)
                .inputFluids(GTMaterials.SolderingAlloy.getFluid(GTValues.L * 8))
                .outputItems(GTMachines.FUSION_REACTOR[GTValues.LuV].asStack())
                .addCondition(new HeatCapacityCondituon(3000))
                .duration(800).EUt(30).save(provider);
    }
}
