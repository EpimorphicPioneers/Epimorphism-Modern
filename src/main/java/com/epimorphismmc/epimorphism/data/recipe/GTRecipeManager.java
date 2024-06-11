package com.epimorphismmc.epimorphism.data.recipe;

import com.epimorphismmc.epimorphism.api.event.GTRecipeEvent;
import com.epimorphismmc.epimorphism.core.mixins.accessors.GTRecipeTypeAccessor;

import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.data.recipe.builder.GTRecipeBuilder;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoader;

import com.google.common.collect.ImmutableMap;
import org.jetbrains.annotations.ApiStatus;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class GTRecipeManager {

    private static Map<GTRecipeType, List<Predicate<GTRecipeBuilder>>> filterMap = new HashMap<>();

    private static boolean removed;

    private GTRecipeManager() {
        /**/
    }

    public static boolean shouldRemove(GTRecipeType type, GTRecipeBuilder builder) {
        if (removed) return false;

        var list = filterMap.get(type);
        if (list != null) {
            for (var filter : list) {
                if (filter.test(builder)) return true;
            }
        }

        return false;
    }

    @ApiStatus.Internal
    public static void onGTRecipeAddition(Consumer<FinishedRecipe> provider) {
        removed = true;
        MinecraftForge.EVENT_BUS.post(new GTRecipeEvent.AddRecipe(provider));
        removed = false;
    }

    @ApiStatus.Internal
    public static void onGTPostInitialization() {
        Map<GTRecipeType, List<BiConsumer<GTRecipeBuilder, Consumer<FinishedRecipe>>>> map =
                new HashMap<>();
        ModLoader.get().postEvent(new GTRecipeEvent.RegisterHandler(map));
        ImmutableMap<GTRecipeType, List<BiConsumer<GTRecipeBuilder, Consumer<FinishedRecipe>>>>
                handlerList = ImmutableMap.copyOf(map);

        handlerList.forEach((type, list) -> {
            var save = ((GTRecipeTypeAccessor) type).getRecipeBuilder().onSave;
            if (save != null) list.add(save);
            type.onRecipeBuild((builder, consumer) -> list.forEach(c -> c.accept(builder, consumer)));
        });
    }

    @ApiStatus.Internal
    public static void onCommonSetup() {
        ModLoader.get().postEvent(new GTRecipeEvent.RemoveRecipe(filterMap));
    }
}
