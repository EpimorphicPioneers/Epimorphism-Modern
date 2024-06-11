package com.epimorphismmc.epimorphism.data.recipe.generated;

import com.epimorphismmc.epimorphism.api.event.GTRecipeEvent;
import com.epimorphismmc.epimorphism.common.machine.multiblock.part.IntakeHatchPartMachine;

import static com.epimorphismmc.epimorphism.common.data.EPRecipeTypes.ROCKET_ENGINE_FUELS;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;

public class GTRecipeHandlerManager {
    public static void register(GTRecipeEvent.RegisterHandler event) {
        event.register(
                ASSEMBLY_LINE_RECIPES, (builder, provider) -> ComponentAsslineRecipeHandler.init(builder));
        event.register(
                ASSEMBLER_RECIPES, (builder, provider) -> ComponentAsslineRecipeHandler.init(builder));
        event.register(COMBUSTION_GENERATOR_FUELS, UniversalChemicalFuelHandler::init);
        event.register(GAS_TURBINE_FUELS, UniversalChemicalFuelHandler::init);
        event.register(ROCKET_ENGINE_FUELS, UniversalChemicalFuelHandler::init);

        event.register(
                GAS_COLLECTOR_RECIPES, (builder, provider) -> IntakeHatchPartMachine.initMap(builder));
    }
}
