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

public class BoronChain {
    public static void init(Consumer<FinishedRecipe> provider) {

        //  Boric Acid + Hydrofluoric Acid -> Fluoroboric Acid + Water
        CHEMICAL_RECIPES.recipeBuilder("")
                .inputFluids(BoricAcid.getFluid(1000))
                .inputFluids(HydrofluoricAcid.getFluid(4000))
                .outputFluids(FluoroboricAcid.getFluid(1000))
                .outputFluids(Water.getFluid(3000))
                .EUt(VA[MV])
                .duration(100)
                .save(provider);

        //  Sodium Nitrite + Fluoroboric Acid + Hydrochloric Acid -> Salt + Benzenediazonium Tetrafluoroborate + Water
        CHEMICAL_PLANT_RECIPES.recipeBuilder("")
                .inputItems(dust, SodiumNitrite, 4)
                .inputFluids(FluoroboricAcid.getFluid(2000))
                .inputFluids(HydrochloricAcid.getFluid(1000))
                .outputItems(dust, Salt, 2)
                .outputFluids(BenzenediazoniumTetrafluoroborate.getFluid(1000))
                .outputFluids(Water.getFluid(2000))
                //.CasingTier(5)
                .EUt(VA[LuV])
                .duration(120)
                .save(provider);

        //  Benzenediazonium Tetrafluoroborate -> Boron Trifluoride + Nitrogen + Fluorobenzene
        DISTILLATION_RECIPES.recipeBuilder("")
                .inputFluids(BenzenediazoniumTetrafluoroborate.getFluid(1000))
                .outputFluids(BoronTrifluoride.getFluid(3000))
                .outputFluids(Nitrogen.getFluid(2000))
                .outputFluids(Fluorobenzene.getFluid(1000))
                .EUt(VA[UV])
                .duration(6000)
                .save(provider);

        //  Sodium + Nitric Acid + Oxygen -> Sodium Nitrate + Water
        CHEMICAL_RECIPES.recipeBuilder("")
                .inputItems(dust, Sodium)
                .circuitMeta(1)
                .inputFluids(NitricAcid.getFluid(2000))
                .inputFluids(Oxygen.getFluid(1000))
                .outputItems(dust, SodiumNitrate, 10)
                .outputFluids(Water.getFluid(1000))
                .EUt(60)
                .duration(20)
                .save(provider);

        //  Sodium Nitrate + Co/AC-AB Catalyst -> Sodium Nitrite + Oxygen + Water
        CHEMICAL_PLANT_RECIPES.recipeBuilder("")
                .notConsumable(dust, CoACABCatalyst)
                .inputFluids(SodiumNitrate.getFluid(1000))
                .outputItems(dust, SodiumNitrite, 4)
                .outputFluids(Oxygen.getFluid(1000))
                .outputFluids(Water.getFluid(1000))
                //.CasingTier(1)
                .EUt(VA[MV])
                .duration(300)
                .save(provider);

        //  Co/AC-AB Catalyst (UV)
        CVD_RECIPES.recipeBuilder("")
                .inputItems(dust, Cobalt)
                .inputItems(dust, Charcoal, 2)
                .inputFluids(Polybenzimidazole.getFluid(144))
                .inputFluids(Acetylene.getFluid(1000))
                .inputFluids(Steam.getFluid(1000))
                .outputItems(dust, CoACABCatalyst)
                .outputFluids(Hydrogen.getFluid(4000))
                .outputFluids(CarbonMonoxide.getFluid(1000))
                .EUt(VA[UV])
                .duration(120)
                //.temperature(688)
                .save(provider);

        //  Co/AC-AB Catalyst (UHV)
        MOLECULAR_BEAM_RECIPES.recipeBuilder("")
                .inputItems(foil, Polybenzimidazole)
                .inputItems(dust, Cobalt)
                .inputItems(dust, Charcoal, 2)
                .inputFluids(Acetylene.getFluid(1000))
                .inputFluids(Steam.getFluid(1000))
                .outputItems(dust, CoACABCatalyst)
                .EUt(VA[UHV])
                .duration(240)
                //.temperature(2688)
                .save(provider);
    }
}
