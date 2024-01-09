package cn.gtcommunity.epimorphism.common.item;

/*
 * Referenced some code from Mekanism
 *
 * https://github.com/mekanism/Mekanism/
 * */

import com.gregtechceu.gtceu.api.item.ComponentItem;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.item.Item;

public class VajraItem {
    private VajraItem() {/**/}

    @ExpectPlatform
    public static ComponentItem create(Item.Properties properties) {
        throw new AssertionError();
    }
}
