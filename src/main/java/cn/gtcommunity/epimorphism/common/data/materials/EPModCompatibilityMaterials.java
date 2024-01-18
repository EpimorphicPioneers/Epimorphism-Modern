package cn.gtcommunity.epimorphism.common.data.materials;

import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.api.fluids.FluidBuilder;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import cn.gtcommunity.epimorphism.common.data.EPMaterials;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import static cn.gtcommunity.epimorphism.api.chemical.material.info.EPMaterialFlags.*;
import static cn.gtcommunity.epimorphism.common.data.EPMaterials.*;

public class EPModCompatibilityMaterials {
    public static void init() {
        // 27000 Mana
        EPMaterials.Mana = Builder("mana")
                .fluid(FluidStorageKeys.GAS, new FluidBuilder().temperature(/*0*/1))
                .color(0x00BFFF)
                .buildAndRegister();
        // 27001 Primal Mana
        EPMaterials.PrimalMana = Builder("primal_mana")
                .fluid(FluidStorageKeys.GAS, new FluidBuilder().temperature(/*0*/1))
                .color(0x0000FF)
                .buildAndRegister();
        // 27002 Dawnstone
        EPMaterials.Dawnstone = Builder("dawnstone")
                .ingot(3)
                .fluid()
                .blastTemp(2300)
                .components(GTMaterials.Gold, 1, GTMaterials.Copper, 1)
                .iconSet(MaterialIconSet.SHINY)
                .flags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_ROTOR, MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_GEAR, MaterialFlags.GENERATE_SMALL_GEAR, GENERATE_CURVED_PLATE)
                .buildAndRegister();
    }
}
