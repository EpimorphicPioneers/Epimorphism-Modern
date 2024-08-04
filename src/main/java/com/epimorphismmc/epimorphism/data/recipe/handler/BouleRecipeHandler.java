package com.epimorphismmc.epimorphism.data.recipe.handler;

import com.gregtechceu.gtceu.api.capability.recipe.FluidRecipeCapability;
import com.gregtechceu.gtceu.api.capability.recipe.ItemRecipeCapability;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.GemProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialStack;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.data.recipe.builder.GTRecipeBuilder;

import com.lowdragmc.lowdraglib.side.fluid.FluidStack;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.ItemStack;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;

import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;

import javax.annotation.Nonnull;

import static com.epimorphismmc.epimorphism.api.data.chemical.material.info.EPMaterialFlags.DISABLE_CRYSTALLIZATION;
import static com.epimorphismmc.epimorphism.api.data.tag.EPTagPrefix.boule;
import static com.epimorphismmc.epimorphism.api.data.tag.EPTagPrefix.seedCrystal;
import static com.epimorphismmc.epimorphism.common.data.EPRecipeTypes.CRYSTALLIZATION_RECIPES;
import static com.gregtechceu.gtceu.api.GTValues.EV;
import static com.gregtechceu.gtceu.api.GTValues.HV;
import static com.gregtechceu.gtceu.api.GTValues.VA;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.CRYSTALLIZABLE;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.gem;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.gemExquisite;
import static com.gregtechceu.gtceu.common.data.GTMaterials.DistilledWater;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.AUTOCLAVE_RECIPES;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.CUTTER_RECIPES;

/**
 * 人造宝石相关配方
 */
public class BouleRecipeHandler {
    public static void init(Consumer<FinishedRecipe> provider) {
        gem.executeHandler(provider, PropertyKey.GEM, BouleRecipeHandler::processCrystallization);
    }

    private static void processCrystallization(
            TagPrefix gem,
            @Nonnull Material material,
            GemProperty property,
            Consumer<FinishedRecipe> provider) {
        //  If material has flag DISABLE_CRYSTALLIZATION, then do not generate crystallization of
        // material.
        if (!material.hasFlag(CRYSTALLIZABLE) || material.hasFlag(DISABLE_CRYSTALLIZATION)) return;

        //  If material has too may components, then do not generate recipe.
        if (material.getMaterialComponents().size()
                > CRYSTALLIZATION_RECIPES.getMaxInputs(ItemRecipeCapability.CAP)
                        - 1
                        + CRYSTALLIZATION_RECIPES.getMaxInputs(FluidRecipeCapability.CAP)) {
            return;
        }

        int componentAmount = 0;
        int temperature = 0;

        List<ItemStack> inputs = new ObjectArrayList<>();
        List<FluidStack> fluidInputs = new ObjectArrayList<>();

        for (MaterialStack materialStack : material.getMaterialComponents()) {
            Material componentMaterial = materialStack.material();
            int amount = (int) materialStack.amount();

            //  Check if material has dust property.
            if (componentMaterial.isSolid() || componentMaterial.hasProperty(PropertyKey.DUST)) {
                componentAmount += amount;
                temperature += componentMaterial.getBlastTemperature() * amount;

                //  If material has too may components, then do not generate recipe.
                if (inputs.size() > CRYSTALLIZATION_RECIPES.getMaxInputs(ItemRecipeCapability.CAP) - 1) {
                    return;
                }

                //  If okay, load its components into recipe.
                inputs.add(ChemicalHelper.get(TagPrefix.dust, componentMaterial, amount));
            } else if (componentMaterial.hasProperty(PropertyKey.FLUID)) {
                //  Check fluid components, e.g. Chlorine.
                componentAmount += amount;

                //  If material has too many fluid components, then do not generate recipe.
                if (fluidInputs.size() > CRYSTALLIZATION_RECIPES.getMaxInputs(FluidRecipeCapability.CAP)) {
                    return;
                }

                //  If okay, load its fluid components into recipe.
                fluidInputs.add(componentMaterial.getFluid(amount * 1000L));
            }

            //  If materials with no blast temperature property, then set it blast temperature to 1200K.
            if (!componentMaterial.hasProperty(PropertyKey.BLAST)) {
                temperature += 1200 * amount;
            }
        }

        //  Prohibit division by zero
        //  FIXME May be can be delete
        if (componentAmount == 0) return;

        //  Get average temperature for recipes.
        temperature /= componentAmount;

        //  Use Blast Recipe Builder to define crystallizer recipes, check temperature of recipe and
        // choose a match voltage.
        GTRecipeBuilder builder = CRYSTALLIZATION_RECIPES
                .recipeBuilder("%s_crystallization".formatted(material.getName().toLowerCase(Locale.ROOT)))
                .blastFurnaceTemp(temperature)
                .EUt(VA[temperature <= 2800 ? HV : EV]);

        //  If material has two component, then set stack amount to 2.
        if (componentAmount == 2) {
            for (ItemStack stack : inputs) {
                stack.setCount(stack.getCount() * 2);
            }
            for (FluidStack stack : fluidInputs) {
                stack.setAmount(stack.getAmount() * 2);
            }

            componentAmount = 1;

            //  Get duration of recipe.
            builder.duration((int) (material.getMass() * 4 * 2));
        } else if (componentAmount % 4 != 0) {
            for (ItemStack stack : inputs) {
                stack.setCount(stack.getCount() * 4);
            }
            for (FluidStack stack : fluidInputs) {
                stack.setAmount(stack.getAmount() * 4);
            }

            builder.duration((int) (material.getMass() * 4 * 4));
        } else {
            componentAmount /= 4;

            builder.duration((int) (material.getMass() * 4));
        }

        //  Seed Crystal -> Boule
        builder
                .inputItems(seedCrystal, material, componentAmount)
                .outputItems(boule, material, componentAmount);

        //  Pay attention, some recipes should add other origin (i.e. here is the automatically
        // generated recipe).
        if (!inputs.isEmpty()) builder.inputItems(inputs.toArray(ItemStack[]::new));
        if (!fluidInputs.isEmpty()) builder.inputFluids(fluidInputs.toArray(FluidStack[]::new));
        builder.save(provider);

        //  Boule -> Exquisite Gem + Seed Crystal
        CUTTER_RECIPES
                .recipeBuilder("%s_boule_to_gem".formatted(material.getName().toLowerCase(Locale.ROOT)))
                .inputItems(boule, material)
                .outputItems(gemExquisite, material)
                .outputItems(seedCrystal, material)
                .duration((int) (material.getMass() * 4))
                .EUt(16)
                .save(provider);

        //  Exquisite Gem + Distilled Water -> Seed Crystal
        AUTOCLAVE_RECIPES
                .recipeBuilder("%s_seed_crystal".formatted(material.getName().toLowerCase(Locale.ROOT)))
                .inputItems(gemExquisite, material)
                .inputFluids(DistilledWater.getFluid(8000))
                .outputItems(seedCrystal, material)
                .duration((int) (material.getMass() * 9))
                .EUt(VA[HV])
                .save(provider);
    }
}
