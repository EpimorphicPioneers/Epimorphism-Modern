package cn.gtcommunity.epimorphism.common.data.materials;

import static cn.gtcommunity.epimorphism.api.chemical.material.info.EPMaterialFlags.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

public class EPMaterialFlagAddition {

    public static void init() {

        //////////////////////////////////////
        //*******       EP Flag      *******//
        //////////////////////////////////////

        //  Disable Crystallization
        Monazite.addFlags(DISABLE_CRYSTALLIZATION);

        //  Crystallizable
        Sapphire.addFlags(CRYSTALLIZABLE);
        Ruby.addFlags(CRYSTALLIZABLE);
        Emerald.addFlags(CRYSTALLIZABLE);
        Olivine.addFlags(CRYSTALLIZABLE);
        Amethyst.addFlags(CRYSTALLIZABLE);
        Opal.addFlags(CRYSTALLIZABLE);

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

        //////////////////////////////////////
        //*******       GT Flag      *******//
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
//        Chrome.addFlags(GENERATE_LONG_ROD);
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
