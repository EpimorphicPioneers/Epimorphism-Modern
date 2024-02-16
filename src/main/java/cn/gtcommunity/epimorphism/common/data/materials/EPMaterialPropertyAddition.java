package cn.gtcommunity.epimorphism.common.data.materials;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.api.chemical.material.properties.GrindBallProperty;
import cn.gtcommunity.epimorphism.common.item.behaviors.renderer.HaloRenderItemBehavior;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.*;
import com.gregtechceu.gtceu.api.fluids.FluidBuilder;
import net.minecraft.resources.ResourceLocation;

import static cn.gtcommunity.epimorphism.api.chemical.material.properties.EPPropertyKeys.*;
import static cn.gtcommunity.epimorphism.common.data.EPMaterials.CosmicNeutronium;
import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey.*;
import static com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

public class EPMaterialPropertyAddition {
    public static void init() {
        //  Setter
        RarestMetalMixture.setFormula("Ir2O2(SiO2)2Au3?");
        IridiumMetalResidue.setFormula("Ir2O4(SiO2)2Au3");
        AcidicOsmiumSolution.setFormula("OsO4(H2O)(HCl)");
        PalladiumRaw.setFormula("PdCl2?");

        //  GT Properties
        Iodine.setProperty(DUST, new DustProperty());
        Iodine.setProperty(FLUID, new FluidProperty());

        Germanium.setProperty(INGOT, new IngotProperty());
        Germanium.setProperty(BLAST, new BlastProperty(1211, BlastProperty.GasTier.HIGH, VA[EV], 1200));
        Germanium.setProperty(FLUID, new FluidProperty());

        Scandium.setProperty(DUST, new DustProperty());
        Scandium.setProperty(FLUID, new FluidProperty());

        Neptunium.setProperty(DUST, new DustProperty());
        Neptunium.setProperty(FLUID, new FluidProperty());

        Dubnium.setProperty(INGOT, new IngotProperty());
        Dubnium.setProperty(FLUID, new FluidProperty());

        Seaborgium.setProperty(INGOT, new IngotProperty());
        Seaborgium.setProperty(FLUID, new FluidProperty());
        Seaborgium.setProperty(WIRE, new WireProperties((int) V[UEV], 32, 32, false));

        Rutherfordium.setProperty(INGOT, new IngotProperty());
        Rutherfordium.setProperty(FLUID, new FluidProperty());

        Livermorium.setProperty(INGOT, new IngotProperty());
        Livermorium.setProperty(FLUID, new FluidProperty());

        Thulium.setProperty(DUST, new DustProperty());
        Thulium.setProperty(FLUID, new FluidProperty());

        Ytterbium.setProperty(DUST, new DustProperty());
        Ytterbium.setProperty(FLUID, new FluidProperty());

        Strontium.setProperty(INGOT, new IngotProperty());
        Strontium.setProperty(FLUID, new FluidProperty());

        Polonium.setProperty(INGOT, new IngotProperty());
        Polonium.setProperty(FLUID, new FluidProperty());

        Fermium.setProperty(INGOT, new IngotProperty());
        Fermium.setProperty(FLUID, new FluidProperty());

        Bohrium.setProperty(INGOT, new IngotProperty());
        Bohrium.setProperty(FLUID, new FluidProperty());

        Curium.setProperty(INGOT, new IngotProperty());
        Curium.setProperty(FLUID, new FluidProperty());

        Radium.setProperty(DUST, new DustProperty());
        Radium.setProperty(FLUID, new FluidProperty());

        Actinium.setProperty(DUST, new DustProperty());
        Actinium.setProperty(FLUID, new FluidProperty());

        Californium.setProperty(INGOT, new IngotProperty());
        Californium.setProperty(FLUID, new FluidProperty());
        Californium.setProperty(ORE, new OreProperty(1, 1, false));

        Astatine.setProperty(DUST, new DustProperty());
        Astatine.setProperty(FLUID, new FluidProperty());

        Copernicium.setProperty(INGOT, new IngotProperty());
        Copernicium.setProperty(FLUID, new FluidProperty());

        Nihonium.setProperty(INGOT, new IngotProperty());
        Nihonium.setProperty(FLUID, new FluidProperty());

        Moscovium.setProperty(INGOT, new IngotProperty());
        Moscovium.setProperty(FLUID, new FluidProperty());

        Hafnium.setProperty(INGOT, new IngotProperty());
        Hafnium.setProperty(FLUID, new FluidProperty());

        Meitnerium.setProperty(INGOT, new IngotProperty());
        Meitnerium.setProperty(FLUID, new FluidProperty());

        Roentgenium.setProperty(INGOT, new IngotProperty());
        Roentgenium.setProperty(FLUID, new FluidProperty());

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

        Bromine.setProperty(FLUID, new FluidProperty());
        SodiumHydroxide.setProperty(FLUID, new FluidProperty());
        AmmoniumChloride.setProperty(FLUID, new FluidProperty());
        Calcium.setProperty(FLUID, new FluidProperty());
        Sodium.setProperty(FLUID, new FluidProperty());
        Caesium.setProperty(FLUID, new FluidProperty());
        Tennessine.setProperty(FLUID, new FluidProperty());
        NetherStar.setProperty(FLUID, new FluidProperty());

        Rhenium.setProperty(INGOT, new IngotProperty());
        Promethium.setProperty(INGOT, new IngotProperty());
        Mendelevium.setProperty(INGOT, new IngotProperty());

        //  Grind Ball Properties
        Soapstone.setProperty(GRIND_BALL, new GrindBallProperty(1F, 1F, 500));
        Aluminium.setProperty(GRIND_BALL, new GrindBallProperty(2F, 1F, 1000));
        Titanium.setProperty(GRIND_BALL, new GrindBallProperty(2.2F, 0.9F, 3000));
        TungstenSteel.setProperty(GRIND_BALL, new GrindBallProperty(2.2F, 0.9F, 5000));
        Neutronium.setProperty(GRIND_BALL, new GrindBallProperty(2.5F, 0.8F, 10000));

        CosmicNeutronium.setProperty(GRIND_BALL,
                new GrindBallProperty(3F, 0.5F, 20000)
                .model(Epimorphism.id("item/grind_ball/neutronium"))
                .renderer(new HaloRenderItemBehavior(8, 0x99FFFFFF, new ResourceLocation(Epimorphism.MOD_ID, "sprite/halo_noise"), true, false)));

        //  IconSets
        Bromine.setMaterialIconSet(MaterialIconSet.FLUID);

        //  Fluid Temperatures
        FluidProperty prop = new FluidProperty();
        prop.getStorage().enqueueRegistration(LIQUID, new FluidBuilder().temperature(8000));
        SodiumBisulfate.setProperty(FLUID, prop);

        //  Wire Properties
        WireProperties wireProp = RutheniumTriniumAmericiumNeutronate.getProperty(WIRE);
        wireProp.setSuperconductor(false);
        wireProp.setLossPerBlock(32);
        wireProp.setVoltage((int) V[UIV]);

        //  Ore Properties
        Molybdenite.getProperty(ORE).setDirectSmeltResult(null);
        Pollucite.getProperty(ORE).setOreByProducts(Aluminium, Potassium, Caesium, Pollucite);
    }
}