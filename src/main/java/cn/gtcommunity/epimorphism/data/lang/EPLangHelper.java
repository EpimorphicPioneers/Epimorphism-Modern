package cn.gtcommunity.epimorphism.data.lang;

import cn.gtcommunity.epimorphism.Epimorphism;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
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

    public static void addItemName(LanguageProvider provider, NonNullSupplier<? extends Item> item, String enName, String cnName) {
        if (provider instanceof RegistrateCNLangProvider cnLangProvider) {
            cnLangProvider.addItem(item, cnName);
        } else if (provider instanceof RegistrateLangProvider enLangProvider) {
            LangHandler.replace(enLangProvider, item.get().getDescriptionId(), enName);
        }
    }

    public static void add(LanguageProvider provider, String key, String enText, String cnText) {
        if (provider instanceof RegistrateCNLangProvider cnLangProvider) {
            cnLangProvider.add(key, cnText);
        } else if (provider instanceof RegistrateLangProvider enLangProvider) {
            enLangProvider.add(key, enText);
        }
    }

    public static void addMultilineLang(LanguageProvider provider, String key, String enText, String cnText) {
        if (provider instanceof RegistrateCNLangProvider cnLangProvider) {
            LangHandler.multilineLang(cnLangProvider, key, cnText);
        } else if (provider instanceof RegistrateLangProvider enLangProvider) {
            LangHandler.multilineLang(enLangProvider, key, enText);
        }
    }

    public static void addCN(LanguageProvider provider, String key, String cnText) {
        if (provider instanceof RegistrateCNLangProvider cnLangProvider) {
            cnLangProvider.add(key, cnText);
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
}
