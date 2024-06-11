package com.epimorphismmc.epimorphism.data.model;

import com.epimorphismmc.epimorphism.Epimorphism;

import net.minecraft.data.models.model.ModelTemplate;
import net.minecraft.data.models.model.TextureSlot;

import java.util.Optional;

public class EPModelTemplates {
    public static final ModelTemplate TINT_FENCE_POST =
            create("fence_post", "_post", TextureSlot.TEXTURE);
    public static final ModelTemplate TINT_FENCE_SIDE =
            create("fence_side", "_side", TextureSlot.TEXTURE);
    public static final ModelTemplate TINT_FENCE_INVENTORY =
            create("fence_inventory", "_inventory", TextureSlot.TEXTURE);

    private static ModelTemplate create(
            String blockModelLocation, String suffix, TextureSlot... requiredSlots) {
        return new ModelTemplate(
                Optional.of(Epimorphism.id("block/" + blockModelLocation)),
                Optional.of(suffix),
                requiredSlots);
    }
}
