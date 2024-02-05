package cn.gtcommunity.epimorphism.data.lang;

import net.minecraftforge.common.data.LanguageProvider;

import static cn.gtcommunity.epimorphism.common.data.EPBlocks.*;
import static cn.gtcommunity.epimorphism.data.lang.EPLangHelper.*;

public class BlockLang {
    public static void init(LanguageProvider provider) {
        //  Glass
        addBlockWithTooltip(provider, SILICATE_GLASS, "Boron Silicate Glass", "硼硅酸盐玻璃",
                "§7Better than Reinforced Glass",
                "§7比钢化玻璃更好");
        addBlockWithTooltip(provider, TI_BORON_SILICATE_GLASS, "Titanium-reinforced Boron Silicate Glass", "钛强化硼硅酸盐玻璃",
                "§7Pink Crystal",
                "§7粉红水晶");
        addBlockWithTooltip(provider, W_BORON_SILICATE_GLASS, "Tungsten-reinforced Boron Silicate Glass", "钨强化硼硅酸盐玻璃",
                "§7High-strength Glass",
                "§7高强玻璃");
        addBlockWithTooltip(provider, OSMIR_BORON_SILICATE_GLASS, "Osmiridium-reinforced Boron Silicate Glass", "铱锇合金强化硼硅酸盐玻璃",
                "§7Industrial Star",
                "§7工业之星");
        addBlockWithTooltip(provider, NAQ_BORON_SILICATE_GLASS, "Naquadah-reinforced Boron Silicate Glass", "硅岩强化硼硅酸盐玻璃",
                "§7Impact Resistance",
                "§7无惧冲击");
        addBlockWithTooltip(provider, THY_BORON_SILICATE_GLASS, "Thorium-reinforced Boron Silicate Glass", "钍强化的硼硅酸盐玻璃",
               "§7Glossy and Green",
               "§7绿油油");
        addBlockWithTooltip(provider, INFINITY_GLASS, "Infinity Glass", "无尽玻璃",
               "§7Force field Constrained Glass",
               "§7力场约束玻璃");
        addBlockWithTooltip(provider, PMMA_GLASS, "PMMA Glass", "PMMA玻璃",
               "§7Acrylic Glassr",
               "§7亚克力玻璃");
        addBlockWithTooltip(provider, NEU_PMMA_GLASS, "Neutronium-reinforced PMMA Glass", "中子素强化PMMA玻璃",
               "§7AT Field",
               "§7心之壁");
        addBlockWithTooltip(provider, BPA_POLYCARBONATE_GLASS, "BPA Polycarbonate Glass", "BPA聚碳酸酯玻璃",
               "§7Gray Quartz",
               "§7灰色石英");
        addBlockWithTooltip(provider, CBDO_POLYCARBONATE_GLASS, "CBDO Polycarbonate Glass", "CBDO聚碳酸酯玻璃",
               "§7It is not the Windshield",
               "§7并不是挡风玻璃");

        add(provider, "epimorphism.glass_tier.desc",
                "§7Glass Tier: %s",
                "§7玻璃等级：%s");

        add(provider, "epimorphism.optical_glass_tier.desc.0",
                "Crude Optical Glass",
                "粗制光学玻璃");
        add(provider, "epimorphism.optical_glass_tier.desc.1",
                "Ordinary Optical Glass",
                "普通光学玻璃");
        add(provider, "epimorphism.optical_glass_tier.desc.2",
                "Modified Optical Glass",
                "改良光学玻璃");
        add(provider, "epimorphism.optical_glass_tier.desc.3",
                "High-quality Optical Glass",
                "优质光学玻璃");
        add(provider, "epimorphism.optical_glass_tier.desc.4",
                "Precision Optical Glass",
                "精密光学玻璃");
        add(provider, "epimorphism.optical_glass_tier.desc.5",
                "Marvellous Optical Glass",
                "精奇光学玻璃");

        //  Fluid Tank Cell Block
        addBlock(provider, FLUID_TANK_CELL_1, "Fluid Tank Cell Block T1", "流体单元方块 T1");
        addBlock(provider, FLUID_TANK_CELL_2, "Fluid Tank Cell Block T2", "流体单元方块 T2");
        addBlock(provider, FLUID_TANK_CELL_3, "Fluid Tank Cell Block T3", "流体单元方块 T3");
        addBlock(provider, FLUID_TANK_CELL_4, "Fluid Tank Cell Block T4", "流体单元方块 T4");
        addBlock(provider, FLUID_TANK_CELL_5, "Fluid Tank Cell Block T5", "流体单元方块 T5");
        addBlock(provider, FLUID_TANK_CELL_6, "Fluid Tank Cell Block T6", "流体单元方块 T6");
        addBlock(provider, FLUID_TANK_CELL_7, "Fluid Tank Cell Block T7", "流体单元方块 T7");
        addBlock(provider, FLUID_TANK_CELL_8, "Fluid Tank Cell Block T8", "流体单元方块 T8");
        addBlock(provider, FLUID_TANK_CELL_9, "Fluid Tank Cell Block T9", "流体单元方块 T9");
        addBlock(provider, FLUID_TANK_CELL_10, "Fluid Tank Cell Block T10", "流体单元方块 T10");

        //  Storage Field Blocks
        addBlock(provider, STORAGE_FIELD_BLOCK_1, "Storage Field Block T1", "存储立场方块 T1");
        addBlock(provider, STORAGE_FIELD_BLOCK_2, "Storage Field Block T2", "存储立场方块 T2");
        addBlock(provider, STORAGE_FIELD_BLOCK_3, "Storage Field Block T3", "存储立场方块 T3");
        addBlock(provider, STORAGE_FIELD_BLOCK_4, "Storage Field Block T4", "存储立场方块 T4");
        addBlock(provider, STORAGE_FIELD_BLOCK_5, "Storage Field Block T5", "存储立场方块 T5");
        addBlock(provider, STORAGE_FIELD_BLOCK_6, "Storage Field Block T6", "存储立场方块 T6");
        addBlock(provider, STORAGE_FIELD_BLOCK_7, "Storage Field Block T7", "存储立场方块 T7");
        addBlock(provider, STORAGE_FIELD_BLOCK_8, "Storage Field Block T8", "存储立场方块 T8");
        addBlock(provider, STORAGE_FIELD_BLOCK_9, "Storage Field Block T9", "存储立场方块 T9");
        addBlock(provider, STORAGE_FIELD_BLOCK_10, "Storage Field Block T10", "存储立场方块 T10");

        //  Component Assembly Line Casings
        addBlockWithTooltip(provider, COMPONENT_ASSEMBLY_LINE_CASING_LV, "Component Assembly Line Casing (§7LV§r)", "部件装配线外壳（§7LV§r）",
                "§7Simple Assembly Unit",
                "§7简易装配单元");
        addBlockWithTooltip(provider, COMPONENT_ASSEMBLY_LINE_CASING_MV, "Component Assembly Line Casing (§bMV§r)", "部件装配线外壳（§bMV§r）",
                "§7Crude Assembly Unit",
                "§7粗制装配单元");
        addBlockWithTooltip(provider, COMPONENT_ASSEMBLY_LINE_CASING_HV, "Component Assembly Line Casing (§6HV§r)", "部件装配线外壳（§6HV§r）",
                "§7Premium Assembly Unit",
                "§7优质装配单元");
        addBlockWithTooltip(provider, COMPONENT_ASSEMBLY_LINE_CASING_EV, "Component Assembly Line Casing (§5EV§r)", "部件装配线外壳（§5EV§r）",
                "§7Advanced Assembly Unit",
                "§7进阶装配单元");
        addBlockWithTooltip(provider, COMPONENT_ASSEMBLY_LINE_CASING_IV, "Component Assembly Line Casing (§1IV§r)", "部件装配线外壳（§1IV§r）",
                "§High-quality Assembly Unit",
                "§7高级装配单元");
        addBlockWithTooltip(provider, COMPONENT_ASSEMBLY_LINE_CASING_LuV, "Component Assembly Line Casing (§dLuV§r)", "部件装配线外壳（§dLuV§r）",
                "§7High-precision Assembly Unit",
                "§7高精度装配单元");
        addBlockWithTooltip(provider, COMPONENT_ASSEMBLY_LINE_CASING_ZPM, "Component Assembly Line Casing (§cZPM§r)", "部件装配线外壳（§cZPM§r）",
                "§7Ultra-high precision Assembly Unit",
                "§7超高精度装配单元");
        addBlockWithTooltip(provider, COMPONENT_ASSEMBLY_LINE_CASING_UV, "Component Assembly Line Casing (§3UV§r)", "部件装配线外壳（§3UV§r）",
                "§7Extreme precision Assembly Unit",
                "§7极限精度装配单元");
        addBlockWithTooltip(provider, COMPONENT_ASSEMBLY_LINE_CASING_UHV, "Component Assembly Line Casing (§4UHV§r)", "部件装配线外壳（§4UHV§r）",
                "§7Extremely High-precision Assembly Unit",
                "§7极高精度装配单元");
        addBlockWithTooltip(provider, COMPONENT_ASSEMBLY_LINE_CASING_UEV, "Component Assembly Line Casing (§aUEV§r)", "部件装配线外壳（§aUEV§r）",
                "§7Structural Assembly Unit",
                "§7结构装配单元");
        addBlockWithTooltip(provider, COMPONENT_ASSEMBLY_LINE_CASING_UIV, "Component Assembly Line Casing (§2UIV)", "部件装配线外壳（§2UIV）",
                "§7Large-scale Structural Assembly Unit",
                "§7大尺度结构装配单元");
        addBlockWithTooltip(provider, COMPONENT_ASSEMBLY_LINE_CASING_UXV, "Component Assembly Line Casing (§eUXV§r)", "部件装配线外壳（§eUXV§r）",
                "§7Superstructural Assembly Unit",
                "§7超结构装配单元");
        addBlockWithTooltip(provider, COMPONENT_ASSEMBLY_LINE_CASING_OpV, "Component Assembly Line Casing (§9OpV§r)", "部件装配线外壳（§9OpV§r）",
                "§7Cosmic Assembly Unit",
                "§7宇宙装配单元");
        addBlockWithTooltip(provider, COMPONENT_ASSEMBLY_LINE_CASING_MAX, "Component Assembly Line Casing (§c§lMAX§r)", "部件装配线外壳（§c§lMAX§r）",
                "§7Space-time Assembly Unit",
                "§7时空装配单元");

        addBlock(provider, FERTILIZED_DIRT,"Fertilized Dirt","肥沃土");
        addBlock(provider, FERTILIZED_FARMLAND,"Fertilized Farmland","肥沃耕地");

        addBlock(provider, HYPER_CASING,"Hyper Casing","超级机械方块");
        addBlock(provider, IRIDIUM_CASING,"Iridium Casing","铱机械方块");
        addBlock(provider, BREEDING_CASING,"Breeding Casing","养殖机械方块");
        addBlock(provider, GENERAL_PROCESSING_CASING,"General Processing Casing","通用加工机械方块");
        addBlock(provider, MARAGING_STEEL_CASING,"Maraging Steel Casing","马氏体时效钢-250机械方块");
        addBlock(provider, ADVANCED_FILTER_CASING,"Advanced Filter Casing","高级过滤器机械方块");
        addBlock(provider, TFFT_CASING,"TFFT Casing","TFFT机械方块");
        addBlock(provider, PROCESS_MACHINE_CASING,"Process Machine Casing","处理器机械方块");
        addBlock(provider, YOTTA_FLUID_TANK_CASING,"Yotta Fluid Tank Casing","YOT流体储罐机械方块");
        addBlock(provider, CASING_POLYBENZIMIDAZOLE_PIPE,"Casing Polybenzimidazole Pipe","聚苯并咪唑管道方块");
        addBlock(provider, SPEEDING_PIPE,"Speeding Pipe","高速管道");
        addBlock(provider, SUBSTRATE_CASING,"Substrate Casing","基材机械方块");
        addBlock(provider, ADVANCED_SUBSTRATE_CASING,"Advanced Substrate Casing","高级基材机械方块");
        addBlock(provider, ADVANCED_INVAR_CASING,"Advanced Invar Casing","殷钢高级隔热机械方块");
        addBlock(provider, ADVANCED_ALUMINIUM_CASING,"Advanced Aluminium Casing","铝制高级防冻机械方块");
        addBlock(provider, ISA_MILL_CASING,"Isa Mill Casing","艾萨研磨机械方块");
        addBlock(provider, CASING_ISA_MILL_PIPE,"Casing Isa Mill Pipe","艾萨研磨管道方块");
        addBlock(provider, CASING_ISA_MILL_GEARBOX,"Casing Isa Mill Gearbox","艾萨研磨齿轮箱");
        addBlock(provider, FLOTATION_CASING,"Flotation Casing","浮选机械方块");
        addBlock(provider, FLOTATION_CELL,"Flotation Cell","浮选槽");
        addBlock(provider, VACUUM_CASING,"Vacuum Casing","真空机械方块");

    }
}
