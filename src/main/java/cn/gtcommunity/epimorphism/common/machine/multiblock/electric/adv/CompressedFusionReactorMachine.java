package cn.gtcommunity.epimorphism.common.machine.multiblock.electric.adv;

import cn.gtcommunity.epimorphism.common.data.EPMaterials;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.block.IFusionCasingType;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.ITieredMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.common.block.FusionCasingBlock;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import net.minecraft.world.level.block.Block;

import static cn.gtcommunity.epimorphism.common.data.EPBlocks.FUSION_CASING_MK4;
import static cn.gtcommunity.epimorphism.common.data.EPBlocks.FUSION_CASING_MK5;
import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.common.data.GTBlocks.*;

public class CompressedFusionReactorMachine extends WorkableElectricMultiblockMachine implements ITieredMachine {

    public CompressedFusionReactorMachine(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
    }

    //////////////////////////////////////
    //********      MISC       *********//
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
