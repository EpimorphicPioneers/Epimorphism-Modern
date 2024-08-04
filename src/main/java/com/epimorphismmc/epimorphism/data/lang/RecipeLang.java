package com.epimorphismmc.epimorphism.data.lang;

import com.epimorphismmc.monomorphism.registry.registrate.providers.MOLangProvider;

import com.gregtechceu.gtceu.api.GTValues;

import static com.epimorphismmc.epimorphism.common.data.EPRecipeTypes.COMPONENT_ASSEMBLY_LINE_RECIPES;
import static com.epimorphismmc.epimorphism.common.data.EPRecipeTypes.CRYSTALLIZATION_RECIPES;
import static com.epimorphismmc.epimorphism.common.data.EPRecipeTypes.DIGESTER_RECIPES;
import static com.epimorphismmc.epimorphism.common.data.EPRecipeTypes.DRILLING_RECIPES;
import static com.epimorphismmc.epimorphism.common.data.EPRecipeTypes.FERMENTATION_TANK_RECIPES;
import static com.epimorphismmc.epimorphism.common.data.EPRecipeTypes.GENERAL_RECIPES_A;
import static com.epimorphismmc.epimorphism.common.data.EPRecipeTypes.GENERAL_RECIPES_B;
import static com.epimorphismmc.epimorphism.common.data.EPRecipeTypes.GENERAL_RECIPES_C;
import static com.epimorphismmc.epimorphism.common.data.EPRecipeTypes.LARGE_NAQUADAH_COOLANT_LIST;
import static com.epimorphismmc.epimorphism.common.data.EPRecipeTypes.LARGE_NAQUADAH_EXCITED_FLUID_LIST;
import static com.epimorphismmc.epimorphism.common.data.EPRecipeTypes.MOLECULAR_BEAM_RECIPES;
import static com.epimorphismmc.epimorphism.common.data.EPRecipeTypes.NEUTRON_ACTIVATOR_RECIPES;
import static com.epimorphismmc.epimorphism.common.data.EPRecipeTypes.ORE_MILLING_RECIPES;
import static com.epimorphismmc.epimorphism.common.data.EPRecipeTypes.PRECISE_ASSEMBLER_RECIPES;
import static com.epimorphismmc.epimorphism.common.data.EPRecipeTypes.RADIATION_HATCH_LIST;
import static com.epimorphismmc.epimorphism.common.data.EPRecipeTypes.ROASTER_RECIPES;
import static com.epimorphismmc.epimorphism.common.data.EPRecipeTypes.UNIVERSAL_CHEMICAL_FUELS;
import static com.epimorphismmc.epimorphism.common.data.EPRecipeTypes.VACUUM_DRYING_FURNACE_RECIPES;

public class RecipeLang {
    public static void init(MOLangProvider provider) {
        provider.addRecipeType(UNIVERSAL_CHEMICAL_FUELS, "Chemical Engine", "化学引擎");
        provider.addRecipeType(NEUTRON_ACTIVATOR_RECIPES, "Neutron Activation", "中子活化");
        provider.addRecipeType(
                COMPONENT_ASSEMBLY_LINE_RECIPES, "Large-scale Component Assembly", "大规模部件装配");
        provider.addRecipeType(GENERAL_RECIPES_A, "Machining Mode A", "加工模式A");
        provider.addRecipeType(GENERAL_RECIPES_B, "Machining Mode B", "加工模式B");
        provider.addRecipeType(GENERAL_RECIPES_C, "Machining Mode C", "加工模式C");
        provider.addRecipeType(
                RADIATION_HATCH_LIST, "List of materials in the radiation chamber", "放射仓材料列表");
        provider.addRecipeType(LARGE_NAQUADAH_COOLANT_LIST, "List of coolants", "冷却剂列表");
        provider.addRecipeType(LARGE_NAQUADAH_EXCITED_FLUID_LIST, "List of active fluids", "激发流体列表");
        provider.addRecipeType(ROASTER_RECIPES, "Roasting", "焙烧");
        provider.addRecipeType(DRILLING_RECIPES, "Drilling", "钻取");
        provider.addRecipeType(DIGESTER_RECIPES, "Digestion", "煮解");
        provider.addRecipeType(ORE_MILLING_RECIPES, "Ore Milling", "矿石加工");
        provider.addRecipeType(VACUUM_DRYING_FURNACE_RECIPES, "Vacuum Drying", "真空干燥");
        provider.addRecipeType(PRECISE_ASSEMBLER_RECIPES, "Precise Assembler", "精密组装");
        provider.addRecipeType(FERMENTATION_TANK_RECIPES, "Biological Fermentation", "生物发酵");
        provider.addRecipeType(MOLECULAR_BEAM_RECIPES, "Molecular Beam Epitaxy", "分子束外延");
        provider.addRecipeType(CRYSTALLIZATION_RECIPES, "Crystallization", "结晶");

        //  Recipe Data
        provider.add("epimorphism.recipe.mass", "Mass: %s kg", "质量：%s kg");
        provider.add("epimorphism.recipe.radioactivity", "Radiation Dose: %s Sv", "辐射剂量：%s Sv");
        provider.add(
                "epimorphism.recipe.consumption_rate", "Consumption Rate: %s mB/s", "消耗速率：%s mB/s");
        provider.add("epimorphism.recipe.parallel", "Parallel: %s", "并行：× %s");
        provider.add("epimorphism.recipe.efficiency", "Efficiency: %s%", "效率：%s%%");

        //  Recipe Condition
        provider.add(
                "recipe.condition.neutron_kinetic_energy.desc",
                "Minimum neutron kinetic energy: %seV\nMaximum neutron kinetic energy: %seV",
                "最小中子动能: %seV\n最大中子动能: %seV");
        provider.addMultiLang(
                "recipe.condition.chemical_plant_casing.desc.%s"::formatted,
                tier -> "Casing Tier: %s - %s".formatted(tier, getCPCasingTier(tier, true)),
                tier -> "外壳等级：%s - %s".formatted(tier, getCPCasingTier(tier, false)),
                GTValues.tiersBetween(1, 6));
        provider.add("recipe.condition.tier_casing.desc", "Casing Tier: %s", "外壳等级：%s");
        provider.add(
                "recipe.condition.precise_assembler_casing.desc", "Casing Tier: MK-%s", "外壳等级：MK-%s");
        provider.add("recipe.condition.heat_capacity.desc", "Temperature: %sK", "温度：%sK");
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
