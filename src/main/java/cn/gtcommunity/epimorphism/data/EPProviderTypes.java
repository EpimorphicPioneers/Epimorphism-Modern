package cn.gtcommunity.epimorphism.data;

import cn.gtcommunity.epimorphism.data.lang.RegistrateCNLangProvider;
import com.tterrag.registrate.providers.ProviderType;

public class EPProviderTypes {
    public static final ProviderType<RegistrateCNLangProvider> CN_LANG = ProviderType.register("cn_lang", (p, e) -> new RegistrateCNLangProvider(p, e.getGenerator().getPackOutput()));

    public static void init() {/**/};
}
