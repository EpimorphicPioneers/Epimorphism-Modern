package cn.gtcommunity.epimorphism.common.data;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.api.registry.EPRegistries;
import com.gregtechceu.gtceu.api.block.RendererBlock;
import com.gregtechceu.gtceu.api.block.RendererGlassBlock;
import com.gregtechceu.gtceu.api.item.RendererBlockItem;
import com.gregtechceu.gtceu.api.item.tool.GTToolType;
import com.gregtechceu.gtceu.client.renderer.block.TextureOverrideRenderer;
import com.lowdragmc.lowdraglib.Platform;
import com.lowdragmc.lowdraglib.client.renderer.IRenderer;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullBiConsumer;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Supplier;

import static cn.gtcommunity.epimorphism.api.registry.EPRegistries.REGISTRATE;
import static cn.gtcommunity.epimorphism.common.data.EPCreativeModeTabs.*;

public class EPBlocks {
    //////////////////////////////////////
    //******     Casing Blocks     *****//
    //////////////////////////////////////



    // Multiblock Machine Casing Blocks
    public static BlockEntry<Block> ISA_MILL_CASING;
    public static BlockEntry<Block> FLOTATION_CASING;
    public static BlockEntry<Block> VACUUM_CASING;
    public static BlockEntry<Block> NAQUADRIA_CASING;
    public static BlockEntry<Block> HYPER_CASING;
    public static BlockEntry<Block> TALONITE_CASING;
    public static BlockEntry<Block> IRIDIUM_CASING;
    public static BlockEntry<Block> BREEDING_CASING;
    public static BlockEntry<Block> TRITANIUM_CASING;
    public static BlockEntry<Block> QUANTUM_CASING;
    public static BlockEntry<Block> REFLECTIVE_CASING;
    public static BlockEntry<Block> GENERAL_PROCESSING_CASING;
    public static BlockEntry<Block> MARAGING_STEEL_CASING;
    public static BlockEntry<Block> BABBITT_ALLOY_CASING;
    public static BlockEntry<Block> ZIRCONIUM_CARBIDE_CASING;
    public static BlockEntry<Block> SUPERCRITICAL_FLUID_TURBINE_CASING;
    public static BlockEntry<Block> CORROSION_CASING;
    public static BlockEntry<Block> HASTELLOYX78_CASING;
    public static BlockEntry<Block> HASTELLOYK243_CASING;
    public static BlockEntry<Block> PRECISE_ASSEMBLER_CASING_MK1;
    public static BlockEntry<Block> PRECISE_ASSEMBLER_CASING_MK2;
    public static BlockEntry<Block> PRECISE_ASSEMBLER_CASING_MK3;
    public static BlockEntry<Block> BASIC_PHOTOLITHOGRAPHIC_FRAMEWORK_CASING;
    public static BlockEntry<Block> MOLD_PRINTING_ASSEMBLY_FRAMEWORK_CASING;
    public static BlockEntry<Block> RADIATION_PROOF_SCAN_FRAMEWORK_CASING;
    public static BlockEntry<Block>  BIOLOGICAL_STERILE_MACHINE_CASING;
    public static BlockEntry<Block>  WATER_COOLED_MACHINE_CASING;
    public static BlockEntry<Block>  INFINITY_COOLED_MACHINE_CASING;

    // Multiblock Machine Pipe Casing Blocks
    public static BlockEntry<Block> CASING_POLYBENZIMIDAZOLE_PIPE;
    public static BlockEntry<Block> CASING_ISA_MILL_PIPE;
    public static BlockEntry<Block> CASING_FLOTATION_PIPE;
    public static BlockEntry<Block> CASING_ALLOY_SMELTING_PIPE;

    public static void init() {
        //////////////////////////////////////
        //******     Casing Blocks     *****//
        //////////////////////////////////////

        REGISTRATE.creativeModeTab(() -> EP_BLOCK);

        // Multiblock Machine Casing Blocks
        ISA_MILL_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
        FLOTATION_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
        VACUUM_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
        NAQUADRIA_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
        HYPER_CASING = createCasingBlock("hyper_casing", Epimorphism.id("block/casings/solid/hyper_casing"));
        TALONITE_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
        IRIDIUM_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
        BREEDING_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
        TRITANIUM_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
        QUANTUM_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
        REFLECTIVE_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
        GENERAL_PROCESSING_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
        MARAGING_STEEL_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
        BABBITT_ALLOY_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
        ZIRCONIUM_CARBIDE_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
        SUPERCRITICAL_FLUID_TURBINE_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
        CORROSION_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
        HASTELLOYX78_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
        HASTELLOYK243_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
        PRECISE_ASSEMBLER_CASING_MK1 = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
        PRECISE_ASSEMBLER_CASING_MK2 = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
        PRECISE_ASSEMBLER_CASING_MK3 = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
        BASIC_PHOTOLITHOGRAPHIC_FRAMEWORK_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
        MOLD_PRINTING_ASSEMBLY_FRAMEWORK_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
        RADIATION_PROOF_SCAN_FRAMEWORK_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
        BIOLOGICAL_STERILE_MACHINE_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
        WATER_COOLED_MACHINE_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
        INFINITY_COOLED_MACHINE_CASING = createCasingBlock("nonconducting_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));

        // Multiblock Machine Pipe Casing Blocks
        CASING_POLYBENZIMIDAZOLE_PIPE = createCasingBlock("polybenzimidazole_pipe", Epimorphism.id("block/casings/solid/nonconducting_casing"));
        CASING_ISA_MILL_PIPE = createCasingBlock("isa_mill_casing_pipe", Epimorphism.id("block/casings/solid/nonconducting_casing"));
        CASING_FLOTATION_PIPE = createCasingBlock("flotation_casing_pipe", Epimorphism.id("block/casings/solid/nonconducting_casing"));
        CASING_ALLOY_SMELTING_PIPE = createCasingBlock("alloy_smelting_pipe_casing", Epimorphism.id("block/casings/solid/nonconducting_casing"));
    }

    protected static BlockEntry<Block> createCasingBlock(String name, ResourceLocation texture) {
        return createCasingBlock(name, RendererBlock::new, texture, () -> Blocks.IRON_BLOCK, () -> RenderType::cutoutMipped);
    }

    private static BlockEntry<Block> createGlassCasingBlock(String name, ResourceLocation texture, Supplier<Supplier<RenderType>> type) {
        return createCasingBlock(name, RendererGlassBlock::new, texture, () -> Blocks.GLASS, type);
    }

    protected static BlockEntry<Block> createCasingBlock(String name, BiFunction<BlockBehaviour.Properties, IRenderer, ? extends RendererBlock> blockSupplier, ResourceLocation texture, NonNullSupplier<? extends Block> properties, Supplier<Supplier<RenderType>> type) {
        return EPRegistries.REGISTRATE.block(name, p -> (Block) blockSupplier.apply(p,
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
}
