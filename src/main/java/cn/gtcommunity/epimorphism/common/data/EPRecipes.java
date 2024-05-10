package cn.gtcommunity.epimorphism.common.data;

import cn.gtcommunity.epimorphism.api.event.GTRecipeEvent;
import cn.gtcommunity.epimorphism.data.recipe.EPMFusionLoader;
import cn.gtcommunity.epimorphism.data.recipe.circuits.CosmicCircuits;
import cn.gtcommunity.epimorphism.data.recipe.generated.BouleRecipeHandler;
import cn.gtcommunity.epimorphism.data.recipe.generated.ComponentAsslineRecipeHandler;
import cn.gtcommunity.epimorphism.data.recipe.misc.FuelRecipes;
import cn.gtcommunity.epimorphism.data.recipe.misc.LargeNaquadahReactorLoader;
import cn.gtcommunity.epimorphism.data.recipe.misc.RadiationHatchLoader;
import cn.gtcommunity.epimorphism.data.recipe.generated.WrapItemRecipeHandler;
import cn.gtcommunity.epimorphism.data.recipe.misc.NeutronActivatorLoader;
import cn.gtcommunity.epimorphism.data.recipe.serialized.oreprocessing.NaquadahProcessing;
import cn.gtcommunity.epimorphism.data.recipe.chains.*;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

public class EPRecipes {
    public static void init(Consumer<FinishedRecipe> provider) {
        WrapItemRecipeHandler.init(provider);
        BouleRecipeHandler.init(provider);

        FuelRecipes.init(provider);

        NeutronActivatorLoader.init(provider);
        LargeNaquadahReactorLoader.init(provider);
        RadiationHatchLoader.init(provider);

        CosmicCircuits.init(provider);
        EPMFusionLoader.init(provider);

        initOreProcessings(provider);
        ComponentAsslineRecipeHandler.finish(provider);
        initChains(provider);
    }

    public static void remove(GTRecipeEvent.RemoveRecipe event) {

    }

    private static void initOreProcessings(Consumer<FinishedRecipe> consumer) {
        NaquadahProcessing.init(consumer);
    }

    private static void initChains(Consumer<FinishedRecipe> consumer) {
        AmmoniaChain.init(consumer);
        BismuthVanadiumChain.init(consumer);
        BoronChain.init(consumer);
        BoronNitrideChain.init(consumer);
        BPAPolycarbonateChain.init(consumer);
        BromineChain.init(consumer);
        BZMediumChain.init(consumer);
        CaesiumRubidiumChain.init(consumer);
        CalciumChain.init(consumer);
        CaliforniumChain.init(consumer);
        CarbonNanotubeChain.init(consumer);
        CBDOPolycarbonateChain.init(consumer);
        ChlorineChain.init(consumer);
        CyanogenChain.init(consumer);
        DragonChain.init(consumer);
        EDTAChain.init(consumer);
    }

}
