package cn.gtcommunity.epimorphism.common.machine.multiblock.electric;

import cn.gtcommunity.epimorphism.api.machine.multiblock.ParallelElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.api.recipe.RecipeHelper;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import net.minecraft.MethodsReturnNonnullByDefault;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

import static cn.gtcommunity.epimorphism.common.data.EPRecipeTypes.*;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class GeneralProcessingPlantMachine extends ParallelElectricMultiblockMachine {
    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(GeneralProcessingPlantMachine.class, ParallelElectricMultiblockMachine.MANAGED_FIELD_HOLDER);
    public final static GTRecipeType[] RECIPE_MAP = new GTRecipeType[] {GTRecipeTypes.COMPRESSOR_RECIPES, GTRecipeTypes.LATHE_RECIPES, GTRecipeTypes.POLARIZER_RECIPES,
                GTRecipeTypes.FERMENTING_RECIPES, GTRecipeTypes.EXTRACTOR_RECIPES, GTRecipeTypes.CANNER_RECIPES,
                GTRecipeTypes.LASER_ENGRAVER_RECIPES, GTRecipeTypes.AUTOCLAVE_RECIPES, GTRecipeTypes.FLUID_SOLIDFICATION_RECIPES};

    public GeneralProcessingPlantMachine(IMachineBlockEntity holder, Object... args) {
        super(holder, machine -> Math.max(machine.getTier() * 8 + 1, 1), args);
    }

    //////////////////////////////////////
    //******     Recipe Logic    *******//
    //////////////////////////////////////

    @Override
    public GTRecipeType[] getRecipeTypes() {
        return new GTRecipeType[]{
                GENERAL_RECIPES_A,
                GENERAL_RECIPES_B,
                GENERAL_RECIPES_C
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

    //////////////////////////////////////
    //***       Multiblock Data      ***//
    //////////////////////////////////////

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }
}
