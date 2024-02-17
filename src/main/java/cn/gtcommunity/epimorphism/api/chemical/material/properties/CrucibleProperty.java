package cn.gtcommunity.epimorphism.api.chemical.material.properties;

import com.google.common.base.Preconditions;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.IMaterialProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.MaterialProperties;
import lombok.Getter;

public class CrucibleProperty implements IMaterialProperty<CrucibleProperty> {

    @Getter
    private int temperature;

    public CrucibleProperty(int temperature) {
        this.temperature = temperature;
    }

    public void setTemperature(int temperature) {
        Preconditions.checkArgument(temperature > 0, "Invalid temperature");
        this.temperature = temperature;
    }

    @Override
    public void verifyProperty(MaterialProperties materialProperties) {

    }
}
