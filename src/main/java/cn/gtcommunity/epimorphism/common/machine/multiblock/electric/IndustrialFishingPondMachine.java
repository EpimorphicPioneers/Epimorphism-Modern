package cn.gtcommunity.epimorphism.common.machine.multiblock.electric;

import cn.gtcommunity.epimorphism.api.machine.multiblock.ParallelElectricMultiblockMachine;
import cn.gtcommunity.epimorphism.common.machine.trait.FishingPondRecipeLogic;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.gui.fancy.ConfiguratorPanel;
import com.gregtechceu.gtceu.api.gui.fancy.IFancyConfigurator;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.utils.GTUtil;
import com.lowdragmc.lowdraglib.gui.editor.ColorPattern;
import com.lowdragmc.lowdraglib.gui.texture.*;
import com.lowdragmc.lowdraglib.gui.widget.ButtonWidget;
import com.lowdragmc.lowdraglib.gui.widget.ImageWidget;
import com.lowdragmc.lowdraglib.gui.widget.Widget;
import com.lowdragmc.lowdraglib.gui.widget.WidgetGroup;
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
import java.util.ArrayList;
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
        super.attachConfigurators(configuratorPanel);
        configuratorPanel.attachConfigurators(new IFancyConfigurator() {

            @Override
            public Component getTitle() {
                return Component.translatable("gui.epimorphism.fishing_mode.title");
            }

            @Override
            public IGuiTexture getIcon() {
                return new ResourceTexture("minecraft:textures/item/fishing_rod.png");
            }

            @Override
            public Widget createConfigurator() {
                WidgetGroup group = new WidgetGroup(0, 0, 140, 64);
                group.setBackground(GuiTextures.BACKGROUND_INVERSE);

                for (int i = 0; i < 3; ++i) {
                    int tMode = i;
                    group.addWidget(new ButtonWidget(2, 2 + i * 20, 136, 20, IGuiTexture.EMPTY, (cd) -> setMode(tMode)));
                    group.addWidget(new ImageWidget(2, 2 + i * 20, 136, 20,
                            () -> new GuiTextureGroup(ResourceBorderTexture.BUTTON_COMMON.copy()
                                    .setColor(getMode() == tMode ? ColorPattern.CYAN.color : -1),
                                    new TextTexture("block.epimorphism.industrial_fishing_pond.fishing_mode.%s".formatted(tMode))
                                            .setWidth(136)
                                            .setType(TextTexture.TextType.ROLL))));
                }

                return group;
            }

            public List<Component> getTooltips() {
                List<Component> tooltip = new ArrayList<>();
                tooltip.add(Component.translatable("gui.epimorphism.change_fishing_mode.desc"));
                return tooltip;
            }
        });
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
