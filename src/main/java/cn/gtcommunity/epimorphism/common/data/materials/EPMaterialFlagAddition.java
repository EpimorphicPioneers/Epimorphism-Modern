package cn.gtcommunity.epimorphism.common.data.materials;

import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import static cn.gtcommunity.epimorphism.api.chemical.material.info.EPMaterialFlags.*;

public class EPMaterialFlagAddition {

    public static void init() {
        //  Coils

        //  Motor coils
        //  Copper (LV), Cupronickel (MV), Electrum (HV), Kanthal (EV),
        //  Graphene (IV), Ruridit (LuV), Vanadium Gallium (ZPM), Americium (UV)
        //  Europium (UHV), Carbon Nanotube (UEV)

        GTMaterials.Copper.addFlags(GENERATE_COIL);
        GTMaterials.Cupronickel.addFlags(GENERATE_COIL);
        GTMaterials.Electrum.addFlags(GENERATE_COIL);
        GTMaterials.Kanthal.addFlags(GENERATE_COIL);
        GTMaterials.Graphene.addFlags(GENERATE_COIL);
        GTMaterials.Ruridit.addFlags(GENERATE_COIL);
        GTMaterials.VanadiumGallium.addFlags(GENERATE_COIL);
        GTMaterials.Americium.addFlags(GENERATE_COIL);
        GTMaterials.Europium.addFlags(GENERATE_COIL);
        // CarbonNanotube.addFlags(GENERATE_COIL);

        //  Voltage coils
        //  Lead (ULV), Steel (LV), Aluminium (MV), Black Steel (HV),
        //  Tungsten Steel (EV), Iridium (IV), Osmiridium (LuV), Europium (ZPM),
        //  Tritanium (UV), Vibranium (UHV), Seaborgium (UEV)
        GTMaterials.Lead.addFlags(GENERATE_COIL);
        GTMaterials.Steel.addFlags(GENERATE_COIL);
        GTMaterials.Aluminium.addFlags(GENERATE_COIL);
        GTMaterials.BlackSteel.addFlags(GENERATE_COIL);
        GTMaterials.TungstenSteel.addFlags(GENERATE_COIL);
        GTMaterials.Iridium.addFlags(GENERATE_COIL);
        GTMaterials.Osmiridium.addFlags(GENERATE_COIL);
        // Europium.addFlags(GENERATE_COIL);
        GTMaterials.Tritanium.addFlags(GENERATE_COIL);
        // Vibranium.addFlags(GENERATE_COIL);
        GTMaterials.Seaborgium.addFlags(GENERATE_COIL);

        //  Curved plates

        //  Rotors
        GTMaterials.Iron.addFlags(GENERATE_CURVED_PLATE);
        GTMaterials.WroughtIron.addFlags(GENERATE_CURVED_PLATE);
        GTMaterials.Darmstadtium.addFlags(GENERATE_CURVED_PLATE);
        GTMaterials.RhodiumPlatedPalladium.addFlags(GENERATE_CURVED_PLATE);
        GTMaterials.NaquadahAlloy.addFlags(GENERATE_CURVED_PLATE);
        GTMaterials.HSSS.addFlags(GENERATE_CURVED_PLATE);
        //  HastelloyN.addFlags(GENERATE_CURVED_PLATE);
        //  Draconium.addFlags(GENERATE_CURVED_PLATE);
        //  Adamantium.addFlags(GENERATE_CURVED_PLATE);
        //  Dawnstone.addFlags(GENERATE_CURVED_PLATE);

        /*
        *  CEu Vanilla Fluid Pipes
        *  Aluminium
        *  Bronze
        *  Chrome
        *  Copper
        *  Duranium
        *  Europium
        *  Gold
        *  Iridium
        *  Lead
        *  Naquadah
        *  Neutronium
        *  NiobiumTitanium
        *  Polyethylene            (x)
        *  Polybenzimidazole       (x)
        *  Polytetrafluoroethylene (x)
        *  Potin
        *  Stainless Steel
        *  Steel
        *  Tin Alloy
        *  Titanium
        *  Tungsten
        *  Tungsten Carbide
        *  TungstenSteel
        *  VanadiumSteel
         */
        GTMaterials.Aluminium.addFlags(GENERATE_CURVED_PLATE);
        GTMaterials.Bronze.addFlags(GENERATE_CURVED_PLATE);
//        Chrome.addFlags(GENERATE_CURVED_PLATE);
        GTMaterials.Copper.addFlags(GENERATE_CURVED_PLATE);
        GTMaterials.Duranium.addFlags(GENERATE_CURVED_PLATE);
        GTMaterials.Europium.addFlags(GENERATE_CURVED_PLATE);
        GTMaterials.Gold.addFlags(GENERATE_CURVED_PLATE);
        GTMaterials.Iridium.addFlags(GENERATE_CURVED_PLATE);
        GTMaterials.Lead.addFlags(GENERATE_CURVED_PLATE);
        GTMaterials.Naquadah.addFlags(GENERATE_CURVED_PLATE);
        GTMaterials.Neutronium.addFlags(GENERATE_CURVED_PLATE);
        GTMaterials.NiobiumTitanium.addFlags(GENERATE_CURVED_PLATE);
        // Polyethylene.addFlags(GENERATE_CURVED_PLATE);
        // Polybenzimidazole.addFlags(GENERATE_CURVED_PLATE);
        // Polytetrafluoroethylene.addFlags(GENERATE_CURVED_PLATE);
        GTMaterials.Potin.addFlags(GENERATE_CURVED_PLATE);
        GTMaterials.StainlessSteel.addFlags(GENERATE_CURVED_PLATE);
        GTMaterials.Steel.addFlags(GENERATE_CURVED_PLATE);
        GTMaterials.TinAlloy.addFlags(GENERATE_CURVED_PLATE);
        GTMaterials.Titanium.addFlags(GENERATE_CURVED_PLATE);
        GTMaterials.Tungsten.addFlags(GENERATE_CURVED_PLATE);
        GTMaterials.TungstenCarbide.addFlags(GENERATE_CURVED_PLATE);
        GTMaterials.TungstenSteel.addFlags(GENERATE_CURVED_PLATE);
        GTMaterials.VanadiumSteel.addFlags(GENERATE_CURVED_PLATE);

        /*
         *  CEu Vanilla Item Pipes
         *  Americium
         *  Magnalium
         *  Sterling Silver
         *  Tin
         *  Cupronickel
         *  Black Bronze
         *  Cobalt Brass
         *  Electrum
         *  Cobalt
         *  Platinum
         *  Brass
         *  Osmium
         *  Ultimet
         *  Osmiridium
         *  Nickel
         *  Polyvinyl Chloride (x)
         *  Rose Gold
         */
        GTMaterials.Americium.addFlags(GENERATE_CURVED_PLATE);
        GTMaterials.Magnalium.addFlags(GENERATE_CURVED_PLATE);
        GTMaterials.SterlingSilver.addFlags(GENERATE_CURVED_PLATE);
        GTMaterials.Tin.addFlags(GENERATE_CURVED_PLATE);
        GTMaterials.Cupronickel.addFlags(GENERATE_CURVED_PLATE);
        GTMaterials.BlackBronze.addFlags(GENERATE_CURVED_PLATE);
        GTMaterials.CobaltBrass.addFlags(GENERATE_CURVED_PLATE);
        GTMaterials.Electrum.addFlags(GENERATE_CURVED_PLATE);
        GTMaterials.Cobalt.addFlags(GENERATE_CURVED_PLATE);
        GTMaterials.Platinum.addFlags(GENERATE_CURVED_PLATE);
        GTMaterials.Brass.addFlags(GENERATE_CURVED_PLATE);
        GTMaterials.Osmium.addFlags(GENERATE_CURVED_PLATE);
        GTMaterials.Ultimet.addFlags(GENERATE_CURVED_PLATE);
        GTMaterials.Osmiridium.addFlags(GENERATE_CURVED_PLATE);
        GTMaterials.Nickel.addFlags(GENERATE_CURVED_PLATE);
        // PolyvinylChloride.addFlags(GENERATE_CURVED_PLATE);
        GTMaterials.RoseGold.addFlags(GENERATE_CURVED_PLATE);

        //  Disable Crystallization
        GTMaterials.Monazite.addFlags(DISABLE_CRYSTALLIZATION);

        //  Crystallizable
        GTMaterials.Sapphire.addFlags(MaterialFlags.CRYSTALLIZABLE);
        GTMaterials.Ruby.addFlags(MaterialFlags.CRYSTALLIZABLE);
        GTMaterials.Emerald.addFlags(MaterialFlags.CRYSTALLIZABLE);
        GTMaterials.Olivine.addFlags(MaterialFlags.CRYSTALLIZABLE);
        GTMaterials.Amethyst.addFlags(MaterialFlags.CRYSTALLIZABLE);
        GTMaterials.Opal.addFlags(MaterialFlags.CRYSTALLIZABLE);
    }
}
