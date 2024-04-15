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

public class BismuthVanadiumChain {
    public static void init(Consumer<FinishedRecipe> provider) {
        //  Vanadium Magnetite + Carbon dust -> Iron + Vanadium Slag
        ROASTER_RECIPES.recipeBuilder("iron_and_vanadium_slag")
                .inputItems(dust, VanadiumMagnetite, 4)
                .inputItems(dust, Carbon)
                .outputItems(ingot, Iron, 3)
                .outputItems(dust, VanadiumSlag, 4)
                //.temperature(1500)
                .duration(220)
                .EUt(VA[MV])
                .save(provider);

        //  Vanadium Slag + Soda Ash -> Sodium Vanadate + Carbon Monoxide
        ROASTER_RECIPES.recipeBuilder("sodium_vanadate_and_carbon_monoxide")
                .inputItems(dust, SodaAsh, 18)
                .inputItems(dust, VanadiumSlag, 4)
                .outputItems(dust, SodiumVanadate, 16)
                .outputFluids(CarbonMonoxide.getFluid(3000))
                //.temperature(700)
                .duration(140)
                .EUt(VA[MV])
                .save(provider);

        //  Bismuth + Nitric Acid -> Bismuth Nitrate Solution + Nitrogen Dioxide + Water
        LARGE_CHEMICAL_RECIPES.recipeBuilder("bismuth_nitrate_solution_and_nitrogen_dioxide_and_water")
                .inputItems(dust, Bismuth)
                .inputFluids(NitricAcid.getFluid(6000))
                .circuitMeta(1)
                .outputFluids(BismuthNitrateSolution.getFluid(1000))
                .outputFluids(NitrogenDioxide.getFluid(3000))
                .outputFluids(Water.getFluid(2000))
                .EUt(VA[LV])
                .duration(300)
                .save(provider);

        //  Ammonium Vanadate + Bismuth Nitrate Solution + Ammonia + Water -> Bismuth Vanadate Solution + Ammonium Nitrate
        CHEMICAL_RECIPES.recipeBuilder("bismuth_vanadate_solution_and_ammonium_nitrate")
                .inputItems(dust, AmmoniumVanadate, 9)
                .inputFluids(BismuthNitrateSolution.getFluid(1000))
                .inputFluids(Ammonia.getFluid(2000))
                .inputFluids(Water.getFluid(1000))
                .outputFluids(BismuthVanadateSolution.getFluid(1000))
                .outputFluids(AmmoniumNitrate.getFluid(3000))
                .EUt(640)
                .duration(220)
                .save(provider);

        //  Bismuth Vanadate Solution -> Bismuth Vanadate
        DRYER_RECIPES.recipeBuilder("bismuth_vanadate")
                .inputFluids(BismuthVanadateSolution.getFluid(1000))
                .outputItems(dust, BismuthVanadate, 6)
                .outputFluids(Water.getFluid(200))
                .EUt(VA[HV])
                .duration(180)
                .save(provider);

        //  Sodium Vanadate + Ammonium Chloride + Sulfuric Acid -> Ammonium Vanadate + Vanadium Waste Solution
        CHEMICAL_RECIPES.recipeBuilder("ammonium_vanadate_and_vanadium_waste_solution")
                .inputItems(dust, SodiumVanadate, 8)
                .inputFluids(AmmoniumChloride.getFluid(1000))
                .inputFluids(SulfuricAcid.getFluid(1000))
                .circuitMeta(1)
                .outputItems(dust, AmmoniumVanadate, 9)
                .outputFluids(VanadiumWasteSolution.getFluid(1000))
                .EUt(VA[MV])
                .duration(120)
                .save(provider);

        //  Vanadium Waste Solution Cycle
        DRYER_RECIPES.recipeBuilder("vanadium_waste_solution_cycle")
                .inputFluids(VanadiumWasteSolution.getFluid(4000))
                .chancedOutput(dust, SiliconDioxide, 3, 5000, 1200)
                .chancedOutput(dust, AluminiumHydroxide, 7, 5000, 1200)
                .EUt(VA[MV])
                .duration(300)
                .save(provider);
    }
}
