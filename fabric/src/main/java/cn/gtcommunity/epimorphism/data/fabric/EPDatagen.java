package cn.gtcommunity.epimorphism.data.fabric;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

//public class EPDatagen implements DataGeneratorEntrypoint {
//    @Override
//    public void onInitializeDataGenerator(FabricDataGenerator generator) {
//        // registrate
//        var rootPath = FabricLoader.getInstance().getGameDir().normalize().getParent().getParent();
//        ExistingFileHelper helper = ExistingFileHelper.withResources(
//                rootPath.resolve("common").resolve("src").resolve("main").resolve("resources"),
//                rootPath.resolve("fabric").resolve("src").resolve("main").resolve("resources"));
//        var pack = generator.createPack();
//        EPRegistries.EP_REGISTRATE.setupDatagen(pack, helper);
//        // sound
//        pack.addProvider((FabricDataOutput output) -> new SoundEntryBuilder.SoundEntryProvider(output, Epimorphism.MOD_ID));
//        // worldgen
//        var set = Set.of(GCyR.MOD_ID);
//        var registryAccess = RegistryAccess.fromRegistryOfRegistries(BuiltInRegistries.REGISTRY);
//        var registries = createProvider(registryAccess);
//        pack.addProvider(bindRegistries((output, provider) -> new GTRegistriesDatapackGenerator(
//                output, registries, new RegistrySetBuilder()
//                .add(Registries.BIOME, EPBiomes::bootstrap),
//                set, "Worldgen Data"), registries));
//    }
//
//    private static <T extends DataProvider> DataProvider.Factory<T> bindRegistries(
//            BiFunction<PackOutput, CompletableFuture<HolderLookup.Provider>, T> factory,
//            CompletableFuture<HolderLookup.Provider> factories) {
//        return packOutput -> factory.apply(packOutput, factories);
//    }
//
//    private static CompletableFuture<HolderLookup.Provider> createProvider(RegistryAccess registryAccess) {
//
//        var vanillaLookup = CompletableFuture.supplyAsync(VanillaRegistries::createLookup, Util.backgroundExecutor());
//
//        return vanillaLookup.thenApply(provider -> {
//            var builder = new RegistrySetBuilder()
//                    .add(Registries.NOISE, NoiseData::bootstrap)
//                    .add(Registries.BIOME, BiomeData::bootstrap);
//
//            return builder.buildPatch(registryAccess, provider);
//        });
//    }
//}
