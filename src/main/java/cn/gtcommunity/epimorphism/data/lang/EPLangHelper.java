package cn.gtcommunity.epimorphism.data.lang;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.common.block.DimensionDisplayBlock;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.data.lang.LangHandler;
import com.tterrag.registrate.providers.RegistrateLangProvider;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;

public class EPLangHelper {

    public static void add(LanguageProvider provider, String key, String enText, String cnText) {
        if (provider instanceof RegistrateCNLangProvider cnLangProvider) {
            cnLangProvider.add(key, cnText);
        } else if (provider instanceof RegistrateLangProvider enLangProvider) {
            enLangProvider.add(key, enText);
        }
    }

    public static void addMultiLang(LanguageProvider provider, Function<Integer, String> keyGetter, Function<Integer, String> enTextGetter, Function<Integer, String> cnTextGetter, int... tiers) {
        for (int tier : tiers) {
            var name = keyGetter.apply(tier);
            if (provider instanceof RegistrateCNLangProvider cnLangProvider) {
                cnLangProvider.add(name, cnTextGetter.apply(tier));
            } else if (provider instanceof RegistrateLangProvider enLangProvider) {
                enLangProvider.add(name, enTextGetter.apply(tier));
            }
        }
    }

    public static void addMultiLang(LanguageProvider provider, String key, List<String> enText, List<String> cnText) {
        if (provider instanceof RegistrateCNLangProvider cnLangProvider) {
            for (var i = 0; i < cnText.size(); i++) {
                cnLangProvider.add(getSubKey(key, i), cnText.get(i));
            }
        } else if (provider instanceof RegistrateLangProvider enLangProvider) {
            for (var i = 0; i < enText.size(); i++) {
                enLangProvider.add(getSubKey(key, i), enText.get(i));
            }
        }
    }

    public static void addMultilineLang(LanguageProvider provider, String key, String enText, String cnText) {
        if (provider instanceof RegistrateCNLangProvider cnLangProvider) {
            multilineLang(cnLangProvider, key, cnText);
        } else if (provider instanceof RegistrateLangProvider enLangProvider) {
            multilineLang(enLangProvider, key, enText);
        }
    }

    public static void addCN(LanguageProvider provider, String key, String cnText) {
        if (provider instanceof RegistrateCNLangProvider cnLangProvider) {
            cnLangProvider.add(key, cnText);
        }
    }

    public static void addItemName(LanguageProvider provider, NonNullSupplier<? extends Item> item, String enName, String cnName) {
        if (provider instanceof RegistrateCNLangProvider cnLangProvider) {
            cnLangProvider.addItem(item, cnName);
        } else if (provider instanceof RegistrateLangProvider enLangProvider) {
            LangHandler.replace(enLangProvider, item.get().getDescriptionId(), enName);
        }
    }

    public static void addItemCNName(LanguageProvider provider, NonNullSupplier<? extends Item> item, String cnName) {
        if (provider instanceof RegistrateCNLangProvider cnLangProvider) {
            cnLangProvider.addItem(item, cnName);
        }
    }

    public static void addItemWithTooltip(LanguageProvider provider, NonNullSupplier<? extends Item> item, String cnName, String enTooltip, String cnTooltip) {
        if (provider instanceof RegistrateCNLangProvider cnLangProvider) {
            cnLangProvider.addItemWithTooltip(item, cnName, cnTooltip);
        } else if (provider instanceof RegistrateLangProvider enLangProvider) {
            enLangProvider.addTooltip(item, enTooltip);
        }
    }

    public static void addBlock(LanguageProvider provider, NonNullSupplier<? extends Block> block, String enName, String cnName) {
        if (provider instanceof RegistrateCNLangProvider cnLangProvider) {
            cnLangProvider.addBlock(block, cnName);
        } else if (provider instanceof RegistrateLangProvider enLangProvider) {
            LangHandler.replace(enLangProvider, block.get().getDescriptionId(), enName);
        }
    }

    public static void addBlockCNName(LanguageProvider provider, NonNullSupplier<? extends Block> block, String cnName) {
        if (provider instanceof RegistrateCNLangProvider cnLangProvider) {
            cnLangProvider.addBlock(block, cnName);
        }
    }

    public static void addBlockWithTooltip(LanguageProvider provider, NonNullSupplier<? extends Block> block, String enName, String cnName, List<String> enTooltip, List<String> cnTooltip) {
        if (provider instanceof RegistrateCNLangProvider cnLangProvider) {
            cnLangProvider.addBlockWithTooltip(block, cnName, cnTooltip);
        } else if (provider instanceof RegistrateLangProvider enLangProvider) {
            LangHandler.replace(enLangProvider, block.get().getDescriptionId(), enName);
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

    public static void addBlockWithTooltip(LanguageProvider provider, NonNullSupplier<? extends Block> block, String cnName, String enTooltip, String cnTooltip) {
        if (provider instanceof RegistrateCNLangProvider cnLangProvider) {
            cnLangProvider.addBlockWithTooltip(block, cnName, cnTooltip);
        } else if (provider instanceof RegistrateLangProvider enLangProvider) {
            enLangProvider.addTooltip(block, enTooltip);
        }
    }

    public static void addBlockWithTooltip(LanguageProvider provider, String blockName, List<String> enTooltip, List<String> cnTooltip) {
        if (provider instanceof RegistrateCNLangProvider cnLangProvider) {
            for (int i = 0; i < cnTooltip.size(); i++) {
                cnLangProvider.add("block.%s.%s.desc.".formatted(Epimorphism.MOD_ID, blockName) + i, cnTooltip.get(i));
            }
        } else if (provider instanceof RegistrateLangProvider enLangProvider) {
            for (int i = 0; i < enTooltip.size(); i++) {
                enLangProvider.add("block.%s.%s.desc.".formatted(Epimorphism.MOD_ID, blockName) + i, enTooltip.get(i));
            }
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

    public static void addBlockWithShiftTooltip(LanguageProvider provider, NonNullSupplier<? extends Block> block, List<String> enTooltip, List<String> cnTooltip) {
        if (provider instanceof RegistrateCNLangProvider cnLangProvider) {
            for (int i = 0; i < cnTooltip.size(); i++) {
                cnLangProvider.add(block.get().asItem().getDescriptionId() + ".shift_desc." + i, cnTooltip.get(i));
            }
        } else if (provider instanceof RegistrateLangProvider enLangProvider) {
            for (int i = 0; i < enTooltip.size(); i++) {
                enLangProvider.add(block.get().asItem().getDescriptionId() + ".shift_desc." + i, enTooltip.get(i));
            }
        }
    }

    public static void addTieredBlockWithTooltip(LanguageProvider provider, Function<Integer, String> keyGetter, Function<Integer, String> enNameGetter, Function<Integer, String> cnNameGetter, Function<Integer, String> enTooltipGetter, Function<Integer, String> cnTooltipGetter, int... tiers) {
        for (int tier : tiers) {
            var name = "block.%s.%s".formatted(Epimorphism.MOD_ID, keyGetter.apply(tier));
            if (provider instanceof RegistrateCNLangProvider cnLangProvider) {
                cnLangProvider.add(name, cnNameGetter.apply(tier));
                cnLangProvider.add(name + ".desc", cnTooltipGetter.apply(tier));
            } else if (provider instanceof RegistrateLangProvider enLangProvider) {
                LangHandler.replace(enLangProvider, name, enNameGetter.apply(tier));
                enLangProvider.add(name + ".desc", enTooltipGetter.apply(tier));
            }
        }
    }

    public static void addTieredBlock(LanguageProvider provider, Function<Integer, String> keyGetter, Function<Integer, String> enNameGetter, Function<Integer, String> cnNameGetter, int... tiers) {
        for (int tier : tiers) {
            var name = "block.%s.%s".formatted(Epimorphism.MOD_ID, keyGetter.apply(tier));
            if (provider instanceof RegistrateCNLangProvider cnLangProvider) {
                cnLangProvider.add(name, cnNameGetter.apply(tier));
            } else if (provider instanceof RegistrateLangProvider enLangProvider) {
                LangHandler.replace(enLangProvider, name, enNameGetter.apply(tier));
            }
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

    public static void addDimensionDisplay(LanguageProvider provider, NonNullSupplier<? extends Block> block, String enName, String cnName) {
        if (block.get() instanceof DimensionDisplayBlock displayBlock) {
            addBlock(provider, block, "T%s: %s".formatted(displayBlock.getDimensionTier(), enName), "T%s: %s".formatted(displayBlock.getDimensionTier(), cnName));
        }
    }

    public static void addRecipeType(LanguageProvider provider, GTRecipeType recipeType, String enName, String cnName) {
        if (provider instanceof RegistrateCNLangProvider cnLangProvider) {
            cnLangProvider.add(recipeType.registryName.toLanguageKey(), cnName);
        } else if (provider instanceof RegistrateLangProvider enLangProvider) {
            enLangProvider.add(recipeType.registryName.toLanguageKey(), enName);
        }
    }

    public static void addMaterial(LanguageProvider provider, Material material, String enName, String cnName) {
        if (provider instanceof RegistrateCNLangProvider cnLangProvider) {
            cnLangProvider.add(material.getUnlocalizedName(), cnName);
        } else if (provider instanceof RegistrateLangProvider enLangProvider) {
            enLangProvider.add(material.getUnlocalizedName(), enName);
        }
    }

    public static void addTagPrefix(LanguageProvider provider, TagPrefix tagPrefix, String enName, String cnName) {
        if (provider instanceof RegistrateCNLangProvider cnLangProvider) {
            cnLangProvider.add(tagPrefix.getUnlocalizedName(), cnName);
        } else if (provider instanceof RegistrateLangProvider enLangProvider) {
            enLangProvider.add(tagPrefix.getUnlocalizedName(), enName);
        }
    }

    public static List<MutableComponent> getItemTooltips(String key, int tooltips) {
        return getSubKeys("item.%s.%s.desc".formatted(Epimorphism.MOD_ID, key), tooltips);
    }

    public static List<MutableComponent> getBlockTooltips(String key, int tooltips) {
        return getSubKeys("block.%s.%s.desc".formatted(Epimorphism.MOD_ID, key), tooltips);
    }

    public static List<MutableComponent> getSubKeys(String key, int tooltips) {
        List<MutableComponent> list = new ArrayList<>();
        if (tooltips <= 1) {
            list.add(Component.translatable(key));
            return list;
        } else {
            for (var i = 0; i < tooltips; i++) {
                list.add(Component.translatable(getSubKey(key, i)));
            }
        }
        return list;
    }

    protected static String getSubKey(String key, int index) {
        return key + "." + index;
    }

    protected static void multiLang(LanguageProvider provider, String key, String... values) {
        for (var i = 0; i < values.length; i++) {
            provider.add(getSubKey(key, i), values[i]);
        }
    }

    protected static void multilineLang(LanguageProvider provider, String key, String multiline) {
        var lines = multiline.split("\n");
        multiLang(provider, key, lines);
    }
}
