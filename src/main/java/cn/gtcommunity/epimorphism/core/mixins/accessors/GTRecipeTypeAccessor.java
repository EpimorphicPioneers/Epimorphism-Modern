package cn.gtcommunity.epimorphism.core.mixins.accessors;

import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.data.recipe.builder.GTRecipeBuilder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value = GTRecipeType.class, remap = false)
public interface GTRecipeTypeAccessor {
    @Accessor
    GTRecipeBuilder getRecipeBuilder();
}
