package com.epimorphismmc.epimorphism.api.machine.multiblock;

import com.epimorphismmc.epimorphism.api.machine.feature.multiblock.stats.ICasingMachine;

import com.epimorphismmc.monomorphism.block.tier.ITierType;
import com.epimorphismmc.monomorphism.machine.multiblock.MultiStatsElectricMultiblockMachine;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;

import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;

import net.minecraft.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class TierCasingElectricMultiblockMachine extends MultiStatsElectricMultiblockMachine
        implements ICasingMachine {

    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(
            TierCasingElectricMultiblockMachine.class,
            MultiStatsElectricMultiblockMachine.MANAGED_FIELD_HOLDER);

    protected final CasingTierStats casingTierStats;

    public TierCasingElectricMultiblockMachine(IMachineBlockEntity holder, String typeName) {
        super(holder);
        this.casingTierStats = new CasingTierStats(this, typeName);
    }

    //////////////////////////////////////
    // ***       Multiblock Data      ***//
    //////////////////////////////////////

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    @Override
    public ITierType getTierType() {
        return casingTierStats.getTierType();
    }

    @Override
    public int getCasingTier() {
        return casingTierStats.getCasingTier();
    }
}
