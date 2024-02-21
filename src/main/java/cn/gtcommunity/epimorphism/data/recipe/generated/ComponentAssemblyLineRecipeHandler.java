package cn.gtcommunity.epimorphism.data.recipe.generated;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.api.event.GTRecipeEvent;
import cn.gtcommunity.epimorphism.common.data.EPItems;
import cn.gtcommunity.epimorphism.common.data.EPRecipeTypes;
import cn.gtcommunity.epimorphism.common.data.EPWrapItem;
import com.gregtechceu.gtceu.api.capability.recipe.FluidRecipeCapability;
import com.gregtechceu.gtceu.api.capability.recipe.ItemRecipeCapability;
import com.gregtechceu.gtceu.api.recipe.ingredient.SizedIngredient;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.data.recipe.builder.GTRecipeBuilder;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

import java.util.*;
import java.util.function.Consumer;

import static cn.gtcommunity.epimorphism.common.data.EPItems.*;
import static com.gregtechceu.gtceu.common.data.GTItems.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;

public class ComponentAssemblyLineRecipeHandler {
    private static final LinkedList<Item> LIST = asLinkedList(
            ELECTRIC_MOTOR_LV, ELECTRIC_MOTOR_MV, ELECTRIC_MOTOR_HV, ELECTRIC_MOTOR_EV, ELECTRIC_MOTOR_IV, ELECTRIC_MOTOR_LuV, ELECTRIC_MOTOR_ZPM, ELECTRIC_MOTOR_UV, ELECTRIC_MOTOR_UHV, ELECTRIC_MOTOR_UEV, ELECTRIC_MOTOR_UIV, ELECTRIC_MOTOR_UXV, ELECTRIC_MOTOR_OpV, ELECTRIC_MOTOR_MAX,
            ELECTRIC_PISTON_LV, ELECTRIC_PISTON_MV, ELECTRIC_PISTON_HV, ELECTRIC_PISTON_EV, ELECTRIC_PISTON_IV, ELECTRIC_PISTON_LUV, ELECTRIC_PISTON_ZPM, ELECTRIC_PISTON_UV, ELECTRIC_PISTON_UHV, ELECTRIC_PISTON_UEV, ELECTRIC_PISTON_UIV, ELECTRIC_PISTON_UXV, ELECTRIC_PISTON_OpV, ELECTRIC_PISTON_MAX,
            ELECTRIC_PUMP_LV, ELECTRIC_PUMP_MV, ELECTRIC_PUMP_HV, ELECTRIC_PUMP_EV, ELECTRIC_PUMP_IV, ELECTRIC_PUMP_LuV, ELECTRIC_PUMP_ZPM, ELECTRIC_PUMP_UV, ELECTRIC_PUMP_UHV, ELECTRIC_PUMP_UEV, ELECTRIC_PUMP_UIV, ELECTRIC_PUMP_UXV, ELECTRIC_PUMP_OpV, ELECTRIC_PUMP_MAX,
            FLUID_REGULATOR_LV, FLUID_REGULATOR_MV, FLUID_REGULATOR_HV, FLUID_REGULATOR_EV, FLUID_REGULATOR_IV, FLUID_REGULATOR_LUV, FLUID_REGULATOR_ZPM, FLUID_REGULATOR_UV, FLUID_REGULATOR_UHV, FLUID_REGULATOR_UEV, FLUID_REGULATOR_UIV, FLUID_REGULATOR_UXV, FLUID_REGULATOR_OpV, FLUID_REGULATOR_MAX,
            CONVEYOR_MODULE_LV, CONVEYOR_MODULE_MV, CONVEYOR_MODULE_HV, CONVEYOR_MODULE_EV, CONVEYOR_MODULE_IV, CONVEYOR_MODULE_LuV, CONVEYOR_MODULE_ZPM, CONVEYOR_MODULE_UV, CONVEYOR_MODULE_UHV, CONVEYOR_MODULE_UEV, CONVEYOR_MODULE_UIV, CONVEYOR_MODULE_UXV, CONVEYOR_MODULE_OpV, CONVEYOR_MODULE_MAX,
            ROBOT_ARM_LV, ROBOT_ARM_MV, ROBOT_ARM_HV, ROBOT_ARM_EV, ROBOT_ARM_IV, ROBOT_ARM_LuV, ROBOT_ARM_ZPM, ROBOT_ARM_UV, ROBOT_ARM_UHV, ROBOT_ARM_UEV, ROBOT_ARM_UIV, ROBOT_ARM_UXV, ROBOT_ARM_OpV, ROBOT_ARM_MAX,
            EMITTER_LV, EMITTER_MV, EMITTER_HV, EMITTER_EV, EMITTER_IV, EMITTER_LuV, EMITTER_ZPM, EMITTER_UV, /*EMITTER_UHV, EMITTER_UEV, EMITTER_UIV, EMITTER_UXV, EMITTER_OpV, */EMITTER_MAX,
            SENSOR_LV, SENSOR_MV, SENSOR_HV, SENSOR_EV, SENSOR_IV, SENSOR_LuV, SENSOR_ZPM, SENSOR_UV, SENSOR_UHV, SENSOR_UEV, SENSOR_UIV, SENSOR_UXV, SENSOR_OpV, SENSOR_MAX,
            FIELD_GENERATOR_LV, FIELD_GENERATOR_MV, FIELD_GENERATOR_HV, FIELD_GENERATOR_EV, FIELD_GENERATOR_IV, FIELD_GENERATOR_LuV, FIELD_GENERATOR_ZPM, FIELD_GENERATOR_UV, FIELD_GENERATOR_UHV, FIELD_GENERATOR_UEV, FIELD_GENERATOR_UIV, FIELD_GENERATOR_UXV, FIELD_GENERATOR_OpV, FIELD_GENERATOR_MAX
    );
    private static List<Item> tempList = new ArrayList<>();

    public static void init(GTRecipeBuilder recipeBuilder, Consumer<FinishedRecipe> provider) {
        var output = recipeBuilder.output.get(ItemRecipeCapability.CAP).get(0).getContent();
        for (var itemStack : ItemRecipeCapability.CAP.of(output).getItems()) {
            var item = itemStack.getItem();
            if (LIST.remove(item)) {
                tempList.add(item);
                var builder = EPRecipeTypes.COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder("ca_%s".formatted(item.getDescriptionId()));
                if (recipeBuilder.input.containsKey(FluidRecipeCapability.CAP)) {
                    builder.input.put(FluidRecipeCapability.CAP, recipeBuilder.input.get(FluidRecipeCapability.CAP));
                }
                itemStack.setCount(64);
                builder.outputItems(itemStack)
                        .duration(recipeBuilder.duration)
                        .EUt(recipeBuilder.EUt());
                for (var input : recipeBuilder.input.get(ItemRecipeCapability.CAP)) {
                    var inputItems = ItemRecipeCapability.CAP.of(input.getContent()).getItems();
                    if (inputItems.length > 0) {
                        var list = inputItems[0].getTags().map(EPWrapItem.WRAP_CIRCUIT_MAP::get).filter(Objects::nonNull).toList();
                        if (!list.isEmpty()) {
                            builder.inputItems(new ItemStack(list.get(0), 1));
                        }
                    }
                }
                builder.save(provider);
            }
        }
    }
    
    private static LinkedList<Item> asLinkedList(ItemLike... itemLikes) {
        return new LinkedList<>(Arrays.stream(itemLikes).map(ItemLike::asItem).toList());
    }

//    private static Map<TagKey<Item>, Item> asMap(Object[][] objects) {
//        Map<TagKey<Item>, Item> map = new HashMap<>();
//        Arrays.stream(objects).forEach(list -> map.put((TagKey<Item>) list[0], ((ItemLike) list[1]).asItem()));
//        return map;
//    }
}
