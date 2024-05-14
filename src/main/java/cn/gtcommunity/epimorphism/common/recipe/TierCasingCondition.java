package cn.gtcommunity.epimorphism.common.recipe;

import cn.gtcommunity.epimorphism.api.machine.feature.multiblock.stats.ICasingMachine;
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
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;

import static com.gregtechceu.gtceu.api.GTValues.*;

@NoArgsConstructor
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class TierCasingCondition extends RecipeCondition {

    public static final TierCasingCondition INSTANCE = new TierCasingCondition();

    @Getter
    private int tier = 0;

    public TierCasingCondition(int tier) {
        this.tier = Mth.clamp(tier, 0, 14);
    }

    @Override
    public String getType() {
        return "tier_casing_condition";
    }

    @Override
    public Component getTooltips() {
        return Component.translatable("recipe.condition.tier_casing.desc", VN[tier]);
    }

    @Override
    public boolean test(@NotNull GTRecipe gtRecipe, @NotNull RecipeLogic recipeLogic) {
        if (recipeLogic.machine instanceof ICasingMachine casingMachine) {
            return casingMachine.getCasingTier() >= tier;
        }
        return false;
    }

    @Override
    public RecipeCondition createTemplate() {
        return new TierCasingCondition();
    }

    @Override
    public JsonObject serialize() {
        JsonObject value = super.serialize();
        value.addProperty("TierCasing", tier);
        return value;
    }

    @Override
    public RecipeCondition deserialize(JsonObject config) {
        super.deserialize(config);
        this.tier = GsonHelper.getAsInt(config, "TierCasing", 0);
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
