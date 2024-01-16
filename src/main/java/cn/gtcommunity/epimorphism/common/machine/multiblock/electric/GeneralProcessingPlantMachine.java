package cn.gtcommunity.epimorphism.common.machine.multiblock.electric;

import cn.gtcommunity.epimorphism.api.machine.feature.IEnhanceFancyUIMachine;
import cn.gtcommunity.epimorphism.api.machine.feature.IParallelMachine;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.api.recipe.RecipeHelper;
import com.gregtechceu.gtceu.common.data.GTRecipeModifiers;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

import static cn.gtcommunity.epimorphism.common.data.EPRecipeTypes.*;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class GeneralProcessingPlantMachine extends WorkableElectricMultiblockMachine implements IEnhanceFancyUIMachine, IParallelMachine {
    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(GeneralProcessingPlantMachine.class, WorkableElectricMultiblockMachine.MANAGED_FIELD_HOLDER);
    public final static GTRecipeType[] RECIPE_MAP = new GTRecipeType[] {GTRecipeTypes.COMPRESSOR_RECIPES, GTRecipeTypes.LATHE_RECIPES, GTRecipeTypes.POLARIZER_RECIPES,
                GTRecipeTypes.FERMENTING_RECIPES, GTRecipeTypes.EXTRACTOR_RECIPES, GTRecipeTypes.CANNER_RECIPES,
                GTRecipeTypes.LASER_ENGRAVER_RECIPES, GTRecipeTypes.AUTOCLAVE_RECIPES, GTRecipeTypes.FLUID_SOLIDFICATION_RECIPES};

    @Persisted
    private int parallelNumber;

    public GeneralProcessingPlantMachine(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
    }

    //////////////////////////////////////
    //***    Multiblock LifeCycle    ***//
    //////////////////////////////////////

    @Override
    public void onStructureFormed() {
        super.onStructureFormed();
        if (parallelNumber == 0) parallelNumber = getMaxParallel();
    }

    @Override
    public void onStructureInvalid() {
        super.onStructureInvalid();
        parallelNumber = 0;
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
        var result = GTRecipeModifiers.accurateParallel(this, newRecipe, getMaxParallel(), false);
        return super.getRealRecipe(result.getA());
    }

    @Override
    public int getMaxParallel() {
        return Math.max(getTier() * 8 + 1, 1);
    }

    @Override
    public int getParallelNumber() {
        return parallelNumber;
    }

    @Override
    public void setParallelNumber(int number) {
        this.parallelNumber = Mth.clamp(number, 1, getMaxParallel());
        getRecipeLogic().markLastRecipeDirty();
    }

    //////////////////////////////////////
    //***       Multiblock Data      ***//
    //////////////////////////////////////

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }
}
