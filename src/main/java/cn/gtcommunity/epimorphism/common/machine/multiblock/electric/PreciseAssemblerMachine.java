package cn.gtcommunity.epimorphism.common.machine.multiblock.electric;

import cn.gtcommunity.epimorphism.api.machine.multiblock.ParallelElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import net.minecraft.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class PreciseAssemblerMachine  extends ParallelElectricMultiblockMachine {

    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(PreciseAssemblerMachine.class, ParallelElectricMultiblockMachine.MANAGED_FIELD_HOLDER);

    public PreciseAssemblerMachine(IMachineBlockEntity holder, Object... args) {
        super(holder, machine -> Math.max(machine.getTier() * 8 + 1, 1), args);
    }

    //////////////////////////////////////
    //******     Recipe Logic    *******//
    //////////////////////////////////////



    //////////////////////////////////////
    //***       Multiblock Data      ***//
    //////////////////////////////////////

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }
}
