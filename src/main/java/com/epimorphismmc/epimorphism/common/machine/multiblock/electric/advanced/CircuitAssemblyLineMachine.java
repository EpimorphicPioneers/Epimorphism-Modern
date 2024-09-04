package com.epimorphismmc.epimorphism.common.machine.multiblock.electric.advanced;

import com.epimorphismmc.monomorphism.machine.fancyconfigurator.InventoryFancyConfigurator;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.capability.recipe.IRecipeHandler;
import com.gregtechceu.gtceu.api.capability.recipe.ItemRecipeCapability;
import com.gregtechceu.gtceu.api.gui.fancy.ConfiguratorPanel;
import com.gregtechceu.gtceu.api.gui.fancy.TabsWidget;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiPart;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.trait.NotifiableItemStackHandler;
import com.gregtechceu.gtceu.api.pattern.util.RelativeDirection;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.common.machine.multiblock.part.EnergyHatchPartMachine;
import com.gregtechceu.gtceu.config.ConfigHolder;
import com.gregtechceu.gtceu.utils.ResearchManager;

import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

import lombok.Getter;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

import static com.epimorphismmc.epimorphism.common.data.EPRecipeTypes.*;

public class CircuitAssemblyLineMachine extends WorkableElectricMultiblockMachine {
    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(
            CircuitAssemblyLineMachine.class, WorkableElectricMultiblockMachine.MANAGED_FIELD_HOLDER);

    @Getter
    @Persisted
    protected final NotifiableItemStackHandler templateInventory;

    public CircuitAssemblyLineMachine(IMachineBlockEntity holder, Object... args) {
        super(holder, args);

        templateInventory = new NotifiableItemStackHandler(this, 1, IO.IN, IO.NONE);
        templateInventory.setFilter(ResearchManager::hasResearchTag);
    }

    @Override
    public boolean beforeWorking(@Nullable GTRecipe recipe) {
        if (recipe == null) {
            return false;
        }
        if (!checkResearch(recipe)) {
            return false;
        }
        if (ConfigHolder.INSTANCE.machines.orderedAssemblyLineItems) {
            var recipeInputs = recipe.inputs.get(ItemRecipeCapability.CAP);
            var itemInputInventory = Objects.requireNonNullElseGet(
                            getCapabilitiesProxy().get(IO.IN, ItemRecipeCapability.CAP),
                            Collections::<IRecipeHandler<?>>emptyList)
                    .stream()
                    .filter(handler -> !handler.isProxy())
                    .map(container -> container.getContents().stream()
                            .filter(ItemStack.class::isInstance)
                            .map(ItemStack.class::cast)
                            .toList())
                    .filter(container -> !container.isEmpty())
                    .toList();

            if (itemInputInventory.size() < recipeInputs.size()) return false;

            for (int i = 0; i < recipeInputs.size(); i++) {
                var itemStack = itemInputInventory.get(i).get(0);
                Ingredient recipeStack = ItemRecipeCapability.CAP.of(recipeInputs.get(i).content);
                if (!recipeStack.test(itemStack)) {
                    return false;
                }
            }
        }
        return super.beforeWorking(recipe);
    }

    public boolean checkResearch(GTRecipe recipe) {
        var researchData = ResearchManager.readResearchId(templateInventory.getStackInSlot(0));
        if (researchData == null) {
            return false;
        }
        if (researchData.getFirst() != CIRCUIT_ASSEMBLY_LINE_RECIPES) {
            return false;
        }
        Collection<GTRecipe> recipes =
                researchData.getFirst().getDataStickEntry(researchData.getSecond());
        if (recipes == null) {
            return false;
        }
        return recipes.contains(recipe);
    }

    @Override
    public void onStructureFormed() {
        getDefinition().setPartSorter(Comparator.comparing(it -> multiblockPartSorter()
                .apply(it.self().getPos())));
        super.onStructureFormed();
    }

    private Function<BlockPos, Integer> multiblockPartSorter() {
        return RelativeDirection.RIGHT.getSorter(getFrontFacing(), getUpwardsFacing(), isFlipped());
    }

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    @Override
    public void attachConfigurators(ConfiguratorPanel configuratorPanel) {
        configuratorPanel.attachConfigurators(
                new InventoryFancyConfigurator(templateInventory.storage, Component.literal(""))
                        .setTooltips(List.of(
                                Component.translatable("gui.epimorphism.circuit_assembly_line.template.desc.0"),
                                Component.translatable("gui.epimorphism.circuit_assembly_line.template.desc.1"))));
        super.attachConfigurators(configuratorPanel);
    }

    @Override
    public void attachSideTabs(TabsWidget sideTabs) {
        super.attachSideTabs(sideTabs);
    }

    //////////////////////////////////////
    // ***      Multiblock Render     ***//
    //////////////////////////////////////

    public static ResourceLocation getBaseTexture(IMultiPart iMultiPart) {
        if (iMultiPart instanceof EnergyHatchPartMachine hatch
                && hatch.energyContainer.getHandlerIO() == IO.IN) {
            return GTCEu.id("block/casings/pipe/machine_casing_grate");
        }
        return GTCEu.id("block/casings/solid/machine_casing_solid_steel");
    }
}
