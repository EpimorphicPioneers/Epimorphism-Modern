package cn.gtcommunity.epimorphism.common.machine.trait;

import cn.gtcommunity.epimorphism.common.machine.multiblock.electric.agriculture.IndustrialFishingPondMachine;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.machine.feature.IRecipeLogicMachine;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.common.data.GTRecipeModifiers;
import com.gregtechceu.gtceu.data.recipe.builder.GTRecipeBuilder;
import com.lowdragmc.lowdraglib.side.fluid.FluidStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.FishingHook;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;

public class FishingPondRecipeLogic extends RecipeLogic {
    public static final int MAX_PROGRESS = 20 * 20;
    public static final long ENERGY = GTValues.VA[GTValues.HV];
    public static final FluidStack STACK = FluidStack.create(Fluids.WATER, 1000);

    private static final ItemStack fishingRod = new ItemStack(Items.FISHING_ROD);

    public FishingPondRecipeLogic(IRecipeLogicMachine machine) {
        super(machine);
    }

    @Override
    public IndustrialFishingPondMachine getMachine() {
        return (IndustrialFishingPondMachine)super.getMachine();
    }

    @Override
    public void serverTick() {
        super.serverTick();
        if (!this.isSuspend() && getMachine().getLevel() instanceof ServerLevel) {
            if (getMachine().getOffsetTimer() % 20 == 0) {
                getMachine().setFilledWater(checkWater());
            }
        }
    }

    @Override
    public void findAndHandleRecipe() {
        if (getMachine().getLevel() instanceof ServerLevel) {
            lastRecipe = null;
            var match = getFishingRecipe();
            if (match != null) {
                if (match.matchRecipe(this.machine).isSuccess() && match.matchTickRecipe(this.machine).isSuccess()) {
                    setupRecipe(match);
                }
            }
        }
    }

    @Override
    public void onRecipeFinish() {
        machine.afterWorking();
        if (lastRecipe != null) {
            lastRecipe.postWorking(this.machine);
            lastRecipe.handleRecipeIO(IO.OUT, this.machine);
        }

        var match = getFishingRecipe();
        if (match != null) {
            if (match.matchRecipe(this.machine).isSuccess() && match.matchTickRecipe(this.machine).isSuccess()) {
                setupRecipe(match);
                return;
            }
        }

        setStatus(Status.IDLE);
        progress = 0;
        duration = 0;
    }

    @Nullable
    private GTRecipe getFishingRecipe() {
        var machine = getMachine();
        var level = getLevel();
        if (!machine.isFilledWater()) return null;

        LootTable lootTable = level.getServer().getLootData().getLootTable(switch (machine.getMode()) {
            case 0 -> BuiltInLootTables.FISHING_FISH;
            case 1 -> BuiltInLootTables.FISHING_JUNK;
            case 2 -> BuiltInLootTables.FISHING_TREASURE;
            default -> BuiltInLootTables.FISHING;
        });

        FishingHook simulatedHook = new FishingHook(EntityType.FISHING_BOBBER, level) {
            public boolean isOpenWaterFishing() {
                return true;
            }
        };

        LootParams lootContext = new LootParams.Builder(level)
                .withOptionalParameter(LootContextParams.THIS_ENTITY, simulatedHook)
                .withParameter(LootContextParams.TOOL, fishingRod)
                .withParameter(LootContextParams.ORIGIN, new Vec3(getPos().getX(), getPos().getY(), getPos().getZ()))
                .create(LootContextParamSets.FISHING);

        var builder = GTRecipeBuilder.ofRaw()
                .duration(MAX_PROGRESS)
                .EUt(ENERGY);

        var tuple = GTRecipeModifiers.accurateParallel(machine,
                GTRecipeBuilder.ofRaw().copyFrom(builder).outputItems(Items.BARRIER.getDefaultInstance()).buildRawRecipe(),
                (int) Math.min(machine.getParallelNumber(), machine.getMaxVoltage() / ENERGY), false);
        int parallel = tuple.getB();
        NonNullList<ItemStack> generatedLoot = NonNullList.create();
        for (int i = 0; i < parallel; i++) {
            generatedLoot.addAll(lootTable.getRandomItems(lootContext));
        }

        generatedLoot.stream()
                .filter(itemStack -> !itemStack.isEmpty())
                .forEach(builder::outputItems);
        var recipe = builder.EUt(ENERGY * parallel).buildRawRecipe();

        var newRecipe = machine.doModifyRecipe(recipe);
        if (newRecipe != null) {
            if (newRecipe.matchRecipe(machine).isSuccess() && newRecipe.matchTickRecipe(machine).isSuccess()) {
                return newRecipe;
            }
        }
        return recipe;
    }

    private Boolean checkWater() {
        int mCurrentDirectionX = 4;
        int mCurrentDirectionZ = 4;
        int mOffsetX_Lower = -4;
        int mOffsetX_Upper = 4;
        int mOffsetZ_Lower = -4;
        int mOffsetZ_Upper = 4;

        final int xDir = getMachine().getFrontFacing().getOpposite().getStepX()
                * mCurrentDirectionX;
        final int zDir = getMachine().getFrontFacing().getOpposite().getStepZ()
                * mCurrentDirectionZ;

        var machine = getMachine();
        var level = machine.getLevel();
        var pos = machine.getPos();
        int tAmount = 0;

        for (int i = mOffsetX_Lower + 1; i <= mOffsetX_Upper - 1; ++i) {
            for (int j = mOffsetZ_Lower + 1; j <= mOffsetZ_Upper - 1; ++j) {
                for (int h = 0; h < 2; h++) {
                    BlockPos.MutableBlockPos waterCheckPos = pos.mutable().move(xDir + i, h, zDir + j);
                    FluidState fluidState = level.getBlockState(waterCheckPos).getFluidState();

                    if (!fluidState.is(Fluids.WATER) && canFill(waterCheckPos) && depleteWater()) {
                        level.destroyBlock(waterCheckPos, true);
                        level.setBlock(waterCheckPos, Blocks.WATER.defaultBlockState(), Block.UPDATE_ALL);
                    }

                    fluidState = level.getBlockState(waterCheckPos).getFluidState();
                    if (fluidState.is(Fluids.WATER)) {
                        ++tAmount;
                    }
                }
            }
        }

        return tAmount >= 98;
    }

    private boolean depleteWater() {
        var recipe = GTRecipeBuilder.ofRaw().inputFluids(STACK).buildRawRecipe();
        if (recipe.matchRecipe(getMachine()).isSuccess()) {
            return recipe.handleRecipeIO(IO.IN, getMachine());
        }
        return false;
    }

    private boolean canFill(BlockPos pos) {
        return getMachine().getLevel().getBlockState(pos).canBeReplaced(Fluids.WATER);
    }

    private ServerLevel getLevel() {
        return (ServerLevel) getMachine().getLevel();
    }

    private BlockPos getPos() {
        return getMachine().getPos();
    }
}
