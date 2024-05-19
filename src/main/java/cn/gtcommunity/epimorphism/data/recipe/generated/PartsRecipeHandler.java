package cn.gtcommunity.epimorphism.data.recipe.generated;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.FluidProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.machine.multiblock.CleanroomType;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static cn.gtcommunity.epimorphism.api.data.tag.EPTagPrefix.*;
import static cn.gtcommunity.epimorphism.common.data.EPItems.*;
import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;

public class PartsRecipeHandler {

    private PartsRecipeHandler() {/**/}

    public static void init(Consumer<FinishedRecipe> provider) {
        laserEmitter.executeHandler(provider, PropertyKey.FLUID, PartsRecipeHandler::processLaserEmitter);
    }

    private static void processLaserEmitter(TagPrefix stickPrefix, Material material, FluidProperty property, Consumer<FinishedRecipe> provider) {
        CANNER_RECIPES.recipeBuilder(material.getName() + "laser_emitter")
                .inputItems(EMPTY_GAS_LASER_EMITTER)
                .inputFluids(material.getFluid(GAS, 1000))
                .outputItems(stickPrefix, material)
                .EUt(VA[HV])
                .duration(120)
                .cleanroom(CleanroomType.CLEANROOM)
                .save(provider);
    }

}
