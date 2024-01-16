package cn.gtcommunity.epimorphism.common.data;

import cn.gtcommunity.epimorphism.api.recipe.GeneralRecipeType;
import cn.gtcommunity.epimorphism.common.machine.multiblock.electric.GeneralProcessingPlantMachine;
import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.recipe.GTRecipeSerializer;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.api.registry.GTRegistries;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.common.data.GTSoundEntries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.RecipeType;

import static cn.gtcommunity.epimorphism.common.machine.multiblock.electric.GeneralProcessingPlantMachine.RECIPE_MAP;

public class EPRecipeTypes {


    //////////////////////////////////////
    //*******     Multiblock     *******//
    //////////////////////////////////////
    public final static GTRecipeType NEUTRON_ACTIVATOR_RECIPES = GTRecipeTypes.register("neutron_activator", GTRecipeTypes.MULTIBLOCK).setMaxIOSize(6, 6, 1, 1)
            .setSound(GTSoundEntries.FURNACE);

    public final static GTRecipeType COMPONENT_ASSEMBLY_LINE_RECIPES = GTRecipeTypes.register("component_assembly_line", GTRecipeTypes.MULTIBLOCK).setMaxIOSize(12, 1, 12, 0).setEUIO(IO.IN)
            .setSound(GTSoundEntries.ASSEMBLER);

    //  Universal Processing Plant Recipemaps (Pseudo Recipemap)
    public final static GTRecipeType GENERAL_RECIPES_A = registerGeneralRecipeType("general_recipes_a", GTRecipeTypes.MULTIBLOCK, RECIPE_MAP[0], RECIPE_MAP[1], RECIPE_MAP[2]).setMaxIOSize(1, 2, 1, 1).setEUIO(IO.IN);
    public final static GTRecipeType GENERAL_RECIPES_B = registerGeneralRecipeType("general_recipes_b", GTRecipeTypes.MULTIBLOCK, RECIPE_MAP[3], RECIPE_MAP[4], RECIPE_MAP[5]).setMaxIOSize(2, 2, 1, 1).setEUIO(IO.IN);
    public final static GTRecipeType GENERAL_RECIPES_C = registerGeneralRecipeType("general_recipes_c", GTRecipeTypes.MULTIBLOCK, RECIPE_MAP[6], RECIPE_MAP[7], RECIPE_MAP[8]).setMaxIOSize(2, 2, 1, 1).setEUIO(IO.IN);

    public static void init() {/**/}

    private static GTRecipeType registerGeneralRecipeType(String name, String group, GTRecipeType recipe_1, GTRecipeType recipe_2, GTRecipeType recipe_3) {
        GTRecipeType recipeType = new GeneralRecipeType(GTCEu.id(name), group, recipe_1, recipe_2, recipe_3);
        GTRegistries.register(BuiltInRegistries.RECIPE_TYPE, recipeType.registryName, recipeType);
        GTRegistries.register(BuiltInRegistries.RECIPE_SERIALIZER, recipeType.registryName, new GTRecipeSerializer());
        GTRegistries.RECIPE_TYPES.register(recipeType.registryName, recipeType);
        return recipeType;
    }
}
