package cn.gtcommunity.epimorphism.common.machine.multiblock.electric;

import cn.gtcommunity.epimorphism.api.machine.multiblock.ParallelCoilMultiblockMachine;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.OverclockingLogic;
import com.gregtechceu.gtceu.api.recipe.RecipeHelper;
import com.gregtechceu.gtceu.data.recipe.builder.GTRecipeBuilder;
import com.lowdragmc.lowdraglib.side.fluid.FluidHelper;
import com.lowdragmc.lowdraglib.side.fluid.FluidStack;
import lombok.val;
import net.minecraft.ChatFormatting;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

import static cn.gtcommunity.epimorphism.common.data.EPMaterials.BlazingPyrotheum;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class AdvancedEBFMachine extends ParallelCoilMultiblockMachine {
    private final FluidStack PYROTHEUM_STACK = BlazingPyrotheum.getFluid(FluidHelper.getBucket() / 1000);

    private boolean insufficient;

    public AdvancedEBFMachine(IMachineBlockEntity holder, Object... args) {
        super(holder, machine -> 8, args);
    }

    //////////////////////////////////////
    //******     Recipe Logic    *******//
    //////////////////////////////////////

    protected GTRecipe getPyrotheumRecipe() {
        return GTRecipeBuilder.ofRaw().inputFluids(PYROTHEUM_STACK).buildRawRecipe();
    }

    @Override
    public void onWorking() {
        super.onWorking();
        long totalContinuousRunningTime = recipeLogic.getTotalContinuousRunningTime();
        if ((totalContinuousRunningTime == 1 || totalContinuousRunningTime % 2 == 0)) {
            if (!getPyrotheumRecipe().handleRecipeIO(IO.IN, this)) {
                this.insufficient = true;
                recipeLogic.interruptRecipe();
            }
            this.insufficient = false;
        }
    }

    public static @Nullable GTRecipe advEBFOverclock(MetaMachine machine, @Nonnull GTRecipe recipe) {
        if (machine instanceof ParallelCoilMultiblockMachine coilMachine) {
            val blastFurnaceTemperature = coilMachine.getCoilType().getCoilTemperature();
            if (!recipe.data.contains("ebf_temp") || recipe.data.getInt("ebf_temp") > blastFurnaceTemperature) {
                return null;
            }
            if (RecipeHelper.getRecipeEUtTier(recipe) > coilMachine.getTier()) {
                return null;
            }
            return RecipeHelper.applyOverclock(new OverclockingLogic((recipe1, recipeEUt, maxVoltage, duration, amountOC) -> {
                var pair = OverclockingLogic.heatingCoilOverclockingLogic(
                        Math.abs(recipeEUt),
                        maxVoltage,
                        duration,
                        amountOC,
                        blastFurnaceTemperature,
                        recipe.data.contains("ebf_temp") ? recipe.data.getInt("ebf_temp") : 0);
                var eu = pair.firstLong() * 0.9;
                var dur = pair.secondInt() * 0.45;
                pair.first((long) Math.max(1, eu)).second((int) Math.max(1, dur));
                return pair;
            }), recipe, coilMachine.getMaxVoltage());
        }
        return null;
    }

    //////////////////////////////////////
    //*******        GUI        ********//
    //////////////////////////////////////

    @Override
    public void addDisplayText(List<Component> textList) {
        super.addDisplayText(textList);
        if (isFormed()) {
            if (this.isActive()) {
                if (insufficient) {
                    textList.add(Component.translatable("block.epimorphism.advanced_electric_blast_furnace.warning.blazing_pyrotheum").withStyle(Style.EMPTY.withColor(ChatFormatting.RED)));
                } else {
                    textList.add(Component.translatable("block.epimorphism.advanced_electric_blast_furnace.blazing_pyrotheum").withStyle(Style.EMPTY.withColor(ChatFormatting.GOLD)));
                }
            }
        }
    }
}
