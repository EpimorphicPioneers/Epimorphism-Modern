package cn.gtcommunity.epimorphism.common.data;

import cn.gtcommunity.epimorphism.common.recipe.NeutronKineticEnergyCondition;
import com.gregtechceu.gtceu.api.registry.GTRegistries;

public class EPRecipeConditions {
    public static void init() {
        GTRegistries.RECIPE_CONDITIONS.register(NeutronKineticEnergyCondition.INSTANCE.getType(), NeutronKineticEnergyCondition.class);
    }
}
