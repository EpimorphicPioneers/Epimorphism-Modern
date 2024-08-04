package com.epimorphismmc.epimorphism.common.data.materials;

import static com.epimorphismmc.epimorphism.api.data.chemical.material.info.EPMaterialFlags.DISABLE_CRYSTALLIZATION;
import static com.epimorphismmc.epimorphism.api.data.chemical.material.info.EPMaterialFlags.GENERATE_LASER_EMITTER;
import static com.epimorphismmc.epimorphism.api.data.chemical.material.info.EPMaterialFlags.GENERATE_MILLED;
import static com.epimorphismmc.epimorphism.api.data.chemical.material.info.EPMaterialFlags.GENERATE_NANITES;
import static com.epimorphismmc.epimorphism.common.data.EPMaterials.HeliumNeon;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.CRYSTALLIZABLE;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.DISABLE_DECOMPOSITION;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.GENERATE_BOLT_SCREW;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.GENERATE_DENSE;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.GENERATE_FINE_WIRE;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.GENERATE_FOIL;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.GENERATE_FRAME;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.GENERATE_GEAR;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.GENERATE_LONG_ROD;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.GENERATE_PLATE;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.GENERATE_RING;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.GENERATE_ROD;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.GENERATE_ROTOR;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.GENERATE_SMALL_GEAR;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.GENERATE_SPRING;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Almandine;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Amethyst;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Argon;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Bohrium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Brass;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Carbon;
import static com.gregtechceu.gtceu.common.data.GTMaterials.CarbonDioxide;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Chalcopyrite;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Chromium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.CobaltBrass;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Cupronickel;
import static com.gregtechceu.gtceu.common.data.GTMaterials.DamascusSteel;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Darmstadtium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Dubnium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Duranium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Emerald;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Germanium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Gold;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Grossular;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Helium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.IronMagnetic;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Krypton;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Livermorium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Molybdenite;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Monazite;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Naquadria;
import static com.gregtechceu.gtceu.common.data.GTMaterials.NeodymiumMagnetic;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Neon;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Neutronium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Nichrome;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Nickel;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Olivine;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Opal;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Pentlandite;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Platinum;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Plutonium241;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Pollucite;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Polybenzimidazole;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Powellite;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Pyrochlore;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Pyrope;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Redstone;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Rhenium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Rhodium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.RhodiumPlatedPalladium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.RockSalt;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Ruby;
import static com.gregtechceu.gtceu.common.data.GTMaterials.RutheniumTriniumAmericiumNeutronate;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Rutherfordium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Salt;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Sapphire;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Silver;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Spessartine;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Sphalerite;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Steel;
import static com.gregtechceu.gtceu.common.data.GTMaterials.SteelMagnetic;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Tantalite;
import static com.gregtechceu.gtceu.common.data.GTMaterials.TinAlloy;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Titanium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Trinium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Tritanium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Tungsten;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Uranium238;
import static com.gregtechceu.gtceu.common.data.GTMaterials.WroughtIron;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Wulfenite;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Xenon;

public class EPMaterialFlagAddition {

    public static void init() {

        //////////////////////////////////////
        // *******       EP Flag      *******//
        //////////////////////////////////////

        //  Disable Crystallization
        Monazite.addFlags(DISABLE_CRYSTALLIZATION);
        //        LithiumNiobate.addFlags(DISABLE_CRYSTALLIZATION);

        //  Crystallizable
        Sapphire.addFlags(CRYSTALLIZABLE);
        Ruby.addFlags(CRYSTALLIZABLE);
        Emerald.addFlags(CRYSTALLIZABLE);
        Olivine.addFlags(CRYSTALLIZABLE);
        Amethyst.addFlags(CRYSTALLIZABLE);
        Opal.addFlags(CRYSTALLIZABLE);
        //        LithiumNiobate.addFlags(CRYSTALLIZABLE);

        // Milled
        Pyrope.addFlags(GENERATE_MILLED);
        Redstone.addFlags(GENERATE_MILLED);
        Nickel.addFlags(GENERATE_MILLED);
        Chalcopyrite.addFlags(GENERATE_MILLED);
        Almandine.addFlags(GENERATE_MILLED);
        Grossular.addFlags(GENERATE_MILLED);
        Pentlandite.addFlags(GENERATE_MILLED);
        Sphalerite.addFlags(GENERATE_MILLED);
        Spessartine.addFlags(GENERATE_MILLED);
        Platinum.addFlags(GENERATE_MILLED);
        Monazite.addFlags(GENERATE_MILLED);

        // Nanites
        Carbon.addFlags(GENERATE_NANITES);
        Gold.addFlags(GENERATE_NANITES);
        Silver.addFlags(GENERATE_NANITES);
        Neutronium.addFlags(GENERATE_NANITES);

        // Laser Emitters
        Helium.addFlags(GENERATE_LASER_EMITTER);
        Neon.addFlags(GENERATE_LASER_EMITTER);
        Argon.addFlags(GENERATE_LASER_EMITTER);
        Krypton.addFlags(GENERATE_LASER_EMITTER);
        Xenon.addFlags(GENERATE_LASER_EMITTER);
        HeliumNeon.addFlags(GENERATE_LASER_EMITTER);
        CarbonDioxide.addFlags(GENERATE_LASER_EMITTER);

        //////////////////////////////////////
        // *******       GT Flag      *******//
        //////////////////////////////////////

        WroughtIron.addFlags(GENERATE_ROTOR, GENERATE_SMALL_GEAR);
        Rhenium.addFlags(GENERATE_PLATE, GENERATE_DENSE);
        Nickel.addFlags(GENERATE_FOIL);
        Titanium.addFlags(GENERATE_FOIL);
        Germanium.addFlags(GENERATE_FOIL);
        Tungsten.addFlags(GENERATE_FINE_WIRE);
        RhodiumPlatedPalladium.addFlags(GENERATE_FRAME, GENERATE_GEAR);
        Darmstadtium.addFlags(GENERATE_FRAME, GENERATE_GEAR);
        Naquadria.addFlags(GENERATE_FRAME);
        Neutronium.addFlags(GENERATE_FRAME, GENERATE_ROTOR, GENERATE_SMALL_GEAR);
        Dubnium.addFlags(GENERATE_ROD, GENERATE_BOLT_SCREW);
        Rutherfordium.addFlags(GENERATE_ROD, GENERATE_BOLT_SCREW);
        Livermorium.addFlags(GENERATE_ROD, GENERATE_BOLT_SCREW);
        //        Trinaquadalloy.addFlags(GENERATE_FRAME);
        TinAlloy.addFlags(GENERATE_RING, GENERATE_ROTOR);
        Brass.addFlags(GENERATE_GEAR);
        Cupronickel.addFlags(GENERATE_GEAR);
        CobaltBrass.addFlags(GENERATE_FRAME);
        Trinium.addFlags(GENERATE_SPRING);
        Tritanium.addFlags(GENERATE_SPRING, GENERATE_ROTOR);
        Nichrome.addFlags(GENERATE_FINE_WIRE);
        Uranium238.addFlags(GENERATE_FRAME);
        Plutonium241.addFlags(GENERATE_FRAME);
        Trinium.addFlags(GENERATE_FRAME);
        RutheniumTriniumAmericiumNeutronate.addFlags(GENERATE_FINE_WIRE, GENERATE_ROD, GENERATE_SPRING);
        Polybenzimidazole.addFlags(GENERATE_ROD, GENERATE_FRAME);
        Steel.addFlags(GENERATE_DENSE);
        IronMagnetic.addFlags(GENERATE_LONG_ROD);
        SteelMagnetic.addFlags(GENERATE_LONG_ROD);
        NeodymiumMagnetic.addFlags(GENERATE_LONG_ROD);
        Chromium.addFlags(GENERATE_LONG_ROD);
        Bohrium.addFlags(GENERATE_PLATE, GENERATE_DENSE);
        Rhodium.addFlags(GENERATE_FRAME);
        DamascusSteel.addFlags(GENERATE_FRAME);
        Duranium.addFlags(GENERATE_FRAME);

        Pyrochlore.addFlags(DISABLE_DECOMPOSITION);
        Tantalite.addFlags(DISABLE_DECOMPOSITION);
        Molybdenite.addFlags(DISABLE_DECOMPOSITION);
        Powellite.addFlags(DISABLE_DECOMPOSITION);
        Wulfenite.addFlags(DISABLE_DECOMPOSITION);
        RockSalt.addFlags(DISABLE_DECOMPOSITION);
        Salt.addFlags(DISABLE_DECOMPOSITION);
        Pollucite.addFlags(DISABLE_DECOMPOSITION);
    }
}
