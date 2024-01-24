package cn.gtcommunity.epimorphism.common.recipe;

import cn.gtcommunity.epimorphism.common.machine.multiblock.electric.NeutronActivatorMachine;
import cn.gtcommunity.epimorphism.utils.EPLangUtil;
import com.google.gson.JsonObject;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.RecipeCondition;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.util.GsonHelper;

import javax.annotation.ParametersAreNonnullByDefault;

@NoArgsConstructor
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class NeutronKineticEnergyCondition extends RecipeCondition {
    public static final NeutronKineticEnergyCondition INSTANCE = new NeutronKineticEnergyCondition();
    @Getter
    private int evMin = 0;
    @Getter
    private int evMax = 0;
    public NeutronKineticEnergyCondition(int min, int max){
        super();
        this.evMax = max;
        this.evMin = min;
    }

    @Override
    public String getType() {
        return "neutron_kinetic_energy_condition";
    }

    @Override
    public Component getTooltips() {
        String max = EPLangUtil.abbreviate0F(evMax).replaceAll("(\\d)([a-zA-Z])", "$1 $2");
        String min = EPLangUtil.abbreviate0F(evMin).replaceAll("(\\d)([a-zA-Z])", "$1 $2");
        return Component.translatable("recipe.condition.neutron_kinetic_energy.desc", min, max);
    }

    @Override
    public boolean test(GTRecipe gtRecipe, RecipeLogic recipeLogic) {
        return recipeLogic.machine instanceof NeutronActivatorMachine;
    }

    @Override
    public RecipeCondition createTemplate() {
        return new NeutronKineticEnergyCondition();
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
