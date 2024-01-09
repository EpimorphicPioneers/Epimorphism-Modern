package cn.gtcommunity.epimorphism.data.recipe.misc;

import com.gregtechceu.gtceu.data.recipe.CustomTags;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTBlocks.*;
import static com.gregtechceu.gtceu.common.data.GTItems.*;
import static com.gregtechceu.gtceu.common.data.GTMachines.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static cn.gtcommunity.epimorphism.common.data.EPRecipeTypes.*;

public class NeutronActivatorLoader {
    public static void init(Consumer<FinishedRecipe> provider) {
        NEUTRON_ACTIVATOR_RECIPES.recipeBuilder("test1")
                .inputItems(SUPERCONDUCTING_COIL.asStack())
                .inputItems(CustomTags.ZPM_CIRCUITS, 4)
                .inputItems(plateDouble, Plutonium241)
                .inputItems(plateDouble, Osmiridium)
                .inputItems(FIELD_GENERATOR_IV, 2)
                .inputItems(ULTRA_HIGH_POWER_INTEGRATED_CIRCUIT, 64)
                .inputFluids(SolderingAlloy.getFluid(L * 8))
                .outputItems(FUSION_REACTOR[LuV].asStack())
                .duration(800).save(provider);
    }
}
