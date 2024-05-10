package cn.gtcommunity.epimorphism.common.machine.multiblock.electric;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiPart;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import net.minecraft.resources.ResourceLocation;

public class EyeOfHarmonyMachine extends WorkableElectricMultiblockMachine {
    public EyeOfHarmonyMachine(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
    }

    public static ResourceLocation getBaseTexture(IMultiPart iMultiblockPart) {
        return GTCEu.id("block/casings/hpca/high_power_casing");
    }
}