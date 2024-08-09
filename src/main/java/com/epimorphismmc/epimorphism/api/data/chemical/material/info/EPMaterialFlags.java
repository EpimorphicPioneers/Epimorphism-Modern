package com.epimorphismmc.epimorphism.api.data.chemical.material.info;

import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlag;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;

public class EPMaterialFlags {
    public static final MaterialFlag DISABLE_CRYSTALLIZATION = new MaterialFlag.Builder(
                    "no_crystallization")
            .requireFlags(MaterialFlags.CRYSTALLIZABLE)
            .requireProps(PropertyKey.GEM)
            .build();
    public static final MaterialFlag GENERATE_BOULE =
            new MaterialFlag.Builder("generate_boule").requireProps(PropertyKey.GEM).build();
    public static final MaterialFlag GENERATE_MILLED =
            new MaterialFlag.Builder("generate_milled").requireProps(PropertyKey.ORE).build();
    public static final MaterialFlag GENERATE_NANITES = new MaterialFlag.Builder("generate_nanites")
            .requireProps(PropertyKey.DUST)
            .build();
    public static final MaterialFlag GENERATE_LASER_EMITTER = new MaterialFlag.Builder(
                    "generate_laser_emitter")
            .requireProps(PropertyKey.FLUID)
            .build();
    public static final MaterialFlag DISABLE_SMALL_DUST = new MaterialFlag.Builder(
                    "disable_small_dust")
            .requireProps(PropertyKey.DUST)
            .build();
}
