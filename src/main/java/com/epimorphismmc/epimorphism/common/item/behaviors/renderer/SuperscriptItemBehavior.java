package com.epimorphismmc.epimorphism.common.item.behaviors.renderer;

import com.epimorphismmc.epimorphism.config.EPConfigHolder;

import com.epimorphismmc.monomorphism.item.component.INumberSuperscriptEffect;
import com.epimorphismmc.monomorphism.item.component.IVoltageSuperscriptEffect;

public class SuperscriptItemBehavior {

    private SuperscriptItemBehavior() {
        /**/
    }

    public record Number(int tier) implements INumberSuperscriptEffect {
        @Override
        public boolean isRoma() {
            return EPConfigHolder.INSTANCE.items.perfRomanSubscript;
        }
    }

    public record Voltage(int tier) implements IVoltageSuperscriptEffect {
        /**/
    }
}
