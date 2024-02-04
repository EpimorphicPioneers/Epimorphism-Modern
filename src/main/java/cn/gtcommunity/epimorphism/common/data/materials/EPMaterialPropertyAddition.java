package cn.gtcommunity.epimorphism.common.data.materials;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.*;

import static cn.gtcommunity.epimorphism.api.chemical.material.info.EPMaterialFlags.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

public class EPMaterialPropertyAddition {
    public static void init() {
        //  Setter
        RarestMetalMixture.setFormula("Ir2O2(SiO2)2Au3?");
        IridiumMetalResidue.setFormula("Ir2O4(SiO2)2Au3");
        AcidicOsmiumSolution.setFormula("OsO4(H2O)(HCl)");
        PalladiumRaw.setFormula("PdCl2?");

        //  Properties
        Iodine.setProperty(PropertyKey.DUST, new DustProperty());
        Iodine.setProperty(PropertyKey.FLUID, new FluidProperty());
        Thallium.setProperty(PropertyKey.DUST, new DustProperty());
        Bromine.setProperty(PropertyKey.FLUID, new FluidProperty());
        Rhenium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Germanium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Germanium.setProperty(PropertyKey.BLAST, new BlastProperty(1211, BlastProperty.GasTier.HIGH, GTValues.VA[GTValues.EV], 1200));
        Germanium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Rubidium.setProperty(PropertyKey.DUST, new DustProperty());
        SodiumHydroxide.setProperty(PropertyKey.FLUID, new FluidProperty());
        AmmoniumChloride.setProperty(PropertyKey.FLUID, new FluidProperty());
        Selenium.setProperty(PropertyKey.DUST, new DustProperty());
        Tellurium.setProperty(PropertyKey.DUST, new DustProperty());
        Erbium.setProperty(PropertyKey.DUST, new DustProperty());
        Praseodymium.setProperty(PropertyKey.DUST, new DustProperty());
        Terbium.setProperty(PropertyKey.DUST, new DustProperty());
        Scandium.setProperty(PropertyKey.DUST, new DustProperty());
        Scandium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Neptunium.setProperty(PropertyKey.DUST, new DustProperty());
        Neptunium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Zirconium.setProperty(PropertyKey.DUST, new DustProperty());
        Calcium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Dubnium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Dubnium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Seaborgium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Seaborgium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Seaborgium.setProperty(PropertyKey.WIRE, new WireProperties((int) GTValues.V[GTValues.UEV], 32, 32, false));
        Rutherfordium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Rutherfordium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Livermorium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Livermorium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Gadolinium.setProperty(PropertyKey.DUST, new DustProperty());
        Dysprosium.setProperty(PropertyKey.DUST, new DustProperty());
        Holmium.setProperty(PropertyKey.DUST, new DustProperty());
        Thulium.setProperty(PropertyKey.DUST, new DustProperty());
        Thulium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Ytterbium.setProperty(PropertyKey.DUST, new DustProperty());
        Ytterbium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Strontium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Strontium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Polonium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Polonium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Fermium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Fermium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Promethium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Mendelevium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Bohrium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Bohrium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Curium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Curium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Sodium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Radium.setProperty(PropertyKey.DUST, new DustProperty());
        Radium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Actinium.setProperty(PropertyKey.DUST, new DustProperty());
        Actinium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Caesium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Californium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Californium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Californium.setProperty(PropertyKey.ORE, new OreProperty(1, 1, false));
        Astatine.setProperty(PropertyKey.DUST, new DustProperty());
        Astatine.setProperty(PropertyKey.FLUID, new FluidProperty());
        Protactinium.setProperty(PropertyKey.DUST, new DustProperty());
        Francium.setProperty(PropertyKey.DUST, new DustProperty());
        Copernicium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Copernicium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Nihonium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Nihonium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Moscovium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Moscovium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Tennessine.setProperty(PropertyKey.FLUID, new FluidProperty());
        Hafnium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Hafnium.setProperty(PropertyKey.FLUID, new FluidProperty());
        NetherStar.setProperty(PropertyKey.FLUID, new FluidProperty());
        Meitnerium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Meitnerium.setProperty(PropertyKey.FLUID, new FluidProperty());
        Roentgenium.setProperty(PropertyKey.INGOT, new IngotProperty());
        Roentgenium.setProperty(PropertyKey.FLUID, new FluidProperty());


        //  IconSets
        Bromine.setMaterialIconSet(MaterialIconSet.FLUID);

        //  Flags
        WroughtIron.addFlags(MaterialFlags.GENERATE_ROTOR, MaterialFlags.GENERATE_SMALL_GEAR);
        Rhenium.addFlags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_DENSE);
        Nickel.addFlags(MaterialFlags.GENERATE_FOIL);
        Titanium.addFlags(MaterialFlags.GENERATE_FOIL);
        Germanium.addFlags(MaterialFlags.GENERATE_FOIL);
        Tungsten.addFlags(MaterialFlags.GENERATE_FINE_WIRE);
        RhodiumPlatedPalladium.addFlags(MaterialFlags.GENERATE_FRAME, MaterialFlags.GENERATE_GEAR);
        Darmstadtium.addFlags(MaterialFlags.GENERATE_FRAME, MaterialFlags.GENERATE_GEAR);
        Naquadria.addFlags(MaterialFlags.GENERATE_FRAME);
        Neutronium.addFlags(MaterialFlags.GENERATE_FRAME);
        Neutronium.addFlags(MaterialFlags.GENERATE_ROTOR, MaterialFlags.GENERATE_SMALL_GEAR);
        Dubnium.addFlags(MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_BOLT_SCREW);
        Rutherfordium.addFlags(MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_BOLT_SCREW);
        Livermorium.addFlags(MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_BOLT_SCREW);
//        Trinaquadalloy.addFlags(GENERATE_FRAME);
        CobaltBrass.addFlags(MaterialFlags.GENERATE_FRAME);
        Trinium.addFlags(MaterialFlags.GENERATE_SPRING/*, GENERATE_DOUBLE_PLATE*/);
        Tritanium.addFlags(MaterialFlags.GENERATE_SPRING, GENERATE_CURVED_PLATE, MaterialFlags.GENERATE_ROTOR/*, GENERATE_DOUBLE_PLATE*/);
        Nichrome.addFlags(MaterialFlags.GENERATE_FINE_WIRE);
        Uranium238.addFlags(MaterialFlags.GENERATE_FRAME);
        Plutonium241.addFlags(MaterialFlags.GENERATE_FRAME);
        Trinium.addFlags(MaterialFlags.GENERATE_FRAME);
        RutheniumTriniumAmericiumNeutronate.addFlags(MaterialFlags.GENERATE_FINE_WIRE, MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_SPRING);
        Polybenzimidazole.addFlags(MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_FRAME);
        Steel.addFlags(MaterialFlags.GENERATE_DENSE);
        IronMagnetic.addFlags(MaterialFlags.GENERATE_LONG_ROD);
        SteelMagnetic.addFlags(MaterialFlags.GENERATE_LONG_ROD);
        NeodymiumMagnetic.addFlags(MaterialFlags.GENERATE_LONG_ROD);
//        Chrome.addFlags(GENERATE_LONG_ROD);
        Bohrium.addFlags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_DENSE);
        Rhodium.addFlags(MaterialFlags.GENERATE_FRAME);
        DamascusSteel.addFlags(MaterialFlags.GENERATE_FRAME);
        Duranium.addFlags(MaterialFlags.GENERATE_FRAME);

        Pyrochlore.addFlags(MaterialFlags.DISABLE_DECOMPOSITION);
        Tantalite.addFlags(MaterialFlags.DISABLE_DECOMPOSITION);
        Molybdenite.addFlags(MaterialFlags.DISABLE_DECOMPOSITION);
        OreProperty oreProp = Molybdenite.getProperty(PropertyKey.ORE);
        oreProp.setDirectSmeltResult(null);
        Powellite.addFlags(MaterialFlags.DISABLE_DECOMPOSITION);
        Wulfenite.addFlags(MaterialFlags.DISABLE_DECOMPOSITION);

        RockSalt.addFlags(MaterialFlags.DISABLE_DECOMPOSITION);
        Salt.addFlags(MaterialFlags.DISABLE_DECOMPOSITION);

        Pollucite.addFlags(MaterialFlags.DISABLE_DECOMPOSITION);
        Pollucite.getProperty(PropertyKey.ORE).setOreByProducts(Aluminium, Potassium, Caesium, Pollucite);

        //  Fluid Temperatures
//        FluidProperty prop = new FluidProperty();
//        prop.setPrimaryKey(332);
//        SodiumBisulfate.setProperty(PropertyKey.FLUID, prop);

        //  Wire Properties
        WireProperties wireProp = RutheniumTriniumAmericiumNeutronate.getProperty(PropertyKey.WIRE);
        wireProp.setSuperconductor(false);
        wireProp.setLossPerBlock(32);
        wireProp.setVoltage((int) GTValues.V[GTValues.UIV]);
    }
}