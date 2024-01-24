package cn.gtcommunity.epimorphism.data.lang;

import cn.gtcommunity.epimorphism.common.data.EPWrapItem;
import com.gregtechceu.gtceu.api.GTValues;
import com.tterrag.registrate.providers.RegistrateLangProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.LanguageProvider;

import java.lang.reflect.Field;
import java.util.Map;

import static cn.gtcommunity.epimorphism.data.lang.EPLangHelper.*;

public class WrapItemLang {
    public static void init(LanguageProvider provider) {
        EPWrapItem.WRAP_ITEM_MAP.object2ObjectEntrySet().fastForEach(entry -> generateWrapItemLang(provider, entry.getValue().asItem(), entry.getKey().asItem()));
        EPWrapItem.WRAP_CIRCUIT_MAP.object2ObjectEntrySet().fastForEach(entry -> generateWrapCircuitLang(provider, entry.getValue().asItem(), entry.getKey()));
    }

    private static void generateWrapItemLang(LanguageProvider provider, Item item, Item wrappedItem) {
        try {
            // the regular lang mappings
            Field field = LanguageProvider.class.getDeclaredField("data");
            field.setAccessible(true);
            // noinspection unchecked
            Map<String, String> map = (Map<String, String>) field.get(provider);
            String text = map.get(wrappedItem.getDescriptionId());
            if (text != null) {
                addName(provider, text, item);
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException("Error generating entry in datagen.", e);
        }
    }

    private static void generateWrapCircuitLang(LanguageProvider provider, Item item, TagKey<Item> wrappedKey) {
        String key = wrappedKey.location().getPath().split("/")[1];
        for (int i = 0; i < GTValues.VN.length; i++) {
            String tier = GTValues.VN[i];
            if (tier.equalsIgnoreCase(key)) {
                addCircuitName(provider, GTValues.VNF[i], item);
            }
        }
    }

    private static void addName(LanguageProvider provider, String text, Item item) {
        if (provider instanceof RegistrateCNLangProvider cnLangProvider) {
            addItemCNName(cnLangProvider, () -> item, "封装%s".formatted(text));
        } else if (provider instanceof RegistrateLangProvider enLangProvider) {
            LangHandler.replace(enLangProvider, item.getDescriptionId(), "Wrap %s".formatted(text));
        }
    }

    private static void addCircuitName(LanguageProvider provider, String text, Item item) {
        if (provider instanceof RegistrateCNLangProvider cnLangProvider) {
            addItemCNName(cnLangProvider, () -> item, "封装电路板（%s§r）".formatted(text));
        } else if (provider instanceof RegistrateLangProvider enLangProvider) {
            LangHandler.replace(enLangProvider, item.getDescriptionId(), "Wrap Circuit (%s§r)".formatted(text));
        }
    }
}
