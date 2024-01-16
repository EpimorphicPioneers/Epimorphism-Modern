package cn.gtcommunity.epimorphism.data.lang;

import net.minecraftforge.common.data.LanguageProvider;

import static cn.gtcommunity.epimorphism.common.data.EPBlocks.*;
import static cn.gtcommunity.epimorphism.data.lang.EPLangHelper.*;

public class BlockLang {
    public static void init(LanguageProvider provider) {
        add(provider, "epimorphism.block_tier.desc",
                "§7Tier: %s",
                "§7等级：%s");

        //  Fluid Tank Cell Block
        addBlock(provider, FLUID_TANK_CELL_1, "Fluid Tank Cell Block T1", "流体单元方块T1");
        addBlock(provider, FLUID_TANK_CELL_2, "Fluid Tank Cell Block T1", "流体单元方块T2");
        addBlock(provider, FLUID_TANK_CELL_3, "Fluid Tank Cell Block T1", "流体单元方块T3");
        addBlock(provider, FLUID_TANK_CELL_4, "Fluid Tank Cell Block T1", "流体单元方块T4");
        addBlock(provider, FLUID_TANK_CELL_5, "Fluid Tank Cell Block T1", "流体单元方块T5");
        addBlock(provider, FLUID_TANK_CELL_6, "Fluid Tank Cell Block T1", "流体单元方块T6");
        addBlock(provider, FLUID_TANK_CELL_7, "Fluid Tank Cell Block T1", "流体单元方块T7");
        addBlock(provider, FLUID_TANK_CELL_8, "Fluid Tank Cell Block T1", "流体单元方块T8");
        addBlock(provider, FLUID_TANK_CELL_9, "Fluid Tank Cell Block T1", "流体单元方块T9");
        addBlock(provider, FLUID_TANK_CELL_10, "Fluid Tank Cell Block T1", "流体单元方块T10");

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

        add(provider, "epimorphism.fluid_capacity.desc",
                "§ 7 Volume: %s L",
                "§7容量：%s L");
    }
}
