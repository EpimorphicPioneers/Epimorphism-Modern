package cn.gtcommunity.epimorphism.data.model;

import cn.gtcommunity.epimorphism.Epimorphism;
import com.tterrag.registrate.providers.RegistrateBlockstateProvider;
import net.minecraftforge.client.model.generators.loaders.ObjModelBuilder;

public class BlockStateHandler {
    public BlockStateHandler() {/**/}

    public static void init(RegistrateBlockstateProvider provider) {
        provider.models().getBuilder("block/obj/star_0").customLoader(ObjModelBuilder::begin)
                .modelLocation(Epimorphism.id("models/block/obj/star.obj"))
                .overrideMaterialLibrary(Epimorphism.id("models/block/obj/star_0.mtl"))
                .flipV(true)
                .end();
        provider.models().getBuilder("block/obj/star_1").customLoader(ObjModelBuilder::begin)
                .modelLocation(Epimorphism.id("models/block/obj/star.obj"))
                .overrideMaterialLibrary(Epimorphism.id("models/block/obj/star_1.mtl"))
                .flipV(true)
                .end();
        provider.models().getBuilder("block/obj/star_2").customLoader(ObjModelBuilder::begin)
                .modelLocation(Epimorphism.id("models/block/obj/star.obj"))
                .overrideMaterialLibrary(Epimorphism.id("models/block/obj/star_2.mtl"))
                .flipV(true)
                .end();
        provider.models().getBuilder("block/obj/space").customLoader(ObjModelBuilder::begin)
                .modelLocation(Epimorphism.id("models/block/obj/space.obj"))
                .flipV(true)
                .end();
        provider.models().getBuilder("block/obj/climber").customLoader(ObjModelBuilder::begin)
                .modelLocation(Epimorphism.id("models/block/obj/climber.obj"))
                .flipV(true)
                .end();
    }
}
