package cn.gtcommunity.epimorphism.common.data.machine;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.api.pattern.EPPredicates;
import cn.gtcommunity.epimorphism.common.data.EPBlocks;
import cn.gtcommunity.epimorphism.common.data.EPMachines;
import cn.gtcommunity.epimorphism.common.data.EPMaterials;
import cn.gtcommunity.epimorphism.common.machine.multiblock.generator.*;
import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IRotorHolderMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.TraceabilityPredicate;
import com.gregtechceu.gtceu.api.pattern.predicates.SimplePredicate;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.machine.multiblock.generator.LargeTurbineMachine;
import com.lowdragmc.lowdraglib.utils.BlockInfo;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

import static cn.gtcommunity.epimorphism.Epimorphism.registrate;
import static cn.gtcommunity.epimorphism.common.data.EPBlocks.*;
import static cn.gtcommunity.epimorphism.common.data.EPRecipeTypes.*;
import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.machine.multiblock.PartAbility.*;
import static com.gregtechceu.gtceu.api.pattern.Predicates.*;
import static com.gregtechceu.gtceu.common.data.GTBlocks.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;
import static com.gregtechceu.gtceu.utils.FormattingUtil.toRomanNumeral;

public class GeneratorMachines {

    public static final MultiblockMachineDefinition LARGE_NAQUADAH_REACTOR = registrate().multiblock("large_naquadah_reactor", LargeNaquadahReactorMachine::new)
            .langValue("Large Naquadah Reactor")
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeTypes(LARGE_NAQUADAH_REACTOR_FUELS, LARGE_NAQUADAH_COOLANT_LIST, LARGE_NAQUADAH_EXCITED_FLUID_LIST)
            .appearanceBlock(EPBlocks.RADIATION_PROOF_MACHINE_CASING)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("AAAAAAA", "VBBBBBV", "VVVVVVV", "B#####B", "B#####B", "B#####B", "B#####B", "VVVVVVV")
                    .aisle("AAAAAAA", "B#####B", "V#####V", "#######", "#######", "#######", "#######", "VVVVVVV")
                    .aisle("AAAAAAA", "B#CCC#B", "V#CCC#V", "##CCC##", "##CCC##", "##CCC##", "##CCC##", "VVVVVVV")
                    .aisle("AAAAAAA", "B#CCC#B", "V#CDC#V", "##CDC##", "##CDC##", "##CDC##", "##CDC##", "VVVVVVV")
                    .aisle("AAAAAAA", "B#CCC#B", "V#CCC#V", "##CCC##", "##CCC##", "##CCC##", "##CCC##", "VVVVVVV")
                    .aisle("AAAAAAA", "B#####B", "V#####V", "#######", "#######", "#######", "#######", "VVVVVVV")
                    .aisle("AAASAAA", "VBBBBBV", "VVVVVVV", "B#####B", "B#####B", "B#####B", "B#####B", "VVVVVVV")
                    .where("S", controller(blocks(definition.get())))
                    .where("V", blocks(EPBlocks.RADIATION_PROOF_MACHINE_CASING.get()))
                    .where("A", blocks(EPBlocks.RADIATION_PROOF_MACHINE_CASING.get())
                            .or(autoAbilities(true, false, false))
                            .or(abilities(PartAbility.OUTPUT_ENERGY).setMinGlobalLimited(1, 1))
                            .or(abilities(PartAbility.IMPORT_FLUIDS).setPreviewCount(1))
                            .or(abilities(PartAbility.EXPORT_FLUIDS).setPreviewCount(1)))
                    .where("B", blocks(ChemicalHelper.getBlock(TagPrefix.frameGt, EPMaterials.RadiationProtection)))
                    .where("C", blocks(EPBlocks.CONSTRAINT_CASING.get()))
                    .where("D", blocks(GTBlocks.CASING_TUNGSTENSTEEL_PIPE.get()))
                    .where("#", air())
                    .build())
            .workableCasingRenderer(Epimorphism.id("block/casings/solid/radiation_proof_machine_casing"),
                    Epimorphism.id("block/multiblock/generator/large_naquadah_reactor"), false)
            .register();
    public static final MultiblockMachineDefinition UNIVERSAL_CHEMICAL_FUEL_ENGINE = registrate().multiblock("universal_chemical_fuel_engine", UniversalChemicalFuelEngineMachine::new)
            .langValue("Universal Chemica Fuel Engine")
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeTypes(COMBUSTION_GENERATOR_FUELS, GAS_TURBINE_FUELS, ROCKET_ENGINE_FUELS)
            .appearanceBlock(CASING_TITANIUM_STABLE)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("AAAAA", "AABAA", "AAAAA", "AAAAA")
                    .aisle("AAAAA", "CDEEF", "CDGGF", "AAHHA")
                    .aisle("AAAAA", "CDEEF", "CDGGF", "AAHHA")
                    .aisle("AAAAA", "CDEEF", "CDGGF", "AAHHA")
                    .aisle("AAAAA", "CDEEF", "CDGGF", "AAHHA")
                    .aisle("AAAAA", "CDEEF", "CDGGF", "AAHHA")
                    .aisle("AAAAA", "CDEEF", "CDGGF", "AAHHA")
                    .aisle("AAAAA", "CDEEF", "CDGGF", "AAHHA")
                    .aisle("AAIAA", "AASAA", "AAAAA", "AAAAA")
                    .where("S", controller(blocks(definition.get())))
                    .where("A", blocks(CASING_TITANIUM_STABLE.get()))
                    .where("B", abilities(OUTPUT_ENERGY))
                    .where("C", blocks(CASING_TITANIUM_STABLE.get())
                            .or(abilities(IMPORT_FLUIDS).setMinGlobalLimited(1).setPreviewCount(14)))
                    .where("D", blocks(CASING_TITANIUM_PIPE.get()))
                    .where("E", blocks(CASING_TITANIUM_GEARBOX.get()))
                    .where("F", blocks(CASING_ENGINE_INTAKE.get()))
                    .where("G", blocks(TITANIUM_PLATED_CYLINDER.get()))
                    .where("H", abilities(MUFFLER))
                    .where("I", abilities(MAINTENANCE))
                    .build())
            .workableCasingRenderer(GTCEu.id("block/casings/solid/machine_casing_stable_titanium"),
                    Epimorphism.id("block/multiblock/generator/universal_chemical_fuel_engine"), false)
            .register();
    public static final MultiblockMachineDefinition ROCKET_ENGINE_F1A = registrate().multiblock("rocket_engine_f1a", RocketEngineMachine::new)
            .langValue("Rocket Engine F-1A")
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeTypes(ROCKET_ENGINE_FUELS)
            .appearanceBlock(TURBO_ENGINE_CASING)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("AAA", "ACA", "ABA")
                    .aisle("ABA", "BDB", "ABA")
                    .aisle("ABA", "BDB", "ABA")
                    .aisle("ABA", "BDB", "ABA")
                    .aisle("ABA", "BDB", "ABA")
                    .aisle("ABA", "BDB", "ABA")
                    .aisle("ABA", "BDB", "ABA")
                    .aisle("ABA", "BDB", "ABA")
                    .aisle("ABA", "BDB", "ABA")
                    .aisle("AAA", "ASA", "ABA")
                    .where("S", controller(blocks(definition.get())))
                    .where("A", blocks(TURBO_ENGINE_CASING.get()))
                    .where("B", blocks(TURBO_ENGINE_CASING.get())
                            .or(abilities(IMPORT_FLUIDS).setMinGlobalLimited(1, 9))
                            .or(abilities(OUTPUT_ENERGY).setMinGlobalLimited(1).setMaxGlobalLimited(3))
                            .or(abilities(MAINTENANCE).setExactLimit(1)))
                    .where("C", abilities(MUFFLER))
                    .where("D", blocks(CASING_TURBO_ENGINE_GEARBOX.get()))
                    .build())
            .workableCasingRenderer(Epimorphism.id("block/casings/solid/turbo_engine_casing"),
                    Epimorphism.id("block/multiblock/generator/rocket_engine_f1a"), false)
            .register();
    public static final MultiblockMachineDefinition[] SOLID_OXIDE_FUEL_CELL = EPMachines.registerTieredEPMultis("solid_oxide_fuel_cell", SolidOxideFuelCellMachine::new, (tier, builder) -> builder
            .rotationState(RotationState.NON_Y_AXIS)
            .langValue("Solid Oxide Fuel Cell MK %s".formatted(toRomanNumeral(SolidOxideFuelCellMachine.getTier(tier))))
            .recipeType(GAS_TURBINE_FUELS)
            .tooltips()
            .appearanceBlock(() -> SolidOxideFuelCellMachine.getCasingState(tier))
            .pattern((definition) -> FactoryBlockPattern.start()
                    .aisle("AAA", "ADA", "AAA")
                    .aisle("AAA", "BCB", "AAA")
                    .aisle("AAA", "BCB", "AAA")
                    .aisle("AAA", "BCB", "AAA")
                    .aisle("AAA", "ASA", "AAA")
                    .where('S', controller(blocks(definition.get())))
                    .where('A', blocks(SolidOxideFuelCellMachine.getCasingState(tier))
                            .or(abilities(IMPORT_FLUIDS))
                            .or(abilities(EXPORT_FLUIDS))
                            .or(abilities(MAINTENANCE).setExactLimit(1)))
                    .where('B', blocks(CASING_LAMINATED_GLASS.get()))
                    .where('C', blocks(SolidOxideFuelCellMachine.getElectrolyteUnitState(tier)))
                    .where('D', abilities(OUTPUT_ENERGY))
                    .build())
            .workableCasingRenderer(SolidOxideFuelCellMachine.getTexture(tier),
                    Epimorphism.id("block/multiblock/generator/solid_oxide_fuel_cell"), false)
            .register(), HV, IV);
    public static final MultiblockMachineDefinition HIGH_PRESSURE_STEAM_TURBINE = registerEPLargeTurbine("high_pressure_steam_turbine", EV,
            HIGH_PRESSURE_STEAM_TURBINE_FUELS,
            CASING_TITANIUM_TURBINE, CASING_TITANIUM_GEARBOX,
            GTCEu.id("block/casings/solid/machine_casing_stable_titanium"),
            Epimorphism.id("block/multiblock/generator/high_pressure_steam_turbine"));
    public static final MultiblockMachineDefinition SUPERCRITICAL_STEAM_TURBINE = registerEPLargeTurbine("supercritical_steam_turbine", LuV,
            SUPERCRITICAL_STEAM_TURBINE_FUELS,
            CASING_SUPERCRITICAL_FLUID_TURBINE, CASING_SUPERCRITICAL_FLUID_GEARBOX,
            Epimorphism.id("block/casings/mechanic/machine_casing_turbine_supercritical_fluid"),
            Epimorphism.id("block/multiblock/generator/supercritical_steam_turbine"));
    public final static MultiblockMachineDefinition STEAM_MEGA_TURBINE = registerMegaTurbine("steam_mega_turbine", IV,
            STEAM_TURBINE_FUELS,
            CASING_STEEL_TURBINE, CASING_STEEL_GEARBOX,
            GTCEu.id("block/casings/solid/machine_casing_solid_steel"),
            GTCEu.id("block/multiblock/generator/large_steam_turbine"));
    public final static MultiblockMachineDefinition GAS_MEGA_TURBINE = registerMegaTurbine("gas_mega_turbine", LuV,
            GAS_TURBINE_FUELS,
            CASING_STAINLESS_CLEAN, CASING_STAINLESS_STEEL_GEARBOX,
            GTCEu.id("block/casings/solid/machine_casing_clean_stainless_steel"),
            GTCEu.id("block/multiblock/generator/large_gas_turbine"));
    public final static MultiblockMachineDefinition PLASMA_MEGA_TURBINE = registerMegaTurbine("plasma_mega_turbine", ZPM,
            PLASMA_GENERATOR_FUELS,
            CASING_TUNGSTENSTEEL_TURBINE, CASING_TUNGSTENSTEEL_GEARBOX,
            GTCEu.id("block/casings/solid/machine_casing_robust_tungstensteel"),
            GTCEu.id("block/multiblock/generator/large_plasma_turbine"));
    public static final MultiblockMachineDefinition HIGH_PRESSURE_STEAM_MEGA_TURBINE = registerMegaTurbine("high_pressure_steam_mega_turbine", LuV,
            HIGH_PRESSURE_STEAM_TURBINE_FUELS,
            CASING_TITANIUM_TURBINE, CASING_TITANIUM_GEARBOX,
            GTCEu.id("block/casings/solid/machine_casing_stable_titanium"),
            Epimorphism.id("block/multiblock/generator/high_pressure_steam_turbine"));
    public static final MultiblockMachineDefinition SUPERCRITICAL_STEAM_MEGA_TURBINE = registerMegaTurbine("supercritical_steam_mega_turbine", UV,
            SUPERCRITICAL_STEAM_TURBINE_FUELS,
            CASING_SUPERCRITICAL_FLUID_TURBINE, CASING_SUPERCRITICAL_FLUID_GEARBOX,
            Epimorphism.id("block/casings/mechanic/machine_casing_turbine_supercritical_fluid"),
            Epimorphism.id("block/multiblock/generator/supercritical_steam_turbine"));

    public static void init() {

    }

    public static MultiblockMachineDefinition registerEPLargeTurbine(String name, int tier, GTRecipeType recipeType, Supplier<? extends Block> casing, Supplier<? extends Block> gear, ResourceLocation casingTexture, ResourceLocation overlayModel) {
        return registrate().multiblock(name, holder -> new LargeTurbineMachine(holder, tier))
                .rotationState(RotationState.NON_Y_AXIS)
                .recipeType(recipeType)
                .recipeModifier(LargeTurbineMachine::recipeModifier, true)
                .appearanceBlock(casing)
                .pattern(definition -> FactoryBlockPattern.start()
                        .aisle("CCCC", "CHHC", "CCCC")
                        .aisle("CHHC", "RGGR", "CHHC")
                        .aisle("CCCC", "CSHC", "CCCC")
                        .where('S', controller(blocks(definition.getBlock())))
                        .where('G', blocks(gear.get()))
                        .where('C', blocks(casing.get()))
                        .where('R', new TraceabilityPredicate(new SimplePredicate(state -> MetaMachine.getMachine(state.getWorld(), state.getPos()) instanceof IRotorHolderMachine rotorHolder
                                && state.getWorld().getBlockState(state.getPos().relative(rotorHolder.self().getFrontFacing())).isAir(),
                                () -> PartAbility.ROTOR_HOLDER.getAllBlocks().stream().map(BlockInfo::fromBlock).toArray(BlockInfo[]::new)))
                                .addTooltips(Component.translatable("gtceu.multiblock.pattern.clear_amount_3"))
                                .addTooltips(Component.translatable("gtceu.multiblock.pattern.error.limited.1", VN[tier]))
                                .setExactLimit(1)
                                .or(abilities(PartAbility.OUTPUT_ENERGY)).setExactLimit(1))
                        .where('H', blocks(casing.get())
                                .or(autoAbilities(definition.getRecipeTypes(), false, false, true, true, true, true))
                                .or(autoAbilities(true, true, false)))
                        .build())
                .recoveryItems(() -> new ItemLike[]{GTItems.MATERIAL_ITEMS.get(TagPrefix.dustTiny, GTMaterials.Ash).get()})
                .workableCasingRenderer(casingTexture, overlayModel, false)
                .tooltips(
                        Component.translatable("gtceu.universal.tooltip.base_production_eut", V[tier] * 2),
                        Component.translatable("gtceu.multiblock.turbine.efficiency_tooltip", VNF[tier]))
                .register();
    }

    public static MultiblockMachineDefinition registerMegaTurbine(String name, int tier, GTRecipeType recipeType, Supplier<? extends Block> casing, Supplier<? extends Block> gear, ResourceLocation casingTexture, ResourceLocation overlayModel) {
        return registrate().multiblock(name, holder -> new MegaTurbineMachine(holder, tier))
                .rotationState(RotationState.NON_Y_AXIS)
                .recipeType(recipeType)
                .appearanceBlock(casing)
                .pattern(definition -> FactoryBlockPattern.start()
                        .aisle("AAAAAAA", "AAAAAAA", "AAAAAAA", "AAAAAAA", "AAAAAAA", "AAAAAAA", "AAAAAAA")
                        .aisle("AAAAAAA", "BDDDDDB", "AAAAAAA", "CAAAAAC", "AAAAAAA", "BDDDDDB", "AAAAAAA")
                        .aisle("AAAAAAA", "AAAAAAA", "AAAAAAA", "CAAAAAC", "AAAAAAA", "AAAAAAA", "AAAAAAA")
                        .aisle("AAAAAAA", "AAAAAAA", "AAAAAAA", "CAAAAAC", "AAAAAAA", "AAAAAAA", "AAAAAAA")
                        .aisle("AAAAAAA", "BDDDDDB", "AAAAAAA", "CAAAAAC", "AAAAAAA", "BDDDDDB", "AAAAAAA")
                        .aisle("AAAAAAA", "AAAAAAA", "AAAAAAA", "CAAAAAC", "AAAAAAA", "AAAAAAA", "AAAAAAA")
                        .aisle("AAAAAAA", "AAAAAAA", "AAAAAAA", "CAAAAAC", "AAAAAAA", "AAAAAAA", "AAAAAAA")
                        .aisle("AAAAAAA", "BDDDDDB", "AAAAAAA", "CAAAAAC", "AAAAAAA", "BDDDDDB", "AAAAAAA")
                        .aisle("AAAAAAA", "AAAAAAA", "AAEEEAA", "AAESEAA", "AAEEEAA", "AAAAAAA", "AAAAAAA")
                        .where('S', controller(blocks(definition.get())))
                        .where('A', blocks(casing.get()))
                        .where('D', blocks(gear.get()))
                        .where('B', EPPredicates.tierReinforcedRotorBlock())
                        .where('E', blocks(casing.get())
                                .or(abilities(MUFFLER).setMinGlobalLimited(1)))
                        .where('C', blocks(casing.get())
                                .or(abilities(OUTPUT_ENERGY).setMinGlobalLimited(1).setMaxGlobalLimited(2))
                                .or(abilities(MAINTENANCE).setExactLimit(1))
                                .or(abilities(IMPORT_ITEMS).setExactLimit(1))
                                .or(abilities(IMPORT_FLUIDS).setMinGlobalLimited(1).setMaxGlobalLimited(4))
                                .or(abilities(EXPORT_FLUIDS).setMinGlobalLimited(1).setMaxGlobalLimited(4)))
                        .build())
                .recoveryItems(() -> new ItemLike[]{GTItems.MATERIAL_ITEMS.get(TagPrefix.dustTiny, GTMaterials.Ash).get()})
                .workableCasingRenderer(casingTexture, overlayModel, false)
                .tooltips(
                        Component.translatable("gtceu.universal.tooltip.base_production_eut", V[tier] * 2),
                        Component.translatable("gtceu.multiblock.turbine.efficiency_tooltip", VNF[tier]))
                .register();
    }
}
