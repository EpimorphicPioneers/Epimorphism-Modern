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


public class CBDOPolycarbonateChain {
    public static void init(Consumer<FinishedRecipe> provider) {
        //  Propene + Carbon Monoxide + Water -> Isobutyric Acid
        LARGE_CHEMICAL_RECIPES.recipeBuilder("isobutyric_acid")
                .inputFluids(Propene.getFluid(1000))
                .inputFluids(CarbonMonoxide.getFluid(1000))
                .inputFluids(Water.getFluid(1000))
                .outputFluids(IsobutyricAcid.getFluid(1000))
                .EUt(VA[HV])
                .duration(180)
                .save(provider);

        //  Isobutyric Acid + Acetic Anhydride -> Isobutyric Anhydride + Acetic Acid
        DISSOLUTION_TANK_RECIPES.recipeBuilder("isobutyric_anhydride_and_acetic_acid")
                .inputFluids(IsobutyricAcid.getFluid(2000))
                .inputFluids(AceticAnhydride.getFluid(1000))
                .outputFluids(IsobutyricAnhydride.getFluid(1000))
                .outputFluids(AceticAcid.getFluid(2000))
                .EUt(VA[EV])
                .duration(60)
                .save(provider);

        //  Isobutyric Anhyride -> Dimethylketene + Water
        PYROLYSE_RECIPES.recipeBuilder("dimethylketene_and_water")
                .notConsumable(rodLong, YttriumBariumCuprate)
                .inputFluids(IsobutyricAnhydride.getFluid(1000))
                .outputFluids(Dimethylketene.getFluid(2000))
                .EUt(VA[LuV])
                .duration(240)
                .save(provider);

        //  Dimethylketene + Hydrogen -> Tetramethylcyclobutanediol
        CHEMICAL_PLANT_RECIPES.recipeBuilder("tetramethylcyclobutanediol")
                .notConsumable(dust, Rhenium)
                .inputFluids(Dimethylketene.getFluid(2000))
                .inputFluids(Hydrogen.getFluid(4000))
                .outputFluids(Tetramethylcyclobutanediol.getFluid(1000))
                .EUt(VA[UV])
                .duration(120)
                .save(provider);

        //  CBDO Polycarbonate
        CHEMICAL_RECIPES.recipeBuilder("cbdo_polycarbonate")
                .inputFluids(Tetramethylcyclobutanediol.getFluid(1000))
                .inputFluids(DiphenylCarbonate.getFluid(1000))
                .outputFluids(CBDOPolycarbonate.getFluid(144))
                .outputFluids(Phenol.getFluid(2000))
                .EUt(VA[MV])
                .duration(160)
                .save(provider);
    }
}
