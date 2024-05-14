package cn.gtcommunity.epimorphism.common.block;

import cn.gtcommunity.epimorphism.api.block.tier.IChemicalPlantCasing;
import cn.gtcommunity.epimorphism.common.machine.multiblock.electric.agriculture.ForestryGreenhouseMachine;
import com.epimorphismmc.monomorphism.block.tier.ITierType;
import com.epimorphismmc.monomorphism.block.tier.WrappedTierType;
import com.gregtechceu.gtceu.GTCEu;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

import java.util.Map;
import java.util.function.Supplier;

import static cn.gtcommunity.epimorphism.common.data.EPBlocks.*;
import static com.gregtechceu.gtceu.common.data.GTBlocks.*;
import static com.gregtechceu.gtceu.common.data.GTBlocks.FIREBOX_TUNGSTENSTEEL;

public class BlockMaps {
    // Glasses
    public static final Object2ObjectOpenHashMap<ITierType, Supplier<Block>> ALL_GLASSES = new Object2ObjectOpenHashMap<>();
    public static final Object2ObjectOpenHashMap<ITierType, Supplier<Block>> SHAPE_GLASSES = new Object2ObjectOpenHashMap<>();

    // Yotta Fluid Tank
    public static final Object2ObjectOpenHashMap<ITierType, Supplier<Block>> ALL_FLUID_CELLS = new Object2ObjectOpenHashMap<>();

    // TFFT
    public static final Object2ObjectOpenHashMap<ITierType, Supplier<Block>> ALL_FIELD_BLOCKS = new Object2ObjectOpenHashMap<>();

    // Component Assembly Line
    public static final Object2ObjectOpenHashMap<ITierType, Supplier<Block>> ALL_CA_TIRED_CASINGS = new Object2ObjectOpenHashMap<>();

    // Chemical Plant
    public static final Object2ObjectOpenHashMap<ITierType, Supplier<Block>> ALL_CP_CASINGS = new Object2ObjectOpenHashMap<>();
    public static final Object2ObjectOpenHashMap<ITierType, Supplier<Block>> ALL_CP_TUBES = new Object2ObjectOpenHashMap<>();

    // Precise Assembler
    public static final Object2ObjectOpenHashMap<ITierType, Supplier<Block>> ALL_PA_CASINGS = new Object2ObjectOpenHashMap<>();

    // Eye of Harmony
    public static final Object2ObjectOpenHashMap<ITierType, Supplier<Block>> SC_FIELD_GENERATORS = new Object2ObjectOpenHashMap<>();
    public static final Object2ObjectOpenHashMap<ITierType, Supplier<Block>> ST_FIELD_GENERATORS = new Object2ObjectOpenHashMap<>();
    public static final Object2ObjectOpenHashMap<ITierType, Supplier<Block>> TA_FIELD_GENERATORS = new Object2ObjectOpenHashMap<>();

    // Space Elevator
    public static final Object2ObjectOpenHashMap<ITierType, Supplier<Block>> ALL_ELEVATOR_MOTORS = new Object2ObjectOpenHashMap<>();

    // Univer
    public static final Object2ObjectOpenHashMap<ITierType, Supplier<Block>> ALL_FIREBOXS = new Object2ObjectOpenHashMap<>();
    public static final Object2ObjectOpenHashMap<String, Supplier<Block>> ALL_DIM_DISPLAY_BLOCKS = new Object2ObjectOpenHashMap<>();

    public static void init() {

        //  ALL_CP_TUBES Init
        simpleTierTypeAdd(ALL_CP_TUBES, CASING_BRONZE_PIPE, 1);
        simpleTierTypeAdd(ALL_CP_TUBES, CASING_STEEL_PIPE, 2);
        simpleTierTypeAdd(ALL_CP_TUBES, CASING_TITANIUM_PIPE, 3);
        simpleTierTypeAdd(ALL_CP_TUBES, CASING_TUNGSTENSTEEL_PIPE, 4);

        //  ALL_CP_CASINGS Init
        CPTierTypeAdd(CASING_BRONZE_BRICKS, 1, GTCEu.id("block/casings/solid/machine_casing_bronze_plated_bricks"));
        CPTierTypeAdd(CASING_STEEL_SOLID, 2, GTCEu.id("block/casings/solid/machine_casing_solid_steel"));
        CPTierTypeAdd(CASING_ALUMINIUM_FROSTPROOF, 3, GTCEu.id("block/casings/solid/machine_casing_frost_proof"));
        CPTierTypeAdd(CASING_STAINLESS_CLEAN, 4, GTCEu.id("block/casings/solid/machine_casing_clean_stainless_steel"));
        CPTierTypeAdd(CASING_TITANIUM_STABLE, 5, GTCEu.id("block/casings/solid/machine_casing_stable_titanium"));
        CPTierTypeAdd(CASING_TUNGSTENSTEEL_ROBUST, 6, GTCEu.id("block/casings/solid/machine_casing_robust_tungstensteel"));

        //  ALL_PA_CASINGS Init
        simpleTierTypeAdd(ALL_PA_CASINGS, PRECISE_ASSEMBLER_CASING_MK1, 1);
        simpleTierTypeAdd(ALL_PA_CASINGS, PRECISE_ASSEMBLER_CASING_MK2, 2);
        simpleTierTypeAdd(ALL_PA_CASINGS, PRECISE_ASSEMBLER_CASING_MK3, 3);

        //  ALL_FIREBOXS Init
        simpleTierTypeAdd(ALL_FIREBOXS, FIREBOX_BRONZE::get, 1);
        simpleTierTypeAdd(ALL_FIREBOXS, FIREBOX_STEEL::get, 2);
        simpleTierTypeAdd(ALL_FIREBOXS, FIREBOX_TITANIUM::get, 3);
        simpleTierTypeAdd(ALL_FIREBOXS, FIREBOX_TUNGSTENSTEEL::get, 4);

        // Misc
        ForestryGreenhouseMachine.addGrasses();
    }

    private static void simpleTierTypeAdd(Map<ITierType, Supplier<Block>> map, Supplier<Block> blockSupplier, int tier) {
        map.put(new WrappedTierType<>(blockSupplier, tier), blockSupplier);
    }

    private static void CPTierTypeAdd(Supplier<Block> blockSupplier, int tier, ResourceLocation location) {
        ALL_CP_CASINGS.put(new IChemicalPlantCasing.CPCasingType(blockSupplier.get().getDescriptionId(), tier, location), blockSupplier);
    }
}
