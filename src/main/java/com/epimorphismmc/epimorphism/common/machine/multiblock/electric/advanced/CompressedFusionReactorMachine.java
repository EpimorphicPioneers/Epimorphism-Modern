package com.epimorphismmc.epimorphism.common.machine.multiblock.electric.advanced;

import com.epimorphismmc.epimorphism.common.data.EPMaterials;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.ITieredMachine;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.machine.multiblock.electric.FusionReactorMachine;
import net.minecraft.world.level.block.Block;

import static com.gregtechceu.gtceu.api.GTValues.*;

public class CompressedFusionReactorMachine extends FusionReactorMachine
        implements ITieredMachine {

    public CompressedFusionReactorMachine(IMachineBlockEntity holder,int tier) {
        super(holder, tier);
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

        public static Block getCoilBlock(int tier) {
            return GTBlocks.COIL_NAQUADAH.get();
        }

        public static Block getGlassBlock(int tier) {
            return GTBlocks.FUSION_GLASS.get();
        }
}
