package cn.gtcommunity.epimorphism.data.recipe.misc;

import cn.gtcommunity.epimorphism.common.data.EPMaterials;
import cn.gtcommunity.epimorphism.common.data.EPRecipeTypes;
import cn.gtcommunity.epimorphism.data.recipe.EPRecipeUtil;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.Locale;
import java.util.function.Consumer;

public class LargeNaquadahReactorLoader {

    public static void init(Consumer<FinishedRecipe> provider) {
        coolant(provider);
        excitedFluid(provider);

        EPRecipeTypes.LARGE_NAQUADAH_REACTOR_FUELS.recipeBuilder("thorium_based_liquid_fuel_depleted")
                .inputFluids(EPMaterials.ThoriumBasedLiquidFuelExcited.getFluid(1000))
                .outputFluids(EPMaterials.ThoriumBasedLiquidFuelDepleted.getFluid(1000))
                .EUt(-2200)
                .duration(EPRecipeUtil.second(25)).save(provider);
        EPRecipeTypes.LARGE_NAQUADAH_REACTOR_FUELS.recipeBuilder("uranium_based_liquid_fuel_depleted")
                .inputFluids(EPMaterials.UraniumBasedLiquidFuelExcited.getFluid(1000))
                .outputFluids(EPMaterials.UraniumBasedLiquidFuelDepleted.getFluid(1000))
                .EUt(-12960)
                .duration(EPRecipeUtil.second(5)).save(provider);
        EPRecipeTypes.LARGE_NAQUADAH_REACTOR_FUELS.recipeBuilder("plutonium_based_liquid_fuel_depleted")
                .inputFluids(EPMaterials.PlutoniumBasedLiquidFuelExcited.getFluid(1000))
                .outputFluids(EPMaterials.PlutoniumBasedLiquidFuelDepleted.getFluid(1000))
                .EUt(-32400)
                .duration(EPRecipeUtil.second(7.5)).save(provider);
    }

    private static void coolant(Consumer<FinishedRecipe> provider) {
        registerCoolant(EPMaterials.GelidCryotheum, 275, 1000, provider);
    }

    private static void excitedFluid(Consumer<FinishedRecipe> provider) {
        registerExcitedFluid(GTMaterials.Caesium, 2, 180, provider);
        registerExcitedFluid(GTMaterials.Uranium235, 3, 180, provider);
        registerExcitedFluid(GTMaterials.Naquadah, 4, 20, provider);
    }

    private static void registerCoolant(Material material, int efficiency, int consumption_rate, Consumer<FinishedRecipe> provider) {
        EPRecipeTypes.LARGE_NAQUADAH_COOLANT_LIST.recipeBuilder("large_naquadah_coolant.%s".formatted(material.getName().toLowerCase(Locale.ROOT)))
                .inputFluids(material.getFluid(consumption_rate))
                .duration(20)
                .addData("efficiency", efficiency)
                .addData("consumption_rate", consumption_rate)
                .save(provider);
    }

    private static void registerExcitedFluid(Material material, int parallel, int consumption_rate, Consumer<FinishedRecipe> provider) {
        EPRecipeTypes.LARGE_NAQUADAH_EXCITED_FLUID_LIST.recipeBuilder("large_naquadah_excited_fluid.%s".formatted(material.getName().toLowerCase(Locale.ROOT)))
                .inputFluids(material.getFluid(consumption_rate))
                .duration(20)
                .addData("parallel", parallel)
                .addData("consumption_rate", consumption_rate)
                .save(provider);
    }
}
