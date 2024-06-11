package com.epimorphismmc.epimorphism.integration.ae2.machine;

import com.epimorphismmc.epimorphism.api.machine.feature.multiblock.ITankProvider;
import com.epimorphismmc.epimorphism.api.machine.trait.ITankTrait;
import com.epimorphismmc.epimorphism.utils.EPFluidUtil;

import appeng.api.config.Actionable;
import appeng.api.stacks.*;
import appeng.api.storage.IStorageMounts;
import appeng.api.storage.IStorageProvider;
import appeng.me.storage.ExternalStorageFacade;

import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.gui.widget.IntInputWidget;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiController;

import com.lowdragmc.lowdraglib.gui.widget.LabelWidget;
import com.lowdragmc.lowdraglib.gui.widget.Widget;
import com.lowdragmc.lowdraglib.gui.widget.WidgetGroup;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import com.lowdragmc.lowdraglib.utils.Position;

import net.minecraft.MethodsReturnNonnullByDefault;

import com.google.common.primitives.Ints;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;

import java.util.Set;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class TankAccessHatchMachine extends MEPartMachine implements IStorageProvider {

    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER =
            new ManagedFieldHolder(TankAccessHatchMachine.class, MEPartMachine.MANAGED_FIELD_HOLDER);

    @Persisted
    @Getter
    @Setter
    private int priority = 0;

    private final TankHandler handler;

    public TankAccessHatchMachine(IMachineBlockEntity holder, Object... args) {
        super(holder, IO.NONE, args);
        this.handler = new TankHandler(null);
        getMainNode().addService(IStorageProvider.class, this);
    }

    //////////////////////////////////////
    // *****     Initialization     *****//
    //////////////////////////////////////

    @Override
    public void addedToController(IMultiController controller) {
        super.addedToController(controller);
        if (controller instanceof ITankProvider tankProvider) {
            handler.setInnerTank(tankProvider.getTank());
        }
        IStorageProvider.requestUpdate(getMainNode());
        updateMEStatus();
    }

    @Override
    public void removedFromController(IMultiController controller) {
        super.removedFromController(controller);
        handler.setInnerTank(null);
        IStorageProvider.requestUpdate(getMainNode());
        updateMEStatus();
    }

    @Override
    protected void update() {
        super.update();
        IStorageProvider.requestUpdate(getMainNode());
    }

    @Override
    public void mountInventories(IStorageMounts storageMounts) {
        storageMounts.mount(this.handler, priority);
    }

    //////////////////////////////////////
    // **********     GUI     ***********//
    //////////////////////////////////////

    @Override
    public Widget createUIWidget() {
        WidgetGroup group = new WidgetGroup(Position.ORIGIN);
        // ME Network status
        group.addWidget(new LabelWidget(
                3,
                0,
                () -> this.isOnline ? "gtceu.gui.me_network.online" : "gtceu.gui.me_network.offline"));

        var widget = new IntInputWidget(new Position(3, 10), this::getPriority, this::setPriority)
                .setMin(Integer.MIN_VALUE);
        group.addWidget(widget);

        return group;
    }

    //////////////////////////////////////
    // **********     Data     **********//
    //////////////////////////////////////
    @Override
    public boolean canShared() {
        return false;
    }

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    //////////////////////////////////////
    // ********    ME Storage    ********//
    //////////////////////////////////////

    private static class TankHandler extends ExternalStorageFacade {

        @Setter
        private ITankTrait innerTank;

        public TankHandler(@Nullable ITankTrait innerTank) {
            super();
            this.innerTank = innerTank;
        }

        @Override
        public int getSlots() {
            return 1;
        }

        @Nullable @Override
        public GenericStack getStackInSlot(int slot) {
            if (innerTank != null) {
                var fluid = innerTank.getFluidInTank(slot);
                if (!fluid.isSame(EPFluidUtil.getDefaultFluid())) {
                    var key = AEFluidKey.of(fluid);
                    return new GenericStack(key, innerTank.getFluidAmountInTank(slot));
                }
            }
            return null;
        }

        @Override
        public AEKeyType getKeyType() {
            return AEKeyType.fluids();
        }

        @Override
        protected int insertExternal(AEKey what, int amount, Actionable mode) {
            if (!(what instanceof AEFluidKey fluidKey) || innerTank == null) {
                return 0;
            }

            return Ints.saturatedCast(innerTank.fill(fluidKey.getFluid(), amount, mode.isSimulate()));
        }

        @Override
        protected int extractExternal(AEKey what, int amount, Actionable mode) {
            if (!(what instanceof AEFluidKey fluidKey) || innerTank == null) {
                return 0;
            }

            return Ints.saturatedCast(innerTank.drain(fluidKey.getFluid(), amount, mode.isSimulate()));
        }

        @Override
        public boolean containsAnyFuzzy(Set<AEKey> keys) {
            if (innerTank == null) return false;

            for (int i = 0; i < innerTank.getTanks(); i++) {
                var fluid = innerTank.getFluidInTank(i);
                if (!fluid.isSame(EPFluidUtil.getDefaultFluid())) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public void getAvailableStacks(KeyCounter out) {
            if (innerTank == null) return;

            for (int i = 0; i < innerTank.getTanks(); i++) {
                var fluid = innerTank.getFluidInTank(i);
                if (!fluid.isSame(EPFluidUtil.getDefaultFluid())) {
                    var key = AEFluidKey.of(fluid);
                    out.add(key, innerTank.getFluidAmountInTank(i));
                }
            }
        }
    }
}
