package com.epimorphismmc.epimorphism.common.machine.multiblock.electric.advanced;

import com.epimorphismmc.epimorphism.common.data.EPMaterials;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.ITieredMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import static com.gregtechceu.gtceu.api.GTValues.*;

public class CompressedFusionReactorMachine extends WorkableElectricMultiblockMachine
        implements ITieredMachine {

    public CompressedFusionReactorMachine(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
    }

    //////////////////////////////////////
    // ********      MISC       *********//
    //////////////////////////////////////

    public static Material getFrameMaterial(int tier) {
        return switch (tier) {
            case LuV -> GTMaterials.Naquadah;
            case ZPM -> GTMaterials.NaquadahEnriched;
            case UV -> GTMaterials.Naquadria;
            case UHV -> GTMaterials.Tritanium;
            default -> EPMaterials.Orichalcum;
        };
    }

    //    public static Block getCoilBlock(int tier) {
    //        return switch (tier) {
    //            case LuV -> GTMaterials.Naquadah;
    //            case ZPM -> GTMaterials.NaquadahEnriched;
    //            case UV -> GTMaterials.Naquadria;
    //            case UHV -> GTMaterials.Tritanium;
    //            default -> EPMaterials.Orichalcum;
    //        };
    //    }
    //
    //    public static Block getGlassBlock(int tier) {
    //        return switch (tier) {
    //            case LuV -> GTMaterials.Naquadah;
    //            case ZPM -> GTMaterials.NaquadahEnriched;
    //            case UV -> GTMaterials.Naquadria;
    //            case UHV -> GTMaterials.Tritanium;
    //            default -> EPMaterials.Orichalcum;
    //        };
    //    }
}
