package com.epimorphismmc.epimorphism.api.data.chemical.material.properties;

import com.gregtechceu.gtceu.api.data.chemical.material.properties.IMaterialProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.MaterialProperties;

import com.google.common.base.Preconditions;
import lombok.Getter;

public class CrucibleProperty implements IMaterialProperty<CrucibleProperty> {

    @Getter
    private int heatCapacity;

    public CrucibleProperty(int heatCapacity) {
        this.heatCapacity = heatCapacity;
    }

    public void setTemperature(int heatCapacity) {
        Preconditions.checkArgument(heatCapacity > 0, "Invalid Heat Capacity");
        this.heatCapacity = heatCapacity;
    }

    @Override
    public void verifyProperty(MaterialProperties materialProperties) {}
}
