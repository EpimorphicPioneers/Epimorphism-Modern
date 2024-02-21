package cn.gtcommunity.epimorphism.common.data;

import cn.gtcommunity.epimorphism.api.gui.EPGuiTextures;
import cn.gtcommunity.epimorphism.api.recipe.GeneralRecipeType;
import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.block.ICoilType;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.recipe.GTRecipeSerializer;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.api.registry.GTRegistries;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTSoundEntries;
import com.lowdragmc.lowdraglib.gui.texture.ProgressTexture;
import com.lowdragmc.lowdraglib.gui.widget.SlotWidget;
import com.lowdragmc.lowdraglib.utils.CycleItemStackHandler;
import com.lowdragmc.lowdraglib.utils.LocalizationUtils;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

import static cn.gtcommunity.epimorphism.common.machine.multiblock.electric.GeneralProcessingPlantMachine.RECIPE_MAP;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;

public class EPRecipeTypes {
    public static final String CUSTOM = "custom";


    //////////////////////////////////////
    //*******     Multiblock     *******//
    //////////////////////////////////////
    public final static GTRecipeType NEUTRON_ACTIVATOR_RECIPES = register("neutron_activator", MULTIBLOCK).setMaxIOSize(6, 6, 1, 1)
            .setSound(GTSoundEntries.FURNACE);

    public final static GTRecipeType COMPONENT_ASSEMBLY_LINE_RECIPES = register("component_assembly_line", MULTIBLOCK).setMaxIOSize(12, 1, 12, 0).setEUIO(IO.IN)
            .setSound(GTSoundEntries.ASSEMBLER);

    public final static GTRecipeType MOLECULAR_BEAM_RECIPES = register("molecular_beam", MULTIBLOCK).setMaxIOSize(5, 1, 2, 1).setEUIO(IO.IN)
            .setSlotOverlay(false, false, false, EPGuiTextures.NANOSCALE_OVERLAY_1)
            .setSlotOverlay(false, false, true, EPGuiTextures.NANOSCALE_OVERLAY_1)
            .setSlotOverlay(false, true, false, EPGuiTextures.NANOSCALE_OVERLAY_2)
            .setSlotOverlay(false, true, true, EPGuiTextures.NANOSCALE_OVERLAY_2)
            .setSlotOverlay(true, false, true, EPGuiTextures.NANOSCALE_OVERLAY_1)
            .setSlotOverlay(true, true, true, EPGuiTextures.NANOSCALE_OVERLAY_2)
            .setProgressBar(EPGuiTextures.PROGRESS_BAR_NANOSCALE, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.ELECTROLYZER);

    public final static GTRecipeType CRYSTALLIZATION_RECIPES = register("crystallization", MULTIBLOCK).setMaxIOSize(6, 1, 3, 0).setEUIO(IO.IN)
            .setProgressBar(GuiTextures.PROGRESS_BAR_CRYSTALLIZATION, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .addDataInfo(data -> {
                int temp = data.getInt("ebf_temp");
                ICoilType requiredCoil = ICoilType.getMinRequiredType(temp);

                if (requiredCoil == null || requiredCoil.getMaterial() == null) {
                    return LocalizationUtils.format("gtceu.recipe.temperature", temp);
                } else {
                    return LocalizationUtils.format("gtceu.recipe.temperature_and_coil", temp, I18n.get(requiredCoil.getMaterial().getUnlocalizedName()));
                }
            })
            .setUiBuilder((recipe, widgetGroup) -> {
                int temp = recipe.data.getInt("ebf_temp");
                List<List<ItemStack>> items = new ArrayList<>();
                items.add(GTBlocks.ALL_COILS.entrySet().stream().filter(coil -> coil.getKey().getCoilTemperature() >= temp).map(coil -> new ItemStack(coil.getValue().get())).toList());
                widgetGroup.addWidget(new SlotWidget(new CycleItemStackHandler(items), 0, widgetGroup.getSize().width - 25, widgetGroup.getSize().height - 32, false, false));
            })
            .setSound(GTSoundEntries.FURNACE);

    public final static GTRecipeType CHEMICAL_PLANT_RECIPES = register("chemical_plant", MULTIBLOCK).setMaxIOSize(4, 4, 4, 2).setEUIO(IO.IN)
            .setSound(GTSoundEntries.CHEMICAL);
    public final static GTRecipeType FERMENTATION_TANK_RECIPES = register("fermentation_tank", MULTIBLOCK).setMaxIOSize(3, 2, 3, 2).setEUIO(IO.IN)
            .setSound(GTSoundEntries.CHEMICAL);

    public final static GTRecipeType PRECISE_ASSEMBLER_RECIPES = register("precise_assembler", MULTIBLOCK).setMaxIOSize(4, 1, 4, 0).setEUIO(IO.IN)
            .setSound(GTSoundEntries.ASSEMBLER);

    public final static GTRecipeType ROASTER_RECIPES = register("roaster", MULTIBLOCK).setMaxIOSize(2, 4, 2, 2).setEUIO(IO.IN)
            .setSound(GTSoundEntries.FURNACE);

    public final static GTRecipeType DRILLING_RECIPES = register("industrial_drill", MULTIBLOCK).setMaxIOSize(1, 1, 0, 1).setEUIO(IO.IN)
            .setSlotOverlay(false, false, true, GuiTextures.CRUSHED_ORE_OVERLAY)
            .setSlotOverlay(true, false, true, GuiTextures.DUST_OVERLAY)
            .setSound(GTSoundEntries.MACERATOR);

    public final static GTRecipeType DIGESTER_RECIPES = register("digester", MULTIBLOCK).setMaxIOSize(1, 1, 1, 1).setEUIO(IO.IN)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.CHEMICAL);

    public final static GTRecipeType ORE_MILLING_RECIPES = register("ore_milling", MULTIBLOCK).setMaxIOSize(1, 1, 0, 0).setEUIO(IO.IN)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.FORGE_HAMMER);

    public final static GTRecipeType VACUUM_DRYING_FURNACE_RECIPES = register("vacuum_drying_furnace", MULTIBLOCK).setMaxIOSize(1, 9, 2, 3).setEUIO(IO.IN)
            .addDataInfo(data -> {
                int temp = data.getInt("ebf_temp");
                ICoilType requiredCoil = ICoilType.getMinRequiredType(temp);

                if (requiredCoil == null || requiredCoil.getMaterial() == null) {
                    return LocalizationUtils.format("gtceu.recipe.temperature", temp);
                } else {
                    return LocalizationUtils.format("gtceu.recipe.temperature_and_coil", temp, I18n.get(requiredCoil.getMaterial().getUnlocalizedName()));
                }
            })
            .setUiBuilder((recipe, widgetGroup) -> {
                int temp = recipe.data.getInt("ebf_temp");
                List<List<ItemStack>> items = new ArrayList<>();
                items.add(GTBlocks.ALL_COILS.entrySet().stream().filter(coil -> coil.getKey().getCoilTemperature() >= temp).map(coil -> new ItemStack(coil.getValue().get())).toList());
                widgetGroup.addWidget(new SlotWidget(new CycleItemStackHandler(items), 0, widgetGroup.getSize().width - 25, widgetGroup.getSize().height - 32, false, false));
            })
            .setSound(GTSoundEntries.FURNACE);

    //  Universal Processing Plant Recipemaps (Pseudo Recipemap)
    public final static GTRecipeType GENERAL_RECIPES_A = registerGeneralRecipeType("general_recipes_a", MULTIBLOCK, RECIPE_MAP[0], RECIPE_MAP[1], RECIPE_MAP[2]).setMaxIOSize(1, 2, 1, 1).setEUIO(IO.IN);
    public final static GTRecipeType GENERAL_RECIPES_B = registerGeneralRecipeType("general_recipes_b", MULTIBLOCK, RECIPE_MAP[3], RECIPE_MAP[4], RECIPE_MAP[5]).setMaxIOSize(2, 2, 1, 1).setEUIO(IO.IN);
    public final static GTRecipeType GENERAL_RECIPES_C = registerGeneralRecipeType("general_recipes_c", MULTIBLOCK, RECIPE_MAP[6], RECIPE_MAP[7], RECIPE_MAP[8]).setMaxIOSize(2, 2, 1, 1).setEUIO(IO.IN);

    //////////////////////////////////////
    //*****     Multiblock Part    *****//
    //////////////////////////////////////
    public final static GTRecipeType RADIATION_HATCH_RECIPES = register("radiation_hatch", CUSTOM).setMaxIOSize(1, 0, 0, 0).setEUIO(IO.NONE)
            .setProgressBar(EPGuiTextures.PROGRESS_BAR_RADIATION_HATCH, ProgressTexture.FillDirection.ALWAYS_FULL)
            .addDataInfo(compoundTag -> {
                int radioactivity = compoundTag.getInt("radioactivity");
                return LocalizationUtils.format("epimorphism.recipe.radioactivity", radioactivity);
            })
            .addDataInfo(compoundTag -> {
                int mass = compoundTag.getInt("mass");
                return LocalizationUtils.format("epimorphism.recipe.mass", mass);
            });

    public static void init() {/**/}

    private static GTRecipeType registerGeneralRecipeType(String name, String group, GTRecipeType recipe_1, GTRecipeType recipe_2, GTRecipeType recipe_3) {
        GTRecipeType recipeType = new GeneralRecipeType(GTCEu.id(name), group, recipe_1, recipe_2, recipe_3);
        GTRegistries.register(BuiltInRegistries.RECIPE_TYPE, recipeType.registryName, recipeType);
        GTRegistries.register(BuiltInRegistries.RECIPE_SERIALIZER, recipeType.registryName, new GTRecipeSerializer());
        GTRegistries.RECIPE_TYPES.register(recipeType.registryName, recipeType);
        return recipeType;
    }
}
