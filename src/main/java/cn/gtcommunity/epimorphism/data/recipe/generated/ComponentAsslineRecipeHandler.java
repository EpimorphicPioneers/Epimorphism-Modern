package cn.gtcommunity.epimorphism.data.recipe.generated;

import cn.gtcommunity.epimorphism.common.data.items.EPWrapItem;
import cn.gtcommunity.epimorphism.common.recipe.TierCasingCondition;
import com.epimorphismmc.monomorphism.recipe.MORecipeHelper;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.recipe.FluidRecipeCapability;
import com.gregtechceu.gtceu.api.capability.recipe.ItemRecipeCapability;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.UnificationEntry;
import com.gregtechceu.gtceu.api.data.tag.TagUtil;
import com.gregtechceu.gtceu.api.item.MaterialPipeBlockItem;
import com.gregtechceu.gtceu.api.recipe.content.Content;
import com.gregtechceu.gtceu.api.recipe.ingredient.FluidIngredient;
import com.gregtechceu.gtceu.api.recipe.ingredient.IntCircuitIngredient;
import com.gregtechceu.gtceu.api.recipe.ingredient.SizedIngredient;
import com.gregtechceu.gtceu.common.block.CableBlock;
import com.gregtechceu.gtceu.core.mixins.IngredientAccessor;
import com.gregtechceu.gtceu.core.mixins.TagValueAccessor;
import com.gregtechceu.gtceu.data.recipe.CraftingComponent;
import com.gregtechceu.gtceu.data.recipe.builder.GTRecipeBuilder;
import com.lowdragmc.lowdraglib.side.fluid.FluidStack;
import it.unimi.dsi.fastutil.objects.*;
import lombok.Data;
import lombok.experimental.Accessors;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static cn.gtcommunity.epimorphism.common.data.EPRecipeTypes.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.data.recipe.CraftingComponent.*;

public class ComponentAsslineRecipeHandler {
    public static CraftingComponent.Component[] craftComponents;
    private static final Object2IntLinkedOpenHashMap<Item> componentItems = new Object2IntLinkedOpenHashMap<>();
    private static final Object2ObjectOpenHashMap<Item, RecipeRecord> recipeRecords = new Object2ObjectOpenHashMap<>();
    private static final Object2ObjectOpenHashMap<Item, List<ItemStack>> inputComponents = new Object2ObjectOpenHashMap<>();

    static {
        CraftingComponent.initializeComponents();
        craftComponents = new CraftingComponent.Component[]{PUMP, MOTOR, FIELD_GENERATOR, SENSOR, PISTON, EMITTER, CONVEYOR, ROBOT_ARM};
    }

    public static void init(GTRecipeBuilder recipeBuilder) {
        initializeGTItems();
        var outputItems = MORecipeHelper.getOutputItem(recipeBuilder);
        if (outputItems.isEmpty()) return;

        var item = outputItems.get(0).getItem();
        if (componentItems.containsKey(item)) {
            var path = recipeBuilder.id.getPath();
            // FIXME It's ugly, I should change it, right?
            if (path.endsWith("rubber") && !path.endsWith("styrene_butadiene_rubber")) return;
            handlerComponent(item, recipeBuilder, componentItems.getInt(item));
            componentItems.removeInt(item);
        }
    }

    public static void finish(Consumer<FinishedRecipe> provider) {
        recipeRecords.forEach((outputItem, record) ->
                record.inputComponentItems().forEach((recipeRecord, count) ->
                        copyToRecord(record, recipeRecord, count, 11)));

        recipeRecords.forEach((outputItem, record) -> {
            var setIterator = record.inputMaterialItems().object2IntEntrySet().fastIterator();
            while (setIterator.hasNext()) {
                var unificationEntry = setIterator.next();
                int count = unificationEntry.getIntValue();
                if (count >= 128) {
                    var stack = getFluidStack(unificationEntry.getKey(), count);
                    if (stack == null) continue;
                    addFluidToList(record.inputFluids(), stack);
                    setIterator.remove();
                }
            }

            var builder = COMPONENT_ASSEMBLY_LINE_RECIPES.recipeBuilder("component_%s".formatted(outputItem.toString()))
                    .outputItems(outputItem, 64)
                    .addCondition(new TierCasingCondition(record.tier()))
                    .duration(record.duration())
                    .EUt(record.eut());
            int circuitMeta = record.circuitMeta();
            if (circuitMeta != 0) {
                builder.circuitMeta(circuitMeta);
            }
            record.inputMaterialItems().forEach(builder::inputItems);
            record.inputItems().forEach(builder::inputItems);
            record.inputTagItems().forEach(builder::inputItems);
            record.inputFluids().forEach(builder::inputFluids);
            builder.save(provider);
        });

        componentItems.clear();
        recipeRecords.clear();
        inputComponents.clear();
    }

    private static void handlerComponent(Item outputItem, GTRecipeBuilder recipeBuilder, int tier) {
        List<FluidIngredient> inputFluids = handlerFluid(recipeBuilder);
        List<ItemStack> inputItems = new ArrayList<>();
        Object2IntOpenHashMap<UnificationEntry> inputMaterialItems = new Object2IntOpenHashMap<>();
        Object2IntOpenHashMap<TagKey<Item>> inputTagItems = new Object2IntOpenHashMap<>();
        Object2IntOpenHashMap<RecipeRecord> inputComponentItems = new Object2IntOpenHashMap<>();

        for (var input : recipeBuilder.input.get(ItemRecipeCapability.CAP)) {
            var ingredient = ItemRecipeCapability.CAP.of(input.getContent());

            if (ingredient instanceof IntCircuitIngredient) continue;

            if (ingredient instanceof SizedIngredient sized) {
                int count = sized.getAmount();
                for (Ingredient.Value value : ((IngredientAccessor) sized.getInner()).getValues()) {
                    if (value instanceof Ingredient.TagValue tagValue) {
                        var tag = ((TagValueAccessor) tagValue).getTag();
                        if (input.chance == 0) {
                            addToMap(inputTagItems, tag, count);
                        } else {
                            if (tag.location().getPath().contains("circuits")) {
                                var warp = EPWrapItem.WRAP_CIRCUIT_MAP.get(tag);
                                if (warp != null) inputItems.add(new ItemStack(warp.asItem(), count * 3));
                            } else if (!handlerTag(tag, count * 48, inputMaterialItems)) {
                                addToMap(inputTagItems, tag, count * 48);
                            }
                        }

                    } else {
                        if (input.chance == 0) {
                            value.getItems().forEach(stack -> addCableToList(inputItems, stack.copyWithCount(count)));
                        } else {
                            value.getItems().forEach(stack -> addCableToList(inputItems, stack.copyWithCount(count * 48)));
                        }

                    }
                }
            } else {
                Arrays.stream(ingredient.getItems())
                        .map(ItemStack::copy)
                        .peek(stack -> stack.setCount(stack.getCount() * 48))
                        .forEach(inputItems::add);
            }
        }

        var materialsIterator = inputMaterialItems.object2IntEntrySet().fastIterator();
        while (materialsIterator.hasNext()) {
            var entry = materialsIterator.next();
            int count = entry.getIntValue();
            if (count >= 128) {
                var stack = getFluidStack(entry.getKey(), count);
                if (stack == null) continue;
                addFluidToList(inputFluids, stack);
                materialsIterator.remove();
            }
        }

        var itemsIterator = inputItems.iterator();
        while (itemsIterator.hasNext()) {
            var stack = itemsIterator.next();
            var item = stack.getItem();
            var record = recipeRecords.get(item);
            if (record != null) {
                addToMap(inputComponentItems, record, stack.getCount());
                itemsIterator.remove();
            } else if (componentItems.containsKey(item)) {
                inputComponents.computeIfAbsent(outputItem, o -> new ArrayList<>()).add(stack);
                itemsIterator.remove();
            }
        }

        var record = new RecipeRecord(inputFluids, inputItems, inputMaterialItems, inputTagItems, inputComponentItems, recipeBuilder.duration, recipeBuilder.EUt(), tier);
        var componentsIterator = inputComponents.object2ObjectEntrySet().fastIterator();
        while (componentsIterator.hasNext()) {
            var entry = componentsIterator.next();
            var list = entry.getValue();
            var rlistIterator = list.listIterator();
            while (rlistIterator.hasNext()) {
                var stack = rlistIterator.next();
                if (stack.getItem() == outputItem) {
                    addToMap(recipeRecords.get(entry.getKey()).inputComponentItems(), record, stack.getCount());
                    rlistIterator.remove();
                    if (list.isEmpty()) {
                        componentsIterator.remove();
                    }
                }
            }
        }

        recipeRecords.put(outputItem, record);
    }

    private static List<FluidIngredient> handlerFluid(GTRecipeBuilder recipeBuilder) {
        return recipeBuilder.input.getOrDefault(FluidRecipeCapability.CAP, Collections.emptyList()).stream()
                .map(Content::getContent)
                .map(FluidRecipeCapability.CAP::of)
                .map(FluidIngredient::copy)
                .peek(ingredient -> ingredient.setAmount(ingredient.getAmount() * 48))
                .collect(Collectors.toList());
    }

    private static boolean handlerTag(TagKey<Item> tag, int count, AbstractObject2IntMap<UnificationEntry> map) {
        var entry = ChemicalHelper.getUnificationEntry(tag);
        if (entry == UnificationEntry.EmptyMapMarkerEntry) return false;

        var material = entry.material;
        var tagPrefix = entry.tagPrefix;
        if (tagPrefix.equals(plate)) {
            if (material != null && material.hasFlag(GENERATE_DENSE)) {
                addToMap(map, new UnificationEntry(plateDense, material), count / 9);
                return true;
            }
        } else if (tagPrefix.equals(rod)) {
            if (material != null && material.hasFlag(GENERATE_LONG_ROD)) {
                addToMap(map, new UnificationEntry(rodLong, material), count / 2);
                return true;
            }
        } else if (tagPrefix.equals(gearSmall)) {
            if (material != null && material.hasFlag(GENERATE_GEAR)) {
                addToMap(map, new UnificationEntry(gear, material), count / 4);
                return true;
            }
        }
        addToMap(map, entry, count);
        return true;
    }

    private static void initializeGTItems() {
        for (int i = 0; i < GTValues.TIER_COUNT; i++) {
            for (var craftComponent : craftComponents) {
                if (craftComponent.getIngredient(i) instanceof ItemStack stack) {
                    componentItems.put(stack.getItem(), i);
                }
            }
        }
    }

    private static <K> void addToMap(AbstractObject2IntMap<K> map, K entry, Integer count) {
        map.mergeInt(entry, count, Integer::sum);
    }

    private static void addStackToList(List<ItemStack> list, ItemStack itemStack) {
        for (var stack : list) {
            if (stack.is(itemStack.getItem())) {
                stack.grow(itemStack.getCount());
                return;
            }
        }
        list.add(itemStack);
    }

    private static void addCableToList(List<ItemStack> list, ItemStack itemStack) {
        var item = itemStack.getItem();
        if (item instanceof MaterialPipeBlockItem cableItem
                && cableItem.getBlock() instanceof CableBlock cable) {
            var type = cable.pipeType;
            var material = cable.material;
            int count = (int) Math.ceil(itemStack.getCount() * type.amperage / 16D);
            if (type.isCable()) {
                list.add(ChemicalHelper.get(cableGtHex, material, count));
            } else {
                list.add(ChemicalHelper.get(wireGtHex, material, count));
            }
        } else {
            list.add(itemStack);
        }
    }

    private static void addFluidToList(List<FluidIngredient> list, FluidStack fluidStack) {
        var fluid = fluidStack.getFluid();
        var tag = TagUtil.createFluidTag(BuiltInRegistries.FLUID.getKey(fluid).getPath());
        boolean isWater = fluid == Fluids.WATER;
        for (var ingredient : list) {
            if (isWater && ingredient.test(fluidStack)) {
                ingredient.setAmount(ingredient.getAmount() + fluidStack.getAmount());
                return;
            }

            if (testFluidStack(ingredient, tag)) {
                ingredient.setAmount(ingredient.getAmount() + fluidStack.getAmount());
                return;
            }
        }
        list.add(isWater ? FluidIngredient.of(fluidStack) : FluidIngredient.of(tag, fluidStack.getAmount()));
    }

    private static void addFluidToList(List<FluidIngredient> list, FluidIngredient fluidIngredient) {
        for (var ingredient : list) {
            if (ingredient.equals(fluidIngredient)) {
                ingredient.setAmount(ingredient.getAmount() + fluidIngredient.getAmount());
                return;
            }
        }
        list.add(fluidIngredient);
    }

    private static boolean testFluidStack(FluidIngredient ingredient, TagKey<Fluid> tag) {
        var values = ingredient.values;
        for (FluidIngredient.Value value : values) {
            if (value instanceof FluidIngredient.TagValue tagValue) {
                if (tagValue.getTag().equals(tag)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Nullable
    private static FluidStack getFluidStack(UnificationEntry entry, int count) {
        var stack = ChemicalHelper.getMaterial(entry);
        if (stack != null) {
            var material = stack.material();
            if (material.hasFlag(IS_MAGNETIC) && material.hasProperty(PropertyKey.INGOT)) {
                material = material.getProperty(PropertyKey.INGOT).getSmeltingInto();
            }
            if (material != null && material.hasFluid()) {
                return material.getFluid(stack.amount() * count);
            }
        }
        return null;
    }

    private static void copyToRecord(RecipeRecord record, RecipeRecord other, int count, int circuitMeta) {
        other.inputComponentItems().forEach((component, integer) -> copyToRecord(other, component, integer, circuitMeta + 1));

        other.inputFluids().forEach(ingredient -> {
            var newIngredient = ingredient.copy();
            newIngredient.setAmount(newIngredient.getAmount() * count / 64);
            addFluidToList(record.inputFluids(), newIngredient);
        });
        other.inputMaterialItems().forEach((entry, integer) -> addToMap(record.inputMaterialItems(), entry, integer * count / 64));
        other.inputTagItems().forEach((tag, integer) -> addToMap(record.inputTagItems(), tag, integer * count / 64));
        other.inputItems().forEach(stack -> addStackToList(record.inputItems(), stack.copyWithCount(stack.getCount() * count / 64)));
        other.circuitMeta(Math.max(circuitMeta, other.circuitMeta()));
    }

    @Data
    @Accessors(fluent = true)
    private static class RecipeRecord {
        private final List<FluidIngredient> inputFluids;
        private final List<ItemStack> inputItems;
        private final Object2IntOpenHashMap<UnificationEntry> inputMaterialItems;
        private final Object2IntOpenHashMap<TagKey<Item>> inputTagItems;
        private final Object2IntOpenHashMap<RecipeRecord> inputComponentItems;
        private final int duration;
        private final long eut;
        private final int tier;
        private int circuitMeta;

        public RecipeRecord(List<FluidIngredient> inputFluids,
                            List<ItemStack> inputItems,
                            Object2IntOpenHashMap<UnificationEntry> inputMaterialItems,
                            Object2IntOpenHashMap<TagKey<Item>> inputTagItems,
                            Object2IntOpenHashMap<RecipeRecord> inputComponentItems,
                            int duration, long eut, int tier) {
            this.inputFluids = inputFluids;
            this.inputItems = inputItems;
            this.inputMaterialItems = inputMaterialItems;
            this.inputTagItems = inputTagItems;
            this.inputComponentItems = inputComponentItems;
            this.duration = duration;
            this.eut = eut;
            this.tier = tier;
        }
    }
}
