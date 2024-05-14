package cn.gtcommunity.epimorphism.common.machine.multiblock.electric;

import com.epimorphismmc.monomorphism.machine.multiblock.ParallelCoilMultiblockMachine;
import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiPart;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Function;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class DTPFMachine extends ParallelCoilMultiblockMachine {

    public DTPFMachine(IMachineBlockEntity holder, Function<ParallelCoilMultiblockMachine, Integer> parallelCalculator, Object... args) {
        super(holder, parallelCalculator, args);
    }

    public static ResourceLocation getBaseTexture(IMultiPart iMultiblockPart) {
        return GTCEu.id("block/casings/hpca/high_power_casing");
    }

}
