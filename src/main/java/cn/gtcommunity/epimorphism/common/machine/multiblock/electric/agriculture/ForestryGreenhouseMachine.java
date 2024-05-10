package cn.gtcommunity.epimorphism.common.machine.multiblock.electric.agriculture;

/*
 * Referenced some code from GregTechFoodOption
 *
 * https://github.com/bruberu/GregTechFoodOption
 * */

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.config.EPConfigHolder;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

public class ForestryGreenhouseMachine extends WorkableElectricMultiblockMachine {

    public static Block[] GRASSES;

    public static void addGrasses() {
        var blockArray = EPConfigHolder.INSTANCE.machines.treeGrowthSimulatorDirts;
        GRASSES = new Block[blockArray.length];
        boolean errorsFound = false;

        for (int i = 0; i < GRASSES.length; i++) {
            String blockString = blockArray[i];
            final Block block = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(blockString));
            if (block == null) {
                Epimorphism.LOGGER.error("Block Parsing error for \"" + blockString + "\". Block does not exist!");
                errorsFound = true;
                continue;
            }
            GRASSES[i] = block;
        }

        if (errorsFound)
            throw new IllegalArgumentException("One or more errors were found with the Greenhouse Blocks configuration for Epimorphism. Check log above.");
    }

    public ForestryGreenhouseMachine(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
    }
}
