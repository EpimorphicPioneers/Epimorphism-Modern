package com.epimorphismmc.epimorphism.api.machine.multiblock;

import com.epimorphismmc.epimorphism.api.machine.feature.multiblock.stats.IGlassMachine;

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
public class ParallelGlassMultiblockMachine extends MultiStatsElectricMultiblockMachine
        implements IParallelMachine, IGlassMachine {
    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(
            ParallelGlassMultiblockMachine.class,
            MultiStatsElectricMultiblockMachine.MANAGED_FIELD_HOLDER);

    @Persisted
    protected final ParallelStats parallelStats;

    protected final GlassTierStats glassTierStats;

    public ParallelGlassMultiblockMachine(
            IMachineBlockEntity holder,
            Function<ParallelGlassMultiblockMachine, Integer> parallelCalculator,
            Object... args) {
        super(holder, args);
        this.parallelStats = new ParallelStats(this, machine -> {
            if (machine instanceof ParallelGlassMultiblockMachine parallelGlassMultiblockMachine) {
                return parallelCalculator.apply(parallelGlassMultiblockMachine);
            }
            return 1;
        });
        this.glassTierStats = new GlassTierStats(this);
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
    public int getGlassTier() {
        return glassTierStats.getGlassTier();
    }

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }
}
