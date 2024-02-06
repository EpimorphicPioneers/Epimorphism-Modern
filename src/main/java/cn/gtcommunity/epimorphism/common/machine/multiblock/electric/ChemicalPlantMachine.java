package cn.gtcommunity.epimorphism.common.machine.multiblock.electric;

import cn.gtcommunity.epimorphism.api.block.IChemicalPlantCasing;
import cn.gtcommunity.epimorphism.api.structure.block.tier.ITierType;
import cn.gtcommunity.epimorphism.common.block.BlockMaps;
import cn.gtcommunity.epimorphism.utils.EPUniverUtil;
import com.gregtechceu.gtceu.api.block.ICoilType;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.syncdata.RequireRerender;
import com.lowdragmc.lowdraglib.syncdata.annotation.DescSynced;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import lombok.Getter;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

public class ChemicalPlantMachine extends WorkableElectricMultiblockMachine {

    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(ChemicalPlantMachine.class, WorkableElectricMultiblockMachine.MANAGED_FIELD_HOLDER);

    @Getter @DescSynced @RequireRerender
    private int casingTier;
    @Getter
    private int coilLevel;
    @Getter
    private int tubeTier;
    @Getter
    private int voltageTier;
    @Getter
    private int tier;

    private static final Map<Integer, ResourceLocation> TEXTURE_MAP = Collections.unmodifiableMap(BlockMaps.ALL_CP_CASINGS.keySet().stream()
            .filter(IChemicalPlantCasing.class::isInstance)
            .map(IChemicalPlantCasing.class::cast)
            .collect(Collectors.toMap(IChemicalPlantCasing::tier, IChemicalPlantCasing::texture)));

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
                () -> ((ICoilType) coilType).getTier(), 0);
        this.tubeTier = EPUniverUtil.getOrDefault(() -> tubeTier instanceof ITierType,
                () -> ((ITierType) tubeTier).tier(), 0);
        this.voltageTier = EPUniverUtil.getOrDefault(() -> voltageTier instanceof ITierType,
                () -> ((ITierType) voltageTier).tier(), 0);
        this.casingTier = EPUniverUtil.getOrDefault(() -> casingTier instanceof IChemicalPlantCasing,
                () -> ((IChemicalPlantCasing) casingTier).tier(), 0);
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

    public static @Nullable ResourceLocation locationGetter(MetaMachine machine) {
        if (machine instanceof ChemicalPlantMachine chemicalPlant && chemicalPlant.isFormed()) {
            return TEXTURE_MAP.get(chemicalPlant.casingTier);
        }
        return null;
    }

    @Override
    public @NotNull ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }
}
