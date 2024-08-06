package com.epimorphismmc.epimorphism.common.machine.multiblock.part;

import com.epimorphismmc.epimorphism.api.gui.EPGuiTextures;

import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.capability.recipe.IRecipeCapabilityHolder;
import com.gregtechceu.gtceu.api.capability.recipe.IRecipeHandler;
import com.gregtechceu.gtceu.api.capability.recipe.ItemRecipeCapability;
import com.gregtechceu.gtceu.api.capability.recipe.RecipeCapability;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.TickableSubscription;
import com.gregtechceu.gtceu.api.machine.multiblock.part.TieredIOPartMachine;
import com.gregtechceu.gtceu.api.machine.trait.NotifiableItemStackHandler;

import com.lowdragmc.lowdraglib.gui.widget.ImageWidget;
import com.lowdragmc.lowdraglib.gui.widget.LabelWidget;
import com.lowdragmc.lowdraglib.gui.widget.ProgressWidget;
import com.lowdragmc.lowdraglib.gui.widget.SlotWidget;
import com.lowdragmc.lowdraglib.gui.widget.Widget;
import com.lowdragmc.lowdraglib.gui.widget.WidgetGroup;
import com.lowdragmc.lowdraglib.syncdata.ISubscription;
import com.lowdragmc.lowdraglib.syncdata.annotation.DescSynced;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import com.lowdragmc.lowdraglib.utils.LocalizationUtils;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.chat.Component;
import net.minecraft.server.TickTask;
import net.minecraft.server.level.ServerLevel;

import com.google.common.collect.Table;
import com.google.common.collect.Tables;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class RadiationHatchPartMachine extends TieredIOPartMachine
        implements IRecipeCapabilityHolder {
    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(
            RadiationHatchPartMachine.class, TieredIOPartMachine.MANAGED_FIELD_HOLDER);

    private final Table<IO, RecipeCapability<?>, List<IRecipeHandler<?>>> proxy;

    @Persisted
    public final NotifiableItemStackHandler inventory;

    @Getter
    @Persisted
    private String radioactiveSource = LocalizationUtils.format("epimorphism.universal.none");

    @Getter
    @Persisted
    private int mass;

    @Getter
    @Persisted
    private int initialRadioactivity;

    @Getter
    @Persisted
    @DescSynced
    private int radioactivity;

    @Getter
    @Persisted
    @DescSynced
    private int initialTime;

    @Getter
    @Persisted
    @DescSynced
    private int time;

    @Nullable protected TickableSubscription AttenuationSubs;

    @Nullable protected TickableSubscription recipeSubs;

    @Nullable protected ISubscription inventorySubs;

    public RadiationHatchPartMachine(IMachineBlockEntity holder, int tier) {
        super(holder, tier, IO.IN);
        this.inventory = new NotifiableItemStackHandler(this, 1, IO.IN, IO.BOTH);
        this.proxy = Tables.newCustomTable(new EnumMap<>(IO.class), HashMap::new);
        proxy.put(IO.IN, ItemRecipeCapability.CAP, List.of(inventory));
    }

    //////////////////////////////////////
    // *****     Initialization    ******//
    //////////////////////////////////////

    @Override
    public void onLoad() {
        super.onLoad();
        if (getLevel() instanceof ServerLevel serverLevel) {
            serverLevel.getServer().tell(new TickTask(0, this::updateAttenuationSubscription));
            inventorySubs = this.inventory.addChangedListener(this::onInventoryChanged);
        }
    }

    @Override
    public void onUnload() {
        super.onUnload();
        if (inventorySubs != null) {
            inventorySubs.unsubscribe();
        }
    }

    private void onInventoryChanged() {
        if (isWorkingEnabled() && !inventory.isEmpty()) {
            recipeSubs = subscribeServerTick(recipeSubs, this::updateRecipeSubscription);
        } else if (recipeSubs != null) {
            recipeSubs.unsubscribe();
        }
    }

    //////////////////////////////////////
    // ********   Subscriptions  ********//
    //////////////////////////////////////

    protected void updateRecipeSubscription() {
        if (getTime() > 0 || getMass() > 0) return;

        var recipeTypes = getDefinition().getRecipeTypes();
        if (recipeTypes != null && !isRemote()) {
            if (recipeTypes.length == 0) return;
            var recipeType = recipeTypes[0];
            var recipes = recipeType.searchRecipe(this);
            if (recipes == null || !recipes.hasNext()) return;
            var recipe = recipes.next();
            if (recipe != null && recipe.handleRecipeIO(IO.IN, this)) {
                radioactiveSource = ItemRecipeCapability.CAP
                        .of(recipe.getInputContents(ItemRecipeCapability.CAP).get(0).getContent())
                        .getItems()[0]
                        .getItem()
                        .getDescription()
                        .getString();
                mass = recipe.data.getInt("mass") - 1;
                initialRadioactivity = recipe.data.getInt("radioactivity");
                initialTime = recipe.duration;
                radioactivity = initialRadioactivity;
                time = initialTime;
                updateAttenuationSubscription();
            }
        }
        onInventoryChanged();
    }

    protected void updateAttenuationSubscription() {
        if (getTime() > 0 || getMass() > 0) {
            AttenuationSubs = subscribeServerTick(AttenuationSubs, this::updateTime);
        } else if (AttenuationSubs != null) {
            AttenuationSubs.unsubscribe();
            radioactiveSource = LocalizationUtils.format("epimorphism.universal.none");
            initialRadioactivity = 0;
            radioactivity = 0;
            initialTime = 0;
            time = 0;
            AttenuationSubs = null;
            onInventoryChanged();
        }
    }

    private void updateTime() {
        if (time <= 0 && mass > 0) {
            mass--;
            time = initialTime;
        }
        time--;
        updateAttenuationSubscription();
    }

    //////////////////////////////////////
    // **********     GUI     ***********//
    //////////////////////////////////////
    @Override
    public Widget createUIWidget() {
        var group = new WidgetGroup(0, 0, 160, 74);
        var container = new WidgetGroup(0, 0, 160, 37);
        container.addWidget(new ImageWidget(4, 4, 152, 29, GuiTextures.DISPLAY));
        container.addWidget(new LabelWidget(
                8,
                8,
                () -> LocalizationUtils.format(
                        "epimorphism.universal.desc.radioactive_source", radioactiveSource)));
        container.addWidget(new LabelWidget(
                8,
                18,
                () ->
                        LocalizationUtils.format("epimorphism.universal.desc.mass", "%s kg".formatted(mass))));
        container.addWidget(new LabelWidget(
                72,
                18,
                () -> LocalizationUtils.format("epimorphism.universal.desc.sievert", radioactivity)));
        container.setBackground(GuiTextures.BACKGROUND_INVERSE);

        var slotContainer = new WidgetGroup(0, 47, 18 + 8, 18 + 8);
        slotContainer.addWidget(
                new SlotWidget(inventory.storage, 0, 4, 4, true, true).setBackground(GuiTextures.SLOT));
        slotContainer.setBackground(GuiTextures.BACKGROUND_INVERSE);

        var image_sievert = new ImageWidget(36, 43, 124, 12, EPGuiTextures.BAR_CONTAINER_SIEVERT) {
            @Override
            public void updateScreen() {
                super.updateScreen();
                setHoverTooltips(
                        Component.translatable("epimorphism.universal.desc.sievert", radioactivity));
            }
        };
        var bar_sievert = new ProgressWidget(
                () -> radioactivity / 150D, 39, 46, 118, 6, EPGuiTextures.PROGRESS_BAR_SIEVERT);

        var image_decay_time = new ImageWidget(36, 61, 124, 12, EPGuiTextures.BAR_CONTAINER) {
            @Override
            public void updateScreen() {
                super.updateScreen();
                setHoverTooltips(Component.translatable(
                        "epimorphism.universal.desc.time", "%ds/%ds".formatted(time / 20, initialTime / 20)));
            }
        };
        var bar_decay_time = new ProgressWidget(
                () -> (double) time / initialTime, 39, 64, 118, 6, EPGuiTextures.PROGRESS_BAR_DECAY_TIME);

        group.addWidget(container);
        group.addWidget(slotContainer);
        group.addWidget(bar_sievert);
        group.addWidget(image_sievert);
        group.addWidget(bar_decay_time);
        group.addWidget(image_decay_time);
        return group;
    }

    //////////////////////////////////////
    // **********     Data     **********//
    //////////////////////////////////////
    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    public int getMaxCapacity() {
        return Math.max(1, tier - 2);
    }

    @NotNull @Override
    public Table<IO, RecipeCapability<?>, List<IRecipeHandler<?>>> getCapabilitiesProxy() {
        return proxy;
    }

    @Override
    public void setWorkingEnabled(boolean workingEnabled) {
        super.setWorkingEnabled(workingEnabled);
        onInventoryChanged();
    }
}
