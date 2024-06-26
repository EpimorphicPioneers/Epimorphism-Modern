package com.epimorphismmc.epimorphism.api.machine.multiblock;

import com.epimorphismmc.epimorphism.api.machine.feature.multiblock.stats.ICasingMachine;

import com.epimorphismmc.monomorphism.block.tier.ITierType;
import com.epimorphismmc.monomorphism.machine.feature.multiblock.stats.IParallelMachine;
import com.epimorphismmc.monomorphism.machine.multiblock.MultiStatsElectricMultiblockMachine;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;

import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;

import net.minecraft.MethodsReturnNonnullByDefault;

import java.util.function.Function;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ParallelCasingMultiblockMachine extends MultiStatsElectricMultiblockMachine
        implements IParallelMachine, ICasingMachine {
    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(
            ParallelCasingMultiblockMachine.class,
            MultiStatsElectricMultiblockMachine.MANAGED_FIELD_HOLDER);

    @Persisted
    protected final ParallelStats parallelStats;

    protected final CasingTierStats casingTierStats;

    public ParallelCasingMultiblockMachine(
            IMachineBlockEntity holder,
            String typeName,
            Function<ParallelCasingMultiblockMachine, Integer> parallelCalculator,
            Object... args) {
        super(holder, args);
        this.parallelStats = new ParallelStats(this, machine -> {
            if (machine instanceof ParallelCasingMultiblockMachine parallelCasingMultiblockMachine) {
                return parallelCalculator.apply(parallelCasingMultiblockMachine);
            }
            return 1;
        });
        this.casingTierStats = new CasingTierStats(this, typeName);
    }

    //////////////////////////////////////
    // ******     Recipe Logic    *******//
    //////////////////////////////////////

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
    // ***       Multiblock Data      ***//
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
