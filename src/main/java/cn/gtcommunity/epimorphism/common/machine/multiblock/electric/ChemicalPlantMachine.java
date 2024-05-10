package cn.gtcommunity.epimorphism.common.machine.multiblock.electric;

import cn.gtcommunity.epimorphism.api.block.tier.IChemicalPlantCasing;
import cn.gtcommunity.epimorphism.api.machine.multiblock.ParallelElectricMultiblockMachine;
import cn.gtcommunity.epimorphism.api.block.tier.ITierType;
import cn.gtcommunity.epimorphism.common.block.BlockMaps;
import cn.gtcommunity.epimorphism.utils.EPUtil;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.block.ICoilType;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiPart;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.RecipeHelper;
import com.lowdragmc.lowdraglib.syncdata.annotation.DescSynced;
import com.lowdragmc.lowdraglib.syncdata.annotation.RequireRerender;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import lombok.Getter;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ChemicalPlantMachine extends ParallelElectricMultiblockMachine {

    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(ChemicalPlantMachine.class, ParallelElectricMultiblockMachine.MANAGED_FIELD_HOLDER);

    @Getter @DescSynced @RequireRerender
    private int casingTier;
    @Getter
    private int coilLevel;
    @Getter
    private int tubeTier;
    @Getter
    private int voltageTier;

    private static final Map<Integer, ResourceLocation> TEXTURE_MAP = Collections.unmodifiableMap(BlockMaps.ALL_CP_CASINGS.keySet().stream()
            .filter(IChemicalPlantCasing.class::isInstance)
            .map(IChemicalPlantCasing.class::cast)
            .collect(Collectors.toMap(IChemicalPlantCasing::tier, IChemicalPlantCasing::texture)));

    private static final Map<Integer, BlockState> APPEARANCE_MAP = Collections.unmodifiableMap(BlockMaps.ALL_CP_CASINGS.keySet().stream()
            .collect(Collectors.toMap(ITierType::tier, type -> BlockMaps.ALL_CP_CASINGS.get(type).get().defaultBlockState())));

    public ChemicalPlantMachine(IMachineBlockEntity holder, Object... args) {
        super(holder, machine -> Math.max((((ChemicalPlantMachine) machine).getTubeTier() - 1) * 2 + 1, 1), args);
    }

    //////////////////////////////////////
    //***    Multiblock LifeCycle    ***//
    //////////////////////////////////////

    @Override
    public void onStructureFormed() {
        super.onStructureFormed();
        var context = getMultiblockState().getMatchContext();
        Object coilType = context.get("CoilType");
        Object casingTier = context.get("CPCasing");
        Object tubeTier = context.get("CPPipe");
        Object voltageTier = context.get("MachineCasing");
        this.coilLevel = EPUtil.getOrDefault(() -> coilType instanceof ICoilType,
                () -> ((ICoilType) coilType).getTier(), 0);
        this.tubeTier = EPUtil.getOrDefault(() -> tubeTier instanceof ITierType,
                () -> ((ITierType) tubeTier).tier(), 0);
        this.voltageTier = EPUtil.getOrDefault(() -> voltageTier instanceof ITierType,
                () -> ((ITierType) voltageTier).tier(), 0);
        this.casingTier = EPUtil.getOrDefault(() -> casingTier instanceof IChemicalPlantCasing,
                () -> ((IChemicalPlantCasing) casingTier).tier(), 0);
    }

    @Override
    public void onStructureInvalid() {
        super.onStructureInvalid();
        coilLevel = 0;
        casingTier = 0;
        tubeTier = 0;
        voltageTier = 0;
    }

    //////////////////////////////////////
    //******     Recipe Logic    *******//
    //////////////////////////////////////

    @Override
    protected @Nullable GTRecipe getRealRecipe(GTRecipe recipe) {
        if (voltageTier < GTValues.UHV && RecipeHelper.getRecipeEUtTier(recipe) > voltageTier) {
            return null;
        }
        var modified = super.getRealRecipe(recipe);
        if (getCasingTier() > 0) {
            var copied = recipe == modified ? modified.copy() : modified;
            if (copied != null) {
                copied.duration = (int) (copied.duration / (1 + getCoilLevel() * 0.5));
            }
            return copied;
        }
        return modified;
    }

    //////////////////////////////////////
    //***        Multiblock UI       ***//
    //////////////////////////////////////

    @Override
    public void addDisplayText(@NotNull List<Component> textList) {
        super.addDisplayText(textList);
        if (isFormed()) {
            textList.add(Component.translatable("block.epimorphism.chemical_plant.voltage", GTValues.VNF[voltageTier]));
            textList.add(Component.translatable("recipe.condition.chemical_plant_casing.desc.%s".formatted(getCasingTier())));
            textList.add(Component.translatable("block.epimorphism.chemical_plant.speed", 100 + 50 * getCoilLevel()));
            textList.add(Component.translatable("block.epimorphism.chemical_plant.chance", getChance()));
        }
    }

    //////////////////////////////////////
    //***       Multiblock Data      ***//
    //////////////////////////////////////

    public int getChance() {
        return Math.min(100 - 20 * (getTubeTier() - 1), 100);
    }

    public static @Nullable ResourceLocation locationGetter(MetaMachine machine) {
        if (machine instanceof ChemicalPlantMachine chemicalPlant && chemicalPlant.isFormed()) {
            return TEXTURE_MAP.get(chemicalPlant.casingTier);
        }
        return null;
    }

    @Nullable
    @Override
    public BlockState getPartAppearance(IMultiPart part, Direction side, BlockState sourceState, BlockPos sourcePos) {
        var appearanceBlock = APPEARANCE_MAP.get(casingTier);
        return appearanceBlock != null ? appearanceBlock : super.getPartAppearance(part, side, sourceState, sourcePos);
    }

    @NotNull
    @Override
    public BlockState getBlockAppearance(BlockState state, BlockAndTintGetter level, BlockPos pos, Direction side, BlockState sourceState, BlockPos sourcePos) {
        var appearanceBlock = APPEARANCE_MAP.get(casingTier);
        return appearanceBlock != null ? appearanceBlock : super.getBlockAppearance(state, level, pos, side, sourceState, sourcePos);
    }

    @Override
    public @NotNull ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }
}
