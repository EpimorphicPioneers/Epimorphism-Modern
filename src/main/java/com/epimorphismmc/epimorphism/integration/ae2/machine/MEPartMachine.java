package com.epimorphismmc.epimorphism.integration.ae2.machine;

import appeng.api.networking.GridFlags;
import appeng.api.networking.IGrid;
import appeng.api.networking.IInWorldGridNodeHost;
import appeng.api.networking.IManagedGridNode;
import appeng.api.networking.security.IActionSource;
import appeng.me.helpers.BlockEntityNodeListener;
import appeng.me.helpers.IGridConnectedBlockEntity;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.TickableSubscription;
import com.gregtechceu.gtceu.api.machine.multiblock.part.TieredIOPartMachine;
import com.gregtechceu.gtceu.config.ConfigHolder;
import com.gregtechceu.gtceu.integration.ae2.util.SerializableManagedGridNode;

import com.lowdragmc.lowdraglib.syncdata.annotation.DescSynced;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.annotation.ReadOnlyManaged;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.TickTask;
import net.minecraft.server.level.ServerLevel;

import lombok.Getter;

import java.util.EnumSet;

import javax.annotation.ParametersAreNonnullByDefault;

import static com.gregtechceu.gtceu.integration.ae2.machine.MEBusPartMachine.ME_UPDATE_INTERVAL;

@SuppressWarnings("unused")
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class MEPartMachine extends TieredIOPartMachine
        implements IInWorldGridNodeHost, IGridConnectedBlockEntity {
    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER =
            new ManagedFieldHolder(MEPartMachine.class, TieredIOPartMachine.MANAGED_FIELD_HOLDER);

    @Getter
    @Persisted
    @ReadOnlyManaged(
            onDirtyMethod = "onGridNodeDirty",
            serializeMethod = "serializeGridNode",
            deserializeMethod = "deserializeGridNode")
    private final SerializableManagedGridNode mainNode =
            (SerializableManagedGridNode) createMainNode()
                    .setFlags(GridFlags.REQUIRE_CHANNEL)
                    .setVisualRepresentation(getDefinition().getItem())
                    .setIdlePowerUsage(ConfigHolder.INSTANCE.compat.ae2.meHatchEnergyUsage)
                    .setInWorldNode(true)
                    .setExposedOnSides(
                            this.hasFrontFacing()
                                    ? EnumSet.of(this.getFrontFacing())
                                    : EnumSet.allOf(Direction.class))
                    .setTagName("proxy");

    protected final IActionSource actionSource = IActionSource.ofMachine(mainNode::getNode);

    @DescSynced
    protected boolean isOnline;

    private IGrid aeProxy;

    private TickableSubscription updateSubs;

    public MEPartMachine(IMachineBlockEntity holder, IO io, Object... args) {
        super(holder, GTValues.UHV, io);
    }

    protected boolean shouldSyncME() {
        return this.getOffsetTimer() % ME_UPDATE_INTERVAL == 0;
    }

    @Override
    public void setFrontFacing(Direction facing) {
        super.setFrontFacing(facing);
        if (isFacingValid(facing)) {
            this.mainNode.setExposedOnSides(
                    this.hasFrontFacing() ? EnumSet.of(facing) : EnumSet.allOf(Direction.class));
        }
    }

    /**
     * Update me network connection status.
     * @return the updated status.
     */
    public boolean updateMEStatus() {
        if (this.aeProxy == null) {
            this.aeProxy = this.mainNode.getGrid();
        }
        if (this.aeProxy != null) {
            this.isOnline = this.mainNode.isOnline() && this.mainNode.isPowered();
        } else {
            this.isOnline = false;
        }
        return this.isOnline;
    }

    protected void updateTankSubscription() {
        if (getLevel() != null) {
            updateSubs = subscribeServerTick(updateSubs, this::update);
        } else if (updateSubs != null) {
            updateSubs.unsubscribe();
            updateSubs = null;
        }
    }

    protected void update() {}

    protected IManagedGridNode createMainNode() {
        return new SerializableManagedGridNode(this, BlockEntityNodeListener.INSTANCE);
    }

    @Override
    public void saveChanges() {
        this.onChanged();
    }

    @Override
    public void onChanged() {
        super.onChanged();
        this.updateTankSubscription();
    }

    @Override
    public void onLoad() {
        super.onLoad();
        if (getLevel() instanceof ServerLevel serverLevel) {
            serverLevel.getServer().tell(new TickTask(0, this::createManagedNode));
        }
    }

    @Override
    public void onUnload() {
        super.onUnload();
        mainNode.destroy();
    }

    protected void createManagedNode() {
        this.mainNode.create(this.getLevel(), this.getPos());
    }

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    public boolean onGridNodeDirty(SerializableManagedGridNode node) {
        return node != null && node.isActive() && node.isOnline();
    }

    public CompoundTag serializeGridNode(SerializableManagedGridNode node) {
        return node.serializeNBT();
    }

    public SerializableManagedGridNode deserializeGridNode(CompoundTag tag) {
        this.mainNode.deserializeNBT(tag);
        return this.mainNode;
    }
}
