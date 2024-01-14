package cn.gtcommunity.epimorphism.common.data;

import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.common.data.GTSoundEntries;
import net.minecraft.world.item.crafting.RecipeType;

public class EPRecipeTypes {


    //////////////////////////////////////
    //*******     Multiblock     *******//
    //////////////////////////////////////
    public final static GTRecipeType NEUTRON_ACTIVATOR_RECIPES = GTRecipeTypes.register("neutron_activator", GTRecipeTypes.MULTIBLOCK).setMaxIOSize(6, 6, 1, 1)
            .setSound(GTSoundEntries.FURNACE);

    public final static GTRecipeType COMPONENT_ASSEMBLY_LINE_RECIPES = GTRecipeTypes.register("component_assembly_line", GTRecipeTypes.MULTIBLOCK).setMaxIOSize(12, 1, 12, 0).setEUIO(IO.IN)
            .setSound(GTSoundEntries.ASSEMBLER);

    public static void init() {/**/}

}
