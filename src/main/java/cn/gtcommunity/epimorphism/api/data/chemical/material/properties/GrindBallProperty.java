package cn.gtcommunity.epimorphism.api.data.chemical.material.properties;

import com.gregtechceu.gtceu.api.data.chemical.material.properties.IMaterialProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.MaterialProperties;
import com.gregtechceu.gtceu.api.item.component.ICustomRenderer;
import com.lowdragmc.lowdraglib.Platform;
import lombok.Getter;
import net.minecraft.resources.ResourceLocation;

public class GrindBallProperty implements IMaterialProperty<GrindBallProperty> {

    @Getter
    private float yieldMultiplier;
    @Getter
    private float energyConsumptionMultiplier;
    @Getter
    private int durability;

    @Getter
    private ResourceLocation model;
    @Getter
    private ICustomRenderer renderer;

    public GrindBallProperty(float yieldMultiplier, float energyConsumptionMultiplier, int durability) {
        this.yieldMultiplier = yieldMultiplier;
        this.energyConsumptionMultiplier = energyConsumptionMultiplier;
        this.durability = durability;
    }

    public void setYieldMultiplier(float yieldMultiplier) {
        if (yieldMultiplier <= 0) throw new IllegalArgumentException("Yield Multiplier must be greater than zero!");
        this.yieldMultiplier = yieldMultiplier;
    }

    public void setEnergyConsumptionMultiplier(float energyConsumptionMultiplier) {
        if (energyConsumptionMultiplier <= 0) throw new IllegalArgumentException("Energy Consumption Multiplier must be greater than zero!");
        this.energyConsumptionMultiplier = energyConsumptionMultiplier;
    }

    public void setDurability(int durability) {
        if (durability <= 0) throw new IllegalArgumentException("Durability must be greater than zero!");
        this.durability = durability;
    }

    public GrindBallProperty model(ResourceLocation model) {
        if (Platform.isClient()) this.model = model;
        return this;
    }

    public GrindBallProperty renderer(ICustomRenderer renderer) {
        if (Platform.isClient()) this.renderer = renderer;
        return this;
    }

    @Override
    public void verifyProperty(MaterialProperties materialProperties) {

    }
}
