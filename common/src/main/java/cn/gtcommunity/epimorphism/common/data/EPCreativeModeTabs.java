package cn.gtcommunity.epimorphism.common.data;

import com.gregtechceu.gtceu.common.data.GTCreativeModeTabs;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.world.item.CreativeModeTab;

import static cn.gtcommunity.epimorphism.api.registry.EPRegistries.*;

public class EPCreativeModeTabs {
    public final static RegistryEntry<CreativeModeTab> EP_ITEM = EP_REGISTRATE.defaultCreativeTab("item",
                    builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("item", EP_REGISTRATE))
                            .icon(EPItems.GOOWARE_BOARD::asStack)
                            .build())
                    .register();
    public final static RegistryEntry<CreativeModeTab> EP_BLOCK = EP_REGISTRATE.defaultCreativeTab("block",
                    builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("block", EP_REGISTRATE))
                            .icon(EPItems.GOOWARE_BOARD::asStack)
                            .build())
                    .register();

    public static void init() {/**/}
}
