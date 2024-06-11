package com.epimorphismmc.epimorphism.core.mixins.gtm;

import com.epimorphismmc.epimorphism.data.recipe.GTRecipeManager;

import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.data.recipe.builder.GTRecipeBuilder;

import net.minecraft.data.recipes.FinishedRecipe;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

@Mixin(value = GTRecipeBuilder.class, remap = false)
public abstract class GTRecipeBuilderMixin {

    @Shadow
    public GTRecipeType recipeType;

    @Inject(
            method = "save(Ljava/util/function/Consumer;)V",
            at =
                    @At(
                            value = "INVOKE",
                            target =
                                    "Lcom/gregtechceu/gtceu/data/recipe/builder/GTRecipeBuilder;build()Lnet/minecraft/data/recipes/FinishedRecipe;"),
            cancellable = true)
    private void save(Consumer<FinishedRecipe> consumer, CallbackInfo ci) {
        if (GTRecipeManager.shouldRemove(recipeType, (GTRecipeBuilder) (Object) this)) ci.cancel();
    }
}
