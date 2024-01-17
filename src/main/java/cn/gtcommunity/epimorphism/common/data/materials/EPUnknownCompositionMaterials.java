package cn.gtcommunity.epimorphism.common.data.materials;

import cn.gtcommunity.epimorphism.api.chemical.material.info.EPMaterialIconSet;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.api.fluids.FluidBuilder;
import com.gregtechceu.gtceu.api.fluids.attribute.FluidAttributes;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import cn.gtcommunity.epimorphism.common.data.EPMaterials;
import net.minecraft.ChatFormatting;

public class EPUnknownCompositionMaterials {
    public static void register() {
        //  25201 BZMedium
        EPMaterials.BZMedium = new Material.Builder("bz_medium")
                .fluid()
                .color(10681653)
                .buildAndRegister();
        //  25202 EDP
        EPMaterials.EDP = new Material.Builder("edp")
                .fluid()
                .color(16514839)
                .buildAndRegister();
        //  25203 Rich Nitrogen Mixture
        EPMaterials.RichNitrogenMixture = new Material.Builder("rich_nitrogen_mixture")
                .gas()
                .color(0x6891D8)
                .buildAndRegister();
        //  25204 Rich Ammonia Mixture
        EPMaterials.RichAmmoniaMixture = new Material.Builder("rich_ammonia_mixture")
                .fluid()
                .color(0x708ACD)
                .buildAndRegister();
        //  25205 Blazing Pyrotheum
        EPMaterials.BlazingPyrotheum = new Material.Builder("blazing_pyrotheum")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(8000))
                .color(GTMaterials.Blaze.getMaterialRGB())
                .components(GTMaterials.Blaze, 2, GTMaterials.Redstone, 1, GTMaterials.Sulfur, 1)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  25206 Gelid Cryotheum
        EPMaterials.GelidCryotheum = new Material.Builder("gelid_cryotheum")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(8))
                .color(0x40B8FB)
                .components(GTMaterials.Ice, 2, GTMaterials.Electrotine, 1, GTMaterials.Water, 1)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .buildAndRegister();
        //  25207 Co/AC-AB Catalyst
        EPMaterials.CoACABCatalyst = new Material.Builder("co_ac_ab_catalyst")
                .dust()
                .color(0x6B4312)
                .iconSet(MaterialIconSet.METALLIC)
                .buildAndRegister();
        //  25208 PhosphoreneSolution
        EPMaterials.PhosphoreneSolution = new Material.Builder("phosphorene_solution")
                .fluid()
                .color(0x465966)
                .buildAndRegister();
        //  25209 Methylamine Mixture
        EPMaterials.MethylamineMixture = new Material.Builder("methylamine_mixture")
                .fluid()
                .color(0xAA4400)
                .buildAndRegister();
        //  25210 Molybdenum Flue
        EPMaterials.MolybdenumFlue = new Material.Builder("molybdenum_flue")
                .gas()
                .color(0x39194A)
                .buildAndRegister();
        //  25211 Trace Rhenium Flue
        EPMaterials.TraceRheniumFlue = new Material.Builder("trace_rhenium_flue")
                .gas()
                .color(0x96D6D5)
                .buildAndRegister();
        //  25212 Chalcogen Anode Mud
        EPMaterials.ChalcogenAnodeMud = new Material.Builder("chalcogen_anode_mud")
                .dust()
                .color(0x8A3324)
                .iconSet(MaterialIconSet.FINE)
                .buildAndRegister();
        //  25213 Precious Metal
        EPMaterials.PreciousMetal = new Material.Builder("precious_metal")
                .ore(1, 1, false)
                .ingot()
                .addOreByproducts(GTMaterials.Iron)
                .color(0xDAA520)
                .iconSet(MaterialIconSet.SHINY)
                .buildAndRegister()
                .setFormula("Au?", false);
        //  25214 Iridium Platinum Metal Dust
        EPMaterials.IridiumPlatinumMetalDust = new Material.Builder("iridium_platinum_metal_dust")
                .dust()
                .color(0x87CEFA)
                .iconSet(MaterialIconSet.ROUGH)
                .buildAndRegister()
                .setFormula("Ir2O4(SiO2)2Au3Pt?", true);
        //  25215 Rarest Metal Residue
        EPMaterials.RarestMetalResidue = new Material.Builder("rarest_metal_residue")
                .dust()
                .color(0xA0522D)
                .iconSet(MaterialIconSet.DULL)
                .buildAndRegister();
        //  25216 Crude Naquadah Fuel
        EPMaterials.CrudeNaquadahFuel = new Material.Builder("crude_naquadah_fuel")
                .fluid()
                .color(0x077F4E)
                .iconSet(MaterialIconSet.DULL)
                .buildAndRegister();
        //  25217 Heavy Naquadah Fuel
        EPMaterials.HeavyNaquadahFuel = new Material.Builder("heavy_naquadah_fuel")
                .fluid()
                .color(0x088C56)
                .buildAndRegister();
        //  25218 Medium Naquadah Fuel
        EPMaterials.MediumNaquadahFuel = new Material.Builder("medium_naquadah_fuel")
                .fluid()
                .color(0x09A566)
                .buildAndRegister();
        //  25219 Light Naquadah Fuel
        EPMaterials.LightNaquadahFuel = new Material.Builder("light_naquadah_fuel")
                .fluid()
                .color(0x0BBF75)
                .buildAndRegister();
        //  25220 Naquadah Gas
        EPMaterials.NaquadahGas = new Material.Builder("naquadah_gas")
                .gas()
                .color(0x0CD985)
//                .iconSet(GAS)
                .buildAndRegister();
        //  25221 Fracturing Fluid
        EPMaterials.FracturingFluid = new Material.Builder("fracturing_fluid")
                .fluid()
                .color(0x96D6D5)
                .buildAndRegister();
        //  25222 Bedrock
        EPMaterials.Bedrock = new Material.Builder("bedrock")
                .dust()
                .fluid()
                .color(0x404040)
                .iconSet(MaterialIconSet.ROUGH)
                .buildAndRegister();
        //  25223 Bedrock Smoke
        EPMaterials.BedrockSmoke = new Material.Builder("bedrock_smoke")
                .gas()
                .color(0x525252)
                .buildAndRegister();
        //  25224 Bedrock Soot Solution
        EPMaterials.BedrockSootSolution = new Material.Builder("bedrock_soot_solution")
                .fluid()
                .color(0x1E2430)
                .buildAndRegister();
        //  25225 Clean Bedrock Solution
        EPMaterials.CleanBedrockSolution = new Material.Builder("clean_bedrock_solution")
                .fluid()
                .color(0xA89F9E)
                .buildAndRegister();
        //  25226 Heavy Bedrock Smoke
        EPMaterials.HeavyBedrockSmoke = new Material.Builder("heavy_bedrock_smoke")
                .gas()
                .color(0x242222)
                .buildAndRegister();
        //  25227 Medium Bedrock Smoke
        EPMaterials.MediumBedrockSmoke = new Material.Builder("medium_bedrock_smoke")
                .gas()
                .color(0x2E2C2C)
                .buildAndRegister();
        //  25228 Light Bedrock Smoke
        EPMaterials.LightBedrockSmoke = new Material.Builder("light_bedrock_smoke")
                .gas()
                .color(0x363333)
                .buildAndRegister();
        //  25229 Ultralight Bedrock Smoke
        EPMaterials.UltralightBedrockSmoke = new Material.Builder("ultralight_bedrock_smoke")
                .gas()
                .color(0x403D3D)
                .buildAndRegister();
        //  25230 Heavy Taranium Gas
        EPMaterials.HeavyTaraniumGas = new Material.Builder("heavy_taranium_gas")
                .gas()
                .color(0x262626)
                .buildAndRegister();
        //  25231 Medium Taranium Gas
        EPMaterials.MediumTaraniumGas = new Material.Builder("medium_taranium_gas")
                .gas()
                .color(0x313131)
                .buildAndRegister();
        //  25232 Light Taranium Gas
        EPMaterials.LightTaraniumGas = new Material.Builder("light_taranium_gas")
                .gas()
                .color(0x404040)
                .buildAndRegister();
        //  25233 Bedrock Gas
        EPMaterials.BedrockGas = new Material.Builder("bedrock_gas")
                .gas()
                .color(0x575757)
                .buildAndRegister();
        //  25234 Cracked Heavy Taranium
        EPMaterials.CrackedHeavyTaranium = new Material.Builder("cracked_heavy_taranium")
                .fluid()
                .color(0x1F2B2E)
                .buildAndRegister();
        //  25235 Cracked Medium Taranium
        EPMaterials.CrackedMediumTaranium = new Material.Builder("cracked_medium_taranium")
                .fluid()
                .color(0x29393D)
                .buildAndRegister();
        //  25236 Cracked Light Taranium
        EPMaterials.CrackedLightTaranium = new Material.Builder("cracked_light_taranium")
                .fluid()
                .color(0x374C52)
                .buildAndRegister();
        //  25237 Enriched Bedrock Soot Solution
        EPMaterials.EnrichedBedrockSootSolution = new Material.Builder("enriched_bedrock_soot_solution")
                .fluid()
                .color(0x280C26)
                .buildAndRegister();
        //  25238 Clean Enriched Bedrock Solution
        EPMaterials.CleanEnrichedBedrockSolution = new Material.Builder("clean_enriched_bedrock_solution")
                .fluid()
                .color(0x828C8C)
                .buildAndRegister();
        //  25239 Heavy Enriched Bedrock Smoke
        EPMaterials.HeavyEnrichedBedrockSmoke = new Material.Builder("heavy_enriched_bedrock_smoke")
                .gas()
                .color(0x1A2222)
                .buildAndRegister();
        //  25240 Medium Enriched Bedrock Smoke
        EPMaterials.MediumEnrichedBedrockSmoke = new Material.Builder("medium_enriched_bedrock_smoke")
                .gas()
                .color(0x1E2C2C)
                .buildAndRegister();
        //  25241 Light Enriched Bedrock Smoke
        EPMaterials.LightEnrichedBedrockSmoke = new Material.Builder("light_enriched_bedrock_smoke")
                .gas()
                .color(0x163333)
                .buildAndRegister();
        //  25242 Heavy Enriched Taranium Gas
        EPMaterials.HeavyEnrichedTaraniumGas = new Material.Builder("heavy_enriched_taranium_gas")
                .gas()
                .color(0x1F2626)
                .buildAndRegister();
        //  25243 Medium Enriched Taranium Gas
        EPMaterials.MediumEnrichedTaraniumGas = new Material.Builder("medium_enriched_taranium_gas")
                .gas()
                .color(0x1F3131)
                .buildAndRegister();
        //  25244 Light Enriched Taranium Gas
        EPMaterials.LightEnrichedTaraniumGas = new Material.Builder("light_enriched_taranium_gas")
                .gas()
                .color(0x1F4040)
                .buildAndRegister();
        //  25245 Cracked Heavy Enriched Taranium
        EPMaterials.CrackedHeavyEnrichedTaranium = new Material.Builder("cracked_heavy_enriched_taranium")
                .fluid()
                .color(0x2E1F2E)
                .buildAndRegister();
        //  25246 Cracked Medium Enriched Taranium
        EPMaterials.CrackedMediumEnrichedTaranium = new Material.Builder("cracked_medium_enriched_taranium")
                .fluid()
                .color(0x29393D)
                .buildAndRegister();
        //  25247 Cracked Light Enriched Taranium
        EPMaterials.CrackedLightEnrichedTaranium = new Material.Builder("cracked_light_enriched_taranium")
                .fluid()
                .color(0x374C52)
                .buildAndRegister();
        //  25248 Energetic Naquadria
        EPMaterials.EnergeticNaquadria = new Material.Builder("energetic_naquadria")
                .fluid()
                .color(0x202020)
                .buildAndRegister();
        //  25249 Light Hyper Fuel
        EPMaterials.LightHyperFuel = new Material.Builder("light_hyper_fuel")
                .fluid()
                .color(0x8C148C)
                .buildAndRegister();
        //  25250 Medium Hyper Fuel
        EPMaterials.MediumHyperFuel = new Material.Builder("medium_hyper_fuel")
                .fluid()
                .color(0xDC0A0A)
                .buildAndRegister();
        //  25251 Heavy Hyper Fuel
        EPMaterials.HeavyHyperFuel = new Material.Builder("heavy_hyper_fuel")
                .fluid()
                .color(0x1E5064)
                .buildAndRegister();
        //  25252 Crude Rare Earth Turbid Solution
        EPMaterials.CrudeRareEarthTurbidSolution = new Material.Builder("crude_rare_earth_turbid_solution")
                .fluid()
                .color(0x9C5C6B)
                .iconSet(MaterialIconSet.DULL)
                .buildAndRegister();
        //  25253 Nitrated Rare Earth Turbid Solution
        EPMaterials.NitratedRareEarthTurbidSolution = new Material.Builder("nitrated_rare_earth_turbid_solution")
                .fluid()
                .color(0x754550)
                .iconSet(MaterialIconSet.DULL)
                .buildAndRegister();
        //  25254 Rare Earth Hydroxides Solution
        EPMaterials.RareEarthHydroxidesSolution = new Material.Builder("rare_earth_hydroxides_solution")
                .fluid()
                .color(0x434327)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.RareEarth, 1, GTMaterials.Oxygen, 1, GTMaterials.Hydrogen, 1, GTMaterials.Water, 1)
                .buildAndRegister();
        //  25255 Rare Earth Chlorides Slurry
        EPMaterials.RareEarthChloridesSlurry = new Material.Builder("rare_earth_chlorides_slurry")
                .dust()
                .color(0x838367)
                .iconSet(MaterialIconSet.ROUGH)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.RareEarth, 1, GTMaterials.Chlorine, 1, GTMaterials.Water, 1)
                .buildAndRegister();
        //  25256 Low-purity Rare Earth Chlorides Solution
        EPMaterials.LowPurityRareEarthChloridesSolution = new Material.Builder("low_purity_rare_earth_chlorides_solution")
                .fluid()
                .color(0x838333)
                .iconSet(MaterialIconSet.DULL)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.RareEarth, 1, GTMaterials.Chlorine, 1, GTMaterials.Water, 2)
                .buildAndRegister();
        //  25257 Roughly Purified Rare Earth Chlorides Solution
        EPMaterials.RoughlyPurifiedRareEarthChloridesSolution = new Material.Builder("roughly_purified_rare_earth_chlorides_solution")
                .fluid()
                .color(0xA2A27F)
                .iconSet(MaterialIconSet.DULL)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(EPMaterials.LowPurityRareEarthChloridesSolution, 4, GTMaterials.AquaRegia, 2)
                .buildAndRegister();
        //  25258 High Purity Rare Earth Chlorides Slurry
        EPMaterials.HighPurityRareEarthChloridesSlurry = new Material.Builder("high_purity_rare_earth_chlorides_slurry")
                .dust()
                .color(0x838367)
                .iconSet(MaterialIconSet.ROUGH)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.RareEarth, 1, GTMaterials.Chlorine, 1, GTMaterials.Water, 1)
                .buildAndRegister();
        //  25259 High Purity Rare Earth Chlorides Solution
        EPMaterials.HighPurityRareEarthChloridesSolution = new Material.Builder("high_purity_rare_earth_chlorides_solution")
                .fluid()
                .color(0x838367)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.RareEarth, 1, GTMaterials.Chlorine, 1, GTMaterials.Water, 1)
                .buildAndRegister();
        //  25260 Low Purity Rare Earth Chlorides Slag
        EPMaterials.LowPurityRareEarthChloridesSlag = new Material.Builder("low_purity_rare_earth_chlorides_slag")
                .dust()
                .color(0x62624D)
                .iconSet(MaterialIconSet.DULL)
                .buildAndRegister();
        //  25261 La-Pr-Nd-Ce Oxides Solution
        EPMaterials.LaPrNdCeOxidesSolution = new Material.Builder("la_pr_nd_ce_oxides_solution")
                .fluid()
                .color(0x9CE3DB)
                .flags(MaterialFlags.DECOMPOSITION_BY_CENTRIFUGING)
                .components(EPMaterials.LanthanumOxide, 1, EPMaterials.PraseodymiumOxide, 1, EPMaterials.NeodymiumOxide, 1, EPMaterials.CeriumOxide, 1)
                .buildAndRegister();
        //  25262 Sc-Eu-Gd-Sm Oxides Solution
        EPMaterials.ScEuGdSmOxidesSolution = new Material.Builder("sc_eu_gd_sm_oxides_solution")
                .fluid()
                .color(0xFFFF99)
                .flags(MaterialFlags.DECOMPOSITION_BY_CENTRIFUGING)
                .components(EPMaterials.ScandiumOxide, 1, EPMaterials.EuropiumOxide, 1, EPMaterials.GadoliniumOxide, 1, EPMaterials.SamariumOxide, 1)
                .buildAndRegister();
        //  25263 Y-Tb-Dy-Ho Oxides Solution
        EPMaterials.YTbDyHoOxidesSolution = new Material.Builder("y_tb_dy_ho_oxides_solution")
                .fluid()
                .color(0x99FF99)
                .flags(MaterialFlags.DECOMPOSITION_BY_CENTRIFUGING)
                .components(EPMaterials.YttriumOxide, 1, EPMaterials.TerbiumOxide, 1, EPMaterials.DysprosiumOxide, 1, EPMaterials.HolmiumOxide, 1)
                .buildAndRegister();
        //  25264 Er-Tm-Yb-Lu Oxides Solution
        EPMaterials.ErTmYbLuOxidesSolution = new Material.Builder("er_tm_yb_lu_oxides_solution")
                .fluid()
                .color(0xFFB3FF)
                .flags(MaterialFlags.DECOMPOSITION_BY_CENTRIFUGING)
                .components(EPMaterials.ErbiumOxide, 1, EPMaterials.ThuliumOxide, 1, EPMaterials.YtterbiumOxide, 1, EPMaterials.LutetiumOxide, 1)
                .buildAndRegister();
        //  25265 Chlorinated Solvents
        EPMaterials.ChlorinatedSolvents = new Material.Builder("chlorinated_solvents")
                .fluid()
                .color(0x40804c)
                .buildAndRegister()
                .setFormula("(CH4)2Cl5", true);
        //  25266 Superheated Steam
        EPMaterials.SuperheatedSteam = new Material.Builder("superheated_steam")
                .fluid(FluidStorageKeys.GAS, new FluidBuilder().temperature(573))
                .color(0xC4C4C4, false)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Hydrogen, 2, GTMaterials.Oxygen, 1)
                .buildAndRegister();
        //  25267 Supercritical Steam
        EPMaterials.SupercriticalSteam = new Material.Builder("supercritical_steam")
                .fluid(FluidStorageKeys.GAS, new FluidBuilder().temperature(873))
                .color(0xC4C4C4, false)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(GTMaterials.Hydrogen, 2, GTMaterials.Oxygen, 1)
                .buildAndRegister();
        // 25268 High-Temperature Exhaust Gas
        EPMaterials.HighTemperatureExhaustGas = new Material.Builder("high_temperature_exhaust_gas")
                .fluid(FluidStorageKeys.GAS, new FluidBuilder().temperature(1123))
                .color(0xF0EAD6)
                .buildAndRegister();
        // 25269 Exhaust Gas
        EPMaterials.ExhaustGas = new Material.Builder("exhaust_gas")
                .fluid(FluidStorageKeys.GAS, new FluidBuilder().temperature(298))
                .color(0xEDEADE)
                .buildAndRegister();
        //  25270 Nitrated Dragon Dust Solution
        EPMaterials.NitratedDragonDustSolution = new Material.Builder("nitrated_dragon_dust_solution")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0xF553FF)
                .buildAndRegister();
        //  25271 Residual Draconium Solution
        EPMaterials.ResidualDraconiumSolution = new Material.Builder("residual_draconium_solution")
                .fluid()
                .color(0x4321C5)
                .buildAndRegister();
        //  25272 Draconium Slag Solution
        EPMaterials.DraconiumSlagSolution = new Material.Builder("draconium_slag_solution")
                .fluid()
                .color(0x790D80)
                .iconSet(MaterialIconSet.DULL)
                .buildAndRegister()
                .setFormula("Dc?(H2O)", true);
        //  25273 Actinium Radium Hydroxide Solution
        EPMaterials.ActiniumRadiumHydroxideSolution = new Material.Builder("actinium_radium_hydroxide_solution")
                .fluid()
                .color(GTMaterials.Actinium.getMaterialRGB() + GTMaterials.Radium.getMaterialRGB())
                .buildAndRegister();
        //  25274 Actinium Radium Nitrate Solution
        EPMaterials.ActiniumRadiumNitrateSolution = new Material.Builder("actinium_radium_nitrate_solution")
                .fluid()
                .color(EPMaterials.ActiniumRadiumHydroxideSolution.getMaterialRGB() + GTMaterials.NitricAcid.getMaterialRGB())
                .buildAndRegister();
        //  25275 Heavy Fluorinated Draconium Solution
        EPMaterials.HeavyFluorinatedDraconiumSolution = new Material.Builder("heavy_fluorinated_draconium_solution")
                .fluid()
                .color(0x8C117D)
                .buildAndRegister();
        //  25276 Quasi-fissioning Plasma
        EPMaterials.QuasifissioningPlasma = new Material.Builder("quasi_fissioning_plasma")
                .fluid(FluidStorageKeys.PLASMA, new FluidBuilder().temperature(230490))
                .color(0xB0A2C3)
                .buildAndRegister()
                .setFormula(ChatFormatting.OBFUSCATED + "aaa", false);
        //  Transcendent Mental
        EPMaterials.TranscendentMental = new Material.Builder("transcendent_mental")
                .fluid()
                .ingot()
                .color(0x000000)
                .iconSet(EPMaterialIconSet.CUSTOM_TRANSCENDENT_MENTAL)
                .buildAndRegister();
    }
}
