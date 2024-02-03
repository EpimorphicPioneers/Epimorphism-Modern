package cn.gtcommunity.epimorphism.api.machine.multiblock;

import cn.gtcommunity.epimorphism.api.machine.feature.stats.IParallelMachine;
import cn.gtcommunity.epimorphism.api.machine.feature.stats.tier.ICoilMachine;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import net.minecraft.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Function;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ParallelCoilMultiblockMachine extends MultiStatsElectricMultiblockMachine implements IParallelMachine, ICoilMachine {
    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(ParallelCoilMultiblockMachine.class, MultiStatsElectricMultiblockMachine.MANAGED_FIELD_HOLDER);

    @Persisted
    protected final ParallelStats parallelStats;
    protected final CoilTierStats coilTierStats;

    public ParallelCoilMultiblockMachine(IMachineBlockEntity holder, Function<ParallelCoilMultiblockMachine, Integer> parallelCalculator, Object... args) {
        super(holder, parallelCalculator, args);
        this.parallelStats = new ParallelStats(this, machine -> {
            if (machine instanceof ParallelCoilMultiblockMachine parallelCoilMultiblockMachine) {
                return parallelCalculator.apply(parallelCoilMultiblockMachine);
            }
            return 1;
        });
        this.coilTierStats = new CoilTierStats(this);
    }

    //////////////////////////////////////
    //***       Multiblock Data      ***//
    //////////////////////////////////////

    public int getCoilTier() {
        return coilTierStats.getCoilTier();
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

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }
}
