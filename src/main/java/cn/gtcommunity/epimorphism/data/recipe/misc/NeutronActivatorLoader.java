package cn.gtcommunity.epimorphism.data.recipe.misc;

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
                .duration(800).save(provider);

//        COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder("test2")
//                .inputItems(GTBlocks.SUPERCONDUCTING_COIL.asStack())
//                .inputItems(CustomTags.ZPM_CIRCUITS, 4)
//                .inputItems(TagPrefix.plateDouble, GTMaterials.Plutonium241)
//                .inputItems(TagPrefix.plateDouble, GTMaterials.Osmiridium)
//                .inputItems(GTItems.FIELD_GENERATOR_IV, 2)
//                .inputItems(GTItems.ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT, 64)
//                .inputFluids(GTMaterials.SolderingAlloy.getFluid(GTValues.L * 8))
//                .outputItems(GTMachines.FUSION_REACTOR[GTValues.LuV].asStack())
//                .duration(800).EUt(30).save(provider);

        CHEMICAL_PLANT_RECIPES.recipeBuilder("test3")
                .inputItems(GTBlocks.SUPERCONDUCTING_COIL.asStack())
                .inputItems(CustomTags.ZPM_CIRCUITS, 4)
                .inputFluids(GTMaterials.SolderingAlloy.getFluid(GTValues.L * 8))
                .outputItems(GTMachines.FUSION_REACTOR[GTValues.LuV].asStack())
                .duration(800).EUt(30).save(provider);
    }
}
