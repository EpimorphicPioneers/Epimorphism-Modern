package com.epimorphismmc.epimorphism.common.data.materials;

import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.api.fluids.FluidBuilder;
import com.gregtechceu.gtceu.api.fluids.attribute.FluidAttributes;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;

import static com.epimorphismmc.epimorphism.common.data.EPMaterials.*;

public class EPSecondDegreeMaterials {
    public static void register() {
        //  25401 Dragon Breath
        DragonBreath = Builder("dragon_breath")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x9400D3)
                .buildAndRegister()
                .setFormula("Dc?", false);
        //  25402 Concentrate Dragon Breath
        ConcentrateDragonBreath = Builder("concentrate_dragon_breath")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0x9400D3)
                .buildAndRegister()
                .setFormula("Dc2?", true);
        //  25403 Dragon Blood
        DragonBlood = Builder("dragon_blood")
                .fluid()
                .color(0xDC2814)
                .iconSet(MaterialIconSet.DULL)
                .buildAndRegister()
                .setFormula("*Dc*Rn?", true);
        //  25404 Dragon Tear
        DragonTear = Builder("dragon_tear")
                .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(2992))
                .color(0x9999FF)
                .iconSet(MaterialIconSet.DULL)
                .buildAndRegister()
                .setFormula("⚙", false);

        ConcreteBlack = Builder("black_concrete")
                .dust()
                .liquid(new FluidBuilder().temperature(286))
                .color(0x202020)
                .secondaryColor(0xbbbaba)
                .iconSet(ROUGH)
                .flags(DISABLE_SMALL_DUST, DISABLE_DECOMPOSITION, EXCLUDE_BLOCK_CRAFTING_BY_HAND_RECIPES)
                .components(Stone, 1)
                .buildAndRegister();

        ConcreteRed = Builder("red_concrete")
                .dust()
                .liquid(new FluidBuilder().temperature(286))
                .color(0xAA0000)
                .secondaryColor(0xbbbaba)
                .iconSet(ROUGH)
                .flags(DISABLE_SMALL_DUST, DISABLE_DECOMPOSITION, EXCLUDE_BLOCK_CRAFTING_BY_HAND_RECIPES)
                .components(Stone, 1)
                .buildAndRegister();

        ConcreteGreen = Builder("green_concrete")
                .dust()
                .liquid(new FluidBuilder().temperature(286))
                .color(0x00AA00)
                .secondaryColor(0xbbbaba)
                .iconSet(ROUGH)
                .flags(DISABLE_SMALL_DUST, DISABLE_DECOMPOSITION, EXCLUDE_BLOCK_CRAFTING_BY_HAND_RECIPES)
                .components(Stone, 1)
                .buildAndRegister();

        ConcreteBrown = Builder("brown_concrete")
                .dust()
                .liquid(new FluidBuilder().temperature(286))
                .color(0x604000)
                .secondaryColor(0xbbbaba)
                .iconSet(ROUGH)
                .flags(DISABLE_SMALL_DUST, DISABLE_DECOMPOSITION, EXCLUDE_BLOCK_CRAFTING_BY_HAND_RECIPES)
                .components(Stone, 1)
                .buildAndRegister();

        ConcreteBlue = Builder("blue_concrete")
                .dust()
                .liquid(new FluidBuilder().temperature(286))
                .color(0x0000AA)
                .secondaryColor(0xbbbaba)
                .iconSet(ROUGH)
                .flags(DISABLE_SMALL_DUST, DISABLE_DECOMPOSITION, EXCLUDE_BLOCK_CRAFTING_BY_HAND_RECIPES)
                .components(Stone, 1)
                .buildAndRegister();

        ConcretePurple = Builder("purple_concrete")
                .dust()
                .liquid(new FluidBuilder().temperature(286))
                .color(0xAA00AA)
                .secondaryColor(0xbbbaba)
                .iconSet(ROUGH)
                .flags(DISABLE_SMALL_DUST, DISABLE_DECOMPOSITION, EXCLUDE_BLOCK_CRAFTING_BY_HAND_RECIPES)
                .components(Stone, 1)
                .buildAndRegister();

        ConcreteCyan = Builder("cyan_concrete")
                .dust()
                .liquid(new FluidBuilder().temperature(286))
                .color(0x00AAAA)
                .secondaryColor(0xbbbaba)
                .iconSet(ROUGH)
                .flags(DISABLE_SMALL_DUST, DISABLE_DECOMPOSITION, EXCLUDE_BLOCK_CRAFTING_BY_HAND_RECIPES)
                .components(Stone, 1)
                .buildAndRegister();

        ConcreteLightGray = Builder("light_gray_concrete")
                .dust()
                .liquid(new FluidBuilder().temperature(286))
                .color(0xAAAAAA)
                .secondaryColor(0xbbbaba)
                .iconSet(ROUGH)
                .flags(DISABLE_SMALL_DUST, DISABLE_DECOMPOSITION, EXCLUDE_BLOCK_CRAFTING_BY_HAND_RECIPES)
                .components(Stone, 1)
                .buildAndRegister();

        ConcreteGray = Builder("gray_concrete")
                .dust()
                .liquid(new FluidBuilder().temperature(286))
                .color(0x555555)
                .secondaryColor(0xbbbaba)
                .iconSet(ROUGH)
                .flags(DISABLE_SMALL_DUST, DISABLE_DECOMPOSITION, EXCLUDE_BLOCK_CRAFTING_BY_HAND_RECIPES)
                .components(Stone, 1)
                .buildAndRegister();

        ConcretePink = Builder("pink_concrete")
                .dust()
                .liquid(new FluidBuilder().temperature(286))
                .color(0xFFC0C0)
                .secondaryColor(0xbbbaba)
                .iconSet(ROUGH)
                .flags(DISABLE_SMALL_DUST, DISABLE_DECOMPOSITION, EXCLUDE_BLOCK_CRAFTING_BY_HAND_RECIPES)
                .components(Stone, 1)
                .buildAndRegister();

        ConcreteLime = Builder("lime_concrete")
                .dust()
                .liquid(new FluidBuilder().temperature(286))
                .color(0x80FF80)
                .secondaryColor(0xbbbaba)
                .iconSet(ROUGH)
                .flags(DISABLE_SMALL_DUST, DISABLE_DECOMPOSITION, EXCLUDE_BLOCK_CRAFTING_BY_HAND_RECIPES)
                .components(Stone, 1)
                .buildAndRegister();

        ConcreteYellow = Builder("yellow_concrete")
                .dust()
                .liquid(new FluidBuilder().temperature(286))
                .color(0xFFFF00)
                .secondaryColor(0xbbbaba)
                .iconSet(ROUGH)
                .flags(DISABLE_SMALL_DUST, DISABLE_DECOMPOSITION, EXCLUDE_BLOCK_CRAFTING_BY_HAND_RECIPES)
                .components(Stone, 1)
                .buildAndRegister();

        ConcreteLightBlue = Builder("light_blue_concrete")
                .dust()
                .liquid(new FluidBuilder().temperature(286))
                .color(0x6080FF)
                .secondaryColor(0xbbbaba)
                .iconSet(ROUGH)
                .flags(DISABLE_SMALL_DUST, DISABLE_DECOMPOSITION, EXCLUDE_BLOCK_CRAFTING_BY_HAND_RECIPES)
                .components(Stone, 1)
                .buildAndRegister();

        ConcreteMagenta = Builder("magenta_concrete")
                .dust()
                .liquid(new FluidBuilder().temperature(286))
                .color(0xFF00FF)
                .secondaryColor(0xbbbaba)
                .iconSet(ROUGH)
                .flags(DISABLE_SMALL_DUST, DISABLE_DECOMPOSITION, EXCLUDE_BLOCK_CRAFTING_BY_HAND_RECIPES)
                .components(Stone, 1)
                .buildAndRegister();

        ConcreteOrange = Builder("orange_concrete")
                .dust()
                .liquid(new FluidBuilder().temperature(286))
                .color(0xFF8000)
                .secondaryColor(0xbbbaba)
                .iconSet(ROUGH)
                .flags(DISABLE_SMALL_DUST, DISABLE_DECOMPOSITION, EXCLUDE_BLOCK_CRAFTING_BY_HAND_RECIPES)
                .components(Stone, 1)
                .buildAndRegister();

        ConcreteWhite = Builder("white_concrete")
                .dust()
                .liquid(new FluidBuilder().temperature(286))
                .color(0xFFFFFF)
                .secondaryColor(0xbbbaba)
                .iconSet(ROUGH)
                .flags(DISABLE_SMALL_DUST, DISABLE_DECOMPOSITION, EXCLUDE_BLOCK_CRAFTING_BY_HAND_RECIPES)
                .components(Stone, 1)
                .buildAndRegister();
    }
}
