package com.epimorphismmc.epimorphism.common.recipe;

import com.epimorphismmc.epimorphism.common.machine.multiblock.noenergy.NeutronActivatorMachine;

import com.epimorphismmc.monomorphism.utility.MOFormattingUtils;

import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.RecipeCondition;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.util.GsonHelper;

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.annotation.ParametersAreNonnullByDefault;

@NoArgsConstructor
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class NeutronEnergyCondition extends RecipeCondition {
    public static final NeutronEnergyCondition INSTANCE = new NeutronEnergyCondition();

    @Getter
    private int evMin = 0;

    @Getter
    private int evMax = 0;

    public NeutronEnergyCondition(int min, int max) {
        super();
        this.evMax = max;
        this.evMin = min;
    }

    @Override
    public String getType() {
        return "neutron_energy_condition";
    }

    @Override
    public Component getTooltips() {
        String max = MOFormattingUtils.abbreviate0F(evMax).replaceAll("(\\d)([a-zA-Z])", "$1 $2");
        String min = MOFormattingUtils.abbreviate0F(evMin).replaceAll("(\\d)([a-zA-Z])", "$1 $2");
        return Component.translatable("recipe.condition.neutron_kinetic_energy.desc", min, max);
    }

    @Override
    public boolean test(GTRecipe gtRecipe, RecipeLogic recipeLogic) {
        return recipeLogic.machine instanceof NeutronActivatorMachine;
    }

    @Override
    public RecipeCondition createTemplate() {
        return new NeutronEnergyCondition();
    }

    @Override
    public JsonObject serialize() {
        JsonObject value = super.serialize();
        value.addProperty("evMin", evMin);
        value.addProperty("evMax", evMax);
        return value;
    }

    @Override
    public RecipeCondition deserialize(JsonObject config) {
        super.deserialize(config);
        this.evMin = GsonHelper.getAsInt(config, "evMin", 0);
        this.evMax = GsonHelper.getAsInt(config, "evMax", 0);
        return this;
    }

    @Override
    public void toNetwork(FriendlyByteBuf buf) {
        super.toNetwork(buf);
        buf.writeInt(evMin);
        buf.writeInt(evMax);
    }

    @Override
    public RecipeCondition fromNetwork(FriendlyByteBuf buf) {
        super.fromNetwork(buf);
        this.evMin = buf.readInt();
        this.evMax = buf.readInt();
        return this;
    }
}
