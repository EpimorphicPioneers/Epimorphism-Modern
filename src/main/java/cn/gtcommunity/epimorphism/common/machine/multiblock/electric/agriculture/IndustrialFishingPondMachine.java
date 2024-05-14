package cn.gtcommunity.epimorphism.common.machine.multiblock.electric.agriculture;

import cn.gtcommunity.epimorphism.api.machine.fancyconfigurator.CustomModeFancyConfigurator;
import cn.gtcommunity.epimorphism.common.machine.trait.FishingPondRecipeLogic;
import com.epimorphismmc.monomorphism.machine.multiblock.ParallelElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.gui.fancy.ConfiguratorPanel;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.utils.GTUtil;
import com.lowdragmc.lowdraglib.gui.texture.*;
import com.lowdragmc.lowdraglib.syncdata.annotation.DescSynced;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.ChatFormatting;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.HoverEvent;
import net.minecraft.network.chat.Style;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class IndustrialFishingPondMachine extends ParallelElectricMultiblockMachine {
    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(IndustrialFishingPondMachine.class, ParallelElectricMultiblockMachine.MANAGED_FIELD_HOLDER);
    @Persisted @DescSynced
    @Getter @Setter
    private int mode = 0;
    @Persisted
    @Getter @Setter
    private boolean filledWater;

    public IndustrialFishingPondMachine(IMachineBlockEntity holder, Object... args) {
        super(holder, machine -> Math.max(machine.getTier() * 2 + 1, 1), args);
    }

    @Override
    protected InteractionResult onScrewdriverClick(Player playerIn, InteractionHand hand, Direction gridSide, BlockHitResult hitResult) {
        setMode((getMode() + 1) % 3);
        return InteractionResult.CONSUME;
    }

    //////////////////////////////////////
    //******     Recipe Logic    *******//
    //////////////////////////////////////

    @Override
    public RecipeLogic createRecipeLogic(Object... args) {
        return new FishingPondRecipeLogic(this);
    }

    //////////////////////////////////////
    //***        Multiblock UI       ***//
    //////////////////////////////////////

    @Override
    public void attachConfigurators(ConfiguratorPanel configuratorPanel) {
        configuratorPanel.attachConfigurators(new CustomModeFancyConfigurator("fishing_mode",
                new ResourceTexture("minecraft:textures/item/fishing_rod.png"), 3, false,
                "block.epimorphism.industrial_fishing_pond.fishing_mode.%s"::formatted, this::getMode, this::setMode));
        super.attachConfigurators(configuratorPanel);
    }

    @Override
    public void addDisplayText(List<Component> textList) {
        super.addDisplayText(textList);
        if (this.isFormed()) {
            textList.clear();
            long maxVoltage = this.getMaxVoltage();
            if (maxVoltage > 0L) {
                String voltageName = GTValues.VNF[GTUtil.getFloorTierByVoltage(maxVoltage)];
                textList.add(Component.translatable("gtceu.multiblock.max_energy_per_tick", maxVoltage, voltageName));
            }

            textList.add(Component.translatable("block.epimorphism.industrial_fishing_pond.fishing_mode.%s".formatted(getMode())).setStyle(Style.EMPTY.withColor(ChatFormatting.AQUA).withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, Component.translatable("gtceu.gui.machinemode.title")))));
            if (!this.isWorkingEnabled()) {
                textList.add(Component.translatable("gtceu.multiblock.work_paused"));
            } else if (this.isActive()) {
                textList.add(Component.translatable("gtceu.multiblock.running"));
                int currentProgress = (int) (this.recipeLogic.getProgressPercent() * 100.0);
                textList.add(Component.translatable("gtceu.multiblock.progress", currentProgress));
            } else {
                textList.add(Component.translatable("gtceu.multiblock.idling"));
            }

            if (this.recipeLogic.isWaiting()) {
                textList.add(Component.translatable("gtceu.multiblock.waiting").setStyle(Style.EMPTY.withColor(ChatFormatting.RED)));
            }

            if (!this.isFilledWater()) {
                textList.add(Component.translatable("block.epimorphism.industrial_fishing_pond.warning.fill_water").setStyle(Style.EMPTY.withColor(ChatFormatting.RED)));
            }
        }

        this.getDefinition().getAdditionalDisplay().accept(this, textList);
    }

    //////////////////////////////////////
    //***       Multiblock Data      ***//
    //////////////////////////////////////

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }
}
