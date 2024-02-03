package cn.gtcommunity.epimorphism.api.machine.multiblock;

import cn.gtcommunity.epimorphism.api.machine.feature.stats.IParallelMachine;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.common.data.GTRecipeModifiers;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import net.minecraft.MethodsReturnNonnullByDefault;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Function;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ParallelElectricMultiblockMachine extends MultiStatsElectricMultiblockMachine implements IParallelMachine {
    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(ParallelElectricMultiblockMachine.class, MultiStatsElectricMultiblockMachine.MANAGED_FIELD_HOLDER);

    @Persisted
    protected final ParallelStats parallelStats;

    public ParallelElectricMultiblockMachine(IMachineBlockEntity holder, Function<WorkableElectricMultiblockMachine, Integer> parallelCalculator, Object... args) {
        super(holder, args);
        this.parallelStats = new ParallelStats(this, machine -> {
            if (machine instanceof WorkableElectricMultiblockMachine workableElectricMultiblockMachine) {
                return parallelCalculator.apply(workableElectricMultiblockMachine);
            }
            return 1;
        });
        addStats(parallelStats);
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
    public int getMaxParallel() {
        return parallelStats.getMaxParallel();
    }

    @Override
    public int getParallelNumber() {
        return parallelStats.getParallelNumber();
    }

    @Override
    public void setParallelNumber(int number) {
        parallelStats.setParallelNumber(number);
    }

    //////////////////////////////////////
    //***       Multiblock Data      ***//
    //////////////////////////////////////

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }
}
