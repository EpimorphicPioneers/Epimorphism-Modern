package com.epimorphismmc.epimorphism.common.recipe;

import com.epimorphismmc.epimorphism.common.machine.multiblock.electric.NanoscaleFabricatorMachine;

import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.RecipeCondition;
import com.gregtechceu.gtceu.utils.FormattingUtil;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.util.GsonHelper;

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;

@NoArgsConstructor
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class HeatCapacityCondituon extends RecipeCondition {

    public static final HeatCapacityCondituon INSTANCE = new HeatCapacityCondituon();

    @Getter
    private int heatCapacity = 0;

    public HeatCapacityCondituon(int heatCapacity) {
        this.heatCapacity = Math.max(heatCapacity, 1);
    }

    @Override
    public String getType() {
        return "heat_capacity_condituon";
    }

    @Override
    public Component getTooltips() {
        return Component.translatable(
                "recipe.condition.heat_capacity.desc", FormattingUtil.formatNumbers(heatCapacity));
    }

    @Override
    public boolean test(@NotNull GTRecipe gtRecipe, @NotNull RecipeLogic recipeLogic) {
        if (recipeLogic.machine instanceof NanoscaleFabricatorMachine nanoscaleFabricator) {
            int delta = nanoscaleFabricator.getHeatCapacity() - heatCapacity;
            return delta >= 0 && delta <= 250;
        }
        return false;
    }

    @Override
    public RecipeCondition createTemplate() {
        return new HeatCapacityCondituon();
    }

    @Override
    public JsonObject serialize() {
        JsonObject value = super.serialize();
        value.addProperty("heatCapacity", heatCapacity);
        return value;
    }

    @Override
    public RecipeCondition deserialize(JsonObject config) {
        super.deserialize(config);
        this.heatCapacity = GsonHelper.getAsInt(config, "heatCapacity", 0);
        return this;
    }

    @Override
    public void toNetwork(FriendlyByteBuf buf) {
        super.toNetwork(buf);
        buf.writeInt(heatCapacity);
    }

    @Override
    public RecipeCondition fromNetwork(FriendlyByteBuf buf) {
        super.fromNetwork(buf);
        this.heatCapacity = buf.readInt();
        return this;
    }
}
