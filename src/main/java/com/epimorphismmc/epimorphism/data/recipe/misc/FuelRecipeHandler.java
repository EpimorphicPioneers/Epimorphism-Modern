package com.epimorphismmc.epimorphism.data.recipe.misc;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.epimorphismmc.epimorphism.common.data.EPMaterials.DenseHydrazineMixtureFuel;
import static com.epimorphismmc.epimorphism.common.data.EPMaterials.MethylhydrazineNitrateRocketFuel;
import static com.epimorphismmc.epimorphism.common.data.EPMaterials.RP1RocketFuel;
import static com.epimorphismmc.epimorphism.common.data.EPMaterials.UDMHRocketFuel;
import static com.epimorphismmc.epimorphism.common.data.EPRecipeTypes.ACIDIC_FUEL_CELL_FUELS;
import static com.epimorphismmc.epimorphism.common.data.EPRecipeTypes.NAQUADAH_REACTOR_FUELS;
import static com.epimorphismmc.epimorphism.common.data.EPRecipeTypes.ROCKET_ENGINE_FUELS;
import static com.epimorphismmc.epimorphism.common.data.EPRecipeTypes.SEMILIQUID_GENERATOR_FUELS;
import static com.gregtechceu.gtceu.api.GTValues.EV;
import static com.gregtechceu.gtceu.api.GTValues.IV;
import static com.gregtechceu.gtceu.api.GTValues.LV;
import static com.gregtechceu.gtceu.api.GTValues.LuV;
import static com.gregtechceu.gtceu.api.GTValues.UV;
import static com.gregtechceu.gtceu.api.GTValues.V;
import static com.gregtechceu.gtceu.api.GTValues.ZPM;
import static com.gregtechceu.gtceu.common.data.GTMaterials.AceticAcid;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Biomass;
import static com.gregtechceu.gtceu.common.data.GTMaterials.CoalTar;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Creosote;
import static com.gregtechceu.gtceu.common.data.GTMaterials.DilutedHydrochloricAcid;
import static com.gregtechceu.gtceu.common.data.GTMaterials.DilutedSulfuricAcid;
import static com.gregtechceu.gtceu.common.data.GTMaterials.FishOil;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Glycerol;
import static com.gregtechceu.gtceu.common.data.GTMaterials.HeavyFuel;
import static com.gregtechceu.gtceu.common.data.GTMaterials.HydrochloricAcid;
import static com.gregtechceu.gtceu.common.data.GTMaterials.HydrofluoricAcid;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Hydrogen;
import static com.gregtechceu.gtceu.common.data.GTMaterials.HypochlorousAcid;
import static com.gregtechceu.gtceu.common.data.GTMaterials.NitricAcid;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Oil;
import static com.gregtechceu.gtceu.common.data.GTMaterials.OilHeavy;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Oxygen;
import static com.gregtechceu.gtceu.common.data.GTMaterials.PhosphoricAcid;
import static com.gregtechceu.gtceu.common.data.GTMaterials.SeedOil;
import static com.gregtechceu.gtceu.common.data.GTMaterials.SulfuricAcid;
import static com.gregtechceu.gtceu.common.data.GTMaterials.SulfuricHeavyFuel;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Water;
import static com.gregtechceu.gtceu.common.data.GTMaterials.WoodTar;

public class FuelRecipeHandler {
    public static void init(Consumer<FinishedRecipe> provider) {
        semiLiquidFuels(provider);
        rocketFuels(provider);
        acidFuelCellFuels(provider);
        naquadahReactorFuels(provider);
    }

    private static void semiLiquidFuels(Consumer<FinishedRecipe> provider) {
        // Calorific Value: 4
        SEMILIQUID_GENERATOR_FUELS
                .recipeBuilder(SeedOil.getName())
                .inputFluids(SeedOil.getFluid(8))
                .duration(1)
                .EUt(-V[LV])
                .save(provider);

        // Calorific Value: 4
        SEMILIQUID_GENERATOR_FUELS
                .recipeBuilder(FishOil.getName())
                .inputFluids(FishOil.getFluid(8))
                .duration(1)
                .EUt(-V[LV])
                .save(provider);

        // Calorific Value: 16
        SEMILIQUID_GENERATOR_FUELS
                .recipeBuilder(WoodTar.getName())
                .inputFluids(WoodTar.getFluid(2))
                .duration(1)
                .EUt(-V[LV])
                .save(provider);

        // Calorific Value: 16
        SEMILIQUID_GENERATOR_FUELS
                .recipeBuilder(Biomass.getName())
                .inputFluids(Biomass.getFluid(2))
                .duration(1)
                .EUt(-V[LV])
                .save(provider);

        // Calorific Value: 32
        SEMILIQUID_GENERATOR_FUELS
                .recipeBuilder(CoalTar.getName())
                .inputFluids(CoalTar.getFluid(1))
                .duration(1)
                .EUt(-V[LV])
                .save(provider);

        // Calorific Value: 40
        SEMILIQUID_GENERATOR_FUELS
                .recipeBuilder(Oil.getName())
                .inputFluids(Oil.getFluid(4))
                .duration(5)
                .EUt(-V[LV])
                .save(provider);

        // Calorific Value: 48
        SEMILIQUID_GENERATOR_FUELS
                .recipeBuilder(Creosote.getName())
                .inputFluids(Creosote.getFluid(2))
                .duration(3)
                .EUt(-V[LV])
                .save(provider);

        // Calorific Value: 60
        SEMILIQUID_GENERATOR_FUELS
                .recipeBuilder(OilHeavy.getName())
                .inputFluids(OilHeavy.getFluid(8))
                .duration(15)
                .EUt(-V[LV])
                .save(provider);

        // Calorific Value: 80
        SEMILIQUID_GENERATOR_FUELS
                .recipeBuilder(SulfuricHeavyFuel.getName())
                .inputFluids(SulfuricHeavyFuel.getFluid(2))
                .duration(5)
                .EUt(-V[LV])
                .save(provider);

        // Calorific Value: 328
        SEMILIQUID_GENERATOR_FUELS
                .recipeBuilder(Glycerol.getName())
                .inputFluids(Glycerol.getFluid(4))
                .duration(41)
                .EUt(-V[LV])
                .save(provider);

        // Calorific Value: 360
        SEMILIQUID_GENERATOR_FUELS
                .recipeBuilder(HeavyFuel.getName())
                .inputFluids(HeavyFuel.getFluid(4))
                .duration(45)
                .EUt(-V[LV])
                .save(provider);
    }

    private static void rocketFuels(Consumer<FinishedRecipe> provider) {
        ROCKET_ENGINE_FUELS
                .recipeBuilder(RP1RocketFuel.getName())
                .inputFluids(RP1RocketFuel.getFluid(4))
                .duration(3)
                .EUt(-V[EV])
                .save(provider);
        ROCKET_ENGINE_FUELS
                .recipeBuilder(DenseHydrazineMixtureFuel.getName())
                .inputFluids(DenseHydrazineMixtureFuel.getFluid(2))
                .duration(3)
                .EUt(-V[EV])
                .save(provider);
        ROCKET_ENGINE_FUELS
                .recipeBuilder(MethylhydrazineNitrateRocketFuel.getName())
                .inputFluids(MethylhydrazineNitrateRocketFuel.getFluid(1))
                .duration(3)
                .EUt(-V[EV])
                .save(provider);
        ROCKET_ENGINE_FUELS
                .recipeBuilder(UDMHRocketFuel.getName())
                .inputFluids(UDMHRocketFuel.getFluid(1))
                .duration(6)
                .EUt(-V[EV])
                .save(provider);
    }

    private static void acidFuelCellFuels(Consumer<FinishedRecipe> provider) {
        ACIDIC_FUEL_CELL_FUELS
                .recipeBuilder(SulfuricAcid.getName())
                .inputFluids(SulfuricAcid.getFluid(4))
                .inputFluids(Hydrogen.getFluid(4))
                .inputFluids(Oxygen.getFluid(2))
                .outputFluids(Water.getFluid(2))
                .duration(5)
                .EUt(-V[LV])
                .save(provider);

        ACIDIC_FUEL_CELL_FUELS
                .recipeBuilder(DilutedSulfuricAcid.getName())
                .inputFluids(DilutedSulfuricAcid.getFluid(8))
                .inputFluids(Hydrogen.getFluid(4))
                .inputFluids(Oxygen.getFluid(2))
                .outputFluids(Water.getFluid(2))
                .duration(5)
                .EUt(-V[LV])
                .save(provider);

        ACIDIC_FUEL_CELL_FUELS
                .recipeBuilder(HydrochloricAcid.getName())
                .inputFluids(HydrochloricAcid.getFluid(3))
                .inputFluids(Hydrogen.getFluid(4))
                .inputFluids(Oxygen.getFluid(2))
                .outputFluids(Water.getFluid(2))
                .duration(5)
                .EUt(-V[LV])
                .save(provider);

        ACIDIC_FUEL_CELL_FUELS
                .recipeBuilder(DilutedHydrochloricAcid.getName())
                .inputFluids(DilutedHydrochloricAcid.getFluid(6))
                .inputFluids(Hydrogen.getFluid(4))
                .inputFluids(Oxygen.getFluid(2))
                .outputFluids(Water.getFluid(2))
                .duration(5)
                .EUt(-V[LV])
                .save(provider);

        ACIDIC_FUEL_CELL_FUELS
                .recipeBuilder(NitricAcid.getName())
                .inputFluids(NitricAcid.getFluid(3))
                .inputFluids(Hydrogen.getFluid(4))
                .inputFluids(Oxygen.getFluid(2))
                .outputFluids(Water.getFluid(2))
                .duration(5)
                .EUt(-V[LV])
                .save(provider);

        // TODO: 等待GTM更新后添加回来
        //        ACIDIC_FUEL_CELL_FUELS.recipeBuilder(FormicAcid.getName())
        //                .inputFluids(FormicAcid.getFluid(1))
        //                .inputFluids(Hydrogen.getFluid(8))
        //                .inputFluids(Oxygen.getFluid(4))
        //                .outputFluids(Water.getFluid(4))
        //                .duration(10)
        //                .EUt(-V[LV])
        //                .save(provider);

        ACIDIC_FUEL_CELL_FUELS
                .recipeBuilder(AceticAcid.getName())
                .inputFluids(AceticAcid.getFluid(4))
                .inputFluids(Hydrogen.getFluid(4))
                .inputFluids(Oxygen.getFluid(2))
                .outputFluids(Water.getFluid(2))
                .duration(5)
                .EUt(-V[LV])
                .save(provider);

        ACIDIC_FUEL_CELL_FUELS
                .recipeBuilder(HypochlorousAcid.getName())
                .inputFluids(HypochlorousAcid.getFluid(2))
                .inputFluids(Hydrogen.getFluid(4))
                .inputFluids(Oxygen.getFluid(2))
                .outputFluids(Water.getFluid(2))
                .duration(5)
                .EUt(-V[LV])
                .save(provider);

        ACIDIC_FUEL_CELL_FUELS
                .recipeBuilder(PhosphoricAcid.getName())
                .inputFluids(PhosphoricAcid.getFluid(1))
                .inputFluids(Hydrogen.getFluid(4))
                .inputFluids(Oxygen.getFluid(2))
                .outputFluids(Water.getFluid(2))
                .duration(5)
                .EUt(-V[LV])
                .save(provider);

        ACIDIC_FUEL_CELL_FUELS
                .recipeBuilder(HydrofluoricAcid.getName())
                .inputFluids(HydrofluoricAcid.getFluid(1))
                .inputFluids(Hydrogen.getFluid(4))
                .inputFluids(Oxygen.getFluid(2))
                .outputFluids(Water.getFluid(4))
                .duration(5)
                .EUt(-V[LV])
                .save(provider);
    }

    private static void naquadahReactorFuels(Consumer<FinishedRecipe> provider) {
        NAQUADAH_REACTOR_FUELS
                .recipeBuilder("naquadah_reactor_I")
                .inputItems(TagPrefix.bolt, GTMaterials.NaquadahEnriched)
                .outputItems(TagPrefix.bolt, GTMaterials.Naquadah)
                .duration((int) (50_000_000L / V[EV]))
                .EUt(-V[EV])
                .save(provider);
        NAQUADAH_REACTOR_FUELS
                .recipeBuilder("naquadah_reactor_II")
                .inputItems(TagPrefix.rod, GTMaterials.NaquadahEnriched)
                .outputItems(TagPrefix.rod, GTMaterials.Naquadah)
                .duration((int) (250_000_000L / V[IV]))
                .EUt(-V[IV])
                .save(provider);
        NAQUADAH_REACTOR_FUELS
                .recipeBuilder("naquadah_reactor_III")
                .inputItems(TagPrefix.rodLong, GTMaterials.NaquadahEnriched)
                .outputItems(TagPrefix.rodLong, GTMaterials.Naquadah)
                .duration((int) (500_000_000L / V[LuV]))
                .EUt(-V[LuV])
                .save(provider);
        NAQUADAH_REACTOR_FUELS
                .recipeBuilder("naquadah_reactor_IV")
                .inputItems(TagPrefix.bolt, GTMaterials.Naquadria)
                .outputItems(TagPrefix.bolt, GTMaterials.Naquadah)
                .duration((int) (250_000_000L / V[ZPM]))
                .EUt(-V[ZPM])
                .save(provider);
        NAQUADAH_REACTOR_FUELS
                .recipeBuilder("naquadah_reactor_V")
                .inputItems(TagPrefix.rod, GTMaterials.Naquadria)
                .outputItems(TagPrefix.rod, GTMaterials.Naquadah)
                .duration((int) (1_000_000_000L / V[UV]))
                .EUt(-V[UV])
                .save(provider);
    }
}
