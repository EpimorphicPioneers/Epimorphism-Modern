package com.epimorphismmc.epimorphism.data;

import com.epimorphismmc.epimorphism.Epimorphism;
import com.epimorphismmc.epimorphism.common.data.EPConfiguredFeatures;
import com.epimorphismmc.epimorphism.data.lang.EPLangHandler;
import com.epimorphismmc.epimorphism.data.tag.EPTagHandler;

import com.epimorphismmc.monomorphism.registry.registrate.providers.MOProviderTypes;

import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import com.tterrag.registrate.providers.ProviderType;

import java.util.Set;

import static com.epimorphismmc.epimorphism.EpimorphismCommon.registrate;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    public static void init() {
        registrate().addDataGenerator(MOProviderTypes.MO_LANG, EPLangHandler::init);
        registrate().addDataGenerator(ProviderType.BLOCK_TAGS, EPTagHandler::block);
        registrate().addDataGenerator(ProviderType.ITEM_TAGS, EPTagHandler::item);
    }

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        var registries = event.getLookupProvider();

        if (event.includeServer()) {
            var set = Set.of(Epimorphism.MOD_ID);
            generator.addProvider(
                    true,
                    new DatapackBuiltinEntriesProvider(
                            packOutput,
                            registries,
                            new RegistrySetBuilder()
                                    .add(Registries.CONFIGURED_FEATURE, EPConfiguredFeatures::bootstrap),
                            set));
        }
    }
}
