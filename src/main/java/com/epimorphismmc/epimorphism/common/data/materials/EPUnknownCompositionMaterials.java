package com.epimorphismmc.epimorphism.common.data.materials;

import com.epimorphismmc.epimorphism.api.data.chemical.material.info.EPMaterialIconSet;

import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.api.fluids.FluidBuilder;
import com.gregtechceu.gtceu.api.fluids.attribute.FluidAttributes;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;

import net.minecraft.ChatFormatting;

import static com.epimorphismmc.epimorphism.api.data.chemical.material.info.EPMaterialFlags.GENERATE_NANITES;
import static com.epimorphismmc.epimorphism.common.data.EPMaterials.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

public class EPUnknownCompositionMaterials {
    public static void register() {
        //  25201 BZMedium
        BZMedium = Builder("bz_medium").fluid().color(10681653).buildAndRegister();
        //  25202 EDP
        EDP = Builder("edp").fluid().color(16514839).buildAndRegister();
        //  25203 Rich Nitrogen Mixture
        RichNitrogenMixture = Builder("rich_nitrogen_mixture").gas().color(0x6891D8).buildAndRegister();
        //  25204 Rich Ammonia Mixture
        RichAmmoniaMixture = Builder("rich_ammonia_mixture").fluid().color(0x708ACD).buildAndRegister();
        //  25205 Blazing Pyrotheum
        BlazingPyrotheum = Builder("blazing_pyrotheum")
                .fluid(
                        FluidStorageKeys.LIQUID,
                        new FluidBuilder().temperature(8000).textures(true).color(-1))
                .color(Blaze.getMaterialRGB())
                .components(Blaze, 2, Redstone, 1, Sulfur, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  25206 Gelid Cryotheum
        GelidCryotheum = Builder("gelid_cryotheum")
                .fluid(
                        FluidStorageKeys.LIQUID,
                        new FluidBuilder().temperature(8).textures(true).color(-1))
                .color(0x40B8FB)
                .components(Ice, 2, Electrotine, 1, Water, 1)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  25207 Co/AC-AB Catalyst
        CoACABCatalyst = Builder("co_ac_ab_catalyst")
                .dust()
                .color(0x6B4312)
                .iconSet(MaterialIconSet.METALLIC)
                .buildAndRegister();
        //  25208 PhosphoreneSolution
        PhosphoreneSolution =
                Builder("phosphorene_solution").fluid().color(0x465966).buildAndRegister();
        //  25209 Methylamine Mixture
        MethylamineMixture = Builder("methylamine_mixture").fluid().color(0xAA4400).buildAndRegister();
        //  25210 Molybdenum Flue
        MolybdenumFlue = Builder("molybdenum_flue").gas().color(0x39194A).buildAndRegister();
        //  25211 Trace Rhenium Flue
        TraceRheniumFlue = Builder("trace_rhenium_flue").gas().color(0x96D6D5).buildAndRegister();
        //  25212 Chalcogen Anode Mud
        ChalcogenAnodeMud = Builder("chalcogen_anode_mud")
                .dust()
                .color(0x8A3324)
                .iconSet(MaterialIconSet.FINE)
                .buildAndRegister();
        //  25213 Precious Metal
        PreciousMetal = Builder("precious_metal")
                .ore(1, 1, false)
                .ingot()
                .addOreByproducts(Iron)
                .color(0xDAA520)
                .iconSet(MaterialIconSet.SHINY)
                .buildAndRegister()
                .setFormula("Au?", false);
        //  25214 Iridium Platinum Metal Dust
        IridiumPlatinumMetalDust = Builder("iridium_platinum_metal_dust")
                .dust()
                .color(0x87CEFA)
                .iconSet(MaterialIconSet.ROUGH)
                .buildAndRegister()
                .setFormula("Ir2O4(SiO2)2Au3Pt?", true);
        //  25215 Rarest Metal Residue
        RarestMetalResidue = Builder("rarest_metal_residue")
                .dust()
                .color(0xA0522D)
                .iconSet(MaterialIconSet.DULL)
                .buildAndRegister();
        //  25216 Crude Naquadah Fuel
        CrudeNaquadahFuel = Builder("crude_naquadah_fuel")
                .fluid()
                .color(0x077F4E)
                .iconSet(MaterialIconSet.DULL)
                .buildAndRegister();
        //  25217 Heavy Naquadah Fuel
        HeavyNaquadahFuel = Builder("heavy_naquadah_fuel").fluid().color(0x088C56).buildAndRegister();
        //  25218 Medium Naquadah Fuel
        MediumNaquadahFuel = Builder("medium_naquadah_fuel").fluid().color(0x09A566).buildAndRegister();
        //  25219 Light Naquadah Fuel
        LightNaquadahFuel = Builder("light_naquadah_fuel").fluid().color(0x0BBF75).buildAndRegister();
        //  25220 Naquadah Gas
        NaquadahGas = Builder("naquadah_gas")
                .gas()
                .color(0x0CD985)
                //                .iconSet(GAS)
                .buildAndRegister();
        //  25221 Fracturing Fluid
        FracturingFluid = Builder("fracturing_fluid").fluid().color(0x96D6D5).buildAndRegister();
        //  25222 Bedrock
        Bedrock = Builder("bedrock")
                .dust()
                .fluid()
                .color(0x404040)
                .iconSet(MaterialIconSet.ROUGH)
                .buildAndRegister();
        //  25223 Bedrock Smoke
        BedrockSmoke = Builder("bedrock_smoke").gas().color(0x525252).buildAndRegister();
        //  25224 Bedrock Soot Solution
        BedrockSootSolution =
                Builder("bedrock_soot_solution").fluid().color(0x1E2430).buildAndRegister();
        //  25225 Clean Bedrock Solution
        CleanBedrockSolution =
                Builder("clean_bedrock_solution").fluid().color(0xA89F9E).buildAndRegister();
        //  25226 Heavy Bedrock Smoke
        HeavyBedrockSmoke = Builder("heavy_bedrock_smoke").gas().color(0x242222).buildAndRegister();
        //  25227 Medium Bedrock Smoke
        MediumBedrockSmoke = Builder("medium_bedrock_smoke").gas().color(0x2E2C2C).buildAndRegister();
        //  25228 Light Bedrock Smoke
        LightBedrockSmoke = Builder("light_bedrock_smoke").gas().color(0x363333).buildAndRegister();
        //  25229 Ultralight Bedrock Smoke
        UltralightBedrockSmoke =
                Builder("ultralight_bedrock_smoke").gas().color(0x403D3D).buildAndRegister();
        //  25230 Heavy Taranium Gas
        HeavyTaraniumGas = Builder("heavy_taranium_gas").gas().color(0x262626).buildAndRegister();
        //  25231 Medium Taranium Gas
        MediumTaraniumGas = Builder("medium_taranium_gas").gas().color(0x313131).buildAndRegister();
        //  25232 Light Taranium Gas
        LightTaraniumGas = Builder("light_taranium_gas").gas().color(0x404040).buildAndRegister();
        //  25233 Bedrock Gas
        BedrockGas = Builder("bedrock_gas").gas().color(0x575757).buildAndRegister();
        //  25234 Cracked Heavy Taranium
        CrackedHeavyTaranium =
                Builder("cracked_heavy_taranium").fluid().color(0x1F2B2E).buildAndRegister();
        //  25235 Cracked Medium Taranium
        CrackedMediumTaranium =
                Builder("cracked_medium_taranium").fluid().color(0x29393D).buildAndRegister();
        //  25236 Cracked Light Taranium
        CrackedLightTaranium =
                Builder("cracked_light_taranium").fluid().color(0x374C52).buildAndRegister();
        //  25237 Enriched Bedrock Soot Solution
        EnrichedBedrockSootSolution =
                Builder("enriched_bedrock_soot_solution").fluid().color(0x280C26).buildAndRegister();
        //  25238 Clean Enriched Bedrock Solution
        CleanEnrichedBedrockSolution =
                Builder("clean_enriched_bedrock_solution").fluid().color(0x828C8C).buildAndRegister();
        //  25239 Heavy Enriched Bedrock Smoke
        HeavyEnrichedBedrockSmoke =
                Builder("heavy_enriched_bedrock_smoke").gas().color(0x1A2222).buildAndRegister();
        //  25240 Medium Enriched Bedrock Smoke
        MediumEnrichedBedrockSmoke =
                Builder("medium_enriched_bedrock_smoke").gas().color(0x1E2C2C).buildAndRegister();
        //  25241 Light Enriched Bedrock Smoke
        LightEnrichedBedrockSmoke =
                Builder("light_enriched_bedrock_smoke").gas().color(0x163333).buildAndRegister();
        //  25242 Heavy Enriched Taranium Gas
        HeavyEnrichedTaraniumGas =
                Builder("heavy_enriched_taranium_gas").gas().color(0x1F2626).buildAndRegister();
        //  25243 Medium Enriched Taranium Gas
        MediumEnrichedTaraniumGas =
                Builder("medium_enriched_taranium_gas").gas().color(0x1F3131).buildAndRegister();
        //  25244 Light Enriched Taranium Gas
        LightEnrichedTaraniumGas =
                Builder("light_enriched_taranium_gas").gas().color(0x1F4040).buildAndRegister();
        //  25245 Cracked Heavy Enriched Taranium
        CrackedHeavyEnrichedTaranium =
                Builder("cracked_heavy_enriched_taranium").fluid().color(0x2E1F2E).buildAndRegister();
        //  25246 Cracked Medium Enriched Taranium
        CrackedMediumEnrichedTaranium =
                Builder("cracked_medium_enriched_taranium").fluid().color(0x29393D).buildAndRegister();
        //  25247 Cracked Light Enriched Taranium
        CrackedLightEnrichedTaranium =
                Builder("cracked_light_enriched_taranium").fluid().color(0x374C52).buildAndRegister();
        //  25248 Energetic Naquadria
        EnergeticNaquadria = Builder("energetic_naquadria").fluid().color(0x202020).buildAndRegister();
        //  25249 Light Hyper Fuel
        LightHyperFuel = Builder("light_hyper_fuel").fluid().color(0x8C148C).buildAndRegister();
        //  25250 Medium Hyper Fuel
        MediumHyperFuel = Builder("medium_hyper_fuel").fluid().color(0xDC0A0A).buildAndRegister();
        //  25251 Heavy Hyper Fuel
        HeavyHyperFuel = Builder("heavy_hyper_fuel").fluid().color(0x1E5064).buildAndRegister();
        //  25252 Crude Rare Earth Turbid Solution
        CrudeRareEarthTurbidSolution = Builder("crude_rare_earth_turbid_solution")
                .fluid()
                .color(0x9C5C6B)
                .iconSet(MaterialIconSet.DULL)
                .buildAndRegister();
        //  25253 Nitrated Rare Earth Turbid Solution
        NitratedRareEarthTurbidSolution = Builder("nitrated_rare_earth_turbid_solution")
                .fluid()
                .color(0x754550)
                .iconSet(MaterialIconSet.DULL)
                .buildAndRegister();
        //  25254 Rare Earth Hydroxides Solution
        RareEarthHydroxidesSolution = Builder("rare_earth_hydroxides_solution")
                .fluid()
                .color(0x434327)
                .flags(DISABLE_DECOMPOSITION)
                .components(RareEarth, 1, Oxygen, 1, Hydrogen, 1, Water, 1)
                .buildAndRegister();
        //  25255 Rare Earth Chlorides Slurry
        RareEarthChloridesSlurry = Builder("rare_earth_chlorides_slurry")
                .dust()
                .color(0x838367)
                .iconSet(MaterialIconSet.ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(RareEarth, 1, Chlorine, 1, Water, 1)
                .buildAndRegister();
        //  25256 Low-purity Rare Earth Chlorides Solution
        LowPurityRareEarthChloridesSolution = Builder("low_purity_rare_earth_chlorides_solution")
                .fluid()
                .color(0x838333)
                .iconSet(MaterialIconSet.DULL)
                .flags(DISABLE_DECOMPOSITION)
                .components(RareEarth, 1, Chlorine, 1, Water, 2)
                .buildAndRegister();
        //  25257 Roughly Purified Rare Earth Chlorides Solution
        RoughlyPurifiedRareEarthChloridesSolution = Builder(
                        "roughly_purified_rare_earth_chlorides_solution")
                .fluid()
                .color(0xA2A27F)
                .iconSet(MaterialIconSet.DULL)
                .flags(DISABLE_DECOMPOSITION)
                .components(LowPurityRareEarthChloridesSolution, 4, AquaRegia, 2)
                .buildAndRegister();
        //  25258 High Purity Rare Earth Chlorides Slurry
        HighPurityRareEarthChloridesSlurry = Builder("high_purity_rare_earth_chlorides_slurry")
                .dust()
                .color(0x838367)
                .iconSet(MaterialIconSet.ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(RareEarth, 1, Chlorine, 1, Water, 1)
                .buildAndRegister();
        //  25259 High Purity Rare Earth Chlorides Solution
        HighPurityRareEarthChloridesSolution = Builder("high_purity_rare_earth_chlorides_solution")
                .fluid()
                .color(0x838367)
                .flags(DISABLE_DECOMPOSITION)
                .components(RareEarth, 1, Chlorine, 1, Water, 1)
                .buildAndRegister();
        //  25260 Low Purity Rare Earth Chlorides Slag
        LowPurityRareEarthChloridesSlag = Builder("low_purity_rare_earth_chlorides_slag")
                .dust()
                .color(0x62624D)
                .iconSet(MaterialIconSet.DULL)
                .buildAndRegister();
        //  25261 La-Pr-Nd-Ce Oxides Solution
        LaPrNdCeOxidesSolution = Builder("la_pr_nd_ce_oxides_solution")
                .fluid()
                .color(0x9CE3DB)
                .flags(DECOMPOSITION_BY_CENTRIFUGING)
                .components(LanthanumOxide, 1, PraseodymiumOxide, 1, NeodymiumOxide, 1, CeriumOxide, 1)
                .buildAndRegister();
        //  25262 Sc-Eu-Gd-Sm Oxides Solution
        ScEuGdSmOxidesSolution = Builder("sc_eu_gd_sm_oxides_solution")
                .fluid()
                .color(0xFFFF99)
                .flags(DECOMPOSITION_BY_CENTRIFUGING)
                .components(ScandiumOxide, 1, EuropiumOxide, 1, GadoliniumOxide, 1, SamariumOxide, 1)
                .buildAndRegister();
        //  25263 Y-Tb-Dy-Ho Oxides Solution
        YTbDyHoOxidesSolution = Builder("y_tb_dy_ho_oxides_solution")
                .fluid()
                .color(0x99FF99)
                .flags(DECOMPOSITION_BY_CENTRIFUGING)
                .components(YttriumOxide, 1, TerbiumOxide, 1, DysprosiumOxide, 1, HolmiumOxide, 1)
                .buildAndRegister();
        //  25264 Er-Tm-Yb-Lu Oxides Solution
        ErTmYbLuOxidesSolution = Builder("er_tm_yb_lu_oxides_solution")
                .fluid()
                .color(0xFFB3FF)
                .flags(DECOMPOSITION_BY_CENTRIFUGING)
                .components(ErbiumOxide, 1, ThuliumOxide, 1, YtterbiumOxide, 1, LutetiumOxide, 1)
                .buildAndRegister();
        //  25265 Chlorinated Solvents
        ChlorinatedSolvents = Builder("chlorinated_solvents")
                .fluid()
                .color(0x40804c)
                .buildAndRegister()
                .setFormula("(CH4)2Cl5", true);
        //  25266 Superheated Steam
        SuperheatedSteam = Builder("superheated_steam")
                .fluid(FluidStorageKeys.GAS, new FluidBuilder().temperature(573))
                .color(0xC4C4C4, false)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 2, Oxygen, 1)
                .buildAndRegister();
        //  25267 Supercritical Steam
        SupercriticalSteam = Builder("supercritical_steam")
                .fluid(FluidStorageKeys.GAS, new FluidBuilder().temperature(873))
                .color(0xC4C4C4, false)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 2, Oxygen, 1)
                .buildAndRegister();
        // 25268 High-Temperature Exhaust Gas
        HighTemperatureExhaustGas = Builder("high_temperature_exhaust_gas")
                .fluid(FluidStorageKeys.GAS, new FluidBuilder().temperature(1123))
                .color(0xF0EAD6)
                .buildAndRegister();
        // 25269 Exhaust Gas
        ExhaustGas = Builder("exhaust_gas")
                .fluid(FluidStorageKeys.GAS, new FluidBuilder().temperature(298))
                .color(0xEDEADE)
                .buildAndRegister();
        //  25270 Nitrated Dragon Dust Solution
        NitratedDragonDustSolution = Builder("nitrated_dragon_dust_solution")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0xF553FF)
                .buildAndRegister();
        //  25271 Residual Draconium Solution
        ResidualDraconiumSolution =
                Builder("residual_draconium_solution").fluid().color(0x4321C5).buildAndRegister();
        //  25272 Draconium Slag Solution
        DraconiumSlagSolution = Builder("draconium_slag_solution")
                .fluid()
                .color(0x790D80)
                .iconSet(MaterialIconSet.DULL)
                .buildAndRegister()
                .setFormula("Dc?(H2O)", true);
        //  25273 Actinium Radium Hydroxide Solution
        ActiniumRadiumHydroxideSolution = Builder("actinium_radium_hydroxide_solution")
                .fluid()
                .color(Actinium.getMaterialRGB() + Radium.getMaterialRGB())
                .buildAndRegister();
        //  25274 Actinium Radium Nitrate Solution
        ActiniumRadiumNitrateSolution = Builder("actinium_radium_nitrate_solution")
                .fluid()
                .color(ActiniumRadiumHydroxideSolution.getMaterialRGB() + NitricAcid.getMaterialRGB())
                .buildAndRegister();
        //  25275 Heavy Fluorinated Draconium Solution
        HeavyFluorinatedDraconiumSolution =
                Builder("heavy_fluorinated_draconium_solution").fluid().color(0x8C117D).buildAndRegister();
        //  25276 Quasi-fissioning Plasma
        QuasifissioningPlasma = Builder("quasi_fissioning_plasma")
                .fluid(FluidStorageKeys.PLASMA, new FluidBuilder().temperature(230490))
                .color(0xB0A2C3)
                .buildAndRegister()
                .setFormula(ChatFormatting.OBFUSCATED + "aaa", false);
        //  Transcendent Mental
        TranscendentMental = Builder("transcendent_mental")
                .fluid()
                .ingot()
                .color(0x000000)
                .iconSet(EPMaterialIconSet.CUSTOM_TRANSCENDENT_MENTAL)
                .flags(GENERATE_NANITES)
                .buildAndRegister();
        //  Low Purity Naquadah Solution
        LowPurityNaquadahSolution = Builder("low_purity_naquadah_solution")
                .liquid(443)
                .color(0x593649)
                .iconSet(MaterialIconSet.DULL)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("(Nq2O3)?·(HNO3)3", true);
        //  Naquadah Hydroxides Solution
        NaquadahHydroxidesSolution = Builder("naquadah_hydroxides_solution")
                .liquid(552)
                .color(0x83586F)
                .iconSet(MaterialIconSet.DULL)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("NQ(OH)3?", true);
        //  Concentrate Enriched Naquadah Mixture
        ConcentrateEnrichedNaquadahMixture = Builder("concentrate_enriched_naquadah_mixture")
                .dust()
                .color(0x153819)
                .iconSet(MaterialIconSet.ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("Nq+Ke?", true);
        //  Impure Naquadah Mixture Solution
        ImpureNaquadahMixtureSolution = Builder("impure_naquadah_mixture_solution")
                .liquid()
                .color(0x1A2A1C)
                .iconSet(MaterialIconSet.DULL)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("*Nq*?", true);
        //  Pure Naquadah Mixture Solution
        PureNaquadriaMixtureSolution = Builder("pure_naquadria_mixture_solution")
                .liquid()
                .color(0x1A2A1C)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister()
                .setFormula("*Nq*?", true);

        //  Combustion Promoter
        CombustionPromoter = Builder("combustion_promoter")
                .liquid()
                .color(0x27B7B5)
                .iconSet(MaterialIconSet.DULL)
                .buildAndRegister();

        Indalloy140 = Builder("indalloy_140")
                .liquid()
                .ingot()
                .dust()
                .color(0x736D8A)
                .iconSet(MaterialIconSet.DULL)
                .components(Bismuth, 47, Lead, 25, Tin, 13, Cadmium, 10, Indium, 5)
                .flags(DISABLE_DECOMPOSITION)
                .buildAndRegister();
    }
}
