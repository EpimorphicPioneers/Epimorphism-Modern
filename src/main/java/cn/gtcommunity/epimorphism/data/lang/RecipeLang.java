package cn.gtcommunity.epimorphism.data.lang;

import com.gregtechceu.gtceu.api.GTValues;
import net.minecraftforge.common.data.LanguageProvider;

import static cn.gtcommunity.epimorphism.common.data.EPRecipeTypes.*;
import static cn.gtcommunity.epimorphism.data.lang.EPLangHelper.*;

public class RecipeLang {
    public static void init(LanguageProvider provider) {
        addRecipeType(provider, UNIVERSAL_CHEMICAL_FUELS, "Chemical Engine", "化学引擎");
        addRecipeType(provider, NEUTRON_ACTIVATOR_RECIPES, "Neutron Activation", "中子活化");
        addRecipeType(provider, COMPONENT_ASSEMBLY_LINE_RECIPES, "Large-scale Component Assembly", "大规模部件装配");
        addRecipeType(provider, GENERAL_RECIPES_A, "Machining Mode A", "加工模式A");
        addRecipeType(provider, GENERAL_RECIPES_B, "Machining Mode B", "加工模式B");
        addRecipeType(provider, GENERAL_RECIPES_C, "Machining Mode C", "加工模式C");
        addRecipeType(provider, RADIATION_HATCH_LIST, "List of materials in the radiation chamber", "放射仓材料列表");
        addRecipeType(provider, LARGE_NAQUADAH_COOLANT_LIST, "List of coolants", "冷却剂列表");
        addRecipeType(provider, LARGE_NAQUADAH_EXCITED_FLUID_LIST, "List of active fluids", "激发流体列表");
        addRecipeType(provider, ROASTER_RECIPES, "Roasting", "焙烧");
        addRecipeType(provider, DRILLING_RECIPES, "Drilling", "钻取");
        addRecipeType(provider, DIGESTER_RECIPES, "Digestion", "煮解");
        addRecipeType(provider, ORE_MILLING_RECIPES, "Ore Milling", "矿石加工");
        addRecipeType(provider, VACUUM_DRYING_FURNACE_RECIPES, "Vacuum Drying", "真空干燥");
        addRecipeType(provider, PRECISE_ASSEMBLER_RECIPES, "Precise Assembler", "精密组装");
        addRecipeType(provider, FERMENTATION_TANK_RECIPES, "Biological Fermentation", "生物发酵");
        addRecipeType(provider, MOLECULAR_BEAM_RECIPES, "Molecular Beam Epitaxy", "分子束外延");
        addRecipeType(provider, CRYSTALLIZATION_RECIPES, "Crystallization", "结晶");


        //  Recipe Data
        add(provider, "epimorphism.recipe.mass",
                "Mass: %s kg",
                "质量：%s kg");
        add(provider, "epimorphism.recipe.radioactivity",
                "Radiation Dose: %s Sv",
                "辐射剂量：%s Sv");
        add(provider, "epimorphism.recipe.consumption_rate",
                "Consumption Rate: %s",
                "消耗速率：%s L/s");
        add(provider, "epimorphism.recipe.parallel",
                "Parallel: %s",
                "并行：× %s");
        add(provider, "epimorphism.recipe.efficiency",
                "Efficiency: %s%",
                "效率：%s%%");

        //  Recipe Condition
        add(provider, "recipe.condition.neutron_kinetic_energy.desc",
                "Minimum neutron kinetic energy: %seV\nMaximum neutron kinetic energy: %seV",
                "最小中子动能: %seV\n最大中子动能: %seV");
        addMultiLang(provider, "recipe.condition.chemical_plant_casing.desc.%s"::formatted,
                tier -> "Casing Tier: %s - %s".formatted(tier, getCPCasingTier(tier, true)),
                tier -> "外壳等级：%s - %s".formatted(tier, getCPCasingTier(tier, false)), GTValues.tiersBetween(1, 6));
        add(provider, "recipe.condition.tier_casing.desc",
                "Casing Tier: %s",
                "外壳等级：%s");
        add(provider, "recipe.condition.precise_assembler_casing.desc",
                "Casing Tier: MK-%s",
                "外壳等级：MK-%s");
        add(provider, "recipe.condition.heat_capacity.desc",
                "Temperature: %sK",
                "温度：%sK");
    }

    private static String getCPCasingTier(int tier, boolean isEN) {
        return switch (tier) {
            case 1 -> isEN ? "Bronze" : "青铜";
            case 2 -> isEN ? "Steel" : "钢";
            case 3 -> isEN ? "Aluminium" : "铝";
            case 4 -> isEN ? "Stainless Steel" : "不锈钢";
            case 5 -> isEN ? "Titanium" : "钛";
            default -> isEN ? "Tungsten Steel" : "钨钢";
        };
    }
}
