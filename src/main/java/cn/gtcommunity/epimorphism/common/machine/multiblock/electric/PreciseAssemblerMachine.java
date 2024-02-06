package cn.gtcommunity.epimorphism.common.machine.multiblock.electric;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.api.machine.multiblock.ParallelCasingMultiblockMachine;
import cn.gtcommunity.epimorphism.api.structure.block.tier.ITierType;
import cn.gtcommunity.epimorphism.utils.EPUniverUtil;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.lowdragmc.lowdraglib.syncdata.annotation.DescSynced;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import lombok.Getter;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class PreciseAssemblerMachine extends ParallelCasingMultiblockMachine {

    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(PreciseAssemblerMachine.class, ParallelCasingMultiblockMachine.MANAGED_FIELD_HOLDER);

    private static final ResourceLocation MK1 = Epimorphism.id("block/casings/solid/precise_assembler_casing_mk1");
    private static final ResourceLocation MK2 = Epimorphism.id("block/casings/solid/precise_assembler_casing_mk2");
    private static final ResourceLocation MK3 = Epimorphism.id("block/casings/solid/precise_assembler_casing_mk3");

    @Getter
    @DescSynced
    private int PACasingTier;

    public PreciseAssemblerMachine(IMachineBlockEntity holder, Object... args) {
        super(holder, "PAMachineCasing", machine -> Math.max(machine.getTier() * 8 + 1, 1), args);
    }

    //////////////////////////////////////
    //***    Multiblock LifeCycle    ***//
    //////////////////////////////////////

    @Override
    public void onStructureFormed() {
        super.onStructureFormed();
        Object data = getMultiblockState().getMatchContext().get("PACasing");
        this.PACasingTier = EPUniverUtil.getOrDefault(() -> data instanceof ITierType,
                () -> ((ITierType) data).tier(), 0);
    }

    @Override
    public void onStructureInvalid() {
        super.onStructureInvalid();
        this.PACasingTier = 0;
    }

    //////////////////////////////////////
    //******     Recipe Logic    *******//
    //////////////////////////////////////

    public static @Nullable ResourceLocation locationGetter(MetaMachine machine) {
        if (machine instanceof PreciseAssemblerMachine preciseAssemblerMachine && preciseAssemblerMachine.isFormed()) {
            return switch (preciseAssemblerMachine.getPACasingTier()) {
                case 1 -> MK1;
                case 2 -> MK2;
                case 3 -> MK3;
                default -> null;
            };
        }
        return null;
    }

    //////////////////////////////////////
    //***       Multiblock Data      ***//
    //////////////////////////////////////

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }
}
