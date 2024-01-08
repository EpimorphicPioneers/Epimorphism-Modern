package cn.gtcommunity.epimorphism.common.data;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.api.block.ITierGlassType;
import cn.gtcommunity.epimorphism.api.block.IFluidTankCell;
import cn.gtcommunity.epimorphism.api.block.IStorageFieldBlock;
import cn.gtcommunity.epimorphism.api.registry.EPRegistries;
import cn.gtcommunity.epimorphism.common.block.*;
import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.block.RendererBlock;
import com.gregtechceu.gtceu.api.block.RendererGlassBlock;
import com.gregtechceu.gtceu.api.item.RendererBlockItem;
import com.gregtechceu.gtceu.api.item.tool.GTToolType;
import com.gregtechceu.gtceu.client.renderer.block.TextureOverrideRenderer;
import com.gregtechceu.gtceu.common.block.RubberLogBlock;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.lowdragmc.lowdraglib.Platform;
import com.lowdragmc.lowdraglib.client.renderer.IRenderer;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullBiConsumer;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Supplier;

import static cn.gtcommunity.epimorphism.api.registry.EPRegistries.EP_REGISTRATE;
import static cn.gtcommunity.epimorphism.common.block.BlockMaps.*;
import static cn.gtcommunity.epimorphism.common.data.EPCreativeModeTabs.*;
import static com.gregtechceu.gtceu.common.data.GTModels.createModelBlockState;

public class EPBlocks {

    static {
        EP_REGISTRATE.creativeModeTab(() -> EP_BLOCK);
    }
    //////////////////////////////////////
    //******     Casing Blocks     *****//
    //////////////////////////////////////



    // Multiblock Machine Casing Blocks
    public static BlockEntry<Block> ISA_MILL_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
    public static BlockEntry<Block> FLOTATION_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
    public static BlockEntry<Block> VACUUM_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
    public static BlockEntry<Block> NAQUADRIA_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
    public static BlockEntry<Block> HYPER_CASING = createCasingBlock("hyper_casing", Epimorphism.id("block/casings/solid/hyper_casing"));
    public static BlockEntry<Block> TALONITE_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
    public static BlockEntry<Block> IRIDIUM_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
    public static BlockEntry<Block> BREEDING_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
    public static BlockEntry<Block> TRITANIUM_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
    public static BlockEntry<Block> QUANTUM_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
    public static BlockEntry<Block> REFLECTIVE_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
    public static BlockEntry<Block> GENERAL_PROCESSING_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
    public static BlockEntry<Block> MARAGING_STEEL_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
    public static BlockEntry<Block> BABBITT_ALLOY_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
    public static BlockEntry<Block> ZIRCONIUM_CARBIDE_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
    public static BlockEntry<Block> SUPERCRITICAL_FLUID_TURBINE_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
    public static BlockEntry<Block> CORROSION_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
    public static BlockEntry<Block> HASTELLOYX78_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
    public static BlockEntry<Block> HASTELLOYK243_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
    public static BlockEntry<Block> PRECISE_ASSEMBLER_CASING_MK1 = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
    public static BlockEntry<Block> PRECISE_ASSEMBLER_CASING_MK2 = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
    public static BlockEntry<Block> PRECISE_ASSEMBLER_CASING_MK3 = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
    public static BlockEntry<Block> BASIC_PHOTOLITHOGRAPHIC_FRAMEWORK_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
    public static BlockEntry<Block> MOLD_PRINTING_ASSEMBLY_FRAMEWORK_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
    public static BlockEntry<Block> RADIATION_PROOF_SCAN_FRAMEWORK_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
    public static BlockEntry<Block> BIOLOGICAL_STERILE_MACHINE_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
    public static BlockEntry<Block> WATER_COOLED_MACHINE_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
    public static BlockEntry<Block> INFINITY_COOLED_MACHINE_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
    public static BlockEntry<Block> TFFT_CASING = createCasingBlock("tfft_casing", Epimorphism.id("block/casings/solid/tfft_casing"));
    public static BlockEntry<Block> YOTTA_FLUID_TANK_CASING = createComplexTextureCasingBlock("yotta_fluid_tank_casing");

    // Multiblock Machine Pipe Casing Blocks
    public static BlockEntry<Block> CASING_POLYBENZIMIDAZOLE_PIPE = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
    public static BlockEntry<Block> CASING_ISA_MILL_PIPE = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
    public static BlockEntry<Block> CASING_FLOTATION_PIPE = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
    public static BlockEntry<Block> CASING_ALLOY_SMELTING_PIPE = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
    public static BlockEntry<Block> SPEEDING_PIPE = createComplexTextureCasingBlock("speeding_pipe");

    // Transparent Casing Blocks
    public static BlockEntry<TierGlassBlock> SILICATE_GLASS = createGlassBlock(TierGlassBlock.GlassType.SILICATE_GLASS, SoundType.GLASS, () -> RenderType::translucent);
    public static BlockEntry<TierGlassBlock> TI_BORON_SILICATE_GLASS = createGlassBlock(TierGlassBlock.GlassType.TI_BORON_SILICATE_GLASS, SoundType.GLASS, () -> RenderType::translucent);
    public static BlockEntry<TierGlassBlock> W_BORON_SILICATE_GLASS = createGlassBlock(TierGlassBlock.GlassType.W_BORON_SILICATE_GLASS, SoundType.GLASS, () -> RenderType::translucent);
    public static BlockEntry<TierGlassBlock> OSMIR_BORON_SILICATE_GLASS = createGlassBlock(TierGlassBlock.GlassType.OSMIR_BORON_SILICATE_GLASS, SoundType.GLASS, () -> RenderType::translucent);
    public static BlockEntry<TierGlassBlock> NAQ_BORON_SILICATE_GLASS = createGlassBlock(TierGlassBlock.GlassType.NAQ_BORON_SILICATE_GLASS, SoundType.GLASS, () -> RenderType::translucent);
    public static BlockEntry<TierGlassBlock> THY_BORON_SILICATE_GLASS = createGlassBlock(TierGlassBlock.GlassType.THY_BORON_SILICATE_GLASS, SoundType.GLASS, () -> RenderType::translucent);
    public static BlockEntry<TierGlassBlock> INFINITY_GLASS = createGlassBlock(TierGlassBlock.GlassType.INFINITY_GLASS, SoundType.GLASS, () -> RenderType::cutoutMipped);
    public static BlockEntry<TierGlassBlock> PMMA_GLASS = createGlassBlock(TierGlassBlock.GlassType.PMMA_GLASS, SoundType.STONE, () -> RenderType::translucent);
    public static BlockEntry<TierGlassBlock> NEU_PMMA_GLASS = createGlassBlock(TierGlassBlock.GlassType.NEU_PMMA_GLASS, SoundType.STONE, () -> RenderType::translucent);
    public static BlockEntry<TierGlassBlock> BPA_POLYCARBONATE_GLASS = createGlassBlock(TierGlassBlock.GlassType.BPA_POLYCARBONATE_GLASS, SoundType.STONE, () -> RenderType::translucent);
    public static BlockEntry<TierGlassBlock> CBDO_POLYCARBONATE_GLASS = createGlassBlock(TierGlassBlock.GlassType.CBDO_POLYCARBONATE_GLASS, SoundType.STONE, () -> RenderType::translucent);

    // Fluid Tank Cell Blocks
    public static BlockEntry<FluidTankCellBlock> FLUID_TANK_CELL_1 = createFluidCellBlock(FluidTankCellBlock.FluidCellType.CELL_1);
    public static BlockEntry<FluidTankCellBlock> FLUID_TANK_CELL_2 = createFluidCellBlock(FluidTankCellBlock.FluidCellType.CELL_2);
    public static BlockEntry<FluidTankCellBlock> FLUID_TANK_CELL_3 = createFluidCellBlock(FluidTankCellBlock.FluidCellType.CELL_3);
    public static BlockEntry<FluidTankCellBlock> FLUID_TANK_CELL_4 = createFluidCellBlock(FluidTankCellBlock.FluidCellType.CELL_4);
    public static BlockEntry<FluidTankCellBlock> FLUID_TANK_CELL_5 = createFluidCellBlock(FluidTankCellBlock.FluidCellType.CELL_5);
    public static BlockEntry<FluidTankCellBlock> FLUID_TANK_CELL_6 = createFluidCellBlock(FluidTankCellBlock.FluidCellType.CELL_6);
    public static BlockEntry<FluidTankCellBlock> FLUID_TANK_CELL_7 = createFluidCellBlock(FluidTankCellBlock.FluidCellType.CELL_7);
    public static BlockEntry<FluidTankCellBlock> FLUID_TANK_CELL_8 = createFluidCellBlock(FluidTankCellBlock.FluidCellType.CELL_8);
    public static BlockEntry<FluidTankCellBlock> FLUID_TANK_CELL_9 = createFluidCellBlock(FluidTankCellBlock.FluidCellType.CELL_9);
    public static BlockEntry<FluidTankCellBlock> FLUID_TANK_CELL_10 = createFluidCellBlock(FluidTankCellBlock.FluidCellType.CELL_10);

    //  Storage Field Blocks
    public static BlockEntry<StorageFieldBlock> STORAGE_FIELD_BLOCK_1 = createStorageFieldBlock(StorageFieldBlock.FieldBlockType.BLOCK_1);
    public static BlockEntry<StorageFieldBlock> STORAGE_FIELD_BLOCK_2 = createStorageFieldBlock(StorageFieldBlock.FieldBlockType.BLOCK_2);
    public static BlockEntry<StorageFieldBlock> STORAGE_FIELD_BLOCK_3 = createStorageFieldBlock(StorageFieldBlock.FieldBlockType.BLOCK_3);
    public static BlockEntry<StorageFieldBlock> STORAGE_FIELD_BLOCK_4 = createStorageFieldBlock(StorageFieldBlock.FieldBlockType.BLOCK_4);
    public static BlockEntry<StorageFieldBlock> STORAGE_FIELD_BLOCK_5 = createStorageFieldBlock(StorageFieldBlock.FieldBlockType.BLOCK_5);
    public static BlockEntry<StorageFieldBlock> STORAGE_FIELD_BLOCK_6 = createStorageFieldBlock(StorageFieldBlock.FieldBlockType.BLOCK_6);
    public static BlockEntry<StorageFieldBlock> STORAGE_FIELD_BLOCK_7 = createStorageFieldBlock(StorageFieldBlock.FieldBlockType.BLOCK_7);
    public static BlockEntry<StorageFieldBlock> STORAGE_FIELD_BLOCK_8 = createStorageFieldBlock(StorageFieldBlock.FieldBlockType.BLOCK_8);
    public static BlockEntry<StorageFieldBlock> STORAGE_FIELD_BLOCK_9 = createStorageFieldBlock(StorageFieldBlock.FieldBlockType.BLOCK_9);
    public static BlockEntry<StorageFieldBlock> STORAGE_FIELD_BLOCK_10 = createStorageFieldBlock(StorageFieldBlock.FieldBlockType.BLOCK_10);

    //  Misc
    public static BlockEntry<Block> FERTILIZED_DIRT = EP_REGISTRATE
            .block("fertilized_dirt", FertilizedDirtBlock::create)
            .initialProperties(() -> Blocks.DIRT)
            .lang("Fertilized Dirt")
            .tag(BlockTags.DIRT)
            .properties(BlockBehaviour.Properties::randomTicks)
            .item()
            .tag(ItemTags.DIRT)
            .build()
            .register();

    public static BlockEntry<Block> FERTILIZED_FARMLAND = EP_REGISTRATE
            .block("fertilized_farmland", FertilizedFarmlandBlock::create)
            .initialProperties(() -> Blocks.FARMLAND)
            .lang("Fertilized Farmland")
            .blockstate((ctx, prov) -> createModelBlockState(ctx, prov, Epimorphism.id("block/fertilized_farmland")))
            .loot((table, block) -> table.add(block, LootTable.lootTable()
                    .withPool(table.applyExplosionCondition(block, LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)))
                            .add(LootItem.lootTableItem(EPBlocks.FERTILIZED_DIRT.asItem())))))
            .tag(BlockTags.BIG_DRIPLEAF_PLACEABLE)
            .addLayer(() -> RenderType::cutout)
            .item()
            .build()
            .register();

    public static void init() {/**/}

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
                .tag(GTToolType.WRENCH.harvestTag, BlockTags.MINEABLE_WITH_PICKAXE)
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
                .tag(GTToolType.WRENCH.harvestTag, BlockTags.MINEABLE_WITH_PICKAXE)
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
                .tag(GTToolType.WRENCH.harvestTag, BlockTags.MINEABLE_WITH_PICKAXE)
                .item(RendererBlockItem::new)
                .model(NonNullBiConsumer.noop())
                .build()
                .register();
        ALL_FIELD_BLOCKS.put(blockData, fieldBlock::get);
        return fieldBlock;
    }

    protected static BlockEntry<Block> createCasingBlock(String name, BiFunction<BlockBehaviour.Properties, IRenderer, ? extends RendererBlock> blockSupplier, ResourceLocation texture, NonNullSupplier<? extends Block> properties, Supplier<Supplier<RenderType>> type) {
        return EPRegistries.EP_REGISTRATE.block(name, p -> (Block) blockSupplier.apply(p,
                        Platform.isClient() ? new TextureOverrideRenderer(new ResourceLocation("block/cube_all"),
                                Map.of("all", texture)) : null))
                .initialProperties(properties)
                .addLayer(type)
                .blockstate(NonNullBiConsumer.noop())
                .tag(GTToolType.WRENCH.harvestTag, BlockTags.MINEABLE_WITH_PICKAXE)
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
                .tag(GTToolType.WRENCH.harvestTag, BlockTags.MINEABLE_WITH_PICKAXE)
                .item(RendererBlockItem::new)
                .model(NonNullBiConsumer.noop())
                .build()
                .register();
    }
}
