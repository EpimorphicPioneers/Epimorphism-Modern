package cn.gtcommunity.epimorphism;

import cn.gtcommunity.epimorphism.api.registry.EPRegistries;
import cn.gtcommunity.epimorphism.common.data.EPCreativeModeTabs;
import cn.gtcommunity.epimorphism.common.data.EPItems;
import cn.gtcommunity.epimorphism.common.data.EPMaterials;
import com.google.common.base.Suppliers;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.config.ConfigHolder;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrarManager;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Supplier;

public class Epimorphism {
    public static final String MOD_ID = "epimorphism";

    public static final String NAME = "Epimorphism";
    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);

    // We can use this if we don't want to use DeferredRegister
    public static final Supplier<RegistrarManager> REGISTRIES = Suppliers.memoize(() -> RegistrarManager.get(MOD_ID));

    // Registering a new creative tab
//    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(MOD_ID, Registries.CREATIVE_MODE_TAB);
//    public static final RegistrySupplier<CreativeModeTab> EXAMPLE_TAB = TABS.register("example_tab", () ->
//            CreativeTabRegistry.create(Component.translatable("itemGroup." + MOD_ID + ".example_tab"),
//                    () -> new ItemStack(Epimorphism.EXAMPLE_ITEM.get())));
    
//    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(MOD_ID, Registries.ITEM);
//    public static final RegistrySupplier<Item> EXAMPLE_ITEM = ITEMS.register("example_item", () ->
//            new Item(new Item.Properties().arch$tab(Epimorphism.EXAMPLE_TAB)));
    
    public static void init() {
        ConfigHolder.init();
//        TABS.register();
//        ITEMS.register();
        EPCreativeModeTabs.init();
        EPItems.init();


        EPRegistries.REGISTRATE.registerRegistrate();
        
        System.out.println(ExampleExpectPlatform.getConfigDirectory().toAbsolutePath().normalize().toString());
    }
}
