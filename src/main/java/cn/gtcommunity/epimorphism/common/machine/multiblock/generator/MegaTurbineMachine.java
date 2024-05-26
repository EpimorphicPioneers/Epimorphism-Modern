package cn.gtcommunity.epimorphism.common.machine.multiblock.generator;

import cn.gtcommunity.epimorphism.api.gui.EPGuiTextures;
import cn.gtcommunity.epimorphism.api.machine.feature.multiblock.IReinforcedRotorHolder;
import cn.gtcommunity.epimorphism.utils.EPUtil;
import com.epimorphismmc.monomorphism.utility.MOTransferUtils;
import com.epimorphismmc.monomorphism.utility.MOUtils;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.recipe.EURecipeCapability;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.capability.recipe.ItemRecipeCapability;
import com.gregtechceu.gtceu.api.capability.recipe.RecipeCapability;
import com.gregtechceu.gtceu.api.gui.fancy.ConfiguratorPanel;
import com.gregtechceu.gtceu.api.gui.fancy.IFancyConfiguratorButton;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.TickableSubscription;
import com.gregtechceu.gtceu.api.machine.feature.ITieredMachine;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMaintenanceMachine;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiPart;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.RecipeHelper;
import com.gregtechceu.gtceu.api.recipe.content.Content;
import com.gregtechceu.gtceu.common.data.GTRecipeModifiers;
import com.gregtechceu.gtceu.common.item.TurbineRotorBehaviour;
import com.gregtechceu.gtceu.config.ConfigHolder;
import com.gregtechceu.gtceu.utils.FormattingUtil;
import com.gregtechceu.gtceu.utils.GTUtil;
import com.lowdragmc.lowdraglib.misc.ItemTransferList;
import com.lowdragmc.lowdraglib.side.item.IItemTransfer;
import com.lowdragmc.lowdraglib.syncdata.annotation.DescSynced;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import it.unimi.dsi.fastutil.longs.Long2ObjectMaps;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.ChatFormatting;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.*;
import java.util.stream.Collectors;

import static com.gregtechceu.gtceu.api.machine.feature.multiblock.IRotorHolderMachine.*;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class MegaTurbineMachine extends WorkableElectricMultiblockMachine implements ITieredMachine {

    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(MegaTurbineMachine.class, WorkableElectricMultiblockMachine.MANAGED_FIELD_HOLDER);

    public static final int MIN_DURABILITY_TO_WARN = 10;

    private final int baseEUOutput;
    @Getter
    private final int tier;
    private long excessVoltage;
    @Getter
    private int rotorTier;
    @Getter @Setter
    @Persisted @DescSynced
    private int rotorSpeed;
    @Persisted
    @Setter @Getter
    private boolean isHighSpeedMode;
    @Setter @Getter
    private boolean isInvUpdate = true;

    private ItemTransferList inputBuses;
    private Set<IReinforcedRotorHolder> rotorHolders;
    @Nullable
    protected TickableSubscription rotorSpeedSubs;
    @Nullable
    private TickableSubscription setRotorSubs;

    public MegaTurbineMachine(IMachineBlockEntity holder, int tier) {
        super(holder);
        this.tier = tier;
        this.baseEUOutput = (int) GTValues.V[tier] * 2;
    }

    //////////////////////////////////////
    //***    Multiblock LifeCycle    ***//
    //////////////////////////////////////

    @Override
    public void onStructureFormed() {
        super.onStructureFormed();
        int tier = GTValues.MAX + 1;
        List<IItemTransfer> inputs = new ArrayList<>();
        Map<Long, IO> ioMap = getMultiblockState().getMatchContext().getOrCreate("ioMap", Long2ObjectMaps::emptyMap);
        for (IMultiPart part : getParts()) {
            if (part instanceof IReinforcedRotorHolder rotorHolder) {
                rotorHolders = Objects.requireNonNullElseGet(rotorHolders, HashSet::new);
                rotorHolders.add(rotorHolder);
                tier = Math.min(tier, rotorHolder.getTier());
            }

            IO io = ioMap.getOrDefault(part.self().getPos().asLong(), IO.BOTH);
            if (io == IO.NONE) continue;
            for (var handler : part.getRecipeHandlers()) {
                var handlerIO = handler.getHandlerIO();
                // If IO not compatible
                if (io != IO.BOTH && handlerIO != IO.BOTH && io != handlerIO) continue;

                if (handler.getCapability() == ItemRecipeCapability.CAP && handler instanceof IItemTransfer itemTransfer) {
                    if (handlerIO == IO.IN || handlerIO == IO.BOTH) {
                        traitSubscriptions.add(handler.addChangedListener(this::onInventoryChanged));
                        inputs.add(itemTransfer);
                    }
                }
            }
        }
        this.inputBuses = new ItemTransferList(inputs);
        this.rotorTier = tier != GTValues.MAX + 1 ? tier : 0;
    }

    @Override
    public void onStructureInvalid() {
        super.onStructureInvalid();
        this.rotorHolders = null;
    }

    @Override
    public void onLoad() {
        super.onLoad();
        if (!isRemote()) {
            updateRotorSubscription();
        }
    }

    //////////////////////////////////////
    //******     Recipe Logic    *******//
    //////////////////////////////////////

    @Override
    protected @Nullable GTRecipe getRealRecipe(GTRecipe recipe) {
        var EUt = RecipeHelper.getOutputEUt(recipe);
        if (checkRotor() && EUt > 0) {
            long turbineMaxVoltage = getOverclockVoltage();
            if (excessVoltage >= turbineMaxVoltage) {
                excessVoltage -= turbineMaxVoltage;
            } else {
                double holderEfficiency = getTotalEfficiency() / 100.0;
                //get the amount of parallel required to match the desired output voltage
                int maxParallel = (int) ((turbineMaxVoltage - excessVoltage) / (EUt * holderEfficiency));
                //this is necessary to prevent over-consumption of fuel
                excessVoltage += (long) (maxParallel * EUt * holderEfficiency - turbineMaxVoltage);
                var parallelResult = GTRecipeModifiers.fastParallel(this, recipe, Math.max(1, maxParallel), false);
                recipe = parallelResult.getFirst() == recipe ? recipe.copy() : parallelResult.getFirst();
                long eut = boostProduction((long) (EUt * holderEfficiency * parallelResult.getSecond()));
                recipe.tickOutputs.put(EURecipeCapability.CAP, List.of(new Content(eut, 1.0f, 0.0f, null, null)));
                return recipe;
            }
        }
        return null;
    }

    @Override
    public boolean alwaysTryModifyRecipe() {
        return true;
    }

    @Override
    public boolean dampingWhenWaiting() {
        return false;
    }

    @Override
    public boolean canVoidRecipeOutputs(RecipeCapability<?> capability) {
        return capability != EURecipeCapability.CAP;
    }

    @Override
    public boolean onWorking() {
        if (getRotorSpeed() < getMaxRotorHolderSpeed()) {
            setRotorSpeed(getRotorSpeed() + SPEED_INCREMENT);
            updateRotorSubscription();
        }

        if (getOffsetTimer() % 20 == 0) {
            var numMaintenanceProblems = getParts().stream()
                    .filter(IMaintenanceMachine.class::isInstance)
                    .map(IMaintenanceMachine.class::cast)
                    .findFirst()
                    .map(IMaintenanceMachine::getNumMaintenanceProblems)
                    .orElse(0);
            rotorHolders.forEach(holder -> holder.damageRotor((isHighSpeedMode() ? 12 : 1) * (1 + numMaintenanceProblems)));
        }
        return super.onWorking();
    }

    @Override
    public void afterWorking() {
        for (IMultiPart part : getParts()) {
            if (isHighSpeedMode() && part instanceof IMaintenanceMachine maintenanceMachine) {
                if (ConfigHolder.INSTANCE.machines.enableMaintenance) {
                    maintenanceMachine.calculateMaintenance(maintenanceMachine, 12 * getRecipeLogic().getProgress());
                    if (maintenanceMachine.hasMaintenanceProblems()) {
                        getRecipeLogic().markLastRecipeDirty();
                    }
                }
                continue;
            }
            part.afterWorking(this);
        }
    }

    protected long boostProduction(long production) {
        if (hasRotor()) {
            int maxSpeed = getMaxRotorHolderSpeed();
            int currentSpeed = getRotorSpeed();
            if (currentSpeed >= maxSpeed)
                return production;
            return (long) (production * Math.pow(1.0 * currentSpeed / maxSpeed, 2));
        }
        return 0;
    }

    //////////////////////////////////////
    //***        Multiblock UI       ***//
    //////////////////////////////////////

    @Override
    public void addDisplayText(List<Component> textList) {
        super.addDisplayText(textList);
        if (isFormed()) {
            if (rotorHolders != null && !rotorHolders.isEmpty() && getRotorEfficiency() > 0) {
                textList.add(Component.translatable("gtceu.multiblock.turbine.rotor_speed", FormattingUtil.formatNumbers(getRotorSpeed()), FormattingUtil.formatNumbers(getMaxRotorHolderSpeed())));
                textList.add(Component.translatable("gtceu.multiblock.turbine.efficiency", getTotalEfficiency()));

                long maxProduction = getOverclockVoltage();
                long currentProduction = isActive() ? boostProduction((int) maxProduction) : 0;
                String voltageName = GTValues.VNF[GTUtil.getTierByVoltage(currentProduction)];

                if (isActive()) {
                    textList.add(3, Component.translatable("gtceu.multiblock.turbine.energy_per_tick", FormattingUtil.formatNumbers(currentProduction), voltageName));
                }

                int rotorDurability = getRotorDurabilityPercent();
                if (rotorDurability > MIN_DURABILITY_TO_WARN) {
                    textList.add(Component.translatable("gtceu.multiblock.turbine.rotor_durability", rotorDurability));
                } else {
                    textList.add(Component.translatable("gtceu.multiblock.turbine.rotor_durability", rotorDurability).setStyle(Style.EMPTY.withColor(ChatFormatting.RED)));
                }
            }
        }
    }

    @Override
    public void attachConfigurators(ConfiguratorPanel configuratorPanel) {
        super.attachConfigurators(configuratorPanel);
        configuratorPanel.attachConfigurators((new IFancyConfiguratorButton.Toggle(
                EPGuiTextures.TOGGLE_BUTTON_HIGH_SPEED.getSubTexture(0.0, 0.0, 1.0, 0.5),
                EPGuiTextures.TOGGLE_BUTTON_HIGH_SPEED.getSubTexture(0.0, 0.5, 1.0, 0.5),
                this::isHighSpeedMode, (clickData, pressed) -> this.setHighSpeedMode(pressed)))
                .setTooltipsSupplier(pressed -> List.of(Component.translatable(pressed ? "gui.epimorphism.high_speed.desc.enabled" : "gui.epimorphism.high_speed.desc.disabled"))));
    }

    //////////////////////////////////////
    //***  Multiblock Subscriptions  ***//
    //////////////////////////////////////

    protected void updateRotorSubscription() {
        if (getRotorSpeed() > 0) {
            rotorSpeedSubs = subscribeServerTick(rotorSpeedSubs, this::updateRotorSpeed);
        } else if (rotorSpeedSubs != null) {
            rotorSpeedSubs.unsubscribe();
            rotorSpeedSubs = null;
        }
    }

    private void updateRotorSpeed() {
        if (isActive()) return;
        setupRotors();
        if (!hasRotor()) {
            setRotorSpeed(0);
        } else if (getRotorSpeed() > 0) {
            setRotorSpeed(Math.max(0, getRotorSpeed() - SPEED_DECREMENT));
        }
        updateRotorSubscription();
    }

    private void onInventoryChanged() {
        setInvUpdate(true);
        if (rotorSpeedSubs == null) {
            setRotorSubs = subscribeServerTick(setRotorSubs, this::setupRotors);
        } else unsubscribe();
    }

    protected void setupRotors() {
        if (isInvUpdate() && !hasRotor()) {
            for (int index = 0; index < inputBuses.getSlots(); index++) {
                ItemStack itemStack = inputBuses.getStackInSlot(index);
                if (itemStack.isEmpty()) continue;

                if (TurbineRotorBehaviour.getBehaviour(itemStack) == null) continue;

                for (IReinforcedRotorHolder holder : rotorHolders) {
                    if (!holder.hasRotor()) {
                        var stack = MOTransferUtils.extractItemAccountNotifiableList(inputBuses, index, 1, false);
                        holder.setRotorStack(stack);
                        break;
                    }
                }
            }
        }
        unsubscribe();
        setInvUpdate(false);
    }

    private void unsubscribe() {
        if (setRotorSubs != null) {
            setRotorSubs.unsubscribe();
            setRotorSubs = null;
        }
    }

    //////////////////////////////////////
    //***       Multiblock Data      ***//
    //////////////////////////////////////

    @Override
    public long getOverclockVoltage() {
        if (hasRotor())
            return (long) (isHighSpeedMode() ? 3 : 1) * baseEUOutput * getTotalPower() / 100;
        return 0;
    }

    public boolean hasRotor() {
        if (rotorHolders == null || rotorHolders.isEmpty()) return false;
        return rotorHolders.stream().allMatch(IReinforcedRotorHolder::hasRotor);
    }

    public boolean checkRotor() {
        return rotorHolders.stream()
                .map(IReinforcedRotorHolder::getRotorMaterial)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet()).size() == 1;
    }

    public int getMaxRotorHolderSpeed() {
        return 2000 + 1000 * getRotorTier();
    }

    public int getTotalEfficiency() {
        return rotorHolders.stream().mapToInt(IReinforcedRotorHolder::getTotalEfficiency).min().orElse(-1);
    }
    public int getRotorEfficiency() {
        return rotorHolders.stream().mapToInt(IReinforcedRotorHolder::getRotorEfficiency).min().orElse(-1);
    }
    public int getRotorDurabilityPercent() {
        return rotorHolders.stream().mapToInt(IReinforcedRotorHolder::getRotorDurabilityPercent).min().orElse(-1);
    }
    public int getTotalPower() {
        return rotorHolders.stream().mapToInt(IReinforcedRotorHolder::getTotalPower).min().orElse(-1);
    }

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

}
