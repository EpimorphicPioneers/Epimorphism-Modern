package cn.gtcommunity.epimorphism.data.lang;

import net.minecraftforge.common.data.LanguageProvider;

import static cn.gtcommunity.epimorphism.common.data.EPRecipeTypes.*;
import static cn.gtcommunity.epimorphism.data.lang.EPLangHelper.*;

public class RecipeLang {
    public static void init(LanguageProvider provider) {
        addRecipeType(provider, CHEMICAL_PLANT_RECIPES, "Chemical Reactions", "化工反应");
        addRecipeType(provider, NEUTRON_ACTIVATOR_RECIPES, "Neutron Activation", "中子活化");
        addRecipeType(provider, COMPONENT_ASSEMBLY_LINE_RECIPES, "Large-scale Component Assembly", "大规模部件装配");
        addRecipeType(provider, GENERAL_RECIPES_A, "Machining Mode A", "加工模式A");
        addRecipeType(provider, GENERAL_RECIPES_B, "Machining Mode B", "加工模式B");
        addRecipeType(provider, GENERAL_RECIPES_C, "Machining Mode C", "加工模式C");
        addRecipeType(provider, RADIATION_HATCH_RECIPES, "List of materials in the radiation chamber", "放射仓材料列表");

        //  Recipe Data
        add(provider, "epimorphism.recipe.mass",
                "Mass: %s kg",
                "质量：%s kg");
        add(provider, "epimorphism.recipe.radioactivity",
                "Radiation dose: %s Sv",
                "辐射剂量：%s Sv");

        //  Recipe Condition
        add(provider, "recipe.condition.neutron_kinetic_energy.desc",
                "Minimum neutron kinetic energy: %seV\nMaximum neutron kinetic energy: %seV",
                "最小中子动能: %seV\n最大中子动能: %seV");
    }
}
