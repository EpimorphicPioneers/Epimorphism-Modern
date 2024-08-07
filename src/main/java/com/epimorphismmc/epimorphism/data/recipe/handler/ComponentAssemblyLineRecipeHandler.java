package com.epimorphismmc.epimorphism.data.recipe.handler;

import com.epimorphismmc.epimorphism.Epimorphism;
import com.epimorphismmc.epimorphism.common.data.items.EPWrapItem;
import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.recipe.FluidRecipeCapability;
import com.gregtechceu.gtceu.api.capability.recipe.ItemRecipeCapability;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.UnificationEntry;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.recipe.RecipeHelper;
import com.gregtechceu.gtceu.api.recipe.ingredient.FluidIngredient;
import com.gregtechceu.gtceu.api.recipe.ingredient.IntCircuitIngredient;
import com.gregtechceu.gtceu.api.recipe.ingredient.SizedIngredient;

import com.gregtechceu.gtceu.core.mixins.IngredientAccessor;
import com.gregtechceu.gtceu.core.mixins.TagValueAccessor;
import com.gregtechceu.gtceu.data.recipe.CraftingComponent;
import com.gregtechceu.gtceu.data.recipe.builder.GTRecipeBuilder;
import com.lowdragmc.lowdraglib.side.fluid.FluidStack;
import it.unimi.dsi.fastutil.objects.Object2IntLinkedOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2LongOpenHashMap;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.material.Fluid;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static com.epimorphismmc.epimorphism.common.data.EPRecipeTypes.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.data.recipe.CraftingComponent.CONVEYOR;
import static com.gregtechceu.gtceu.data.recipe.CraftingComponent.EMITTER;
import static com.gregtechceu.gtceu.data.recipe.CraftingComponent.FIELD_GENERATOR;
import static com.gregtechceu.gtceu.data.recipe.CraftingComponent.MOTOR;
import static com.gregtechceu.gtceu.data.recipe.CraftingComponent.PISTON;
import static com.gregtechceu.gtceu.data.recipe.CraftingComponent.PUMP;
import static com.gregtechceu.gtceu.data.recipe.CraftingComponent.ROBOT_ARM;
import static com.gregtechceu.gtceu.data.recipe.CraftingComponent.SENSOR;

public class ComponentAssemblyLineRecipeHandler {
    // 需要制作的部件
    public static CraftingComponent.Component[] craftComponents;
    private static final Object2IntLinkedOpenHashMap<Item> componentItems = new Object2IntLinkedOpenHashMap<>();

    private static final List<GTRecipeBuilder> recipeBuilders = new ArrayList<>();

    static {
        CraftingComponent.initializeComponents();
        craftComponents = new CraftingComponent.Component[]{
                MOTOR, PUMP, PISTON, CONVEYOR, ROBOT_ARM, FIELD_GENERATOR, EMITTER, SENSOR
        };
        initComponentList();
    }

    public static void init(GTRecipeBuilder recipeBuilder) {
        var outputItems = RecipeHelper.getOutputItems(recipeBuilder);
        if (outputItems.isEmpty()) return;

        var item = outputItems.get(0).getItem();
        if (componentItems.containsKey(item)) {
            handlerComponent(item, recipeBuilder, componentItems.getInt(item));
        }
    }

    public static void finish(Consumer<FinishedRecipe> provider) {
        recipeBuilders.forEach(builder -> builder.save(provider));
    }

    private static void handlerComponent(Item outputItem, GTRecipeBuilder builder, int tier) {
        List<Ingredient> inputItems = RecipeHelper.getInputContents(builder, ItemRecipeCapability.CAP);
        List<FluidIngredient> inputFluids = RecipeHelper.getInputContents(builder, FluidRecipeCapability.CAP);
        Object2LongOpenHashMap<Fluid> inputFluidMap = new Object2LongOpenHashMap<>();

        GTRecipeBuilder newBuilder = COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder(Epimorphism.id(builder.id.getPath()));

        for (var input : inputItems) {
            //noinspection StatementWithEmptyBody
            if (input instanceof IntCircuitIngredient) {
            } else if (input instanceof SizedIngredient ingredient) {
                int count = ingredient.getAmount();
                for (Ingredient.Value value : ((IngredientAccessor) ingredient.getInner()).getValues()) {
                    if (value instanceof Ingredient.ItemValue itemValue) {
                        // 普通 itemStack 物品
                        for (ItemStack stack : itemValue.getItems()) {
                            UnificationEntry entry = ChemicalHelper.getUnificationEntry(stack.getItem());
                            if (entry != null && entry != UnificationEntry.EmptyMapMarkerEntry) {
                                handlerUnificationEntry(builder, newBuilder, inputFluidMap, entry, count);
                            } else {
                                newBuilder.inputItems(stack.copyWithCount(count * 48));
                            }
                        }
                    } else if (value instanceof Ingredient.TagValue tagValue) {
                        TagKey<Item> tag = ((TagValueAccessor) tagValue).getTag();
                        ResourceLocation location = tag.location();
                        if (location.getNamespace().equals(GTCEu.MOD_ID) && location.getPath().contains("circuits")) {
                            // 是 GT 电路板
                            ItemLike warpItem = EPWrapItem.WRAP_CIRCUIT_MAP.get(tag);
                            if (warpItem != null) {
                                newBuilder.inputItems(new ItemStack(warpItem, count * 3));
                            }
                        } else {
                            UnificationEntry entry = ChemicalHelper.getUnificationEntry(tag);
                            if (entry != null && entry != UnificationEntry.EmptyMapMarkerEntry) {
                                handlerUnificationEntry(builder, newBuilder, inputFluidMap, entry, count);
                            } else {
                                newBuilder.inputItems(tag, count * 48);
                            }
                        }
                    } else {
                        value.getItems().forEach(stack -> newBuilder.inputItems(stack.copyWithCount(count * 48)));
                    }
                }
            } else {
                for (ItemStack stack : input.getItems()) {
                    newBuilder.inputItems(stack.copyWithCount(stack.getCount() * 48));
                }
            }
        }

        inputFluids.forEach(fluidIngredient -> {
            FluidIngredient copy = fluidIngredient.copy();
            copy.setAmount(copy.getAmount() * 48);
            newBuilder.inputFluids(copy);
        });
        inputFluidMap.forEach((fluid, amount) -> newBuilder.inputFluids(FluidStack.create(fluid, amount)));

        newBuilder.outputItems(outputItem, 64);
        newBuilder.EUt(GTValues.VA[tier]);
        newBuilder.duration(builder.duration * 48);
        if (builder.recipeType == ASSEMBLY_LINE_RECIPES) {
            if (builder.id.getPath().contains("electric_motor")) {
                newBuilder.circuitMeta(1);
            } else if (builder.id.getPath().contains("electric_pump")) {
                newBuilder.circuitMeta(2);
            } else if (builder.id.getPath().contains("conveyor_module")) {
                newBuilder.circuitMeta(3);
            } else if (builder.id.getPath().contains("electric_piston")) {
                newBuilder.circuitMeta(4);
            } else if (builder.id.getPath().contains("robot_arm")) {
                newBuilder.circuitMeta(5);
            } else if (builder.id.getPath().contains("field_generator")) {
                newBuilder.circuitMeta(6);
            } else if (builder.id.getPath().contains("emitter")) {
                newBuilder.circuitMeta(7);
            } else if (builder.id.getPath().contains("sensor")) {
                newBuilder.circuitMeta(8);
            }
        }

        recipeBuilders.add(newBuilder);
    }

    private static void initComponentList() {
        for (int i = 0; i < GTValues.TIER_COUNT; i++) {
            for (var component : craftComponents) {
                if (component.getIngredient(i) instanceof ItemStack stack) {
                    componentItems.put(stack.getItem(), i);
                }
            }
        }
    }

    private static void handlerUnificationEntry(GTRecipeBuilder builder, GTRecipeBuilder newBuilder, Object2LongOpenHashMap<Fluid> fluidMap, UnificationEntry entry, int count) {
        // 是有 mat 物品
        Material material = entry.material;
        if (material == null) {
            return;
        }
        TagPrefix prefix = entry.tagPrefix;
        // 1x线缆 -> 16x线缆
        if (prefix == cableGtSingle) {
            conventPrefix(newBuilder, cableGtSingle, cableGtHex, material, count, 16);
            return;
        }
        // 2x线缆 -> 16x线缆
        if (prefix == cableGtDouble) {
            conventPrefix(newBuilder, cableGtDouble, cableGtHex, material, count, 8);
            return;
        }
        // 4x线缆 -> 16x线缆
        if (prefix == cableGtQuadruple) {
            conventPrefix(newBuilder, cableGtQuadruple, cableGtHex, material, count, 4);
            return;
        }
        // 8x线缆 -> 16x线缆
        if (prefix == cableGtOctal) {
            conventPrefix(newBuilder, cableGtOctal, cableGtHex, material, count, 2);
            return;
        }
        if (builder.recipeType == ASSEMBLY_LINE_RECIPES) {
            conventPrefixToFluid(fluidMap, newBuilder, prefix, material, count);
        } else {
            // 杆 -> 长杆
            if (prefix == rod) {
                conventPrefix(newBuilder, rod, rodLong, material, count, 2);
                return;
            }
            // 板 -> 致密板
            if (prefix == plate) {
                conventPrefix(newBuilder, plate, plateDense, material, count, 9);
                return;
            }
            // 小齿轮 -> 齿轮
            if (prefix == gearSmall) {
                conventPrefix(newBuilder, gearSmall, gear, material, count, 4);
                return;
            }
            if (material == Rubber || material == SiliconeRubber || material == StyreneButadieneRubber) {
                conventPrefixToFluid(fluidMap, newBuilder, prefix, material, count);
                return;
            }
            newBuilder.inputItems(prefix, material, count * 48);
        }
    }

    private static void conventPrefix(GTRecipeBuilder builder, TagPrefix originalPrefix, TagPrefix newPrefix, Material material, int count, int multiple) {
        ItemStack stack = ChemicalHelper.get(newPrefix, material);
        if (stack.isEmpty()) {
            builder.inputItems(originalPrefix, material, count * 48);
        } else {
            builder.inputItems(newPrefix, material, count * 48 / multiple);
        }
    }

    private static void conventPrefixToFluid(Object2LongOpenHashMap<Fluid> fluidMap, GTRecipeBuilder builder, TagPrefix prefix, Material material, int count) {
        if (material.hasFluid() && prefix.materialAmount() != -1) {
            long fluidCount = prefix.materialAmount() / 25200;
            FluidStack fluid = material.getFluid(fluidCount * count * 48);
            fluidMap.addTo(fluid.getFluid(), fluid.getAmount());
        } else {
            builder.inputItems(prefix, material, count * 48);
        }
    }
}
