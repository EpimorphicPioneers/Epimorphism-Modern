package cn.gtcommunity.epimorphism.data.lang;

import cn.gtcommunity.epimorphism.common.data.items.EPWrapItem;
import com.epimorphismmc.monomorphism.datagen.lang.MOLangProvider;
import com.gregtechceu.gtceu.api.GTValues;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.LanguageProvider;

import java.lang.reflect.Field;
import java.util.Map;

import static cn.gtcommunity.epimorphism.common.data.items.EPWrapItem.*;

public class WrapItemLang {
    public static void init(MOLangProvider provider) {
        provider.addItemName(WRAP_BOARD_COATED, "Wrap Resin Circuit Board", "封装覆膜电路基板");
        provider.addItemName(WRAP_BOARD_PHENOLIC, "Wrap Phenolic Circuit Board", "封装酚醛树脂电路基板");
        provider.addItemName(WRAP_BOARD_PLASTIC, "Wrap Plastic Circuit Board", "封装塑料电路基板");
        provider.addItemName(WRAP_BOARD_EPOXY, "Wrap Epoxy Circuit Board", "封装环氧树脂基板");
        provider.addItemName(WRAP_BOARD_FIBER, "Wrap Fiber-Reinforced Circuit Board", "封装纤维强化电路基板");
        provider.addItemName(WRAP_BOARD_MULTILAYER_FIBER, "Wrap Multi-layer Fiber-Reinforced Circuit Board", "封装多层纤维强化电路基板");
        provider.addItemName(WRAP_BOARD_WETWARE, "Wrap Wetware Circuit Board", "封装湿件电路基板");

        provider.addItemName(WRAP_CIRCUIT_BOARD_BASIC, "Wrap Resin Printed Circuit Board", "封装覆膜印刷电路基板");
        provider.addItemName(WRAP_CIRCUIT_BOARD_GOOD, "Wrap Phenolic Printed Circuit Board", "封装酚醛树脂印刷电路基板");
        provider.addItemName(WRAP_CIRCUIT_BOARD_PLASTIC, "Wrap Plastic Printed Circuit Board", "封装塑料印刷电路基板");
        provider.addItemName(WRAP_CIRCUIT_BOARD_ADVANCED, "Wrap Epoxy Printed Circuit Board", "封装环氧树脂印刷电路基板");
        provider.addItemName(WRAP_CIRCUIT_BOARD_EXTREME, "Wrap Fiber-Reinforced Printed Circuit Board", "封装纤维强化印刷电路基板");
        provider.addItemName(WRAP_CIRCUIT_BOARD_ELITE, "Wrap Multi-layer Fiber-Reinforced Printed Circuit Board", "封装多层纤维强化印刷电路基板");
        provider.addItemName(WRAP_CIRCUIT_BOARD_WETWARE, "Wrap Wetware Printed Circuit Board", "封装湿件印刷电路基板");

        provider.addItemName(WRAP_SMD_TRANSISTOR, "Wrap Transistor", "封装贴片晶体管");
        provider.addItemName(WRAP_SMD_RESISTOR, "Wrap Resistor", "封装贴片电阻");
        provider.addItemName(WRAP_SMD_CAPACITOR, "Wrap Capacitor", "封装贴片电容");
        provider.addItemName(WRAP_SMD_DIODE, "Wrap Diode", "封装贴片二极管");
        provider.addItemName(WRAP_SMD_INDUCTOR, "Wrap Inductor", "封装贴片电感");
        provider.addItemName(WRAP_SMD_TRANSISTOR_ADVANCED, "Wrap SMD Transistor", "封装高级贴片晶体管");
        provider.addItemName(WRAP_SMD_RESISTOR_ADVANCED, "Wrap SMD Resistor", "封装高级贴片电阻");
        provider.addItemName(WRAP_SMD_CAPACITOR_ADVANCED, "Wrap SMD Capacitor", "封装高级贴片电容");
        provider.addItemName(WRAP_SMD_DIODE_ADVANCED, "Wrap SMD Diode", "封装高级贴片二极管");
        provider.addItemName(WRAP_SMD_INDUCTOR_ADVANCED, "Wrap SMD Inductor", "封装高级贴片电感");

        EPWrapItem.WRAP_ITEM_MAP.object2ObjectEntrySet().fastForEach(entry -> generateWrapItemLang(provider, entry.getValue().asItem(), entry.getKey().asItem()));
        EPWrapItem.WRAP_CIRCUIT_MAP.object2ObjectEntrySet().fastForEach(entry -> generateWrapCircuitLang(provider, entry.getValue().asItem(), entry.getKey()));
    }

    private static void generateWrapItemLang(MOLangProvider provider, Item item, Item wrappedItem) {
        try {
            Field field = MOLangProvider.class.getDeclaredField("simplifiedChinese");
            field.setAccessible(true);
            LanguageProvider providerCN = (LanguageProvider) field.get(provider);

            String text = getText(provider, wrappedItem);
            String textCN = getText(providerCN, wrappedItem);
            if (text != null) {
                provider.addItem(() -> item, "Wrap %s".formatted(text));
            }
            if (textCN != null) {
                provider.addItemCNName(() -> item, "封装%s".formatted(textCN));
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException("Error generating entry in datagen.", e);
        }
    }

    private static String getText(LanguageProvider provider, Item item) {
        try {
            Field field = LanguageProvider.class.getDeclaredField("data");
            field.setAccessible(true);
            // noinspection unchecked
            Map<String, String> map = (Map<String, String>) field.get(provider);
            return map.get(item.getDescriptionId());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException("Error generating entry in datagen.", e);
        }
    }

    private static void generateWrapCircuitLang(MOLangProvider provider, Item item, TagKey<Item> wrappedKey) {
        String key = wrappedKey.location().getPath().split("/")[1];
        for (int i = 0; i < GTValues.VN.length; i++) {
            String tier = GTValues.VN[i];
            if (tier.equalsIgnoreCase(key)) {
                provider.addItemName(() -> item, "Wrap Circuit (%s§r)".formatted(GTValues.VNF[i]), "封装电路板（%s§r）".formatted(GTValues.VNF[i]));
            }
        }
    }

}
