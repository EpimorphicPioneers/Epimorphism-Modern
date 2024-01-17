package cn.gtcommunity.epimorphism.data.lang;

import cn.gtcommunity.epimorphism.Epimorphism;
import com.gregtechceu.gtceu.api.GTValues;
import com.tterrag.registrate.providers.RegistrateLangProvider;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.List;
import java.util.Locale;

public class EPLangHelper {
    public static void addItemWithTooltip(LanguageProvider provider, NonNullSupplier<? extends Item> item, String cnName, String enTooltip, String cnTooltip) {
        if (provider instanceof RegistrateCNLangProvider cnLangProvider) {
            cnLangProvider.addItemWithTooltip(item, cnName, cnTooltip);
        } else if (provider instanceof RegistrateLangProvider enLangProvider) {
            enLangProvider.addTooltip(item, enTooltip);
        }
    }

    public static void addItemCNName(LanguageProvider provider, NonNullSupplier<? extends Item> item, String cnName) {
        if (provider instanceof RegistrateCNLangProvider cnLangProvider) {
            cnLangProvider.addItem(item, cnName);
        }
    }

    public static void add(LanguageProvider provider, String key, String enTooltip, String cnTooltip) {
        if (provider instanceof RegistrateCNLangProvider cnLangProvider) {
            cnLangProvider.add(key, cnTooltip);
        } else if (provider instanceof RegistrateLangProvider enLangProvider) {
            enLangProvider.add(key, enTooltip);
        }
    }

    public static void addBlockWithTooltip(LanguageProvider provider, NonNullSupplier<? extends Block> block, String cnName, String enTooltip, String cnTooltip) {
        if (provider instanceof RegistrateCNLangProvider cnLangProvider) {
            cnLangProvider.addBlockWithTooltip(block, cnName, cnTooltip);
        } else if (provider instanceof RegistrateLangProvider enLangProvider) {
            enLangProvider.addTooltip(block, enTooltip);
        }
    }

    public static void addBlockWithTooltip(LanguageProvider provider, NonNullSupplier<? extends Block> block, String cnName, List<String> enTooltip, List<String> cnTooltip) {
        if (provider instanceof RegistrateCNLangProvider cnLangProvider) {
            cnLangProvider.addBlockWithTooltip(block, cnName, cnTooltip);
        } else if (provider instanceof RegistrateLangProvider enLangProvider) {
            enLangProvider.addTooltip(block, enTooltip);
        }
    }

    public static void addBlockWithTooltip(LanguageProvider provider, NonNullSupplier<? extends Block> block, String enName, String cnName, String enTooltip, String cnTooltip) {
        if (provider instanceof RegistrateCNLangProvider cnLangProvider) {
            cnLangProvider.addBlockWithTooltip(block, cnName, cnTooltip);
        } else if (provider instanceof RegistrateLangProvider enLangProvider) {
            LangHandler.replace(enLangProvider, block.get().getDescriptionId(), enName);
            enLangProvider.addTooltip(block, enTooltip);
        }
    }

    public static void addBlock(LanguageProvider provider, NonNullSupplier<? extends Block> block, String enName, String cnName) {
        if (provider instanceof RegistrateCNLangProvider cnLangProvider) {
            cnLangProvider.addBlock(block, cnName);
        } else if (provider instanceof RegistrateLangProvider enLangProvider) {
            LangHandler.replace(enLangProvider, block.get().getDescriptionId(), enName);
        }
    }

    public static void addTieredMachineName(LanguageProvider provider, String key, String cnName, int... tiers) {
        for (int tier : tiers) {
            var name = "block.%s.%s".formatted(Epimorphism.MOD_ID, GTValues.VN[tier].toLowerCase(Locale.ROOT) + "_" + key);
            if (provider instanceof RegistrateCNLangProvider cnLangProvider) {
                cnLangProvider.add(name, "%s§r%s".formatted(GTValues.VNF[tier], cnName));
            }
        }
    }
}
