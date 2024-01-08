package cn.gtcommunity.epimorphism.data.fabric;

import cn.gtcommunity.epimorphism.api.registry.EPRegistries;
import io.github.fabricators_of_create.porting_lib.data.ExistingFileHelper;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.loader.api.FabricLoader;

public class EPDatagen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        // registrate
        var rootPath = FabricLoader.getInstance().getGameDir().normalize().getParent().getParent();
        ExistingFileHelper helper = ExistingFileHelper.withResources(
                rootPath.resolve("common").resolve("src").resolve("main").resolve("resources"),
                rootPath.resolve("fabric").resolve("src").resolve("main").resolve("resources"));
        var pack = generator.createPack();
        EPRegistries.EP_REGISTRATE.setupDatagen(pack, helper);
    }
}
