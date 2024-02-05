package cn.gtcommunity.epimorphism.api.machine.multiblock;

import cn.gtcommunity.epimorphism.api.machine.feature.stats.IParallelMachine;
import cn.gtcommunity.epimorphism.api.machine.feature.stats.tier.ICoilMachine;
import cn.gtcommunity.epimorphism.api.machine.feature.stats.tier.IGlassMachine;
import com.gregtechceu.gtceu.api.block.ICoilType;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import net.minecraft.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Function;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ParallelGlassCoilMultiblockMachine extends MultiStatsElectricMultiblockMachine implements IParallelMachine, IGlassMachine, ICoilMachine {
    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(ParallelGlassCoilMultiblockMachine.class, MultiStatsElectricMultiblockMachine.MANAGED_FIELD_HOLDER);

    @Persisted
    protected final ParallelStats parallelStats;
    protected final GlassTierStats glassTierStats;
    protected final CoilTierStats coilTierStats;

    public ParallelGlassCoilMultiblockMachine(IMachineBlockEntity holder, Function<ParallelGlassCoilMultiblockMachine, Integer> parallelCalculator, Object... args) {
        super(holder, parallelCalculator, args);
        this.parallelStats = new ParallelStats(this, machine -> {
            if (machine instanceof ParallelGlassCoilMultiblockMachine parallelGlassCoilMultiblockMachine) {
                return parallelCalculator.apply(parallelGlassCoilMultiblockMachine);
            }
            return 1;
        });
        this.glassTierStats = new GlassTierStats(this);
        this.coilTierStats = new CoilTierStats(this);
    }

    //////////////////////////////////////
    //***       Multiblock Data      ***//
    //////////////////////////////////////

    public int getCoilTier() {
        return coilTierStats.getCoilTier();
    }

    @Override
    public ICoilType getCoilType() {
        return coilTierStats.getCoilType();
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
    public int getGlassTier() {
        return glassTierStats.getGlassTier();
    }

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }
}
