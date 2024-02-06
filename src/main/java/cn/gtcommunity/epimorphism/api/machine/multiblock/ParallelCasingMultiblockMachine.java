package cn.gtcommunity.epimorphism.api.machine.multiblock;

import cn.gtcommunity.epimorphism.api.machine.feature.stats.IParallelMachine;
import cn.gtcommunity.epimorphism.api.machine.feature.stats.tier.ICasingMachine;
import cn.gtcommunity.epimorphism.api.structure.block.tier.ITierType;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
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
public class ParallelCasingMultiblockMachine extends MultiStatsElectricMultiblockMachine implements IParallelMachine, ICasingMachine {
    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(ParallelCasingMultiblockMachine.class, MultiStatsElectricMultiblockMachine.MANAGED_FIELD_HOLDER);

    @Persisted
    protected final ParallelStats parallelStats;

    protected final CasingTierStats casingTierStats;

    public ParallelCasingMultiblockMachine(IMachineBlockEntity holder, String typeName, Function<ParallelCasingMultiblockMachine, Integer> parallelCalculator, Object... args) {
        super(holder, args);
        this.parallelStats = new ParallelStats(this, machine -> {
            if (machine instanceof ParallelCasingMultiblockMachine parallelCasingMultiblockMachine) {
                return parallelCalculator.apply(parallelCasingMultiblockMachine);
            }
            return 1;
        });
        this.casingTierStats = new CasingTierStats(this, typeName);
        addStats(casingTierStats);
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
    public ITierType getTierType() {
        return casingTierStats.getTierType();
    }

    @Override
    public int getCasingTier() {
        return casingTierStats.getCasingTier();
    }

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }
}
