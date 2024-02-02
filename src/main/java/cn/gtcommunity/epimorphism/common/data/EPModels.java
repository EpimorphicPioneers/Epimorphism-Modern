package cn.gtcommunity.epimorphism.common.data;

import cn.gtcommunity.epimorphism.Epimorphism;
import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateItemModelProvider;
import com.tterrag.registrate.util.nullness.NonNullBiConsumer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ModelFile;

public class EPModels {
    public static <T extends Item> NonNullBiConsumer<DataGenContext<Item, T>, RegistrateItemModelProvider> wrapItemModel(ResourceLocation wrapped) {
        return (ctx, prov) -> prov.getBuilder("item/" + prov.name(ctx::getEntry)).parent(new ModelFile.UncheckedModelFile(Epimorphism.id("item/wrap_item")))
                .texture("layer0", wrapped)
                .texture("layer4", Epimorphism.id("item/wrap_overlay"));
    }

    public static <T extends Item> NonNullBiConsumer<DataGenContext<Item, T>, RegistrateItemModelProvider> simpleCustomModel(ResourceLocation modelLocation, ResourceLocation... textureLocations) {
        return (ctx, prov) -> {
            var builder = prov.getBuilder("item/" + prov.name(ctx::getEntry)).parent(new ModelFile.UncheckedModelFile(modelLocation));
            for (int i = 0; i < textureLocations.length; ++i) {
                builder.texture("layer%s".formatted(i), textureLocations[i]);
            }
        };
    }

    public static void captureToolModel(DataGenContext<Item, ? extends Item> ctx, RegistrateItemModelProvider prov) {
        // empty model
        prov.getBuilder("item/" + prov.name(ctx::getEntry) + "_empty").parent(new ModelFile.UncheckedModelFile("item/generated"))
                .texture("layer0", prov.modLoc("item/%s/empty".formatted(prov.name(ctx))));

        // filled model
        prov.getBuilder("item/" + prov.name(ctx::getEntry) + "_filled").parent(new ModelFile.UncheckedModelFile("item/generated"))
                .texture("layer0", prov.modLoc("item/%s/filled".formatted(prov.name(ctx))));

        // root model
        prov.generated(ctx::getEntry, prov.modLoc("item/%s/empty".formatted(prov.name(ctx))))
                .override().predicate(Epimorphism.id("organism_capture_tool"), 0)
                .model(new ModelFile.UncheckedModelFile(prov.modLoc("item/%s_empty".formatted(prov.name(ctx)))))
                .end()
                .override().predicate(Epimorphism.id("organism_capture_tool"), 1)
                .model(new ModelFile.UncheckedModelFile(prov.modLoc("item/%s_filled".formatted(prov.name(ctx)))))
                .end();
    }
}
