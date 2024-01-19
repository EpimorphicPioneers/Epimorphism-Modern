package cn.gtcommunity.epimorphism.common.data.materials;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.*;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import static cn.gtcommunity.epimorphism.api.chemical.material.info.EPMaterialFlags.*;

public class EPMaterialPropertyAddition {
    public static void init() {
        //  Setter
        GTMaterials.RarestMetalMixture.setFormula("Ir2O2(SiO2)2Au3?");
        GTMaterials.IridiumMetalResidue.setFormula("Ir2O4(SiO2)2Au3");
        GTMaterials.AcidicOsmiumSolution.setFormula("OsO4(H2O)(HCl)");
        GTMaterials.PalladiumRaw.setFormula("PdCl2?");

        //  Properties
        GTMaterials.Iodine.setProperty(PropertyKey.DUST, new DustProperty());
        GTMaterials.Iodine.setProperty(PropertyKey.FLUID, new FluidProperty());
        GTMaterials.Thallium.setProperty(PropertyKey.DUST, new DustProperty());
        GTMaterials.Bromine.setProperty(PropertyKey.FLUID, new FluidProperty());
        GTMaterials.Rhenium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Germanium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Germanium.setProperty(PropertyKey.BLAST, new BlastProperty(1211, BlastProperty.GasTier.HIGH, GTValues.VA[GTValues.EV], 1200));
        GTMaterials.Germanium.setProperty(PropertyKey.FLUID, new FluidProperty());
        GTMaterials.Rubidium.setProperty(PropertyKey.DUST, new DustProperty());
        GTMaterials.SodiumHydroxide.setProperty(PropertyKey.FLUID, new FluidProperty());
        GTMaterials.AmmoniumChloride.setProperty(PropertyKey.FLUID, new FluidProperty());
        GTMaterials.Selenium.setProperty(PropertyKey.DUST, new DustProperty());
        GTMaterials.Tellurium.setProperty(PropertyKey.DUST, new DustProperty());
        GTMaterials.Erbium.setProperty(PropertyKey.DUST, new DustProperty());
        GTMaterials.Praseodymium.setProperty(PropertyKey.DUST, new DustProperty());
        GTMaterials.Terbium.setProperty(PropertyKey.DUST, new DustProperty());
        GTMaterials.Scandium.setProperty(PropertyKey.DUST, new DustProperty());
        GTMaterials.Scandium.setProperty(PropertyKey.FLUID, new FluidProperty());
        GTMaterials.Neptunium.setProperty(PropertyKey.DUST, new DustProperty());
        GTMaterials.Neptunium.setProperty(PropertyKey.FLUID, new FluidProperty());
        GTMaterials.Zirconium.setProperty(PropertyKey.DUST, new DustProperty());
        GTMaterials.Calcium.setProperty(PropertyKey.FLUID, new FluidProperty());
        GTMaterials.Dubnium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Dubnium.setProperty(PropertyKey.FLUID, new FluidProperty());
        GTMaterials.Seaborgium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Seaborgium.setProperty(PropertyKey.FLUID, new FluidProperty());
        GTMaterials.Seaborgium.setProperty(PropertyKey.WIRE, new WireProperties((int) GTValues.V[GTValues.UEV], 32, 32, false));
        GTMaterials.Rutherfordium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Rutherfordium.setProperty(PropertyKey.FLUID, new FluidProperty());
        GTMaterials.Livermorium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Livermorium.setProperty(PropertyKey.FLUID, new FluidProperty());
        GTMaterials.Gadolinium.setProperty(PropertyKey.DUST, new DustProperty());
        GTMaterials.Dysprosium.setProperty(PropertyKey.DUST, new DustProperty());
        GTMaterials.Holmium.setProperty(PropertyKey.DUST, new DustProperty());
        GTMaterials.Thulium.setProperty(PropertyKey.DUST, new DustProperty());
        GTMaterials.Thulium.setProperty(PropertyKey.FLUID, new FluidProperty());
        GTMaterials.Ytterbium.setProperty(PropertyKey.DUST, new DustProperty());
        GTMaterials.Ytterbium.setProperty(PropertyKey.FLUID, new FluidProperty());
        GTMaterials.Strontium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Strontium.setProperty(PropertyKey.FLUID, new FluidProperty());
        GTMaterials.Polonium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Polonium.setProperty(PropertyKey.FLUID, new FluidProperty());
        GTMaterials.Fermium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Fermium.setProperty(PropertyKey.FLUID, new FluidProperty());
        GTMaterials.Promethium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Mendelevium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Bohrium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Bohrium.setProperty(PropertyKey.FLUID, new FluidProperty());
        GTMaterials.Curium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Curium.setProperty(PropertyKey.FLUID, new FluidProperty());
        GTMaterials.Sodium.setProperty(PropertyKey.FLUID, new FluidProperty());
        GTMaterials.Radium.setProperty(PropertyKey.DUST, new DustProperty());
        GTMaterials.Radium.setProperty(PropertyKey.FLUID, new FluidProperty());
        GTMaterials.Actinium.setProperty(PropertyKey.DUST, new DustProperty());
        GTMaterials.Actinium.setProperty(PropertyKey.FLUID, new FluidProperty());
        GTMaterials.Caesium.setProperty(PropertyKey.FLUID, new FluidProperty());
        GTMaterials.Californium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Californium.setProperty(PropertyKey.FLUID, new FluidProperty());
        GTMaterials.Californium.setProperty(PropertyKey.ORE, new OreProperty(1, 1, false));
        GTMaterials.Astatine.setProperty(PropertyKey.DUST, new DustProperty());
        GTMaterials.Astatine.setProperty(PropertyKey.FLUID, new FluidProperty());
        GTMaterials.Protactinium.setProperty(PropertyKey.DUST, new DustProperty());
        GTMaterials.Francium.setProperty(PropertyKey.DUST, new DustProperty());
        GTMaterials.Copernicium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Copernicium.setProperty(PropertyKey.FLUID, new FluidProperty());
        GTMaterials.Nihonium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Nihonium.setProperty(PropertyKey.FLUID, new FluidProperty());
        GTMaterials.Moscovium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Moscovium.setProperty(PropertyKey.FLUID, new FluidProperty());
        GTMaterials.Tennessine.setProperty(PropertyKey.FLUID, new FluidProperty());
        GTMaterials.Hafnium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Hafnium.setProperty(PropertyKey.FLUID, new FluidProperty());
        GTMaterials.NetherStar.setProperty(PropertyKey.FLUID, new FluidProperty());
        GTMaterials.Meitnerium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Meitnerium.setProperty(PropertyKey.FLUID, new FluidProperty());
        GTMaterials.Roentgenium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Roentgenium.setProperty(PropertyKey.FLUID, new FluidProperty());


        //  IconSets
        GTMaterials.Bromine.setMaterialIconSet(MaterialIconSet.FLUID);

        //  Flags
        GTMaterials.WroughtIron.addFlags(MaterialFlags.GENERATE_ROTOR, MaterialFlags.GENERATE_SMALL_GEAR);
        GTMaterials.Rhenium.addFlags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_DENSE);
        GTMaterials.Nickel.addFlags(MaterialFlags.GENERATE_FOIL);
        GTMaterials.Titanium.addFlags(MaterialFlags.GENERATE_FOIL);
        GTMaterials.Germanium.addFlags(MaterialFlags.GENERATE_FOIL);
        GTMaterials.Tungsten.addFlags(MaterialFlags.GENERATE_FINE_WIRE);
        GTMaterials.RhodiumPlatedPalladium.addFlags(MaterialFlags.GENERATE_FRAME, MaterialFlags.GENERATE_GEAR);
        GTMaterials.Darmstadtium.addFlags(MaterialFlags.GENERATE_FRAME, MaterialFlags.GENERATE_GEAR);
        GTMaterials.Naquadria.addFlags(MaterialFlags.GENERATE_FRAME);
        GTMaterials.Neutronium.addFlags(MaterialFlags.GENERATE_FRAME);
        GTMaterials.Neutronium.addFlags(MaterialFlags.GENERATE_ROTOR, MaterialFlags.GENERATE_SMALL_GEAR);
        GTMaterials.Dubnium.addFlags(MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_BOLT_SCREW);
        GTMaterials.Rutherfordium.addFlags(MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_BOLT_SCREW);
        GTMaterials.Livermorium.addFlags(MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_BOLT_SCREW);
//        Trinaquadalloy.addFlags(GENERATE_FRAME);
        GTMaterials.CobaltBrass.addFlags(MaterialFlags.GENERATE_FRAME);
        GTMaterials.Trinium.addFlags(MaterialFlags.GENERATE_SPRING/*, GENERATE_DOUBLE_PLATE*/);
        GTMaterials.Tritanium.addFlags(MaterialFlags.GENERATE_SPRING, GENERATE_CURVED_PLATE, MaterialFlags.GENERATE_ROTOR/*, GENERATE_DOUBLE_PLATE*/);
        GTMaterials.Nichrome.addFlags(MaterialFlags.GENERATE_FINE_WIRE);
        GTMaterials.Uranium238.addFlags(MaterialFlags.GENERATE_FRAME);
        GTMaterials.Plutonium241.addFlags(MaterialFlags.GENERATE_FRAME);
        GTMaterials.Trinium.addFlags(MaterialFlags.GENERATE_FRAME);
        GTMaterials.RutheniumTriniumAmericiumNeutronate.addFlags(MaterialFlags.GENERATE_FINE_WIRE, MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_SPRING);
        GTMaterials.Polybenzimidazole.addFlags(MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_FRAME);
        GTMaterials.Steel.addFlags(MaterialFlags.GENERATE_DENSE);
        GTMaterials.IronMagnetic.addFlags(MaterialFlags.GENERATE_LONG_ROD);
        GTMaterials.SteelMagnetic.addFlags(MaterialFlags.GENERATE_LONG_ROD);
        GTMaterials.NeodymiumMagnetic.addFlags(MaterialFlags.GENERATE_LONG_ROD);
//        Chrome.addFlags(GENERATE_LONG_ROD);
        GTMaterials.Bohrium.addFlags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_DENSE);
        GTMaterials.Rhodium.addFlags(MaterialFlags.GENERATE_FRAME);
        GTMaterials.DamascusSteel.addFlags(MaterialFlags.GENERATE_FRAME);
        GTMaterials.Duranium.addFlags(MaterialFlags.GENERATE_FRAME);

        GTMaterials.Pyrochlore.addFlags(MaterialFlags.DISABLE_DECOMPOSITION);
        GTMaterials.Tantalite.addFlags(MaterialFlags.DISABLE_DECOMPOSITION);
        GTMaterials.Molybdenite.addFlags(MaterialFlags.DISABLE_DECOMPOSITION);
        OreProperty oreProp = GTMaterials.Molybdenite.getProperty(PropertyKey.ORE);
        oreProp.setDirectSmeltResult(null);
        GTMaterials.Powellite.addFlags(MaterialFlags.DISABLE_DECOMPOSITION);
        GTMaterials.Wulfenite.addFlags(MaterialFlags.DISABLE_DECOMPOSITION);

        GTMaterials.RockSalt.addFlags(MaterialFlags.DISABLE_DECOMPOSITION);
        GTMaterials.Salt.addFlags(MaterialFlags.DISABLE_DECOMPOSITION);

        GTMaterials.Pollucite.addFlags(MaterialFlags.DISABLE_DECOMPOSITION);
        GTMaterials.Pollucite.getProperty(PropertyKey.ORE).setOreByProducts(GTMaterials.Aluminium, GTMaterials.Potassium, GTMaterials.Caesium, GTMaterials.Pollucite);

        //  Fluid Temperatures
//        FluidProperty prop = new FluidProperty();
//        prop.setPrimaryKey(332);
//        SodiumBisulfate.setProperty(PropertyKey.FLUID, prop);

        //  Wire Properties
        WireProperties wireProp = GTMaterials.RutheniumTriniumAmericiumNeutronate.getProperty(PropertyKey.WIRE);
        wireProp.setSuperconductor(false);
        wireProp.setLossPerBlock(32);
        wireProp.setVoltage((int) GTValues.V[GTValues.UIV]);
    }
}