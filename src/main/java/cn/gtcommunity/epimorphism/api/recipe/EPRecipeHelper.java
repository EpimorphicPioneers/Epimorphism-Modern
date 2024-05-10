package cn.gtcommunity.epimorphism.api.recipe;

import com.gregtechceu.gtceu.api.capability.recipe.FluidRecipeCapability;
import com.gregtechceu.gtceu.api.capability.recipe.ItemRecipeCapability;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.content.Content;
import com.gregtechceu.gtceu.data.recipe.builder.GTRecipeBuilder;
import com.lowdragmc.lowdraglib.side.fluid.FluidStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EPRecipeHelper {

    public static Content itemStack(ItemStack itemStack, float chance, float tierChanceBoost) {
        return new Content(ItemRecipeCapability.CAP.of(itemStack), chance, tierChanceBoost, null, null);
    }

    public static Content itemStack(Item item, int amount, float chance, float tierChanceBoost) {
        return new Content(ItemRecipeCapability.CAP.of(new ItemStack(item, amount)), chance, tierChanceBoost, null, null);
    }

    public static Content fluidStack(FluidStack fluidStack, float chance, float tierChanceBoost) {
        return new Content(FluidRecipeCapability.CAP.of(fluidStack), chance, tierChanceBoost, null, null);
    }

    public static Content fluidStack(Fluid fluid, long amount, float chance, float tierChanceBoost) {
        return new Content(FluidRecipeCapability.CAP.of(FluidStack.create(fluid, amount)), chance, tierChanceBoost, null, null);
    }

    public static List<ItemStack> getOutputItem(GTRecipe recipe) {
        List<ItemStack> stacks = new ArrayList<>();
        for (var content : recipe.getOutputContents(ItemRecipeCapability.CAP)) {
            stacks.addAll(List.of(ItemRecipeCapability.CAP.of(content.getContent()).getItems()));
        }
        return stacks;
    }

    public static List<ItemStack> getOutputItem(GTRecipeBuilder builder) {
        List<ItemStack> stacks = new ArrayList<>();
        for (var content : builder.output.getOrDefault(ItemRecipeCapability.CAP, Collections.emptyList())) {
            stacks.addAll(List.of(ItemRecipeCapability.CAP.of(content.getContent()).getItems()));
        }
        return stacks;
    }

    public static List<FluidStack> getOutputFluid(GTRecipe recipe) {
        List<FluidStack> stacks = new ArrayList<>();
        for (var content : recipe.getOutputContents(FluidRecipeCapability.CAP)) {
            stacks.addAll(List.of(FluidRecipeCapability.CAP.of(content.getContent()).getStacks()));
        }
        return stacks;
    }

    public static List<FluidStack> getOutputFluid(GTRecipeBuilder builder) {
        List<FluidStack> stacks = new ArrayList<>();
        for (var content : builder.output.getOrDefault(FluidRecipeCapability.CAP, Collections.emptyList())) {
            stacks.addAll(List.of(FluidRecipeCapability.CAP.of(content.getContent()).getStacks()));
        }
        return stacks;
    }

    public static List<ItemStack> getInputItem(GTRecipe recipe) {
        List<ItemStack> stacks = new ArrayList<>();
        for (var content : recipe.getInputContents(ItemRecipeCapability.CAP)) {
            stacks.addAll(List.of(ItemRecipeCapability.CAP.of(content.getContent()).getItems()));
        }
        return stacks;
    }

    public static List<ItemStack> getInputItem(GTRecipeBuilder builder) {
        List<ItemStack> stacks = new ArrayList<>();
        for (var content : builder.input.getOrDefault(ItemRecipeCapability.CAP, Collections.emptyList())) {
            stacks.addAll(List.of(ItemRecipeCapability.CAP.of(content.getContent()).getItems()));
        }
        return stacks;
    }

    public static List<FluidStack> getInputFluid(GTRecipe recipe) {
        List<FluidStack> stacks = new ArrayList<>();
        for (var content : recipe.getInputContents(FluidRecipeCapability.CAP)) {
            stacks.addAll(List.of(FluidRecipeCapability.CAP.of(content.getContent()).getStacks()));
        }
        return stacks;
    }

}
