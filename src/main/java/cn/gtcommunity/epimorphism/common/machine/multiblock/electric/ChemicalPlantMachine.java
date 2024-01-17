package cn.gtcommunity.epimorphism.common.machine.multiblock.electric;

import cn.gtcommunity.epimorphism.api.block.IChemicalPlantCasing;
import cn.gtcommunity.epimorphism.api.structure.block.tier.ITierType;
import cn.gtcommunity.epimorphism.utils.EPUniverUtil;
import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.block.ICoilType;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.syncdata.RequireRerender;
import com.lowdragmc.lowdraglib.syncdata.annotation.DescSynced;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

public class ChemicalPlantMachine extends WorkableElectricMultiblockMachine {
    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(ChemicalPlantMachine.class, WorkableElectricMultiblockMachine.MANAGED_FIELD_HOLDER);
    @Getter
    private int coilLevel;
    @Getter
    private int casingTier;
    @Getter
    private int tubeTier;
    @Getter
    private int voltageTier;
    @Getter
    private int tier;
    @Getter @DescSynced @RequireRerender
    private String location = GTCEu.id("block/casings/solid/machine_casing_bronze_plated_bricks").toString();

    public ChemicalPlantMachine(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
    }

    @Override
    public void onStructureFormed() {
        super.onStructureFormed();
        var context = getMultiblockState().getMatchContext();
        Object coilType = context.get("CoilType");
        Object casingTier = context.get("CPCasing");
        Object tubeTier = context.get("CPPipe");
        Object voltageTier = context.get("CPMachineCasing");
        this.coilLevel = EPUniverUtil.getOrDefault(() -> coilType instanceof ICoilType,
                () -> ((ICoilType) coilType).getTier(),
                0);
        this.tubeTier = EPUniverUtil.getOrDefault(() -> tubeTier instanceof ITierType,
                () -> ((ITierType)tubeTier).tier(),
                0);
        this.voltageTier = EPUniverUtil.getOrDefault(() -> voltageTier instanceof ITierType,
                () -> ((ITierType)voltageTier).tier(),
                0);
        this.casingTier = EPUniverUtil.getOrDefault(() -> casingTier instanceof IChemicalPlantCasing,
                () -> {
                    var tier = (IChemicalPlantCasing) casingTier;
                    location = ((IChemicalPlantCasing) casingTier).texture().toString();
                    return tier.tier();
                },
                0);

        this.tier = Math.min(this.casingTier,this.tubeTier);
    }

    @Override
    public void onStructureInvalid() {
        super.onStructureInvalid();
        coilLevel = 0;
        casingTier = 0;
        tubeTier = 0;
        voltageTier = 0;
        tier = 0;
    }

    //////////////////////////////////////
    //***       Multiblock Data      ***//
    //////////////////////////////////////

    @Override
    public @NotNull ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }
}
