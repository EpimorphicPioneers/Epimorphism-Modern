package cn.gtcommunity.epimorphism.common.data;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.api.block.tier.ITierGlassType;
import cn.gtcommunity.epimorphism.api.block.tier.IFluidTankCell;
import cn.gtcommunity.epimorphism.api.block.tier.IStorageFieldBlock;
import cn.gtcommunity.epimorphism.api.data.chemical.material.properties.EPPropertyKeys;
import cn.gtcommunity.epimorphism.api.data.tag.EPTagPrefix;
import cn.gtcommunity.epimorphism.common.registry.EPRegistration;
import cn.gtcommunity.epimorphism.client.renderer.handler.block.PlanetDisplayRenderer;
import cn.gtcommunity.epimorphism.common.block.*;
import cn.gtcommunity.epimorphism.common.block.MaterialFenceBlock;
import cn.gtcommunity.epimorphism.common.data.items.EPAgricultureItems;
import cn.gtcommunity.epimorphism.core.mixins.accessors.BlockLootSubProviderAccessor;
import cn.gtcommunity.epimorphism.data.lang.EPLangHelper;
import com.epimorphismmc.monomorphism.block.CasingBlock;
import com.epimorphismmc.monomorphism.block.tier.ITierType;
import com.epimorphismmc.monomorphism.block.tier.SimpleTierBlock;
import com.epimorphismmc.monomorphism.item.MOMaterialBlockItem;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Table;
import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.block.ActiveBlock;
import com.gregtechceu.gtceu.api.block.IFusionCasingType;
import com.gregtechceu.gtceu.api.block.RendererBlock;
import com.gregtechceu.gtceu.api.block.RendererGlassBlock;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.registry.MaterialRegistry;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.item.MaterialBlockItem;
import com.gregtechceu.gtceu.api.item.RendererBlockItem;
import com.gregtechceu.gtceu.api.item.tool.GTToolType;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import com.gregtechceu.gtceu.client.renderer.block.CTMModelRenderer;
import com.gregtechceu.gtceu.client.renderer.block.TextureOverrideRenderer;
import com.gregtechceu.gtceu.common.block.FusionCasingBlock;
import com.gregtechceu.gtceu.common.data.*;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import com.lowdragmc.lowdraglib.Platform;
import com.lowdragmc.lowdraglib.client.renderer.IRenderer;
import com.tterrag.registrate.providers.ProviderType;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullBiConsumer;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Supplier;

import static cn.gtcommunity.epimorphism.common.registry.EPRegistration.EP_REGISTRATE;
import static cn.gtcommunity.epimorphism.common.block.BlockMaps.*;
import static cn.gtcommunity.epimorphism.common.block.DimensionDisplayBlock.Dimension.*;
import static com.gregtechceu.gtceu.common.data.GTBlocks.*;
import static com.gregtechceu.gtceu.common.data.GTModels.createModelBlockState;
import static com.gregtechceu.gtceu.common.registry.GTRegistration.REGISTRATE;

@SuppressWarnings("all")
public class EPBlocks {

    //////////////////////////////////////
    //*****     Tables Builders    *****//
    //////////////////////////////////////
    private static ImmutableTable.Builder<TagPrefix, Material, BlockEntry<CrucibleBlock>> CRUCIBLE_BLOCKS_BUILDER = ImmutableTable.builder();
    private static ImmutableTable.Builder<TagPrefix, Material, BlockEntry<MaterialFenceBlock>> FENCE_BLOCKS_BUILDER = ImmutableTable.builder();

    //////////////////////////////////////
    //*****    Reference Tables    *****//
    //////////////////////////////////////

    public static Table<TagPrefix, Material, BlockEntry<CrucibleBlock>> CRUCIBLE_BLOCKS;
    public static Table<TagPrefix, Material, BlockEntry<MaterialFenceBlock>> FENCE_BLOCKS;

    // Crucible Blocks
    private static void generateCrucibleBlocks() {
        Epimorphism.LOGGER.debug("Generating Epimorphism Crucible Blocks...");
        for (MaterialRegistry registry : GTCEuAPI.materialManager.getRegistries()) {
            GTRegistrate registrate = registry.getRegistrate();
            for (Material material : registry.getAllMaterials()) {
                if (allowCrucibleBlock(material)) {
                    registerCrucibleBlock(material, registrate);
                }
            }
        }
        CRUCIBLE_BLOCKS = CRUCIBLE_BLOCKS_BUILDER.build();
        Epimorphism.LOGGER.debug("Generating Epimorphism Crucible Blocks... Complete!");
    }

    private static boolean allowCrucibleBlock(Material material) {
        return material.hasProperty(EPPropertyKeys.CRUCIBLE);
    }

    private static void generateFenceBlocks() {
        Epimorphism.LOGGER.debug("Generating Epimorphism Fence Blocks...");
        for (MaterialRegistry registry : GTCEuAPI.materialManager.getRegistries()) {
            GTRegistrate registrate = registry.getRegistrate();
            for (Material material : registry.getAllMaterials()) {
                if (allowFenceBlock(material)) {
                    registerFenceBlock(material, registrate);
                }
            }
        }
        FENCE_BLOCKS = FENCE_BLOCKS_BUILDER.build();
        Epimorphism.LOGGER.debug("Generating Epimorphism Fence Blocks... Complete!");
    }

    private static boolean allowFenceBlock(Material material) {
        return material.hasProperty(EPPropertyKeys.FENCE);
    }

    private static void registerCrucibleBlock(Material material, GTRegistrate registrate) {
        var entry = registrate.block("%s_crucible".formatted(material.getName()), p -> new CrucibleBlock(p, material))
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .properties(p -> EPTagPrefix.crucible.blockProperties().properties().apply(p).noLootTable())
                .transform(GTBlocks.unificationBlock(EPTagPrefix.crucible, material))
                .addLayer(EPTagPrefix.crucible.blockProperties().renderType())
                .setData(ProviderType.BLOCKSTATE, NonNullBiConsumer.noop())
                .setData(ProviderType.LANG, NonNullBiConsumer.noop())
                .setData(ProviderType.LOOT, NonNullBiConsumer.noop())
                .color(() -> CrucibleBlock::tintedColor)
                .item(MaterialBlockItem::create)
                .model(NonNullBiConsumer.noop())
                .color(() -> MaterialBlockItem::tintColor)
                .build()
                .register();
        CRUCIBLE_BLOCKS_BUILDER.put(EPTagPrefix.crucible, material, entry);
    }

    private static void registerFenceBlock(Material material, GTRegistrate registrate) {
        var entry = registrate.block("%s_fence".formatted(material.getName()), p -> new MaterialFenceBlock(p, material, true))
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .properties(p -> EPTagPrefix.fence.blockProperties().properties().apply(p).noLootTable())
                .transform(GTBlocks.unificationBlock(EPTagPrefix.fence, material))
                .addLayer(EPTagPrefix.fence.blockProperties().renderType())
                .setData(ProviderType.BLOCKSTATE, NonNullBiConsumer.noop())
                .setData(ProviderType.LANG, NonNullBiConsumer.noop())
                .setData(ProviderType.LOOT, NonNullBiConsumer.noop())
                .color(() -> MaterialFenceBlock::tintedColor)
                .item(MOMaterialBlockItem::create)
                .model(NonNullBiConsumer.noop())
                .color(() -> MOMaterialBlockItem::tintColor)
                .build()
                .register();
        FENCE_BLOCKS_BUILDER.put(EPTagPrefix.fence, material, entry);
    }

    static {
        EP_REGISTRATE.creativeModeTab(() -> EPCreativeModeTabs.EP_BLOCK);
    }
    //////////////////////////////////////
    //******     Casing Blocks     *****//
    //////////////////////////////////////

    // Multiblock Machine Casing Blocks
    public static final BlockEntry<Block> NAQUADAH_ALLOY_CASING = createCasingBlock("naquadah_alloy_casing", Epimorphism.id("block/casings/solid/naquadah_alloy_casing"));
    public static final BlockEntry<Block> NAQUADRIA_CASING = createCasingBlock("naquadria_casing", Epimorphism.id("block/casings/solid/naquadria_casing"));
    public static final BlockEntry<Block> HYPER_CASING = createCasingBlock("hyper_casing", Epimorphism.id("block/casings/solid/hyper_casing"));
    public static final BlockEntry<Block> TALONITE_CASING = createCasingBlock("talonite_casing", Epimorphism.id("block/casings/solid/talonite_casing"));
    public static final BlockEntry<Block> IRIDIUM_CASING = createCasingBlock("iridium_casing", Epimorphism.id("block/casings/solid/iridium_casing"));
    public static final BlockEntry<Block> BREEDING_CASING = createCasingBlock("breeding_casing", Epimorphism.id("block/casings/solid/breeding_casing"));
    public static final BlockEntry<Block> FARM_CASING = createCasingBlock("farm_casing", Epimorphism.id("block/casings/solid/farm_casing"));
    public static final BlockEntry<Block> TRITANIUM_CASING = createCasingBlock("tritanium_casing", Epimorphism.id("block/casings/solid/tritanium_casing"));
    public static final BlockEntry<Block> QUANTUM_CASING = createCasingBlock("quantum_casing", Epimorphism.id("block/casings/solid/quantum_casing"));
    public static final BlockEntry<Block> AEROSPACE_CASING = createCasingBlock("aerospace_casing", Epimorphism.id("block/casings/solid/aerospace_casing"));
    public static final BlockEntry<Block> COIL_CASING = createCasingBlock("coil_casing", Epimorphism.id("block/casings/solid/coil_casing"));
    public static final BlockEntry<Block> DISH_CASING = createCasingBlock("dish_casing", Epimorphism.id("block/casings/solid/dish_casing"));
    public static final BlockEntry<Block> CONSTRAINT_CASING = createCasingBlock("constraint_casing", Epimorphism.id("block/casings/solid/constraint_casing"));
    public static final BlockEntry<Block> RADIATION_PROOF_MACHINE_CASING = createCasingBlock("radiation_proof_machine_casing", Epimorphism.id("block/casings/solid/radiation_proof_machine_casing"));
    public static final BlockEntry<Block> GENERAL_PROCESSING_CASING = createCasingBlock("general_processing_casing", Epimorphism.id("block/casings/solid/general_processing_casing"));
    public static final BlockEntry<Block> MARAGING_STEEL_CASING = createCasingBlock("maraging_steel_250_casing", Epimorphism.id("block/casings/solid/maraging_steel_250_casing"));
    public static final BlockEntry<Block> BABBITT_ALLOY_CASING = createCasingBlock("babbitt_alloy_casing", Epimorphism.id("block/casings/solid/babbitt_alloy_casing"));
    public static final BlockEntry<Block> NEUTRONIUM_MINING_CASING = createCasingBlock("neutronium_mining_casing", Epimorphism.id("block/casings/solid/neutronium_mining_casing"));
    public static final BlockEntry<Block> ZIRCONIUM_CARBIDE_CASING = createCasingBlock("zirconium_carbide_casing", Epimorphism.id("block/casings/solid/zirconium_carbide_casing"));
    public static final BlockEntry<Block> CASING_SUPERCRITICAL_FLUID_TURBINE = createCasingBlock("machine_casing_turbine_supercritical_fluid", Epimorphism.id("block/casings/mechanic/machine_casing_turbine_supercritical_fluid"));
    public static final BlockEntry<Block> TURBO_ENGINE_CASING = createCasingBlock("turbo_engine_casing", Epimorphism.id("block/casings/solid/turbo_engine_casing"));
    public static final BlockEntry<Block> CORROSION_CASING = createCasingBlock("corrosion_casing", Epimorphism.id("block/casings/solid/corrosion_casing"));
    public static final BlockEntry<Block> HASTELLOYX78_CASING = createCasingBlock("hastelloyx78_casing", Epimorphism.id("block/casings/solid/hastelloyx78_casing"));
    public static final BlockEntry<Block> HASTELLOYK243_CASING = createCasingBlock("hastelloyk243_casing", Epimorphism.id("block/casings/solid/hastelloyk243_casing"));
    public static final BlockEntry<Block> BASIC_PHOTOLITHOGRAPHIC_CASING = createCasingBlock("basic_photolithographic_casing", Epimorphism.id("block/casings/solid/basic_photolithographic_casing"));
    public static final BlockEntry<Block> MOLD_PRINTING_ASSEMBLY_CASING = createCasingBlock("mold_printing_assembly_casing", Epimorphism.id("block/casings/solid/mold_printing_assembly_casing"));
    public static final BlockEntry<Block> RADIATION_PROOF_PHOTOLITHOGRAPHIC_CASING = createCasingBlock("radiation_proof_photolithographic_casing", Epimorphism.id("block/casings/solid/radiation_proof_photolithographic_casing"));
    public static final BlockEntry<Block> BIOLOGICAL_STERILE_MACHINE_CASING = createCasingBlock("biological_sterile_casing", Epimorphism.id("block/casings/solid/biological_sterile_casing"));
    public static final BlockEntry<Block> INFINITY_COOLED_MACHINE_CASING = createCasingBlock("infinity_cooled_casing", Epimorphism.id("block/casings/solid/infinity_cooled_casing"));
    public static final BlockEntry<Block> ADVANCED_INVAR_CASING = createCasingBlock("advanced_invar_casing", Epimorphism.id("block/casings/solid/advanced_invar_casing"));
    public static final BlockEntry<Block> ADVANCED_ALUMINIUM_CASING = createCasingBlock("advanced_aluminium_casing", Epimorphism.id("block/casings/solid/advanced_aluminium_casing"));
    public static final BlockEntry<Block> ADVANCED_FILTER_CASING = createCasingBlock("advanced_filter_casing", Epimorphism.id("block/casings/solid/advanced_filter_casing"));
    public static final BlockEntry<Block> PRECISE_ASSEMBLER_CASING_MK1 = createCasingBlock("precise_assembler_casing_mk1", Epimorphism.id("block/casings/solid/precise_assembler_casing_mk1"));
    public static final BlockEntry<Block> PRECISE_ASSEMBLER_CASING_MK2 = createCasingBlock("precise_assembler_casing_mk2", Epimorphism.id("block/casings/solid/precise_assembler_casing_mk2"));
    public static final BlockEntry<Block> PRECISE_ASSEMBLER_CASING_MK3 = createCasingBlock("precise_assembler_casing_mk3", Epimorphism.id("block/casings/solid/precise_assembler_casing_mk3"));
    public static final BlockEntry<Block> TFFT_CASING = createCasingBlock("tfft_casing", Epimorphism.id("block/casings/solid/tfft_casing"));
    public static final BlockEntry<Block> PROCESS_MACHINE_CASING = createCasingBlock("process_machine_casing", Epimorphism.id("block/casings/solid/process_machine_casing"));
    public static final BlockEntry<Block> HIGH_STRENGTH_FLOOR = createCasingBlock("high_strength_floor", Epimorphism.id("block/casings/misc/high_strength_floor"));
    public static final BlockEntry<Block> YOTTA_FLUID_TANK_CASING = createComplexTextureCasingBlock("yotta_fluid_tank_casing");
    public static final BlockEntry<Block> DEPLOYMENT_UNIT_CASING = createComplexTextureCasingBlock("deployment_unit_casing");
    public static final BlockEntry<Block> DEPLOYMENT_UNIT_CORE = createComplexTextureCasingBlock("deployment_unit_core");
    public static final BlockEntry<Block> RECEIVER_CASING = createComplexTextureCasingBlock("receiver_casing");
    public static final BlockEntry<Block> SUPPORT_STRUCTURE_CASING = createComplexTextureCasingBlock("support_structure_casing");
    public static final BlockEntry<Block> INTERNAL_STRUCTURE_CASING = createComplexTextureCasingBlock("internal_structure_casing");
    public static final BlockEntry<Block> CONTROL_PRIMARY_WINDING = createComplexTextureCasingBlock("control_primary_winding");
    public static final BlockEntry<Block> CONTROL_SECONDARY_WINDING = createComplexTextureCasingBlock("control_secondary_winding");
    public static final BlockEntry<ActiveBlock> DEPLOYMENT_UNIT_MAGNET = createActiveCasing("deployment_unit_magnet", "block/variant/deployment_unit_magnet");

    // Multiblock Special Casing Blocks
    ////  Isa
    public static final BlockEntry<Block> ISA_MILL_CASING = createCasingBlock("isa_mill_casing", Epimorphism.id("block/casings/solid/isa_mill_casing"));
    public static final BlockEntry<Block> CASING_ISA_MILL_PIPE = createCasingBlock("isa_mill_casing_pipe", Epimorphism.id("block/casings/solid/isa_mill_casing_pipe"));
    public static final BlockEntry<Block> FLOTATION_CASING = createCasingBlock("flotation_casing", Epimorphism.id("block/casings/solid/flotation_casing"));
    public static final BlockEntry<Block> FLOTATION_CELL = createCasingBlock("flotation_cell", Epimorphism.id("block/casings/solid/flotation_cell"));// industrial_flotation_cell
    public static final BlockEntry<Block> VACUUM_CASING = createCasingBlock("vacuum_casing", Epimorphism.id("block/casings/solid/vacuum_casing"));

    public static final BlockEntry<Block> SPEEDING_PIPE = createComplexTextureCasingBlock("speeding_pipe");
    public static final BlockEntry<Block> SUBSTRATE_CASING = createComplexTextureCasingBlock("substrate_casing");
    public static final BlockEntry<Block> ADVANCED_SUBSTRATE_CASING = createComplexTextureCasingBlock("advanced_substrate_casing");
    public static final BlockEntry<Block> DRILL_HEAD = createComplexTextureCasingBlock("drill_head");


    // Multiblock Machine Pipe Casing Blocks
    public static final BlockEntry<Block> CASING_POLYBENZIMIDAZOLE_PIPE = createCasingBlock("polybenzimidazole_pipe", Epimorphism.id("block/casings/pipe/polybenzimidazole_pipe"));

    // Multiblock Machine Gearbox Casing Blocks
    public static final BlockEntry<Block> CASING_TURBO_ENGINE_GEARBOX = createCasingBlock("casing_gearbox_turbo_engine", Epimorphism.id("block/casings/gearbox/casing_gearbox_turbo_engine"));
    public static final BlockEntry<Block> CASING_ISA_MILL_GEARBOX = createCasingBlock("casing_isa_mill_gearbox", Epimorphism.id("block/casings/gearbox/casing_isa_mill_gearbox"));
    public static final BlockEntry<Block> CASING_SUPERCRITICAL_FLUID_GEARBOX = createCasingBlock("casing_gearbox_supercritical_fluid", Epimorphism.id("block/casings/gearbox/casing_gearbox_supercritical_fluid"));

    public static final BlockEntry<Block> RAW_CYLINDER = createCasingBlock("raw_cylinder", Epimorphism.id("block/casings/unique/raw_cylinder"));
    public static final BlockEntry<Block> TITANIUM_PLATED_CYLINDER = createCasingBlock("titanium_plated_cylinder", Epimorphism.id("block/casings/unique/titanium_plated_cylinder"));

    public static final BlockEntry<Block> GD_CE_CERAMIC_ELECTROLYTE_UNIT = createCasingBlock("gd_ce_ceramic_electrolyte_unit", Epimorphism.id("block/casings/unique/gd_ce_ceramic_electrolyte_unit"));
    public static final BlockEntry<Block> Y_ZR_CERAMIC_ELECTROLYTE_UNIT = createCasingBlock("y_zr_ceramic_electrolyte_unit", Epimorphism.id("block/casings/unique/y_zr_ceramic_electrolyte_unit"));

    // Transparent Casing Blocks
    public static final BlockEntry<TierGlassBlock> SILICATE_GLASS = createGlassBlock(TierGlassBlock.GlassType.SILICATE_GLASS, SoundType.GLASS, () -> RenderType::translucent);
    public static final BlockEntry<TierGlassBlock> TI_BORON_SILICATE_GLASS = createGlassBlock(TierGlassBlock.GlassType.TI_BORON_SILICATE_GLASS, SoundType.GLASS, () -> RenderType::translucent);
    public static final BlockEntry<TierGlassBlock> W_BORON_SILICATE_GLASS = createGlassBlock(TierGlassBlock.GlassType.W_BORON_SILICATE_GLASS, SoundType.GLASS, () -> RenderType::translucent);
    public static final BlockEntry<TierGlassBlock> OSMIR_BORON_SILICATE_GLASS = createGlassBlock(TierGlassBlock.GlassType.OSMIR_BORON_SILICATE_GLASS, SoundType.GLASS, () -> RenderType::translucent);
    public static final BlockEntry<TierGlassBlock> NAQ_BORON_SILICATE_GLASS = createGlassBlock(TierGlassBlock.GlassType.NAQ_BORON_SILICATE_GLASS, SoundType.GLASS, () -> RenderType::translucent);
    public static final BlockEntry<TierGlassBlock> THY_BORON_SILICATE_GLASS = createGlassBlock(TierGlassBlock.GlassType.THY_BORON_SILICATE_GLASS, SoundType.GLASS, () -> RenderType::translucent);
    public static final BlockEntry<TierGlassBlock> INFINITY_GLASS = createGlassBlock(TierGlassBlock.GlassType.INFINITY_GLASS, SoundType.GLASS, () -> RenderType::cutoutMipped);
    public static final BlockEntry<TierGlassBlock> PMMA_GLASS = createGlassBlock(TierGlassBlock.GlassType.PMMA_GLASS, SoundType.STONE, () -> RenderType::translucent);
    public static final BlockEntry<TierGlassBlock> NEU_PMMA_GLASS = createGlassBlock(TierGlassBlock.GlassType.NEU_PMMA_GLASS, SoundType.STONE, () -> RenderType::translucent);
    public static final BlockEntry<TierGlassBlock> BPA_POLYCARBONATE_GLASS = createGlassBlock(TierGlassBlock.GlassType.BPA_POLYCARBONATE_GLASS, SoundType.STONE, () -> RenderType::translucent);
    public static final BlockEntry<TierGlassBlock> CBDO_POLYCARBONATE_GLASS = createGlassBlock(TierGlassBlock.GlassType.CBDO_POLYCARBONATE_GLASS, SoundType.STONE, () -> RenderType::translucent);


    // Fluid Tank Cell Blocks
    public static final BlockEntry<FluidTankCellBlock> FLUID_TANK_CELL_1 = createFluidCellBlock(FluidTankCellBlock.FluidCellType.CELL_1);
    public static final BlockEntry<FluidTankCellBlock> FLUID_TANK_CELL_2 = createFluidCellBlock(FluidTankCellBlock.FluidCellType.CELL_2);
    public static final BlockEntry<FluidTankCellBlock> FLUID_TANK_CELL_3 = createFluidCellBlock(FluidTankCellBlock.FluidCellType.CELL_3);
    public static final BlockEntry<FluidTankCellBlock> FLUID_TANK_CELL_4 = createFluidCellBlock(FluidTankCellBlock.FluidCellType.CELL_4);
    public static final BlockEntry<FluidTankCellBlock> FLUID_TANK_CELL_5 = createFluidCellBlock(FluidTankCellBlock.FluidCellType.CELL_5);
    public static final BlockEntry<FluidTankCellBlock> FLUID_TANK_CELL_6 = createFluidCellBlock(FluidTankCellBlock.FluidCellType.CELL_6);
    public static final BlockEntry<FluidTankCellBlock> FLUID_TANK_CELL_7 = createFluidCellBlock(FluidTankCellBlock.FluidCellType.CELL_7);
    public static final BlockEntry<FluidTankCellBlock> FLUID_TANK_CELL_8 = createFluidCellBlock(FluidTankCellBlock.FluidCellType.CELL_8);
    public static final BlockEntry<FluidTankCellBlock> FLUID_TANK_CELL_9 = createFluidCellBlock(FluidTankCellBlock.FluidCellType.CELL_9);
    public static final BlockEntry<FluidTankCellBlock> FLUID_TANK_CELL_10 = createFluidCellBlock(FluidTankCellBlock.FluidCellType.CELL_10);

    //  Storage Field Blocks
    public static final BlockEntry<StorageFieldBlock> STORAGE_FIELD_BLOCK_1 = createStorageFieldBlock(StorageFieldBlock.FieldBlockType.BLOCK_1);
    public static final BlockEntry<StorageFieldBlock> STORAGE_FIELD_BLOCK_2 = createStorageFieldBlock(StorageFieldBlock.FieldBlockType.BLOCK_2);
    public static final BlockEntry<StorageFieldBlock> STORAGE_FIELD_BLOCK_3 = createStorageFieldBlock(StorageFieldBlock.FieldBlockType.BLOCK_3);
    public static final BlockEntry<StorageFieldBlock> STORAGE_FIELD_BLOCK_4 = createStorageFieldBlock(StorageFieldBlock.FieldBlockType.BLOCK_4);
    public static final BlockEntry<StorageFieldBlock> STORAGE_FIELD_BLOCK_5 = createStorageFieldBlock(StorageFieldBlock.FieldBlockType.BLOCK_5);
    public static final BlockEntry<StorageFieldBlock> STORAGE_FIELD_BLOCK_6 = createStorageFieldBlock(StorageFieldBlock.FieldBlockType.BLOCK_6);
    public static final BlockEntry<StorageFieldBlock> STORAGE_FIELD_BLOCK_7 = createStorageFieldBlock(StorageFieldBlock.FieldBlockType.BLOCK_7);
    public static final BlockEntry<StorageFieldBlock> STORAGE_FIELD_BLOCK_8 = createStorageFieldBlock(StorageFieldBlock.FieldBlockType.BLOCK_8);
    public static final BlockEntry<StorageFieldBlock> STORAGE_FIELD_BLOCK_9 = createStorageFieldBlock(StorageFieldBlock.FieldBlockType.BLOCK_9);
    public static final BlockEntry<StorageFieldBlock> STORAGE_FIELD_BLOCK_10 = createStorageFieldBlock(StorageFieldBlock.FieldBlockType.BLOCK_10);

    //  Component Assembly Line Casings
    public static final BlockEntry<SimpleTierBlock> COMPONENT_ASSEMBLY_LINE_CASING_LV = createComponentAssemblyBlock(ITierType.TierBlockType.LV);
    public static final BlockEntry<SimpleTierBlock> COMPONENT_ASSEMBLY_LINE_CASING_MV = createComponentAssemblyBlock(ITierType.TierBlockType.MV);
    public static final BlockEntry<SimpleTierBlock> COMPONENT_ASSEMBLY_LINE_CASING_HV = createComponentAssemblyBlock(ITierType.TierBlockType.HV);
    public static final BlockEntry<SimpleTierBlock> COMPONENT_ASSEMBLY_LINE_CASING_EV = createComponentAssemblyBlock(ITierType.TierBlockType.EV);
    public static final BlockEntry<SimpleTierBlock> COMPONENT_ASSEMBLY_LINE_CASING_IV = createComponentAssemblyBlock(ITierType.TierBlockType.IV);
    public static final BlockEntry<SimpleTierBlock> COMPONENT_ASSEMBLY_LINE_CASING_LuV = createComponentAssemblyBlock(ITierType.TierBlockType.LuV);
    public static final BlockEntry<SimpleTierBlock> COMPONENT_ASSEMBLY_LINE_CASING_ZPM = createComponentAssemblyBlock(ITierType.TierBlockType.ZPM);
    public static final BlockEntry<SimpleTierBlock> COMPONENT_ASSEMBLY_LINE_CASING_UV = createComponentAssemblyBlock(ITierType.TierBlockType.UV);
    public static final BlockEntry<SimpleTierBlock> COMPONENT_ASSEMBLY_LINE_CASING_UHV = createComponentAssemblyBlock(ITierType.TierBlockType.UHV);
    public static final BlockEntry<SimpleTierBlock> COMPONENT_ASSEMBLY_LINE_CASING_UEV = createComponentAssemblyBlock(ITierType.TierBlockType.UEV);
    public static final BlockEntry<SimpleTierBlock> COMPONENT_ASSEMBLY_LINE_CASING_UIV = createComponentAssemblyBlock(ITierType.TierBlockType.UIV);
    public static final BlockEntry<SimpleTierBlock> COMPONENT_ASSEMBLY_LINE_CASING_UXV = createComponentAssemblyBlock(ITierType.TierBlockType.UXV);
    public static final BlockEntry<SimpleTierBlock> COMPONENT_ASSEMBLY_LINE_CASING_OpV = createComponentAssemblyBlock(ITierType.TierBlockType.OpV);
    public static final BlockEntry<SimpleTierBlock> COMPONENT_ASSEMBLY_LINE_CASING_MAX = createComponentAssemblyBlock(ITierType.TierBlockType.MAX);

    // Fusion
    public static final BlockEntry<FusionCasingBlock> FUSION_CASING_MK4 = createFusionCasing(EPFusionCasingBlock.CasingType.FUSION_CASING_MK4);
    public static final BlockEntry<FusionCasingBlock> FUSION_CASING_MK5 = createFusionCasing(EPFusionCasingBlock.CasingType.FUSION_CASING_MK5);

    // Physics
    static {
        EP_REGISTRATE.creativeModeTab(() -> EPCreativeModeTabs.EP_PHYSICS);
    }

    public static final BlockEntry<CasingBlock> ULTIMATE_HIGH_ENERGY_CASING = createCasingBlockWithTooltip("ultimate_high_energy_casing", Epimorphism.id("block/casings/solid/ultimate_high_energy_casing"), 2);
    public static final BlockEntry<CasingBlock> ADVANCED_HIGH_ENERGY_CASING = createCasingBlockWithTooltip("advanced_high_energy_casing", Epimorphism.id("block/casings/solid/advanced_high_energy_casing"), 2);
    public static final BlockEntry<CasingBlock> DIMENSIONAL_BRIDGE_CASING = createCasingBlockWithTooltip("dimensional_bridge_casing", Epimorphism.id("block/casings/solid/dimensional_bridge_casing"), 2);
    public static final BlockEntry<CasingBlock> DIMENSIONAL_LINK_CASING = createCasingBlockWithTooltip("dimensional_link_casing", Epimorphism.id("block/casings/solid/dimensional_link_casing"), 2);
    public static final BlockEntry<CasingBlock> CONTAINMENT_FIELD_GENERATOR = createCasingBlockWithTooltip("containment_field_generator", Epimorphism.id("block/casings/solid/containment_field_generator"), 2);
    public static final BlockEntry<CasingBlock> ULTIMATE_CONTAINMENT_FIELD_GENERATOR = createCasingBlockWithTooltip("ultimate_containment_field_generator", Epimorphism.id("block/casings/solid/ultimate_containment_field_generator"), 2);
    public static final BlockEntry<CasingBlock> HOLLOW_CASING = createCasingBlockWithTooltip("hollow_casing", Epimorphism.id("block/casings/solid/hollow_casing"), 2);
    public static final BlockEntry<CasingBlock> SPACETIME_DISTORTION_CASING = createCasingBlockWithTooltip("spacetime_distortion_casing", Epimorphism.id("block/casings/solid/spacetime_distortion_casing"), 2);
    public static final BlockEntry<CasingBlock> DIMENSIONAL_CASING = createCasingBlockWithTooltip("dimensional_casing", Epimorphism.id("block/casings/solid/dimensional_casing"), 2);
    public static final BlockEntry<CasingBlock> HYPERDIMENSIONAL_CASING = createCasingBlockWithTooltip("hyperdimensional_casing", Epimorphism.id("block/casings/solid/hyperdimensional_casing"), 2);

    public static final BlockEntry<SimpleTierBlock> SC_FIELD_GENERATOR_1 = createSCFieldGenerator(ITierType.TierBlockType.LV);
    public static final BlockEntry<SimpleTierBlock> SC_FIELD_GENERATOR_2 = createSCFieldGenerator(ITierType.TierBlockType.MV);
    public static final BlockEntry<SimpleTierBlock> SC_FIELD_GENERATOR_3 = createSCFieldGenerator(ITierType.TierBlockType.HV);
    public static final BlockEntry<SimpleTierBlock> SC_FIELD_GENERATOR_4 = createSCFieldGenerator(ITierType.TierBlockType.EV);
    public static final BlockEntry<SimpleTierBlock> SC_FIELD_GENERATOR_5 = createSCFieldGenerator(ITierType.TierBlockType.IV);
    public static final BlockEntry<SimpleTierBlock> SC_FIELD_GENERATOR_6 = createSCFieldGenerator(ITierType.TierBlockType.LuV);
    public static final BlockEntry<SimpleTierBlock> SC_FIELD_GENERATOR_7 = createSCFieldGenerator(ITierType.TierBlockType.ZPM);
    public static final BlockEntry<SimpleTierBlock> SC_FIELD_GENERATOR_8 = createSCFieldGenerator(ITierType.TierBlockType.UV);
    public static final BlockEntry<SimpleTierBlock> SC_FIELD_GENERATOR_9 = createSCFieldGenerator(ITierType.TierBlockType.UHV);

    public static final BlockEntry<SimpleTierBlock> ST_FIELD_GENERATOR_1 = createSTFieldGenerator(ITierType.TierBlockType.LV);
    public static final BlockEntry<SimpleTierBlock> ST_FIELD_GENERATOR_2 = createSTFieldGenerator(ITierType.TierBlockType.MV);
    public static final BlockEntry<SimpleTierBlock> ST_FIELD_GENERATOR_3 = createSTFieldGenerator(ITierType.TierBlockType.HV);
    public static final BlockEntry<SimpleTierBlock> ST_FIELD_GENERATOR_4 = createSTFieldGenerator(ITierType.TierBlockType.EV);
    public static final BlockEntry<SimpleTierBlock> ST_FIELD_GENERATOR_5 = createSTFieldGenerator(ITierType.TierBlockType.IV);
    public static final BlockEntry<SimpleTierBlock> ST_FIELD_GENERATOR_6 = createSTFieldGenerator(ITierType.TierBlockType.LuV);
    public static final BlockEntry<SimpleTierBlock> ST_FIELD_GENERATOR_7 = createSTFieldGenerator(ITierType.TierBlockType.ZPM);
    public static final BlockEntry<SimpleTierBlock> ST_FIELD_GENERATOR_8 = createSTFieldGenerator(ITierType.TierBlockType.UV);
    public static final BlockEntry<SimpleTierBlock> ST_FIELD_GENERATOR_9 = createSTFieldGenerator(ITierType.TierBlockType.UHV);

    public static final BlockEntry<SimpleTierBlock> TA_FIELD_GENERATOR_1 = createTAFieldGenerator(ITierType.TierBlockType.LV);
    public static final BlockEntry<SimpleTierBlock> TA_FIELD_GENERATOR_2 = createTAFieldGenerator(ITierType.TierBlockType.MV);
    public static final BlockEntry<SimpleTierBlock> TA_FIELD_GENERATOR_3 = createTAFieldGenerator(ITierType.TierBlockType.HV);
    public static final BlockEntry<SimpleTierBlock> TA_FIELD_GENERATOR_4 = createTAFieldGenerator(ITierType.TierBlockType.EV);
    public static final BlockEntry<SimpleTierBlock> TA_FIELD_GENERATOR_5 = createTAFieldGenerator(ITierType.TierBlockType.IV);
    public static final BlockEntry<SimpleTierBlock> TA_FIELD_GENERATOR_6 = createTAFieldGenerator(ITierType.TierBlockType.LuV);
    public static final BlockEntry<SimpleTierBlock> TA_FIELD_GENERATOR_7 = createTAFieldGenerator(ITierType.TierBlockType.ZPM);
    public static final BlockEntry<SimpleTierBlock> TA_FIELD_GENERATOR_8 = createTAFieldGenerator(ITierType.TierBlockType.UV);
    public static final BlockEntry<SimpleTierBlock> TA_FIELD_GENERATOR_9 = createTAFieldGenerator(ITierType.TierBlockType.UHV);

    static {
        EP_REGISTRATE.creativeModeTab(() -> EPCreativeModeTabs.EP_GALAXY);
    }

    public static final BlockEntry<SimpleTierBlock> ELEVATOR_MOTOR_1 = createElevatorMotor(ITierType.TierBlockType.LV);
    public static final BlockEntry<SimpleTierBlock> ELEVATOR_MOTOR_2 = createElevatorMotor(ITierType.TierBlockType.MV);
    public static final BlockEntry<SimpleTierBlock> ELEVATOR_MOTOR_3 = createElevatorMotor(ITierType.TierBlockType.HV);
    public static final BlockEntry<SimpleTierBlock> ELEVATOR_MOTOR_4 = createElevatorMotor(ITierType.TierBlockType.EV);
    public static final BlockEntry<SimpleTierBlock> ELEVATOR_MOTOR_5 = createElevatorMotor(ITierType.TierBlockType.IV);

    public static final BlockEntry<Block> PLANET_OVERWORLD = createPlanetDimensionDisplay(OVERWORLD);
    public static final BlockEntry<Block> PLANET_NETHER = createPlanetDimensionDisplay(THE_NETHER);
    public static final BlockEntry<Block> PLANET_THE_END = createPlanetDimensionDisplay(THE_END);
    public static final BlockEntry<Block> PLANET_TWILIGHT_FOREST = createPlanetDimensionDisplay(TWILIGHT_FOREST);
    public static final BlockEntry<Block> PLANET_MOON = createPlanetDimensionDisplay(MOON);
    public static final BlockEntry<Block> PLANET_DEIMOS = createPlanetDimensionDisplay(DEIMOS);
    public static final BlockEntry<Block> PLANET_MARS = createPlanetDimensionDisplay(MARS);
    public static final BlockEntry<Block> PLANET_PHOBOS = createPlanetDimensionDisplay(PHOBOS);
    public static final BlockEntry<Block> PLANET_CALLISTO = createPlanetDimensionDisplay(CALLISTO);
    public static final BlockEntry<Block> PLANET_CERES = createPlanetDimensionDisplay(CERES);
    public static final BlockEntry<Block> PLANET_EUROPA = createPlanetDimensionDisplay(EUROPA);
    public static final BlockEntry<Block> PLANET_GANYMEDE = createPlanetDimensionDisplay(GANYMEDE);
    public static final BlockEntry<Block> PLANET_ROSS_128_B = createPlanetDimensionDisplay(ROSS_128_B);
    public static final BlockEntry<Block> PLANET_ASTEROID_BELT = createPlanetDimensionDisplay(ASTEROID_BELT);
    public static final BlockEntry<Block> PLANET_IO = createPlanetDimensionDisplay(IO);
    public static final BlockEntry<Block> PLANET_VENUS = createPlanetDimensionDisplay(VENUS);
    public static final BlockEntry<Block> PLANET_MERCURY = createPlanetDimensionDisplay(MERCURY);
    public static final BlockEntry<Block> PLANET_MIRANDA = createPlanetDimensionDisplay(MIRANDA);
    public static final BlockEntry<Block> PLANET_OBERON = createPlanetDimensionDisplay(OBERON);
    public static final BlockEntry<Block> PLANET_ENCELADUS = createPlanetDimensionDisplay(ENCELADUS);
    public static final BlockEntry<Block> PLANET_ROSS_128_BA = createPlanetDimensionDisplay(ROSS_128_BA);
    public static final BlockEntry<Block> PLANET_TITAN = createPlanetDimensionDisplay(TITAN);
    public static final BlockEntry<Block> PLANET_PROTEUS = createPlanetDimensionDisplay(PROTEUS);
    public static final BlockEntry<Block> PLANET_TRITON = createPlanetDimensionDisplay(TRITON);
    public static final BlockEntry<Block> PLANET_HAUMEA = createPlanetDimensionDisplay(HAUMEA);
    public static final BlockEntry<Block> PLANET_KUIPER_BELT = createPlanetDimensionDisplay(KUIPER_BELT);
    public static final BlockEntry<Block> PLANET_MAKEMAKE = createPlanetDimensionDisplay(MAKEMAKE);
    public static final BlockEntry<Block> PLANET_PLUTO = createPlanetDimensionDisplay(PLUTO);
    public static final BlockEntry<Block> PLANET_BARNARDA_C = createPlanetDimensionDisplay(BARNARDA_C);
    public static final BlockEntry<Block> PLANET_BARNARDA_E = createPlanetDimensionDisplay(BARNARDA_E);
    public static final BlockEntry<Block> PLANET_BARNARDA_F = createPlanetDimensionDisplay(BARNARDA_F);
    public static final BlockEntry<Block> PLANET_TAU_CETI_E = createPlanetDimensionDisplay(TAU_CETI_E);
    public static final BlockEntry<Block> PLANET_VEGA_B = createPlanetDimensionDisplay(VEGA_B);
    public static final BlockEntry<Block> PLANET_CENTAURI_BB = createPlanetDimensionDisplay(CENTAURI_BB);
    public static final BlockEntry<Block> PLANET_SET = createPlanetDimensionDisplay(SET);
    public static final BlockEntry<Block> PLANET_ANUBIS = createPlanetDimensionDisplay(ANUBIS);
    public static final BlockEntry<Block> PLANET_HORUS = createPlanetDimensionDisplay(HORUS);
    public static final BlockEntry<Block> PLANET_MAAHES = createPlanetDimensionDisplay(MAAHES);
    public static final BlockEntry<Block> PLANET_MEHEN_BELT = createPlanetDimensionDisplay(MEHEN_BELT);
    public static final BlockEntry<Block> PLANET_NEPERI = createPlanetDimensionDisplay(NEPERI);
    public static final BlockEntry<Block> PLANET_DEEP_DARK = createPlanetDimensionDisplay(DEEP_DARK);

    //  Misc
    public static final BlockEntry<EOHRendererBlock> EOH_RENDERER_BLOCK = EP_REGISTRATE
            .block("eoh_render_block", EOHRendererBlock::new)
            .properties(properties -> properties.noCollission().noOcclusion().noLootTable().strength(-1))
            .setData(ProviderType.BLOCKSTATE, NonNullBiConsumer.noop())
            .setData(ProviderType.LANG, NonNullBiConsumer.noop())
            .setData(ProviderType.LOOT, NonNullBiConsumer.noop())
            .register();

    static {
        EP_REGISTRATE.creativeModeTab(() -> EPCreativeModeTabs.EP_AGRICULTURE);
    }

    public static final BlockEntry<SaplingBlock> PINE_SAPLING = EP_REGISTRATE.block("pine_sapling", properties -> new SaplingBlock(new AbstractTreeGrower() {
                protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(@Nonnull RandomSource random, boolean largeHive) {
                    return EPConfiguredFeatures.PINE;
                }
            }, properties))
            .initialProperties(() -> Blocks.OAK_SAPLING)
            .lang("Pine Sapling")
            .blockstate(GTModels::createCrossBlockState)
            .addLayer(() -> RenderType::cutoutMipped)
            .tag(BlockTags.SAPLINGS)
            .item()
            .model(EPModels::simpleCustomBlockItemModel)
            .tag(ItemTags.SAPLINGS)
            .build()
            .register();

    public static final BlockEntry<RotatedPillarBlock> PINE_LOG = EP_REGISTRATE.block("pine_log", RotatedPillarBlock::new)
            .properties(p -> p.strength(2.0F).sound(SoundType.WOOD))
            .lang("Pine Log")
            .tag(BlockTags.LOGS)
            .blockstate((ctx, provider) -> provider.logBlock(ctx.get()))
            .item()
            .tag(ItemTags.LOGS)
            .build()
            .register();

//    public static final BlockEntry<EPCropBlock> CROP = EP_REGISTRATE.block("crop", EPCropBlock::new)
//            .addLayer(() -> RenderType::cutout)
//            .blockstate(EPBlockStates::cropBlockState)
//            .register();

    // Fortune Level
    public static final float[] PINE_LEAVES_DROPPING_CHANCE = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};

    public static final BlockEntry<LeavesBlock> PINE_LEAVES = EP_REGISTRATE
            .block("pine_leaves", LeavesBlock::new)
            .initialProperties(() -> Blocks.OAK_LEAVES)
            .lang("Pine Leaves")
            .blockstate((ctx, prov) -> createModelBlockState(ctx, prov, Epimorphism.id("block/pine_leaves")))
            .loot((table, block) -> table.add(block, table.createLeavesDrops(block, PINE_SAPLING.get(), PINE_LEAVES_DROPPING_CHANCE)
                    .withPool(LootPool.lootPool()
                            .setRolls(ConstantValue.exactly(1.0F))
                            .when(BlockLootSubProviderAccessor.getHasNoShearsOrSilkTouch())
                            .add(table.applyExplosionCondition(block, LootItem.lootTableItem(EPAgricultureItems.PINECONE))
                                    .when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, new float[]{0.005F, 0.0055555557F, 0.00625F, 0.008333334F, 0.025F}))))))
            .tag(BlockTags.LEAVES)
            .color(() -> EPBlocks::pineLeavesBlockColor)
            .item()
            .color(() -> EPBlocks::pineLeavesItemColor)
            .tag(ItemTags.LEAVES)
            .build()
            .register();

    public static final BlockEntry<Block> PINE_PLANK = EP_REGISTRATE
            .block("pine_planks", Block::new)
            .initialProperties(() -> Blocks.OAK_PLANKS)
            .lang("Pine Planks")
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_GRAY))
            .tag(BlockTags.PLANKS)
            .item()
            .tag(ItemTags.PLANKS)
            .build()
            .register();

    static {
        EP_REGISTRATE.creativeModeTab(() -> EPCreativeModeTabs.EP_BLOCK);
    }

    public static void init() {
        REGISTRATE.creativeModeTab(() -> GTCreativeModeTabs.MATERIAL_BLOCK);
        generateCrucibleBlocks();
        generateFenceBlocks();
    }

    protected static BlockEntry<Block> createCasingBlock(String name, ResourceLocation texture) {
        return createCasingBlock(name, RendererBlock::new, texture, () -> Blocks.IRON_BLOCK, () -> RenderType::cutoutMipped);
    }

    private static BlockEntry<Block> createComplexTextureCasingBlock(String name) {
        return createComplexTextureCasingBlock(name, RendererBlock::new, () -> Blocks.IRON_BLOCK, () -> RenderType::cutoutMipped);
    }

    private static BlockEntry<Block> createGlassCasingBlock(String name, ResourceLocation texture, Supplier<Supplier<RenderType>> type) {
        return createCasingBlock(name, RendererGlassBlock::new, texture, () -> Blocks.GLASS, type);
    }

    protected static BlockEntry<CasingBlock> createCasingBlockWithTooltip(String name, ResourceLocation texture, int tooltips) {
        return EPRegistration.EP_REGISTRATE.block(name, p -> new CasingBlock(p,
                        Platform.isClient() ? new TextureOverrideRenderer(new ResourceLocation("block/cube_all"),
                                Map.of("all", texture)) : null))
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .addLayer(() -> RenderType::cutoutMipped)
                .blockstate(NonNullBiConsumer.noop())
                .tag(GTToolType.WRENCH.harvestTags.get(0), BlockTags.MINEABLE_WITH_PICKAXE)
                .onRegister(block -> block.addTooltip(EPLangHelper.getBlockTooltips(name, tooltips)))
                .item(RendererBlockItem::new)
                .model(NonNullBiConsumer.noop())
                .build()
                .register();
    }

    private static BlockEntry<TierGlassBlock> createGlassBlock(ITierGlassType glassType, SoundType soundType, Supplier<Supplier<RenderType>> type) {
        BlockEntry<TierGlassBlock> glassBlock = EP_REGISTRATE.block("%s_block".formatted(glassType.typeName()),
                        p -> new TierGlassBlock(p, Platform.isClient() ? new TextureOverrideRenderer(new ResourceLocation("block/cube_all"),
                                Map.of("all", Epimorphism.id("block/casings/glass/%s".formatted(glassType.typeName())))) : null, glassType))
                .initialProperties(() -> Blocks.GLASS)
                .properties(p -> p.sound(soundType))
                .addLayer(type)
                .blockstate(NonNullBiConsumer.noop())
                .tag(GTToolType.WRENCH.harvestTags.get(0), BlockTags.MINEABLE_WITH_PICKAXE)
                .item(RendererBlockItem::new)
                .model(NonNullBiConsumer.noop())
                .build()
                .register();
        ALL_GLASSES.put(glassType, glassBlock::get);
        SHAPE_GLASSES.put(glassType, glassBlock::get);
        return glassBlock;
    }

    private static BlockEntry<FusionCasingBlock> createFusionCasing(IFusionCasingType casingType) {
        BlockEntry<FusionCasingBlock> casingBlock = EP_REGISTRATE.block(casingType.getSerializedName(), p -> (FusionCasingBlock) new EPFusionCasingBlock(p, casingType))
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .properties(properties -> properties.strength(5.0f, 10.0f).sound(SoundType.METAL))
                .addLayer(() -> RenderType::cutoutMipped)
                .blockstate(NonNullBiConsumer.noop())
                .tag(GTToolType.WRENCH.harvestTags.get(0), CustomTags.TOOL_TIERS[casingType.getHarvestLevel()])
                .item(RendererBlockItem::new)
                .model(NonNullBiConsumer.noop())
                .build()
                .register();
        ALL_FUSION_CASINGS.put(casingType, casingBlock);
        return casingBlock;
    }

    private static BlockEntry<FluidTankCellBlock> createFluidCellBlock(IFluidTankCell cellData) {
        BlockEntry<FluidTankCellBlock> cellBlock = EP_REGISTRATE.block("fluid_tank_%s".formatted(cellData.typeName()),
                        p -> new FluidTankCellBlock(p, cellData, Platform.isClient() ? new TextureOverrideRenderer(new ResourceLocation("block/cube_all"),
                                Map.of("all", Epimorphism.id("block/casings/fluid_tank_cell/%s".formatted(cellData.typeName())))) : null))
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .addLayer(() -> RenderType::cutoutMipped)
                .blockstate(NonNullBiConsumer.noop())
                .tag(GTToolType.WRENCH.harvestTags.get(0), BlockTags.MINEABLE_WITH_PICKAXE)
                .item(RendererBlockItem::new)
                .model(NonNullBiConsumer.noop())
                .build()
                .register();
        ALL_FLUID_CELLS.put(cellData, cellBlock::get);
        return cellBlock;
    }

    private static BlockEntry<StorageFieldBlock> createStorageFieldBlock(IStorageFieldBlock blockData) {
        BlockEntry<StorageFieldBlock> fieldBlock = EP_REGISTRATE.block("storage_field_%s".formatted(blockData.typeName()),
                        p -> new StorageFieldBlock(p, blockData, Platform.isClient() ? new TextureOverrideRenderer(new ResourceLocation("block/cube_all"),
                                Map.of("all", Epimorphism.id("block/casings/storage_field_block/%s".formatted(blockData.typeName())))) : null))
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .addLayer(() -> RenderType::cutoutMipped)
                .blockstate(NonNullBiConsumer.noop())
                .tag(GTToolType.WRENCH.harvestTags.get(0), BlockTags.MINEABLE_WITH_PICKAXE)
                .item(RendererBlockItem::new)
                .model(NonNullBiConsumer.noop())
                .build()
                .register();
        ALL_FIELD_BLOCKS.put(blockData, fieldBlock::get);
        return fieldBlock;
    }

    private static BlockEntry<SimpleTierBlock> createSCFieldGenerator(ITierType blockData) {
        BlockEntry<SimpleTierBlock> SCFieldGenerator = EP_REGISTRATE.block("spacetime_compression_field_generator_%s".formatted(blockData.tier()),
                        p -> new SimpleTierBlock(p, blockData, Platform.isClient() ? new TextureOverrideRenderer(new ResourceLocation("block/cube_all"),
                                Map.of("all", Epimorphism.id("block/casings/field_generator/spacetime_compression/%s".formatted(blockData.tier())))) : null))
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .addLayer(() -> RenderType::cutoutMipped)
                .blockstate(NonNullBiConsumer.noop())
                .tag(GTToolType.WRENCH.harvestTags.get(0), BlockTags.MINEABLE_WITH_PICKAXE)
                .onRegister(simpleTierBlock -> simpleTierBlock.setUseNumberTier(true).addTooltip(Component.translatable(simpleTierBlock.getDescriptionId() + ".desc")))
                .item(RendererBlockItem::new)
                .model(NonNullBiConsumer.noop())
                .build()
                .register();
        SC_FIELD_GENERATORS.put(blockData, SCFieldGenerator::get);
        return SCFieldGenerator;
    }

    private static BlockEntry<SimpleTierBlock> createSTFieldGenerator(ITierType blockData) {
        BlockEntry<SimpleTierBlock> STFieldGenerator = EP_REGISTRATE.block("stabilisation_field_generator_%s".formatted(blockData.tier()),
                        p -> new SimpleTierBlock(p, blockData, Platform.isClient() ? new TextureOverrideRenderer(new ResourceLocation("block/cube_all"),
                                Map.of("all", Epimorphism.id("block/casings/field_generator/stabilisation/%s".formatted(blockData.tier())))) : null))
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .addLayer(() -> RenderType::cutoutMipped)
                .blockstate(NonNullBiConsumer.noop())
                .tag(GTToolType.WRENCH.harvestTags.get(0), BlockTags.MINEABLE_WITH_PICKAXE)
                .onRegister(simpleTierBlock -> simpleTierBlock.setUseNumberTier(true).addTooltip(Component.translatable(simpleTierBlock.getDescriptionId() + ".desc")))
                .item(RendererBlockItem::new)
                .model(NonNullBiConsumer.noop())
                .build()
                .register();
        ST_FIELD_GENERATORS.put(blockData, STFieldGenerator::get);
        return STFieldGenerator;
    }

    private static BlockEntry<SimpleTierBlock> createTAFieldGenerator(ITierType blockData) {
        BlockEntry<SimpleTierBlock> TAFieldGenerator = EP_REGISTRATE.block("time_acceleration_field_generator_%s".formatted(blockData.tier()),
                        p -> new SimpleTierBlock(p, blockData, Platform.isClient() ? new TextureOverrideRenderer(new ResourceLocation("block/cube_all"),
                                Map.of("all", Epimorphism.id("block/casings/field_generator/time_acceleration/%s".formatted(blockData.tier())))) : null))
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .addLayer(() -> RenderType::cutoutMipped)
                .blockstate(NonNullBiConsumer.noop())
                .tag(GTToolType.WRENCH.harvestTags.get(0), BlockTags.MINEABLE_WITH_PICKAXE)
                .onRegister(simpleTierBlock -> simpleTierBlock.setUseNumberTier(true).addTooltip(Component.translatable(simpleTierBlock.getDescriptionId() + ".desc")))
                .item(RendererBlockItem::new)
                .model(NonNullBiConsumer.noop())
                .build()
                .register();
        TA_FIELD_GENERATORS.put(blockData, TAFieldGenerator::get);
        return TAFieldGenerator;
    }

    private static BlockEntry<SimpleTierBlock> createElevatorMotor(ITierType blockData) {
        BlockEntry<SimpleTierBlock> elevatorMotor = EP_REGISTRATE.block("elevator_motor_%s".formatted(blockData.tier()),
                        p -> new SimpleTierBlock(p, blockData, Platform.isClient() ? new TextureOverrideRenderer(new ResourceLocation("block/cube_bottom_top"),
                                Map.of("top", Epimorphism.id("block/casings/elevator_motor/motor"),
                                        "bottom", Epimorphism.id("block/casings/elevator_motor/motor"),
                                        "side", Epimorphism.id("block/casings/elevator_motor/%s".formatted(blockData.tier())))) : null))
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .addLayer(() -> RenderType::cutoutMipped)
                .blockstate(NonNullBiConsumer.noop())
                .tag(GTToolType.WRENCH.harvestTags.get(0), BlockTags.MINEABLE_WITH_PICKAXE)
                .onRegister(simpleTierBlock -> simpleTierBlock.setUseNumberTier(true).addTooltip(Component.translatable(simpleTierBlock.getDescriptionId() + ".desc")))
                .item(RendererBlockItem::new)
                .model(NonNullBiConsumer.noop())
                .build()
                .register();
        ALL_ELEVATOR_MOTORS.put(blockData, elevatorMotor::get);
        return elevatorMotor;
    }

    private static BlockEntry<Block> createPlanetDimensionDisplay(DimensionDisplayBlock.Dimension dimension) {
        var dim = dimension.getDimension();
        BlockEntry<Block> planetBlock = EP_REGISTRATE.block("dimension_display_%s".formatted(dim),
                        p -> (Block) new DimensionDisplayBlock(p, Platform.isClient() ? new PlanetDisplayRenderer(dim, dimension.getTier()) : null, dimension))
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .addLayer(() -> RenderType::cutoutMipped)
                .blockstate(NonNullBiConsumer.noop())
                .tag(GTToolType.WRENCH.harvestTags.get(0), BlockTags.MINEABLE_WITH_PICKAXE)
                .item(RendererBlockItem::new)
                .model(NonNullBiConsumer.noop())
                .build()
                .register();
        ALL_DIM_DISPLAY_BLOCKS.put(dim, planetBlock);
        return planetBlock;
    }

    private static BlockEntry<SimpleTierBlock> createComponentAssemblyBlock(ITierType blockData) {
        BlockEntry<SimpleTierBlock> componentAssemblyBlock = EP_REGISTRATE.block("component_assline_casing_%s".formatted(blockData.typeName()),
                        p -> new SimpleTierBlock(p, blockData, Platform.isClient() ? new TextureOverrideRenderer(GTCEu.id("block/cube_2_layer_all"),
                                Map.of("top_all", Epimorphism.id("block/casings/component_assline_casing/%s".formatted(blockData.typeName().toLowerCase())),
                                        "bot_all", Epimorphism.id("block/casings/solid/iridium_casing"))) : null))
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .addLayer(() -> RenderType::cutoutMipped)
                .blockstate(NonNullBiConsumer.noop())
                .tag(GTToolType.WRENCH.harvestTags.get(0), BlockTags.MINEABLE_WITH_PICKAXE)
                .onRegister(simpleTierBlock -> simpleTierBlock.addTooltip(Component.translatable(simpleTierBlock.getDescriptionId() + ".desc")))
                .item(RendererBlockItem::new)
                .model(NonNullBiConsumer.noop())
                .build()
                .register();
        ALL_CA_TIRED_CASINGS.put(blockData, componentAssemblyBlock::get);
        return componentAssemblyBlock;
    }

    protected static BlockEntry<Block> createCasingBlock(String name, BiFunction<BlockBehaviour.Properties, IRenderer, ? extends RendererBlock> blockSupplier, ResourceLocation texture, NonNullSupplier<? extends Block> properties, Supplier<Supplier<RenderType>> type) {
        return EPRegistration.EP_REGISTRATE.block(name, p -> (Block) blockSupplier.apply(p,
                        Platform.isClient() ? new TextureOverrideRenderer(new ResourceLocation("block/cube_all"),
                                Map.of("all", texture)) : null))
                .initialProperties(properties)
                .addLayer(type)
                .blockstate(NonNullBiConsumer.noop())
                .tag(GTToolType.WRENCH.harvestTags.get(0), BlockTags.MINEABLE_WITH_PICKAXE)
                .item(RendererBlockItem::new)
                .model(NonNullBiConsumer.noop())
                .build()
                .register();
    }

    private static BlockEntry<Block> createComplexTextureCasingBlock(String name, BiFunction<BlockBehaviour.Properties, IRenderer, ? extends RendererBlock> blockSupplier, NonNullSupplier<? extends Block> properties, Supplier<Supplier<RenderType>> type) {
        return EPRegistration.EP_REGISTRATE.block(name, p -> (Block) blockSupplier.apply(p,
                        Platform.isClient() ? new TextureOverrideRenderer(new ResourceLocation("block/cube_bottom_top"),
                                Map.of("bottom", GTCEu.id("block/casings/" + name + "/bottom"),
                                        "top", GTCEu.id("block/casings/" + name + "/top"),
                                        "side", GTCEu.id("block/casings/" + name + "/side"))) :
                                null))
                .initialProperties(properties)
                .addLayer(type)
                .blockstate(NonNullBiConsumer.noop())
                .tag(GTToolType.WRENCH.harvestTags.get(0), BlockTags.MINEABLE_WITH_PICKAXE)
                .item(RendererBlockItem::new)
                .model(NonNullBiConsumer.noop())
                .build()
                .register();
    }

    private static BlockEntry<ActiveBlock> createActiveCasing(String name, String baseModelPath) {
        String finalName = "%s".formatted(name);
        return EP_REGISTRATE.block(finalName, p -> new ActiveBlock(p,
                        Platform.isClient() ? new CTMModelRenderer(Epimorphism.id(baseModelPath)) : null,
                        Platform.isClient() ? new CTMModelRenderer(Epimorphism.id("%s_active".formatted(baseModelPath))) : null))
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .addLayer(() -> RenderType::cutoutMipped)
                .blockstate(NonNullBiConsumer.noop())
                .tag(GTToolType.WRENCH.harvestTags.get(0), BlockTags.MINEABLE_WITH_PICKAXE)
                .item(RendererBlockItem::new)
                .model(NonNullBiConsumer.noop())
                .build()
                .register();
    }

    @OnlyIn(Dist.CLIENT)
    public static BlockColor pineLeavesBlockColor() {
        return (state, reader, pos, tintIndex) -> FoliageColor.getEvergreenColor();
    }

    @OnlyIn(Dist.CLIENT)
    public static ItemColor pineLeavesItemColor() {
        return (stack, tintIndex) -> FoliageColor.getEvergreenColor();
    }
}
