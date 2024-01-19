package cn.gtcommunity.epimorphism.data.lang;

import net.minecraftforge.common.data.LanguageProvider;

import static cn.gtcommunity.epimorphism.common.data.EPBlocks.*;
import static cn.gtcommunity.epimorphism.data.lang.EPLangHelper.*;

public class BlockLang {
    public static void init(LanguageProvider provider) {
        //  Glass
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
        addBlock(provider, FLUID_TANK_CELL_1, "Fluid Tank Cell Block T1", "流体单元方块T1");
        addBlock(provider, FLUID_TANK_CELL_2, "Fluid Tank Cell Block T2", "流体单元方块T2");
        addBlock(provider, FLUID_TANK_CELL_3, "Fluid Tank Cell Block T3", "流体单元方块T3");
        addBlock(provider, FLUID_TANK_CELL_4, "Fluid Tank Cell Block T4", "流体单元方块T4");
        addBlock(provider, FLUID_TANK_CELL_5, "Fluid Tank Cell Block T5", "流体单元方块T5");
        addBlock(provider, FLUID_TANK_CELL_6, "Fluid Tank Cell Block T6", "流体单元方块T6");
        addBlock(provider, FLUID_TANK_CELL_7, "Fluid Tank Cell Block T7", "流体单元方块T7");
        addBlock(provider, FLUID_TANK_CELL_8, "Fluid Tank Cell Block T8", "流体单元方块T8");
        addBlock(provider, FLUID_TANK_CELL_9, "Fluid Tank Cell Block T9", "流体单元方块T9");
        addBlock(provider, FLUID_TANK_CELL_10, "Fluid Tank Cell Block T10", "流体单元方块T10");

        //  Storage Field Blocks
        addBlock(provider, STORAGE_FIELD_BLOCK_1, "Storage Field Block T1", "存储立场方块T1");
        addBlock(provider, STORAGE_FIELD_BLOCK_2, "Storage Field Block T2", "存储立场方块T2");
        addBlock(provider, STORAGE_FIELD_BLOCK_3, "Storage Field Block T3", "存储立场方块T3");
        addBlock(provider, STORAGE_FIELD_BLOCK_4, "Storage Field Block T4", "存储立场方块T4");
        addBlock(provider, STORAGE_FIELD_BLOCK_5, "Storage Field Block T5", "存储立场方块T5");
        addBlock(provider, STORAGE_FIELD_BLOCK_6, "Storage Field Block T6", "存储立场方块T6");
        addBlock(provider, STORAGE_FIELD_BLOCK_7, "Storage Field Block T7", "存储立场方块T7");
        addBlock(provider, STORAGE_FIELD_BLOCK_8, "Storage Field Block T8", "存储立场方块T8");
        addBlock(provider, STORAGE_FIELD_BLOCK_9, "Storage Field Block T9", "存储立场方块T9");
        addBlock(provider, STORAGE_FIELD_BLOCK_10, "Storage Field Block T10", "存储立场方块T10");

        //  Component Assembly Line Casings
        addBlockWithTooltip(provider, COMPONENT_ASSEMBLY_LINE_CASING_LV, "Component Assembly Line Casing (LV)", "部件装配线外壳（LV）",
                "§7Simple Assembly Unit",
                "§7简易装配单元");
        addBlockWithTooltip(provider, COMPONENT_ASSEMBLY_LINE_CASING_MV, "Component Assembly Line Casing (MV)", "部件装配线外壳（MV）",
                "§7Crude Assembly Unit",
                "§7粗制装配单元");
        addBlockWithTooltip(provider, COMPONENT_ASSEMBLY_LINE_CASING_HV, "Component Assembly Line Casing (HV)", "部件装配线外壳（HV）",
                "§7Premium Assembly Unit",
                "§7优质装配单元");
        addBlockWithTooltip(provider, COMPONENT_ASSEMBLY_LINE_CASING_EV, "Component Assembly Line Casing (EV)", "部件装配线外壳（EV）",
                "§7Advanced Assembly Unit",
                "§7进阶装配单元");
        addBlockWithTooltip(provider, COMPONENT_ASSEMBLY_LINE_CASING_IV, "Component Assembly Line Casing (IV)", "部件装配线外壳（IV）",
                "§High-quality Assembly Unit",
                "§7高级装配单元");
        addBlockWithTooltip(provider, COMPONENT_ASSEMBLY_LINE_CASING_LuV, "Component Assembly Line Casing (LuV)", "部件装配线外壳（LuV）",
                "§7High-precision Assembly Unit",
                "§7高精度装配单元");
        addBlockWithTooltip(provider, COMPONENT_ASSEMBLY_LINE_CASING_ZPM, "Component Assembly Line Casing (ZPM)", "部件装配线外壳（ZPM）",
                "§7Ultra-high precision Assembly Unit",
                "§7超高精度装配单元");
        addBlockWithTooltip(provider, COMPONENT_ASSEMBLY_LINE_CASING_UV, "Component Assembly Line Casing (UV)", "部件装配线外壳（UV）",
                "§7Extreme precision Assembly Unit",
                "§7极限精度装配单元");
        addBlockWithTooltip(provider, COMPONENT_ASSEMBLY_LINE_CASING_UHV, "Component Assembly Line Casing (UHV)", "部件装配线外壳（UHV）",
                "§7Extremely High-precision Assembly Unit",
                "§7极高精度装配单元");
        addBlockWithTooltip(provider, COMPONENT_ASSEMBLY_LINE_CASING_UEV, "Component Assembly Line Casing (UEV)", "部件装配线外壳（UEV）",
                "§7Structural Assembly Unit",
                "§7结构装配单元");
        addBlockWithTooltip(provider, COMPONENT_ASSEMBLY_LINE_CASING_UIV, "Component Assembly Line Casing (UIV)", "部件装配线外壳（UIV）",
                "§7Large-scale Structural Assembly Unit",
                "§7大尺度结构装配单元");
        addBlockWithTooltip(provider, COMPONENT_ASSEMBLY_LINE_CASING_UXV, "Component Assembly Line Casing (UXV)", "部件装配线外壳（UXV）",
                "§7Superstructural Assembly Unit",
                "§7超结构装配单元");
        addBlockWithTooltip(provider, COMPONENT_ASSEMBLY_LINE_CASING_OpV, "Component Assembly Line Casing (OpV)", "部件装配线外壳（OpV）",
                "§7Cosmic Assembly Unit",
                "§7宇宙装配单元");
        addBlockWithTooltip(provider, COMPONENT_ASSEMBLY_LINE_CASING_MAX, "Component Assembly Line Casing (MAX)", "部件装配线外壳（MAX）",
                "§7Space-time Assembly Unit",
                "§7时空装配单元");
    }
}
