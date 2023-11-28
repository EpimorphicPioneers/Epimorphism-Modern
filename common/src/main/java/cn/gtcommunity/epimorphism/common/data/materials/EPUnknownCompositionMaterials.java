package cn.gtcommunity.epimorphism.common.data.materials;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.fluids.FluidBuilder;
import com.gregtechceu.gtceu.api.fluids.attribute.FluidAttributes;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet.*;
import static cn.gtcommunity.epimorphism.common.data.EPMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static net.minecraft.ChatFormatting.*;

public class EPUnknownCompositionMaterials {
    public static void register() {
        //  25201 BZMedium
        BZMedium = new Material.Builder("bz_medium")
                .fluid()
                .color(10681653)
                .buildAndRegister();
        //  25202 EDP
        EDP = new Material.Builder("edp")
                .fluid()
                .color(16514839)
                .buildAndRegister();
        //  25203 Rich Nitrogen Mixture
        RichNitrogenMixture = new Material.Builder("rich_nitrogen_mixture")
                .gas()
                .color(0x6891D8)
                .buildAndRegister();
        //  25204 Rich Ammonia Mixture
        RichAmmoniaMixture = new Material.Builder("rich_ammonia_mixture")
                .fluid()
                .color(0x708ACD)
                .buildAndRegister();
        //  25205 Blazing Pyrotheum
        BlazingPyrotheum = new Material.Builder("blazing_pyrotheum")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(8000))
                .color(GTMaterials.Blaze.getMaterialRGB())
                .components(Blaze, 2, Redstone, 1, Sulfur, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  25206 Gelid Cryotheum
        GelidCryotheum = new Material.Builder("gelid_cryotheum")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(8))
                .color(0x40B8FB)
                .components(Ice, 2, Electrotine, 1, Water, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  25207 Co/AC-AB Catalyst
        CoACABCatalyst = new Material.Builder("co_ac_ab_catalyst")
                .dust()
                .color(0x6B4312)
                .iconSet(METALLIC)
                .buildAndRegister();
        //  25208 PhosphoreneSolution
        PhosphoreneSolution = new Material.Builder("phosphorene_solution")
                .fluid()
                .color(0x465966)
                .buildAndRegister();
        //  25209 Methylamine Mixture
        MethylamineMixture = new Material.Builder("methylamine_mixture")
                .fluid()
                .color(0xAA4400)
                .buildAndRegister();
        //  25210 Molybdenum Flue
        MolybdenumFlue = new Material.Builder("molybdenum_flue")
                .gas()
                .color(0x39194A)
                .buildAndRegister();
        //  25211 Trace Rhenium Flue
        TraceRheniumFlue = new Material.Builder("trace_rhenium_flue")
                .gas()
                .color(0x96D6D5)
                .buildAndRegister();
        //  25212 Chalcogen Anode Mud
        ChalcogenAnodeMud = new Material.Builder("chalcogen_anode_mud")
                .dust()
                .color(0x8A3324)
                .iconSet(FINE)
                .buildAndRegister();
        //  25213 Precious Metal
        PreciousMetal = new Material.Builder("precious_metal")
                .ore(1, 1, false)
                .ingot()
                .addOreByproducts(Iron)
                .color(0xDAA520)
                .iconSet(SHINY)
                .buildAndRegister()
                .setFormula("Au?", false);
        //  25214 Iridium Platinum Metal Dust
        IridiumPlatinumMetalDust = new Material.Builder("iridium_platinum_metal_dust")
                .dust()
                .color(0x87CEFA)
                .iconSet(ROUGH)
                .buildAndRegister()
                .setFormula("Ir2O4(SiO2)2Au3Pt?", true);
        //  25215 Rarest Metal Residue
        RarestMetalResidue = new Material.Builder("rarest_metal_residue")
                .dust()
                .color(0xA0522D)
                .iconSet(DULL)
                .buildAndRegister();
        //  25216 Crude Naquadah Fuel
        CrudeNaquadahFuel = new Material.Builder("crude_naquadah_fuel")
                .fluid()
                .color(0x077F4E)
                .iconSet(DULL)
                .buildAndRegister();
        //  25217 Heavy Naquadah Fuel
        HeavyNaquadahFuel = new Material.Builder("heavy_naquadah_fuel")
                .fluid()
                .color(0x088C56)
                .buildAndRegister();
        //  25218 Medium Naquadah Fuel
        MediumNaquadahFuel = new Material.Builder("medium_naquadah_fuel")
                .fluid()
                .color(0x09A566)
                .buildAndRegister();
        //  25219 Light Naquadah Fuel
        LightNaquadahFuel = new Material.Builder("light_naquadah_fuel")
                .fluid()
                .color(0x0BBF75)
                .buildAndRegister();
        //  25220 Naquadah Gas
        NaquadahGas = new Material.Builder("naquadah_gas")
                .gas()
                .color(0x0CD985)
//                .iconSet(GAS)
                .buildAndRegister();
        //  25221 Fracturing Fluid
        FracturingFluid = new Material.Builder("fracturing_fluid")
                .fluid()
                .color(0x96D6D5)
                .buildAndRegister();
        //  25222 Bedrock
        Bedrock = new Material.Builder("bedrock")
                .dust()
                .fluid()
                .color(0x404040)
                .iconSet(ROUGH)
                .buildAndRegister();
        //  25223 Bedrock Smoke
        BedrockSmoke = new Material.Builder("bedrock_smoke")
                .gas()
                .color(0x525252)
                .buildAndRegister();
        //  25224 Bedrock Soot Solution
        BedrockSootSolution = new Material.Builder("bedrock_soot_solution")
                .fluid()
                .color(0x1E2430)
                .buildAndRegister();
        //  25225 Clean Bedrock Solution
        CleanBedrockSolution = new Material.Builder("clean_bedrock_solution")
                .fluid()
                .color(0xA89F9E)
                .buildAndRegister();
        //  25226 Heavy Bedrock Smoke
        HeavyBedrockSmoke = new Material.Builder("heavy_bedrock_smoke")
                .gas()
                .color(0x242222)
                .buildAndRegister();
        //  25227 Medium Bedrock Smoke
        MediumBedrockSmoke = new Material.Builder("medium_bedrock_smoke")
                .gas()
                .color(0x2E2C2C)
                .buildAndRegister();
        //  25228 Light Bedrock Smoke
        LightBedrockSmoke = new Material.Builder("light_bedrock_smoke")
                .gas()
                .color(0x363333)
                .buildAndRegister();
        //  25229 Ultralight Bedrock Smoke
        UltralightBedrockSmoke = new Material.Builder("ultralight_bedrock_smoke")
                .gas()
                .color(0x403D3D)
                .buildAndRegister();
        //  25230 Heavy Taranium Gas
        HeavyTaraniumGas = new Material.Builder("heavy_taranium_gas")
                .gas()
                .color(0x262626)
                .buildAndRegister();
        //  25231 Medium Taranium Gas
        MediumTaraniumGas = new Material.Builder("medium_taranium_gas")
                .gas()
                .color(0x313131)
                .buildAndRegister();
        //  25232 Light Taranium Gas
        LightTaraniumGas = new Material.Builder("light_taranium_gas")
                .gas()
                .color(0x404040)
                .buildAndRegister();
        //  25233 Bedrock Gas
        BedrockGas = new Material.Builder("bedrock_gas")
                .gas()
                .color(0x575757)
                .buildAndRegister();
        //  25234 Cracked Heavy Taranium
        CrackedHeavyTaranium = new Material.Builder("cracked_heavy_taranium")
                .fluid()
                .color(0x1F2B2E)
                .buildAndRegister();
        //  25235 Cracked Medium Taranium
        CrackedMediumTaranium = new Material.Builder("cracked_medium_taranium")
                .fluid()
                .color(0x29393D)
                .buildAndRegister();
        //  25236 Cracked Light Taranium
        CrackedLightTaranium = new Material.Builder("cracked_light_taranium")
                .fluid()
                .color(0x374C52)
                .buildAndRegister();
        //  25237 Enriched Bedrock Soot Solution
        EnrichedBedrockSootSolution = new Material.Builder("enriched_bedrock_soot_solution")
                .fluid()
                .color(0x280C26)
                .buildAndRegister();
        //  25238 Clean Enriched Bedrock Solution
        CleanEnrichedBedrockSolution = new Material.Builder("clean_enriched_bedrock_solution")
                .fluid()
                .color(0x828C8C)
                .buildAndRegister();
        //  25239 Heavy Enriched Bedrock Smoke
        HeavyEnrichedBedrockSmoke = new Material.Builder("heavy_enriched_bedrock_smoke")
                .gas()
                .color(0x1A2222)
                .buildAndRegister();
        //  25240 Medium Enriched Bedrock Smoke
        MediumEnrichedBedrockSmoke = new Material.Builder("medium_enriched_bedrock_smoke")
                .gas()
                .color(0x1E2C2C)
                .buildAndRegister();
        //  25241 Light Enriched Bedrock Smoke
        LightEnrichedBedrockSmoke = new Material.Builder("light_enriched_bedrock_smoke")
                .gas()
                .color(0x163333)
                .buildAndRegister();
        //  25242 Heavy Enriched Taranium Gas
        HeavyEnrichedTaraniumGas = new Material.Builder("heavy_enriched_taranium_gas")
                .gas()
                .color(0x1F2626)
                .buildAndRegister();
        //  25243 Medium Enriched Taranium Gas
        MediumEnrichedTaraniumGas = new Material.Builder("medium_enriched_taranium_gas")
                .gas()
                .color(0x1F3131)
                .buildAndRegister();
        //  25244 Light Enriched Taranium Gas
        LightEnrichedTaraniumGas = new Material.Builder("light_enriched_taranium_gas")
                .gas()
                .color(0x1F4040)
                .buildAndRegister();
        //  25245 Cracked Heavy Enriched Taranium
        CrackedHeavyEnrichedTaranium = new Material.Builder("cracked_heavy_enriched_taranium")
                .fluid()
                .color(0x2E1F2E)
                .buildAndRegister();
        //  25246 Cracked Medium Enriched Taranium
        CrackedMediumEnrichedTaranium = new Material.Builder("cracked_medium_enriched_taranium")
                .fluid()
                .color(0x29393D)
                .buildAndRegister();
        //  25247 Cracked Light Enriched Taranium
        CrackedLightEnrichedTaranium = new Material.Builder("cracked_light_enriched_taranium")
                .fluid()
                .color(0x374C52)
                .buildAndRegister();
        //  25248 Energetic Naquadria
        EnergeticNaquadria = new Material.Builder("energetic_naquadria")
                .fluid()
                .color(0x202020)
                .buildAndRegister();
        //  25249 Light Hyper Fuel
        LightHyperFuel = new Material.Builder("light_hyper_fuel")
                .fluid()
                .color(0x8C148C)
                .buildAndRegister();
        //  25250 Medium Hyper Fuel
        MediumHyperFuel = new Material.Builder("medium_hyper_fuel")
                .fluid()
                .color(0xDC0A0A)
                .buildAndRegister();
        //  25251 Heavy Hyper Fuel
        HeavyHyperFuel = new Material.Builder("heavy_hyper_fuel")
                .fluid()
                .color(0x1E5064)
                .buildAndRegister();
        //  25252 Crude Rare Earth Turbid Solution
        CrudeRareEarthTurbidSolution = new Material.Builder("crude_rare_earth_turbid_solution")
                .fluid()
                .color(0x9C5C6B)
                .iconSet(DULL)
                .buildAndRegister();
        //  25253 Nitrated Rare Earth Turbid Solution
        NitratedRareEarthTurbidSolution = new Material.Builder("nitrated_rare_earth_turbid_solution")
                .fluid()
                .color(0x754550)
                .iconSet(DULL)
                .buildAndRegister();
        //  25254 Rare Earth Hydroxides Solution
        RareEarthHydroxidesSolution = new Material.Builder("rare_earth_hydroxides_solution")
                .fluid()
                .color(0x434327)
                .flags(DISABLE_DECOMPOSITION)
                .components(RareEarth, 1, Oxygen, 1, Hydrogen, 1, Water, 1)
                .buildAndRegister();
        //  25255 Rare Earth Chlorides Slurry
        RareEarthChloridesSlurry = new Material.Builder("rare_earth_chlorides_slurry")
                .dust()
                .color(0x838367)
                .iconSet(ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(RareEarth, 1, Chlorine, 1, Water, 1)
                .buildAndRegister();
        //  25256 Low-purity Rare Earth Chlorides Solution
        LowPurityRareEarthChloridesSolution = new Material.Builder("low_purity_rare_earth_chlorides_solution")
                .fluid()
                .color(0x838333)
                .iconSet(DULL)
                .flags(DISABLE_DECOMPOSITION)
                .components(RareEarth, 1, Chlorine, 1, Water, 2)
                .buildAndRegister();
        //  25257 Roughly Purified Rare Earth Chlorides Solution
        RoughlyPurifiedRareEarthChloridesSolution = new Material.Builder("roughly_purified_rare_earth_chlorides_solution")
                .fluid()
                .color(0xA2A27F)
                .iconSet(DULL)
                .flags(DISABLE_DECOMPOSITION)
                .components(LowPurityRareEarthChloridesSolution, 4, AquaRegia, 2)
                .buildAndRegister();
        //  25258 High Purity Rare Earth Chlorides Slurry
        HighPurityRareEarthChloridesSlurry = new Material.Builder("high_purity_rare_earth_chlorides_slurry")
                .dust()
                .color(0x838367)
                .iconSet(ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(RareEarth, 1, Chlorine, 1, Water, 1)
                .buildAndRegister();
        //  25259 High Purity Rare Earth Chlorides Solution
        HighPurityRareEarthChloridesSolution = new Material.Builder("high_purity_rare_earth_chlorides_solution")
                .fluid()
                .color(0x838367)
                .flags(DISABLE_DECOMPOSITION)
                .components(RareEarth, 1, Chlorine, 1, Water, 1)
                .buildAndRegister();
        //  25260 Low Purity Rare Earth Chlorides Slag
        LowPurityRareEarthChloridesSlag = new Material.Builder("low_purity_rare_earth_chlorides_slag")
                .dust()
                .color(0x62624D)
                .iconSet(DULL)
                .buildAndRegister();
        //  25261 La-Pr-Nd-Ce Oxides Solution
        LaPrNdCeOxidesSolution = new Material.Builder("la_pr_nd_ce_oxides_solution")
                .fluid()
                .color(0x9CE3DB)
                .flags(DECOMPOSITION_BY_CENTRIFUGING)
                .components(LanthanumOxide, 1, PraseodymiumOxide, 1, NeodymiumOxide, 1, CeriumOxide, 1)
                .buildAndRegister();
        //  25262 Sc-Eu-Gd-Sm Oxides Solution
        ScEuGdSmOxidesSolution = new Material.Builder("sc_eu_gd_sm_oxides_solution")
                .fluid()
                .color(0xFFFF99)
                .flags(DECOMPOSITION_BY_CENTRIFUGING)
                .components(ScandiumOxide, 1, EuropiumOxide, 1, GadoliniumOxide, 1, SamariumOxide, 1)
                .buildAndRegister();
        //  25263 Y-Tb-Dy-Ho Oxides Solution
        YTbDyHoOxidesSolution = new Material.Builder("y_tb_dy_ho_oxides_solution")
                .fluid()
                .color(0x99FF99)
                .flags(DECOMPOSITION_BY_CENTRIFUGING)
                .components(YttriumOxide, 1, TerbiumOxide, 1, DysprosiumOxide, 1, HolmiumOxide, 1)
                .buildAndRegister();
        //  25264 Er-Tm-Yb-Lu Oxides Solution
        ErTmYbLuOxidesSolution = new Material.Builder("er_tm_yb_lu_oxides_solution")
                .fluid()
                .color(0xFFB3FF)
                .flags(DECOMPOSITION_BY_CENTRIFUGING)
                .components(ErbiumOxide, 1, ThuliumOxide, 1, YtterbiumOxide, 1, LutetiumOxide, 1)
                .buildAndRegister();
        //  25265 Chlorinated Solvents
        ChlorinatedSolvents = new Material.Builder("chlorinated_solvents")
                .fluid()
                .color(0x40804c)
                .buildAndRegister()
                .setFormula("(CH4)2Cl5", true);
        //  25266 Superheated Steam
        SuperheatedSteam = new Material.Builder("superheated_steam")
                .fluid(FluidStorageKeys.GAS, new FluidBuilder().temperature(573))
                .color(0xC4C4C4, false)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 2, Oxygen, 1)
                .buildAndRegister();
        //  25267 Supercritical Steam
        SupercriticalSteam = new Material.Builder("supercritical_steam")
                .fluid(FluidStorageKeys.GAS, new FluidBuilder().temperature(873))
                .color(0xC4C4C4, false)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 2, Oxygen, 1)
                .buildAndRegister();
        // 25268 High-Temperature Exhaust Gas
        HighTemperatureExhaustGas = new Material.Builder("high_temperature_exhaust_gas")
                .fluid(FluidStorageKeys.GAS, new FluidBuilder().temperature(1123))
                .color(0xF0EAD6)
                .buildAndRegister();
        // 25269 Exhaust Gas
        ExhaustGas = new Material.Builder("exhaust_gas")
                .fluid(FluidStorageKeys.GAS, new FluidBuilder().temperature(298))
                .color(0xEDEADE)
                .buildAndRegister();
        //  25270 Nitrated Dragon Dust Solution
        NitratedDragonDustSolution = new Material.Builder("nitrated_dragon_dust_solution")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0xF553FF)
                .buildAndRegister();
        //  25271 Residual Draconium Solution
        ResidualDraconiumSolution = new Material.Builder("residual_draconium_solution")
                .fluid()
                .color(0x4321C5)
                .buildAndRegister();
        //  25272 Draconium Slag Solution
        DraconiumSlagSolution = new Material.Builder("draconium_slag_solution")
                .fluid()
                .color(0x790D80)
                .iconSet(DULL)
                .buildAndRegister()
                .setFormula("Dc?(H2O)", true);
        //  25273 Actinium Radium Hydroxide Solution
        ActiniumRadiumHydroxideSolution = new Material.Builder("actinium_radium_hydroxide_solution")
                .fluid()
                .color(Actinium.getMaterialRGB() + Radium.getMaterialRGB())
                .buildAndRegister();
        //  25274 Actinium Radium Nitrate Solution
        ActiniumRadiumNitrateSolution = new Material.Builder("actinium_radium_nitrate_solution")
                .fluid()
                .color(ActiniumRadiumHydroxideSolution.getMaterialRGB() + NitricAcid.getMaterialRGB())
                .buildAndRegister();
        //  25275 Heavy Fluorinated Draconium Solution
        HeavyFluorinatedDraconiumSolution = new Material.Builder("heavy_fluorinated_draconium_solution")
                .fluid()
                .color(0x8C117D)
                .buildAndRegister();
        //  25276 Quasi-fissioning Plasma
        QuasifissioningPlasma = new Material.Builder("quasi_fissioning_plasma")
                .fluid(FluidStorageKeys.PLASMA, new FluidBuilder().temperature(230490))
                .color(0xB0A2C3)
                .buildAndRegister()
                .setFormula(OBFUSCATED + "aaa", false);
    }
}
