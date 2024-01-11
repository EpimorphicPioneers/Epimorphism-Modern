package cn.gtcommunity.epimorphism.api.chemical.material.info;

import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlag;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;

public class EPMaterialFlags {

    public static final MaterialFlag GENERATE_COIL = new MaterialFlag.Builder("generate_coil")
            .requireFlags(MaterialFlags.GENERATE_FINE_WIRE)
            .build();
    public static final MaterialFlag GENERATE_CURVED_PLATE = new MaterialFlag.Builder("generate_curved_plate")
            .requireFlags(MaterialFlags.GENERATE_PLATE)
            .build();
    public static final MaterialFlag DISABLE_CRYSTALLIZATION = new MaterialFlag.Builder("no_crystallization")
            .requireFlags(MaterialFlags.CRYSTALLIZABLE)
            .requireProps(PropertyKey.GEM)
            .build();
    public static final MaterialFlag GENERATE_BOULE = new MaterialFlag.Builder("generate_boule")
            .requireProps(PropertyKey.GEM)
            .build();
}
