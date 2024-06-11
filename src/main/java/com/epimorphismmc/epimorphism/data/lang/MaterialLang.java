package com.epimorphismmc.epimorphism.data.lang;

import com.epimorphismmc.monomorphism.datagen.lang.MOLangProvider;

import static com.epimorphismmc.epimorphism.api.data.tag.EPTagPrefix.*;
import static com.epimorphismmc.epimorphism.common.data.EPMaterials.*;

public class MaterialLang {
    public static void init(MOLangProvider provider) {

        //  Element Materials
        provider.addMaterial(Draconium, "Draconium", "龙素");
        provider.addMaterial(AwakenedDraconium, "Awakened Draconium", "觉醒龙素");
        provider.addMaterial(ChaoticDraconium, "Chaotic Draconium", "混沌龙素");
        provider.addMaterial(Orichalcum, "Orichalcum", "山铜");
        provider.addMaterial(Vibranium, "Vibranium", "振金");
        provider.addMaterial(Adamantium, "Adamantium", "精金");
        provider.addMaterial(Taranium, "Taranium", "塔兰金属");
        provider.addMaterial(Plutonium244, "Plutonium-244", "钚-244");
        provider.addMaterial(MetastableOganesson, "Metastable Oganesson", "亚稳态气奥");
        provider.addMaterial(MetastableHassium, "Metastable Hassium", "亚稳态钅黑");
        provider.addMaterial(MetastableFlerovium, "Metastable Flerovium", "亚稳态钅夫");
        provider.addMaterial(CosmicNeutronium, "Cosmic Neutronium", "宇宙中子素");
        provider.addMaterial(DegenerateRhenium, "DegenerateRhenium", "简并态铼");
        provider.addMaterial(Infinity, "Infinity", "无尽");
        provider.addMaterial(Rhugnor, "Rhugnor", "鲁格诺");
        provider.addMaterial(Hypogen, "Hypogen", "海珀珍");
        provider.addMaterial(Californium252, "Californium-252", "锎-252");
        provider.addMaterial(AstralTitanium, "Astral Titanium", "星体钛");
        provider.addMaterial(CelestialTungsten, "Celestial Tungsten", "天体钨");
        provider.addMaterial(Ytterbium178, "Ytterbium-178", "镱-178");
        provider.addMaterial(Ichorium, "Ichorium", "灵宝");
        provider.addMaterial(IchorLiquid, "Ichor Liquid", "灵液");
        provider.addMaterial(CrystalMatrix, "Crystal Matrix", "水晶矩阵");
        provider.addMaterial(VoidMetal, "Void Metal", "虚空金属");
        provider.addMaterial(Mithril, "Mithril", "秘银");
        provider.addMaterial(Bismuth209, "Bismuth-209", "铋-209");
        provider.addMaterial(Lead209, "Lead-209", "铅-209");

        // First Degree Materials
        provider.addMaterial(GrapheneOxide, "Graphene Oxide", "氧化石墨烯");
        provider.addMaterial(Hydrazine, "Hydrazine", "肼");
        provider.addMaterial(BerylliumOxide, "Beryllium Oxide", "氧化铍");
        provider.addMaterial(HydrogenPeroxide, "Hydrogen Peroxide", "过氧化氢");
        provider.addMaterial(TungstenTrioxide, "Tungsten Trioxide", "三氧化钨");
        provider.addMaterial(HexagonalBoronNitride, "Hexagonal Boron Nitride", "六方氮化硼");
        provider.addMaterial(CubicBoronNitride, "Cubic Boron Nitride", "立方氮化硼");
        provider.addMaterial(BoricAcid, "Boric Acid", "硼酸");
        provider.addMaterial(BoronTrioxide, "Boron Trioxide", "三氧化二硼");
        provider.addMaterial(BoronTrifluoride, "Boron Trifluoride", "三氟化硼");
        provider.addMaterial(LithiumHydride, "Lithium Hydride", "氢化锂");
        provider.addMaterial(LithiumTetrafluoroborate, "Lithium Tetrafluoroborate", "四氟硼酸锂");
        provider.addMaterial(Diborane, "Diborane", "乙硼烷");
        provider.addMaterial(Borazine, "Borazine", "环氮硼烷");
        provider.addMaterial(BoronTrichloride, "Boron Trichloride", "三氯化硼");
        provider.addMaterial(Trichloroborazine, "Trichloroborazine", "三氯环硼氮烷");
        provider.addMaterial(AmorphousBoronNitride, "Amorphous Boron Nitride", "非晶氮化硼");
        provider.addMaterial(Heterodiamond, "Heterodiamond", "杂金刚石");
        provider.addMaterial(CubicHeterodiamond, "Cubic Heterodiamond", "立方杂金刚石");
        provider.addMaterial(CarbonNanotube, "Carbon Nanotube", "碳纳米管");
        provider.addMaterial(SilverTetrafluoroborate, "Silver Tetrafluoroborate", "四氟硼酸银");
        provider.addMaterial(TrimethyltinChloride, "Trimethyltin Chloride", "三甲基氯化锡");
        provider.addMaterial(SilverChloride, "Silver Chloride", "氯化银");
        provider.addMaterial(ChloroplatinicAcid, "Chloroplatinic Acid", "氯铂酸");
        provider.addMaterial(PotassiumTetrachloroplatinate, "Potassium Tetrachloroplatinate", "氯铂酸钾");
        provider.addMaterial(NickelTriphenylphosphite, "Nickel Triphenylphosphite", "四（亚磷酸三苯酯）镍");
        provider.addMaterial(NickelChloride, "Nickel Chloride", "氯化镍");
        provider.addMaterial(PhosphorusTrichloride, "Phosphorus Trichloride", "三氯化磷");
        provider.addMaterial(AmmoniumSulfate, "Ammonium Sulfate", "硫酸铵");
        provider.addMaterial(AmmoniumPersulfate, "Ammonium Persulfate", "过硫酸铵");
        provider.addMaterial(HydroxylamineDisulfate, "Hydroxylamine Disulfate", "硫酸羟胺");
        provider.addMaterial(Hydroxylamine, "Hydroxylamine", "羟胺");
        provider.addMaterial(AmmoniumNitrate, "Ammonium Nitrate", "硝酸铵");
        provider.addMaterial(ThalliumSulfate, "Thallium Sulfate", "硫酸铊");
        provider.addMaterial(ThalliumChloride, "Thallium Chloride", "氯化铊");
        provider.addMaterial(IodizedBrine, "Iodized Brine", "含碘盐水");
        provider.addMaterial(IodineBrineMixture, "Iodine Brine Mixture", "浓缩碘盐水混合物");
        provider.addMaterial(BrominatedBrine, "Brominated Brine", "含溴盐水");
        provider.addMaterial(IodineSlurry, "Iodine Slurry", "碘浆液");
        provider.addMaterial(SodiumIodate, "Sodium Iodate", "碘酸钠");
        provider.addMaterial(SodiumIodide, "Sodium Iodide", "碘化钠");
        provider.addMaterial(SodiumHypochlorite, "Sodium Hypochlorite", "次氯酸钠");
        provider.addMaterial(SodiumPeriodate, "Sodium Periodate", "高碘酸钠");
        provider.addMaterial(AcidicBrominatedBrine, "Acidic Brominated Brine", "酸化含溴盐水");
        provider.addMaterial(BromineSulfateSolution, "Bromine Sulfate Solution", "硫酸溴溶液");
        provider.addMaterial(
                OverheatedBromineSulfateSolution, "Overheated Bromine Sulfate Solution", "过热硫酸溴溶液");
        provider.addMaterial(WetBromine, "Wet Bromine", "含水溴烟气");
        provider.addMaterial(DebrominatedWater, "Debrominated Water", "脱溴水");
        provider.addMaterial(PalladiumChloride, "Palladium Chloride", "氯化钯");
        provider.addMaterial(PalladiumOnCarbon, "Palladium on Carbon", "钯碳催化剂");
        provider.addMaterial(PotassiumPermanganate, "Potassium Permanganate", "高锰酸钾");
        provider.addMaterial(PotassiumManganate, "Potassium Manganate", "锰酸钾");
        provider.addMaterial(TinChloride, "Tin Dichloride", "二氯化锡");
        provider.addMaterial(SilverOxide, "Silver Oxide", "氧化银");
        provider.addMaterial(SodiumFluoride, "Sodium Fluoride", "氟化钠");
        provider.addMaterial(
                ZnFeAlClCatalyst, "Zinc-Iron-Aluminum-Chlorine Combined Catalyst", "锌-铁-铝-氯联合催化剂");
        provider.addMaterial(SodiumNitrate, "Sodium Nitrate", "硝酸钠");
        provider.addMaterial(FluoroboricAcid, "Fluoroboric Acid", "氟硼酸");
        provider.addMaterial(
                BenzenediazoniumTetrafluoroborate, "Benzenediazonium Tetrafluoroborate", "四氟硼酸重氮苯");
        provider.addMaterial(GalliumTrichloride, "Gallium Trichloride", "三氯化镓");
        provider.addMaterial(AluminiumTrichloride, "Aluminium Trichloride", "三氯化铝");
        provider.addMaterial(AluminiumHydroxide, "Aluminium Hydroxide", "氢氧化铝");
        provider.addMaterial(Alumina, "Alumina", "三氧化二铝");
        provider.addMaterial(GalliumTrioxide, "Gallium Trioxide", "三氧化镓");
        provider.addMaterial(GalliumNitride, "Gallium Nitride", "氮化镓");
        provider.addMaterial(Fullerene, "Fullerene", "富勒烯");
        provider.addMaterial(GeodesicPolyarene, "Geodesic Polyarene", "拱形芳烃聚合物");
        provider.addMaterial(TiAlCatalyst, "Titanium-Aluminum Combined Catalyst", "钛-铝联合催化剂");
        provider.addMaterial(PotassiumBromide, "Potassium Bromide", "溴化钾");
        provider.addMaterial(BismuthVanadate, "Bismuth Vanadate", "钒酸铋");
        provider.addMaterial(BismuthVanadateSolution, "Bismuth Vanadate Solution", "钒酸铋溶液");
        provider.addMaterial(AmmoniumVanadate, "Ammonium Vanadate", "钒酸铵");
        provider.addMaterial(VanadiumSlag, "Vanadium Slag", "含钒炉渣");
        provider.addMaterial(BismuthNitrateSolution, "Bismuth Nitrate Solution", "硝酸铋溶液");
        provider.addMaterial(SodiumVanadate, "Sodium Vanadate", "钒酸钠");
        provider.addMaterial(VanadiumWasteSolution, "Vanadium Waste Solution", "钒废液");
        provider.addMaterial(SodiumBromide, "Sodium Bromide", "溴化钠");
        provider.addMaterial(WhitePhosphorus, "White Phosphorus", "白磷");
        provider.addMaterial(RedPhosphorus, "Red Phosphorus", "红磷");
        provider.addMaterial(VioletPhosphorus, "Violet Phosphorus", "紫磷");
        provider.addMaterial(BlackPhosphorus, "Black Phosphorus", "黑磷");
        provider.addMaterial(BluePhosphorus, "Blue Phosphorus", "蓝磷");
        provider.addMaterial(Wollastonite, "Wollastonite", "硅灰石");
        provider.addMaterial(Phosphorene, "Phosphorene", "磷烯");
        provider.addMaterial(PhosphorylChloride, "Phosphoryl Chloride", "磷酰氯");
        provider.addMaterial(Phosphine, "Phosphine", "磷化氢");
        provider.addMaterial(CopperChloride, "Copper Chloride", "氯化铜");
        provider.addMaterial(LithiumHydroxide, "Lithium Hydroxide", "氢氧化锂");
        provider.addMaterial(LithiumAmalgam, "Lithium Amalgam", "锂汞齐");
        provider.addMaterial(
                HexafluorideEnrichedNaquadahSolution,
                "Hexafluoride Enriched Naquadah Solution",
                "六氟化富集硅岩溶液");
        provider.addMaterial(
                XenonHexafluoroEnrichedNaquadate, "Xenon Hexafluoro-Enriched Naquadate", "六氟氙酸富集硅岩");
        provider.addMaterial(
                EnrichedNaquadahResidueSolution, "Enriched Naquadah Residue Solution", "富集硅岩残余物溶液");
        provider.addMaterial(XenoauricFluoroantimonicAcid, "Xenoauric Fluoroantimonic Acid", "氟锑酸二氙");
        provider.addMaterial(GoldChloride, "Gold Chloride", "氯化金");
        provider.addMaterial(BromineTrifluoride, "Bromine Trifluoride", "三氟化溴");
        provider.addMaterial(GoldTrifluoride, "Gold Trifluoride", "三氟化金");
        provider.addMaterial(NaquadriaCaesiumfluoride, "Naquadria Caesiumfluoride", "二氟超能硅岩酸铯");
        provider.addMaterial(
                AcidicNaquadriaCaesiumfluoride, "Acidic Naquadria Caesiumfluoride", "硫酸二氟超能硅岩酸铯");
        provider.addMaterial(NitrosoniumOctafluoroxenate, "Nitrosonium Octafluoroxenate", "八氟氙酸亚硝酰");
        provider.addMaterial(
                NaquadriaCaesiumXenonnonfluoride, "Naquadria Caesium Xenonnonfluoride", "九氟氙酸超能硅岩酸铯");
        provider.addMaterial(RadonNaquadriaOctafluoride, "Radon Naquadria Octafluoride", "八氟超能硅岩酸氡");
        provider.addMaterial(CaesiumXenontrioxideFluoride, "Caesium Xenontrioxide Fluoride", "二氟三氧氙酸铯");
        provider.addMaterial(RadonTrioxide, "Radon Trioxide", "三氧化氡");
        provider.addMaterial(CaesiumFluoride, "Caesium Fluoride", "氟化铯");
        provider.addMaterial(XenonTrioxide, "Xenon Trioxide", "三氧化氙");
        provider.addMaterial(
                HexafluorideNaquadriaSolution, "Hexafluoride Naquadria Solution", "六氟化超能硅岩溶液");
        provider.addMaterial(NaquadriaResidueSolution, "Naquadria Residue Solution", "超能硅岩残余物溶液");
        provider.addMaterial(RadonDifluoride, "Radon Difluoride", "二氟化氡");
        provider.addMaterial(HeavyAlkaliChlorideSolution, "Heavy Alkali Chloride Solution", "重碱氯化物溶液");
        provider.addMaterial(StannicChloride, "Tin Tetrachloride", "四氯化锡");
        provider.addMaterial(RubidiumChlorostannate, "Rubidium Chlorostannate", "六氯锡酸铷");
        provider.addMaterial(CaesiumChlorostannate, "Caesium Chlorostannate", "六氯锡酸铯");
        provider.addMaterial(GermaniumDioxide, "Germanium Dioxide", "二氧化锗");
        provider.addMaterial(RoastedSphalerite, "Roasted Sphalerite", "焙烧闪锌矿");
        provider.addMaterial(ZincRichSphalerite, "Zinc rich Sphalerite", "富锌闪锌矿");
        provider.addMaterial(ZincOxide, "Zinc Oxide", "氧化锌");
        provider.addMaterial(WaelzOxide, "Waelz Oxide", "威氏氧化物");
        provider.addMaterial(WaelzSlag, "Waelz Slag", "威氏浸出渣");
        provider.addMaterial(ImpureGermaniumDioxide, "Impure Germanium Dioxide", "含杂氧化锗");
        provider.addMaterial(GermaniumTetrachloride, "Germanium Tetrachloride", "四氯化锗");
        provider.addMaterial(MolybdenumTrioxide, "Molybdenum Trioxide", "三氧化钼");
        provider.addMaterial(LeadChloride, "Lead Chloride", "氯化铅");
        provider.addMaterial(PerrhenicAcid, "Perrhenic Acid", "高铼酸");
        provider.addMaterial(AmmoniumPerrhenate, "Ammonium Perrhenate", "高铼酸铵");
        provider.addMaterial(NiobiumPentoxide, "Niobium Pentoxide", "五氧化二铌");
        provider.addMaterial(TantalumPentoxide, "Tantalum Pentoxide", "五氧化二钽");
        provider.addMaterial(CalciumDifluoride, "Calcium Difluoride", "二氟化钙");
        provider.addMaterial(ManganeseDifluoride, "Manganese Difluoride", "二氟化锰");
        provider.addMaterial(CalciumCarbide, "Calcium Carbide", "碳化钙");
        provider.addMaterial(SodiumTellurite, "Sodium Tellurite", "亚碲酸钠");
        provider.addMaterial(SeleniumDioxide, "Selenium Dioxide", "二氧化硒");
        provider.addMaterial(TelluriumDioxide, "Tellurium Dioxide", "二氧化碲");
        provider.addMaterial(SelenousAcid, "Selenous Acid", "亚硒酸");
        provider.addMaterial(GSTGlass, "GST Glass", "GST玻璃");
        provider.addMaterial(ZBLANGlass, "ZBLAN Glass", "ZBLAN玻璃");
        provider.addMaterial(ErbiumDopedZBLANGlass, "Erbium doped ZBLAN Glass", "掺铒的ZBLAN玻璃");
        provider.addMaterial(
                PraseodymiumDopedZBLANGlass, "Praseodymium doped ZBLAN Glass", "掺镨的ZBLAN玻璃");
        provider.addMaterial(SiliconTetrachloride, "Silicon Tetrachloride", "四氯化硅");
        provider.addMaterial(CadmiumSulfide, "Cadmium Sulfide", "硫化镉");
        provider.addMaterial(SiliconCarbide, "Silicon Carbide", "碳化硅");
        provider.addMaterial(ChromiumGermaniumTelluride, "Chromium Germanium Telluride", "碲化锗铬");
        provider.addMaterial(
                ChromiumGermaniumTellurideMagnetic, "Magnetic Chromium Germanium Telluride", "磁化碲化锗铬");
        provider.addMaterial(LithiumFluoride, "Lithium Fluoride", "氟化锂");
        provider.addMaterial(BariumCarbonate, "Barium Carbonate", "碳酸钡");
        provider.addMaterial(CarbonDisulfide, "Carbon Disulfide", "二硫化碳");
        provider.addMaterial(SodiumThiosulfate, "Sodium Thiosulfate", "硫代硫酸钠");
        provider.addMaterial(CadmiumSelenide, "Cadium Selenide", "硒化镉");
        provider.addMaterial(ThalliumCopperChloride, "Thallium Copper Chloride", "氯化铜铊");
        provider.addMaterial(PlutoniumTrihydride, "Plutonium Trihydride", "三氢化钚");
        provider.addMaterial(PlutoniumPhosphide, "Plutonium Phosphide", "亚磷酸钚");
        provider.addMaterial(NeptuniumAluminide, "Neptunium Aluminide", "铝化镎");
        provider.addMaterial(BismuthTrioxide, "Bismuth Trioxide", "三氧化二铋");
        provider.addMaterial(FerricOxide, "Ferric Oxide", "三氧化二铁");
        provider.addMaterial(BismuthFerrite, "Bismuth Ferrite", "铁酸铋");
        provider.addMaterial(BismuthChalcogenide, "Bismuth Chalcogenide", "铋-锑硫系化合物");
        provider.addMaterial(CubicZirconia, "Cubic Zirconia", "立方氧化锆");
        provider.addMaterial(BismuthTellurite, "Bismuth Tellurite", "亚碲酸铋");
        provider.addMaterial(Prasiolite, "Prasiolite", "堇云石");
        provider.addMaterial(MagnetoResonatic, "Magneto Resonatic", "共振紫晶");
        provider.addMaterial(YttriumTrioxide, "Yttrium Trioxide", "三氧化二钇");
        provider.addMaterial(HeavyTaraniumFuel, "Heavy Taranium Fuel", "重塔兰金属燃料");
        provider.addMaterial(MediumTaraniumFuel, "Medium Taranium Fuel", "塔兰金属燃料");
        provider.addMaterial(LightTaraniumFuel, "Light Taranium Fuel", "轻塔兰金属燃料");
        provider.addMaterial(HeavyEnrichedTaraniumFuel, "Heavy Enriched Taranium Fuel", "重富集塔兰金属燃料");
        provider.addMaterial(MediumEnrichedTaraniumFuel, "Medium Enriched Taranium Fuel", "富集塔兰金属燃料");
        provider.addMaterial(LightEnrichedTaraniumFuel, "Light Enriched Taranium Fuel", "轻塔兰金属燃料");
        provider.addMaterial(Adamantite, "Adamantite", "精金石");
        provider.addMaterial(AdamantiumUnstable, "Unstable Adamantium", "不稳定精金");
        provider.addMaterial(OrichalcumEnergized, "Energized Orichalcum", "充能山铜");
        provider.addMaterial(AdamantiumEnriched, "Enriched Adamantium", "富集精金");
        provider.addMaterial(DeepIron, "Deep Iron", "深铁");
        provider.addMaterial(VibraniumUnstable, "Unstable Vibranium", "不稳定振金");
        provider.addMaterial(LanthanumOxide, "Lanthanum Oxide", "氧化镧");
        provider.addMaterial(PraseodymiumOxide, "Praseodymium Oxide", "氧化镨");
        provider.addMaterial(NeodymiumOxide, "Neodymium Oxide", "氧化钕");
        provider.addMaterial(CeriumOxide, "Cerium Oxide", "氧化铈");
        provider.addMaterial(ScandiumOxide, "Scandium Oxide", "氧化钪");
        provider.addMaterial(EuropiumOxide, "Europium Oxide", "氧化铕");
        provider.addMaterial(GadoliniumOxide, "Gadolinium Oxide", "氧化钆");
        provider.addMaterial(SamariumOxide, "Samarium Oxide", "氧化钐");
        provider.addMaterial(YttriumOxide, "Yttrium Oxide", "氧化钇");
        provider.addMaterial(TerbiumOxide, "Terbium Oxide", "氧化铽");
        provider.addMaterial(DysprosiumOxide, "Dysprosium Oxide", "氧化镝");
        provider.addMaterial(HolmiumOxide, "Holmium Oxide", "氧化钬");
        provider.addMaterial(ErbiumOxide, "Erbium Oxide", "氧化铒");
        provider.addMaterial(ThuliumOxide, "Thulium Oxide", "氧化铥");
        provider.addMaterial(YtterbiumOxide, "Ytterbium Oxide", "氧化镱");
        provider.addMaterial(LutetiumOxide, "Lutetium Oxide", "氧化镥");
        provider.addMaterial(ManganeseSulfate, "Manganese Sulfate", "硫酸锰");
        provider.addMaterial(AmmoniumCyanate, "Ammonium Cyanate", "氰酸铵");
        provider.addMaterial(Carbamide, "Carbamide", "碳酰胺");
        provider.addMaterial(NeodymiumDopedYttriumOxide, "Neodymium Doped Yttrium Oxide", "钕掺杂的氧化钇");
        provider.addMaterial(AluminaSolution, "Alumina Solution", "三氧化二铝溶液");
        provider.addMaterial(CrudeAluminaSolution, "Crude Alumina Solution", "粗制三氧化二铝溶液");
        provider.addMaterial(CarbonTetrachloride, "Carbon Tetrachloride", "四氯化碳");
        provider.addMaterial(AluminiumNitrate, "Aluminium Nitrate", "硝酸铝");
        provider.addMaterial(UnprocessedNdYAGSolution, "Unprocessed NdYAGSolution", "未处理钕掺杂的钇铝榴石溶液");
        provider.addMaterial(NdYAG, "NdYAG", "钕掺杂的钇铝榴石");
        provider.addMaterial(AuPdCCatalyst, "Au-PdC Catalyst", "金-钯碳混合催化剂");
        provider.addMaterial(SodiumOxide, "Sodium Oxide", "氧化钠");
        provider.addMaterial(SodiumTungstate, "Sodium Tungstate", "钨酸钠");
        provider.addMaterial(SodiumPhosphotungstate, "Sodium Phosphotungstate", "磷钨酸钠");
        provider.addMaterial(SodiumMolybdate, "Sodium Molybdate", "钼酸钠");
        provider.addMaterial(SodiumPhosphomolybdate, "Sodium Phosphomolybdate", "磷钼酸钠");
        provider.addMaterial(SodiumAcetate, "Sodium Acetate", "乙酸钠");
        provider.addMaterial(NeutronStarCoreMaterial, "Neutron StarCore Material", "中子星内核物质");
        provider.addMaterial(
                MagnetoHydrodynamicallyConstrainedStarMatter,
                "Magneto Hydrodynamically Constrained Star Matter",
                "磁流体动力学约束恒星等离子体物质");
        provider.addMaterial(WhiteDwarfMatter, "White Dwarf Matter", "白矮星物质");
        provider.addMaterial(BlackDwarfMatter, "Black Dwarf Matter", "黑矮星物质");
        provider.addMaterial(RawStarMatter, "Raw Star Matter", "原始恒星等离子体物质");
        provider.addMaterial(
                DimensionallyTranscendentResidue, "Dimensionally Transcendent Residue", "超维度残余物");
        provider.addMaterial(HeavyLeptonMixture, "Heavy Lepton Mixture", "重轻子混合物");
        provider.addMaterial(HeavyQuarks, "Heavy Quarks", "重夸克");
        provider.addMaterial(Gluons, "Gluons", "胶子");
        provider.addMaterial(Instantons, "Instantons", "瞬子");
        provider.addMaterial(TemporalFluid, "Temporal Fluid", "富快子时间流体");
        provider.addMaterial(HiggsBosons, "Higgs Bosons", "希格斯玻色子");
        provider.addMaterial(CosmicComputingMixture, "Cosmic Computing Mixture", "宇宙信息混合物");
        provider.addMaterial(SilicaGel, "Silica Gel", "硅胶");
        provider.addMaterial(SilicaGelBase, "Silica Gel Base", "硅胶基质");
        provider.addMaterial(NitroniumTetrafluoroborate, "Nitronium Tetrafluoroborate", "四氟硝铵");
        provider.addMaterial(NitrosoniumTetrafluoroborate, "Nitrosonium Tetrafluoroborate", "四氟硼酸亚硝铵");
        provider.addMaterial(TetrafluoroboricAcid, "Tetrafluoroboric Acid", "四氟硼酸");
        provider.addMaterial(NitrogenMonoxide, "Nitrogen Monoxide", "一氧化氮");
        provider.addMaterial(HydroxylammoniumSulfate, "Hydroxylammonium Sulfate", "硫酸羟铵");
        provider.addMaterial(
                PotassiumHydroxylaminedisulfonate, "Potassium Hydroxylaminedisulfonate", "羟胺二磺酸钾");
        provider.addMaterial(PotassiumBisulfite, "Potassium Bisulfite", "亚硫酸氢钾");
        provider.addMaterial(NitrousAcid, "Nitrous Acid", "亚硝酸");
        provider.addMaterial(PotassiumNitrite, "Potassium Nitrite", "亚硝酸钾");
        provider.addMaterial(BariumDichloride, "Barium Dichloride", "三氯化钡");
        provider.addMaterial(HydroxylamineHydrochloride, "Hydroxylamine Hydrochloride", "盐酸羟胺");
        provider.addMaterial(BariumSulfateSuspension, "Barium Sulfate Suspension", "硫酸钡悬浊液");
        provider.addMaterial(AmmoniumAcetate, "Ammonium Acetate", "乙酸铵");
        provider.addMaterial(AmmoniumCarbonate, "Ammonium Carbonate", "碳酸铵");
        provider.addMaterial(FreeElectronGas, "Free Electron Gas", "自由电子气体");
        provider.addMaterial(QuarkGluonPlasma, "Quark Gluon Plasma", "夸克-胶子");
        provider.addMaterial(LightQuarks, "Light Quarks", "轻夸克");
        provider.addMaterial(FerricCatalyst, "Ferric Catalyst", "铁-过氧化氢混合催化剂");
        provider.addMaterial(Neutron, "Neutron", "中子");
        provider.addMaterial(HeliumNeon, "Helium Neon", "氦-氖混合气");
        provider.addMaterial(PoloniumNitrate, "Polonium Nitrate", "硝酸钋");
        provider.addMaterial(PoloniumChloride, "Polonium Chloride", "氯化亚钋");
        provider.addMaterial(Celestite, "Celestite", "天青石");
        provider.addMaterial(StrontiumCarbonate, "Strontium Carbonate", "碳酸锶");
        provider.addMaterial(StrontiumOxide, "Strontium Oxide", "氧化锶");
        provider.addMaterial(AcidicPyrochlore, "Acidic Pyrochlore", "酸浸烧绿石");
        provider.addMaterial(ThoriumUraniumSolution, "Thorium Uranium Solution", "钍铀杂质溶液");
        provider.addMaterial(LeachingPyrochlore, "Leaching Pyrochlore", "浸出烧绿石");
        provider.addMaterial(
                BariumStrontiumRadiumSolution, "Barium-Strontium-Radium Solution", "碱性钡-锶-镭溶液");
        provider.addMaterial(FluoroniobicAcid, "Fluoroniobic Acid", "氟铌酸");
        provider.addMaterial(PotassiumFluoride, "Potassium Fluoride", "氟化钾");
        provider.addMaterial(Oxypentafluoroniobate, "Oxypentafluoroniobate", "氧五氟铌酸盐");
        provider.addMaterial(Heptafluorotantalate, "Heptafluorotantalate", "七氟钽酸盐");
        provider.addMaterial(PotassiumFluoniobate, "Potassium Fluoniobate", "氟铌酸钾");
        provider.addMaterial(PotassiumFluotantalate, "Potassium Fluotantalate", "氟钽酸钾");
        provider.addMaterial(UraniumThoriumNitrate, "Uranium Thorium Nitrate", "硝酸铀酰-硝酸钍混合物");
        provider.addMaterial(
                UraniumOxideThoriumNitrate, "Uranium Oxide Thorium Nitrate", "二氧化铀-硝酸钍混合物");
        provider.addMaterial(ThoriumNitrateSolution, "Thorium Nitrate Solution", "硝酸钍溶液");
        provider.addMaterial(ThoriumOxide, "Thorium Oxide", "氧化钍");
        provider.addMaterial(GoldCopperMixture, "Gold-Copper Mixture", "铜-金混合物");
        provider.addMaterial(LeachingGold, "Leaching Gold", "金浸出物");
        provider.addMaterial(ChloroauricAcid, "Chloroauric Acid", "氯金酸");
        provider.addMaterial(LeachingCopper, "Leaching Copper", "铜浸出物");
        provider.addMaterial(PotassiumMetabisulfite, "Potassium Metabisulfite", "焦亚硫酸钾");
        provider.addMaterial(PlatinumMetal, "Platinum Metal", "铂金属");
        provider.addMaterial(PlatinumSlag, "Platinum Slag,", "铂残渣");
        provider.addMaterial(PalladiumMetal, "Palladium Metal", "钯金属");
        provider.addMaterial(ConcentratePlatinum, "Concentrate Platinum", "浓缩铂溶液");
        provider.addMaterial(CrudePlatinum, "Crude Platinum", "粗铂混合物");
        provider.addMaterial(PalladiumRichAmmonia, "Palladium Rich Ammonia", "富钯氨");
        provider.addMaterial(IridiumDioxide, "Iridium Dioxide", "二氧化铱");
        provider.addMaterial(AcidicIridiumSolution, "Acidic Iridium Solution", "酸性铱溶液");
        provider.addMaterial(OsmiumTetrachloride, "Osmium Tetrachloride", "四氯化锇");
        provider.addMaterial(RutheniumChloride, "Ruthenium Chloride", "三氯化钌");
        provider.addMaterial(SodiumPeroxide, "Sodium Peroxide", "过氧化钠");
        provider.addMaterial(RhodiumOxide, "Rhodium Oxide", "三氧化二铑");
        provider.addMaterial(PlatinumGroupSludgeSolution, "Platinum Group Sludge Solution", "铂族金属泥浆液");
        provider.addMaterial(
                AmmoniumHexachloroPlatinumGroupSludge,
                "Ammonium Hexachloro Platinum Group Sludge",
                "六氯铵酸化铂族金属泥浆液");
        provider.addMaterial(LeachingNickel, "Leaching Nickel", "镍浸出物");
        provider.addMaterial(GoldNickelMixture, "Gold Nickel Mixture", "镍金混合物");
        provider.addMaterial(LanthanumFullereneMixture, "Lanthanum Fullerene Mixture", "镧-富勒烯混合物");
        provider.addMaterial(LanthanumEmbeddedFullerene, "Lanthanum Embedded Fullerene", "镧-富勒烯包合物");
        provider.addMaterial(LanthanumFullereneNanotube, "Lanthanum Fullerene Nanotube", "镧-富勒烯纳米管");
        provider.addMaterial(HRAMagnesium, "HRA Magnesium", "高反应活化镁");
        provider.addMaterial(CadmiumBromide, "Cadmium Bromide", "溴化镉");
        provider.addMaterial(MagnesiumBromide, "Magnesium Bromide", "溴化镁");
        provider.addMaterial(OganessonBreedingBase, "Oganesson Breeding Base", "气奥增殖基");
        provider.addMaterial(HotOganesson, "Hot Oganesson", "热气奥");
        provider.addMaterial(DragonDust, "Dragon Dust", "龙尘");
        provider.addMaterial(CaliforniumNitrite, "Californium Nitrite", "亚硝酸锎");
        provider.addMaterial(CaliforniumDioxide, "Californium Dioxide", "二氧化锎");
        provider.addMaterial(CaliforniumHexachloride, "Californium Hexachloride", "六氯化锎");
        provider.addMaterial(CaliforniumHexafluoride, "Californium Hexafluoride", "六氟化锎");
        provider.addMaterial(Californium252Hexafluoride, "Californium-252 Hexafluoride", "六氟化锎-252");
        provider.addMaterial(
                SteamCrackedCalifornium252Hexafluoride,
                "Steam Cracked Californium-252 Hexafluoride",
                "蒸汽裂化六氟化锎-252");
        provider.addMaterial(Californium252Dioxide, "Californium-252 Dioxide", "二氧化锎-252");
        provider.addMaterial(ActiniumDraconiumHydroxides, "Actinium Draconium Hydroxides", "锕龙素氢氧化物");
        provider.addMaterial(ActiniumNitrate, "Actinium Nitrate", "硝酸锕");
        provider.addMaterial(RadiumNitrate, "Radium Nitrate", "硝酸镭");
        provider.addMaterial(CaesiumCarborane, "Caesium Carborane", "碳硼烷铯");
        provider.addMaterial(SilverNitrate, "Silver Nitrate", "硝酸银");
        provider.addMaterial(CaesiumNitrate, "Caesium Nitrate", "硝酸铯");
        provider.addMaterial(SilverIodide, "Silver Iodide", "碘化银");
        provider.addMaterial(CaesiumHydroxide, "Caesium Hydroxide", "氢氧化铯");
        provider.addMaterial(SodiumTetrafluoroborate, "Sodium Tetrafluoroborate", "四氟硼酸钠");
        provider.addMaterial(SodiumBorohydride, "Sodium Borohydride", "硼氢化钠");
        provider.addMaterial(SodiumEthoxide, "Sodium Ethoxide", "乙醇钠");
        provider.addMaterial(KryptonDifluoride, "Krypton Difluoride", "二氟化氪");
        provider.addMaterial(DraconiumTetrafluoride, "Draconium Tetrafluoride", "四氟化龙素");
        provider.addMaterial(ActiniumOxalate, "Actinium Oxalate", "草酸锕");
        provider.addMaterial(ActiniumHydride, "Actinium Hydride", "氢化锕");
        provider.addMaterial(ActiniumSuperhydride, "Actinium Superhydride", "超氢化锕");
        provider.addMaterial(FranciumCarbide, "Francium Carbide", "碳化钫");
        provider.addMaterial(BoronFranciumMixture, "Boron Francium Mixture", "硼钫混合物");
        provider.addMaterial(FleroviumYtterbiumPlasma, "Flerovium-Ytterbium Plasma", "钅夫-镱");
        provider.addMaterial(SolarGradeSilicon, "Solar Grade Silicon", "太阳能级硅");
        provider.addMaterial(DenseHydrazineMixtureFuel, "Dense Hydrazine Mixture Fuel", "混合浓缩肼火箭燃料");
        provider.addMaterial(HighlyPurifiedCoalTar, "Highly Purified Coal Tar", "高度提纯煤焦油");
        provider.addMaterial(RP1RocketFuel, "RP-1 RocketFuel", "RP-1火箭燃料");
        provider.addMaterial(Methylhydrazine, "Methylhydrazine", "甲肼");
        provider.addMaterial(
                MethylhydrazineNitrateRocketFuel, "Methylhydrazine Nitrate Rocket Fuel", "硝酸甲肼火箭燃料");
        provider.addMaterial(UDMHRocketFuel, "UDMH Rocket Fuel", "H8N4C2O4火箭燃料");
        provider.addMaterial(UDMH, "UDMH", "偏二甲肼");
        provider.addMaterial(LithiumNiobate, "Lithium Niobate", "铌酸锂");
        provider.addMaterial(NiobiumPentachloride, "Niobium Pentachloride", "五氯化铌");
        provider.addMaterial(HighPuritySodiumVanadate, "High Purity Sodium Vanadate", "高纯钒酸钠");
        provider.addMaterial(
                LutetiumThuliumYttriumChloridesSolution,
                "Lutetium Thulium Yttrium Chlorides Solution",
                "镥铥钇氯化物溶液");
        provider.addMaterial(
                YttriumVanadateLuTmDeposition, "Yttrium Vanadate Lu-Tm Deposition", "镥铥掺杂的钒酸钇沉淀");
        provider.addMaterial(YttriumVanadateLuTm, "Yttrium Vanadate Lu-Tm", "镥铥掺杂的钒酸钇");
        provider.addMaterial(HeavyQuarkEnrichedMixture, "Heavy Quark Enriched Mixture", "富集重夸克混合物");
        provider.addMaterial(DeuteriumSuperHeavyMixture, "Deuterium Super Heavy Mixture", "氘-超重元素混合物");
        provider.addMaterial(HeavyQuarkDegenerateMatter, "Heavy Quark Degenerate Matter", "重夸克简并物质");
        provider.addMaterial(FullerenePolymerMatrix, "Fullerene Polymer Matrix", "富勒烯聚合物基体");
        provider.addMaterial(RadiumRadonMixture, "Radium Radon Mixture", "镭-氡混合物");
        provider.addMaterial(ScandiumTitaniumMixture, "Scandium Titanium Mixture", "钪-钛混合物");
        provider.addMaterial(CaesiumIodide, "Caesium Iodide", "碘化铯");
        provider.addMaterial(TlTmDropedCaesiumIodide, "Tl-Tm Droped Caesium Iodide", "铊-铥掺杂的碘化铯");
        provider.addMaterial(CadmiumTungstate, "Cadmium Tungstate", "钨酸镉");
        provider.addMaterial(BismuthGermanate, "Bismuth Germanate", "锗酸铋");
        provider.addMaterial(IodineMonochloride, "Iodine Monochloride", "氯化碘");
        provider.addMaterial(MagnesiumChlorideBromide, "Magnesium Chloride Bromide", "溴氯化镁");
        provider.addMaterial(RhReNqCatalyst, "Rh-Re-Nq Catalyst", "铑-铼-硅岩混合催化剂");
        provider.addMaterial(LithiumTitanate, "Lithium Titanate", "钛酸锂");
        provider.addMaterial(TitaniumNitrate, "Titanium Nitrate", "硝酸钛");
        provider.addMaterial(NaquadahOxideMixture, "Naquadah Oxide Mixture", "氧化硅岩混合物");
        provider.addMaterial(ExtractiveNaquadahOxide, "Extractive Naquadah Oxide", "氧化硅岩浸出物");
        provider.addMaterial(LithiumCarbonate, "Lithium Carbonate", "碳酸锂");
        //        provider.addMaterial(AceticAnhydride, "Acetic Anhydride", "乙酸酐");
        //        provider.addMaterial(HydrogenCyanide, "Hydrogen Cyanide", "氰化氢");
        //        provider.addMaterial(SodiumCyanide, "Sodium Cyanide", "氰化钠");
        //        provider.addMaterial(SodiumPerchlorate, "Sodium Perchlorate", "高氯酸钠");

        // Second Degree Materials
        provider.addMaterial(DragonBreath, "Dragon Breath", "龙息");
        provider.addMaterial(ConcentrateDragonBreath, "Concentrate Dragon Breath", "浓缩龙息");
        provider.addMaterial(DragonBlood, "Dragon Blood", "龙血");
        provider.addMaterial(DragonTear, "Dragon Tear", "龙泪");

        // Organic Chemistry Materials
        provider.addMaterial(KaptonK, "Kapton-K", "聚酰亚胺-K");
        provider.addMaterial(KaptonE, "Kapton-E", "聚酰亚胺-E");
        provider.addMaterial(Edot, "3,4-Ethylenedioxythiophene (EDOT)", "3,4-乙撑二氧噻吩（EDOT）");
        provider.addMaterial(Polystyrene, "Polystyrene (PS)", "聚苯乙烯（PS）");
        provider.addMaterial(PolystyreneSulfonate, "Polystyrene Sulfonate (PSS)", "聚苯乙烯磺酸（PSS）");
        provider.addMaterial(PedotPSS, "PEDOT:PSS", "PEDOT:PSS");
        provider.addMaterial(PMMA, "Polymethylmethacrylate (PMMA)", "聚甲基丙烯酸甲酯（PMMA）");
        provider.addMaterial(PedotTMA, "PEDOT-TMA", "PEDOT-TMA");
        provider.addMaterial(
                TetramethylammoniumHydroxide, "Tetramethylammonium Hydroxide (TMAH)", "四甲基氢氧化铵（TMAH）");
        provider.addMaterial(PotassiumBromate, "Potassium Bromate", "溴酸钾");
        provider.addMaterial(MalonicAcid, "Malonic Acid", "丙二酸");
        provider.addMaterial(ChloroaceticAcid, "Chloroacetic Acid", "氯乙酸");
        provider.addMaterial(Trichloroethylene, "Trichloroethylene", "三氯乙烯");
        provider.addMaterial(HydrobromicAcid, "Hydrobromic Acid", "氢溴酸");
        provider.addMaterial(Butanediol, "Butanediol", "1,4-丁二醇");
        provider.addMaterial(Diacetyl, "Diacetyl", "丁二酮");
        provider.addMaterial(EthyleneGlycol, "Ethylene Glycol", "乙二醇");
        provider.addMaterial(SulfurDichloride, "Sulfur Dichloride", "二氯化硫");
        provider.addMaterial(AcetoneCyanohydrin, "Acetone Cyanohydrin", "丙酮氰醇");
        provider.addMaterial(ParaXylene, "Para Xylene", "对二甲苯");
        provider.addMaterial(Cycloparaphenylene, "Cycloparaphenylene (CPP)", "环对苯撑（CPP）");
        provider.addMaterial(
                Dichlorocyclooctadieneplatinium, "Dichlorocyclooctadieneplatinium", "（1,5-环辛二烯）二氯化铂");
        provider.addMaterial(Diiodobiphenyl, "Diiodobiphenyl", "二碘代联苯");
        provider.addMaterial(Bipyridine, "Bipyridine", "联吡啶");
        provider.addMaterial(
                PalladiumBisdibenzylidieneacetone, "Palladium Bisdibenzylidieneacetone", "双（二亚苄基二丙酮）钯");
        provider.addMaterial(Octene, "1-Octene", "1-辛烯");
        provider.addMaterial(Acetylene, "Acetylene", "乙炔");
        provider.addMaterial(Cyclooctadiene, "Cyclooctadiene", "环辛二烯");
        provider.addMaterial(Pyridine, "Pyridine", "吡啶");
        provider.addMaterial(Dibenzylideneacetone, "Dibenzylideneacetone", "二苄基丙酮");
        provider.addMaterial(Benzaldehyde, "Benzaldehyde", "苯甲醛");
        provider.addMaterial(BenzoylChloride, "Benzoyl Chloride", "苯甲酰氯");
        provider.addMaterial(ThionylChloride, "Thionyl Chloride", "氯化亚砜");
        provider.addMaterial(Polyetheretherketone, "Polyetheretherketone (PEEK)", "聚醚醚酮（PEEK）");
        provider.addMaterial(Difluorobenzophenone, "Difluorobenzophenone", "二氟二苯甲酮");
        provider.addMaterial(Hydroquinone, "Hydroquinone", "对苯二酚");
        provider.addMaterial(Resorcinol, "Resorcinol", "间苯二酚");
        provider.addMaterial(Fluorobenzene, "Fluorobenzene", "氟苯");
        provider.addMaterial(Fluorotoluene, "Fluorotoluene", "氟甲苯");
        provider.addMaterial(Kevlar, "Kevlar", "凯芙拉");
        provider.addMaterial(ParaPhenylenediamine, "Para Phenylenediamine", "对苯二胺");
        provider.addMaterial(TerephthaloylChloride, "Terephthaloyl Chloride", "对苯二甲酰氯");
        provider.addMaterial(NMethylPyrrolidone, "N-Methyl-2-Pyrrolidone", "N-甲基-2-吡咯烷酮");
        provider.addMaterial(Nitroaniline, "Nitroaniline", "4-硝基苯胺");
        provider.addMaterial(Durene, "Durene", "均四甲苯");
        provider.addMaterial(
                PyromelliticDianhydride, "Pyromellitic Dianhydride (PDMA)", "均苯四酸二酐（PDMA）");
        provider.addMaterial(Oxydianiline, "4,4'-Oxydianiline (ODA)", "4,4'-二氨基二苯醚（ODA）");
        provider.addMaterial(Dimethylformamide, "Dimethylformamide (DMF)", "二甲基甲酰胺（DMF）");
        provider.addMaterial(PhthalicAnhydride, "Phthalic Anhydride", "邻苯二甲酸酐");
        provider.addMaterial(
                BiphenylTetracarboxylicAcidDianhydride,
                "Biphenyl Tetracarboxylic Acid Dianhydride (BPDA)",
                "联苯四甲酸二酐（BPDA）");
        provider.addMaterial(
                Bistrichloromethylbenzene, "1,4-Bis(trichloromethyl)benzene", "1,4-双（三氯甲基）苯");
        provider.addMaterial(Tetrabromoethane, "Tetrabromoethane", "四溴乙烷");
        provider.addMaterial(TerephthalicAcid, "Terephthalic Acid (PTA)", "对苯二甲酸（PTA）");
        provider.addMaterial(GammaButyrolactone, "γ-Butyrolactone", "γ-丁内酯");
        provider.addMaterial(Methylamine, "Methylamine", "甲胺");
        provider.addMaterial(Trimethylaluminium, "Trimethylaluminium", "三甲基铝");
        provider.addMaterial(Trimethylgallium, "Trimethylgallium", "三甲基镓");
        provider.addMaterial(Benzophenanthrenylacetonitrile, "Benzophenanthrenylacetonitrile", "苯并菲乙腈");
        provider.addMaterial(Methylbenzophenanthrene, "Methylbenzophenanthrene", "甲基苯并菲");
        provider.addMaterial(BromoSuccinimide, "Bromo Succinimide", "N-溴代琥珀酰亚胺");
        provider.addMaterial(Succinimide, "Succinimide", "琥珀酰亚胺");
        provider.addMaterial(SuccinicAcid, "Succinic Acid", "琥珀酸");
        provider.addMaterial(MaleicAnhydride, "Maleic Anhydride", "顺丁烯二酸酐");
        provider.addMaterial(Naphthaldehyde, "Naphthaldehyde", "萘甲醛");
        provider.addMaterial(Butanol, "Butanol", "丁醇");
        provider.addMaterial(Bromobutane, "Bromobutane", "溴丁烷");
        provider.addMaterial(Cyanonaphthalene, "Cyanonaphthalene", "氰萘");
        provider.addMaterial(Triphenylphosphine, "Triphenylphosphine", "三苯基膦");
        provider.addMaterial(Ethylanthraquinone, "2-Ethylanthraquinone", "2-乙基蒽醌");
        provider.addMaterial(Ethylanthrahydroquinone, "2-Ethylanthrahydroquinone", "2-乙基蒽氢醌");
        provider.addMaterial(Ethylenediamine, "Ethylenediamine", "乙二胺");
        provider.addMaterial(
                TetrasodiumEDTA, "Ethylenediaminetetraacetic Acid Tetrasodium", "乙二胺四乙酸四钠");
        provider.addMaterial(
                EthylenediaminetetraaceticAcid, "Ethylenediaminetetraacetic Acid (EDTA)", "乙二胺四乙酸（EDTA）");
        provider.addMaterial(TetramethylammoniumChloride, "Tetramethylammonium Chloride", "四甲基氯化铵");
        provider.addMaterial(Trimethylamine, "Trimethylamine", "三甲胺");
        provider.addMaterial(Pyrocatechol, "Pyrocatechol", "邻苯二酚");
        provider.addMaterial(NitrylFluoride, "Nitryl Fluoride", "硝酰氟");
        provider.addMaterial(DimethylamineHydrochloride, "Dimethylamine Hydrochloride", "盐酸二甲胺");
        provider.addMaterial(PotassiumFormate, "Potassium Formate", "甲醇钾");
        provider.addMaterial(DiethylSuflide, "Diethyl Sulfide", "二乙硫醚");
        provider.addMaterial(Dimethylcadmium, "Dimethylcadmium", "二甲基镉");
        provider.addMaterial(
                BETSPerrhenate, "Bisethylenedithiotetraselenafulvalene Perrhenate", "高铼酸双（乙烯二硫代）四硒富瓦烯");
        provider.addMaterial(
                Bisethylenedithiotetraselenafulvalene,
                "Bisethylenedithiotetraselenafulvalene (BETS)",
                "双（乙烯二硫代）四硒富瓦烯（BETS）");
        provider.addMaterial(Lithiumthiinediselenide, "Lithiumthiinediselenide", "二硒醚合硫锂");
        provider.addMaterial(
                CyclopentadienylTitaniumTrichloride,
                "Cyclopentadienyl Titanium Trichloride (CTT)",
                "环戊二烯三氯化钛（CTT）");
        provider.addMaterial(Propadiene, "Propadiene", "丙二烯");
        provider.addMaterial(BariumTriflate, "Barium Triflate", "三氟甲基磺酸钡");
        provider.addMaterial(ScandiumTriflate, "Scandium Triflate", "三氟甲基磺酸钪");
        provider.addMaterial(BariumTriflateSolution, "Barium Triflate Solution", "三氟甲基磺酸钡溶液");
        provider.addMaterial(Biperfluoromethanedisulfide, "Biperfluoromethanedisulfide", "三氟甲基二硫醚");
        provider.addMaterial(ButylLithium, "Butyl Lithium", "丁基锂");
        provider.addMaterial(Bromodihydrothiine, "Bromodihydrothiine", "溴二氢硫醚");
        provider.addMaterial(Chloroethane, "Chloroethane", "氯乙烷");
        provider.addMaterial(Dibromoacrolein, "Dibromoacrolein", "二溴丙烯醛");
        provider.addMaterial(SodiumFormate, "Sodium Formate", "甲酸钠");
        provider.addMaterial(Ethylhexanol, "2-Ethylhexanol", "2-乙基己醇");
        provider.addMaterial(
                DiethylhexylPhosphoricAcid, "Di-(2-ethylhexyl)phosphoric Acid", "二-(2-乙基己基)磷酸");
        provider.addMaterial(Dichloromethane, "Dichloromethane", "二氯甲烷");
        provider.addMaterial(Tributylamine, "Tributylamine", "三丁胺");
        provider.addMaterial(Zylon, "Zylon", "柴隆纤维");
        provider.addMaterial(PreZylon, "Pre Zylon", "预处理柴隆纤维");
        provider.addMaterial(Terephthalaldehyde, "Terephthalaldehyde", "对苯二甲醛");
        provider.addMaterial(Dibromomethylbenzene, "Dibromomethylbenzene", "二溴甲苯");
        provider.addMaterial(Isochloropropane, "Isochloropropane", "氯丙烷");
        provider.addMaterial(Dinitrodipropanyloxybenzene, "Dinitrodipropanyloxybenzene", "二硝基二丙氧基苯");
        provider.addMaterial(
                Hexanitrohexaaxaisowurtzitane, "Hexanitrohexaaxaisowurtzitane", "六硝基六轴异伍兹烷");
        provider.addMaterial(
                CrudeHexanitrohexaaxaisowurtzitane, "CrudeHexanitrohexaaxaisowurtzitane", "粗制六硝基六轴异伍兹烷");
        provider.addMaterial(
                Tetraacetyldinitrosohexaazaisowurtzitane,
                "Tetraacetyldinitrosohexaazaisowurtzitane",
                "四乙酰二硝基六氮杂异戊二烯");
        provider.addMaterial(
                Dibenzyltetraacetylhexaazaisowurtzitane,
                "Dibenzyltetraacetylhexaazaisowurtzitane",
                "二苄基四乙酰六氮杂异纤锌烷");
        provider.addMaterial(SuccinimidylAcetate, "Succinimidyl Acetate", "琥珀酰亚胺醋酸酯");
        provider.addMaterial(NHydroxysuccinimide, "NHydroxysuccinimide", "N-羟基丁二酰亚胺");
        provider.addMaterial(Tetrahydrofuran, "Tetrahydrofuran", "四氢呋喃");
        provider.addMaterial(SuccinicAnhydride, "Succinic Anhydride", "琥珀酸酐");
        provider.addMaterial(
                Hexabenzylhexaazaisowurtzitane, "Hexabenzylhexaazaisowurtzitane", "六苄基六氮杂异伍兹烷");
        provider.addMaterial(Acetonitrile, "Acetonitrile", "乙腈");
        provider.addMaterial(Acetamide, "Acetamide", "乙酰胺");
        provider.addMaterial(Benzylamine, "Benzylamine", "苄胺");
        provider.addMaterial(BenzylChloride, "Benzyl Chloride", "氯化苄");
        provider.addMaterial(Hexamethylenetetramine, "Hexamethylenetetramine", "六亚甲基四胺");
        provider.addMaterial(DimethylCarbonate, "Dimethyl Carbonate", "碳酸二甲酯");
        provider.addMaterial(DiphenylCarbonate, "Diphenyl Carbonate", "碳酸二苯酯");
        provider.addMaterial(BPAPolycarbonate, "BPA Polycarbonate", "双酚A聚碳酸酯");
        provider.addMaterial(IsobutyricAcid, "Isobutyric Acid", "异丁酸");
        provider.addMaterial(IsobutyricAnhydride, "Isobutyric Anhydride", "异丁酸酐");
        provider.addMaterial(Dimethylketene, "Dimethylketene", "二甲基乙烯酮");
        provider.addMaterial(
                Tetramethylcyclobutanediol, "Tetramethylcyclobutanediol", "2,2,4,4-四甲基-1,3-环丁二醇（CBDO）");
        provider.addMaterial(CBDOPolycarbonate, "CBDO Polycarbonate", "CBDO聚碳酸酯");
        provider.addMaterial(NitrileButadieneRubber, "Nitrile Butadiene Rubber", "丁腈橡胶");
        provider.addMaterial(
                PolyPhosphonitrileFluoroRubber, "Poly Phosphonitrile FluoroRubber", "聚膦腈氟橡胶");
        provider.addMaterial(Acrylonitrile, "Acrylonitrile", "丙烯腈");
        provider.addMaterial(
                PhosphonitrilicChlorideTrimer, "Phosphonitrilic Chloride Trimer", "六氯环三磷腈");
        provider.addMaterial(SodiumTrifluoroethanolate, "Sodium Trifluoroethanolate", "三氟乙醇钠");
        provider.addMaterial(OctafluoroPentanol, "Octafluoro Pentanol", "八氟戊醇");
        provider.addMaterial(TributylPhosphate, "Tributyl Phosphate", "磷酸三丁酯（TBP）");
        provider.addMaterial(MethylIsobutylKetone, "Methyl Isobutyl Ketone", "甲基异丁基酮（MIBK）");
        provider.addMaterial(TBPMIBKSolution, "TBP:MIBK Solution", "TBP:MIBK分离液");
        provider.addMaterial(MesitylOxide, "Mesityl Oxide", "异亚丙基丙酮");
        provider.addMaterial(
                ElectrolyteReflectorMixture, "Electrolyte Reflector Mixture", "电介质反射镜形成混合物");
        provider.addMaterial(EthyleneDibromide, "Ethylene Dibromide", "1,2-二溴乙烷");
        provider.addMaterial(GrignardReagent, "Grignard Reagent", "格氏试剂");
        provider.addMaterial(Fluorocarborane, "Fluorocarborane", "碳氟化合物");
        provider.addMaterial(Perfluorobenzene, "Perfluorobenzene", "全氟苯");
        provider.addMaterial(Trimethylsilane, "Trimethylsilane", "三甲基硅烷");
        provider.addMaterial(Trimethylchlorosilane, "Trimethylchlorosilane", "三甲基氯硅烷");
        provider.addMaterial(CaesiumCarboranePrecursor, "Caesium Carborane Precursor", "碳硼烷铯预固化剂");
        provider.addMaterial(BoraneDimethylsulfide, "Borane Dimethylsulfide", "硼烷二甲硫醚");
        provider.addMaterial(Decaborane, "Decaborane", "癸硼烷");
        provider.addMaterial(DiethylEther, "Diethyl Ether", "二乙醚");
        provider.addMaterial(BoronTrifluorideEtherate, "Boron Trifluoride Etherate", "三氟化硼乙醚");
        provider.addMaterial(DimethylSulfide, "Dimethyl Sulfide", "二甲硫醚");
        provider.addMaterial(OxalicAcid, "Oxalic Acid", "乙二酸");
        provider.addMaterial(Glucose, "Glucose", "葡萄糖");
        provider.addMaterial(Fructose, "Fructose", "果糖");
        provider.addMaterial(Hexafluoropropylene, "Hexafluoropropylene", "六氟丙烯");
        provider.addMaterial(
                FluorinatedEthylenePropylene, "Fluorinated Ethylene Propylene", "聚全氟乙丙烯（FEP）");
        provider.addMaterial(PolycyclicAromaticMixture, "Polycyclic Aromatic Mixture", "多环芳香烃混合物");
        provider.addMaterial(Anthracene, "Anthracene", "蒽");
        provider.addMaterial(Dihydroiodotetracene, "Dihydroiodotetracene", "二氢碘化四联苯");
        provider.addMaterial(Dimethylnaphthalene, "Dimethylnaphthalene", "二甲基萘");
        provider.addMaterial(AcetylatingReagent, "Acetylating Reagent", "乙酰化试剂");
        provider.addMaterial(Dichlorodicyanobenzoquinone, "Dichlorodicyanobenzoquinone", "二氯二氰苯醌");
        provider.addMaterial(Dichlorodicyanohydroquinone, "Dichlorodicyanohydroquinone", "二氯二氰氢醌");
        provider.addMaterial(IsopropylAlcohol, "Isopropyl Alcohol", "异丙醇");
        provider.addMaterial(Tetracene, "Tetracene", "并四苯");

        // Unknown Composition Materials
        provider.addMaterial(BZMedium, "Belousov-Zhabotinsky Medium", "别洛索夫-扎鲍京斯基振荡反应液");
        provider.addMaterial(EDP, "Ethylenediamine Pyrocatechol (EDP)", "乙二胺邻苯二酚（EDP）");
        provider.addMaterial(RichNitrogenMixture, "Rich Nitrogen Mixture", "富氮混合物");
        provider.addMaterial(RichAmmoniaMixture, "Rich Ammonia Mixture", "富氨混合物");
        provider.addMaterial(BlazingPyrotheum, "Blazing Pyrotheum", "烈焰之炽焱");
        provider.addMaterial(GelidCryotheum, "Gelid Cryotheum", "极寒之凛冰");
        provider.addMaterial(CoACABCatalyst, "Co/Ac-AB Mixed Catalyst", "钴/乙炔-聚苯并咪唑混合催化剂");
        provider.addMaterial(PhosphoreneSolution, "Phosphorene Solution", "磷烯剥离溶液");
        provider.addMaterial(MethylamineMixture, "Methylamine Mixture", "甲基胺混合物");
        provider.addMaterial(MolybdenumFlue, "Molybdenum Flue", "钼烟气");
        provider.addMaterial(TraceRheniumFlue, "Trace Rhenium Flue", "微量钼烟气");
        provider.addMaterial(ChalcogenAnodeMud, "Chalcogen Anode Mud", "硫系元素阳极泥");
        provider.addMaterial(PreciousMetal, "Precious Metal", "贵金属");
        provider.addMaterial(IridiumPlatinumMetalDust, "Iridium-Platinum Slag", "铱铂金属残渣");
        provider.addMaterial(RarestMetalResidue, "Rarest Metal Residue", "稀有金属残余物");
        provider.addMaterial(CrudeNaquadahFuel, "Crude Naquadah Fuel", "粗制硅岩燃料");
        provider.addMaterial(HeavyNaquadahFuel, "Heavy Naquadah Fuel", "重硅岩燃料");
        provider.addMaterial(MediumNaquadahFuel, "Medium Naquadah Fuel", "硅岩燃料");
        provider.addMaterial(LightNaquadahFuel, "Light Naquadah Fuel", "轻硅岩燃料");
        provider.addMaterial(NaquadahGas, "Naquadah Gas", "硅岩气");
        provider.addMaterial(FracturingFluid, "Fracturing Fluid", "压裂液");
        provider.addMaterial(Bedrock, "Bedrock", "基岩");
        provider.addMaterial(BedrockSmoke, "Bedrock Smoke", "未处理基岩烟");
        provider.addMaterial(BedrockSootSolution, "Bedrock Soot Solution", "基岩烟灰溶液");
        provider.addMaterial(CleanBedrockSolution, "Clean Bedrock Solution", "洁净基岩烟灰溶液");
        provider.addMaterial(HeavyBedrockSmoke, "Heavy Bedrock Smoke", "重基岩烟");
        provider.addMaterial(MediumBedrockSmoke, "Medium Bedrock Smoke", "基岩烟");
        provider.addMaterial(LightBedrockSmoke, "Light Bedrock Smoke", "轻基岩烟");
        provider.addMaterial(UltralightBedrockSmoke, "Ultralight Bedrock Smoke", "超轻基岩烟");
        provider.addMaterial(HeavyTaraniumGas, "Heavy Taranium Gas", "重塔兰金属气");
        provider.addMaterial(MediumTaraniumGas, "Medium Taranium Gas", "塔兰金属气");
        provider.addMaterial(LightTaraniumGas, "Light Taranium Gas", "轻塔兰金属气");
        provider.addMaterial(BedrockGas, "Bedrock Gas", "基岩气");
        provider.addMaterial(CrackedHeavyTaranium, "Fluorine-Cracked Heavy Taranium Gas", "氟裂化重塔兰金属气");
        provider.addMaterial(CrackedMediumTaranium, "Fluorine-Crackd Medium Taranium Gas", "氟裂化塔兰金属气");
        provider.addMaterial(CrackedLightTaranium, "Fluorine-Crackd Light Taranium Gas", "氟裂化轻塔兰金属气");
        provider.addMaterial(EnrichedBedrockSootSolution, "Enriched Bedrock Soot Solution", "富集基岩烟灰溶液");
        provider.addMaterial(
                CleanEnrichedBedrockSolution, "Clean Enriched Bedrock Soot Solution", "洁净富集基岩烟灰溶液");
        provider.addMaterial(HeavyEnrichedBedrockSmoke, "Heavy Enriched Bedrock Smoke", "重富集基岩烟");
        provider.addMaterial(MediumEnrichedBedrockSmoke, "Medium Enriched Bedrock Smoke", "富集基岩烟");
        provider.addMaterial(LightEnrichedBedrockSmoke, "Light Enriched Bedrock Smoke", "轻富集基岩烟");
        provider.addMaterial(HeavyEnrichedTaraniumGas, "Heavy Enriched Taranium Gas", "重富集塔兰金属气");
        provider.addMaterial(MediumEnrichedTaraniumGas, "Medium Enriched Taranium Gas", "富集塔兰金属气");
        provider.addMaterial(LightEnrichedTaraniumGas, "Light Enriched Taranium Gas", "轻富集塔兰金属气");
        provider.addMaterial(
                CrackedHeavyEnrichedTaranium, "Radon-Cracked Heavy Enriched Taranium Gas", "氡裂化重富集塔兰金属气");
        provider.addMaterial(
                CrackedMediumEnrichedTaranium, "Radon-Cracked Medium Enriched Taranium Gas", "氡裂化富集塔兰金属气");
        provider.addMaterial(
                CrackedLightEnrichedTaranium, "Radon-Cracked Light Enriched Taranium Gas", "氡裂化轻富集塔兰金属气");
        provider.addMaterial(EnergeticNaquadria, "Energetic Naquadria", "充能超能硅岩");
        provider.addMaterial(LightHyperFuel, "Light Hyper Fuel", "轻超能燃料");
        provider.addMaterial(MediumHyperFuel, "Hyper Fuel", "超能燃料");
        provider.addMaterial(HeavyHyperFuel, "Heavy Hyper Fuel", "重超能燃料");
        provider.addMaterial(
                CrudeRareEarthTurbidSolution, "Crude Rare earth Turbid Solution", "粗制稀土浊溶液");
        provider.addMaterial(
                NitratedRareEarthTurbidSolution, "Nitrated Rare earth Turbid Solution", "硝化稀土浊溶液");
        provider.addMaterial(RareEarthHydroxidesSolution, "Rare earth Hydroxides Solution", "稀土氢氧化物溶液");
        provider.addMaterial(RareEarthChloridesSlurry, "Rare earth Chlorides Slurry", "稀土氯化物泥浆");
        provider.addMaterial(
                LowPurityRareEarthChloridesSolution,
                "Low purity Rare earth Chlorides Solution",
                "低纯度稀土氯化物溶液");
        provider.addMaterial(
                RoughlyPurifiedRareEarthChloridesSolution,
                "Roughly purified Rare earth Chlorides Solution",
                "粗提纯稀土氯化物溶液");
        provider.addMaterial(
                HighPurityRareEarthChloridesSlurry,
                "High purity Rare earth Chlorides Slurry",
                "高纯度稀土氯化物泥浆");
        provider.addMaterial(
                HighPurityRareEarthChloridesSolution,
                "High purity Rare earth Chlorides Solution",
                "高纯度稀土氯化物溶液");
        provider.addMaterial(
                LowPurityRareEarthChloridesSlag, "Low purity Rare earth Chlorides Slag", "低纯度稀土氯化物残渣");
        provider.addMaterial(LaPrNdCeOxidesSolution, "La-Pr-Nd-Ce Oxides Solution", "镧-镨-钕-铈氧化物溶液");
        provider.addMaterial(ScEuGdSmOxidesSolution, "Sc-Eu-Gd-Sm Oxides Solution", "钪-铕-钆-钐氧化物溶液");
        provider.addMaterial(YTbDyHoOxidesSolution, "Y-Tb-Dy-Ho Oxides Solution", "钇-铽-镝-钬氧化物溶液");
        provider.addMaterial(ErTmYbLuOxidesSolution, "Er-Tm-Yb-Lu Oxides Solution", "铒-铥-镱-镥氧化物溶液");
        provider.addMaterial(ChlorinatedSolvents, "Chlorinated Solvents", "有机氯溶液");
        provider.addMaterial(SuperheatedSteam, "Superheated Steam", "过热蒸汽");
        provider.addMaterial(SupercriticalSteam, "Supercritical Steam", "超临界蒸汽");
        provider.addMaterial(HighTemperatureExhaustGas, "High Temperature ExhaustGas", "高温废气");
        provider.addMaterial(ExhaustGas, "Exhaust Gas", "废气");
        provider.addMaterial(NitratedDragonDustSolution, "Nitrated Dragon Dust Solution", "硝化龙尘溶液");
        provider.addMaterial(ResidualDraconiumSolution, "Residual Draconium Solution", "龙素残余物溶液");
        provider.addMaterial(DraconiumSlagSolution, "Draconium Slag Solution", "龙素残渣溶液");
        provider.addMaterial(
                ActiniumRadiumHydroxideSolution, "Actinium Radium Hydroxide Solution", "氢氧化锕镭溶液");
        provider.addMaterial(
                ActiniumRadiumNitrateSolution, "Actinium Radium Nitrate Solution", "硝酸锕镭溶液");
        provider.addMaterial(
                HeavyFluorinatedDraconiumSolution, "Heavy Fluorinated Draconium Solution", "重氟龙素溶液");
        provider.addMaterial(QuasifissioningPlasma, "Quasifissioning Plasma", "拟裂变");
        provider.addMaterial(TranscendentMental, "Transcendent Mental", "超时空金属");
        provider.addMaterial(LowPurityNaquadahSolution, "Low-purity Naquadah Solution", "低纯度硅岩乳液");
        provider.addMaterial(NaquadahHydroxidesSolution, "Naquadah Hydroxides Solution", "硅岩氯化物溶液");
        provider.addMaterial(
                ConcentrateEnrichedNaquadahMixture, "Concentrate Enriched Naquadah Mixture", "浓缩富集硅岩混合物");
        provider.addMaterial(
                ImpureNaquadahMixtureSolution, "Impure Naquadah Mixture Solution", "含杂硅岩混合物溶液");
        provider.addMaterial(
                PureNaquadriaMixtureSolution, "Pure Naquadria Mixture Solution", "洁净超能硅岩混合物乳液");

        // Mod Compatibility Materials
        provider.addMaterial(Mana, "Mana", "魔力");
        provider.addMaterial(PrimalMana, "Primal Mana", "原始魔力");
        provider.addMaterial(Dawnstone, "Dawnstone", "黎明石");

        // Biological Production Line
        provider.addMaterial(DryRedAlgae, "Dry Red Algae", "干红藻");
        provider.addMaterial(RedAlgae, "Red Algae", "红藻");
        provider.addMaterial(DryGreenAlgae, "Dry Green Algae", "干绿藻");
        provider.addMaterial(GreenAlgae, "Green Algae", "绿藻");
        provider.addMaterial(DryGoldenAlgae, "Dry Golden Algae", "干金藻");
        provider.addMaterial(GoldenAlgae, "Golden Algae", "金藻");
        provider.addMaterial(DryBrownAlgae, "Dry Brown Algae", "干褐藻");
        provider.addMaterial(BrownAlgae, "Brown algae", "褐藻");

        // Machine Casing Materials
        provider.addMaterial(Inconel625, "Inconel-625", "镍基合金-625");
        provider.addMaterial(HastelloyN, "Hastelloy-N", "哈斯特洛依合金-N");
        provider.addMaterial(Stellite, "Stellite", "铬钴锰钛合金");
        provider.addMaterial(QuantumAlloy, "Quantum Alloy", "量子合金");
        provider.addMaterial(Grisium, "Grisium", "灰钛合金");
        provider.addMaterial(Hdcs, "High Durability Compound Steel", "高强度复合钢");
        provider.addMaterial(Abyssalloy, "Abyssal Alloy", "渊狱合金");
        provider.addMaterial(Lafium, "Lafium", "路菲恩");
        provider.addMaterial(BlackTitanium, "Black Titanium", "黑钛合金");
        provider.addMaterial(Talonite, "Talonite", "铬钴磷酸盐合金");
        provider.addMaterial(BlackPlutonium, "Black Plutonium", "黑钚");
        provider.addMaterial(MaragingSteel250, "", "马氏体时效钢250");
        provider.addMaterial(Staballoy, "Staballoy", "贫铀合金");
        provider.addMaterial(BabbittAlloy, "Babbitt Alloy", "巴氏合金");
        provider.addMaterial(ZirconiumCarbide, "Zirconium Carbide", "碳化锆");
        provider.addMaterial(Inconel792, "Inconel-792", "镍基合金-792");
        provider.addMaterial(IncoloyMA813, "Incoloy-MA813", "耐热铬铁合金-MA813");
        provider.addMaterial(HastelloyX78, "Hastelloy-X78", "哈斯特洛依合金-X78");
        provider.addMaterial(HastelloyK243, "Hastelloy-K243", "哈斯特洛依合金-K243");
        provider.addMaterial(MARM200Steel, "MAR-M200 Steel", "MAR-M200特种钢");
        provider.addMaterial(MARM200CeSteel, "MAR-Ce-M200 Steel", "MAR-Ce-M200特种钢");
        provider.addMaterial(TanmolyiumBetaC, "Tanmolyium-Beta-C", "钛钼合金β-C");
        provider.addMaterial(HastelloyC59, "Hastelloy-C59", "哈斯特洛依合金-C59");
        provider.addMaterial(HMS1J79Alloy, "HMS-1J79 Alloy", "高饱和磁感应软磁合金-1J79");
        provider.addMaterial(HY1301, "HY130-1", "高强度结构钢HY130-1");
        provider.addMaterial(
                AusteniticStainlessSteel904L, "Austenitic Stainless Steel-904L", "超级奥氏体不锈钢-904L");
        provider.addMaterial(EglinSteelBase, "EglinSteel Base", "埃格林钢粗胚");
        provider.addMaterial(EglinSteel, "Eglin Steel", "埃格林钢");
        provider.addMaterial(Pikyonium64B, "Pikyonium-64B", "皮卡优合金-64B");
        provider.addMaterial(Cinobite, "Cinobite", "西诺柏");
        provider.addMaterial(TitanSteel, "Titan Steel", "泰坦精钢");
        provider.addMaterial(IncoloyDS, "Incoloy-DS", "耐热铬铁合金-DS");
        provider.addMaterial(Inconel690, "Inconel-690", "镍基合金-690");
        provider.addMaterial(Tantalloy61, "Tantalloy-61", "钽钨合金-61");
        provider.addMaterial(Incoloy020, "Incoloy-020", "耐热铬铁合金-020");
        provider.addMaterial(HG1223, "HG-1223", "HG-1223");
        provider.addMaterial(HMS1J22Alloy, "HMS-1J22 Alloy", "高饱和磁感应软磁合金-1J22");
        provider.addMaterial(FullereneSuperconductor, "Fullerene Superconductor", "富勒烯超导体");
        provider.addMaterial(Legendarium, "Legendarium", "传奇金属");
        provider.addMaterial(SuperheavyHAlloy, "Superheavy-H Alloy", "超重元素-重合金");
        provider.addMaterial(SuperheavyLAlloy, "Superheavy-L Alloy", "超重元素-轻合金");
        provider.addMaterial(PlatinumGroupAlloy, "Platinum Group Alloy", "稀有金属合金");

        initGeneratedNames(provider);
    }

    private static void initGeneratedNames(MOLangProvider provider) {
        // TagPrefix
        provider.addTagPrefix(singularity, "%s Singularity", "%s奇点");
        provider.addTagPrefix(milled, "Milled %s", "研磨%s粉");
        provider.addTagPrefix(crucible, "%s Crucible", "%s坩埚");
        provider.addTagPrefix(seedCrystal, "%s Seed Crystal", "%s晶种");
        provider.addTagPrefix(nanites, "%s Nanites", "%s纳米蜂群");
        provider.addTagPrefix(laserEmitter, "%s Laser Emitter", "%s激光镭射器");
        provider.addTagPrefix(boule, "%s Boule", "人造%s");
        provider.addTagPrefix(fence, "%s Fence", "%s栅栏");
        provider.addTagPrefix(catalyst, "%s", "%s");
    }
}
