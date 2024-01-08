package cn.gtcommunity.epimorphism.common.data;

import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.common.data.GTSoundEntries;

import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;

public class EPRecipeTypes {


    //////////////////////////////////////
    //*******     Multiblock     *******//
    //////////////////////////////////////
    public final static GTRecipeType NEUTRON_ACTIVATOR_RECIPES = register("neutron_activator", MULTIBLOCK).setMaxIOSize(6, 6, 1, 1)
            .setSound(GTSoundEntries.FURNACE);

    public static void init() {/**/}

}
