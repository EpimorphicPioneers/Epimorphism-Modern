package cn.gtcommunity.epimorphism.common.machine.multiblock.part;

import com.google.common.collect.Table;
import com.google.common.collect.Tables;
import com.gregtechceu.gtceu.api.capability.recipe.*;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.TickableSubscription;
import com.gregtechceu.gtceu.api.machine.multiblock.part.TieredPartMachine;
import com.gregtechceu.gtceu.api.machine.trait.NotifiableItemStackHandler;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.lowdragmc.lowdraglib.Platform;
import com.lowdragmc.lowdraglib.gui.widget.SlotWidget;
import com.lowdragmc.lowdraglib.gui.widget.Widget;
import com.lowdragmc.lowdraglib.gui.widget.WidgetGroup;
import com.lowdragmc.lowdraglib.syncdata.ISubscription;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import lombok.Getter;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.server.TickTask;
import net.minecraft.server.level.ServerLevel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.*;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class RadiationHatchMachine extends TieredPartMachine implements IRecipeCapabilityHolder {
    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(RadiationHatchMachine.class, TieredPartMachine.MANAGED_FIELD_HOLDER);

    private final Table<IO, RecipeCapability<?>, List<IRecipeHandler<?>>> proxy;

    @Persisted
    public final NotifiableItemStackHandler inventory;
    @Getter @Persisted
    private int mass;
    @Getter @Persisted
    private int initialRadioactivity;
    @Getter @Persisted
    private int radioactivity;
    @Getter @Persisted
    private int initialTime;
    @Getter @Persisted
    private int time;

    @Nullable
    protected TickableSubscription AttenuationSubs;
    @Nullable
    protected ISubscription inventorySubs;

    public RadiationHatchMachine(IMachineBlockEntity holder, int tier) {
        super(holder, tier);
        this.inventory = new NotifiableItemStackHandler(this, 1, IO.IN, IO.BOTH);
        this.proxy = Tables.newCustomTable(new EnumMap<>(IO.class), HashMap::new);
        proxy.put(IO.IN, ItemRecipeCapability.CAP, List.of(inventory));
    }

    //////////////////////////////////////
    //*****     Initialization    ******//
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
        if (getTime() > 0 || getMass() > 0) return;

        var recipeTypes = getDefinition().getRecipeTypes();
        if (recipeTypes != null && !isRemote()) {
            var recipeType = recipeTypes.length > 0 ? recipeTypes[0] : GTRecipeTypes.DUMMY_RECIPES;
            var recipes = recipeType.searchRecipe(Platform.getMinecraftServer().getRecipeManager(), this);
        }
    }

    protected void updateAttenuationSubscription() {
        if (getTime() > 0 || getMass() > 0) {
            AttenuationSubs = subscribeServerTick(AttenuationSubs, this::updateTime);
        } else if (AttenuationSubs != null) {
            AttenuationSubs.unsubscribe();
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
    //**********     GUI     ***********//
    //////////////////////////////////////
    @Override
    public Widget createUIWidget() {
        var group = new WidgetGroup(0, 0, 18 + 16, 18 + 16);
        var container = new WidgetGroup(4, 4, 18 + 8, 18 + 8);
        container.addWidget(new SlotWidget(inventory.storage, 0, 4, 4, true, true)
                .setBackground(GuiTextures.SLOT));
        container.setBackground(GuiTextures.BACKGROUND_INVERSE);
        group.addWidget(container);
        return group;
    }

    //////////////////////////////////////
    //**********     Data     **********//
    //////////////////////////////////////
    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    public int getMaxCapacity() {
        return Math.max(1, tier - 2);
    }

    @NotNull
    @Override
    public Table<IO, RecipeCapability<?>, List<IRecipeHandler<?>>> getCapabilitiesProxy() {
        return proxy;
    }
}
