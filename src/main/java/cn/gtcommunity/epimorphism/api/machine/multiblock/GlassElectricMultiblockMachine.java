package cn.gtcommunity.epimorphism.api.machine.multiblock;

import cn.gtcommunity.epimorphism.api.machine.feature.multiblock.stats.tier.IGlassMachine;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import net.minecraft.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class GlassElectricMultiblockMachine extends MultiStatsElectricMultiblockMachine implements IGlassMachine{
    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(GlassElectricMultiblockMachine.class, MultiStatsElectricMultiblockMachine.MANAGED_FIELD_HOLDER);

    protected final GlassTierStats glassTierStats;

    public GlassElectricMultiblockMachine(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
        this.glassTierStats = new GlassTierStats(this);
    }

    //////////////////////////////////////
    //***       Multiblock Data      ***//
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
