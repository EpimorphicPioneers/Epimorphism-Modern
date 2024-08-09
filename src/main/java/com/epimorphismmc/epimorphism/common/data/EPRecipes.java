package com.epimorphismmc.epimorphism.common.data;

import com.epimorphismmc.epimorphism.api.event.GTRecipeEvent;
import com.epimorphismmc.epimorphism.data.recipe.chains.circuits.OpticalCircuitRecipeHandler;
import com.epimorphismmc.epimorphism.data.recipe.chains.oreprocessing.NaquadahProcessing;
import com.epimorphismmc.epimorphism.data.recipe.handler.BouleRecipeHandler;
import com.epimorphismmc.epimorphism.data.recipe.handler.ComponentAssemblyLineRecipeHandler;
import com.epimorphismmc.epimorphism.data.recipe.handler.PartsRecipeHandler;
import com.epimorphismmc.epimorphism.data.recipe.handler.WrapItemRecipeHandler;
import com.epimorphismmc.epimorphism.data.recipe.machine.multi.ComponentAssemblyLineMachineRecipe;
import com.epimorphismmc.epimorphism.data.recipe.machine.multi.ConcreteBackfillerMachineRecipe;
import com.epimorphismmc.epimorphism.data.recipe.machine.multi.SteamMachineRecipe;
import com.epimorphismmc.epimorphism.data.recipe.misc.BorosilicateGlassRecipes;
import com.epimorphismmc.epimorphism.data.recipe.misc.FuelRecipes;
import com.epimorphismmc.epimorphism.data.recipe.misc.LargeNaquadahReactorRecipes;
import com.epimorphismmc.epimorphism.data.recipe.misc.RadiationHatchRecipes;
import com.epimorphismmc.epimorphism.data.recipe.machine.multi.ConcreteBackfillerMachineHandler;
import com.epimorphismmc.epimorphism.data.recipe.machine.multi.SteamMachineHandler;
import com.epimorphismmc.epimorphism.data.recipe.misc.ConcreteBackfillerRecipes;
import com.epimorphismmc.epimorphism.data.recipe.misc.ConcreteRecipes;
import com.epimorphismmc.epimorphism.data.recipe.misc.FuelRecipeHandler;
import com.epimorphismmc.epimorphism.data.recipe.misc.LargeNaquadahReactorRecipeHandler;
import com.epimorphismmc.epimorphism.data.recipe.misc.RadiationHatchRecipeHandler;
import com.epimorphismmc.epimorphism.data.recipe.misc.WrapItemRecipes;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

public class EPRecipes {
    public static void init(Consumer<FinishedRecipe> provider) {
        /////////////////////////////////////////
        // *****     Machine Recipes     ***** //
        /////////////////////////////////////////
        SteamMachineRecipe.init(provider);
        ConcreteBackfillerMachineRecipe.init(provider);
        ComponentAssemblyLineMachineRecipe.init(provider);

        /////////////////////////////////////////
        // *****      Chain Recipes      ***** //
        /////////////////////////////////////////
        OpticalCircuitRecipeHandler.init(provider);
        NaquadahProcessing.init(provider);

        /////////////////////////////////////////
        // *****     Handler Recipes     ***** //
        /////////////////////////////////////////
        BouleRecipeHandler.init(provider);
        ComponentAssemblyLineRecipeHandler.finish(provider);
        PartsRecipeHandler.init(provider);

        /////////////////////////////////////////
        // *****       Misc Recipes      ***** //
        /////////////////////////////////////////
        FuelRecipeHandler.init(provider);
        LargeNaquadahReactorRecipeHandler.init(provider);
        RadiationHatchRecipeHandler.init(provider);
        ConcreteBackfillerRecipes.init(provider);
        ConcreteRecipes.init(provider);
        WrapItemRecipes.init(provider);
        BorosilicateGlassRecipes.init(provider);
    }

    public static void remove(GTRecipeEvent.RemoveRecipe event) {}
}
