package com.epimorphismmc.epimorphism.common.data;

import com.epimorphismmc.epimorphism.common.recipe.CPCasingCondition;
import com.epimorphismmc.epimorphism.common.recipe.HeatCapacityCondituon;
import com.epimorphismmc.epimorphism.common.recipe.NeutronEnergyCondition;
import com.epimorphismmc.epimorphism.common.recipe.PACasingCondition;
import com.epimorphismmc.epimorphism.common.recipe.TierCasingCondition;

import com.gregtechceu.gtceu.api.registry.GTRegistries;

public class EPRecipeConditions {
    public static void init() {
        GTRegistries.RECIPE_CONDITIONS.register(
                NeutronEnergyCondition.INSTANCE.getType(), NeutronEnergyCondition.class);
        GTRegistries.RECIPE_CONDITIONS.register(
                PACasingCondition.INSTANCE.getType(), PACasingCondition.class);
        GTRegistries.RECIPE_CONDITIONS.register(
                CPCasingCondition.INSTANCE.getType(), CPCasingCondition.class);
        GTRegistries.RECIPE_CONDITIONS.register(
                TierCasingCondition.INSTANCE.getType(), TierCasingCondition.class);
        GTRegistries.RECIPE_CONDITIONS.register(
                HeatCapacityCondituon.INSTANCE.getType(), HeatCapacityCondituon.class);
    }
}
