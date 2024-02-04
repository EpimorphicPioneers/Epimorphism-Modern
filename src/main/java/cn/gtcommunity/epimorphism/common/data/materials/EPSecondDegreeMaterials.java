package cn.gtcommunity.epimorphism.common.data.materials;

import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.api.fluids.FluidBuilder;
import com.gregtechceu.gtceu.api.fluids.attribute.FluidAttributes;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;

import static cn.gtcommunity.epimorphism.common.data.EPMaterials.*;

public class EPSecondDegreeMaterials {
    public static void init() {
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
    }
}
