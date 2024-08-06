package com.epimorphismmc.epimorphism.data.recipe.chains;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.epimorphismmc.epimorphism.common.data.EPMaterials.*;
import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;

public class ChlorineChain {
    public static void init(Consumer<FinishedRecipe> provider) {

        //  Chlorinated Solvents
        MIXER_RECIPES
                .recipeBuilder("chlorinated_solvents")
                .inputFluids(Methane.getFluid(2000))
                .inputFluids(Chlorine.getFluid(5000))
                .outputFluids(ChlorinatedSolvents.getFluid(7000))
                .EUt(VA[EV])
                .duration(240)
                .save(provider);
    }
}
