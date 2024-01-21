package cn.gtcommunity.epimorphism.api.machine.multiblock;

import cn.gtcommunity.epimorphism.api.machine.feature.IEnhanceFancyUIMachine;
import cn.gtcommunity.epimorphism.api.machine.feature.IParallelMachine;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.common.data.GTRecipeModifiers;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class ParallelElectricMultiblockMachine extends WorkableElectricMultiblockMachine implements IEnhanceFancyUIMachine, IParallelMachine {
    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(ParallelElectricMultiblockMachine.class, WorkableElectricMultiblockMachine.MANAGED_FIELD_HOLDER);
    @Persisted
    private int parallelNumber;

    public ParallelElectricMultiblockMachine(IMachineBlockEntity holder, Object... args) {
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
    protected @Nullable GTRecipe getRealRecipe(GTRecipe recipe) {
        var newRecipe = recipe.copy();
        var result = GTRecipeModifiers.accurateParallel(this, newRecipe, getParallelNumber(), false);
        return super.getRealRecipe(result.getA());
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
