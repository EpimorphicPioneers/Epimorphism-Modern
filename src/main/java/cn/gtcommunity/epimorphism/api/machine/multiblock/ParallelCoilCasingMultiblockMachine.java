package cn.gtcommunity.epimorphism.api.machine.multiblock;

import cn.gtcommunity.epimorphism.api.machine.feature.multiblock.stats.ICasingMachine;
import cn.gtcommunity.epimorphism.api.machine.feature.multiblock.stats.ICoilMachine;
import com.epimorphismmc.monomorphism.block.tier.ITierType;
import com.epimorphismmc.monomorphism.machine.feature.multiblock.stats.IParallelMachine;
import com.epimorphismmc.monomorphism.machine.multiblock.MultiStatsElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.block.ICoilType;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import net.minecraft.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Function;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ParallelCoilCasingMultiblockMachine extends MultiStatsElectricMultiblockMachine implements IParallelMachine, ICoilMachine, ICasingMachine {
    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(ParallelCoilCasingMultiblockMachine.class, MultiStatsElectricMultiblockMachine.MANAGED_FIELD_HOLDER);

    @Persisted
    protected final ParallelStats parallelStats;
    protected final CoilTierStats coilTierStats;
    protected final CasingTierStats casingTierStats;

    public ParallelCoilCasingMultiblockMachine(IMachineBlockEntity holder, String typeName, Function<ParallelCoilCasingMultiblockMachine, Integer> parallelCalculator, Object... args) {
        super(holder, parallelCalculator, args);
        this.parallelStats = new IParallelMachine.ParallelStats(this, machine -> {
            if (machine instanceof ParallelCoilCasingMultiblockMachine parallelCoilCasingMultiblockMachine) {
                return parallelCalculator.apply(parallelCoilCasingMultiblockMachine);
            }
            return 1;
        });
        this.coilTierStats = new ICoilMachine.CoilTierStats(this);
        this.casingTierStats = new CasingTierStats(this, typeName);
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
