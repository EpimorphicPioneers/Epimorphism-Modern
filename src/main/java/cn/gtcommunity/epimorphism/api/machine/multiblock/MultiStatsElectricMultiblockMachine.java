package cn.gtcommunity.epimorphism.api.machine.multiblock;

import cn.gtcommunity.epimorphism.api.machine.feature.IEnhanceFancyUIMachine;
import cn.gtcommunity.epimorphism.api.machine.trait.MultiblockStats;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import lombok.Getter;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.List;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class MultiStatsElectricMultiblockMachine extends WorkableElectricMultiblockMachine implements IEnhanceFancyUIMachine {
    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(MultiStatsElectricMultiblockMachine.class, WorkableElectricMultiblockMachine.MANAGED_FIELD_HOLDER);

    @Getter
    protected List<MultiblockStats> multiblockStats;

    public MultiStatsElectricMultiblockMachine(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
        multiblockStats = new ArrayList<>();
    }

    //////////////////////////////////////
    //***    Multiblock LifeCycle    ***//
    //////////////////////////////////////

    @Override
    public void onStructureFormed() {
        super.onStructureFormed();
        multiblockStats.forEach(stats -> stats.onStructureFormed(getMultiblockState()));
    }

    @Override
    public void onStructureInvalid() {
        super.onStructureInvalid();
        multiblockStats.forEach(MultiblockStats::onStructureInvalid);
    }

    //////////////////////////////////////
    //***        Multiblock UI       ***//
    //////////////////////////////////////
    @Override
    public void addDisplayText(@NotNull List<Component> textList) {
        super.addDisplayText(textList);
        multiblockStats.forEach(stats -> stats.addDisplayText(textList));
    }

    //////////////////////////////////////
    //***       Multiblock Data      ***//
    //////////////////////////////////////
    protected void addStats(MultiblockStats state) {
        multiblockStats.add(state);
    }

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }
}