package com.epimorphismmc.epimorphism;

import com.epimorphismmc.epimorphism.client.ClientProxy;
import com.epimorphismmc.epimorphism.common.CommonProxy;
import com.epimorphismmc.epimorphism.config.EPConfigHolder;
import com.epimorphismmc.epimorphism.data.lang.EPLangHandler;
import com.epimorphismmc.epimorphism.network.s2c.PacketVajraDestroy;

import com.epimorphismmc.monomorphism.MOMod;
import com.epimorphismmc.monomorphism.datagen.MOProviderTypes;
import com.epimorphismmc.monomorphism.registry.registrate.MORegistrate;

import com.gregtechceu.gtceu.utils.FormattingUtil;

import com.lowdragmc.lowdraglib.networking.INetworking;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.common.Mod;

import org.slf4j.Logger;

@Mod(Epimorphism.MOD_ID)
public class Epimorphism extends MOMod<CommonProxy> {
    public static final String MOD_ID = "epimorphism";
    public static final String NAME = "Epimorphism";

    public static Epimorphism instance;

    public Epimorphism() {
        super();
    }

    @Override
    public String getModId() {
        return MOD_ID;
    }

    @Override
    public String getModName() {
        return NAME;
    }

    @Override
    protected void onModConstructed() {
        instance = this;
        EPConfigHolder.init();
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    protected CommonProxy createClientProxy() {
        return new ClientProxy();
    }

    @Override
    @OnlyIn(Dist.DEDICATED_SERVER)
    protected CommonProxy createServerProxy() {
        return new CommonProxy();
    }

    @Override
    public void addDataGenerator(MORegistrate registrate) {
        registrate.addDataGenerator(MOProviderTypes.MO_LANG, EPLangHandler::init);
    }

    @Override
    public void registerPackets(INetworking network) {
        network.registerS2C(PacketVajraDestroy.class);
    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, FormattingUtil.toLowerCaseUnder(path));
    }

    public static Logger logger() {
        return instance.getLogger();
    }

    public static CommonProxy proxy() {
        return instance.getProxy();
    }

    public static MORegistrate registrate() {
        return instance.getRegistrate();
    }

    public static INetworking network() {
        return instance.getNetwork();
    }
}
