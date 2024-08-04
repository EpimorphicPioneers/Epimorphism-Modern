package com.epimorphismmc.epimorphism.common.data;

import com.epimorphismmc.epimorphism.Epimorphism;
import com.epimorphismmc.epimorphism.api.machine.EfficiencyGeneratorMachine;
import com.epimorphismmc.epimorphism.api.machine.multiblock.EPPartAbility;
import com.epimorphismmc.epimorphism.api.machine.multiblock.TierCasingElectricMultiblockMachine;
import com.epimorphismmc.epimorphism.api.pattern.EPPredicates;
import com.epimorphismmc.epimorphism.client.renderer.handler.machine.BallHatchRenderer;
import com.epimorphismmc.epimorphism.client.renderer.handler.machine.DigesterRenderer;
import com.epimorphismmc.epimorphism.client.renderer.handler.machine.LightningRodRenderer;
import com.epimorphismmc.epimorphism.client.renderer.handler.machine.TankMachineRenderer;
import com.epimorphismmc.epimorphism.common.block.BlockMaps;
import com.epimorphismmc.epimorphism.common.block.CrucibleBlock;
import com.epimorphismmc.epimorphism.common.block.EPFusionCasingBlock;
import com.epimorphismmc.epimorphism.common.data.machine.AdvancedMachines;
import com.epimorphismmc.epimorphism.common.data.machine.BiologyMachines;
import com.epimorphismmc.epimorphism.common.data.machine.EPAEMachines;
import com.epimorphismmc.epimorphism.common.data.machine.GeneratorMachines;
import com.epimorphismmc.epimorphism.common.machine.generator.LightningRodMachine;
import com.epimorphismmc.epimorphism.common.machine.generator.NuclearReactorMachine;
import com.epimorphismmc.epimorphism.common.machine.generator.ReactorChamberMachine;
import com.epimorphismmc.epimorphism.common.machine.multiblock.electric.ChemicalPlantMachine;
import com.epimorphismmc.epimorphism.common.machine.multiblock.electric.ConcreteBackfillerMachine;
import com.epimorphismmc.epimorphism.common.machine.multiblock.electric.DTPFMachine;
import com.epimorphismmc.epimorphism.common.machine.multiblock.electric.DigesterMachine;
import com.epimorphismmc.epimorphism.common.machine.multiblock.electric.DissolutionTankMachine;
import com.epimorphismmc.epimorphism.common.machine.multiblock.electric.FrackerMachine;
import com.epimorphismmc.epimorphism.common.machine.multiblock.electric.IndustrialDrillMachine;
import com.epimorphismmc.epimorphism.common.machine.multiblock.electric.IsaMillMachine;
import com.epimorphismmc.epimorphism.common.machine.multiblock.electric.NanoForgeMachine;
import com.epimorphismmc.epimorphism.common.machine.multiblock.electric.NanoscaleFabricatorMachine;
import com.epimorphismmc.epimorphism.common.machine.multiblock.electric.advanced.AdvancedEBFMachine;
import com.epimorphismmc.epimorphism.common.machine.multiblock.noenergy.NeutronActivatorMachine;
import com.epimorphismmc.epimorphism.common.machine.multiblock.part.BallHatchPartMachine;
import com.epimorphismmc.epimorphism.common.machine.multiblock.part.CatalystHatchPartMachine;
import com.epimorphismmc.epimorphism.common.machine.multiblock.part.InfiniteWaterHatchPartMachine;
import com.epimorphismmc.epimorphism.common.machine.multiblock.part.IntakeHatchPartMachine;
import com.epimorphismmc.epimorphism.common.machine.multiblock.part.NeutronAcceleratorPartMachine;
import com.epimorphismmc.epimorphism.common.machine.multiblock.part.NeutronSensorPartMachine;
import com.epimorphismmc.epimorphism.common.machine.multiblock.part.RadiationHatchPartMachine;
import com.epimorphismmc.epimorphism.common.machine.multiblock.part.ReinforcedRotorHolderPartMachine;
import com.epimorphismmc.epimorphism.common.machine.multiblock.storage.TFFTMachine;
import com.epimorphismmc.epimorphism.common.machine.multiblock.storage.YottaFluidTankMachine;
import com.epimorphismmc.epimorphism.common.machine.storage.InfinityCrateMachine;
import com.epimorphismmc.epimorphism.integration.EPIntegration;

import com.epimorphismmc.monomorphism.client.renderer.machine.CustomPartRenderer;
import com.epimorphismmc.monomorphism.client.renderer.machine.TierCasingMachineRenderer;
import com.epimorphismmc.monomorphism.machine.multiblock.ParallelCoilMultiblockMachine;
import com.epimorphismmc.monomorphism.machine.multiblock.ParallelElectricMultiblockMachine;
import com.epimorphismmc.monomorphism.pattern.FactoryMOPattern;
import com.epimorphismmc.monomorphism.pattern.LayerShapeInfo;
import com.epimorphismmc.monomorphism.pattern.MOBlockPattern;
import com.epimorphismmc.monomorphism.pattern.MOPredicates;
import com.epimorphismmc.monomorphism.pattern.utils.StructureUtil;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.recipe.FluidRecipeCapability;
import com.gregtechceu.gtceu.api.capability.recipe.ItemRecipeCapability;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.machine.*;
import com.gregtechceu.gtceu.api.machine.multiblock.CoilWorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.MultiblockControllerMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.MultiblockShapeInfo;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.api.pattern.util.RelativeDirection;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.api.recipe.OverclockingLogic;
import com.gregtechceu.gtceu.api.recipe.modifier.RecipeModifier;
import com.gregtechceu.gtceu.api.registry.registrate.MachineBuilder;
import com.gregtechceu.gtceu.api.registry.registrate.MultiblockMachineBuilder;
import com.gregtechceu.gtceu.client.renderer.block.TextureOverrideRenderer;
import com.gregtechceu.gtceu.client.renderer.machine.*;
import com.gregtechceu.gtceu.common.block.BoilerFireboxType;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMachines;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.GTRecipeModifiers;
import com.gregtechceu.gtceu.common.machine.multiblock.electric.FusionReactorMachine;
import com.gregtechceu.gtceu.common.machine.multiblock.steam.SteamParallelMultiblockMachine;
import com.gregtechceu.gtceu.data.lang.LangHandler;
import com.gregtechceu.gtceu.utils.FormattingUtil;

import com.lowdragmc.lowdraglib.Platform;

import net.minecraft.ChatFormatting;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DirectionalBlock;

import com.google.common.primitives.Ints;
import com.tterrag.registrate.util.entry.BlockEntry;
import it.unimi.dsi.fastutil.ints.Int2LongFunction;
import org.joml.Math;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static com.epimorphismmc.epimorphism.EpimorphismCommon.registrate;
import static com.epimorphismmc.epimorphism.common.block.BlockMaps.*;
import static com.epimorphismmc.monomorphism.block.MOBlockMaps.ALL_COIL_BLOCKS;
import static com.epimorphismmc.monomorphism.block.MOBlockMaps.ALL_MACHINE_CASINGS;
import static com.epimorphismmc.monomorphism.pattern.MOPredicates.*;
import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.block;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.frameGt;
import static com.gregtechceu.gtceu.api.machine.multiblock.PartAbility.*;
import static com.gregtechceu.gtceu.api.pattern.Predicates.*;
import static com.gregtechceu.gtceu.common.data.GCyMBlocks.*;
import static com.gregtechceu.gtceu.common.data.GTBlocks.*;
import static com.gregtechceu.gtceu.common.data.GTMachines.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;
import static com.gregtechceu.gtceu.utils.FormattingUtil.toEnglishName;
import static com.gregtechceu.gtceu.utils.FormattingUtil.toRomanNumeral;

public class EPMachines {
    public static final int[] NO_HIGH_TIERS = tiersBetween(1, 8);

    static {
        registrate().creativeModeTab(() -> EPCreativeModeTabs.EP_MACHINE);
    }

    //////////////////////////////////////
    // ******     Steam Machine    ******//
    //////////////////////////////////////

    //////////////////////////////////////
    // ***    Simple Tiered Machine   ***//
    //////////////////////////////////////

    //////////////////////////////////////
    // *******      Generator     *******//
    //////////////////////////////////////

    public static final MachineDefinition[] NAQUADAH_REACTOR =
            EPMachines.registerEfficiencyGenerators(
                    "naquadah_reactor",
                    EPRecipeTypes.NAQUADAH_REACTOR_FUELS,
                    EfficiencyGeneratorMachine::nonParallel,
                    genericGeneratorTankSizeFunction,
                    tiersBetween(EV, UV));
    public static final MachineDefinition[] ROCKET_ENGINE = EPMachines.registerEfficiencyGenerators(
            "rocket_engine",
            EPRecipeTypes.ROCKET_ENGINE_FUELS,
            EfficiencyGeneratorMachine::parallel,
            genericGeneratorTankSizeFunction,
            EV,
            IV,
            LuV);
    public static final MachineDefinition[] SEMILIQUID_GENERATOR =
            EPMachines.registerTieredEPGenerators(
                    "semiliquid_generator",
                    EPRecipeTypes.SEMILIQUID_GENERATOR_FUELS,
                    genericGeneratorTankSizeFunction,
                    LV,
                    MV,
                    HV);
    public static final MachineDefinition[] ACID_FUEL_CELL = EPMachines.registerTieredEPGenerators(
            "acid_fuel_cell",
            EPRecipeTypes.ACIDIC_FUEL_CELL_FUELS,
            genericGeneratorTankSizeFunction,
            LV,
            MV,
            HV);
    public static final MachineDefinition[] LIGHTNING_ROD = EPMachines.registerTieredEPMachines(
            "lightning_rod",
            LightningRodMachine::new,
            (tier, builder) -> builder
                    .langValue("%s Lightning Rod %s".formatted(VLVH[tier], VLVT[tier]))
                    .rotationState(RotationState.NON_Y_AXIS)
                    .renderer(() ->
                            new LightningRodRenderer(tier, Epimorphism.id("block/generators/lightning_rod")))
                    .tooltips()
                    .register(),
            tiersBetween(LuV, UV));
    public static final MachineDefinition NUCLEAR_REACTOR = registrate()
            .machine("nuclear_reactor", NuclearReactorMachine::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .langValue("Nuclear Reactor")
            .recipeType(DUMMY_RECIPES)
            .workableCasingRenderer(
                    Epimorphism.id("block/generators/nuclear_reactor/base"),
                    Epimorphism.id("block/generators/nuclear_reactor"))
            .register();
    public static final MachineDefinition REACTOR_CHAMBER = registrate()
            .machine("reactor_chamber", ReactorChamberMachine::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .langValue("Reactor Chamber")
            .recipeType(DUMMY_RECIPES)
            .defaultModelRenderer()
            .register();

    //////////////////////////////////////
    // ********     Electric     ********//
    //////////////////////////////////////

    public static final MachineDefinition[] DEHYDRATOR = registerSimpleMachines(
            "dehydrator",
            EPRecipeTypes.DEHYDRATOR_RECIPES,
            GTMachines.defaultTankSizeFunction,
            tiersBetween(MV, ZPM));

    ///////////////////////////////////////
    // *********     Storage    *********//
    //////////////////////////////////////

    public static final MachineDefinition INFINITY_CRATE = registrate()
            .machine(
                    "infinity_crate", holder -> new InfinityCrateMachine(holder, EPMaterials.Infinity, 252))
            .langValue("Infinity Crate")
            .rotationState(RotationState.NONE)
            .tooltips(Component.translatable("gtceu.universal.tooltip.item_storage_capacity", 252))
            .tooltips(Component.translatable("block.epimorphism.infinity_crate.desc"))
            .renderer(() -> new TextureOverrideRenderer(
                    new ResourceLocation("block/cube_all"),
                    Map.of("all", Epimorphism.id("block/storage/crates/infinity_crate"))))
            .register();

    //////////////////////////////////////
    // **********     Part     **********//
    //////////////////////////////////////

    public static final MachineDefinition INFINITE_WATER_HATCH = registrate()
            .machine("infinite_water_hatch", InfiniteWaterHatchPartMachine::new)
            .langValue("Infinite Water Hatch")
            .tier(IV)
            .rotationState(RotationState.ALL)
            .abilities(PartAbility.IMPORT_FLUIDS)
            .overlayTieredHullRenderer("infinite_water_hatch")
            .tooltips(
                    Component.translatable("block.epimorphism.infinite_water_hatch.desc.0"),
                    Component.translatable("block.epimorphism.infinite_water_hatch.desc.1"),
                    Component.translatable("block.epimorphism.infinite_water_hatch.desc.2"))
            .register();

    public static final MachineDefinition[] INTAKE_HATCH = registerTieredEPMachines(
            "intake_hatch",
            IntakeHatchPartMachine::new,
            (tier, builder) -> builder
                    .langValue("%s §rIntake Hatch".formatted(VNF[tier]))
                    .rotationState(RotationState.ALL)
                    .abilities(IMPORT_FLUIDS)
                    .overlayTieredHullRenderer("intake_hatch")
                    .tooltips(
                            Component.translatable("block.epimorphism.intake_hatch.desc.0"),
                            Component.translatable(
                                    "gtceu.universal.tooltip.fluid_storage_capacity",
                                    IntakeHatchPartMachine.getTankCapacity(tier)),
                            Component.translatable(
                                    "epimorphism.universal.desc.intake_rate",
                                    IntakeHatchPartMachine.getIntakeAmount(tier)),
                            Component.translatable("gtceu.universal.enabled"),
                            Component.translatable("block.epimorphism.intake_hatch.desc.1"))
                    .register(),
            tiersBetween(IV, UHV));

    public static final MachineDefinition GRIND_BALL_HATCH = registrate()
            .machine("grind_ball_hatch", BallHatchPartMachine::new)
            .langValue("Grind Ball Hatch")
            .tier(IV)
            .rotationState(RotationState.ALL)
            .abilities(EPPartAbility.GRIND_BALL)
            .renderer(() -> BallHatchRenderer.INSTANCE)
            .tooltips(
                    Component.translatable("block.epimorphism.grind_ball_hatch.desc.0"),
                    Component.translatable("block.epimorphism.grind_ball_hatch.desc.1"),
                    Component.translatable("block.epimorphism.grind_ball_hatch.desc.2"))
            .register();

    public static final MachineDefinition CATALYST_HATCH = registrate()
            .machine("catalyst_hatch", CatalystHatchPartMachine::new)
            .langValue("Catalyst Hatch")
            .tier(IV)
            .rotationState(RotationState.ALL)
            .abilities(EPPartAbility.CATALYST)
            .overlayTieredHullRenderer("catalyst_hatch")
            .tooltips()
            .register();

    public static final MachineDefinition NEUTRON_SENSOR = registrate()
            .machine("neutron_sensor", NeutronSensorPartMachine::new)
            .langValue("Neutron Sensor")
            .tier(IV)
            .rotationState(RotationState.ALL)
            .abilities(EPPartAbility.NEUTRON_SENSOR)
            .overlayTieredHullRenderer("neutron_sensor")
            .tooltips(Component.translatable("block.epimorphism.neutron_sensor.desc"))
            .register();

    public static final MachineDefinition[] NEUTRON_ACCELERATOR = registerTieredEPMachines(
            "neutron_accelerator",
            NeutronAcceleratorPartMachine::new,
            (tier, builder) -> builder
                    .langValue("%s §rNeutron Accelerator".formatted(VNF[tier]))
                    .rotationState(RotationState.ALL)
                    .abilities(EPPartAbility.NEUTRON_ACCELERATOR)
                    .overlayTieredHullRenderer("neutron_accelerator")
                    .tooltips(
                            Component.translatable("block.epimorphism.neutron_accelerator.desc.0"),
                            Component.translatable("block.epimorphism.neutron_accelerator.desc.1"),
                            Component.translatable("gtceu.universal.tooltip.max_voltage_in", V[tier], VNF[tier]),
                            Component.translatable(
                                    "epimorphism.universal.desc.max_power_consume", Math.round(V[tier] * 0.8)),
                            Component.translatable(
                                    "gtceu.universal.tooltip.energy_storage_capacity", V[tier] * 72))
                    .register(),
            ELECTRIC_TIERS);
    public static final MachineDefinition[] RADIATION_HATCH = registerTieredEPMachines(
            "radiation_hatch",
            RadiationHatchPartMachine::new,
            (tier, builder) -> builder
                    .langValue("%s §rRadiation Hatch".formatted(VNF[tier]))
                    .rotationState(RotationState.ALL)
                    .abilities(EPPartAbility.RADIATION)
                    .recipeType(EPRecipeTypes.RADIATION_HATCH_LIST)
                    .overlayTieredHullRenderer("radiation_hatch")
                    .tooltips(
                            Component.translatable("block.epimorphism.radiation_hatch.desc.0"),
                            Component.translatable(
                                    "epimorphism.universal.desc.kg_capacity", Math.max(1, tier - 2)),
                            Component.translatable("block.epimorphism.radiation_hatch.desc.1"))
                    .register(),
            tiersBetween(3, 13));

    public static final MachineDefinition[] REINFORCED_ROTOR_HOLDER = registerTieredEPMachines(
            "reinforced_rotor_holder",
            ReinforcedRotorHolderPartMachine::new,
            (tier, builder) -> builder
                    .langValue("%s Reinforced Rotor Holder".formatted(VNF[tier]))
                    .rotationState(RotationState.ALL)
                    .abilities(EPPartAbility.REINFORCED_ROTOR_HOLDER)
                    .renderer(() -> new RotorHolderMachineRenderer(tier))
                    .tooltips(
                            LangHandler.getFromMultiLang("gtceu.machine.muffler_hatch.tooltip", 0),
                            LangHandler.getFromMultiLang("gtceu.machine.muffler_hatch.tooltip", 1),
                            Component.translatable("gtceu.universal.disabled"))
                    .register(),
            tiersBetween(IV, UEV));

    //////////////////////////////////////
    // *******     Multiblock     *******//
    //////////////////////////////////////

    // Steam
    public static final MultiblockMachineDefinition STEAM_PISTON_HAMMER = registrate()
            .multiblock("steam_piston_hammer", SteamParallelMultiblockMachine::new)
            .langValue("Steam Piston Hammer")
            .tooltips(
                    Component.translatable("block.epimorphism.steam_piston_hammer.desc.0"),
                    Component.translatable("block.epimorphism.steam_piston_hammer.desc.1"),
                    Component.translatable("block.epimorphism.steam_piston_hammer.desc.2"),
                    Component.translatable("block.epimorphism.steam_piston_hammer.desc.3"))
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeTypes(FORGE_HAMMER_RECIPES, EPRecipeTypes.ORE_MILLING_RECIPES)
            .recipeModifier(SteamParallelMultiblockMachine::recipeModifier, true)
            .appearanceBlock(CASING_BRONZE_BRICKS)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("AAA", " E ", "   ", "   ", "   ")
                    .aisle("ABA", "E#E", "EBE", "ECE", "EDE")
                    .aisle("AAA", " S ", "   ", "   ", "   ")
                    .where('S', controller(blocks(definition.get())))
                    .where(
                            'A',
                            blocks(CASING_BRONZE_BRICKS.get())
                                    .setMinGlobalLimited(5)
                                    .or(abilities(PartAbility.STEAM_IMPORT_ITEMS))
                                    .or(abilities(PartAbility.STEAM_EXPORT_ITEMS))
                                    .or(abilities(PartAbility.STEAM)))
                    .where('B', blocks(ChemicalHelper.getBlock(block, Steel)))
                    .where(
                            'C',
                            states(Blocks.STICKY_PISTON
                                    .defaultBlockState()
                                    .setValue(DirectionalBlock.FACING, Direction.DOWN)))
                    .where('D', abilities(PartAbility.STEAM))
                    .where('E', blocks(CASING_BRONZE_BRICKS.get()))
                    .where('#', air())
                    .where(' ', any())
                    .build())
            .shapeInfo(definition -> MultiblockShapeInfo.builder()
                    .aisle("IAO", " S ", "   ", "   ", "   ")
                    .aisle("ABA", "E E", "EBE", "ECE", "EDE")
                    .aisle("AAA", " E ", "   ", "   ", "   ")
                    .where('S', definition, Direction.NORTH)
                    .where('A', CASING_BRONZE_BRICKS.get())
                    .where('E', CASING_BRONZE_BRICKS.get())
                    .where('I', ITEM_IMPORT_BUS[ULV], Direction.NORTH)
                    .where('O', ITEM_EXPORT_BUS[ULV], Direction.NORTH)
                    .where('D', STEAM_HATCH, Direction.NORTH)
                    .where('B', ChemicalHelper.getBlock(block, Steel))
                    .where(
                            'C',
                            Blocks.STICKY_PISTON
                                    .defaultBlockState()
                                    .setValue(DirectionalBlock.FACING, Direction.DOWN))
                    .where(' ', Blocks.AIR.defaultBlockState())
                    .build())
            .workableCasingRenderer(
                    GTCEu.id("block/casings/solid/machine_casing_bronze_plated_bricks"),
                    GTCEu.id("block/machines/forge_hammer"),
                    false)
            .register();

    public static final MachineDefinition STEAM_PRESSOR = registrate()
            .multiblock("steam_pressor", SteamParallelMultiblockMachine::new)
            .tooltips(
                    Component.translatable("block.epimorphism.steam_pressor.desc.0"),
                    Component.translatable("block.epimorphism.steam_pressor.desc.1"),
                    Component.translatable("block.epimorphism.steam_pressor.desc.2"),
                    Component.translatable("block.epimorphism.steam_pressor.desc.3"))
            .rotationState(RotationState.NON_Y_AXIS)
            .appearanceBlock(CASING_BRONZE_BRICKS)
            .recipeType(COMPRESSOR_RECIPES)
            .recipeModifier(SteamParallelMultiblockMachine::recipeModifier, true)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("XXX", "XXX", "XXX")
                    .aisle("XXX", "X#X", "XXX")
                    .aisle("XXX", "X#X", "XXX")
                    .aisle("XXX", "XSX", "XXX")
                    .where('S', Predicates.controller(blocks(definition.getBlock())))
                    .where(
                            'X',
                            blocks(CASING_BRONZE_BRICKS.get())
                                    .setMinGlobalLimited(6)
                                    .or(Predicates.abilities(PartAbility.STEAM_IMPORT_ITEMS).setPreviewCount(1))
                                    .or(Predicates.abilities(PartAbility.STEAM).setExactLimit(1))
                                    .or(Predicates.abilities(PartAbility.STEAM_EXPORT_ITEMS).setPreviewCount(1)))
                    .where('#', Predicates.air())
                    .where(' ', Predicates.any())
                    .build())
            .workableCasingRenderer(
                    GTCEu.id("block/casings/solid/machine_casing_bronze_plated_bricks"),
                    Epimorphism.id("block/multiblock/steam_compressor"),
                    false)
            .register();

    public static final MachineDefinition STEAM_FOUNDRY = registrate()
            .multiblock("steam_foundry", SteamParallelMultiblockMachine::new)
            .tooltips(
                    Component.translatable("block.epimorphism.steam_foundry.desc.0"),
                    Component.translatable("block.epimorphism.steam_foundry.desc.1"),
                    Component.translatable("block.epimorphism.steam_foundry.desc.2"),
                    Component.translatable("block.epimorphism.steam_foundry.desc.3"))
            .rotationState(RotationState.NON_Y_AXIS)
            .appearanceBlock(CASING_BRONZE_BRICKS)
            .recipeType(ALLOY_SMELTER_RECIPES)
            .recipeModifier(SteamParallelMultiblockMachine::recipeModifier, true)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("FFF", "XXX", "XXX")
                    .aisle("FFF", "X#X", "XXX")
                    .aisle("FFF", "XSX", "XXX")
                    .where('S', Predicates.controller(blocks(definition.getBlock())))
                    .where(
                            'F',
                            blocks(FIREBOX_BRONZE.get())
                                    .or(Predicates.abilities(PartAbility.STEAM).setExactLimit(1)))
                    .where('#', Predicates.air())
                    .where(' ', Predicates.any())
                    .where(
                            'X',
                            blocks(CASING_BRONZE_BRICKS.get())
                                    .setMinGlobalLimited(6)
                                    .or(Predicates.abilities(PartAbility.STEAM_IMPORT_ITEMS).setPreviewCount(1))
                                    .or(Predicates.abilities(PartAbility.STEAM_EXPORT_ITEMS).setPreviewCount(1)))
                    .build())
            .renderer(() -> new LargeBoilerRenderer(
                    GTCEu.id("block/casings/solid/machine_casing_bronze_plated_bricks"),
                    BoilerFireboxType.BRONZE_FIREBOX,
                    GTCEu.id("block/machines/alloy_smelter")))
            .register();

    // No Energy
    public static final MultiblockMachineDefinition NEUTRON_ACTIVATOR = registrate()
            .multiblock("neutron_activator", NeutronActivatorMachine::new)
            .langValue("Neutron Activator")
            .tooltips(
                    Component.translatable("block.epimorphism.neutron_activator.desc.0"),
                    Component.translatable("block.epimorphism.neutron_activator.desc.1"),
                    Component.translatable("block.epimorphism.neutron_activator.desc.2"),
                    Component.translatable("block.epimorphism.neutron_activator.desc.3"),
                    Component.translatable("block.epimorphism.neutron_activator.desc.4"))
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(EPRecipeTypes.NEUTRON_ACTIVATOR_RECIPES)
            .appearanceBlock(CASING_STAINLESS_CLEAN)
            .pattern(definition -> FactoryBlockPattern.start(
                            RelativeDirection.RIGHT, RelativeDirection.BACK, RelativeDirection.UP)
                    .aisle("AAGAA", "ADDDA", "ADDDA", "ADDDA", "AAAAA")
                    .aisle("B   B", " EEE ", " EFE ", " EEE ", "B   B")
                    .setRepeatable(4, 40)
                    .aisle("CCCCC", "CDDDC", "CDDDC", "CDDDC", "CCCCC")
                    .where('G', controller(blocks(definition.getBlock())))
                    .where(
                            'A',
                            blocks(CASING_STAINLESS_CLEAN.get())
                                    .or(abilities(PartAbility.EXPORT_FLUIDS))
                                    .or(abilities(PartAbility.EXPORT_ITEMS))
                                    .or(abilities(EPPartAbility.NEUTRON_SENSOR))
                                    .or(abilities(EPPartAbility.NEUTRON_ACCELERATOR)
                                            .setMinGlobalLimited(1)
                                            .setPreviewCount(1))
                                    .or(abilities(PartAbility.MAINTENANCE).setExactLimit(1).setPreviewCount(1)))
                    .where('B', frames(GTMaterials.Steel))
                    .where(
                            'C',
                            blocks(CASING_STAINLESS_CLEAN.get())
                                    .or(abilities(PartAbility.IMPORT_FLUIDS))
                                    .or(abilities(PartAbility.IMPORT_ITEMS)))
                    .where('D', Predicates.blocks(EPBlocks.PROCESS_MACHINE_CASING.get()))
                    .where('E', blocks(CASING_LAMINATED_GLASS.get()))
                    .where('F', MOPredicates.countBlock("SpeedPipe", EPBlocks.SPEEDING_PIPE.get()))
                    .build())
            .partSorter(Comparator.comparingInt(a -> a.self().getPos().getY()))
            .workableCasingRenderer(
                    GTCEu.id("block/casings/solid/machine_casing_clean_stainless_steel"),
                    Epimorphism.id("block/multiblock/neutron_activator"),
                    false)
            .register();

    // Physics
    public static final MultiblockMachineDefinition[] EP_FUSION_REACTOR = registerTieredEPMultis(
            "fusion_reactor",
            FusionReactorMachine::new,
            (tier, builder) -> builder
                    .rotationState(RotationState.NON_Y_AXIS)
                    .langValue("Fusion Reactor Computer MK %s".formatted(toRomanNumeral(tier - 5)))
                    .recipeType(FUSION_RECIPES)
                    .recipeModifier(FusionReactorMachine::recipeModifier)
                    .tooltips(
                            Component.translatable(
                                    "gtceu.machine.fusion_reactor.capacity",
                                    FusionReactorMachine.calculateEnergyStorageFactor(tier, 16) / 1000000L),
                            Component.translatable("gtceu.machine.fusion_reactor.overclocking"),
                            Component.translatable("gtceu.multiblock.fusion_reactor.%s.description"
                                    .formatted(VN[tier].toLowerCase(Locale.ROOT))))
                    .appearanceBlock(() -> EPFusionCasingBlock.getCasingState(tier))
                    .pattern((definition) -> {
                        var casing = blocks(EPFusionCasingBlock.getCasingState(tier));
                        return FactoryBlockPattern.start()
                                .aisle("###############", "######OGO######", "###############")
                                .aisle("######ICI######", "####GGAAAGG####", "######ICI######")
                                .aisle("####CC###CC####", "###EAAOGOAAE###", "####CC###CC####")
                                .aisle("###C#######C###", "##EKEG###GEKE##", "###C#######C###")
                                .aisle("##C#########C##", "#GAE#######EAG#", "##C#########C##")
                                .aisle("##C#########C##", "#GAG#######GAG#", "##C#########C##")
                                .aisle("#I###########I#", "OAO#########OAO", "#I###########I#")
                                .aisle("#C###########C#", "GAG#########GAG", "#C###########C#")
                                .aisle("#I###########I#", "OAO#########OAO", "#I###########I#")
                                .aisle("##C#########C##", "#GAG#######GAG#", "##C#########C##")
                                .aisle("##C#########C##", "#GAE#######EAG#", "##C#########C##")
                                .aisle("###C#######C###", "##EKEG###GEKE##", "###C#######C###")
                                .aisle("####CC###CC####", "###EAAOGOAAE###", "####CC###CC####")
                                .aisle("######ICI######", "####GGAAAGG####", "######ICI######")
                                .aisle("###############", "######OSO######", "###############")
                                .where('S', controller(blocks(definition.get())))
                                .where('G', blocks(FUSION_GLASS.get()).or(casing))
                                .where(
                                        'E',
                                        casing.or(blocks(
                                                        PartAbility.INPUT_ENERGY.getBlockRange(tier, UEV).toArray(Block[]::new))
                                                .setMinGlobalLimited(1)
                                                .setPreviewCount(16)))
                                .where('C', casing)
                                .where('K', blocks(FusionReactorMachine.getCoilState(tier)))
                                .where('O', casing.or(abilities(PartAbility.EXPORT_FLUIDS)))
                                .where('A', air())
                                .where('I', casing.or(abilities(PartAbility.IMPORT_FLUIDS).setMinGlobalLimited(2)))
                                .where('#', any())
                                .build();
                    })
                    .shapeInfos((controller) -> {
                        List<MultiblockShapeInfo> shapeInfos = new ArrayList<>();

                        MultiblockShapeInfo.ShapeInfoBuilder baseBuilder = MultiblockShapeInfo.builder()
                                .aisle("###############", "######WGW######", "###############")
                                .aisle("######DCD######", "####GG###GG####", "######UCU######")
                                .aisle("####CC###CC####", "###w##EGE##s###", "####CC###CC####")
                                .aisle("###C#######C###", "##nKeG###GeKn##", "###C#######C###")
                                .aisle("##C#########C##", "#G#s#######w#G#", "##C#########C##")
                                .aisle("##C#########C##", "#G#G#######G#G#", "##C#########C##")
                                .aisle("#D###########D#", "N#S#########N#S", "#U###########U#")
                                .aisle("#C###########C#", "G#G#########G#G", "#C###########C#")
                                .aisle("#D###########D#", "N#S#########N#S", "#U###########U#")
                                .aisle("##C#########C##", "#G#G#######G#G#", "##C#########C##")
                                .aisle("##C#########C##", "#G#s#######w#G#", "##C#########C##")
                                .aisle("###C#######C###", "##eKnG###GnKe##", "###C#######C###")
                                .aisle("####CC###CC####", "###w##WGW##s###", "####CC###CC####")
                                .aisle("######DCD######", "####GG###GG####", "######UCU######")
                                .aisle("###############", "######EME######", "###############")
                                .where('M', controller, Direction.SOUTH)
                                .where('C', EPFusionCasingBlock.getCasingState(tier))
                                .where('G', FUSION_GLASS.get())
                                .where('K', FusionReactorMachine.getCoilState(tier))
                                .where('W', GTMachines.FLUID_EXPORT_HATCH[tier], Direction.NORTH)
                                .where('E', GTMachines.FLUID_EXPORT_HATCH[tier], Direction.SOUTH)
                                .where('S', GTMachines.FLUID_EXPORT_HATCH[tier], Direction.EAST)
                                .where('N', GTMachines.FLUID_EXPORT_HATCH[tier], Direction.WEST)
                                .where('w', GTMachines.ENERGY_INPUT_HATCH[tier], Direction.WEST)
                                .where('e', GTMachines.ENERGY_INPUT_HATCH[tier], Direction.SOUTH)
                                .where('s', GTMachines.ENERGY_INPUT_HATCH[tier], Direction.EAST)
                                .where('n', GTMachines.ENERGY_INPUT_HATCH[tier], Direction.NORTH)
                                .where('U', GTMachines.FLUID_IMPORT_HATCH[tier], Direction.UP)
                                .where('D', GTMachines.FLUID_IMPORT_HATCH[tier], Direction.DOWN)
                                .where('#', Blocks.AIR.defaultBlockState());

                        shapeInfos.add(baseBuilder
                                .shallowCopy()
                                .where('G', EPFusionCasingBlock.getCasingState(tier))
                                .build());
                        shapeInfos.add(baseBuilder.build());
                        return shapeInfos;
                    })
                    .workableCasingRenderer(
                            EPFusionCasingBlock.getCasingType(tier).getTexture(),
                            GTCEu.id("block/multiblock/fusion_reactor"),
                            false)
                    .register(),
            UHV,
            UEV);

    public static final MultiblockMachineDefinition DIMENSIONALLY_TRANSCENDENT_PLASMA_FORGE =
            registrate()
                    .multiblock(
                            "dimensionally_transcendent_plasma_forge",
                            holder -> new DTPFMachine(holder, m -> 4096))
                    .langValue("Dimensionally Transcendent Plasma Forge")
                    .tooltips(
                            Component.translatable("gtceu.machine.electric_blast_furnace.tooltip.1"),
                            Component.translatable("gtceu.machine.electric_blast_furnace.tooltip.2"))
                    .rotationState(RotationState.NON_Y_AXIS)
                    .recipeType(BLAST_RECIPES)
                    .recipeModifiers(EPRecipeModifiers.EP_PARALLEL, AdvancedEBFMachine::advEBFOverclock)
                    .appearanceBlock(EPBlocks.ADVANCED_INVAR_CASING)
                    .pattern(definition -> FactoryMOPattern.start()
                            .aisle(
                                    " NNN   NNN             NNN   NNN ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    " NNN   NNN             NNN   NNN ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    " NNN   NNN             NNN   NNN ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    " NNN   NNN   N     N   NNN   NNN ",
                                    "         N   N     N   N         ",
                                    "         N   N     N   N         ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "         N   N     N   N         ",
                                    "         N   N     N   N         ",
                                    "         N   N     N   N         ",
                                    "                                 ")
                            .aisle(
                                    "NbbbN NbbbN    N N    NbbbN NbbbN",
                                    " CCC   CCC             CCC   CCC ",
                                    " CCC   CCC             CCC   CCC ",
                                    " CCC   CCC             CCC   CCC ",
                                    "NbbbN NbbbN           NbbbN NbbbN",
                                    "  N     N               N     N  ",
                                    "  N     N               N     N  ",
                                    "                                 ",
                                    "  N     N               N     N  ",
                                    "  N     N               N     N  ",
                                    "NbbbN NbbbN           NbbbN NbbbN",
                                    " CCC   CCC             CCC   CCC ",
                                    " CCC   CCC             CCC   CCC ",
                                    " CCC   CCC   N     N   CCC   CCC ",
                                    "NbbbN NbbNCCCb     bCCCNbbN NbbbN",
                                    "         bCCCb     bCCCb         ",
                                    "         bCCCb     bCCCb         ",
                                    "         N   N     N   N         ",
                                    "                                 ",
                                    "         N   N     N   N         ",
                                    "         bCCCb     bCCCb         ",
                                    "         bCCCb     bCCCb         ",
                                    "         bCCCb     bCCCb         ",
                                    "         N   N     N   N         ")
                            .aisle(
                                    "NbbbN NbbbNNNNNsNsNNNNNbbbN NbbbN",
                                    " CbC   CbC             CbC   CbC ",
                                    " CbC   CbC             CbC   CbC ",
                                    " CbC   CbC             CbC   CbC ",
                                    "NbbbN NbbbN           NbbbN NbbbN",
                                    " NNN   NNN             NNN   NNN ",
                                    " NNN   NNN             NNN   NNN ",
                                    "  s     s               s     s  ",
                                    " NNN   NNN             NNN   NNN ",
                                    " NNN   NNN             NNN   NNN ",
                                    "NbbbN NbbbN           NbbbN NbbbN",
                                    " CbC   CbC             CbC   CbC ",
                                    " CbC   CbC             CbC   CbC ",
                                    " CbC   CbC   N     N   CbC   CbC ",
                                    "NbbbN NbbNCCCb     bCCCNbbN NbbbN",
                                    "  N     sbbbbbNNsNNbbbbbs     N  ",
                                    "  N      bCCCb     bCCCb      N  ",
                                    "  N      N   N     N   N      N  ",
                                    "   s                         s   ",
                                    "   s     N   N     N   N     s   ",
                                    "    ss   bCCCb     bCCCb   ss    ",
                                    "      NNNbbbbbNNsNNbbbbbNNN      ",
                                    "         bCCCb     bCCCb         ",
                                    "         N   N     N   N         ")
                            .aisle(
                                    "NbbbNNNbbbN    NbN    NbbbNNNbbbN",
                                    " CCCCCCCCC             CCCCCCCCC ",
                                    " CCCCCCCCC             CCCCCCCCC ",
                                    " CCCCCCCCC             CCCCCCCCC ",
                                    "NbbbNNNbbbN           NbbbNNNbbbN",
                                    "  N     N               N     N  ",
                                    "  N     N               N     N  ",
                                    "                                 ",
                                    "  N     N               N     N  ",
                                    "  N     N               N     N  ",
                                    "NbbbNNNbbbN           NbbbNNNbbbN",
                                    " CCCCCCCCC             CCCCCCCCC ",
                                    " CCCCCCCCC             CCCCCCCCC ",
                                    " CCCCCCCCC   N     N   CCCCCCCCC ",
                                    "NbbbNNNbbNCCCb     bCCCNbbNNNbbbN",
                                    "         bCCCb     bCCCb         ",
                                    "         bCCCb     bCCCb         ",
                                    "         NCCCN     NCCCN         ",
                                    "  s      NCCCN     NCCCN      s  ",
                                    "  s      NCCCN     NCCCN      s  ",
                                    "         bCCCb     bCCCb         ",
                                    "    ss   bCCCb     bCCCb   ss    ",
                                    "         bCCCb     bCCCb         ",
                                    "         N   N     N   N         ")
                            .aisle(
                                    " NNN   NNN     NbN     NNN   NNN ",
                                    "   C   C                 C   C   ",
                                    "   C   C                 C   C   ",
                                    "   C   C                 C   C   ",
                                    " NNN   NNN             NNN   NNN ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    " NNN   NNN             NNN   NNN ",
                                    "   C   C                 C   C   ",
                                    "   C   C                 C   C   ",
                                    "   C   C                 C   C   ",
                                    " NNN   NN    N     N    NN   NNN ",
                                    "         N   N     N   N         ",
                                    "         NCCCN     NCCCN         ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "  s      NCCCN     NCCCN      s  ",
                                    "   s     N   N     N   N     s   ",
                                    "         N   N     N   N         ",
                                    "                                 ")
                            .aisle(
                                    "   N   N       NbN       N   N   ",
                                    "   C   C                 C   C   ",
                                    "   C   C                 C   C   ",
                                    "   C   C                 C   C   ",
                                    "   N   N                 N   N   ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "   N   N                 N   N   ",
                                    "   C   C                 C   C   ",
                                    "   C   C                 C   C   ",
                                    "   C   C                 C   C   ",
                                    "   N   N                 N   N   ",
                                    "                                 ",
                                    "         NCCCN     NCCCN         ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "  s      NCCCN     NCCCN      s  ",
                                    "   s                         s   ",
                                    "                                 ",
                                    "                                 ")
                            .aisle(
                                    " NNN   NNN     NbN     NNN   NNN ",
                                    "   C   C                 C   C   ",
                                    "   C   C                 C   C   ",
                                    "   C   C                 C   C   ",
                                    " NNN   NNN             NNN   NNN ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    " NNN   NNN             NNN   NNN ",
                                    "   C   C                 C   C   ",
                                    "   C   C                 C   C   ",
                                    "   C   C                 C   C   ",
                                    " NNN   NN    N     N    NN   NNN ",
                                    "         N   N     N   N         ",
                                    "         NCCCN     NCCCN         ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "         NCCCN     NCCCN         ",
                                    "  N      N   N     N   N      N  ",
                                    "         N   N     N   N         ",
                                    "                                 ")
                            .aisle(
                                    "NbbbNNNbbbN    NbN    NbbbNNNbbbN",
                                    " CCCCCCCCC             CCCCCCCCC ",
                                    " CCCCCCCCC             CCCCCCCCC ",
                                    " CCCCCCCCC             CCCCCCCCC ",
                                    "NbbbNNNbbbN           NbbbNNNbbbN",
                                    "  N     N               N     N  ",
                                    "  N     N               N     N  ",
                                    "                                 ",
                                    "  N     N               N     N  ",
                                    "  N     N               N     N  ",
                                    "NbbbNNNbbbN           NbbbNNNbbbN",
                                    " CCCCCCCCC             CCCCCCCCC ",
                                    " CCCCCCCCC             CCCCCCCCC ",
                                    " CCCCCCCCC   N     N   CCCCCCCCC ",
                                    "NbbbNNNbbNCCCb     bCCCNbbNNNbbbN",
                                    "         bCCCb     bCCCb         ",
                                    "         bCCCb     bCCCb         ",
                                    "         NCCCN     NCCCN         ",
                                    "         NCCCN     NCCCN         ",
                                    "         NCCCN     NCCCN         ",
                                    "         bCCCb     bCCCb         ",
                                    "  N      bCCCb     bCCCb      N  ",
                                    "         bCCCb     bCCCb         ",
                                    "         N   N     N   N         ")
                            .aisle(
                                    "NbbbN NbbbNNNNNsNsNNNNNbbbN NbbbN",
                                    " CbC   CbC             CbC   CbC ",
                                    " CbC   CbC             CbC   CbC ",
                                    " CbC   CbC             CbC   CbC ",
                                    "NbbbN NbbbN           NbbbN NbbbN",
                                    " NNN   NNN             NNN   NNN ",
                                    " NNN   NNN             NNN   NNN ",
                                    "  s     s               s     s  ",
                                    " NNN   NNN             NNN   NNN ",
                                    " NNN   NNN             NNN   NNN ",
                                    "NbbbN NbbbN           NbbbN NbbbN",
                                    " CbC   CbC             CbC   CbC ",
                                    " CbC   CbC             CbC   CbC ",
                                    " CbC   CbC   N     N   CbC   CbC ",
                                    "NbbbN NbbNCCCb     bCCCNbbN NbbbN",
                                    "  s     sbbbbbNNsNNbbbbbs     s  ",
                                    "         bCCCb     bCCCb         ",
                                    "         N   N     N   N         ",
                                    "                                 ",
                                    "         N   N     N   N         ",
                                    "         bCCCb     bCCCb         ",
                                    "  N     sbbbbbNNsNNbbbbbs     N  ",
                                    "         bCCCb     bCCCb         ",
                                    "         N   N     N   N         ")
                            .aisle(
                                    "NbbbN NbbbN    NbN    NbbbN NbbbN",
                                    " CCC   CCC             CCC   CCC ",
                                    " CCC   CCC             CCC   CCC ",
                                    " CCC   CCC             CCC   CCC ",
                                    "NbbbN NbbbN           NbbbN NbbbN",
                                    "  N     N               N     N  ",
                                    "  N     N               N     N  ",
                                    "                                 ",
                                    "  N     N               N     N  ",
                                    "  N     N               N     N  ",
                                    "NbbbN NbbbN           NbbbN NbbbN",
                                    " CCC   CCC             CCC   CCC ",
                                    " CCC   CCC             CCC   CCC ",
                                    " CCC   CCC   N     N   CCC   CCC ",
                                    "NNNN   NNNCCCb     bCCCNNN   NNNN",
                                    "NbbbN NbbNCCCb     bCCCNbbN NbbbN",
                                    "NbbbNNNbbNCCCb     bCCCNbbNNNbbbN",
                                    " NNN   NNN   N     N   NNN   NNN ",
                                    "   N   N                 N   N   ",
                                    " NNN   NNN   N     N   NNN   NNN ",
                                    "NbbbNNNbbNCCCb     bCCCNbbNNNbbbN",
                                    "NbbbN NbbNCCCb     bCCCNbbN NbbbN",
                                    "NbbbN NbbNCCCb     bCCCNbbN NbbbN",
                                    " NNN   NNN   N     N   NNN   NNN ")
                            .aisle(
                                    " NNN   NNN     NbN     NNN   NNN ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    " NNN   NNN             NNN   NNN ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    " NNN   NNN             NNN   NNN ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    " CCC   CCC   N     N   CCC   CCC ",
                                    " CbC   CbC   N     N   CbC   CbC ",
                                    " CCCCCCCCC   N     N   CCCCCCCCC ",
                                    "   C   C                 C   C   ",
                                    "   C   C                 C   C   ",
                                    "   C   C                 C   C   ",
                                    " CCCCCCCCC   N     N   CCCCCCCCC ",
                                    " CbC   CbC   N     N   CbC   CbC ",
                                    " CCC   CCC   N     N   CCC   CCC ",
                                    "                                 ")
                            .aisle(
                                    "  N     N      NbN      N     N  ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    " CCC   CCC             CCC   CCC ",
                                    " CbC   CbC             CbC   CbC ",
                                    " CCCCCCCCC             CCCCCCCCC ",
                                    "   C   C                 C   C   ",
                                    "   C   C                 C   C   ",
                                    "   C   C                 C   C   ",
                                    " CCCCCCCCC             CCCCCCCCC ",
                                    " CbC   CbC             CbC   CbC ",
                                    " CCC   CCC             CCC   CCC ",
                                    "                                 ")
                            .aisle(
                                    "  N     N      NbN      N     N  ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    " CCC   CCC             CCC   CCC ",
                                    " CbC   CbC             CbC   CbC ",
                                    " CCCCCCCCC             CCCCCCCCC ",
                                    "   C   C                 C   C   ",
                                    "   C   C                 C   C   ",
                                    "   C   C                 C   C   ",
                                    " CCCCCCCCC             CCCCCCCCC ",
                                    " CbC   CbC             CbC   CbC ",
                                    " CCC   CCC             CCC   CCC ",
                                    "                                 ")
                            .aisle(
                                    "  N     N     NsNsN     N     N  ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    " NNN   NNN             NNN   NNN ",
                                    "NbbbN NbbbN           NbbbN NbbbN",
                                    "NbbbN NbbbN           NbbbN NbbbN",
                                    "NbbbNNNbbbN           NbbbNNNbbbN",
                                    " NNN   NNN             NNN   NNN ",
                                    "   N   N                 N   N   ",
                                    " NNN   NNN             NNN   NNN ",
                                    "NbbbNNNbbbN           NbbbNNNbbbN",
                                    "NbbbN NbbbN           NbbbN NbbbN",
                                    "NbbbN NbbbN           NbbbN NbbbN",
                                    " NNN   NNN             NNN   NNN ")
                            .aisle(
                                    "  N     N    NbbbbbN    N     N  ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "  N     N               N     N  ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "  N     N               N     N  ",
                                    "                                 ",
                                    "                                 ")
                            .aisle(
                                    " NsNNNNNsNNNNsbbbbbsNNNNsNNNNNsN ",
                                    "                N                ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "  N     N               N     N  ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "  N     N               N     N  ",
                                    "                                 ",
                                    "                                 ")
                            .aisle(
                                    "  NbbbbbNbbbbNbbbbbNbbbbNbbbbbN  ",
                                    "               NNN               ",
                                    "                ~                ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "  s     s               s     s  ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "  s     s               s     s  ",
                                    "                                 ",
                                    "                                 ")
                            .aisle(
                                    " NsNNNNNsNNNNsbbbbbsNNNNsNNNNNsN ",
                                    "                N                ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "  N     N               N     N  ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "  N     N               N     N  ",
                                    "                                 ",
                                    "                                 ")
                            .aisle(
                                    "  N     N    NbbbbbN    N     N  ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "  N     N               N     N  ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "  N     N               N     N  ",
                                    "                                 ",
                                    "                                 ")
                            .aisle(
                                    "  N     N     NsNsN     N     N  ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    " NNN   NNN             NNN   NNN ",
                                    "NbbbN NbbbN           NbbbN NbbbN",
                                    "NbbbN NbbbN           NbbbN NbbbN",
                                    "NbbbNNNbbbN           NbbbNNNbbbN",
                                    " NNN   NNN             NNN   NNN ",
                                    "   N   N                 N   N   ",
                                    " NNN   NNN             NNN   NNN ",
                                    "NbbbNNNbbbN           NbbbNNNbbbN",
                                    "NbbbN NbbbN           NbbbN NbbbN",
                                    "NbbbN NbbbN           NbbbN NbbbN",
                                    " NNN   NNN             NNN   NNN ")
                            .aisle(
                                    "  N     N      NbN      N     N  ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    " CCC   CCC             CCC   CCC ",
                                    " CbC   CbC             CbC   CbC ",
                                    " CCCCCCCCC             CCCCCCCCC ",
                                    "   C   C                 C   C   ",
                                    "   C   C                 C   C   ",
                                    "   C   C                 C   C   ",
                                    " CCCCCCCCC             CCCCCCCCC ",
                                    " CbC   CbC             CbC   CbC ",
                                    " CCC   CCC             CCC   CCC ",
                                    "                                 ")
                            .aisle(
                                    "  N     N      NbN      N     N  ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    " CCC   CCC             CCC   CCC ",
                                    " CbC   CbC             CbC   CbC ",
                                    " CCCCCCCCC             CCCCCCCCC ",
                                    "   C   C                 C   C   ",
                                    "   C   C                 C   C   ",
                                    "   C   C                 C   C   ",
                                    " CCCCCCCCC             CCCCCCCCC ",
                                    " CbC   CbC             CbC   CbC ",
                                    " CCC   CCC             CCC   CCC ",
                                    "                                 ")
                            .aisle(
                                    " NNN   NNN     NbN     NNN   NNN ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    " NNN   NNN             NNN   NNN ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    " NNN   NNN             NNN   NNN ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    " CCC   CCC   N     N   CCC   CCC ",
                                    " CbC   CbC   N     N   CbC   CbC ",
                                    " CCCCCCCCC   N     N   CCCCCCCCC ",
                                    "   C   C                 C   C   ",
                                    "   C   C                 C   C   ",
                                    "   C   C                 C   C   ",
                                    " CCCCCCCCC   N     N   CCCCCCCCC ",
                                    " CbC   CbC   N     N   CbC   CbC ",
                                    " CCC   CCC   N     N   CCC   CCC ",
                                    "                                 ")
                            .aisle(
                                    "NbbbN NbbbN    NbN    NbbbN NbbbN",
                                    " CCC   CCC             CCC   CCC ",
                                    " CCC   CCC             CCC   CCC ",
                                    " CCC   CCC             CCC   CCC ",
                                    "NbbbN NbbbN           NbbbN NbbbN",
                                    "  N     N               N     N  ",
                                    "  N     N               N     N  ",
                                    "                                 ",
                                    "  N     N               N     N  ",
                                    "  N     N               N     N  ",
                                    "NbbbN NbbbN           NbbbN NbbbN",
                                    " CCC   CCC             CCC   CCC ",
                                    " CCC   CCC             CCC   CCC ",
                                    " CCC   CCC   N     N   CCC   CCC ",
                                    "NNNN   NNNCCCb     bCCCNNN   NNNN",
                                    "NbbbN NbbNCCCb     bCCCNbbN NbbbN",
                                    "NbbbNNNbbNCCCb     bCCCNbbNNNbbbN",
                                    " NNN   NNN   N     N   NNN   NNN ",
                                    "   N   N                 N   N   ",
                                    " NNN   NNN   N     N   NNN   NNN ",
                                    "NbbbNNNbbNCCCb     bCCCNbbNNNbbbN",
                                    "NbbbN NbbNCCCb     bCCCNbbN NbbbN",
                                    "NbbbN NbbNCCCb     bCCCNbbN NbbbN",
                                    " NNN   NNN   N     N   NNN   NNN ")
                            .aisle(
                                    "NbbbN NbbbNNNNNsNsNNNNNbbbN NbbbN",
                                    " CbC   CbC             CbC   CbC ",
                                    " CbC   CbC             CbC   CbC ",
                                    " CbC   CbC             CbC   CbC ",
                                    "NbbbN NbbbN           NbbbN NbbbN",
                                    " NNN   NNN             NNN   NNN ",
                                    " NNN   NNN             NNN   NNN ",
                                    "  s     s               s     s  ",
                                    " NNN   NNN             NNN   NNN ",
                                    " NNN   NNN             NNN   NNN ",
                                    "NbbbN NbbbN           NbbbN NbbbN",
                                    " CbC   CbC             CbC   CbC ",
                                    " CbC   CbC             CbC   CbC ",
                                    " CbC   CbC   N     N   CbC   CbC ",
                                    "NbbbN NbbNCCCb     bCCCNbbN NbbbN",
                                    "  s     sbbbbbNNsNNbbbbbs     s  ",
                                    "         bCCCb     bCCCb         ",
                                    "         N   N     N   N         ",
                                    "                                 ",
                                    "         N   N     N   N         ",
                                    "         bCCCb     bCCCb         ",
                                    "  N     sbbbbbNNsNNbbbbbs     N  ",
                                    "         bCCCb     bCCCb         ",
                                    "         N   N     N   N         ")
                            .aisle(
                                    "NbbbNNNbbbN    NbN    NbbbNNNbbbN",
                                    " CCCCCCCCC             CCCCCCCCC ",
                                    " CCCCCCCCC             CCCCCCCCC ",
                                    " CCCCCCCCC             CCCCCCCCC ",
                                    "NbbbNNNbbbN           NbbbNNNbbbN",
                                    "  N     N               N     N  ",
                                    "  N     N               N     N  ",
                                    "                                 ",
                                    "  N     N               N     N  ",
                                    "  N     N               N     N  ",
                                    "NbbbNNNbbbN           NbbbNNNbbbN",
                                    " CCCCCCCCC             CCCCCCCCC ",
                                    " CCCCCCCCC             CCCCCCCCC ",
                                    " CCCCCCCCC   N     N   CCCCCCCCC ",
                                    "NbbbNNNbbNCCCb     bCCCNbbNNNbbbN",
                                    "         bCCCb     bCCCb         ",
                                    "         bCCCb     bCCCb         ",
                                    "         NCCCN     NCCCN         ",
                                    "         NCCCN     NCCCN         ",
                                    "         NCCCN     NCCCN         ",
                                    "         bCCCb     bCCCb         ",
                                    "  N      bCCCb     bCCCb      N  ",
                                    "         bCCCb     bCCCb         ",
                                    "         N   N     N   N         ")
                            .aisle(
                                    " NNN   NNN     NbN     NNN   NNN ",
                                    "   C   C                 C   C   ",
                                    "   C   C                 C   C   ",
                                    "   C   C                 C   C   ",
                                    " NNN   NNN             NNN   NNN ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    " NNN   NNN             NNN   NNN ",
                                    "   C   C                 C   C   ",
                                    "   C   C                 C   C   ",
                                    "   C   C                 C   C   ",
                                    " NNN   NN    N     N    NN   NNN ",
                                    "         N   N     N   N         ",
                                    "         NCCCN     NCCCN         ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "         NCCCN     NCCCN         ",
                                    "  N      N   N     N   N      N  ",
                                    "         N   N     N   N         ",
                                    "                                 ")
                            .aisle(
                                    "   N   N       NbN       N   N   ",
                                    "   C   C                 C   C   ",
                                    "   C   C                 C   C   ",
                                    "   C   C                 C   C   ",
                                    "   N   N                 N   N   ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "   N   N                 N   N   ",
                                    "   C   C                 C   C   ",
                                    "   C   C                 C   C   ",
                                    "   C   C                 C   C   ",
                                    "   N   N                 N   N   ",
                                    "                                 ",
                                    "         NCCCN     NCCCN         ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "  s      NCCCN     NCCCN      s  ",
                                    "   s                         s   ",
                                    "                                 ",
                                    "                                 ")
                            .aisle(
                                    " NNN   NNN     NbN     NNN   NNN ",
                                    "   C   C                 C   C   ",
                                    "   C   C                 C   C   ",
                                    "   C   C                 C   C   ",
                                    " NNN   NNN             NNN   NNN ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    " NNN   NNN             NNN   NNN ",
                                    "   C   C                 C   C   ",
                                    "   C   C                 C   C   ",
                                    "   C   C                 C   C   ",
                                    " NNN   NN    N     N    NN   NNN ",
                                    "         N   N     N   N         ",
                                    "         NCCCN     NCCCN         ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "  s      NCCCN     NCCCN      s  ",
                                    "   s     N   N     N   N     s   ",
                                    "         N   N     N   N         ",
                                    "                                 ")
                            .aisle(
                                    "NbbbNNNbbbN    NbN    NbbbNNNbbbN",
                                    " CCCCCCCCC             CCCCCCCCC ",
                                    " CCCCCCCCC             CCCCCCCCC ",
                                    " CCCCCCCCC             CCCCCCCCC ",
                                    "NbbbNNNbbbN           NbbbNNNbbbN",
                                    "  N     N               N     N  ",
                                    "  N     N               N     N  ",
                                    "                                 ",
                                    "  N     N               N     N  ",
                                    "  N     N               N     N  ",
                                    "NbbbNNNbbbN           NbbbNNNbbbN",
                                    " CCCCCCCCC             CCCCCCCCC ",
                                    " CCCCCCCCC             CCCCCCCCC ",
                                    " CCCCCCCCC   N     N   CCCCCCCCC ",
                                    "NbbbNNNbbNCCCb     bCCCNbbNNNbbbN",
                                    "         bCCCb     bCCCb         ",
                                    "         bCCCb     bCCCb         ",
                                    "         NCCCN     NCCCN         ",
                                    "  s      NCCCN     NCCCN      s  ",
                                    "  s      NCCCN     NCCCN      s  ",
                                    "         bCCCb     bCCCb         ",
                                    "    ss   bCCCb     bCCCb   ss    ",
                                    "         bCCCb     bCCCb         ",
                                    "         N   N     N   N         ")
                            .aisle(
                                    "NbbbN NbbbNNNNNsNsNNNNNbbbN NbbbN",
                                    " CbC   CbC             CbC   CbC ",
                                    " CbC   CbC             CbC   CbC ",
                                    " CbC   CbC             CbC   CbC ",
                                    "NbbbN NbbbN           NbbbN NbbbN",
                                    " NNN   NNN             NNN   NNN ",
                                    " NNN   NNN             NNN   NNN ",
                                    "  s     s               s     s  ",
                                    " NNN   NNN             NNN   NNN ",
                                    " NNN   NNN             NNN   NNN ",
                                    "NbbbN NbbbN           NbbbN NbbbN",
                                    " CbC   CbC             CbC   CbC ",
                                    " CbC   CbC             CbC   CbC ",
                                    " CbC   CbC   N     N   CbC   CbC ",
                                    "NbbbN NbbNCCCb     bCCCNbbN NbbbN",
                                    "  N     sbbbbbNNsNNbbbbbs     N  ",
                                    "  N      bCCCb     bCCCb      N  ",
                                    "  N      N   N     N   N      N  ",
                                    "   s                         s   ",
                                    "   s     N   N     N   N     s   ",
                                    "    ss   bCCCb     bCCCb   ss    ",
                                    "      NNNbbbbbNNsNNbbbbbNNN      ",
                                    "         bCCCb     bCCCb         ",
                                    "         N   N     N   N         ")
                            .aisle(
                                    "NbbbN NbbbN    N N    NbbbN NbbbN",
                                    " CCC   CCC             CCC   CCC ",
                                    " CCC   CCC             CCC   CCC ",
                                    " CCC   CCC             CCC   CCC ",
                                    "NbbbN NbbbN           NbbbN NbbbN",
                                    "  N     N               N     N  ",
                                    "  N     N               N     N  ",
                                    "                                 ",
                                    "  N     N               N     N  ",
                                    "  N     N               N     N  ",
                                    "NbbbN NbbbN           NbbbN NbbbN",
                                    " CCC   CCC             CCC   CCC ",
                                    " CCC   CCC             CCC   CCC ",
                                    " CCC   CCC   N     N   CCC   CCC ",
                                    "NbbbN NbbNCCCb     bCCCNbbN NbbbN",
                                    "         bCCCb     bCCCb         ",
                                    "         bCCCb     bCCCb         ",
                                    "         N   N     N   N         ",
                                    "                                 ",
                                    "         N   N     N   N         ",
                                    "         bCCCb     bCCCb         ",
                                    "         bCCCb     bCCCb         ",
                                    "         bCCCb     bCCCb         ",
                                    "         N   N     N   N         ")
                            .aisle(
                                    " NNN   NNN             NNN   NNN ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    " NNN   NNN             NNN   NNN ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    " NNN   NNN             NNN   NNN ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    " NNN   NNN   N     N   NNN   NNN ",
                                    "         N   N     N   N         ",
                                    "         N   N     N   N         ",
                                    "                                 ",
                                    "                                 ",
                                    "                                 ",
                                    "         N   N     N   N         ",
                                    "         N   N     N   N         ",
                                    "         N   N     N   N         ",
                                    "                                 ")
                            .where('~', controller(blocks(definition.get())))
                            .where('C', coilBlock())
                            .where(
                                    'b',
                                    blocks(HIGH_POWER_CASING.get())
                                            .setMinGlobalLimited(1100)
                                            .or(abilities(MAINTENANCE).setExactLimit(1))
                                            .or(abilities(INPUT_ENERGY).setMaxGlobalLimited(3))
                                            .or(abilities(INPUT_LASER).setMaxGlobalLimited(1))
                                            .or(abilities(IMPORT_ITEMS).setMaxGlobalLimited(32).setPreviewCount(1))
                                            .or(abilities(EXPORT_ITEMS).setMaxGlobalLimited(32))
                                            .or(abilities(IMPORT_FLUIDS).setMaxGlobalLimited(32).setPreviewCount(1))
                                            .or(abilities(EXPORT_FLUIDS).setMaxGlobalLimited(32).setPreviewCount(1)))
                            .where('N', Predicates.blocks(EPBlocks.HYPERDIMENSIONAL_CASING.get()))
                            .where('s', Predicates.blocks(EPBlocks.DIMENSIONAL_BRIDGE_CASING.get()))
                            .where(' ', any())
                            .build())
                    .shapeInfos(definition -> new ArrayList<>(StructureUtil.getMatchingShapes(
                            (MOBlockPattern) definition.getPatternFactory().get(), ALL_COIL_BLOCKS.size())))
                    .recoveryItems(() -> new ItemLike[] {
                        GTItems.MATERIAL_ITEMS.get(TagPrefix.dustTiny, GTMaterials.Ash).get()
                    })
                    .renderer(() -> new CustomPartRenderer(
                            Epimorphism.id("block/casings/solid/dimensional_bridge_casing"),
                            Epimorphism.id("block/multiblock/dimensionally_transcendent_plasma_forge"),
                            DTPFMachine::getBaseTexture))
                    .additionalDisplay((controller, components) -> {
                        if (controller instanceof CoilWorkableElectricMultiblockMachine coilMachine
                                && controller.isFormed()) {
                            components.add(Component.translatable(
                                    "gtceu.multiblock.blast_furnace.max_temperature",
                                    Component.translatable(FormattingUtil.formatNumbers(
                                                            coilMachine.getCoilType().getCoilTemperature()
                                                                    + 100L * Math.max(0, coilMachine.getTier() - MV))
                                                    + "K")
                                            .setStyle(Style.EMPTY.withColor(ChatFormatting.RED))));
                        }
                    })
                    .register();

    // Chemistry
    public static final MultiblockMachineDefinition CHEMICAL_PLANT = registrate()
            .multiblock("chemical_plant", ChemicalPlantMachine::new)
            .langValue("Chemical Plant")
            .tooltips(Component.translatable("block.epimorphism.chemical_plant.desc.0"))
            .rotationState(RotationState.ALL)
            .recipeTypes(EPRecipeTypes.CHEMICAL_PLANT_RECIPES)
            .recipeModifiers(
                    EPRecipeModifiers.EP_PARALLEL,
                    GTRecipeModifiers.ELECTRIC_OVERCLOCK.apply(OverclockingLogic.NON_PERFECT_OVERCLOCK))
            .appearanceBlock(CASING_BRONZE_BRICKS)
            .pattern(definition -> FactoryMOPattern.start()
                    .aisle("EEEEEEE", "C#####C", "C#####C", "C#####C", "C#####C", "C#####C", "CCCCCCC")
                    .aisle("EMMMMME", "#MMMMM#", "#######", "#######", "#######", "#MMMMM#", "CCCCCCC")
                    .aisle("EMMMMME", "#MXXXM#", "##TTT##", "##XXX##", "##TTT##", "#MXXXM#", "CCCCCCC")
                    .aisle("EMMMMME", "#MXAXM#", "##TAT##", "##XAX##", "##TAT##", "#MXAXM#", "CCCCCCC")
                    .aisle("EMMMMME", "#MXXXM#", "##TTT##", "##XXX##", "##TTT##", "#MXXXM#", "CCCCCCC")
                    .aisle("EMMMMME", "#MMMMM#", "#######", "#######", "#######", "#MMMMM#", "CCCCCCC")
                    .aisle("EEESEEE", "C#####C", "C#####C", "C#####C", "C#####C", "C#####C", "CCCCCCC")
                    .where('S', controller(blocks(definition.getBlock())))
                    .where(
                            'E',
                            EPPredicates.CPCasingBlock()
                                    .or(abilities(PartAbility.MAINTENANCE).setExactLimit(1))
                                    .or(abilities(PartAbility.EXPORT_FLUIDS).setMinGlobalLimited(1))
                                    .or(abilities(PartAbility.EXPORT_ITEMS).setMinGlobalLimited(1))
                                    .or(abilities(PartAbility.IMPORT_ITEMS).setMinGlobalLimited(1))
                                    .or(abilities(PartAbility.IMPORT_FLUIDS).setMinGlobalLimited(1))
                                    .or(abilities(EPPartAbility.CATALYST).setMaxGlobalLimited(2))
                                    .or(abilities(PartAbility.INPUT_ENERGY)
                                            .setMinGlobalLimited(1)
                                            .setMaxGlobalLimited(2)))
                    .where('C', EPPredicates.CPCasingBlock())
                    .where('X', coilBlock())
                    .where('M', machineCasingBlock())
                    .where('T', EPPredicates.CPPipeBlock())
                    .where('#', any())
                    .where('A', air())
                    .build())
            .shapeInfos(definition -> {
                int maxLeng = Ints.max(
                        ALL_COIL_BLOCKS.size(),
                        ALL_CP_CASINGS.size(),
                        ALL_CP_TUBES.size(),
                        ALL_MACHINE_CASINGS.size());
                return new ArrayList<>(StructureUtil.getMatchingShapes(
                        (MOBlockPattern) definition.getPatternFactory().get(), maxLeng));
            })
            .partSorter(Comparator.comparingInt(a -> a.self().getPos().getY()))
            .renderer(() -> new TierCasingMachineRenderer(
                    GTCEu.id("block/casings/solid/machine_casing_bronze_plated_bricks"),
                    Epimorphism.id("block/multiblock/chemical_plant"),
                    ChemicalPlantMachine::locationGetter))
            .register();

    public static final MultiblockMachineDefinition CATALYTIC_REFORMER = registrate()
            .multiblock("catalytic_reformer", WorkableElectricMultiblockMachine::new)
            .tooltips(Component.translatable("block.epimorphism.catalytic_reformer.desc.0"))
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(EPRecipeTypes.CATALYTIC_REFORMER_RECIPES)
            .recipeModifier(
                    GTRecipeModifiers.ELECTRIC_OVERCLOCK.apply(OverclockingLogic.NON_PERFECT_OVERCLOCK))
            .appearanceBlock(CASING_TITANIUM_STABLE)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("F   F", "XXXPX", "XXXPX", "XXXPX")
                    .aisle("     ", "XXXPX", "X###M", "XXXPX")
                    .aisle("F   F", "XXXPX", "XSXPX", "XXXPX")
                    .where('S', controller(blocks(definition.getBlock())))
                    .where(
                            'X',
                            blocks(CASING_TITANIUM_STABLE.get())
                                    .setMinGlobalLimited(24)
                                    .or(autoAbilities(definition.getRecipeTypes()))
                                    .or(autoAbilities(true, true, false)))
                    .where('P', blocks(CASING_TITANIUM_PIPE.get()))
                    .where('F', frames(Titanium))
                    .where('M', abilities(MUFFLER))
                    .where(' ', any())
                    .where('#', air())
                    .build())
            .workableCasingRenderer(
                    GTCEu.id("block/casings/solid/machine_casing_stable_titanium"),
                    Epimorphism.id("block/multiblock/catalytic_reformer"),
                    false)
            .register();

    public static final MultiblockMachineDefinition CRYOGENIC_REACTOR = registrate()
            .multiblock("cryogenic_reactor", WorkableElectricMultiblockMachine::new)
            .tooltips(Component.translatable("block.epimorphism.cryogenic_reactor.desc.0"))
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(EPRecipeTypes.CRYOGENIC_REACTOR_RECIPES)
            .recipeModifier(
                    GTRecipeModifiers.ELECTRIC_OVERCLOCK.apply(OverclockingLogic.NON_PERFECT_OVERCLOCK))
            .appearanceBlock(CASING_ALUMINIUM_FROSTPROOF)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("    RR", "    TV", "    VV", "    TV", "    TT")
                    .aisle("F   RR", "F X TT", "FXPPPV", "F X TT", "F   TT")
                    .aisle("  X   ", " XCX  ", "XCKCP ", " XCX  ", "  X   ")
                    .aisle(" XXX  ", "XCCCX ", "XC#KP ", "XCCCX ", " XXX  ")
                    .aisle("  X   ", " XCX  ", "XCCCX ", " XCX  ", "  X   ")
                    .aisle("F   F ", "F X F ", "FXSXF ", "F X F ", "F   F ")
                    .where('S', controller(blocks(definition.getBlock())))
                    .where(
                            'X',
                            blocks(CASING_ALUMINIUM_FROSTPROOF.get())
                                    .setMinGlobalLimited(20)
                                    .or(autoAbilities(definition.getRecipeTypes()))
                                    .or(autoAbilities(true, false, false)))
                    .where('F', frames(Aluminium))
                    .where('R', frames(Steel))
                    .where('C', blocks(CASING_PTFE_INERT.get()))
                    .where('K', blocks(CASING_POLYTETRAFLUOROETHYLENE_PIPE.get()))
                    .where('P', blocks(CASING_STEEL_PIPE.get()))
                    .where('V', blocks(HEAT_VENT.get()))
                    .where('T', blocks(CASING_STEEL_SOLID.get()))
                    .where(' ', any())
                    .where('#', air())
                    .build())
            .workableCasingRenderer(
                    GTCEu.id("block/casings/solid/machine_casing_frost_proof"),
                    Epimorphism.id("block/multiblock/cryogenic_reactor"),
                    false)
            .register();

    public static final MultiblockMachineDefinition BURNER_REACTOR = registrate()
            .multiblock("burner_reactor", WorkableElectricMultiblockMachine::new)
            .tooltips(Component.translatable("block.epimorphism.burner_reactor.desc.0"))
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(EPRecipeTypes.BURNER_REACTOR_RECIPES)
            .recipeModifier(
                    GTRecipeModifiers.ELECTRIC_OVERCLOCK.apply(OverclockingLogic.NON_PERFECT_OVERCLOCK))
            .appearanceBlock(CASING_INVAR_HEATPROOF)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("F   F", "F X F", "FXXXF", "F X F", "F   F", "     ")
                    .aisle("  X  ", " XCX ", "XCCCX", " XCX ", "  X  ", "  X  ")
                    .aisle(" XXX ", "XCCCX", "XK#KX", "XC#CX", " XCX ", " XMX ")
                    .aisle("  X  ", " XCX ", "XCCCX", " XCX ", "  X  ", "  X  ")
                    .aisle("F   F", "F X F", "FXSXF", "F X F", "F   F", "     ")
                    .where('S', controller(blocks(definition.getBlock())))
                    .where(
                            'X',
                            blocks(CASING_INVAR_HEATPROOF.get())
                                    .setMinGlobalLimited(25)
                                    .or(autoAbilities(definition.getRecipeTypes()))
                                    .or(autoAbilities(true, true, false)))
                    .where('F', frames(MaragingSteel300))
                    .where('C', blocks(CASING_STAINLESS_CLEAN.get()))
                    .where('K', blocks(COIL_CUPRONICKEL.get()))
                    .where('M', abilities(MUFFLER))
                    .where(' ', any())
                    .where('#', air())
                    .build())
            .workableCasingRenderer(
                    GTCEu.id("block/casings/solid/machine_casing_heatproof"),
                    Epimorphism.id("block/multiblock/burner_reactor"),
                    false)
            .register();

    public static final MultiblockMachineDefinition DISSOLUTION_TANK = registrate()
            .multiblock("dissolution_tank", DissolutionTankMachine::new)
            .langValue("Dissolution Tank")
            .tooltips(Component.translatable("block.epimorphism.dissolution_tank.desc.0"))
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(EPRecipeTypes.DIGESTER_RECIPES)
            .recipeModifier(
                    GTRecipeModifiers.ELECTRIC_OVERCLOCK.apply(OverclockingLogic.PERFECT_OVERCLOCK))
            .appearanceBlock(CASING_STAINLESS_CLEAN)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("M   M", "MMMMM", "MGGGM", "MGGGM", " MMM ")
                    .aisle("     ", "MNNNM", "G###G", "G###G", "MMMMM")
                    .aisle("     ", "MNNNM", "G###G", "G###G", "MMMMM")
                    .aisle("     ", "MNNNM", "G###G", "G###G", "MMMMM")
                    .aisle("M   M", "MMSMM", "MGGGM", "MGGGM", " MMM ")
                    .where('S', controller(blocks(definition.get())))
                    .where(
                            'M',
                            blocks(CASING_STAINLESS_CLEAN.get())
                                    .or(autoAbilities(definition.getRecipeTypes()))
                                    .or(autoAbilities(true, false, false)))
                    .where('G', blocks(EPBlocks.OSMIR_BORON_SILICATE_GLASS.get()))
                    .where('N', blocks(CASING_INVAR_HEATPROOF.get()))
                    .where('#', air())
                    .where(' ', any())
                    .build())
            .renderer(() -> new TankMachineRenderer(
                    GTCEu.id("block/casings/solid/machine_casing_clean_stainless_steel"),
                    Epimorphism.id("block/multiblock/dissolution_tank")))
            .hasTESR(true)
            .register();

    public static final MultiblockMachineDefinition DIGESTER = registrate()
            .multiblock("digester", DigesterMachine::new)
            .langValue("Digester")
            .tooltips(Component.translatable("block.epimorphism.digester.desc.0"))
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(EPRecipeTypes.DIGESTER_RECIPES)
            .recipeModifier(
                    GTRecipeModifiers.ELECTRIC_OVERCLOCK.apply(OverclockingLogic.PERFECT_OVERCLOCK))
            .appearanceBlock(CASING_TUNGSTENSTEEL_ROBUST)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle(" CCCCC ", " COOOC ", "  CCC  ", "       ")
                    .aisle("CHHHHHC", "COAAAOC", " CAAAC ", " CCCCC ")
                    .aisle("CHLLLHC", "OAAAAAO", "CAAAAAC", " CAAAC ")
                    .aisle("CHLLLHC", "OAAAAAO", "CAAAAAC", " CAAAC ")
                    .aisle("CHLLLHC", "OAAAAAO", "CAAAAAC", " CAAAC ")
                    .aisle("CHHHHHC", "COAAAOC", " CAAAC ", " CCCCC ")
                    .aisle(" CCSCC ", " COOOC ", "  CCC  ", "       ")
                    .where('S', controller(blocks(definition.get())))
                    .where(
                            'C',
                            blocks(CASING_TUNGSTENSTEEL_ROBUST.get())
                                    .or(autoAbilities(definition.getRecipeTypes()))
                                    .or(autoAbilities(true, true, false)))
                    .where('H', blocks(CASING_INVAR_HEATPROOF.get()))
                    .where('O', blocks(COIL_CUPRONICKEL.get()))
                    .where('L', blocks(CASING_STAINLESS_CLEAN.get()))
                    .where('A', air())
                    .where(' ', any())
                    .build())
            .renderer(() -> DigesterRenderer.INSTANCE)
            .register();

    public static final MultiblockMachineDefinition ROASTER = registrate()
            .multiblock("roaster", WorkableElectricMultiblockMachine::new)
            .langValue("Roaster")
            .tooltips(
                    Component.translatable("block.epimorphism.roaster.desc.0"),
                    Component.translatable("block.epimorphism.roaster.desc.1"))
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(EPRecipeTypes.ROASTER_RECIPES)
            .recipeModifiers(
                    EPRecipeModifiers.EP_PARALLEL,
                    GTRecipeModifiers.ELECTRIC_OVERCLOCK.apply(OverclockingLogic.NON_PERFECT_OVERCLOCK))
            .appearanceBlock(CASING_INVAR_HEATPROOF)
            .pattern(definition -> FactoryMOPattern.start()
                    .aisle("     ", "     ", " D D ", " D D ", " D D ")
                    .aisle("A   A", "ACCCA", "BDBDB", "BBBBB", " D D ")
                    .aisle("     ", "BCCCB", "BD#DB", "BDEDB", " D D ")
                    .aisle("A   A", "ACCCA", "BBSBB", "BBBBB", "     ")
                    .where('S', Predicates.controller(blocks(definition.get())))
                    .where('A', frames(Invar))
                    .where(
                            'B',
                            blocks(CASING_INVAR_HEATPROOF.get())
                                    .setMinGlobalLimited(18)
                                    .or(Predicates.autoAbilities(definition.getRecipeTypes()))
                                    .or(Predicates.abilities(PartAbility.IMPORT_ITEMS))
                                    .or(Predicates.abilities(PartAbility.EXPORT_ITEMS))
                                    .or(Predicates.abilities(PartAbility.IMPORT_FLUIDS))
                                    .or(Predicates.abilities(PartAbility.EXPORT_FLUIDS))
                                    .or(Predicates.abilities(PartAbility.INPUT_ENERGY))
                                    .or(Predicates.autoAbilities(true, false, false)))
                    .where('C', EPPredicates.fireboxBlock())
                    .where('D', blocks(CASING_TITANIUM_PIPE.get()))
                    .where('E', abilities(MUFFLER))
                    .where('#', Predicates.air())
                    .where(' ', Predicates.any())
                    .build())
            .shapeInfos(definition -> new ArrayList<>(StructureUtil.getMatchingShapes(
                    (MOBlockPattern) definition.getPatternFactory().get(), ALL_FIREBOXS.size())))
            .workableCasingRenderer(
                    GTCEu.id("block/casings/solid/machine_casing_heatproof"),
                    Epimorphism.id("block/multiblock/roaster"),
                    false)
            .register();

    public static final MultiblockMachineDefinition CVD_UNIT = registrate()
            .multiblock("cvd_unit", WorkableElectricMultiblockMachine::new)
            .tooltips(Component.translatable("block.epimorphism.cvd_unit.desc.0"))
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(EPRecipeTypes.CVD_RECIPES)
            .recipeModifier(
                    GTRecipeModifiers.ELECTRIC_OVERCLOCK.apply(OverclockingLogic.NON_PERFECT_OVERCLOCK))
            .appearanceBlock(CASING_NONCONDUCTING)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("XXXXX", "XGGGX", "XGGGX")
                    .aisle("XXXXX", "XCCCX", "XGGGX")
                    .setRepeatable(3)
                    .aisle("XXXXX", "SGGGX", "XGGGX")
                    .where('S', controller(blocks(definition.getBlock())))
                    .where(
                            'X', blocks(CASING_NONCONDUCTING.get()).setMinGlobalLimited(35).or(autoAbilities()))
                    .where('G', blocks(EPBlocks.SILICATE_GLASS.get()))
                    .where('C', Predicates.blocks(EPBlocks.SUBSTRATE_CASING.get()))
                    .build())
            .workableCasingRenderer(
                    GTCEu.id("block/casings/gcym/nonconducting_casing"),
                    Epimorphism.id("block/multiblock/cvd_unit"),
                    false)
            .register();

    public static final MultiblockMachineDefinition PLASMA_CVD = registrate()
            .multiblock("plasma_cvd", WorkableElectricMultiblockMachine::new)
            .tooltips(Component.translatable("block.epimorphism.plasma_cvd.desc.0"))
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeTypes(EPRecipeTypes.CVD_RECIPES, EPRecipeTypes.PLASMA_CVD_RECIPES)
            .recipeModifier(
                    GTRecipeModifiers.ELECTRIC_OVERCLOCK.apply(OverclockingLogic.NON_PERFECT_OVERCLOCK))
            .appearanceBlock(CASING_ATOMIC)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("XXXXXXX", " XGGGX ", " XGGGX ", "       ")
                    .aisle("XXXXXXX", "XCCCCCX", "X     X", " XGGGX ")
                    .aisle("VXXXXXV", "VCCCCCV", "X     X", " XGGGX ")
                    .aisle("XXXXXXX", "XCCCCCX", "X     X", " XGGGX ")
                    .aisle("XXXXXXX", " SGGGX ", " XGGGX ", "       ")
                    .where('S', controller(blocks(definition.getBlock())))
                    .where('X', blocks(CASING_ATOMIC.get()).setMinGlobalLimited(40).or(autoAbilities()))
                    .where('G', blocks(FUSION_GLASS.get()))
                    .where('C', Predicates.blocks(EPBlocks.ADVANCED_SUBSTRATE_CASING.get()))
                    .where('V', blocks(HEAT_VENT.get()))
                    .build())
            .workableCasingRenderer(
                    GTCEu.id("block/casings/gcym/atomic_casing"),
                    Epimorphism.id("block/multiblock/plasma_cvd"),
                    false)
            .register();

    public static final MultiblockMachineDefinition LASER_CVD = registrate()
            .multiblock("laser_cvd", holder -> new TierCasingElectricMultiblockMachine(holder, "Firebox"))
            .tooltips(Component.translatable("block.epimorphism.laser_cvd.desc.0"))
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeTypes(EPRecipeTypes.CVD_RECIPES, EPRecipeTypes.LASER_CVD_RECIPES)
            .recipeModifier(
                    GTRecipeModifiers.ELECTRIC_OVERCLOCK.apply(OverclockingLogic.NON_PERFECT_OVERCLOCK))
            .appearanceBlock(CASING_REACTION_SAFE)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("   XXXXX", "   XGGGX", "   XGGGX", "   XGGGX", "    XXX ")
                    .aisle("XXXXXXXX", "XXXFCCCF", "XXXF   F", "XXXF   F", "    FFF ")
                    .aisle("XXXXXXXX", "X XFCCCF", "X G    X", "XXXF   F", "    FFF ")
                    .aisle("XXXXXXXX", "XXXFCCCF", "XSXF   F", "XXXF   F", "    FFF ")
                    .aisle("   XXXXX", "   XGGGX", "   XGGGX", "   XGGGX", "    XXX ")
                    .where('S', controller(blocks(definition.getBlock())))
                    .where(
                            'X', blocks(CASING_REACTION_SAFE.get()).setMinGlobalLimited(60).or(autoAbilities()))
                    .where('G', blocks(FUSION_GLASS.get()))
                    .where('C', Predicates.blocks(EPBlocks.ADVANCED_SUBSTRATE_CASING.get()))
                    .where('F', frames(HastelloyX))
                    .build())
            .workableCasingRenderer(
                    GTCEu.id("block/casings/gcym/reaction_safe_mixing_casing"),
                    Epimorphism.id("block/multiblock/laser_cvd"),
                    false)
            .register();

    public static final MultiblockMachineDefinition NANOSCALE_FABRICATOR = registrate()
            .multiblock("nanoscale_fabricator", NanoscaleFabricatorMachine::new)
            .langValue("Nanoscale Fabricator")
            .tooltips(Component.translatable("block.epimorphism.nanoscale_fabricator.desc.0"))
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(EPRecipeTypes.MOLECULAR_BEAM_RECIPES)
            .appearanceBlock(CASING_LASER_SAFE_ENGRAVING)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("   TTT   ", "   TIT   ", "   TCT   ", "         ")
                    .aisle("  XXXXX  ", "  XX#XX  ", "  XXXXX  ", "  XXXXX  ")
                    .aisle(" XXXXXXX ", " X#####X ", " X#####X ", " XXGGGXX ")
                    .aisle("TXXTTTXXT", "TX#####XT", "TX#####XT", " XGGGGGX ")
                    .aisle("TXXTITXXT", "I###A###I", "CX#####XC", " XGGGGGX ")
                    .aisle("TXXTTTXXT", "TX#####XT", "TX#####XT", " XGGGGGX ")
                    .aisle(" XXXXXXX ", " X#####X ", " X#####X ", " XXGGGXX ")
                    .aisle("  XXXXX  ", "  XX#XX  ", "  XXXXX  ", "  XXSXX  ")
                    .aisle("   TTT   ", "   TIT   ", "   TCT   ", "         ")
                    .where('S', controller(blocks(definition.get())))
                    .where(
                            'X',
                            blocks(CASING_LASER_SAFE_ENGRAVING.get())
                                    .setMinGlobalLimited(84)
                                    .or(autoAbilities(definition.getRecipeTypes()))
                                    .or(autoAbilities(true, false, false)))
                    .where('T', blocks(CASING_NONCONDUCTING.get()).setMinGlobalLimited(36))
                    .where('G', blocks(CASING_LAMINATED_GLASS.get()))
                    .where('I', ability(PartAbility.IMPORT_ITEMS, ULV).or(blocks(CASING_NONCONDUCTING.get())))
                    .where(
                            'C',
                            blocks(CASING_NONCONDUCTING.get()).or(NanoscaleFabricatorMachine.cruciblePredicate()))
                    .where('A', Predicates.blocks(EPBlocks.ADVANCED_SUBSTRATE_CASING.get()))
                    .where('#', air())
                    .where(' ', any())
                    .build())
            .shapeInfos(definition -> {
                List<MultiblockShapeInfo> shapeInfos = new ArrayList<>();
                MultiblockShapeInfo.ShapeInfoBuilder builder = MultiblockShapeInfo.builder()
                        .aisle("   TTT   ", "   TPT   ", "   TCT   ", "         ")
                        .aisle("  XXXXX  ", "  FX XO  ", "  LXXXX  ", "  XMSEX  ")
                        .aisle(" XXXXXXX ", " X     X ", " X     X ", " XXGGGXX ")
                        .aisle("TXXTTTXXT", "TX     XT", "TX     XT", " XGGGGGX ")
                        .aisle("TXXTATXXT", "N   J   U", "CX     XC", " XGGGGGX ")
                        .aisle("TXXTTTXXT", "TX     XT", "TX     XT", " XGGGGGX ")
                        .aisle(" XXXXXXX ", " X     X ", " X     X ", " XXGGGXX ")
                        .aisle("  XXXXX  ", "  XX XX  ", "  XXXXX  ", "  XXXXX  ")
                        .aisle("   TTT   ", "   TIT   ", "   TCT   ", "         ")
                        .where('S', definition, Direction.NORTH)
                        .where('X', CASING_LASER_SAFE_ENGRAVING.get())
                        .where('T', CASING_NONCONDUCTING.get())
                        .where('G', CASING_LAMINATED_GLASS.get())
                        .where('J', EPBlocks.ADVANCED_SUBSTRATE_CASING.get())
                        .where('I', GTMachines.ITEM_IMPORT_BUS[ULV], Direction.SOUTH)
                        .where('N', GTMachines.ITEM_IMPORT_BUS[ULV], Direction.WEST)
                        .where('P', GTMachines.ITEM_IMPORT_BUS[ULV], Direction.NORTH)
                        .where('U', GTMachines.ITEM_IMPORT_BUS[ULV], Direction.EAST)
                        .where('A', GTMachines.ITEM_IMPORT_BUS[ULV], Direction.DOWN)
                        .where('E', GTMachines.ENERGY_INPUT_HATCH[LuV], Direction.NORTH)
                        .where('F', GTMachines.FLUID_IMPORT_HATCH[HV], Direction.NORTH)
                        .where('L', GTMachines.FLUID_EXPORT_HATCH[HV], Direction.NORTH)
                        .where('O', GTMachines.ITEM_EXPORT_BUS[HV], Direction.NORTH)
                        .where('M', GTMachines.MAINTENANCE_HATCH, Direction.NORTH)
                        .where(' ', Blocks.AIR.defaultBlockState());

                EPBlocks.CRUCIBLE_BLOCKS.values().stream()
                        .map(BlockEntry::get)
                        .sorted(Comparator.comparingInt(CrucibleBlock::getHeatCapacity))
                        .forEach(crucible -> shapeInfos.add(builder.where('C', crucible).build()));

                return shapeInfos;
            })
            .renderer(() -> new CustomPartRenderer(
                    GTCEu.id("block/casings/gcym/laser_safe_engraving_casing"),
                    Epimorphism.id("block/multiblock/nanoscale_fabricator"),
                    NanoscaleFabricatorMachine::getBaseTexture))
            .register();
    public static final MultiblockMachineDefinition NANO_FORGE = registrate()
            .multiblock("nano_forge", NanoForgeMachine::new)
            .langValue("Nano Forge")
            .tooltips(Component.translatable("block.epimorphism.nano_forge.desc.0"))
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(EPRecipeTypes.NANO_FORGE_RECIPES)
            .appearanceBlock(EPBlocks.NAQUADAH_ALLOY_CASING)
            .pattern(StructureUtil::emptyPattern)
            .shapeInfos(definition -> {
                List<MultiblockShapeInfo> shapeInfos = new ArrayList<>();
                for (int i = 1; i < 4; i++) {
                    shapeInfos.addAll(
                            StructureUtil.getMatchingShapes(NanoForgeMachine.getBlockPattern(i, definition)));
                }
                return shapeInfos;
            })
            .workableCasingRenderer(
                    Epimorphism.id("block/casings/solid/naquadah_alloy_casing"),
                    Epimorphism.id("block/multiblock/nano_forge"),
                    false)
            .register();

    public static final MultiblockMachineDefinition CRYSTALLIZATION_CRUCIBLE = registrate()
            .multiblock("crystallization_crucible", CoilWorkableElectricMultiblockMachine::new)
            .langValue("Crystallization Crucible")
            .tooltips(Component.translatable("block.epimorphism.crystallization_crucible.desc.0"))
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(EPRecipeTypes.CRYSTALLIZATION_RECIPES)
            .appearanceBlock(CASING_TITANIUM_STABLE)
            .pattern(definition -> FactoryMOPattern.start()
                    .aisle("XXXXX", "G###G", "G###G", "XXXXX")
                    .aisle("XXXXX", "#VCV#", "#VCV#", "XXXXX")
                    .aisle("XXXXX", "#CAC#", "#CAC#", "XXMXX")
                    .aisle("XXXXX", "#VCV#", "#VCV#", "XXXXX")
                    .aisle("XXSXX", "G###G", "G###G", "XXXXX")
                    .where('S', controller(blocks(definition.get())))
                    .where(
                            'X',
                            blocks(CASING_TITANIUM_STABLE.get())
                                    .setMinGlobalLimited(32)
                                    .or(autoAbilities(definition.getRecipeTypes()))
                                    .or(autoAbilities(true, false, false)))
                    .where('C', coilBlock())
                    .where('M', abilities(MUFFLER))
                    .where('G', frames(Titanium))
                    .where('V', blocks(HEAT_VENT.get()))
                    .where('A', air())
                    .where('#', any())
                    .build())
            .shapeInfos(definition -> new ArrayList<>(StructureUtil.getMatchingShapes(
                    (MOBlockPattern) definition.getPatternFactory().get(), ALL_COIL_BLOCKS.size())))
            .workableCasingRenderer(
                    GTCEu.id("block/casings/solid/machine_casing_stable_titanium"),
                    Epimorphism.id("block/multiblock/crystallization_crucible"),
                    false)
            .additionalDisplay((controller, components) -> {
                if (controller instanceof CoilWorkableElectricMultiblockMachine coilMachine
                        && controller.isFormed()) {
                    components.add(Component.translatable(
                            "gtceu.multiblock.blast_furnace.max_temperature",
                            Component.translatable(
                                            FormattingUtil.formatNumbers(coilMachine.getCoilType().getCoilTemperature()
                                                            + 100L * Math.max(0, coilMachine.getTier() - GTValues.MV))
                                                    + "K")
                                    .setStyle(Style.EMPTY.withColor(ChatFormatting.RED))));
                }
            })
            .register();

    public static final MultiblockMachineDefinition ISA_MILL = registrate()
            .multiblock("isa_mill", IsaMillMachine::new)
            .langValue("Isa Mill")
            .tooltips(Component.translatable("block.epimorphism.isa_mill.desc.0"))
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(DUMMY_RECIPES)
            .recipeModifier(
                    GTRecipeModifiers.ELECTRIC_OVERCLOCK.apply(OverclockingLogic.NON_PERFECT_OVERCLOCK))
            .appearanceBlock(EPBlocks.ISA_MILL_CASING)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("CEEEEEE", "CEEEEEE", "CEEEEEE")
                    .aisle("CEEEEEE", "BGGGGGE", "CEEEEEE")
                    .aisle("CEEEEEE", "CEESEEE", "CEEEEEE")
                    .where('S', controller(blocks(definition.get())))
                    .where('B', abilities(EPPartAbility.GRIND_BALL))
                    .where('C', Predicates.blocks(EPBlocks.CASING_ISA_MILL_PIPE.get()))
                    .where(
                            'E',
                            Predicates.blocks(EPBlocks.ISA_MILL_CASING.get())
                                    .setMinGlobalLimited(31)
                                    .or(abilities(MUFFLER).setExactLimit(1))
                                    .or(abilities(PartAbility.MAINTENANCE).setExactLimit(1))
                                    .or(abilities(PartAbility.EXPORT_ITEMS).setMinGlobalLimited(1).setPreviewCount(1))
                                    .or(abilities(PartAbility.IMPORT_ITEMS).setMinGlobalLimited(1).setPreviewCount(1))
                                    .or(abilities(PartAbility.INPUT_ENERGY)
                                            .setMinGlobalLimited(1)
                                            .setMaxGlobalLimited(2)
                                            .setPreviewCount(1)))
                    .where('G', Predicates.blocks(EPBlocks.CASING_ISA_MILL_GEARBOX.get()))
                    .build())
            .workableCasingRenderer(
                    Epimorphism.id("block/casings/solid/isa_mill_casing"),
                    Epimorphism.id("block/multiblock/isa_mill"),
                    false)
            .register();

    public static final MultiblockMachineDefinition INDUSTRIAL_FLOTATION_CELL = registrate()
            .multiblock(
                    "industrial_flotation_cell",
                    blockEntity -> new ParallelElectricMultiblockMachine(blockEntity, machine -> 1))
            .langValue("Industrial Flotation Cell")
            .tooltips(Component.translatable("block.epimorphism.industrial_flotation_cell.desc.0"))
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(DUMMY_RECIPES)
            .recipeModifier(
                    GTRecipeModifiers.ELECTRIC_OVERCLOCK.apply(OverclockingLogic.NON_PERFECT_OVERCLOCK))
            .appearanceBlock(EPBlocks.FLOTATION_CASING)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle(
                            "  AAA  ", "  AAA  ", "       ", "       ", "       ", "       ", "       ",
                            "       ", "       ")
                    .aisle(
                            " AAAAA ", " AAAAA ", "   C   ", "   C   ", "   C   ", "   C   ", "   C   ",
                            "   C   ", "       ")
                    .aisle(
                            "AAAAAAA", "AAAAAAA", "  CDC  ", "  CDC  ", "  CDC  ", "  CDC  ", "  CDC  ",
                            "  CDC  ", "   A   ")
                    .aisle(
                            "AAAAAAA", "AAAAAAA", " CDDDC ", " CDDDC ", " CDDDC ", " CDDDC ", " CDDDC ",
                            " CDDDC ", "  AAA  ")
                    .aisle(
                            "AAAAAAA", "AAAAAAA", "  CDC  ", "  CDC  ", "  CDC  ", "  CDC  ", "  CDC  ",
                            "  CDC  ", "   A   ")
                    .aisle(
                            " AAAAA ", " AAAAA ", "   C   ", "   C   ", "   C   ", "   C   ", "   C   ",
                            "   C   ", "       ")
                    .aisle(
                            "  AAA  ", "  ASA  ", "       ", "       ", "       ", "       ", "       ",
                            "       ", "       ")
                    .where('S', Predicates.controller(blocks(definition.getBlock())))
                    .where('C', blocks(EPBlocks.FLOTATION_CELL.get()).setMinGlobalLimited(48))
                    .where(
                            'A',
                            blocks(EPBlocks.FLOTATION_CASING.get())
                                    .setMinGlobalLimited(64)
                                    .or(Predicates.autoAbilities(definition.getRecipeTypes()))
                                    .or(Predicates.autoAbilities(true, false, false)))
                    .where('D', Predicates.air())
                    .build())
            .workableCasingRenderer(
                    Epimorphism.id("block/casings/solid/flotation_casing"),
                    Epimorphism.id("block/multiblock/industrial_flotation_cell"),
                    false)
            .register();

    public static final MultiblockMachineDefinition VACUUM_DRYING_FURNACE = registrate()
            .multiblock(
                    "vacuum_drying_furnace",
                    blockEntity ->
                            new ParallelCoilMultiblockMachine(blockEntity, machine -> machine.getCoilTier() * 4))
            .langValue("Vacuum Drying Furnace")
            .tooltips(Component.translatable("block.epimorphism.vacuum_drying_furnace.desc.0"))
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeTypes(EPRecipeTypes.VACUUM_DRYING_FURNACE_RECIPES, EPRecipeTypes.DEHYDRATOR_RECIPES)
            .appearanceBlock(EPBlocks.VACUUM_CASING)
            .pattern(definition -> FactoryMOPattern.start()
                    .aisle("XXX", "CCC", "CCC", "CCC", "XXX")
                    .aisle("XXX", "C#C", "C#C", "C#C", "XMX")
                    .aisle("XSX", "CCC", "CCC", "CCC", "XXX")
                    .where('S', controller(blocks(definition.get())))
                    .where(
                            'X',
                            Predicates.blocks(EPBlocks.VACUUM_CASING.get())
                                    .setMinGlobalLimited(9)
                                    .or(autoAbilities(definition.getRecipeTypes()))
                                    .or(autoAbilities(true, false, false)))
                    .where('M', abilities(MUFFLER))
                    .where('C', coilBlock())
                    .where('#', air())
                    .build())
            .shapeInfos(definition -> new ArrayList<>(StructureUtil.getMatchingShapes(
                    (MOBlockPattern) definition.getPatternFactory().get(), ALL_COIL_BLOCKS.size())))
            .partSorter(Comparator.comparingInt(a -> a.self().getPos().getY()))
            .workableCasingRenderer(
                    Epimorphism.id("block/casings/solid/vacuum_casing"),
                    Epimorphism.id("block/multiblock/vacuum_drying_furnace"),
                    false)
            .register();

    // Bedrock
    public static final MultiblockMachineDefinition INDUSTRIAL_DRILL = registrate()
            .multiblock("industrial_drill", IndustrialDrillMachine::new)
            .langValue("Industrial Drill")
            .tooltips(Component.translatable("block.epimorphism.industrial_drill.desc.0"))
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(EPRecipeTypes.DRILLING_RECIPES)
            .recipeModifier(
                    GTRecipeModifiers.ELECTRIC_OVERCLOCK.apply(OverclockingLogic.NON_PERFECT_OVERCLOCK))
            .appearanceBlock(CASING_STEEL_SOLID)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle(
                            "       ", "XXXXXXX", "X     X", "X     X", "X     X", "X     X", "X     X",
                            "XXXXXXX")
                    .aisle(
                            "       ", "X     X", "       ", " F   F ", "       ", "       ", "       ",
                            "X  F  X")
                    .aisle(
                            "       ", "X     X", "   C   ", "  FCF  ", "   C   ", "  CVC  ", "  CVC  ",
                            "X BBB X")
                    .aisle(
                            "   R   ", "X  D  X", "  CGC  ", "  CGC  ", "  CGC  ", "  VGV  ", "  VGV  ",
                            "XFBBBFX")
                    .aisle(
                            "       ", "X     X", "   C   ", "  FCF  ", "   C   ", "  CSC  ", "  CVC  ",
                            "X BBB X")
                    .aisle(
                            "       ", "X     X", "       ", " F   F ", "       ", "       ", "       ",
                            "X  F  X")
                    .aisle(
                            "       ", "XXXXXXX", "X     X", "X     X", "X     X", "X     X", "X     X",
                            "XXXXXXX")
                    .where('S', controller(blocks(definition.get())))
                    .where('X', blocks(CASING_ATOMIC.get()))
                    .where('F', frames(HSLASteel))
                    .where('C', blocks(CASING_STEEL_SOLID.get()))
                    .where('G', blocks(CASING_TUNGSTENSTEEL_GEARBOX.get()))
                    .where('V', blocks(CASING_GRATE.get()))
                    .where(
                            'B',
                            blocks(CASING_STEEL_SOLID.get())
                                    .setMinGlobalLimited(4)
                                    .or(autoAbilities(
                                            definition.getRecipeTypes(), true, true, false, true, true, true))
                                    .or(autoAbilities(true, true, false)))
                    .where('D', Predicates.blocks(EPBlocks.DRILL_HEAD.get()))
                    .where('R', EPPredicates.bedrockPredicate())
                    .where(' ', any())
                    .build())
            .workableCasingRenderer(
                    GTCEu.id("block/casings/solid/machine_casing_solid_steel"),
                    Epimorphism.id("block/multiblock/industrial_drill"),
                    false)
            .register();

    public static final MultiblockMachineDefinition FRACKER = registrate()
            .multiblock("fracker", FrackerMachine::new)
            .langValue("Fracker")
            .tooltips(Component.translatable("block.epimorphism.fracker.desc.0"))
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(DUMMY_RECIPES)
            .recipeModifier(
                    GTRecipeModifiers.ELECTRIC_OVERCLOCK.apply(OverclockingLogic.NON_PERFECT_OVERCLOCK))
            .appearanceBlock(CASING_WATERTIGHT)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("F    F", "F    F", "F  CCC", "F  CCC", "F  CCC", "FFFCCC", "   CCC", "   CCC")
                    .aisle("    P ", "    P ", "   CPC", "   CPC", "   CPC", "F  CPC", " PPPPC", "   CCC")
                    .aisle("      ", "      ", "   CCC", "XXXCCC", "XXXCCC", "XXXCCC", " P CCC", "   CCC")
                    .aisle("      ", "      ", "     F", "XXXX  ", "X##X  ", "XXXX F", " P    ", "      ")
                    .aisle("      ", "      ", "     F", "XXXX  ", "XP#X  ", "XPXX F", " P    ", "      ")
                    .aisle("F    F", "F    F", "F    F", "XXXX F", "XSXX F", "XXXXFF", "      ", "      ")
                    .where('S', controller(blocks(definition.get())))
                    .where(
                            'X',
                            blocks(CASING_WATERTIGHT.get())
                                    .setMinGlobalLimited(32)
                                    .or(autoAbilities(true, true, false))
                                    .or(abilities(PartAbility.INPUT_ENERGY)
                                            .setMinGlobalLimited(1)
                                            .setMaxGlobalLimited(1))
                                    .or(abilities(PartAbility.IMPORT_FLUIDS).setMinGlobalLimited(1)))
                    .where('C', blocks(CASING_STAINLESS_CLEAN.get()))
                    .where('F', frames(GTMaterials.HSLASteel))
                    .where('P', blocks(CASING_STEEL_PIPE.get()))
                    .where('#', air())
                    .where(' ', any())
                    .build())
            .workableCasingRenderer(
                    GTCEu.id("block/casings/gcym/watertight_casing"),
                    Epimorphism.id("block/multiblock/fracker"),
                    false)
            .register();

    public static final MultiblockMachineDefinition[] CONCRETE_BACKFILLER = registerTieredEPMultis(
            "concrete_backfiller",
            (holder, tier) ->
                    new ConcreteBackfillerMachine(holder, tier, 64 / tier, 2 * tier - 5, 8 - (tier - 5)),
            (tier, builder) -> builder
                    .langValue("Concrete Backfiller")
                    .tooltips(Component.translatable("block.epimorphism.concrete_backfiller.desc.0"))
                    .rotationState(RotationState.NON_Y_AXIS)
                    .recipeType(DUMMY_RECIPES)
                    .appearanceBlock(() -> ConcreteBackfillerMachine.getCasingState(tier))
                    .pattern(definition -> FactoryBlockPattern.start()
                            .aisle("XXX", "#F#", "#F#", "#F#", "###", "###", "###")
                            .aisle("XXX", "FCF", "FCF", "FCF", "#F#", "#F#", "#F#")
                            .aisle("XSX", "#F#", "#F#", "#F#", "###", "###", "###")
                            .where('S', controller(blocks(definition.get())))
                            .where(
                                    'X',
                                    blocks(ConcreteBackfillerMachine.getCasingState(tier))
                                            .setMinGlobalLimited(3)
                                            .or(abilities(PartAbility.INPUT_ENERGY)
                                                    .setMinGlobalLimited(1)
                                                    .setMaxGlobalLimited(3))
                                            .or(abilities(PartAbility.IMPORT_FLUIDS).setMaxGlobalLimited(1)))
                            .where('C', blocks(ConcreteBackfillerMachine.getCasingState(tier)))
                            .where('F', frames(ConcreteBackfillerMachine.getMaterial(tier)))
                            .where('#', any())
                            .build())
                    .renderer(() -> new LargeMinerRenderer(
                            MinerRenderer.MATERIALS_TO_CASING_MODELS.get(
                                    ConcreteBackfillerMachine.getMaterial(tier)),
                            Epimorphism.id("block/multiblock/concrete_backfiller")))
                    .register(),
            MV,
            EV);

    // Storage
    public static final MultiblockMachineDefinition YOTTA_FLUID_TANK = registrate()
            .multiblock("yotta_fluid_tank", YottaFluidTankMachine::new)
            .langValue("Yotta Fluid Tank")
            .tooltips(
                    Component.translatable("block.epimorphism.yotta_fluid_tank.desc.0"),
                    Component.translatable("block.epimorphism.yotta_fluid_tank.desc.1"))
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(DUMMY_RECIPES)
            .appearanceBlock(EPBlocks.YOTTA_FLUID_TANK_CASING)
            .pattern(definition -> FactoryBlockPattern.start(
                            RelativeDirection.RIGHT, RelativeDirection.BACK, RelativeDirection.UP)
                    .aisle("     ", " FFF ", " FFF ", " FFF ", "     ")
                    .aisle("AABAA", "AAAAA", "AAAAA", "AAAAA", "AAAAA")
                    .aisle("CCCCC", "CEEEC", "CEEEC", "CEEEC", "CCCCC")
                    .setRepeatable(1, 15)
                    .aisle("AAAAA", "AGGGA", "AGGGA", "AGGGA", "AAAAA")
                    .aisle("DDDDD", "D   D", "D   D", "D   D", "DDDDD")
                    .where('B', controller(blocks(definition.getBlock())))
                    .where(
                            'A',
                            Predicates.blocks(EPBlocks.YOTTA_FLUID_TANK_CASING.get())
                                    .or(abilities(EPPartAbility.TANK_ACCESS).setMaxGlobalLimited(1)))
                    .where('C', EPPredicates.glass())
                    .where('D', frames(GTMaterials.Steel))
                    .where('E', EPPredicates.fluidTankCell())
                    .where(
                            'F',
                            Predicates.blocks(EPBlocks.YOTTA_FLUID_TANK_CASING.get())
                                    .or(abilities(PartAbility.EXPORT_FLUIDS)))
                    .where(
                            'G',
                            Predicates.blocks(EPBlocks.YOTTA_FLUID_TANK_CASING.get())
                                    .or(abilities(PartAbility.IMPORT_FLUIDS)))
                    .build())
            .shapeInfos(definition -> {
                List<MultiblockShapeInfo> shapeInfo = new ArrayList<>();
                MultiblockShapeInfo.ShapeInfoBuilder builder = LayerShapeInfo.builder()
                        .aisle("     ", " FFF ", " FFF ", " FFF ", "     ")
                        .aisle("AABAA", "AAAAA", "AAAAA", "AAAAA", "AAAAA")
                        .aisle("CCCCC", "CEEEC", "CEEEC", "CEEEC", "CCCCC")
                        .aisle("CCCCC", "CEEEC", "CEEEC", "CEEEC", "CCCCC")
                        .aisle("CCCCC", "CEEEC", "CEEEC", "CEEEC", "CCCCC")
                        .aisle("CCCCC", "CEEEC", "CEEEC", "CEEEC", "CCCCC")
                        .aisle("CCCCC", "CEEEC", "CEEEC", "CEEEC", "CCCCC")
                        .where('B', definition, Direction.NORTH)
                        .where('A', EPBlocks.YOTTA_FLUID_TANK_CASING.get())
                        .where('D', ChemicalHelper.getBlock(frameGt, GTMaterials.Steel))
                        .where('F', GTMachines.FLUID_EXPORT_HATCH[ULV], Direction.DOWN)
                        .where('G', GTMachines.FLUID_IMPORT_HATCH[ULV], Direction.UP)
                        .where(' ', Blocks.AIR.defaultBlockState());
                var fluidCells = BlockMaps.ALL_FLUID_CELLS.entrySet().stream()
                        .sorted(Comparator.comparingInt(entry -> entry.getKey().tier()))
                        .map(Map.Entry::getValue)
                        .toList();
                var glass = BlockMaps.ALL_GLASSES.entrySet().stream()
                        .collect(
                                Collectors.toMap(entry -> entry.getKey().tier(), Map.Entry::getValue, (a, b) -> a));
                TreeMap<Integer, Supplier<Block>> glasses = new TreeMap<>(glass);
                for (int i = 0; i < fluidCells.size(); i++) {
                    var info = builder
                            .aisle("CCCCC", "CEEEC", "CEEEC", "CEEEC", "CCCCC")
                            .where('C', glasses.ceilingEntry(i + 3).getValue())
                            .where('E', fluidCells.get(i))
                            .shallowCopy()
                            .aisle("AAAAA", "AGGGA", "AGGGA", "AGGGA", "AAAAA")
                            .aisle("DDDDD", "D   D", "D   D", "D   D", "DDDDD")
                            .build();
                    shapeInfo.add(info);
                }
                return shapeInfo;
            })
            .partSorter(Comparator.comparingInt(a -> a.self().getPos().getY()))
            .sidedWorkableCasingRenderer(
                    "block/casings/yotta_fluid_tank_casing",
                    Epimorphism.id("block/multiblock/yotta_fluid_tank"),
                    false)
            .register();

    public static final MultiblockMachineDefinition TFFT = registrate()
            .multiblock("tfft", TFFTMachine::new)
            .langValue("T.F.F.T.")
            .tooltips(Component.translatable("block.epimorphism.tfft.desc.0"))
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(DUMMY_RECIPES)
            .appearanceBlock(EPBlocks.TFFT_CASING)
            .pattern(definition -> FactoryMOPattern.start(
                            RelativeDirection.RIGHT, RelativeDirection.BACK, RelativeDirection.UP)
                    .aisle("AADAA", "AAAAA", "AAAAA", "AAAAA", "AAAAA")
                    .aisle("BBBBB", "BCCCB", "BCCCB", "BCCCB", "BBBBB")
                    .setRepeatable(1, 15)
                    .aisle("AAAAA", "AAAAA", "AAAAA", "AAAAA", "AAAAA")
                    .where('D', controller(blocks(definition.getBlock())))
                    .where(
                            'A',
                            Predicates.blocks(EPBlocks.TFFT_CASING.get())
                                    .or(abilities(PartAbility.IMPORT_FLUIDS)
                                            .setMinGlobalLimited(1)
                                            .setMaxGlobalLimited(9))
                                    .or(abilities(PartAbility.EXPORT_FLUIDS)
                                            .setMinGlobalLimited(1)
                                            .setMaxGlobalLimited(9))
                                    .or(abilities(PartAbility.INPUT_ENERGY)
                                            .setMinGlobalLimited(1)
                                            .setMaxGlobalLimited(3))
                                    .or(abilities(EPPartAbility.TANK_ACCESS).setMaxGlobalLimited(1))
                                    .or(abilities(PartAbility.MAINTENANCE).setExactLimit(1)))
                    .where('B', blocks(CASING_LAMINATED_GLASS.get()))
                    .where('C', EPPredicates.storageFieldBlock())
                    .build())
            .shapeInfos(definition -> new ArrayList<>(StructureUtil.getMatchingShapes(
                    (MOBlockPattern) definition.getPatternFactory().get(), ALL_FIELD_BLOCKS.size())))
            .partSorter(Comparator.comparingInt(a -> a.self().getPos().getY()))
            .workableCasingRenderer(
                    Epimorphism.id("block/casings/solid/tfft_casing"),
                    Epimorphism.id("block/multiblock/tfft"),
                    false)
            .register();

    //////////////////////////////////////
    // **********     Misc     **********//
    //////////////////////////////////////

    public static void init() {
        AdvancedMachines.init();
        BiologyMachines.init();
        GeneratorMachines.init();

        if (EPIntegration.isAE2Loaded()) {
            EPAEMachines.init();
        }

        if (Platform.isDatagen()) {
            EPAEMachines.init();
        }
    }

    public static MachineDefinition[] registerSimpleMachines(
            String name, GTRecipeType recipeType, Int2LongFunction tankScalingFunction, int... tiers) {
        return registerTieredEPMachines(
                name,
                (holder, tier) -> new SimpleTieredMachine(holder, tier, tankScalingFunction),
                (tier, builder) -> builder
                        .langValue("%s %s %s".formatted(VLVH[tier], toEnglishName(name), VLVT[tier]))
                        .editableUI(SimpleTieredMachine.EDITABLE_UI_CREATOR.apply(GTCEu.id(name), recipeType))
                        .rotationState(RotationState.NON_Y_AXIS)
                        .recipeType(recipeType)
                        .recipeModifier(
                                GTRecipeModifiers.ELECTRIC_OVERCLOCK.apply(OverclockingLogic.NON_PERFECT_OVERCLOCK))
                        .workableTieredHullRenderer(Epimorphism.id("block/machines/" + name))
                        .tooltips(GTMachines.explosion())
                        .tooltips(GTMachines.workableTiered(
                                tier,
                                GTValues.V[tier],
                                GTValues.V[tier] * 64,
                                recipeType,
                                tankScalingFunction.apply(tier),
                                true))
                        .register(),
                tiers);
    }

    public static MachineDefinition[] registerTieredEPGenerators(
            String name, GTRecipeType recipeType, Int2LongFunction tankScalingFunction, int... tiers) {
        return registerTieredEPMachines(
                name,
                (holder, tier) -> new SimpleGeneratorMachine(holder, tier, tankScalingFunction),
                (tier, builder) -> builder
                        .langValue("%s %s Generator %s".formatted(VLVH[tier], toEnglishName(name), VLVT[tier]))
                        .editableUI(
                                SimpleGeneratorMachine.EDITABLE_UI_CREATOR.apply(GTCEu.id(name), recipeType))
                        .rotationState(RotationState.ALL)
                        .recipeType(recipeType)
                        .recipeModifier(SimpleGeneratorMachine::recipeModifier, true)
                        //                .addOutputLimit(ItemRecipeCapability.CAP, 0)
                        //                .addOutputLimit(FluidRecipeCapability.CAP, 0)
                        .renderer(() -> new SimpleGeneratorMachineRenderer(
                                tier, Epimorphism.id("block/generators/" + name)))
                        .tooltips(GTMachines.workableTiered(
                                tier,
                                GTValues.V[tier],
                                GTValues.V[tier] * 64,
                                recipeType,
                                tankScalingFunction.apply(tier),
                                false))
                        .register(),
                tiers);
    }

    public static MachineDefinition[] registerEfficiencyGenerators(
            String name,
            GTRecipeType recipeType,
            RecipeModifier recipeModifier,
            Int2LongFunction tankScalingFunction,
            int... tiers) {
        return registerTieredEPMachines(
                name,
                (holder, tier) -> new EfficiencyGeneratorMachine(holder, tier, name, tankScalingFunction),
                (tier, builder) -> builder
                        .langValue("%s %s Generator %s".formatted(VLVH[tier], toEnglishName(name), VLVT[tier]))
                        .editableUI(
                                SimpleGeneratorMachine.EDITABLE_UI_CREATOR.apply(GTCEu.id(name), recipeType))
                        .rotationState(RotationState.ALL)
                        .recipeType(recipeType)
                        .recipeModifier(recipeModifier, true)
                        .addOutputLimit(ItemRecipeCapability.CAP, 0)
                        .addOutputLimit(FluidRecipeCapability.CAP, 0)
                        .renderer(() -> new SimpleGeneratorMachineRenderer(
                                tier, Epimorphism.id("block/generators/" + name)))
                        .tooltips(Component.translatable(
                                "epimorphism.machine." + name + ".desc",
                                EfficiencyGeneratorMachine.getEfficiency(tier, name)))
                        .tooltips(GTMachines.explosion())
                        .tooltips(GTMachines.workableTiered(
                                tier,
                                GTValues.V[tier],
                                GTValues.V[tier] * 64,
                                recipeType,
                                tankScalingFunction.apply(tier),
                                false))
                        .register(),
                tiers);
    }

    public static MachineDefinition[] registerTieredEPMachines(
            String name,
            BiFunction<IMachineBlockEntity, Integer, MetaMachine> factory,
            BiFunction<Integer, MachineBuilder<MachineDefinition>, MachineDefinition> builder,
            int... tiers) {
        MachineDefinition[] definitions = new MachineDefinition[TIER_COUNT];
        for (int tier : tiers) {
            var register = registrate()
                    .machine(
                            VN[tier].toLowerCase(Locale.ROOT) + "_" + name, holder -> factory.apply(holder, tier))
                    .tier(tier);
            definitions[tier] = builder.apply(tier, register);
        }
        return definitions;
    }

    public static MultiblockMachineDefinition[] registerTieredEPMultis(
            String name,
            BiFunction<IMachineBlockEntity, Integer, MultiblockControllerMachine> factory,
            BiFunction<Integer, MultiblockMachineBuilder, MultiblockMachineDefinition> builder,
            int... tiers) {
        MultiblockMachineDefinition[] definitions = new MultiblockMachineDefinition[TIER_COUNT];
        for (int tier : tiers) {
            var register = registrate()
                    .multiblock(
                            VN[tier].toLowerCase(Locale.ROOT) + "_" + name, holder -> factory.apply(holder, tier))
                    .tier(tier);
            definitions[tier] = builder.apply(tier, register);
        }
        return definitions;
    }
}
