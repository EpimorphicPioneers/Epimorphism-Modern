package com.epimorphismmc.epimorphism.common.machine.trait;

import com.epimorphismmc.epimorphism.common.machine.multiblock.electric.advanced.IntegratedOreFactoryMachine;
import com.epimorphismmc.epimorphism.utils.EPUtil;

import com.epimorphismmc.monomorphism.misc.SimpleCapabilityHolder;
import com.epimorphismmc.monomorphism.recipe.MORecipeHelper;
import com.epimorphismmc.monomorphism.utility.MOUtils;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.recipe.*;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.data.tag.TagUtil;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.data.recipe.builder.GTRecipeBuilder;
import com.gregtechceu.gtceu.utils.GTTransferUtils;

import com.lowdragmc.lowdraglib.misc.FluidTransferList;
import com.lowdragmc.lowdraglib.misc.ItemTransferList;
import com.lowdragmc.lowdraglib.side.fluid.FluidStack;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import com.google.common.primitives.Ints;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;

public class OreProcessingRecipeLogic extends RecipeLogic {

    private static final FluidStack DISTILLED_WATER =
            GTMaterials.DistilledWater.getFluid(Long.MAX_VALUE);
    private static final FluidStack LUBRICANT = GTMaterials.Lubricant.getFluid(Long.MAX_VALUE);
    private static final TagKey<Item> STONE_DUST =
            ChemicalHelper.getTag(TagPrefix.dust, GTMaterials.Stone);
    private static final TagKey<Item> END_STONE_DUST =
            ChemicalHelper.getTag(TagPrefix.dust, GTMaterials.Endstone);
    private static final TagKey<Item> NETHER_RACK_DUST =
            ChemicalHelper.getTag(TagPrefix.dust, GTMaterials.Netherrack);
    private static final TagKey<Item> ORE_TAG = TagUtil.createItemTag("ores");

    private ItemStack[] midProduct;
    protected List<FluidStack> fluidInputs;
    protected List<FluidStack> fluidOutputs;

    protected SimpleCapabilityHolder holder;

    public OreProcessingRecipeLogic(IntegratedOreFactoryMachine machine) {
        super(machine);
        this.holder = new SimpleCapabilityHolder();
    }

    @Override
    public IntegratedOreFactoryMachine getMachine() {
        return (IntegratedOreFactoryMachine) super.getMachine();
    }

    @Override
    public void findAndHandleRecipe() {
        if (getMachine().getLevel() instanceof ServerLevel) {
            lastRecipe = null;
            handleRecipe();
        }
    }

    @Override
    public void onRecipeFinish() {
        machine.afterWorking();
        if (lastRecipe != null) {
            lastRecipe.postWorking(this.machine);
            lastRecipe.handleRecipeIO(IO.OUT, this.machine);
        }
        if (!handleRecipe()) {
            setStatus(Status.IDLE);
            progress = 0;
            duration = 0;
        }
    }

    private boolean handleRecipe() {
        var match = getProcessingRecipe();
        if (match != null) {
            GTRecipe modified = this.machine.fullModifyRecipe(match);
            if (modified != null) {
                if (modified.checkConditions(this).isSuccess()
                        && modified.matchRecipe(this.machine).isSuccess()
                        && modified.matchTickRecipe(this.machine).isSuccess()) {
                    this.setupRecipe(modified);
                    return true;
                }
            }
        }
        return false;
    }

    @Nullable private GTRecipe getProcessingRecipe() {
        int charged = getParallels();
        List<ItemStack> inputItems = getInputItems();
        var tInput = getInputTank();
        var lubricant = GTTransferUtils.drainFluidAccountNotifiableList(tInput, LUBRICANT, true);
        var water = GTTransferUtils.drainFluidAccountNotifiableList(tInput, DISTILLED_WATER, true);

        charged = (int) Math.min(charged, lubricant.getAmount() / 2);
        charged = (int) Math.min(charged, water.getAmount() / 200);
        charged = (int) Math.min(charged, getMaxHatchVoltage() / 30L);

        List<ItemStack> ores = new ArrayList<>();
        int realUsed = 0;

        for (ItemStack stack : inputItems) {
            if (charged <= 0) break;
            if (checkTags(
                    stack.getItem(),
                    ore,
                    rawOre,
                    crushed,
                    crushedPurified,
                    crushedRefined,
                    dustImpure,
                    dustPure)) {
                if (stack.getCount() <= charged) {
                    realUsed += stack.getCount();
                    ores.add(stack.copy());
                    charged -= stack.getCount();
                } else {
                    realUsed = charged;
                    ores.add(stack.copyWithCount(realUsed));
                    break;
                }
            }
        }

        if (realUsed != 0) {
            fluidInputs = new ArrayList<>();
            fluidOutputs = new ArrayList<>();
            fluidInputs.add(GTMaterials.DistilledWater.getFluid(realUsed * 200L));
            fluidInputs.add(GTMaterials.Lubricant.getFluid(realUsed * 2L));

            midProduct = ores.toArray(new ItemStack[0]);
            switch (getMode()) {
                case 0 -> {
                    doMac(ore, rawOre);
                    doWash(crushed);
                    doThermal(crushedPurified, crushed);
                    doMac(crushedRefined, ore, rawOre, crushed, crushedPurified);
                }
                case 1 -> {
                    doMac(ore, rawOre);
                    doWash(crushed);
                    doMac(ore, rawOre, crushed, crushedPurified);
                    doCentrifuge(dustImpure, dustPure);
                }
                case 2 -> {
                    doMac(ore, rawOre);
                    doMac(crushedRefined, ore, rawOre, crushed, crushedPurified);
                    doCentrifuge(dustImpure, dustPure);
                }
                case 3 -> {
                    doMac(ore, rawOre);
                    doWash(crushed);
                    doSift(crushedPurified);
                }
                case 4 -> {
                    doMac(ore, rawOre);
                    doChemWash(crushed);
                    doMac(crushed, crushedPurified);
                    doCentrifuge(dustImpure, dustPure);
                }
                default -> {}
            }

            var builder = GTRecipeBuilder.ofRaw().duration(getTime(getMode())).EUt(30L * realUsed);
            ores.forEach(builder::inputItems);
            fluidInputs.forEach(builder::inputFluids);
            fluidOutputs.forEach(builder::outputFluids);
            for (var item : midProduct) {
                builder.outputItems(item);
            }
            fluidInputs = null;
            fluidOutputs = null;
            return builder.buildRawRecipe();
        }
        return null;
    }

    //  对中间产物进行配方检测，输出加入products，无输出则向products加入stack
    private void doMac(TagPrefix... tags) {
        List<ItemStack> products = new ArrayList<>();
        if (midProduct != null) {
            for (ItemStack stack : midProduct) {
                if (checkTags(stack.getItem(), tags)) {
                    holder.addItems(stack);
                    GTRecipe recipe = GTRecipeTypes.MACERATOR_RECIPES.getLookup().findRecipe(holder);
                    holder.clear();
                    if (recipe != null) {
                        products.addAll(getOutputStack(recipe, stack.getCount()));
                    } else {
                        products.add(stack);
                    }
                } else {
                    products.add(stack);
                }
            }
        }
        doCompress(products);
    }

    private void doWash(TagPrefix... tags) {
        List<ItemStack> products = new ArrayList<>();
        if (midProduct != null) {
            for (ItemStack stack : midProduct) {
                if (checkTags(stack.getItem(), tags)) {
                    holder.addItems(stack);
                    holder.addFluids(DISTILLED_WATER.copy());
                    GTRecipe recipe = GTRecipeTypes.ORE_WASHER_RECIPES.getLookup().findRecipe(holder);
                    holder.clear();
                    if (recipe != null) {
                        products.addAll(getOutputStack(recipe, stack.getCount()));
                    } else {
                        products.add(stack);
                    }
                } else {
                    products.add(stack);
                }
            }
        }
        doCompress(products);
    }

    private void doThermal(TagPrefix... tags) {
        List<ItemStack> products = new ArrayList<>();
        if (midProduct != null) {
            for (ItemStack stack : midProduct) {
                if (checkTags(stack.getItem(), tags)) {
                    holder.addItems(stack);
                    GTRecipe recipe = GTRecipeTypes.THERMAL_CENTRIFUGE_RECIPES.getLookup().findRecipe(holder);
                    holder.clear();
                    if (recipe != null) {
                        products.addAll(getOutputStack(recipe, stack.getCount()));
                    } else {
                        products.add(stack);
                    }
                } else {
                    products.add(stack);
                }
            }
        }
        doCompress(products);
    }

    private void doCentrifuge(TagPrefix... tags) {
        List<ItemStack> products = new ArrayList<>();
        if (midProduct != null) {
            for (ItemStack stack : midProduct) {
                if (checkTags(stack.getItem(), tags)) {
                    holder.addItems(stack);
                    GTRecipe recipe = GTRecipeTypes.CENTRIFUGE_RECIPES.getLookup().findRecipe(holder);
                    holder.clear();
                    if (recipe != null) {
                        products.addAll(getOutputStack(recipe, stack.getCount()));
                    } else {
                        products.add(stack);
                    }
                } else {
                    products.add(stack);
                }
            }
        }
        doCompress(products);
    }

    private void doSift(TagPrefix... tags) {
        List<ItemStack> products = new ArrayList<>();
        if (midProduct != null) {
            for (ItemStack stack : midProduct) {
                if (checkTags(stack.getItem(), tags)) {
                    holder.addItems(stack);
                    GTRecipe recipe = GTRecipeTypes.SIFTER_RECIPES.getLookup().findRecipe(holder);
                    holder.clear();
                    if (recipe != null) {
                        products.addAll(getOutputStack(recipe, stack.getCount()));
                    } else {
                        products.add(stack);
                    }
                } else {
                    products.add(stack);
                }
            }
        }
        doCompress(products);
    }

    //  化学浸洗，额外计算消耗的液体并消耗，向products加入已浸洗物品的产物和未浸洗物品
    private void doChemWash(TagPrefix... tags) {
        if (midProduct == null) return;

        List<ItemStack> products = new ArrayList<>();
        for (ItemStack stack : midProduct) {
            if (!checkTags(stack.getItem(), tags)) {
                products.add(stack);
                continue;
            }

            holder.addItems(stack);
            holder.addFluids(EPUtil.fluidHandlerToList(getInputTank()));
            GTRecipe recipe = GTRecipeTypes.CHEMICAL_BATH_RECIPES.getLookup().findRecipe(holder);
            holder.clear();
            if (recipe != null) {
                var inputFluids = MORecipeHelper.getInputFluid(recipe);
                var outputFluids = MORecipeHelper.getOutputFluid(recipe);
                int washed = stack.getCount();
                if (!inputFluids.isEmpty()) {
                    var inputFluid = inputFluids.get(0);
                    long stored = getFluidAmount(inputFluid);
                    washed = Ints.saturatedCast(Math.min(stored / inputFluid.getAmount(), stack.getCount()));
                    fluidInputs.add(inputFluid.copy(washed * inputFluid.getAmount()));
                    if (washed < stack.getCount()) {
                        products.add(stack.copyWithCount(stack.getCount() - washed));
                    }
                }

                if (!outputFluids.isEmpty()) {
                    var outputFluid = inputFluids.get(0);
                    fluidOutputs.add(outputFluid.copy(washed * outputFluid.getAmount()));
                }
                products.addAll(getOutputStack(recipe, washed));
            }
        }
        doCompress(products);
    }

    //  计算配方产物带概率输出
    private List<ItemStack> getOutputStack(GTRecipe recipe, int time) {
        List<ItemStack> outputs = new ArrayList<>();
        for (var content : recipe.getOutputContents(ItemRecipeCapability.CAP)) {
            if (content.chance == 1) {
                for (ItemStack item : ItemRecipeCapability.CAP.of(content.getContent()).getItems()) {
                    outputs.add(item.copyWithCount(item.getCount() * time));
                }
            }

            if (content.chance < 1 && content.chance > 0) {
                //  计算产出概率
                float chance = content.chance;
                for (ItemStack item : ItemRecipeCapability.CAP.of(content.getContent()).getItems()) {
                    // Use Normal Distribution 正态分布
                    double u = time * chance;
                    double e = time * chance * (1 - chance);
                    int amount = (int) Math.ceil(Math.sqrt(e) * GTValues.RNG.nextGaussian() + u);
                    outputs.add(item.copyWithCount(amount * item.getCount()));
                }
            }
        }

        return outputs.stream()
                .filter(Objects::nonNull)
                .filter(Predicate.not(ItemStack::isEmpty))
                .collect(Collectors.toList());
    }

    //  用products中的物品更新midProduct
    private void doCompress(List<ItemStack> list) {
        HashMap<Item, Integer> products = new HashMap<>();
        for (ItemStack stack : list) {
            var item = stack.getItem();
            //  开启石粉销毁，则跳过加入石粉的循环
            if (isVoidStone()) {
                if (isStoneDust(item)) {
                    continue;
                }
            }
            //  重复物品
            products.merge(item, stack.getCount(), Integer::sum);
        }
        //  更新midProduct
        midProduct = new ItemStack[products.size()];
        products.forEach((item, amount) -> MOUtils.add(midProduct, new ItemStack(item, amount)));
    }

    // 不要修改返回的ItemStack
    private List<ItemStack> getInputItems() {
        List<ItemStack> list = new ArrayList<>();
        for (int index = 0; index < getInputInventory().getSlots(); index++) {
            final ItemStack currentInputItem = getInputInventory().getStackInSlot(index);
            if (currentInputItem.isEmpty()) continue;
            list.add(currentInputItem);
        }
        return list;
    }

    // 查询存储的fluid数量
    private long getFluidAmount(FluidStack fluid) {
        if (fluid == null) return 0;
        return GTTransferUtils.drainFluidAccountNotifiableList(
                        getInputTank(), fluid.copy(Long.MAX_VALUE), true)
                .getAmount();
    }

    private boolean checkTags(Item item, TagPrefix... tagPrefixes) {
        var prefix = ChemicalHelper.getPrefix(item);
        for (TagPrefix tagPrefix : tagPrefixes) {
            if (tagPrefix.equals(ore) && item.builtInRegistryHolder().is(ORE_TAG)) {
                return true;
            }

            if (tagPrefix.equals(prefix)) {
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("all")
    private boolean isStoneDust(Item item) {
        var holder = item.builtInRegistryHolder();
        return holder.is(STONE_DUST) || holder.is(END_STONE_DUST) || holder.is(NETHER_RACK_DUST);
    }

    private ItemTransferList getInputInventory() {
        return getMachine().getInputBuses();
    }

    private FluidTransferList getInputTank() {
        return getMachine().getInputHatches();
    }

    private static int getTime(int mode) {
        return switch (mode) {
            case 0 -> 30 * 20;
            case 1 -> 15 * 20;
            case 2 -> 10 * 20;
            case 3 -> 20 * 20;
            case 4 -> 17 * 20;
            default -> 1000000000;
        };
    }

    private long getMaxHatchVoltage() {
        return getMachine().getMaxVoltage();
    }

    private int getParallels() {
        return getMachine().getParallelNumber();
    }

    private boolean isVoidStone() {
        return getMachine().isVoidStone();
    }

    private int getMode() {
        return getMachine().getMode();
    }
}
