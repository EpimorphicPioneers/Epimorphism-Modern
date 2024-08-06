package com.epimorphismmc.epimorphism.common.data;

import com.epimorphismmc.epimorphism.api.event.GTRecipeEvent;
import com.epimorphismmc.epimorphism.data.recipe.chains.circuits.OpticalCircuitRecipeHandler;
import com.epimorphismmc.epimorphism.data.recipe.chains.oreprocessing.NaquadahProcessing;
import com.epimorphismmc.epimorphism.data.recipe.handler.BouleRecipeHandler;
import com.epimorphismmc.epimorphism.data.recipe.handler.ComponentAsslineRecipeHandler;
import com.epimorphismmc.epimorphism.data.recipe.handler.PartsRecipeHandler;
import com.epimorphismmc.epimorphism.data.recipe.handler.WrapItemRecipeHandler;
import com.epimorphismmc.epimorphism.data.recipe.machine.multi.ConcreteBackfillerMachineHandler;
import com.epimorphismmc.epimorphism.data.recipe.machine.multi.SteamMachineHandler;
import com.epimorphismmc.epimorphism.data.recipe.misc.FuelRecipeHandler;
import com.epimorphismmc.epimorphism.data.recipe.misc.LargeNaquadahReactorRecipeHandler;
import com.epimorphismmc.epimorphism.data.recipe.misc.RadiationHatchRecipeHandler;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

public class EPRecipes {
    public static void init(Consumer<FinishedRecipe> provider) {
        /////////////////////////////////////////
        // *****     Machine Recipes     ***** //
        /////////////////////////////////////////
        SteamMachineHandler.init(provider);
        ConcreteBackfillerMachineHandler.init(provider);

        /////////////////////////////////////////
        // *****      Chain Recipes      ***** //
        /////////////////////////////////////////
        OpticalCircuitRecipeHandler.init(provider);
        NaquadahProcessing.init(provider);

        /////////////////////////////////////////
        // *****     Handler Recipes     ***** //
        /////////////////////////////////////////
        BouleRecipeHandler.init(provider);
        ComponentAsslineRecipeHandler.finish(provider);
        PartsRecipeHandler.init(provider);
        WrapItemRecipeHandler.init(provider);

        /////////////////////////////////////////
        // *****       Misc Recipes      ***** //
        /////////////////////////////////////////
        FuelRecipeHandler.init(provider);
        LargeNaquadahReactorRecipeHandler.init(provider);
        RadiationHatchRecipeHandler.init(provider);
    }

    public static void remove(GTRecipeEvent.RemoveRecipe event) {}
}
