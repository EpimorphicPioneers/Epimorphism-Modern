package cn.gtcommunity.epimorphism.common.data;

import cn.gtcommunity.epimorphism.Epimorphism;
import com.gregtechceu.gtceu.common.data.GTCreativeModeTabs;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.world.item.CreativeModeTab;

import static cn.gtcommunity.epimorphism.api.registry.EPRegistries.*;

public class EPCreativeModeTabs {
    public final static RegistryEntry<CreativeModeTab> EP_ITEM = REGISTRATE.defaultCreativeTab("item",
                    builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("item", REGISTRATE))
                            .icon(EPItems.GOOWARE_BOARD::asStack)
                            .build())
                    .register();
    public final static RegistryEntry<CreativeModeTab> EP_BLOCK = REGISTRATE.defaultCreativeTab("block",
                    builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("block", REGISTRATE))
                            .icon(EPItems.GOOWARE_BOARD::asStack)
                            .build())
                    .register();

    public static void init() {/**/}
}