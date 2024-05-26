package cn.gtcommunity.epimorphism.api.data.chemical.material.properties;

import com.google.common.base.Preconditions;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.IMaterialProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.MaterialProperties;
import lombok.Getter;

public class CatalystProperty implements IMaterialProperty<CatalystProperty> {
    @Getter
    private int maxDurability;

    public CatalystProperty(int maxDurability) {
        this.maxDurability = maxDurability;
    }

    public void setMaxDurability(int maxDurability) {
        Preconditions.checkArgument(maxDurability > 0, "Invalid Max Durability");
        this.maxDurability = maxDurability;
    }

    @Override
    public void verifyProperty(MaterialProperties materialProperties) {

    }
}
