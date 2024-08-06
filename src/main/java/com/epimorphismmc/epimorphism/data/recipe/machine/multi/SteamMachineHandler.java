package com.epimorphismmc.epimorphism.data.recipe.machine.multi;

import com.epimorphismmc.epimorphism.Epimorphism;

import com.gregtechceu.gtceu.api.data.chemical.material.stack.UnificationEntry;
import com.gregtechceu.gtceu.common.data.GTMachines;
import com.gregtechceu.gtceu.config.ConfigHolder;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.epimorphismmc.epimorphism.common.data.EPMachines.STEAM_FOUNDRY;
import static com.epimorphismmc.epimorphism.common.data.EPMachines.STEAM_PISTON_HAMMER;
import static com.epimorphismmc.epimorphism.common.data.EPMachines.STEAM_PRESS;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTBlocks.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

public class SteamMachineHandler {

    public static void init(Consumer<FinishedRecipe> provider) {
        steelSteamMultiblocks(provider);
    }

    @SuppressWarnings("DuplicatedCode")
    private static void steelSteamMultiblocks(Consumer<FinishedRecipe> provider) {
        if (ConfigHolder.INSTANCE.machines.steelSteamMultiblocks) {
            VanillaRecipeHelper.addShapedRecipe(
                    provider,
                    true,
                    Epimorphism.id("steam_piston_hammer"),
                    STEAM_PISTON_HAMMER.asStack(1),
                    "PGP",
                    "PTP",
                    "PGP",
                    'P',
                    CASING_STEEL_SOLID,
                    'G',
                    new UnificationEntry(gear, Steel),
                    'T',
                    GTMachines.STEAM_HAMMER.right().asStack());

            VanillaRecipeHelper.addShapedRecipe(
                    provider,
                    true,
                    Epimorphism.id("steam_foundry"),
                    STEAM_FOUNDRY.asStack(1),
                    "PGP",
                    "BTB",
                    "PGP",
                    'P',
                    CASING_STEEL_SOLID,
                    'B',
                    FIREBOX_STEEL,
                    'G',
                    new UnificationEntry(gear, Cupronickel),
                    'T',
                    GTMachines.STEAM_ALLOY_SMELTER.right().asStack());

            VanillaRecipeHelper.addShapedRecipe(
                    provider,
                    true,
                    Epimorphism.id("steam_pressor"),
                    STEAM_PRESS.asStack(1),
                    "PGP",
                    "PTP",
                    "PGP",
                    'P',
                    CASING_STEEL_SOLID,
                    'G',
                    new UnificationEntry(gear, Brass),
                    'T',
                    GTMachines.STEAM_COMPRESSOR.right().asStack());
        } else {
            VanillaRecipeHelper.addShapedRecipe(
                    provider,
                    true,
                    Epimorphism.id("steam_piston_hammer"),
                    STEAM_PISTON_HAMMER.asStack(1),
                    "PGP",
                    "PTP",
                    "PGP",
                    'P',
                    CASING_BRONZE_BRICKS,
                    'G',
                    new UnificationEntry(gear, Steel),
                    'T',
                    GTMachines.STEAM_HAMMER.left().asStack());

            VanillaRecipeHelper.addShapedRecipe(
                    provider,
                    true,
                    Epimorphism.id("steam_foundry"),
                    STEAM_FOUNDRY.asStack(1),
                    "PGP",
                    "BTB",
                    "PGP",
                    'P',
                    CASING_BRONZE_BRICKS,
                    'B',
                    FIREBOX_BRONZE,
                    'G',
                    new UnificationEntry(gear, Cupronickel),
                    'T',
                    GTMachines.STEAM_ALLOY_SMELTER.left().asStack());

            VanillaRecipeHelper.addShapedRecipe(
                    provider,
                    true,
                    Epimorphism.id("steam_pressor"),
                    STEAM_PRESS.asStack(1),
                    "PGP",
                    "PTP",
                    "PGP",
                    'P',
                    CASING_BRONZE_BRICKS,
                    'G',
                    new UnificationEntry(gear, Brass),
                    'T',
                    GTMachines.STEAM_COMPRESSOR.left().asStack());
        }
    }
}
