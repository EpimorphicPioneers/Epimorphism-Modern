package cn.gtcommunity.epimorphism.api.data.chemical.material.properties;

import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;

public class EPPropertyKeys {
    public static final PropertyKey<GrindBallProperty> GRIND_BALL = new PropertyKey<>("grind_ball", GrindBallProperty.class);
    public static final PropertyKey<CrucibleProperty> CRUCIBLE = new PropertyKey<>("crucible", CrucibleProperty.class);
    public static final PropertyKey<FenceProperty> FENCE = new PropertyKey<>("fence", FenceProperty.class);
}
