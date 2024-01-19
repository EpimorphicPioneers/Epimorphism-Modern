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
    }
}
