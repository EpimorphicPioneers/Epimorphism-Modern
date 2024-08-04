package com.epimorphismmc.epimorphism.data.recipe.machine.multi;

import com.epimorphismmc.epimorphism.Epimorphism;

import com.gregtechceu.gtceu.api.data.chemical.material.stack.UnificationEntry;
import com.gregtechceu.gtceu.common.data.GTMachines;
import com.gregtechceu.gtceu.config.ConfigHolder;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;

import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.epimorphismmc.epimorphism.common.data.EPMachines.STEAM_FOUNDRY;
import static com.epimorphismmc.epimorphism.common.data.EPMachines.STEAM_PRESSOR;
import static com.epimorphismmc.epimorphism.common.data.EPMachines.STEAM_SEPARATOR;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.gear;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.rotor;
import static com.gregtechceu.gtceu.common.data.GTBlocks.CASING_BRONZE_BRICKS;
import static com.gregtechceu.gtceu.common.data.GTBlocks.CASING_STEEL_SOLID;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Brass;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Cupronickel;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Steel;
import static com.gregtechceu.gtceu.common.data.GTMaterials.TinAlloy;

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
                    Epimorphism.id("steam_separator"),
                    STEAM_SEPARATOR.asStack(1),
                    "PGP",
                    "PTP",
                    "PGP",
                    'P',
                    CASING_STEEL_SOLID,
                    'G',
                    new UnificationEntry(gear, Steel),
                    'T',
                    new UnificationEntry(rotor, TinAlloy));

            VanillaRecipeHelper.addShapedRecipe(
                    provider,
                    true,
                    Epimorphism.id("steam_foundry"),
                    STEAM_FOUNDRY.asStack(1),
                    "PGP",
                    "PTP",
                    "PGP",
                    'P',
                    CASING_STEEL_SOLID,
                    'G',
                    new UnificationEntry(gear, Cupronickel),
                    'T',
                    GTMachines.STEAM_ALLOY_SMELTER.left().asStack());

            VanillaRecipeHelper.addShapedRecipe(
                    provider,
                    true,
                    Epimorphism.id("steam_pressor"),
                    STEAM_PRESSOR.asStack(1),
                    "PGP",
                    "PTP",
                    "PGP",
                    'P',
                    CASING_STEEL_SOLID,
                    'G',
                    new UnificationEntry(gear, Brass),
                    'T',
                    GTMachines.STEAM_COMPRESSOR.left().asStack());
        } else {
            VanillaRecipeHelper.addShapedRecipe(
                    provider,
                    true,
                    Epimorphism.id("steam_separator"),
                    STEAM_SEPARATOR.asStack(1),
                    "PGP",
                    "PTP",
                    "PGP",
                    'P',
                    CASING_BRONZE_BRICKS,
                    'G',
                    new UnificationEntry(gear, Steel),
                    'T',
                    new UnificationEntry(rotor, TinAlloy));

            VanillaRecipeHelper.addShapedRecipe(
                    provider,
                    true,
                    Epimorphism.id("steam_foundry"),
                    STEAM_FOUNDRY.asStack(1),
                    "PGP",
                    "PTP",
                    "PGP",
                    'P',
                    CASING_BRONZE_BRICKS,
                    'G',
                    new UnificationEntry(gear, Cupronickel),
                    'T',
                    GTMachines.STEAM_ALLOY_SMELTER.left().asStack());

            VanillaRecipeHelper.addShapedRecipe(
                    provider,
                    true,
                    Epimorphism.id("steam_pressor"),
                    STEAM_PRESSOR.asStack(1),
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
