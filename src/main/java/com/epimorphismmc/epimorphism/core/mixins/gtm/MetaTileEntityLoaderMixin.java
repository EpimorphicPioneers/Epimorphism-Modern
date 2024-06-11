package com.epimorphismmc.epimorphism.core.mixins.gtm;

import com.epimorphismmc.epimorphism.data.recipe.generated.ComponentAsslineRecipeHandler;

import com.gregtechceu.gtceu.data.recipe.misc.MetaTileEntityLoader;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = MetaTileEntityLoader.class, remap = false)
public abstract class MetaTileEntityLoaderMixin {

    @WrapOperation(
            method = "init(Ljava/util/function/Consumer;)V",
            at =
                    @At(
                            value = "INVOKE",
                            target =
                                    "Lcom/gregtechceu/gtceu/data/recipe/CraftingComponent;initializeComponents()V"))
    private static void init(Operation<Void> original) {
        if (ComponentAsslineRecipeHandler.craftComponents == null) {
            original.call();
        }
    }
}
