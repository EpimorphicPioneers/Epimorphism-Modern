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
public class CaliforniumChain {
    public static void init(Consumer<FinishedRecipe> provider) {

        //  Californium -> Californium Nitrite
        CHEMICAL_RECIPES.recipeBuilder("californium_nitrite")
                .inputItems(dust, Californium)
                .inputFluids(NitricAcid.getFluid(2000))
                .outputItems(dust, CaliforniumNitrite, 3)
                .outputFluids(Hydrogen.getFluid(2000))
                .EUt(VA[MV])
                .duration(320)
                .save(provider);

        //  Californium Nitrite -> Californium Dioxide
        BLAST_RECIPES.recipeBuilder("californium_dioxide")
                .inputItems(dust, CaliforniumNitrite, 3)
                .outputItems(dust, CaliforniumDioxide)
                .outputFluids(NitrogenMonoxide.getFluid(2000))
                .EUt(VA[MV])
                .duration(144)
                .blastFurnaceTemp(600)
                .save(provider);

        //  Californium Dioxide -> Californium Hexachloride
        ROASTER_RECIPES.recipeBuilder("californium_hexachloride")
                .inputItems(dust, CaliforniumDioxide)
                .inputFluids(Chlorine.getFluid(6000))
                .outputFluids(CaliforniumHexachloride.getFluid(1000))
                .outputFluids(Oxygen.getFluid(2000))
                .EUt(VA[MV])
                .duration(960)
                //.temperature(1443)
                .save(provider);

        //  Californium Hexachloride -> Californium Hexafluoride
        CHEMICAL_RECIPES.recipeBuilder("californium_hexafluoride")
                .inputFluids(CaliforniumHexachloride.getFluid(1000))
                .inputFluids(HydrofluoricAcid.getFluid(6000))
                .outputFluids(CaliforniumHexafluoride.getFluid(1000))
                .outputFluids(DilutedHydrochloricAcid.getFluid(6000))
                .EUt(VA[HV])
                .duration(160)
                .save(provider);

        //  TODO Gas Centrifuge? Zalgo, please do it quickly TAT
        //  Californium Hexafluoride -> Californium-252 Hexafluoride
        CENTRIFUGE_RECIPES.recipeBuilder("californium_252_hexafluoride")
                .inputFluids(CaliforniumHexafluoride.getFluid(1000))
                .outputFluids(Californium252Hexafluoride.getFluid(900))
                .outputFluids(Californium.getFluid(100))
                .EUt(VA[EV])
                .duration(800)
                .save(provider);

        //  Californium-252 Hexafluoride -> Steam Cracked Californium-252 Hexafluoride
        CRACKING_RECIPES.recipeBuilder("steam_cracked_californium_252_hexafluoride")
                .inputFluids(Californium252Hexafluoride.getFluid(1000))
                .inputFluids(Steam.getFluid(3000))
                .outputFluids(SteamCrackedCalifornium252Hexafluoride.getFluid(1000))
                .EUt(VA[HV])
                .duration(640)
                .save(provider);

        //  Steam Cracked Californium-252 Hexafluoride -> Californium-252 Dioxide + Hydrofluoric Acid
        DISTILLATION_RECIPES.recipeBuilder("californium_252_dioxide_and_hydrofluoric_acid")
                .inputFluids(SteamCrackedCalifornium252Hexafluoride.getFluid(1000))
                .outputItems(dust, Californium252Dioxide, 3)
                .outputFluids(HydrofluoricAcid.getFluid(6000))
                .EUt(VA[MV])
                .duration(180)
                .save(provider);

        //  Californium-252 Dioxide -> Californium-252
        BLAST_RECIPES.recipeBuilder("californium_252")
                .inputItems(dust, Californium252Dioxide, 3)
                .outputItems(ingot, Californium252)
                .outputFluids(Oxygen.getFluid(2000))
                .EUt(VA[MV])
                .duration(1600)
                .blastFurnaceTemp(2300)
                .save(provider);
    }
}
