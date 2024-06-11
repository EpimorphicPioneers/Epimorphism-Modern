package com.epimorphismmc.epimorphism.common.data;

import com.epimorphismmc.epimorphism.api.gui.EPGuiTextures;
import com.epimorphismmc.epimorphism.api.recipe.GeneralRecipeType;
import com.epimorphismmc.epimorphism.api.recipe.SlotNames;

import com.epimorphismmc.monomorphism.gui.utils.MOWidgetUtil;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.block.ICoilType;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.capability.recipe.ItemRecipeCapability;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.gui.WidgetUtils;
import com.gregtechceu.gtceu.api.recipe.GTRecipeSerializer;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.api.registry.GTRegistries;
import com.gregtechceu.gtceu.common.data.GTSoundEntries;

import com.lowdragmc.lowdraglib.gui.texture.ProgressTexture;
import com.lowdragmc.lowdraglib.gui.widget.SlotWidget;
import com.lowdragmc.lowdraglib.utils.CycleItemStackHandler;
import com.lowdragmc.lowdraglib.utils.LocalizationUtils;

import net.minecraft.ChatFormatting;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

import static com.epimorphismmc.epimorphism.common.machine.multiblock.electric.advanced.GeneralProcessingPlantMachine.RECIPE_MAP;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;
import static com.lowdragmc.lowdraglib.gui.texture.ProgressTexture.FillDirection.*;

public class EPRecipeTypes {
    public static final String LIST = "list";

    //////////////////////////////////////
    // *******     Multiblock     *******//
    //////////////////////////////////////
    public static final GTRecipeType NEUTRON_ACTIVATOR_RECIPES = register(
                    "neutron_activator", MULTIBLOCK)
            .setMaxIOSize(6, 6, 1, 1)
            .setSound(GTSoundEntries.FURNACE);

    public static final GTRecipeType COMPONENT_ASSEMBLY_LINE_RECIPES = register(
                    "component_assembly_line", MULTIBLOCK)
            .setMaxIOSize(12, 1, 12, 0)
            .setEUIO(IO.IN)
            .setMaxTooltips(4)
            .setSound(GTSoundEntries.ASSEMBLER);

    public static final GTRecipeType CVD_RECIPES = register("cvd", MULTIBLOCK)
            .setMaxIOSize(2, 2, 3, 3)
            .setEUIO(IO.IN)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.COOLING);

    public static final GTRecipeType PLASMA_CVD_RECIPES = register("plasma_cvd", MULTIBLOCK)
            .setMaxIOSize(2, 2, 3, 3)
            .setEUIO(IO.IN)
            .setProgressBar(GuiTextures.PROGRESS_BAR_FUSION, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.COOLING);

    public static final GTRecipeType LASER_CVD_RECIPES = register("laser_cvd", MULTIBLOCK)
            .setMaxIOSize(2, 2, 3, 3)
            .setEUIO(IO.IN)
            .setProgressBar(EPGuiTextures.PROGRESS_BAR_NANOSCALE, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.COOLING);

    public static final GTRecipeType MOLECULAR_BEAM_RECIPES = register("molecular_beam", MULTIBLOCK)
            .setMaxIOSize(5, 1, 2, 1)
            .setEUIO(IO.IN)
            .setSlotOverlay(false, false, false, EPGuiTextures.NANOSCALE_OVERLAY_1)
            .setSlotOverlay(false, false, true, EPGuiTextures.NANOSCALE_OVERLAY_1)
            .setSlotOverlay(false, true, false, EPGuiTextures.NANOSCALE_OVERLAY_2)
            .setSlotOverlay(false, true, true, EPGuiTextures.NANOSCALE_OVERLAY_2)
            .setSlotOverlay(true, false, true, EPGuiTextures.NANOSCALE_OVERLAY_1)
            .setSlotOverlay(true, true, true, EPGuiTextures.NANOSCALE_OVERLAY_2)
            .setProgressBar(EPGuiTextures.PROGRESS_BAR_NANOSCALE, LEFT_TO_RIGHT)
            .setMaxTooltips(4)
            .setSound(GTSoundEntries.ELECTROLYZER);

    public static final GTRecipeType CRYSTALLIZATION_RECIPES = register("crystallization", MULTIBLOCK)
            .setMaxIOSize(6, 1, 3, 0)
            .setEUIO(IO.IN)
            .setProgressBar(GuiTextures.PROGRESS_BAR_CRYSTALLIZATION, LEFT_TO_RIGHT)
            .addDataInfo(data -> {
                int temp = data.getInt("ebf_temp");
                return LocalizationUtils.format("gtceu.recipe.temperature", temp);
            })
            .addDataInfo(data -> {
                int temp = data.getInt("ebf_temp");
                ICoilType requiredCoil = ICoilType.getMinRequiredType(temp);

                if (requiredCoil != null && requiredCoil.getMaterial() != null) {
                    return LocalizationUtils.format(
                            "gtceu.recipe.coil.tier", I18n.get(requiredCoil.getMaterial().getUnlocalizedName()));
                }
                return "";
            })
            .setUiBuilder((recipe, widgetGroup) -> {
                int temp = recipe.data.getInt("ebf_temp");
                List<List<ItemStack>> items = new ArrayList<>();
                items.add(GTCEuAPI.HEATING_COILS.entrySet().stream()
                        .filter(coil -> coil.getKey().getCoilTemperature() >= temp)
                        .map(coil -> new ItemStack(coil.getValue().get()))
                        .toList());
                widgetGroup.addWidget(new SlotWidget(
                        new CycleItemStackHandler(items),
                        0,
                        widgetGroup.getSize().width - 25,
                        widgetGroup.getSize().height - 32,
                        false,
                        false));
            })
            .setSound(GTSoundEntries.FURNACE);

    public static final GTRecipeType CHEMICAL_PLANT_RECIPES = register("chemical_plant", MULTIBLOCK)
            .setMaxIOSize(4, 4, 4, 2)
            .setEUIO(IO.IN)
            .setUiBuilder((recipe, widgetGroup) -> {
                var contents = recipe.getInputContents(ItemRecipeCapability.CAP);
                var widgets = WidgetUtils.getWidgetsById(
                        widgetGroup, "^%s_[0-9]+$".formatted(ItemRecipeCapability.CAP.slotName(IO.IN)));
                for (int i = 0; i < contents.size(); i++) {
                    var content = contents.get(i);
                    var name = content.slotName;
                    if (widgets.get(i) instanceof SlotWidget slot
                            && name != null
                            && name.equals(SlotNames.CATALYST)) {
                        slot.addTooltipCallback(components -> {
                            components.add(Component.translatable("gui.epimorphism.catalyst.desc.0")
                                    .withStyle(ChatFormatting.RED));
                            components.add(Component.translatable("gui.epimorphism.catalyst.desc.1"));
                        });
                        slot.setOverlay(MOWidgetUtil.createTextOverlay("gui.epimorphism.content.catalyst"));
                    }
                }
            })
            .setMaxTooltips(4)
            .setSound(GTSoundEntries.CHEMICAL);

    public static final GTRecipeType CATALYTIC_REFORMER_RECIPES = register(
                    "catalytic_reformer", MULTIBLOCK)
            .setMaxIOSize(1, 0, 1, 4)
            .setEUIO(IO.IN)
            .setProgressBar(GuiTextures.PROGRESS_BAR_CRACKING, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.FURNACE);

    public static final GTRecipeType CRYOGENIC_REACTOR_RECIPES = register(
                    "cryogenic_reactor", MULTIBLOCK)
            .setMaxIOSize(3, 2, 2, 2)
            .setEUIO(IO.IN)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.COOLING);

    public static final GTRecipeType BURNER_REACTOR_RECIPES = register("burner_reactor", MULTIBLOCK)
            .setMaxIOSize(3, 3, 3, 3)
            .setEUIO(IO.IN)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARC_FURNACE, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.ARC);

    public static final GTRecipeType FERMENTATION_TANK_RECIPES = register(
                    "fermentation_tank", MULTIBLOCK)
            .setMaxIOSize(3, 2, 3, 2)
            .setEUIO(IO.IN)
            .setSound(GTSoundEntries.CHEMICAL);

    public static final GTRecipeType PRECISE_ASSEMBLER_RECIPES = register(
                    "precise_assembler", MULTIBLOCK)
            .setMaxIOSize(4, 1, 4, 0)
            .setEUIO(IO.IN)
            .setMaxTooltips(4)
            .setSound(GTSoundEntries.ASSEMBLER);

    public static final GTRecipeType ROASTER_RECIPES = register("roaster", MULTIBLOCK)
            .setMaxIOSize(2, 4, 2, 2)
            .setEUIO(IO.IN)
            .setSound(GTSoundEntries.FURNACE);

    public static final GTRecipeType NANO_FORGE_RECIPES = register("nano_forge", MULTIBLOCK)
            .setMaxIOSize(6, 2, 3, 0)
            .setEUIO(IO.IN)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.FURNACE);

    public static final GTRecipeType DRILLING_RECIPES = register("industrial_drill", MULTIBLOCK)
            .setMaxIOSize(1, 1, 0, 1)
            .setEUIO(IO.IN)
            .setSlotOverlay(false, false, true, GuiTextures.CRUSHED_ORE_OVERLAY)
            .setSlotOverlay(true, false, true, GuiTextures.DUST_OVERLAY)
            .setSound(GTSoundEntries.MACERATOR);

    public static final GTRecipeType DIGESTER_RECIPES = register("digester", MULTIBLOCK)
            .setMaxIOSize(1, 1, 1, 1)
            .setEUIO(IO.IN)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.CHEMICAL);

    public static final GTRecipeType ORE_MILLING_RECIPES = register("ore_milling", MULTIBLOCK)
            .setMaxIOSize(1, 1, 0, 0)
            .setEUIO(IO.IN)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.FORGE_HAMMER);

    public static final GTRecipeType VACUUM_DRYING_FURNACE_RECIPES = register(
                    "vacuum_drying_furnace", MULTIBLOCK)
            .setMaxIOSize(1, 9, 2, 3)
            .setEUIO(IO.IN)
            .addDataInfo(data -> {
                int temp = data.getInt("ebf_temp");
                return LocalizationUtils.format("gtceu.recipe.temperature", temp);
            })
            .addDataInfo(data -> {
                int temp = data.getInt("ebf_temp");
                ICoilType requiredCoil = ICoilType.getMinRequiredType(temp);

                if (requiredCoil != null && requiredCoil.getMaterial() != null) {
                    return LocalizationUtils.format(
                            "gtceu.recipe.coil.tier", I18n.get(requiredCoil.getMaterial().getUnlocalizedName()));
                }
                return "";
            })
            .setUiBuilder((recipe, widgetGroup) -> {
                int temp = recipe.data.getInt("ebf_temp");
                List<List<ItemStack>> items = new ArrayList<>();
                items.add(GTCEuAPI.HEATING_COILS.entrySet().stream()
                        .filter(coil -> coil.getKey().getCoilTemperature() >= temp)
                        .map(coil -> new ItemStack(coil.getValue().get()))
                        .toList());
                widgetGroup.addWidget(new SlotWidget(
                        new CycleItemStackHandler(items),
                        0,
                        widgetGroup.getSize().width - 25,
                        widgetGroup.getSize().height - 32,
                        false,
                        false));
            })
            .setSound(GTSoundEntries.FURNACE);

    //  Universal Processing Plant Recipemaps (Fake Recipemap)
    public static final GTRecipeType GENERAL_RECIPES_A = registerGeneralRecipeType(
                    "general_recipes_a", MULTIBLOCK, RECIPE_MAP[0], RECIPE_MAP[1], RECIPE_MAP[2])
            .setMaxIOSize(1, 2, 1, 1)
            .setEUIO(IO.IN);
    public static final GTRecipeType GENERAL_RECIPES_B = registerGeneralRecipeType(
                    "general_recipes_b", MULTIBLOCK, RECIPE_MAP[3], RECIPE_MAP[4], RECIPE_MAP[5])
            .setMaxIOSize(2, 2, 1, 1)
            .setEUIO(IO.IN);
    public static final GTRecipeType GENERAL_RECIPES_C = registerGeneralRecipeType(
                    "general_recipes_c", MULTIBLOCK, RECIPE_MAP[6], RECIPE_MAP[7], RECIPE_MAP[8])
            .setMaxIOSize(2, 2, 1, 1)
            .setEUIO(IO.IN);

    //////////////////////////////////////
    // ********      Electric     *******//
    //////////////////////////////////////

    public static final GTRecipeType DEHYDRATOR_RECIPES = register("dehydrator", ELECTRIC)
            .setMaxIOSize(2, 9, 1, 1)
            .setEUIO(IO.IN)
            .prepareBuilder(recipeBuilder -> recipeBuilder.EUt(5))
            .setProgressBar(GuiTextures.PROGRESS_BAR_EXTRACT, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.CENTRIFUGE);

    //////////////////////////////////////
    // *******      Generator     *******//
    //////////////////////////////////////

    public static final GTRecipeType HIGH_PRESSURE_STEAM_TURBINE_FUELS = register(
                    "high_pressure_steam_turbine", GENERATOR)
            .setMaxIOSize(0, 0, 1, 1)
            .setEUIO(IO.OUT)
            .setSlotOverlay(false, true, true, GuiTextures.CENTRIFUGE_OVERLAY)
            .setProgressBar(GuiTextures.PROGRESS_BAR_GAS_COLLECTOR, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.TURBINE);

    public static final GTRecipeType SUPERCRITICAL_STEAM_TURBINE_FUELS = register(
                    "supercritical_steam_turbine", GENERATOR)
            .setMaxIOSize(0, 0, 1, 1)
            .setEUIO(IO.OUT)
            .setSlotOverlay(false, true, true, GuiTextures.CENTRIFUGE_OVERLAY)
            .setProgressBar(GuiTextures.PROGRESS_BAR_GAS_COLLECTOR, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.TURBINE);

    public static final GTRecipeType ROCKET_ENGINE_FUELS = register("rocket_engine", GENERATOR)
            .setMaxIOSize(0, 0, 1, 0)
            .setEUIO(IO.OUT)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.CENTRIFUGE);

    public static final GTRecipeType NAQUADAH_REACTOR_FUELS = register("naquadah_reactor", GENERATOR)
            .setMaxIOSize(1, 1, 0, 0)
            .setEUIO(IO.OUT)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.CENTRIFUGE);

    public static final GTRecipeType LARGE_NAQUADAH_REACTOR_FUELS = register(
                    "large_naquadah_reactor", GENERATOR)
            .setMaxIOSize(0, 0, 1, 1)
            .setEUIO(IO.OUT)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.CENTRIFUGE);

    public static final GTRecipeType UNIVERSAL_CHEMICAL_FUELS = register(
                    "universal_chemical_fuel_engine", GENERATOR)
            .setMaxIOSize(0, 0, 1, 0)
            .setEUIO(IO.OUT)
            .setSound(GTSoundEntries.CENTRIFUGE);

    public static final GTRecipeType SEMILIQUID_GENERATOR_FUELS = register(
                    "semiliquid_generator", GENERATOR)
            .setMaxIOSize(0, 0, 1, 0)
            .setEUIO(IO.OUT)
            .setSlotOverlay(false, true, true, GuiTextures.FURNACE_OVERLAY_2)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.COMBUSTION);

    public static final GTRecipeType GEOTHERMAL_ENGINE_FUELS = register(
                    "geothermal_engine", GENERATOR)
            .setMaxIOSize(0, 0, 1, 0)
            .setEUIO(IO.OUT)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.COMBUSTION);

    public static final GTRecipeType ACIDIC_FUEL_CELL_FUELS = register("acid_fuel_cell", GENERATOR)
            .setMaxIOSize(0, 0, 3, 1)
            .setEUIO(IO.OUT)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.CHEMICAL);

    public static final GTRecipeType RADIOISOTOPE_THERMOELECTRIC_GENERATOR_FUELS = register(
                    "radioisotope_thermoelectric_generator", GENERATOR)
            .setMaxIOSize(1, 1, 0, 0)
            .setEUIO(IO.OUT)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.CHEMICAL);

    //////////////////////////////////////
    // *********      Custom     ********//
    //////////////////////////////////////

    public static final GTRecipeType LARGE_NAQUADAH_COOLANT_LIST = register(
                    "large_naquadah_coolant", LIST)
            .setMaxIOSize(0, 0, 1, 0)
            .setEUIO(IO.NONE)
            .addDataInfo(compoundTag -> {
                int efficiency = compoundTag.getInt("efficiency");
                return LocalizationUtils.format(
                        "epimorphism.recipe.efficiency", "%d %%".formatted(efficiency));
            })
            .addDataInfo(compoundTag -> {
                int consumption_rate = compoundTag.getInt("consumption_rate");
                return LocalizationUtils.format("epimorphism.recipe.consumption_rate", consumption_rate);
            });

    public static final GTRecipeType LARGE_NAQUADAH_EXCITED_FLUID_LIST = register(
                    "large_naquadah_excited_fluid", LIST)
            .setMaxIOSize(0, 0, 1, 0)
            .setEUIO(IO.NONE)
            .addDataInfo(compoundTag -> {
                int parallel = compoundTag.getInt("parallel");
                return LocalizationUtils.format("epimorphism.recipe.parallel", parallel);
            })
            .addDataInfo(compoundTag -> {
                int consumption_rate = compoundTag.getInt("consumption_rate");
                return LocalizationUtils.format("epimorphism.recipe.consumption_rate", consumption_rate);
            });

    public static final GTRecipeType RADIATION_HATCH_LIST = register("radiation_hatch", LIST)
            .setMaxIOSize(1, 0, 0, 0)
            .setEUIO(IO.NONE)
            .setProgressBar(
                    EPGuiTextures.PROGRESS_BAR_RADIATION_HATCH, ProgressTexture.FillDirection.ALWAYS_FULL)
            .addDataInfo(compoundTag -> {
                int radioactivity = compoundTag.getInt("radioactivity");
                return LocalizationUtils.format("epimorphism.recipe.radioactivity", radioactivity);
            })
            .addDataInfo(compoundTag -> {
                int mass = compoundTag.getInt("mass");
                return LocalizationUtils.format("epimorphism.recipe.mass", mass);
            });

    public static void init() {
        // FIXME The recipe is shown incorrectly, it's GTM's fault, not mine
        UNIVERSAL_CHEMICAL_FUELS.getRecipeUI().setJEIVisible(false);

        //        GTRegistries.register(BuiltInRegistries.RECIPE_SERIALIZER,
        // GTCEu.id("repair_recipe_serializer"), RepairRecipe.SERIALIZER);
    }

    private static GTRecipeType registerGeneralRecipeType(
            String name,
            String group,
            GTRecipeType recipe_1,
            GTRecipeType recipe_2,
            GTRecipeType recipe_3) {
        GTRecipeType recipeType =
                new GeneralRecipeType(GTCEu.id(name), group, recipe_1, recipe_2, recipe_3);
        GTRegistries.register(BuiltInRegistries.RECIPE_TYPE, recipeType.registryName, recipeType);
        GTRegistries.register(
                BuiltInRegistries.RECIPE_SERIALIZER, recipeType.registryName, new GTRecipeSerializer());
        GTRegistries.RECIPE_TYPES.register(recipeType.registryName, recipeType);
        return recipeType;
    }
}
