package com.epimorphismmc.epimorphism.common.data.materials;

import com.epimorphismmc.epimorphism.Epimorphism;
import com.epimorphismmc.epimorphism.api.data.chemical.material.properties.CatalystProperty;
import com.epimorphismmc.epimorphism.api.data.chemical.material.properties.CrucibleProperty;
import com.epimorphismmc.epimorphism.api.data.chemical.material.properties.FenceProperty;
import com.epimorphismmc.epimorphism.api.data.chemical.material.properties.GrindBallProperty;
import com.epimorphismmc.epimorphism.common.item.behaviors.renderer.HaloItemBehavior;

import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.BlastProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.DustProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.FluidProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.IngotProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.OreProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.WireProperties;
import com.gregtechceu.gtceu.api.fluids.FluidBuilder;

import net.minecraft.resources.ResourceLocation;

import static com.epimorphismmc.epimorphism.api.data.chemical.material.properties.EPPropertyKeys.CATALYST;
import static com.epimorphismmc.epimorphism.api.data.chemical.material.properties.EPPropertyKeys.CRUCIBLE;
import static com.epimorphismmc.epimorphism.api.data.chemical.material.properties.EPPropertyKeys.FENCE;
import static com.epimorphismmc.epimorphism.api.data.chemical.material.properties.EPPropertyKeys.GRIND_BALL;
import static com.epimorphismmc.epimorphism.common.data.EPMaterials.CosmicNeutronium;
import static com.epimorphismmc.epimorphism.common.data.EPMaterials.HexagonalBoronNitride;
import static com.epimorphismmc.epimorphism.common.data.EPMaterials.PalladiumOnCarbon;
import static com.gregtechceu.gtceu.api.GTValues.EV;
import static com.gregtechceu.gtceu.api.GTValues.UEV;
import static com.gregtechceu.gtceu.api.GTValues.UIV;
import static com.gregtechceu.gtceu.api.GTValues.V;
import static com.gregtechceu.gtceu.api.GTValues.VA;
import static com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey.BLAST;
import static com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey.DUST;
import static com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey.FLUID;
import static com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey.INGOT;
import static com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey.ORE;
import static com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey.WIRE;
import static com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys.LIQUID;
import static com.gregtechceu.gtceu.common.data.GTMaterials.AcidicOsmiumSolution;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Actinium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Aluminium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.AmmoniumChloride;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Astatine;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Bohrium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Bromine;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Bronze;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Caesium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Calcium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Californium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Chromium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Copernicium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Curium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Dubnium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Dysprosium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Erbium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Fermium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Francium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Gadolinium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Germanium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Gold;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Graphite;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Hafnium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Holmium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Invar;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Iodine;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Iridium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.IridiumMetalResidue;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Iron;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Livermorium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Meitnerium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Mendelevium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Molybdenite;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Molybdenum;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Moscovium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Neptunium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.NetherStar;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Neutronium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Nihonium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.NiobiumTitanium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Osmium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.PalladiumRaw;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Pollucite;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Polonium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Potassium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Praseodymium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Promethium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Protactinium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Quartzite;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Radium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.RarestMetalMixture;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Rhenium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Roentgenium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Rubidium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Ruridit;
import static com.gregtechceu.gtceu.common.data.GTMaterials.RutheniumTriniumAmericiumNeutronate;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Rutherfordium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Scandium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Seaborgium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Selenium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Soapstone;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Sodium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.SodiumBisulfate;
import static com.gregtechceu.gtceu.common.data.GTMaterials.SodiumHydroxide;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Steel;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Strontium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Tellurium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Tennessine;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Terbium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Thallium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Thulium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Titanium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Tungsten;
import static com.gregtechceu.gtceu.common.data.GTMaterials.TungstenSteel;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Vanadium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Ytterbium;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Zirconium;

public class EPMaterialPropertyAddition {
    public static void init() {
        //  Setter
        RarestMetalMixture.setFormula("Ir2O2(SiO2)2Au3?");
        IridiumMetalResidue.setFormula("Ir2O4(SiO2)2Au3");
        AcidicOsmiumSolution.setFormula("OsO4(H2O)(HCl)");
        PalladiumRaw.setFormula("PdCl2?");

        //  GT Properties
        Iodine.setProperty(FLUID, getFluidProperty());

        Germanium.setProperty(INGOT, new IngotProperty());
        Germanium.setProperty(BLAST, new BlastProperty(1211, BlastProperty.GasTier.HIGH, VA[EV], 1200));
        Germanium.setProperty(FLUID, getFluidProperty());

        Scandium.setProperty(DUST, new DustProperty());
        Scandium.setProperty(FLUID, getFluidProperty());

        Neptunium.setProperty(DUST, new DustProperty());
        Neptunium.setProperty(FLUID, getFluidProperty());

        Dubnium.setProperty(INGOT, new IngotProperty());
        Dubnium.setProperty(FLUID, getFluidProperty());

        Seaborgium.setProperty(INGOT, new IngotProperty());
        Seaborgium.setProperty(FLUID, getFluidProperty());
        Seaborgium.setProperty(WIRE, new WireProperties((int) V[UEV], 32, 32, false));

        Rutherfordium.setProperty(INGOT, new IngotProperty());
        Rutherfordium.setProperty(FLUID, getFluidProperty());

        Livermorium.setProperty(INGOT, new IngotProperty());
        Livermorium.setProperty(FLUID, getFluidProperty());

        Thulium.setProperty(DUST, new DustProperty());
        Thulium.setProperty(FLUID, getFluidProperty());

        Ytterbium.setProperty(DUST, new DustProperty());
        Ytterbium.setProperty(FLUID, getFluidProperty());

        Strontium.setProperty(INGOT, new IngotProperty());
        Strontium.setProperty(FLUID, getFluidProperty());

        Polonium.setProperty(INGOT, new IngotProperty());
        Polonium.setProperty(FLUID, getFluidProperty());

        Fermium.setProperty(INGOT, new IngotProperty());
        Fermium.setProperty(FLUID, getFluidProperty());

        Bohrium.setProperty(INGOT, new IngotProperty());
        Bohrium.setProperty(FLUID, getFluidProperty());

        Curium.setProperty(INGOT, new IngotProperty());
        Curium.setProperty(FLUID, getFluidProperty());

        Radium.setProperty(DUST, new DustProperty());
        Radium.setProperty(FLUID, getFluidProperty());

        Actinium.setProperty(DUST, new DustProperty());
        Actinium.setProperty(FLUID, getFluidProperty());

        Californium.setProperty(INGOT, new IngotProperty());
        Californium.setProperty(FLUID, getFluidProperty());
        Californium.setProperty(ORE, new OreProperty(1, 1, false));

        Astatine.setProperty(DUST, new DustProperty());
        Astatine.setProperty(FLUID, getFluidProperty());

        Copernicium.setProperty(INGOT, new IngotProperty());
        Copernicium.setProperty(FLUID, getFluidProperty());

        Nihonium.setProperty(INGOT, new IngotProperty());
        Nihonium.setProperty(FLUID, getFluidProperty());

        Moscovium.setProperty(INGOT, new IngotProperty());
        Moscovium.setProperty(FLUID, getFluidProperty());

        Hafnium.setProperty(INGOT, new IngotProperty());
        Hafnium.setProperty(FLUID, getFluidProperty());

        Meitnerium.setProperty(INGOT, new IngotProperty());
        Meitnerium.setProperty(FLUID, getFluidProperty());

        Roentgenium.setProperty(INGOT, new IngotProperty());
        Roentgenium.setProperty(FLUID, getFluidProperty());

        Thallium.setProperty(DUST, new DustProperty());
        Rubidium.setProperty(DUST, new DustProperty());
        Selenium.setProperty(DUST, new DustProperty());
        Tellurium.setProperty(DUST, new DustProperty());
        Erbium.setProperty(DUST, new DustProperty());
        Terbium.setProperty(DUST, new DustProperty());
        Zirconium.setProperty(DUST, new DustProperty());
        Gadolinium.setProperty(DUST, new DustProperty());
        Dysprosium.setProperty(DUST, new DustProperty());
        Holmium.setProperty(DUST, new DustProperty());
        Francium.setProperty(DUST, new DustProperty());
        Protactinium.setProperty(DUST, new DustProperty());
        Praseodymium.setProperty(DUST, new DustProperty());

        SodiumHydroxide.setProperty(FLUID, getFluidProperty());
        AmmoniumChloride.setProperty(FLUID, getFluidProperty());
        Calcium.setProperty(FLUID, getFluidProperty());
        Sodium.setProperty(FLUID, getFluidProperty());
        Caesium.setProperty(FLUID, getFluidProperty());
        Tennessine.setProperty(FLUID, getFluidProperty());
        NetherStar.setProperty(FLUID, getFluidProperty());
        Ruridit.setProperty(FLUID, getFluidProperty());
        SodiumBisulfate.setProperty(FLUID, getFluidProperty(8000));

        Rhenium.setProperty(INGOT, new IngotProperty());
        Promethium.setProperty(INGOT, new IngotProperty());
        Mendelevium.setProperty(INGOT, new IngotProperty());

        //  Grind Ball Properties
        Soapstone.setProperty(GRIND_BALL, new GrindBallProperty(1F, 1F, 500));
        Aluminium.setProperty(GRIND_BALL, new GrindBallProperty(2F, 1F, 1000));
        Titanium.setProperty(GRIND_BALL, new GrindBallProperty(2.2F, 0.9F, 3000));
        TungstenSteel.setProperty(GRIND_BALL, new GrindBallProperty(2.2F, 0.9F, 5000));
        Neutronium.setProperty(GRIND_BALL, new GrindBallProperty(2.5F, 0.8F, 10000));

        CosmicNeutronium.setProperty(
                GRIND_BALL,
                new GrindBallProperty(3F, 0.5F, 20000)
                        .model(Epimorphism.id("item/grind_ball/neutronium"))
                        .renderer(new HaloItemBehavior(
                                8,
                                0x99FFFFFF,
                                new ResourceLocation(Epimorphism.MOD_ID, "sprite/halo_noise"),
                                true,
                                false)));

        //  Crucible Properties
        Bronze.setProperty(CRUCIBLE, new CrucibleProperty(1696));
        Invar.setProperty(CRUCIBLE, new CrucibleProperty(2395));
        Quartzite.setProperty(CRUCIBLE, new CrucibleProperty(2482));
        Chromium.setProperty(CRUCIBLE, new CrucibleProperty(2725));
        Vanadium.setProperty(CRUCIBLE, new CrucibleProperty(2728));
        NiobiumTitanium.setProperty(CRUCIBLE, new CrucibleProperty(2931));
        Iridium.setProperty(CRUCIBLE, new CrucibleProperty(3398));
        Molybdenum.setProperty(CRUCIBLE, new CrucibleProperty(3620));
        Tungsten.setProperty(CRUCIBLE, new CrucibleProperty(3695));
        Osmium.setProperty(CRUCIBLE, new CrucibleProperty(4132));
        Graphite.setProperty(CRUCIBLE, new CrucibleProperty(4750));
        HexagonalBoronNitride.setProperty(CRUCIBLE, new CrucibleProperty(5328));

        //  Fence Properties
        Iron.setProperty(FENCE, new FenceProperty());
        Gold.setProperty(FENCE, new FenceProperty());
        Steel.setProperty(FENCE, new FenceProperty());

        PalladiumOnCarbon.setProperty(CATALYST, new CatalystProperty(50));

        //  IconSets
        Bromine.setMaterialIconSet(MaterialIconSet.FLUID);

        //  Wire Properties
        WireProperties wireProp = RutheniumTriniumAmericiumNeutronate.getProperty(WIRE);
        wireProp.setSuperconductor(false);
        wireProp.setLossPerBlock(32);
        wireProp.setVoltage((int) V[UIV]);

        //  Ore Properties
        Molybdenite.getProperty(ORE).setDirectSmeltResult(null);
        Pollucite.getProperty(ORE).setOreByProducts(Aluminium, Potassium, Caesium, Pollucite);
    }

    private static FluidProperty getFluidProperty(int temperature) {
        FluidProperty prop = new FluidProperty();
        prop.getStorage().enqueueRegistration(LIQUID, new FluidBuilder().temperature(temperature));
        return prop;
    }

    private static FluidProperty getFluidProperty() {
        FluidProperty prop = new FluidProperty();
        prop.getStorage().enqueueRegistration(LIQUID, new FluidBuilder());
        return prop;
    }
}
