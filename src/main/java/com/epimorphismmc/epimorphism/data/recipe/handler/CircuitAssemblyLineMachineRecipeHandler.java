package com.epimorphismmc.epimorphism.data.recipe.handler;

import com.epimorphismmc.epimorphism.Epimorphism;
import com.epimorphismmc.epimorphism.common.data.items.EPCircuitItems;
import com.epimorphismmc.epimorphism.common.data.items.EPWrapItem;
import com.gregtechceu.gtceu.api.capability.recipe.FluidRecipeCapability;
import com.gregtechceu.gtceu.api.capability.recipe.ItemRecipeCapability;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.chemical.material.MarkerMaterials;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.UnificationEntry;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.recipe.RecipeHelper;
import com.gregtechceu.gtceu.api.recipe.ingredient.FluidIngredient;
import com.gregtechceu.gtceu.api.recipe.ingredient.IntCircuitIngredient;
import com.gregtechceu.gtceu.api.recipe.ingredient.SizedIngredient;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.core.mixins.IngredientAccessor;
import com.gregtechceu.gtceu.core.mixins.TagValueAccessor;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import com.gregtechceu.gtceu.data.recipe.builder.GTRecipeBuilder;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import static com.epimorphismmc.epimorphism.common.data.EPRecipeTypes.*;
import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;

public class CircuitAssemblyLineMachineRecipeHandler {
    private static final List<GTRecipeBuilder> recipeBuilders = new ArrayList<>();

    public static void init(GTRecipeBuilder recipeBuilder) {
        var outputItems = RecipeHelper.getOutputItems(recipeBuilder);
        if (outputItems.isEmpty()) return;

        var item = outputItems.get(0).getItem();
        for (var entry : EPCircuitItems.ETCHED_CIRCUIT_MAP.keySet()) {
            if (entry.is(item)) {
                handleComponent(recipeBuilder, entry, outputItems.get(0).getCount());
            }
        }
    }

    public static void finish(Consumer<FinishedRecipe> provider) {
        recipeBuilders.forEach(builder -> builder.save(provider));

        for (var entry : EPCircuitItems.ETCHED_CIRCUIT_MAP.keySet()) {
            var etchedCircuit = EPCircuitItems.ETCHED_CIRCUIT_MAP.get(entry);
            var etchedCircuitBoard = EPCircuitItems.ETCHED_CIRCUIT_BOARD_MAP.get(entry);
            var etchedCircuitBase = EPCircuitItems.ETCHED_CIRCUIT_BASE_MAP.get(entry);
            if (entry.getId().getPath().contains("mirco")) {
                LASER_ENGRAVER_RECIPES.recipeBuilder(() -> etchedCircuit)
                        .inputItems(entry)
                        .notConsumable(lens, MarkerMaterials.Color.Yellow)
                        .outputItems(etchedCircuit)
                        .EUt(VA[MV])
                        .duration(30 * 20)
                        .save(provider);
                FORMING_PRESS_RECIPES.recipeBuilder(() -> etchedCircuitBase)
                        .inputItems(etchedCircuitBoard)
                        .inputItems(foil, WroughtIron, 4)
                        .outputItems(etchedCircuitBase)
                        .EUt(VA[LV])
                        .duration(15 * 20)
                        .save(provider);
            } else if (entry.getId().getPath().contains("nano")) {
                LASER_ENGRAVER_RECIPES.recipeBuilder(() -> etchedCircuit)
                        .inputItems(entry)
                        .notConsumable(lens, MarkerMaterials.Color.Cyan)
                        .outputItems(etchedCircuit)
                        .EUt(VA[HV])
                        .duration(30 * 20)
                        .save(provider);
                FORMING_PRESS_RECIPES.recipeBuilder(() -> etchedCircuitBase)
                        .inputItems(etchedCircuitBoard)
                        .inputItems(foil, Silver, 4)
                        .outputItems(etchedCircuitBase)
                        .EUt(VA[LV])
                        .duration(15 * 20)
                        .save(provider);
            } else if (entry.getId().getPath().contains("quantum")) {
                LASER_ENGRAVER_RECIPES.recipeBuilder(() -> etchedCircuit)
                        .inputItems(entry)
                        .notConsumable(lens, MarkerMaterials.Color.Lime)
                        .outputItems(etchedCircuit)
                        .EUt(VA[EV])
                        .duration(30 * 20)
                        .save(provider);
                FORMING_PRESS_RECIPES.recipeBuilder(() -> etchedCircuitBase)
                        .inputItems(etchedCircuitBoard)
                        .inputItems(foil, Electrum, 4)
                        .outputItems(etchedCircuitBase)
                        .EUt(VA[LV])
                        .duration(15 * 20)
                        .save(provider);
            } else if (entry.getId().getPath().contains("crystal")) {
                LASER_ENGRAVER_RECIPES.recipeBuilder(() -> etchedCircuit)
                        .inputItems(entry)
                        .notConsumable(lens, MarkerMaterials.Color.Blue)
                        .outputItems(etchedCircuit)
                        .EUt(VA[IV])
                        .duration(30 * 20)
                        .save(provider);
                FORMING_PRESS_RECIPES.recipeBuilder(() -> etchedCircuitBase)
                        .inputItems(etchedCircuitBoard)
                        .inputItems(foil, Osmium, 4)
                        .outputItems(etchedCircuitBase)
                        .EUt(VA[LV])
                        .duration(15 * 20)
                        .save(provider);
            } else if (entry.getId().getPath().contains("wetware")) {
                LASER_ENGRAVER_RECIPES.recipeBuilder(() -> etchedCircuit)
                        .inputItems(entry)
                        .notConsumable(lens, MarkerMaterials.Color.Red)
                        .outputItems(etchedCircuit)
                        .EUt(VA[LuV])
                        .duration(30 * 20)
                        .save(provider);
                FORMING_PRESS_RECIPES.recipeBuilder(() -> etchedCircuitBase)
                        .inputItems(etchedCircuitBoard)
                        .inputItems(foil, HSSG, 4)
                        .outputItems(etchedCircuitBase)
                        .EUt(VA[LV])
                        .duration(15 * 20)
                        .save(provider);
            }

            ASSEMBLER_RECIPES.recipeBuilder(() -> etchedCircuitBoard)
                    .inputItems(etchedCircuit)
                    .inputItems(GTItems.PLASTIC_BOARD)
                    .inputFluids(GTMaterials.Glue.getFluid(100))
                    .outputItems(etchedCircuitBoard)
                    .EUt(VA[LV])
                    .duration(15 * 20)
                    .save(provider);
        }
    }

    private static void handleComponent(GTRecipeBuilder builder, ItemEntry<? extends Item> outputItem, int outputCount) {
        List<Ingredient> inputItems = RecipeHelper.getInputContents(builder, ItemRecipeCapability.CAP);
        List<FluidIngredient> inputFluids = RecipeHelper.getInputContents(builder, FluidRecipeCapability.CAP);

        if (!builder.id.getPath().contains("soldering_alloy")) {
            return;
        }
        GTRecipeBuilder newBuilder = CIRCUIT_ASSEMBLY_LINE_RECIPES
                .recipeBuilder(Epimorphism.id(builder.id.getPath()));

        for (var input : inputItems) {
            //noinspection StatementWithEmptyBody
            if (input instanceof IntCircuitIngredient) {
            } else if (input instanceof SizedIngredient ingredient) {
                int count = ingredient.getAmount();
                for (Ingredient.Value value : ((IngredientAccessor) ingredient.getInner()).getValues()) {
                    if (value instanceof Ingredient.ItemValue itemValue) {
                        // 普通物品
                        for (ItemStack stack : itemValue.getItems()) {
                            UnificationEntry entry = ChemicalHelper.getUnificationEntry(stack.getItem());
                            if (entry != null && entry != UnificationEntry.EmptyMapMarkerEntry) {
                                handleUnificationEntry(newBuilder, entry, count);
                            } else {
                                ItemLike warpItem = EPWrapItem.WRAP_ITEM_MAP.entrySet().stream()
                                        .filter(e -> e.getKey().asItem() == stack.getItem())
                                        .map(Map.Entry::getValue)
                                        .findFirst()
                                        .orElse(null);
                                if (warpItem != null) {
                                    newBuilder.inputItems(new ItemStack(warpItem, count));
                                } else {
                                    newBuilder.inputItems(stack.copyWithCount(Math.min(64, count * 16)));
                                }
                            }
                        }
                    } else if (value instanceof Ingredient.TagValue tagValue) {
                        // tag 物品
                        TagKey<Item> tag = ((TagValueAccessor) tagValue).getTag();
                        UnificationEntry entry = ChemicalHelper.getUnificationEntry(tag);
                        if (entry != null && entry != UnificationEntry.EmptyMapMarkerEntry) {
                            handleUnificationEntry(newBuilder, entry, count);
                        } else {
                            if (tag == CustomTags.TRANSISTORS) {
                                newBuilder.inputItems(EPWrapItem.WRAP_SMD_TRANSISTOR, count);
                            } else if (tag == CustomTags.RESISTORS) {
                                newBuilder.inputItems(EPWrapItem.WRAP_SMD_RESISTOR, count);
                            } else if (tag == CustomTags.CAPACITORS) {
                                newBuilder.inputItems(EPWrapItem.WRAP_SMD_CAPACITOR, count);
                            } else if (tag == CustomTags.DIODES) {
                                newBuilder.inputItems(EPWrapItem.WRAP_SMD_DIODE, count);
                            } else if (tag == CustomTags.INDUCTORS) {
                                newBuilder.inputItems(EPWrapItem.WRAP_SMD_INDUCTOR, count);
                            } else {
                                newBuilder.inputItems(tag, Math.min(64, count * 16));
                            }
                        }
                    } else {
                        value.getItems().forEach(stack -> newBuilder.inputItems(
                                stack.copyWithCount(Math.min(64, count * 16))));
                    }
                }
            } else {
                for (ItemStack item : input.getItems()) {
                    newBuilder.inputItems(item.copyWithCount(Math.min(64, item.getCount() * 16)));
                }
            }
        }

        inputFluids.forEach(newBuilder::inputFluids);

        newBuilder.outputItems(outputItem, outputCount * 16);
        newBuilder.EUt(builder.EUt());
        newBuilder.duration(builder.duration * 3);
        newBuilder.scannerResearch(b -> b
                .researchStack(EPCircuitItems.ETCHED_CIRCUIT_BASE_MAP.get(outputItem).asStack())
                .EUt(VA[IV])
                .duration(30 * 20));

        recipeBuilders.add(newBuilder);
    }

    private static void handleUnificationEntry(GTRecipeBuilder newBuilder, UnificationEntry entry, int count) {
        // 是有 mat 物品
        Material material = entry.material;
        if (material == null) {
            return;
        }
        TagPrefix prefix = entry.tagPrefix;

        if (prefix == wireFine) {
            newBuilder.inputItems(wireGtQuadruple, material, count);
            return;
        }
        if (prefix == wireGtSingle) {
            newBuilder.inputItems(wireGtHex, material, count);
        }
        newBuilder.inputItems(prefix, material, Math.min(64, count * 16));
    }
}
