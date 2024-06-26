package com.epimorphismmc.epimorphism.common.machine.multiblock.electric.advanced;

import com.epimorphismmc.epimorphism.common.data.EPRecipeTypes;

import com.epimorphismmc.monomorphism.machine.multiblock.ParallelElectricMultiblockMachine;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.api.recipe.RecipeHelper;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;

import net.minecraft.MethodsReturnNonnullByDefault;

import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class GeneralProcessingPlantMachine extends ParallelElectricMultiblockMachine {
    public static final GTRecipeType[] RECIPE_MAP = new GTRecipeType[] {
        GTRecipeTypes.COMPRESSOR_RECIPES,
        GTRecipeTypes.LATHE_RECIPES,
        GTRecipeTypes.POLARIZER_RECIPES,
        GTRecipeTypes.FERMENTING_RECIPES,
        GTRecipeTypes.EXTRACTOR_RECIPES,
        GTRecipeTypes.CANNER_RECIPES,
        GTRecipeTypes.LASER_ENGRAVER_RECIPES,
        GTRecipeTypes.AUTOCLAVE_RECIPES,
        GTRecipeTypes.FLUID_SOLIDFICATION_RECIPES
    };

    public GeneralProcessingPlantMachine(IMachineBlockEntity holder, Object... args) {
        super(holder, machine -> Math.max(machine.getTier() * 8, 1), args);
    }

    //////////////////////////////////////
    // ******     Recipe Logic    *******//
    //////////////////////////////////////

    @Override
    public GTRecipeType[] getRecipeTypes() {
        return new GTRecipeType[] {
            EPRecipeTypes.GENERAL_RECIPES_A,
            EPRecipeTypes.GENERAL_RECIPES_B,
            EPRecipeTypes.GENERAL_RECIPES_C
        };
    }

    @Override
    public GTRecipeType getRecipeType() {
        return getRecipeTypes()[getActiveRecipeType()];
    }

    @Override
    protected @Nullable GTRecipe getRealRecipe(GTRecipe recipe) {
        var newRecipe = recipe.copy();
        newRecipe.duration = (int) Math.round(recipe.duration * 0.4);
        RecipeHelper.setInputEUt(newRecipe, Math.round(RecipeHelper.getInputEUt(recipe) * 0.8));
        return super.getRealRecipe(newRecipe);
    }
}
