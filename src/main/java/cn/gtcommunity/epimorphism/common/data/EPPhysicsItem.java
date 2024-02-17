package cn.gtcommunity.epimorphism.common.data;

import cn.gtcommunity.epimorphism.Epimorphism;
import com.gregtechceu.gtceu.api.item.ComponentItem;
import com.gregtechceu.gtceu.common.item.TooltipBehavior;
import com.lowdragmc.lowdraglib.utils.LocalizationUtils;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.builders.ItemBuilder;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import static cn.gtcommunity.epimorphism.api.registry.EPRegistries.EP_REGISTRATE;
import static cn.gtcommunity.epimorphism.common.data.EPItems.*;

public class EPPhysicsItem {

    static {
        EP_REGISTRATE.creativeModeTab(() -> EPCreativeModeTabs.EP_PHYSICS);
    }

    //  High Energy Physics items
//    public final static ItemEntry<Item> PLASMA_CONTAINMENT_CELL;
//    public final static ItemEntry<Item> RHENIUM_PLASMA_CONTAINMENT_CELL;
//    public final static ItemEntry<Item> NEUTRON_PLASMA_CONTAINMENT_CELL;
//    public final static ItemEntry<Item> HYPOGEN_PLASMA_CONTAINMENT_CELL;
//    public final static ItemEntry<Item> ACTINIUM_SUPERHYDRIDE_PLASMA_CONTAINMENT_CELL;
//    public final static ItemEntry<Item> QUANTUM_ANOMALY;

    //  Particle Capsule
    public final static ItemEntry<ComponentItem> EMPTY_PARTICLE_CAPSULE = registerItemWithTooltip("particle_capsule.empty", ComponentItem::create, 1).lang("Empty Particle Capsule").model(EPModels.simpleCustomModel(new ResourceLocation("item/generated"), Epimorphism.id("item/particle_capsule/capsule_base"))).register();
    public final static ItemEntry<ComponentItem> TOP_QUARK_PARTICLE_CAPSULE = registerParticleCapsule("top_quark", ParticleType.QUARK).lang("Top Quark Capsule").register();
    public final static ItemEntry<ComponentItem> BOTTOM_QUARK_PARTICLE_CAPSULE = registerParticleCapsule("bottom_quark", ParticleType.QUARK).lang("Bottom Quark Capsule").register();
    public final static ItemEntry<ComponentItem> UP_QUARK_PARTICLE_CAPSULE = registerParticleCapsule("up_quark", ParticleType.QUARK).lang("Up Quark Capsule").register();
    public final static ItemEntry<ComponentItem> DOWN_QUARK_PARTICLE_CAPSULE = registerParticleCapsule("down_quark", ParticleType.QUARK).lang("Down Quark Capsule").register();
    public final static ItemEntry<ComponentItem> CHARM_QUARK_PARTICLE_CAPSULE = registerParticleCapsule("charm_quark", ParticleType.QUARK).lang("Charm Quark Capsule").register();
    public final static ItemEntry<ComponentItem> STRANGE_QUARK_PARTICLE_CAPSULE = registerParticleCapsule("strange_quark", ParticleType.QUARK).lang("Strange Quark Capsule").register();
    public final static ItemEntry<ComponentItem> ELECTRON_PARTICLE_CAPSULE = registerParticleCapsule("electron", ParticleType.LEPTON).lang("Electron Capsule").register();
    public final static ItemEntry<ComponentItem> ELECTRON_NEUTRINO_PARTICLE_CAPSULE = registerParticleCapsule("electron_neutrino", ParticleType.LEPTON).lang("Electron Neutrino Capsule").register();
    public final static ItemEntry<ComponentItem> MUON_PARTICLE_CAPSULE = registerParticleCapsule("muon", ParticleType.LEPTON).lang("Muon Capsule").register();
    public final static ItemEntry<ComponentItem> MUON_NEUTRINO_PARTICLE_CAPSULE = registerParticleCapsule("muon_neutrino", ParticleType.LEPTON).lang("Muon Neutrino Capsule").register();
    public final static ItemEntry<ComponentItem> TAUON_PARTICLE_CAPSULE = registerParticleCapsule("tauon", ParticleType.LEPTON).lang("Tauon Capsule").register();
    public final static ItemEntry<ComponentItem> TAU_NEUTRINO_PARTICLE_CAPSULE = registerParticleCapsule("tau_neutrino", ParticleType.LEPTON).lang("Tau Neutrino Capsule").register();
    public final static ItemEntry<ComponentItem> GRAVITON_PARTICLE_CAPSULE = registerParticleCapsule("graviton", ParticleType.BOSON).lang("Graviton Capsule").register();
    public final static ItemEntry<ComponentItem> GLUON_PARTICLE_CAPSULE = registerParticleCapsule("gluon", ParticleType.BOSON).lang("Gluon Capsule").register();
    public final static ItemEntry<ComponentItem> PHOTON_PARTICLE_CAPSULE = registerParticleCapsule("photon", ParticleType.BOSON).lang("Photon Capsule").register();
    public final static ItemEntry<ComponentItem> W_BOSON_PARTICLE_CAPSULE = registerParticleCapsule("w_boson", ParticleType.BOSON).lang("W Boson Capsule").register();
    public final static ItemEntry<ComponentItem> Z_BOSON_PARTICLE_CAPSULE = registerParticleCapsule("z_boson", ParticleType.BOSON).lang("Z Boson Capsule").register();
    public final static ItemEntry<ComponentItem> HIGGS_BOSON_PARTICLE_CAPSULE = registerParticleCapsule("higgs_boson", ParticleType.BOSON).lang("Higgs Boson Capsule").register();
    public final static ItemEntry<ComponentItem> PROTON_PARTICLE_CAPSULE = registerParticleCapsule("proton", ParticleType.BARYON).lang("Proton Capsule").register();
    public final static ItemEntry<ComponentItem> NEUTRON_PARTICLE_CAPSULE = registerParticleCapsule("neutron", ParticleType.BARYON).lang("Neutron Capsule").register();
    public final static ItemEntry<ComponentItem> PARTICLE_CAPSULE = registerParticleCapsule("lambda_baryon", ParticleType.BARYON).lang("Lambda Baryon Capsule").register();
    public final static ItemEntry<ComponentItem> OMEGA_BARYON_PARTICLE_CAPSULE = registerParticleCapsule("omega_baryon", ParticleType.BARYON).lang("Omega Baryon Capsule").register();
    public final static ItemEntry<ComponentItem> PI_MESON_PARTICLE_CAPSULE = registerParticleCapsule("pi_meson", ParticleType.MESON).lang("Pi Meson Capsule").register();
    public final static ItemEntry<ComponentItem> ETA_MESON_PARTICLE_CAPSULE = registerParticleCapsule("eta_meson", ParticleType.MESON).lang("Eta Meson Capsule").register();
    public final static ItemEntry<ComponentItem> KERR_BLACK_HOLE_PARTICLE_CAPSULE = registerParticleCapsule("kerr_black_hole").lang("Kerr Black Hole Capsule").register();

    private EPPhysicsItem() {/**/}

    public static void init() {

    }

    private static ItemBuilder<ComponentItem, Registrate> registerParticleCapsule(String name, ParticleType particleType) {
        return EP_REGISTRATE.item("particle_capsule." + name, ComponentItem::create)
                .model(EPModels.simpleCustomModel(new ResourceLocation("item/generated"), Epimorphism.id("item/particle_capsule/capsule_base"), Epimorphism.id("item/particle_capsule/" + name)))
                .onRegister(attach(new TooltipBehavior(lines -> lines.add(Component.translatable("epimorphism.universal.particle_type.desc", particleType.getText())))));
    }

    private static ItemBuilder<ComponentItem, Registrate> registerParticleCapsule(String name) {
        return EP_REGISTRATE.item("particle_capsule." + name, ComponentItem::create)
                .model(EPModels.simpleCustomModel(new ResourceLocation("item/generated"), Epimorphism.id("item/particle_capsule/capsule_base"), Epimorphism.id("item/particle_capsule/" + name)));
    }

    private enum ParticleType {
        QUARK("quark"),
        BOSON("boson"),
        BARYON("baryon"),
        LEPTON("lepton"),
        MESON("meson");

        private final String text;

        ParticleType(String text) {
            this.text = "particleType.%s.%s".formatted(Epimorphism.MOD_ID, text);
        }

        public String getText() {
            return LocalizationUtils.format(text);
        }
    }
}
