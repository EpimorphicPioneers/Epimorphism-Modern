package com.epimorphismmc.epimorphism.common.data.materials;

import com.epimorphismmc.epimorphism.integration.EPIntegration;

import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.api.fluids.FluidBuilder;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import com.lowdragmc.lowdraglib.Platform;

import static com.epimorphismmc.epimorphism.common.data.EPMaterials.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.*;

public class EPModCompatibilityMaterials {
    public static void register() {
        if (EPIntegration.isBotaniaLoaded()) botaniaMaterial();

        if (EPIntegration.isEmbersLoaded()) embersMaterial();

        if (Platform.isDatagen()) {
            botaniaMaterial();
            embersMaterial();
        }
    }

    private static void botaniaMaterial() {
        // 27000 Mana
        Mana = Builder("mana")
                .fluid(FluidStorageKeys.GAS, new FluidBuilder().temperature(/*0*/ 1))
                .color(0x00BFFF)
                .buildAndRegister();
        // 27001 Primal Mana
        PrimalMana = Builder("primal_mana")
                .fluid(FluidStorageKeys.GAS, new FluidBuilder().temperature(/*0*/ 1))
                .color(0x0000FF)
                .buildAndRegister();
    }

    private static void embersMaterial() {
        // 27002 Dawnstone
        Dawnstone = Builder("dawnstone")
                .ingot(3)
                .fluid()
                .blastTemp(2300)
                .components(GTMaterials.Gold, 1, GTMaterials.Copper, 1)
                .iconSet(MaterialIconSet.SHINY)
                .flags(GENERATE_PLATE, GENERATE_ROTOR, GENERATE_ROD, GENERATE_GEAR, GENERATE_SMALL_GEAR)
                .buildAndRegister();
    }
}
