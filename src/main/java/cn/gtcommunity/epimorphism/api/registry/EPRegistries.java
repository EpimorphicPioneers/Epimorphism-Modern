package cn.gtcommunity.epimorphism.api.registry;

import cn.gtcommunity.epimorphism.Epimorphism;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.api.registry.GTRegistry;

public class EPRegistries {

    public static final GTRegistry.RL<GTRecipeType> PLANTS = new GTRegistry.RL<>(Epimorphism.id("plant"));

}
