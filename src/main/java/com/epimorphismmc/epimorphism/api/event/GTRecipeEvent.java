package com.epimorphismmc.epimorphism.api.event;

import com.gregtechceu.gtceu.api.capability.recipe.FluidRecipeCapability;
import com.gregtechceu.gtceu.api.capability.recipe.ItemRecipeCapability;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.api.recipe.content.Content;
import com.gregtechceu.gtceu.api.recipe.ingredient.FluidIngredient;
import com.gregtechceu.gtceu.data.recipe.builder.GTRecipeBuilder;

import com.lowdragmc.lowdraglib.side.fluid.FluidStack;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.fml.event.IModBusEvent;

import org.jetbrains.annotations.ApiStatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public abstract class GTRecipeEvent extends Event {
    @ApiStatus.Internal
    protected GTRecipeEvent() {
        /**/
    }

    public static class AddRecipe extends GTRecipeEvent {
        private final Consumer<FinishedRecipe> provider;

        @ApiStatus.Internal
        public AddRecipe(Consumer<FinishedRecipe> provider) {
            this.provider = provider;
        }

        public void register(Consumer<Consumer<FinishedRecipe>> registry) {
            registry.accept(provider);
        }
    }

    public static class RemoveRecipe extends GTRecipeEvent implements IModBusEvent {

        private final Map<GTRecipeType, List<Predicate<GTRecipeBuilder>>> map;

        @ApiStatus.Internal
        public RemoveRecipe(Map<GTRecipeType, List<Predicate<GTRecipeBuilder>>> map) {
            this.map = map;
        }

        public void removeRecipesByInputs(
                GTRecipeType type, ItemStack[] itemInputs, FluidStack[] fluidInputs) {
            this.map.computeIfAbsent(type, t -> new ArrayList<>()).add(b -> {
                var listItem = b.input.get(ItemRecipeCapability.CAP);

                if (listItem != null) {
                    var list = b.input.get(ItemRecipeCapability.CAP).stream()
                            .map(Content::getContent)
                            .map(ItemRecipeCapability.CAP::of)
                            .toList();

                    boolean allItemsMatch = checkItemsMatch(itemInputs, list);

                    if (!allItemsMatch) return false;
                }

                var listFluid = b.input.get(ItemRecipeCapability.CAP);

                if (listFluid != null) {
                    var list = b.input.get(FluidRecipeCapability.CAP).stream()
                            .map(Content::getContent)
                            .map(FluidRecipeCapability.CAP::of)
                            .toList();

                    return checkFluidsMatch(fluidInputs, list);
                }

                return true;
            });
        }

        public void removeRecipesByInputs(GTRecipeType type, ItemStack... itemInputs) {
            removeRecipesByInputs(type, itemInputs, new FluidStack[0]);
        }

        public void removeRecipesByInputs(GTRecipeType type, FluidStack... fluidInputs) {
            removeRecipesByInputs(type, new ItemStack[0], fluidInputs);
        }

        public void removeRecipesByOutputs(
                GTRecipeType type, ItemStack[] itemOutputs, FluidStack[] fluidOutputs) {
            this.map.computeIfAbsent(type, t -> new ArrayList<>()).add(b -> {
                var listItem = b.output.get(ItemRecipeCapability.CAP);

                if (listItem != null) {
                    var list = listItem.stream()
                            .map(Content::getContent)
                            .map(ItemRecipeCapability.CAP::of)
                            .toList();

                    boolean allItemsMatch = checkItemsMatch(itemOutputs, list);

                    if (!allItemsMatch) return false;
                }

                var listFluid = b.output.get(FluidRecipeCapability.CAP);

                if (listFluid != null) {
                    var list = listFluid.stream()
                            .map(Content::getContent)
                            .map(FluidRecipeCapability.CAP::of)
                            .toList();

                    return checkFluidsMatch(fluidOutputs, list);
                }

                return true;
            });
        }

        public void removeRecipesByOutputs(GTRecipeType type, ItemStack... itemOutputs) {
            removeRecipesByOutputs(type, itemOutputs, new FluidStack[0]);
        }

        public void removeRecipesByOutputs(GTRecipeType type, FluidStack... fluidOutputs) {
            removeRecipesByOutputs(type, new ItemStack[0], fluidOutputs);
        }

        public void removeAllRecipes(GTRecipeType type) {
            this.map.computeIfAbsent(type, t -> new ArrayList<>()).add(b -> true);
        }

        private boolean checkItemsMatch(ItemStack[] itemStacks, List<Ingredient> list) {
            return Arrays.stream(itemStacks)
                    .allMatch(stack -> list.stream().anyMatch(item -> item.test(stack)));
        }

        private boolean checkFluidsMatch(FluidStack[] fluidStacks, List<FluidIngredient> list) {
            return Arrays.stream(fluidStacks)
                    .allMatch(stack -> list.stream().anyMatch(fluid -> fluid.test(stack)));
        }
    }

    public static class RegisterHandler extends GTRecipeEvent implements IModBusEvent {
        private final Map<GTRecipeType, List<BiConsumer<GTRecipeBuilder, Consumer<FinishedRecipe>>>>
                map;

        @ApiStatus.Internal
        public RegisterHandler(
                Map<GTRecipeType, List<BiConsumer<GTRecipeBuilder, Consumer<FinishedRecipe>>>> map) {
            this.map = map;
        }

        public void register(
                GTRecipeType type, BiConsumer<GTRecipeBuilder, Consumer<FinishedRecipe>> handler) {
            this.map.computeIfAbsent(type, t -> new ArrayList<>()).add(handler);
        }
    }
}
