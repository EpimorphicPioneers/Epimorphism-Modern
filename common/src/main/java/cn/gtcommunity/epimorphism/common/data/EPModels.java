package cn.gtcommunity.epimorphism.common.data;

import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateItemModelProvider;
import com.tterrag.registrate.util.nullness.NonNullBiConsumer;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class EPModels {
    @ExpectPlatform
    public static <T extends Item> NonNullBiConsumer<DataGenContext<Item, T>, RegistrateItemModelProvider> wrapCircuitModel(ResourceLocation wrapped) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static void captureToolModel(DataGenContext<Item, ? extends Item> ctx, RegistrateItemModelProvider prov) {
        throw new AssertionError();
    }
}
