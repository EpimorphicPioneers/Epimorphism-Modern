package cn.gtcommunity.epimorphism.common.data.machine;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.api.machine.multiblock.EPPartAbility;
import cn.gtcommunity.epimorphism.api.pattern.EPPredicates;
import cn.gtcommunity.epimorphism.client.renderer.handler.machine.TankMachineRenderer;
import cn.gtcommunity.epimorphism.common.machine.multiblock.electric.agriculture.IndustrialFishingPondMachine;
import cn.gtcommunity.epimorphism.common.machine.multiblock.electric.biology.BacterialCultureTankMachine;
import cn.gtcommunity.epimorphism.common.machine.multiblock.electric.biology.FermentationTankMachine;
import cn.gtcommunity.epimorphism.common.machine.multiblock.noenergy.AlgaeFarmMachine;
import com.epimorphismmc.monomorphism.pattern.FactoryMOPattern;
import com.epimorphismmc.monomorphism.pattern.MOBlockPattern;
import com.epimorphismmc.monomorphism.pattern.utils.StructureUtil;
import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.MultiblockShapeInfo;
import com.gregtechceu.gtceu.api.recipe.OverclockingLogic;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.GTRecipeModifiers;
import net.minecraft.network.chat.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static cn.gtcommunity.epimorphism.Epimorphism.registrate;
import static cn.gtcommunity.epimorphism.common.data.EPBlocks.*;
import static cn.gtcommunity.epimorphism.common.data.EPBlocks.BREEDING_CASING;
import static cn.gtcommunity.epimorphism.common.block.BlockMaps.SHAPE_GLASSES;
import static cn.gtcommunity.epimorphism.common.data.EPRecipeTypes.FERMENTATION_TANK_RECIPES;
import static com.epimorphismmc.monomorphism.block.MOBlockMaps.ALL_MACHINE_CASINGS;
import static com.epimorphismmc.monomorphism.pattern.MOPredicates.machineCasingBlock;
import static com.gregtechceu.gtceu.api.pattern.Predicates.*;
import static com.gregtechceu.gtceu.common.data.GTBlocks.CASING_POLYTETRAFLUOROETHYLENE_PIPE;
import static com.gregtechceu.gtceu.common.data.GTBlocks.CASING_STAINLESS_CLEAN;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.DUMMY_RECIPES;

public class BiologyMachines {

    public final static MultiblockMachineDefinition ALGAE_FARM = registrate().multiblock("algae_farm", AlgaeFarmMachine::new)
            .langValue("Algae Farm")
            .tooltips(
            )
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(DUMMY_RECIPES)
            .recipeModifier(GTRecipeModifiers.ELECTRIC_OVERCLOCK.apply(OverclockingLogic.NON_PERFECT_OVERCLOCK))
            .appearanceBlock(FARM_CASING)
            .pattern(definition -> FactoryMOPattern.start()
                    .aisle("XXXXXXXXX", "CCCCCCCCC", "CCCCCCCCC")
                    .aisle("XMMMMMMMX", "C#######C", "C#######C")
                    .aisle("XMMMMMMMX", "C#######C", "C#######C")
                    .aisle("XMMMMMMMX", "C#######C", "C#######C")
                    .aisle("XMMMMMMMX", "C#######C", "C#######C")
                    .aisle("XMMMMMMMX", "C#######C", "C#######C")
                    .aisle("XMMMMMMMX", "C#######C", "C#######C")
                    .aisle("XMMMMMMMX", "C#######C", "C#######C")
                    .aisle("XXXXSXXXX", "CCCCCCCCC", "CCCCCCCCC")
                    .where('S', controller(blocks(definition.getBlock())))
                    .where('X', blocks(FARM_CASING.get()).setMinGlobalLimited(18)
                            .or(abilities(PartAbility.EXPORT_ITEMS).setMinGlobalLimited(1))
                            .or(abilities(PartAbility.IMPORT_FLUIDS).setMaxGlobalLimited(1)))
                    .where('C', blocks(FARM_CASING.get()))
                    .where('M', machineCasingBlock())
                    .where('#', any())
                    .build()
            )
            .shapeInfos(definition -> {
                List<MultiblockShapeInfo> shapeInfos = new ArrayList<>();
                shapeInfos.addAll(StructureUtil.getMatchingShapes((MOBlockPattern) definition.getPatternFactory().get(), ALL_MACHINE_CASINGS.size()));
                return shapeInfos;
            })
            .partSorter(Comparator.comparingInt(a -> a.self().getPos().getY()))
            .workableCasingRenderer(Epimorphism.id("block/casings/solid/farm_casing"),
                    Epimorphism.id("block/multiblock/algae_farm"), false)
            .register();
    public final static MultiblockMachineDefinition INDUSTRIAL_FISHING_POND = registrate().multiblock("industrial_fishing_pond", IndustrialFishingPondMachine::new)
            .langValue("Industrial Fishing Pond")
            .tooltips(
                    Component.translatable("block.epimorphism.industrial_fishing_pond.desc.0"),
                    Component.translatable("block.epimorphism.industrial_fishing_pond.desc.1"),
                    Component.translatable("block.epimorphism.industrial_fishing_pond.desc.2"),
                    Component.translatable("block.epimorphism.industrial_fishing_pond.desc.3"),
                    Component.translatable("block.epimorphism.industrial_fishing_pond.desc.4"),
                    Component.translatable("block.epimorphism.industrial_fishing_pond.desc.5")
            )
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(DUMMY_RECIPES)
            .recipeModifier(GTRecipeModifiers.ELECTRIC_OVERCLOCK.apply(OverclockingLogic.NON_PERFECT_OVERCLOCK))
            .appearanceBlock(BREEDING_CASING)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("EEEEEEEEE", "XXXXXXXXX", "XXXXXXXXX")
                    .aisle("EXXXXXXXE", "X#######X", "X#######X")
                    .aisle("EXXXXXXXE", "X#######X", "X#######X")
                    .aisle("EXXXXXXXE", "X#######X", "X#######X")
                    .aisle("EXXXXXXXE", "X#######X", "X#######X")
                    .aisle("EXXXXXXXE", "X#######X", "X#######X")
                    .aisle("EXXXXXXXE", "X#######X", "X#######X")
                    .aisle("EXXXXXXXE", "X#######X", "X#######X")
                    .aisle("EEEEEEEEE", "XXXXSXXXX", "XXXXXXXXX")
                    .where('S', controller(blocks(definition.getBlock())))
                    .where('X', blocks(BREEDING_CASING.get()).setMinGlobalLimited(106)
                            .or(abilities(PartAbility.EXPORT_ITEMS).setMinGlobalLimited(1))
                            .or(abilities(PartAbility.IMPORT_FLUIDS).setMaxGlobalLimited(1))
                            .or(abilities(PartAbility.MAINTENANCE).setExactLimit(1)))
                    .where('E', blocks(BREEDING_CASING.get())
                            .or(abilities(PartAbility.INPUT_ENERGY).setMinGlobalLimited(1).setMaxGlobalLimited(3)))
                    .where('#', any())
                    .build())
            .partSorter(Comparator.comparingInt(a -> a.self().getPos().getY()))
            .workableCasingRenderer(Epimorphism.id("block/casings/solid/breeding_casing"),
                    Epimorphism.id("block/multiblock/industrial_fishing_pond"), false)
            .register();

    public final static MultiblockMachineDefinition BACTERIAL_CULTURE_TANK = registrate().multiblock("bacterial_culture_tank", BacterialCultureTankMachine::new)
            .langValue("Bacterial Culture Tank")
            .tooltips(Component.translatable("block.epimorphism.bacterial_culture_tank.desc.0"))
            .rotationState(RotationState.ALL)
            .recipeType(DUMMY_RECIPES)
            .appearanceBlock(CASING_STAINLESS_CLEAN)
            .pattern(definition -> FactoryMOPattern.start()
                    .aisle("AAAAA", "CCCCC", "CCCCC", "AAAAA")
                    .aisle("AAAAA", "C   C", "C   C", "AAAAA")
                    .aisle("AAAAA", "C   C", "C   C", "AAAAA")
                    .aisle("AAAAA", "C   C", "C   C", "AAAAA")
                    .aisle("AABAA", "CCCCC", "CCCCC", "AAAAA")
                    .where('B', controller(blocks(definition.getBlock())))
                    .where('A', blocks(CASING_STAINLESS_CLEAN.get()).setMinGlobalLimited(19)
                            .or(abilities(PartAbility.IMPORT_FLUIDS).setMinGlobalLimited(1))
                            .or(abilities(PartAbility.EXPORT_FLUIDS).setMinGlobalLimited(1))
                            .or(abilities(PartAbility.IMPORT_ITEMS).setMinGlobalLimited(1))
                            .or(abilities(PartAbility.INPUT_ENERGY).setMinGlobalLimited(1))
                            .or(abilities(EPPartAbility.RADIATION).setExactLimit(1))
                            .or(abilities(PartAbility.MAINTENANCE).setExactLimit(1)))
                    .where('C', EPPredicates.glass())
                    .build()
            )
            .shapeInfos(definition -> {
                List<MultiblockShapeInfo> shapeInfos = new ArrayList<>();
                shapeInfos.addAll(StructureUtil.getMatchingShapes((MOBlockPattern) definition.getPatternFactory().get(), SHAPE_GLASSES.size()));
                return shapeInfos;
            })
            .partSorter(Comparator.comparingInt(a -> a.self().getPos().getY()))
            .renderer(() -> new TankMachineRenderer(GTCEu.id("block/casings/solid/machine_casing_clean_stainless_steel"),
                    Epimorphism.id("block/multiblock/bacterial_culture_tank")))
            .hasTESR(true)
            .register();
    public final static MultiblockMachineDefinition FERMENTATION_TANK = registrate().multiblock("fermentation_tank", FermentationTankMachine::new)
            .langValue("Fermentation Tank")
            .tooltips(Component.translatable("block.epimorphism.fermentation_tank.desc.0"))
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(FERMENTATION_TANK_RECIPES)
            .appearanceBlock(CASING_STAINLESS_CLEAN)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("FAAAF", "FXXXF", "FXGXF", "FXGXF", "FXGXF", "FXXXF", "AAAAA")
                    .aisle("AXXXA", "XEEEX", "XEEEX", "XEEEX", "XEEEX", "XEEEX", "AXXXA")
                    .aisle("AXXXA", "XEPEX", "GEPEG", "GEPEG", "GEPEG", "XEPEX", "AXXXA")
                    .aisle("AXXXA", "XEEEX", "XEEEX", "XEEEX", "XEEEX", "XEEEX", "AXXXA")
                    .aisle("FAAAF", "FXSXF", "FXGXF", "FXGXF", "FXGXF", "FXXXF", "AAAAA")
                    .where('S', controller(blocks(definition.getBlock())))
                    .where('X', blocks(CASING_STAINLESS_CLEAN.get()).setMinGlobalLimited(42).or(autoAbilities(FERMENTATION_TANK_RECIPES)))
                    .where('G', blocks(OSMIR_BORON_SILICATE_GLASS.get()))
                    .where('F', frames(GTMaterials.WatertightSteel))
                    .where('P', blocks(CASING_POLYTETRAFLUOROETHYLENE_PIPE.get()))
                    .where('A', any())
                    .where('E', air())
                    .build())
            .partSorter(Comparator.comparingInt(a -> a.self().getPos().getY()))
            .workableCasingRenderer(GTCEu.id("block/casings/solid/machine_casing_clean_stainless_steel"),
                    Epimorphism.id("block/multiblock/fermentation_tank"), false)
            .register();

    public static void init() {

    }
}
