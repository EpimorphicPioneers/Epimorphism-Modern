package com.epimorphismmc.epimorphism.data.lang;

import com.epimorphismmc.monomorphism.registry.registrate.providers.MOLangProvider;

import java.util.List;
import java.util.Locale;

import static com.epimorphismmc.epimorphism.common.data.EPBlocks.ADVANCED_ALUMINIUM_CASING;
import static com.epimorphismmc.epimorphism.common.data.EPBlocks.ADVANCED_FILTER_CASING;
import static com.epimorphismmc.epimorphism.common.data.EPBlocks.ADVANCED_HIGH_ENERGY_CASING;
import static com.epimorphismmc.epimorphism.common.data.EPBlocks.ADVANCED_INVAR_CASING;
import static com.epimorphismmc.epimorphism.common.data.EPBlocks.ADVANCED_SUBSTRATE_CASING;
import static com.epimorphismmc.epimorphism.common.data.EPBlocks.BPA_POLYCARBONATE_GLASS;
import static com.epimorphismmc.epimorphism.common.data.EPBlocks.BREEDING_CASING;
import static com.epimorphismmc.epimorphism.common.data.EPBlocks.CASING_ISA_MILL_GEARBOX;
import static com.epimorphismmc.epimorphism.common.data.EPBlocks.CASING_ISA_MILL_PIPE;
import static com.epimorphismmc.epimorphism.common.data.EPBlocks.CASING_POLYBENZIMIDAZOLE_PIPE;
import static com.epimorphismmc.epimorphism.common.data.EPBlocks.CBDO_POLYCARBONATE_GLASS;
import static com.epimorphismmc.epimorphism.common.data.EPBlocks.CONTAINMENT_FIELD_GENERATOR;
import static com.epimorphismmc.epimorphism.common.data.EPBlocks.DIMENSIONAL_BRIDGE_CASING;
import static com.epimorphismmc.epimorphism.common.data.EPBlocks.DIMENSIONAL_CASING;
import static com.epimorphismmc.epimorphism.common.data.EPBlocks.DIMENSIONAL_LINK_CASING;
import static com.epimorphismmc.epimorphism.common.data.EPBlocks.DRILL_HEAD;
import static com.epimorphismmc.epimorphism.common.data.EPBlocks.FLOTATION_CASING;
import static com.epimorphismmc.epimorphism.common.data.EPBlocks.FLOTATION_CELL;
import static com.epimorphismmc.epimorphism.common.data.EPBlocks.GENERAL_PROCESSING_CASING;
import static com.epimorphismmc.epimorphism.common.data.EPBlocks.HOLLOW_CASING;
import static com.epimorphismmc.epimorphism.common.data.EPBlocks.HYPERDIMENSIONAL_CASING;
import static com.epimorphismmc.epimorphism.common.data.EPBlocks.HYPER_CASING;
import static com.epimorphismmc.epimorphism.common.data.EPBlocks.INFINITY_GLASS;
import static com.epimorphismmc.epimorphism.common.data.EPBlocks.IRIDIUM_CASING;
import static com.epimorphismmc.epimorphism.common.data.EPBlocks.ISA_MILL_CASING;
import static com.epimorphismmc.epimorphism.common.data.EPBlocks.MARAGING_STEEL_CASING;
import static com.epimorphismmc.epimorphism.common.data.EPBlocks.NAQ_BORON_SILICATE_GLASS;
import static com.epimorphismmc.epimorphism.common.data.EPBlocks.NEUTRONIUM_MINING_CASING;
import static com.epimorphismmc.epimorphism.common.data.EPBlocks.NEU_PMMA_GLASS;
import static com.epimorphismmc.epimorphism.common.data.EPBlocks.OSMIR_BORON_SILICATE_GLASS;
import static com.epimorphismmc.epimorphism.common.data.EPBlocks.PINE_LEAVES;
import static com.epimorphismmc.epimorphism.common.data.EPBlocks.PINE_LOG;
import static com.epimorphismmc.epimorphism.common.data.EPBlocks.PINE_PLANK;
import static com.epimorphismmc.epimorphism.common.data.EPBlocks.PINE_SAPLING;
import static com.epimorphismmc.epimorphism.common.data.EPBlocks.PMMA_GLASS;
import static com.epimorphismmc.epimorphism.common.data.EPBlocks.PRECISE_ASSEMBLER_CASING_MK1;
import static com.epimorphismmc.epimorphism.common.data.EPBlocks.PRECISE_ASSEMBLER_CASING_MK2;
import static com.epimorphismmc.epimorphism.common.data.EPBlocks.PRECISE_ASSEMBLER_CASING_MK3;
import static com.epimorphismmc.epimorphism.common.data.EPBlocks.PROCESS_MACHINE_CASING;
import static com.epimorphismmc.epimorphism.common.data.EPBlocks.SILICATE_GLASS;
import static com.epimorphismmc.epimorphism.common.data.EPBlocks.SPACETIME_DISTORTION_CASING;
import static com.epimorphismmc.epimorphism.common.data.EPBlocks.SPEEDING_PIPE;
import static com.epimorphismmc.epimorphism.common.data.EPBlocks.SUBSTRATE_CASING;
import static com.epimorphismmc.epimorphism.common.data.EPBlocks.TFFT_CASING;
import static com.epimorphismmc.epimorphism.common.data.EPBlocks.THY_BORON_SILICATE_GLASS;
import static com.epimorphismmc.epimorphism.common.data.EPBlocks.TI_BORON_SILICATE_GLASS;
import static com.epimorphismmc.epimorphism.common.data.EPBlocks.ULTIMATE_CONTAINMENT_FIELD_GENERATOR;
import static com.epimorphismmc.epimorphism.common.data.EPBlocks.ULTIMATE_HIGH_ENERGY_CASING;
import static com.epimorphismmc.epimorphism.common.data.EPBlocks.VACUUM_CASING;
import static com.epimorphismmc.epimorphism.common.data.EPBlocks.W_BORON_SILICATE_GLASS;
import static com.epimorphismmc.epimorphism.common.data.EPBlocks.YOTTA_FLUID_TANK_CASING;
import static com.gregtechceu.gtceu.api.GTValues.EV;
import static com.gregtechceu.gtceu.api.GTValues.HV;
import static com.gregtechceu.gtceu.api.GTValues.IV;
import static com.gregtechceu.gtceu.api.GTValues.LV;
import static com.gregtechceu.gtceu.api.GTValues.LuV;
import static com.gregtechceu.gtceu.api.GTValues.MAX;
import static com.gregtechceu.gtceu.api.GTValues.MV;
import static com.gregtechceu.gtceu.api.GTValues.OpV;
import static com.gregtechceu.gtceu.api.GTValues.UEV;
import static com.gregtechceu.gtceu.api.GTValues.UHV;
import static com.gregtechceu.gtceu.api.GTValues.UIV;
import static com.gregtechceu.gtceu.api.GTValues.UV;
import static com.gregtechceu.gtceu.api.GTValues.UXV;
import static com.gregtechceu.gtceu.api.GTValues.VN;
import static com.gregtechceu.gtceu.api.GTValues.VNF;
import static com.gregtechceu.gtceu.api.GTValues.ZPM;
import static com.gregtechceu.gtceu.api.GTValues.tiersBetween;

public class BlockLang {
    public static void init(MOLangProvider provider) {
        //  Glass
        provider.addBlockWithTooltip(
                SILICATE_GLASS,
                "Boron Silicate Glass",
                "硼硅酸盐玻璃",
                "§7Better than Reinforced Glass",
                "§7比钢化玻璃更好");
        provider.addBlockWithTooltip(
                TI_BORON_SILICATE_GLASS,
                "Titanium-reinforced Boron Silicate Glass",
                "钛强化硼硅酸盐玻璃",
                "§7Pink Crystal",
                "§7粉红水晶");
        provider.addBlockWithTooltip(
                W_BORON_SILICATE_GLASS,
                "Tungsten-reinforced Boron Silicate Glass",
                "钨强化硼硅酸盐玻璃",
                "§7High-strength Glass",
                "§7高强玻璃");
        provider.addBlockWithTooltip(
                OSMIR_BORON_SILICATE_GLASS,
                "Osmiridium-reinforced Boron Silicate Glass",
                "铱锇合金强化硼硅酸盐玻璃",
                "§7Industrial Star",
                "§7工业之星");
        provider.addBlockWithTooltip(
                NAQ_BORON_SILICATE_GLASS,
                "Naquadah-reinforced Boron Silicate Glass",
                "硅岩强化硼硅酸盐玻璃",
                "§7Impact Resistance",
                "§7无惧冲击");
        provider.addBlockWithTooltip(
                THY_BORON_SILICATE_GLASS,
                "Thorium-reinforced Boron Silicate Glass",
                "钍强化的硼硅酸盐玻璃",
                "§7Glossy and Green",
                "§7绿油油");
        provider.addBlockWithTooltip(
                INFINITY_GLASS, "Infinity Glass", "无尽玻璃", "§7Force field Constrained Glass", "§7力场约束玻璃");
        provider.addBlockWithTooltip(PMMA_GLASS, "PMMA Glass", "PMMA玻璃", "§7Acrylic Glassr", "§7亚克力玻璃");
        provider.addBlockWithTooltip(
                NEU_PMMA_GLASS, "Neutronium-reinforced PMMA Glass", "中子素强化PMMA玻璃", "§7AT Field", "§7心之壁");
        provider.addBlockWithTooltip(
                BPA_POLYCARBONATE_GLASS, "BPA Polycarbonate Glass", "BPA聚碳酸酯玻璃", "§7Gray Quartz", "§7灰色石英");
        provider.addBlockWithTooltip(
                CBDO_POLYCARBONATE_GLASS,
                "CBDO Polycarbonate Glass",
                "CBDO聚碳酸酯玻璃",
                "§7It is not the Windshield",
                "§7并不是挡风玻璃");

        provider.add("epimorphism.glass_tier.desc", "§7Glass Tier: %s", "§7玻璃等级：%s");

        provider.addMultiLang(
                "epimorphism.optical_glass_tier.desc",
                List.of(
                        "Crude Optical Glass",
                        "Ordinary Optical Glass",
                        "Modified Optical Glass",
                        "High-quality Optical Glass",
                        "Precision Optical Glass",
                        "Marvellous Optical Glass"),
                List.of("粗制光学玻璃", "普通光学玻璃", "改良光学玻璃", "优质光学玻璃", "精密光学玻璃", "精奇光学玻璃"));

        //  Fluid Tank Cell Block
        provider.addTieredBlockName(
                "fluid_tank_cell_%s"::formatted,
                "Fluid Tank Cell Block T%s"::formatted,
                "流体单元方块 T%s"::formatted,
                tiersBetween(1, 10));

        //  Storage Field Blocks
        provider.addTieredBlockName(
                "storage_field_block_%s"::formatted,
                "Storage Field Block T%s"::formatted,
                "存储立场方块 T%s"::formatted,
                tiersBetween(1, 10));

        //  Component Assembly Line Casings
        provider.addTieredBlockWithTooltip(
                tier -> "component_assline_casing_%s".formatted(VN[tier].toLowerCase(Locale.ROOT)),
                tier -> "Component Assembly Line Casing (%s§r)".formatted(VNF[tier]),
                tier -> "部件装配线外壳（%s§r）".formatted(VNF[tier]),
                tier -> "§7%s Assembly Unit".formatted(getCATier(tier, true)),
                tier -> "§7%s装配单元".formatted(getCATier(tier, false)),
                tiersBetween(LV, MAX));

        provider.addBlockName(HYPER_CASING, "Hyper Casing", "超级机械方块");
        provider.addBlockName(IRIDIUM_CASING, "Iridium Casing", "铱机械方块");
        provider.addBlockName(BREEDING_CASING, "Breeding Casing", "养殖机械方块");
        provider.addBlockName(GENERAL_PROCESSING_CASING, "General Processing Casing", "通用加工机械方块");
        provider.addBlockName(MARAGING_STEEL_CASING, "Maraging Steel Casing", "马氏体时效钢-250机械方块");
        provider.addBlockName(NEUTRONIUM_MINING_CASING, "Neutronium Mining Casing", "中子素采矿机械方块");
        provider.addBlockName(PRECISE_ASSEMBLER_CASING_MK1, "Precise Assembler Casing Mk 1", "精密装配机械方块 Mk-I");
        provider.addBlockName(PRECISE_ASSEMBLER_CASING_MK2, "Precise Assembler Casing Mk 2", "精密装配机械方块 Mk-II");
        provider.addBlockName(PRECISE_ASSEMBLER_CASING_MK3, "Precise Assembler Casing Mk 3", "精密装配机械方块 Mk-III");
        provider.addBlockName(ADVANCED_FILTER_CASING, "Advanced Filter Casing", "高级过滤器机械方块");
        provider.addBlockName(TFFT_CASING, "TFFT Casing", "TFFT机械方块");
        provider.addBlockName(PROCESS_MACHINE_CASING, "Process Machine Casing", "处理器机械方块");
        provider.addBlockName(YOTTA_FLUID_TANK_CASING, "Yotta Fluid Tank Casing", "YOT流体储罐机械方块");
        provider.addBlockName(CASING_POLYBENZIMIDAZOLE_PIPE, "Casing Polybenzimidazole Pipe", "聚苯并咪唑管道方块");
        provider.addBlockName(SPEEDING_PIPE, "Speeding Pipe", "高速管道");
        provider.addBlockName(SUBSTRATE_CASING, "Substrate Casing", "基材机械方块");
        provider.addBlockName(ADVANCED_SUBSTRATE_CASING, "Advanced Substrate Casing", "高级基材机械方块");
        provider.addBlockName(ADVANCED_INVAR_CASING, "Advanced Invar Casing", "殷钢高级隔热机械方块");
        provider.addBlockName(ADVANCED_ALUMINIUM_CASING, "Advanced Aluminium Casing", "铝制高级防冻机械方块");
        provider.addBlockName(ISA_MILL_CASING, "Isa Mill Casing", "艾萨研磨机械方块");
        provider.addBlockName(CASING_ISA_MILL_PIPE, "Casing Isa Mill Pipe", "艾萨研磨管道方块");
        provider.addBlockName(CASING_ISA_MILL_GEARBOX, "Casing Isa Mill Gearbox", "艾萨研磨齿轮箱");
        provider.addBlockName(FLOTATION_CASING, "Flotation Casing", "浮选机械方块");
        provider.addBlockName(FLOTATION_CELL, "Flotation Cell", "浮选槽");
        provider.addBlockName(VACUUM_CASING, "Vacuum Casing", "真空机械方块");
        provider.addBlockName(DRILL_HEAD, "Drill Head", "钻头");
        provider.addBlockName(NAQUADAH_ALLOY_CASING, "Naquadah Alloy Casing", "硅岩合金机械方块");
        provider.addBlockName(NAQUADRIA_CASING, "Naquadria Casing", "超能硅岩机械方块");
        provider.addBlockName(FARM_CASING, "Farm Casing", "农场机械方块");
        provider.addBlockName(TRITANIUM_CASING, "Tritanium Casing", "三钛机械方块");
        provider.addBlockName(QUANTUM_CASING, "Quantum Casing", "量子机械方块");
        provider.addBlockName(AEROSPACE_CASING, "Aerospace Casing", "航空机械方块");
        provider.addBlockName(COIL_CASING, "Coil Casing", "线圈机械方块");
        provider.addBlockName(DISH_CASING, "Dish Casing", "Dish机械方块");
        provider.addBlockName(CONSTRAINT_CASING, "Constraint Casing", "立场约束机械方块");
        provider.addBlockName(RADIATION_PROOF_MACHINE_CASING, "Radiation Proof Machine Casing", "防辐射机械方块");
        provider.addBlockName(BABBITT_ALLOY_CASING, "Babbitt Alloy Casing", "巴氏合金机械方块");
        provider.addBlockName(ZIRCONIUM_CARBIDE_CASING, "Zirconium Carbide Casing", "碳化锆机械方块");
        provider.addBlockName(CASING_SUPERCRITICAL_FLUID_TURBINE, "Supercritical Fluid Turbine Casing", "超临界流体涡轮机械方块");
        provider.addBlockName(TURBO_ENGINE_CASING, "Turbo Engine Casing", "涡轮引擎机械方块");
        provider.addBlockName(CORROSION_CASING, "Corrosion Casing", "抗腐蚀机械方块");
        provider.addBlockName(HASTELLOYK243_CASING, "Hastelloy-k243 Casing", "哈斯特洛依合金-K243机械方块");
        provider.addBlockName(BASIC_PHOTOLITHOGRAPHIC_CASING, "Basic Photolithographic Casing", "基础光刻机械方块");
        provider.addBlockName(MOLD_PRINTING_ASSEMBLY_CASING, "Mold Printing Assembly Casing", "模具印刷组装机械方块");
        provider.addBlockName(RADIATION_PROOF_PHOTOLITHOGRAPHIC_CASING, "Radiation Proof Photolithographic Casing", "防辐射光刻机械方块");
        provider.addBlockName(HIGH_STRENGTH_FLOOR, "High Strength Floor", "高强度混凝土地板");
        provider.addBlockName(CASING_TURBO_ENGINE_GEARBOX, "Turbo Engine Gearbox Casing", "涡轮引擎齿轮箱");
        provider.addBlockName(CASING_SUPERCRITICAL_FLUID_GEARBOX, "Supercritical Fluid Gearbox Casing", "超临界流体涡轮齿轮箱");
        provider.addBlockName(RAW_CYLINDER, "Raw Cylinder", "粗制气缸");
        provider.addBlockName(TITANIUM_PLATED_CYLINDER, "Titanium Plated Cylinder", "镀钛气缸");
        provider.addBlockName(GD_CE_CERAMIC_ELECTROLYTE_UNIT, "Gd-Ce Ceramic Electrolyte Unit", "钆-铈陶瓷电解质装置");
        provider.addBlockName(Y_ZR_CERAMIC_ELECTROLYTE_UNIT, "Y-Zr Ceramic Electrolyte Unit", "钇-锆陶瓷电解质装置");
        provider.addBlockName(FUSION_CASING_MK4, "Fusion Casing Mk-4", "聚变机械方块 MK-IV");
        provider.addBlockName(FUSION_CASING_MK5, "Fusion Casing Mk-5", "聚变机械方块 MK-V");

        provider.addBlockWithTooltip(
                ADVANCED_HIGH_ENERGY_CASING,
                "Advanced High Energy Casing",
                "进阶高能机械方块",
                List.of(
                        "§7Used for Ultrahigh Energy Physics Experiment", "§b§lThis block can last forever."),
                List.of("§7用于超高能物理实验器件", "§b§l这个方块可以持久不衰。"));
        provider.addBlockWithTooltip(
                ULTIMATE_HIGH_ENERGY_CASING,
                "Ultimate High Energy Casing",
                "终极高能机械方块",
                List.of(
                        "§7Used for Ultrahigh Energy Physics Experiment in Extreme Situations",
                        "§b§lIt can survive at least one big bang of the universe, maybe even two..."),
                List.of("§7用于极端情况下的超高能物理实验", "§b§l至少能在一次宇宙大爆炸中幸存，也许是两次……"));
        provider.addBlockWithTooltip(
                DIMENSIONAL_BRIDGE_CASING,
                "Dimensional Bridge Casing",
                "维度桥接机械方块",
                List.of(
                        "§7Used to connect Time and Space from Different Dimensions",
                        "§b§lIt's best not to touch it with your hands."),
                List.of("§7用于连接不同维度的时间与空间", "§b§l最好别用手碰它。"));
        provider.addBlockWithTooltip(
                DIMENSIONAL_LINK_CASING,
                "Dimensional Link Casing",
                "维度联络机械方块",
                List.of("§7Multidimensional Operation", "§b§lThe universe or someplace else."),
                List.of("§7多维运算", "§b§l宇宙或别的地方。"));
        provider.addBlockWithTooltip(
                CONTAINMENT_FIELD_GENERATOR,
                "Containment Field Generator",
                "遏制场发生器",
                List.of("§7Generate a field...", "§b§lIt can even block high-energy particles."),
                List.of("§7产生一个场……", "§b§l甚至可以阻止高能粒子。"));
        provider.addBlockWithTooltip(
                ULTIMATE_CONTAINMENT_FIELD_GENERATOR,
                "Ultimate Containment Field Generator",
                "终极遏制场发生器",
                List.of("§7Black hole", "§b§lHmm..."),
                List.of("§7黑洞", "§b§l嗯……"));
        provider.addBlockWithTooltip(
                HOLLOW_CASING,
                "Hollow Structure Casing",
                "中空结构方块",
                List.of("§7Enhanced Accelerator Pipe", "§b§lThe most advanced pipeline ever."),
                List.of("§7强化加速器通道", "§b§l有史以来最先进的管道。"));
        provider.addBlockWithTooltip(
                SPACETIME_DISTORTION_CASING,
                "Spacetime Distortion Casing",
                "时空扭曲机械方块",
                List.of(
                        "§7Speed of Light no longer a Limit",
                        "§b§lCould potentially trigger temporal and spatial turbulence."),
                List.of("§7光速不再是限制", "§b§l可能引发时空乱流。"));
        provider.addBlockWithTooltip(
                DIMENSIONAL_CASING,
                "Dimensional Casing",
                "维度机械方块",
                List.of(
                        "§7Resist the spacetime shearing caused by the expansion of the universe",
                        "§b§lProvide a stable barrier between spacetime regions."),
                List.of("§7抵抗宇宙膨胀带来的时空剪切", "§b§l在时空区域之间提供一道稳定的屏障。"));
        provider.addBlockWithTooltip(
                HYPERDIMENSIONAL_CASING,
                "Hyperdimensional Casing",
                "超维度机械方块",
                List.of(
                        "§7Exists in all possible spacetime dimensions",
                        "§b§lMerely a projection in three-dimensional space..."),
                List.of("§7存在于所有可能时空", "§b§l仅仅是三维空间下的投影……"));

        provider.addBlockName(PINE_SAPLING, "Pine Sapling", "松树树苗");
        provider.addBlockName(PINE_LOG, "Pine Log", "松树原木");
        provider.addBlockName(PINE_LEAVES, "Pine Leaves", "松树树叶");
        provider.addBlockName(PINE_PLANK, "Pine Plank", "松树木板");
    }

    private static String getCATier(int tier, boolean isEN) {
        return switch (tier) {
            case LV -> isEN ? "Simple" : "简易";
            case MV -> isEN ? "Crude" : "粗制";
            case HV -> isEN ? "Premium" : "优质";
            case EV -> isEN ? "Advanced" : "进阶";
            case IV -> isEN ? "High-quality" : "高级";
            case LuV -> isEN ? "High-precision" : "高精度";
            case ZPM -> isEN ? "Ultra-high Precision" : "超高精度";
            case UV -> isEN ? "Extreme Precision" : "极限精度";
            case UHV -> isEN ? "Extremely High-precision" : "极高精度";
            case UEV -> isEN ? "Structural" : "结构";
            case UIV -> isEN ? "Large-scale Structural" : "大尺度结构";
            case UXV -> isEN ? "Superstructural" : "超结构";
            case OpV -> isEN ? "Cosmic" : "宇宙";
            default -> isEN ? "Space-time" : "时空";
        };
    }
}
