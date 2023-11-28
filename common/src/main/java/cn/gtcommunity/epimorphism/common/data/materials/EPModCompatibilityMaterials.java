package cn.gtcommunity.epimorphism.common.data.materials;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.fluids.FluidBuilder;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;

import static cn.gtcommunity.epimorphism.api.chemical.material.info.EPMaterialFlags.*;
import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet.*;
import static cn.gtcommunity.epimorphism.common.data.EPMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

public class EPModCompatibilityMaterials {
    public static void init() {
        // 27000 Mana
        Mana = new Material.Builder("mana")
                .fluid(FluidStorageKeys.GAS, new FluidBuilder().temperature(/*0*/1))
                .color(0x00BFFF)
                .buildAndRegister();
        // 27001 Primal Mana
        PrimalMana = new Material.Builder("primal_mana")
                .fluid(FluidStorageKeys.GAS, new FluidBuilder().temperature(/*0*/1))
                .color(0x0000FF)
                .buildAndRegister();
        // 27002 Dawnstone
        Dawnstone = new Material.Builder("dawnstone")
                .ingot(3)
                .fluid()
                .blastTemp(2300)
                .components(Gold, 1, Copper, 1)
                .iconSet(SHINY)
                .flags(GENERATE_PLATE, GENERATE_ROTOR, GENERATE_ROD, GENERATE_GEAR, GENERATE_SMALL_GEAR, GENERATE_CURVED_PLATE)
                .buildAndRegister();
    }
}
