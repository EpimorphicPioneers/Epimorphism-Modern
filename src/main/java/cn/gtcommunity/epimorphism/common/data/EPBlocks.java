package cn.gtcommunity.epimorphism.common.data;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.api.block.ITierGlassType;
import cn.gtcommunity.epimorphism.api.block.IFluidTankCell;
import cn.gtcommunity.epimorphism.api.block.IStorageFieldBlock;
import cn.gtcommunity.epimorphism.api.chemical.material.properties.EPPropertyKeys;
import cn.gtcommunity.epimorphism.api.data.tag.EPTagPrefix;
import cn.gtcommunity.epimorphism.api.registry.EPRegistries;
import cn.gtcommunity.epimorphism.api.structure.block.tier.ITierType;
import cn.gtcommunity.epimorphism.common.block.*;
import cn.gtcommunity.epimorphism.core.mixins.accessors.BlockLootSubProviderAccessor;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Table;
import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.block.RendererBlock;
import com.gregtechceu.gtceu.api.block.RendererGlassBlock;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.registry.MaterialRegistry;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.item.MaterialBlockItem;
import com.gregtechceu.gtceu.api.item.RendererBlockItem;
import com.gregtechceu.gtceu.api.item.tool.GTToolType;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import com.gregtechceu.gtceu.client.renderer.block.TextureOverrideRenderer;
import com.gregtechceu.gtceu.common.data.*;
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

import static cn.gtcommunity.epimorphism.api.registry.EPRegistries.EP_REGISTRATE;
import static cn.gtcommunity.epimorphism.common.block.BlockMaps.*;
import static com.gregtechceu.gtceu.common.data.GTModels.createModelBlockState;
import static com.gregtechceu.gtceu.common.registry.GTRegistration.REGISTRATE;

@SuppressWarnings("all")
public class EPBlocks {

    //////////////////////////////////////
    //*****     Tables Builders    *****//
    //////////////////////////////////////
    private static ImmutableTable.Builder<TagPrefix, Material, BlockEntry<CrucibleBlock>> CRUCIBLE_BLOCKS_BUILDER = ImmutableTable.builder();

    //////////////////////////////////////
    //*****    Reference Tables    *****//
    //////////////////////////////////////

    public static Table<TagPrefix, Material, BlockEntry<CrucibleBlock>> CRUCIBLE_BLOCKS;

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
    private static void registerCrucibleBlock(Material material, GTRegistrate registrate) {
        var entry = registrate.block("%s_crucible".formatted(material.getName()), p -> new CrucibleBlock(p, material))
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .properties(p -> EPTagPrefix.crucible.blockProperties().properties().apply(p).noLootTable())
                .transform(GTBlocks.unificationBlock(EPTagPrefix.crucible, material))
                .addLayer(() -> RenderType::cutout)
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

    static {
        EP_REGISTRATE.creativeModeTab(() -> EPCreativeModeTabs.EP_BLOCK);
    }
    //////////////////////////////////////
    //******     Casing Blocks     *****//
    //////////////////////////////////////

    // Multiblock Machine Casing Blocks
    public static final BlockEntry<Block> NAQUADRIA_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
    public static final BlockEntry<Block> HYPER_CASING = createCasingBlock("hyper_casing", Epimorphism.id("block/casings/solid/hyper_casing"));
    public static final BlockEntry<Block> TALONITE_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
    public static final BlockEntry<Block> IRIDIUM_CASING = createCasingBlock("iridium_casing", Epimorphism.id("block/casings/solid/iridium_casing"));
    public static final BlockEntry<Block> BREEDING_CASING = createCasingBlock("breeding_casing", Epimorphism.id("block/casings/solid/breeding_casing"));
    public static final BlockEntry<Block> TRITANIUM_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
    public static final BlockEntry<Block> QUANTUM_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
    public static final BlockEntry<Block> REFLECTIVE_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
    public static final BlockEntry<Block> GENERAL_PROCESSING_CASING = createCasingBlock("general_processing_casing", Epimorphism.id("block/casings/solid/general_processing_casing"));
    public static final BlockEntry<Block> MARAGING_STEEL_CASING = createCasingBlock("maraging_steel_250_casing", Epimorphism.id("block/casings/solid/maraging_steel_250_casing"));
    public static final BlockEntry<Block> BABBITT_ALLOY_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
    public static final BlockEntry<Block> NEUTRONIUM_MINING_CASING = createCasingBlock("neutronium_mining_casing", Epimorphism.id("block/casings/solid/neutronium_mining_casing"));
    public static final BlockEntry<Block> ZIRCONIUM_CARBIDE_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
    public static final BlockEntry<Block> SUPERCRITICAL_FLUID_TURBINE_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
    public static final BlockEntry<Block> CORROSION_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
    public static final BlockEntry<Block> HASTELLOYX78_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
    public static final BlockEntry<Block> HASTELLOYK243_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
    public static final BlockEntry<Block> PRECISE_ASSEMBLER_CASING_MK1 = createCasingBlock("precise_assembler_casing_mk1", Epimorphism.id("block/casings/solid/precise_assembler_casing_mk1"));
    public static final BlockEntry<Block> PRECISE_ASSEMBLER_CASING_MK2 = createCasingBlock("precise_assembler_casing_mk2", Epimorphism.id("block/casings/solid/precise_assembler_casing_mk2"));
    public static final BlockEntry<Block> PRECISE_ASSEMBLER_CASING_MK3 = createCasingBlock("precise_assembler_casing_mk3", Epimorphism.id("block/casings/solid/precise_assembler_casing_mk3"));
    public static final BlockEntry<Block> BASIC_PHOTOLITHOGRAPHIC_FRAMEWORK_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
    public static final BlockEntry<Block> MOLD_PRINTING_ASSEMBLY_FRAMEWORK_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
    public static final BlockEntry<Block> RADIATION_PROOF_SCAN_FRAMEWORK_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
    public static final BlockEntry<Block> BIOLOGICAL_STERILE_MACHINE_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
    public static final BlockEntry<Block> WATER_COOLED_MACHINE_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
    public static final BlockEntry<Block> INFINITY_COOLED_MACHINE_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
    public static final BlockEntry<Block> ADVANCED_INVAR_CASING = createCasingBlock("advanced_invar_casing", Epimorphism.id("block/casings/solid/advanced_invar_casing"));
    public static final BlockEntry<Block> ADVANCED_ALUMINIUM_CASING = createCasingBlock("advanced_aluminium_casing", Epimorphism.id("block/casings/solid/advanced_aluminium_casing"));
    public static final BlockEntry<Block> ADVANCED_FILTER_CASING = createCasingBlock("advanced_filter_casing", Epimorphism.id("block/casings/solid/advanced_filter_casing"));
    public static final BlockEntry<Block> TFFT_CASING = createCasingBlock("tfft_casing", Epimorphism.id("block/casings/solid/tfft_casing"));
    public static final BlockEntry<Block> PROCESS_MACHINE_CASING = createCasingBlock("process_machine_casing", Epimorphism.id("block/casings/solid/process_machine_casing"));
    public static final BlockEntry<Block> YOTTA_FLUID_TANK_CASING = createComplexTextureCasingBlock("yotta_fluid_tank_casing");

    // Multiblock Special Casing Blocks
    ////  Isa
    public static final BlockEntry<Block> ISA_MILL_CASING = createCasingBlock("isa_mill_casing", Epimorphism.id("block/casings/solid/isa_mill_casing"));
    public static final BlockEntry<Block> CASING_ISA_MILL_PIPE = createCasingBlock("isa_mill_casing_pipe", Epimorphism.id("block/casings/solid/isa_mill_casing_pipe"));
    public static final BlockEntry<Block> CASING_ISA_MILL_GEARBOX = createCasingBlock("casing_isa_mill_gearbox", Epimorphism.id("block/casings/gearbox/casing_isa_mill_gearbox"));
    public static final BlockEntry<Block> FLOTATION_CASING = createCasingBlock("flotation_casing", Epimorphism.id("block/casings/solid/flotation_casing"));
    public static final BlockEntry<Block> FLOTATION_CELL = createCasingBlock("flotation_cell", Epimorphism.id("block/casings/solid/flotation_cell"));// industrial_flotation_cell
    public static final BlockEntry<Block> VACUUM_CASING = createCasingBlock("vacuum_casing", Epimorphism.id("block/casings/solid/vacuum_casing"));

    public static final BlockEntry<Block> SPEEDING_PIPE = createComplexTextureCasingBlock("speeding_pipe");
    public static final BlockEntry<Block> SUBSTRATE_CASING = createComplexTextureCasingBlock("substrate_casing");
    public static final BlockEntry<Block> ADVANCED_SUBSTRATE_CASING = createComplexTextureCasingBlock("advanced_substrate_casing");
    public static final BlockEntry<Block> DRILL_HEAD = createComplexTextureCasingBlock("drill_head");


    // Multiblock Machine Pipe Casing Blocks
    public static final BlockEntry<Block> CASING_POLYBENZIMIDAZOLE_PIPE = createCasingBlock("polybenzimidazole_pipe", Epimorphism.id("block/casings/pipe/polybenzimidazole_pipe"));
    public static final BlockEntry<Block> CASING_FLOTATION_PIPE = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
    public static final BlockEntry<Block> CASING_ALLOY_SMELTING_PIPE = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));

    // Multiblock Machine Gearbox Casing Blocks

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


    //  Misc

    static {
        EP_REGISTRATE.creativeModeTab(() -> EPCreativeModeTabs.EP_AGRICULTURE);
    }
    public static BlockEntry<FertilizedDirtBlock> FERTILIZED_DIRT = EP_REGISTRATE
            .block("fertilized_dirt", FertilizedDirtBlock::new)
            .initialProperties(() -> Blocks.DIRT)
            .lang("Fertilized Dirt")
            .tag(BlockTags.DIRT)
            .properties(BlockBehaviour.Properties::randomTicks)
            .item()
            .tag(ItemTags.DIRT)
            .build()
            .register();

    public static BlockEntry<FertilizedFarmlandBlock> FERTILIZED_FARMLAND = EP_REGISTRATE
            .block("fertilized_farmland", FertilizedFarmlandBlock::new)
            .initialProperties(() -> Blocks.FARMLAND)
            .lang("Fertilized Farmland")
            .blockstate((ctx, prov) -> GTModels.createModelBlockState(ctx, prov, Epimorphism.id("block/fertilized_farmland")))
            .loot((table, block) -> table.add(block, LootTable.lootTable()
                    .withPool(table.applyExplosionCondition(block, LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)))
                            .add(LootItem.lootTableItem(EPBlocks.FERTILIZED_DIRT.asItem())))))
            .tag(BlockTags.BIG_DRIPLEAF_PLACEABLE)
            .addLayer(() -> RenderType::cutout)
            .item()
            .build()
            .register();

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
                            .add(table.applyExplosionCondition(block, LootItem.lootTableItem(EPAgricultureItem.PINECONE))
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

    private static BlockEntry<SimpleTierBlock> createComponentAssemblyBlock(ITierType blockData) {
        BlockEntry<SimpleTierBlock> componentAssemblyBlock = EP_REGISTRATE.block("component_assembly_line_casing_%s".formatted(blockData.typeName()),
                        p -> new SimpleTierBlock(p, blockData, Platform.isClient() ? new TextureOverrideRenderer(GTCEu.id("block/cube_2_layer_all"),
                                Map.of("top_all", Epimorphism.id("block/casings/component_assembly_line_casing/%s".formatted(blockData.typeName().toLowerCase())),
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
        return EPRegistries.EP_REGISTRATE.block(name, p -> (Block) blockSupplier.apply(p,
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
        return EPRegistries.EP_REGISTRATE.block(name, p -> (Block) blockSupplier.apply(p,
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

    @OnlyIn(Dist.CLIENT)
    public static BlockColor pineLeavesBlockColor() {
        return (state, reader, pos, tintIndex) -> FoliageColor.getEvergreenColor();
    }

    @OnlyIn(Dist.CLIENT)
    public static ItemColor pineLeavesItemColor() {
        return (stack, tintIndex) -> FoliageColor.getEvergreenColor();
    }
}
