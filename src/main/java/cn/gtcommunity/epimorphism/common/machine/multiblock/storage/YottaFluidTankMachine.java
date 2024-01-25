package cn.gtcommunity.epimorphism.common.machine.multiblock.storage;

import cn.gtcommunity.epimorphism.api.block.ITierGlassType;
import cn.gtcommunity.epimorphism.api.gui.EPGuiTextures;
import cn.gtcommunity.epimorphism.api.machine.ScheduledSubscriptionHandler;
import cn.gtcommunity.epimorphism.api.pattern.utils.containers.FluidTankCellContainer;
import cn.gtcommunity.epimorphism.api.structure.utils.IValueContainer;
import cn.gtcommunity.epimorphism.api.structure.utils.UniverUtil;
import cn.gtcommunity.epimorphism.utils.EPLangUtil;
import cn.gtcommunity.epimorphism.utils.EPMathUtil;
import cn.gtcommunity.epimorphism.utils.EPTransformUtil;
import cn.gtcommunity.epimorphism.utils.EPUniverUtil;
import com.gregtechceu.gtceu.api.capability.recipe.FluidRecipeCapability;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.capability.recipe.IRecipeHandler;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.gui.fancy.*;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.feature.IFancyUIMachine;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IDisplayUIMachine;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiPart;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.trait.MachineTrait;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.ingredient.FluidIngredient;
import com.gregtechceu.gtceu.common.data.GTRecipeCapabilities;
import com.gregtechceu.gtceu.data.recipe.builder.GTRecipeBuilder;
import com.gregtechceu.gtceu.utils.FormattingUtil;
import com.lowdragmc.lowdraglib.gui.modular.ModularUI;
import com.lowdragmc.lowdraglib.gui.widget.*;
import com.lowdragmc.lowdraglib.misc.FluidTransferList;
import com.lowdragmc.lowdraglib.side.fluid.FluidStack;
import com.lowdragmc.lowdraglib.side.fluid.IFluidTransfer;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import com.lowdragmc.lowdraglib.utils.LocalizationUtils;
import it.unimi.dsi.fastutil.longs.Long2ObjectMaps;
import lombok.Getter;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.HoverEvent;
import net.minecraft.network.chat.Style;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.material.Fluid;
import org.jetbrains.annotations.NotNull;

import java.math.BigInteger;
import java.util.*;

public class YottaFluidTankMachine extends WorkableMultiblockMachine implements IFancyUIMachine, IDisplayUIMachine {
    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(YottaFluidTankMachine.class, WorkableMultiblockMachine.MANAGED_FIELD_HOLDER);

    private YottaFluidTank fluidTank;

    @Getter @Persisted
    private boolean isLocked;
    @Getter @Persisted
    private boolean isVoiding;

    private FluidTransferList inputHatches;
    private FluidTransferList outputHatches;

    protected ScheduledSubscriptionHandler tickSubscription;

    public YottaFluidTankMachine(IMachineBlockEntity holder) {
        super(holder);
        this.fluidTank = new YottaFluidTank(this, BigInteger.ZERO);
        this.tickSubscription = new ScheduledSubscriptionHandler(this, this::transferFluid, this::isFormed);
    }

    //////////////////////////////////////
    //***    Multiblock LifeCycle    ***//
    //////////////////////////////////////

    @Override
    public void onStructureFormed() {
        // Determine if the glass tier is greater than the maximum cell tier
        Object data = getMultiblockState().getMatchContext().get("Glass");
        IValueContainer<?> container = getMultiblockState().getMatchContext().getOrCreate("FluidTankCellValue", IValueContainer::noop);
        int glassTier = EPUniverUtil.getOrDefault(() -> data instanceof ITierGlassType,
                () -> ((ITierGlassType) data).tier(), 0);
        int maxTier = EPUniverUtil.getOrDefault(() -> container instanceof FluidTankCellContainer,
                () -> ((FluidTankCellContainer) container).getMaxTier(), 0);
        if (glassTier < maxTier) return;

        super.onStructureFormed();
        // get IO
        List<IFluidTransfer> inputs = new ArrayList<>();
        List<IFluidTransfer> outputs = new ArrayList<>();
        Map<Long, IO> ioMap = getMultiblockState().getMatchContext().getOrCreate("ioMap", Long2ObjectMaps::emptyMap);
        for (IMultiPart part : getParts()) {
            IO io = ioMap.getOrDefault(part.self().getPos().asLong(), IO.BOTH);
            if (io == IO.NONE) continue;
            for (var handler : part.getRecipeHandlers()) {
                var handlerIO = handler.getHandlerIO();
                // If IO not compatible
                if (io != IO.BOTH && handlerIO != IO.BOTH && io != handlerIO) continue;
                if (handler.getCapability() == FluidRecipeCapability.CAP && handler instanceof IFluidTransfer fluidContainer) {
                    if (handlerIO == IO.IN) {
                        inputs.add(fluidContainer);
                    } else if (handlerIO == IO.OUT) {
                        outputs.add(fluidContainer);
                    }
                    traitSubscriptions.add(handler.addChangedListener(tickSubscription::updateSubscription));
                }
            }
        }
        this.inputHatches = new FluidTransferList(inputs);
        this.outputHatches = new FluidTransferList(outputs);

        // get the capacity and initialize the tank
        if (container.getValue() instanceof BigInteger capacity) {
            if (this.fluidTank == null) {
                this.fluidTank = new YottaFluidTank(this, capacity);
            } else {
                this.fluidTank = fluidTank.rebuild(capacity);
            }
        }

        transferFluid();
    }

    @Override
    public void onStructureInvalid() {
        inputHatches = null;
        outputHatches = null;
        super.onStructureInvalid();
    }

    //////////////////////////////////////
    //***        Multiblock UI       ***//
    //////////////////////////////////////

    @Override
    public Widget createUIWidget() {
        var group = new WidgetGroup(0, 0, 170 + 8, 129 + 8);
        var container = new WidgetGroup(4, 4, 170, 129);
        container.addWidget(new DraggableScrollableWidgetGroup(4, 4, 162, 121).setBackground(getScreenTexture())
                .addWidget(new LabelWidget(4, 5, self().getBlockState().getBlock().getDescriptionId()))
                .addWidget(new ComponentPanelWidget(4, 17, this::addDisplayText)
                        .setMaxWidthLimit(150)
                        .clickHandler(this::handleDisplayClick)));
        container.setBackground(GuiTextures.BACKGROUND_INVERSE);
        group.addWidget(container);
        return group;
    }

    @Override
    public ModularUI createUI(Player entityPlayer) {
        return IFancyUIMachine.super.createUI(entityPlayer);
    }

    @Override
    public List<IFancyUIProvider> getSubTabs() {
        return getParts().stream().filter(IFancyUIProvider.class::isInstance).map(IFancyUIProvider.class::cast).toList();
    }

    @Override
    public void attachTooltips(TooltipsPanel tooltipsPanel) {
        for (IMultiPart part : getParts()) {
            part.attachFancyTooltipsToController(this, tooltipsPanel);
        }
    }

    @Override
    public void attachConfigurators(ConfiguratorPanel configuratorPanel) {
        IFancyUIMachine.super.attachConfigurators(configuratorPanel);
        configuratorPanel.attachConfigurators((new IFancyConfiguratorButton.Toggle(
                EPGuiTextures.TOGGLE_BUTTON_LOCK.getSubTexture(0.0, 0.0, 1.0, 0.5),
                EPGuiTextures.TOGGLE_BUTTON_LOCK.getSubTexture(0.0, 0.5, 1.0, 0.5),
                this::isLocked, (clickData, pressed) -> this.setLocked(pressed)))
                .setTooltipsSupplier((pressed) -> List.of(Component.translatable(pressed ? "gtceu.gui.fluid_lock.tooltip.enabled" : "gtceu.gui.fluid_lock.tooltip.disabled"))));
        configuratorPanel.attachConfigurators((new IFancyConfiguratorButton.Toggle(
                EPGuiTextures.TOGGLE_BUTTON_VOID.getSubTexture(0.0, 0.0, 1.0, 0.5),
                EPGuiTextures.TOGGLE_BUTTON_VOID.getSubTexture(0.0, 0.5, 1.0, 0.5),
                this::isVoiding, (clickData, pressed) -> this.setVoiding(pressed)))
                .setTooltipsSupplier((pressed) -> List.of(Component.translatable(pressed ? "gtceu.gui.fluid_voiding_partial.tooltip.enabled" : "gtceu.gui.fluid_voiding_partial.tooltip.disabled"))));
    }

    @Override
    public void addDisplayText(List<Component> textList) {
        IDisplayUIMachine.super.addDisplayText(textList);
        if (isFormed()) {
            if (!isWorkingEnabled()) {
                textList.add(Component.translatable("gtceu.multiblock.work_paused"));

            } else if (isActive()) {
                textList.add(Component.translatable("gtceu.multiblock.running"));
            } else {
                textList.add(Component.translatable("gtceu.multiblock.idling"));
            }

            if (recipeLogic.isWaiting()) {
                textList.add(Component.translatable("gtceu.multiblock.waiting").setStyle(Style.EMPTY.withColor(ChatFormatting.RED)));
            }

            if (fluidTank != null) {
                BigInteger fluidStored = fluidTank.getCurrentStorage();
                BigInteger fluidCapacity = fluidTank.getMaxStorage();
                textList.add(Component.translatable("block.epimorphism.yotta_fluid_tank.fluid", getFluid()));
                textList.add(Component.translatable("block.epimorphism.yotta_fluid_tank.stored", EPLangUtil.abbreviate(fluidStored))
                        .setStyle(Style.EMPTY.withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
                                Component.literal(fluidStored + " L")))));
                textList.add(Component.translatable("block.epimorphism.yotta_fluid_tank.capacity", EPLangUtil.abbreviate(fluidCapacity))
                        .setStyle(Style.EMPTY.withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
                                Component.literal(fluidCapacity + " L")))));
            }
        }
        getDefinition().getAdditionalDisplay().accept(this, textList);
    }

    //////////////////////////////////////
    //***       Multiblock Data      ***//
    //////////////////////////////////////

    public String getStored() {
        if (fluidTank == null) {
            return "0";
        }
        return FormattingUtil.formatNumbers(fluidTank.getCurrentStorage());
    }

    public String getCapacity() {
        if (fluidTank == null) {
            return "0";
        }
        return FormattingUtil.formatNumbers(fluidTank.getMaxStorage());
    }

    public String getFluid() {
        if (fluidTank == null || fluidTank.getCurrentFluid().isSame(EPTransformUtil.getDefaultFluid())) {
            return LocalizationUtils.format("epimorphism.universal.none");
        }

        return EPTransformUtil.fluidToName(fluidTank.getCurrentFluid());
    }

    @Override
    public void setWorkingEnabled(boolean isWorkingAllowed) {
        super.setWorkingEnabled(isWorkingAllowed);
        transferFluid();
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
        if (!isLocked) {
            fluidTank.drain(BigInteger.ZERO);
            getRecipeLogic().setStatus(fluidTank.hasFluid() ? RecipeLogic.Status.WORKING : RecipeLogic.Status.IDLE);
        }
    }

    public void setVoiding(boolean voiding) {
        isVoiding = voiding;
        if (isVoiding) {
            transferFluid();
        }
    }

    @Override
    public @NotNull ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    @Override
    public void loadCustomPersistedData(@NotNull CompoundTag tag) {
        super.loadCustomPersistedData(tag);
        fluidTank.readFromNBT(tag.getCompound("fluidTank"));
    }

    @Override
    public void saveCustomPersistedData(@NotNull CompoundTag tag, boolean forDrop) {
        super.saveCustomPersistedData(tag, forDrop);
        CompoundTag tankTag = fluidTank.writeToNBT(new CompoundTag());
        tag.put("fluidTank", tankTag);
    }

    //////////////////////////////////////
    //***  Multiblock Subscriptions  ***//
    //////////////////////////////////////

    private void transferFluid() {
        if (!getLevel().isClientSide) {
            tickSubscription.unsubscribe();

            if (!(isFormed() && isWorkingEnabled())) return;

            // Bank from Fluid Input Hatches
            FluidStack inputFluidStack;
            if (fluidTank.hasFluid()) {
                var free = isVoiding ? EPMathUtil.LONG_MAX_VALUE : fluidTank.getMaxStorage().subtract(fluidTank.getCurrentStorage());
                inputFluidStack = FluidStack.create(fluidTank.getCurrentFluid(), free.min(EPMathUtil.LONG_MAX_VALUE).longValue());
                List<IRecipeHandler<?>> handlers = UniverUtil.getOrDefault(capabilitiesProxy.get(IO.IN, GTRecipeCapabilities.FLUID), Collections::emptyList);
                List<?> list = List.of(FluidIngredient.of(inputFluidStack));
                for (var handler : handlers) {
                    list = UniverUtil.getOrDefault(handler.handleRecipe(IO.IN, null, list, null, false), Collections::emptyList);
                }

                if (!list.isEmpty()) {
                    inputFluidStack.shrink(((FluidIngredient) list.get(0)).getAmount());
                }

                fluidTank.fill(inputFluidStack.getFluid(), BigInteger.valueOf(inputFluidStack.getAmount()));
            } else {
                inputFluidStack = inputHatches.drain(Long.MAX_VALUE, true);
                if (!EPTransformUtil.isDefaultFluid(inputFluidStack)) {
                    long fluidBanked = fluidTank.fill(inputFluidStack.getFluid(), BigInteger.valueOf(inputFluidStack.getAmount())).longValue();
                    if (fluidBanked != 0) {
                        inputFluidStack.setAmount(fluidBanked);
                        GTRecipeBuilder.ofRaw().inputFluids(inputFluidStack).buildRawRecipe().handleRecipeIO(IO.IN, this);
                    }
                }
            }

            // Debank to Fluid Output Hatches
            FluidStack outputFluidStack = FluidStack.create(fluidTank.getCurrentFluid(), fluidTank.getCurrentStorage().min(EPMathUtil.LONG_MAX_VALUE).longValue());
            if (!EPTransformUtil.isDefaultFluid(outputFluidStack) && outputFluidStack.getAmount() >= 0) {
                List<?> list = List.of(FluidIngredient.of(outputFluidStack));
                List<IRecipeHandler<?>> handlers = UniverUtil.getOrDefault(capabilitiesProxy.get(IO.OUT, GTRecipeCapabilities.FLUID), Collections::emptyList);
                for (var handler : handlers) {
                    list = UniverUtil.getOrDefault(handler.handleRecipe(IO.OUT, null, list, null, false), Collections::emptyList);
                }
                if (!list.isEmpty()) {
                    outputFluidStack.shrink(((FluidIngredient) list.get(0)).getAmount());
                }
                fluidTank.drain(BigInteger.valueOf(outputFluidStack.getAmount()));
            }

            // active here is just used for rendering
            getRecipeLogic().setStatus(fluidTank.hasFluid() ? RecipeLogic.Status.WORKING : RecipeLogic.Status.IDLE);
        }
    }

    //////////////////////////////////////
    //***      Multiblock Traits     ***//
    //////////////////////////////////////

    public class YottaFluidTank extends MachineTrait {

        protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(YottaFluidTankMachine.YottaFluidTank.class);

        private static final String NBT_FLUID = "Yot_Fluid";
        private static final String NBT_STORED = "Yot_Stored";
        private static final String NBT_MAX = "Yot_Max";

        @Getter
        private Fluid currentFluid = EPTransformUtil.getDefaultFluid();
        @Getter
        private BigInteger maxStorage;
        @Getter
        private BigInteger currentStorage = BigInteger.ZERO;
        public YottaFluidTank(MetaMachine machine, BigInteger capacity) {
            super(machine);
            maxStorage = capacity.max(BigInteger.ZERO);
        }

        public void readFromNBT(CompoundTag storageTag) {
            currentFluid = EPTransformUtil.stringToFluid(storageTag.getString(NBT_FLUID));
            currentStorage = new BigInteger(storageTag.getString(NBT_STORED));
            maxStorage = new BigInteger(storageTag.getString(NBT_MAX));
        }

        public CompoundTag writeToNBT(CompoundTag compound) {
            compound.putString(NBT_FLUID, EPTransformUtil.fluidToString(currentFluid));
            compound.putString(NBT_STORED, currentStorage.toString());
            compound.putString(NBT_MAX, maxStorage.toString());
            return compound;
        }

        public BigInteger fill(Fluid fluid, BigInteger amount) {
            if (EPTransformUtil.isDefaultFluid(currentFluid)) {
                currentFluid = fluid;
            }

            if (!currentFluid.isSame(fluid)) {
                return BigInteger.ZERO;
            }

            BigInteger increaseAmount = amount.min(maxStorage.subtract(currentStorage));
            currentStorage = currentStorage.add(increaseAmount);
            return isVoiding ? amount : increaseAmount;
        }

        public BigInteger drain(Fluid fluid, BigInteger amount) {
            if (EPTransformUtil.isDefaultFluid(currentFluid) || !currentFluid.isSame(fluid)) {
                return BigInteger.ZERO;
            }

            BigInteger reduction = currentStorage.min(amount);
            currentStorage = currentStorage.subtract(reduction);
            if (!isLocked && currentStorage.equals(BigInteger.ZERO)) {
                currentFluid = EPTransformUtil.getDefaultFluid();
            }
            return reduction;
        }

        public BigInteger drain(BigInteger amount) {
            return this.drain(currentFluid, amount);
        }

        public boolean hasFluid() {
            return !EPTransformUtil.isDefaultFluid(currentFluid);
        }

        public YottaFluidTank rebuild(@NotNull BigInteger capacity) {
            YottaFluidTank newTank = new YottaFluidTank(this.machine, capacity);
            newTank.fill(currentFluid, currentStorage);
            return newTank;
        }

        @Override
        public ManagedFieldHolder getFieldHolder() {
            return MANAGED_FIELD_HOLDER;
        }
    }
}
