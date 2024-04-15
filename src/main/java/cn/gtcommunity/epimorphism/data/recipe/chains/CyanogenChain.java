package cn.gtcommunity.epimorphism.data.recipe.chains;

import cn.gtcommunity.epimorphism.common.recipe.NeutronKineticEnergyCondition;
import com.gregtechceu.gtceu.api.machine.multiblock.CleanroomType;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static cn.gtcommunity.epimorphism.common.data.EPMaterials.*;
import static cn.gtcommunity.epimorphism.common.data.EPRecipeTypes.*;
import static cn.gtcommunity.epimorphism.utils.EPMathUtil.K;
import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;


public class CyanogenChain {
    public static void init(Consumer<FinishedRecipe> provider) {

        //  Hydrogen + Ammonia + Methane -> Hydrogen Cyanide + Water
        CHEMICAL_RECIPES.recipeBuilder("hydrogen_cyanide_and_water")
                .inputFluids(Hydrogen.getFluid(1000))
                .inputFluids(Ammonia.getFluid(1000))
                .inputFluids(Methane.getFluid(1000))
                .circuitMeta(3)
                .outputFluids(HydrogenCyanide.getFluid(1000))
                .outputFluids(Water.getFluid(3000))
                .EUt(VA[MV])
                .duration(120)
                .save(provider);

        //  Methane + Ammonia + Oxygen + Platinum -> Hydrogen Cyanide + Steam
        BURNER_REACTOR_RECIPES.recipeBuilder("hydrogen_cyanide_and_steam")
                .inputFluids(Methane.getFluid(1000))
                .inputFluids(Ammonia.getFluid(1000))
                .inputFluids(Oxygen.getFluid(1000))
                .notConsumable(dust, Platinum)
                .outputFluids(HydrogenCyanide.getFluid(3000))
                .outputFluids(Steam.getFluid(3000))
                //.temperature(1473)
                .duration(60)
                .EUt(VA[HV])
                .save(provider);

        //  Potassium Hydroxide + Hydrogen Cyanide -> Potassium Cyanide + Water
        CHEMICAL_RECIPES.recipeBuilder("potassium_cyanide_and_water")
                .inputFluids(PotassiumHydroxide.getFluid(1000))
                .inputFluids(HydrogenCyanide.getFluid(1000))
                .circuitMeta(0)
                .outputItems(dust, PotassiumCyanide, 3)
                .outputFluids(Water.getFluid(1000))
                .EUt(1920)
                .duration(200)
                .save(provider);
    }
}