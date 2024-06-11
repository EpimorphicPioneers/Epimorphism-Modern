package com.epimorphismmc.epimorphism.common.recipe;

import com.epimorphismmc.epimorphism.common.machine.multiblock.electric.advanced.PreciseAssemblerMachine;

import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.RecipeCondition;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.util.GsonHelper;
import net.minecraft.util.Mth;

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;

@NoArgsConstructor
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class PACasingCondition extends RecipeCondition {
    public static final int MK_1 = 1;
    public static final int MK_2 = 2;
    public static final int MK_3 = 3;

    public static final PACasingCondition INSTANCE = new PACasingCondition();

    @Getter
    private int tier = 0;

    public PACasingCondition(int tier) {
        this.tier = Mth.clamp(tier, 1, 3);
    }

    @Override
    public String getType() {
        return "precise_assembler_casing_condition";
    }

    @Override
    public Component getTooltips() {
        return Component.translatable("recipe.condition.precise_assembler_casing.desc", tier);
    }

    @Override
    public boolean test(@NotNull GTRecipe gtRecipe, @NotNull RecipeLogic recipeLogic) {
        if (recipeLogic.machine instanceof PreciseAssemblerMachine preciseAssembler) {
            return preciseAssembler.getPACasingTier() >= tier;
        }
        return false;
    }

    @Override
    public RecipeCondition createTemplate() {
        return new PACasingCondition();
    }

    @Override
    public JsonObject serialize() {
        JsonObject value = super.serialize();
        value.addProperty("PATier", tier);
        return value;
    }

    @Override
    public RecipeCondition deserialize(JsonObject config) {
        super.deserialize(config);
        this.tier = GsonHelper.getAsInt(config, "PATier", 0);
        return this;
    }

    @Override
    public void toNetwork(FriendlyByteBuf buf) {
        super.toNetwork(buf);
        buf.writeInt(tier);
    }

    @Override
    public RecipeCondition fromNetwork(FriendlyByteBuf buf) {
        super.fromNetwork(buf);
        this.tier = buf.readInt();
        return this;
    }
}
