package cn.gtcommunity.epimorphism.common.data.items;

import cn.gtcommunity.epimorphism.Epimorphism;
import cn.gtcommunity.epimorphism.common.data.EPCreativeModeTabs;
import cn.gtcommunity.epimorphism.common.data.EPModels;
import cn.gtcommunity.epimorphism.common.item.behaviors.reactor.*;
import com.gregtechceu.gtceu.api.item.ComponentItem;
import com.gregtechceu.gtceu.common.item.TooltipBehavior;
import com.lowdragmc.lowdraglib.utils.LocalizationUtils;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.builders.ItemBuilder;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import static cn.gtcommunity.epimorphism.common.registry.EPRegistration.EP_REGISTRATE;
import static cn.gtcommunity.epimorphism.common.data.EPItems.*;

public class EPPhysicsItems {

    static {
        EP_REGISTRATE.creativeModeTab(() -> EPCreativeModeTabs.EP_PHYSICS);
    }

    //  High Energy Physics Items
    public final static ItemEntry<ComponentItem> PLASMA_CONTAINMENT_CELL = registerItemWithTooltip("plasma_containment_cell", ComponentItem::create, 1).lang("Plasma Containment Cell").register();
    public final static ItemEntry<ComponentItem> RHENIUM_PLASMA_CONTAINMENT_CELL = registerItemWithTooltip("rhenium_plasma_containment_cell", ComponentItem::create, 1).lang("Rhenium Plasma Containment Cell").register();
    public final static ItemEntry<ComponentItem> NEUTRON_PLASMA_CONTAINMENT_CELL = registerItemWithTooltip("neutron_plasma_containment_cell", ComponentItem::create, 1).lang("Neutron Plasma Containment Cell").register();
    public final static ItemEntry<ComponentItem> HYPOGEN_PLASMA_CONTAINMENT_CELL = registerItemWithTooltip("hypogen_plasma_containment_cell", ComponentItem::create, 1).lang("Hypogen Plasma Containment Cell ").register();
    public final static ItemEntry<ComponentItem> ACTINIUM_SUPERHYDRIDE_PLASMA_CONTAINMENT_CELL = registerItemWithTooltip("actinium_superhydride_plasma_containment_cell", ComponentItem::create, 1).lang("Actinium Superhydride Plasma Containment Cell").register();
    public final static ItemEntry<ComponentItem> QUANTUM_ANOMALY = registerItemWithTooltip("quantum_anomaly", ComponentItem::create, 1).lang("Quantum Anomaly").register();

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

    //  Nuclear Physics items
    public static ItemEntry<Item> NEUTRON_SOURCE = EP_REGISTRATE.item("neutron_source", Item::new).lang("Neutron Source").register();
    public static ItemEntry<Item> PLATE_RADIATION_PROTECTION = EP_REGISTRATE.item("plate_radiation_protection", Item::new).lang("Radiation Protection Plate").register();
    public static ItemEntry<Item> ADV_PLATE_RADIATION_PROTECTION = EP_REGISTRATE.item("advanced_plate_radiation_protection", Item::new).lang("Advanced Radiation Protection Plate").register();
    public static ItemEntry<Item> ENCAPSULATED_URANIUM = EP_REGISTRATE.item("encapsulated_uranium", Item::new).lang("Encapsulated Uranium").register();
    public static ItemEntry<Item> ENRICHED_URANIUM_NUGGET = EP_REGISTRATE.item("enriched_uranium_nugget", Item::new).lang("Enriched Uranium Nugget").register();
    public static ItemEntry<Item> ENRICHED_URANIUM = EP_REGISTRATE.item("enriched_uranium", Item::new).lang("Enriched Uranium").register();
    public static ItemEntry<Item> ENCAPSULATED_THORIUM = EP_REGISTRATE.item("encapsulated_thorium", Item::new).lang("Encapsulated Thorium").register();
    public static ItemEntry<Item> ENRICHED_THORIUM_NUGGET = EP_REGISTRATE.item("enriched_thorium_nugget", Item::new).lang("Enriched Thorium Nugget").register();
    public static ItemEntry<Item> ENRICHED_THORIUM = EP_REGISTRATE.item("enriched_thorium", Item::new).lang("Enriched Thorium").register();
    public static ItemEntry<Item> ENCAPSULATED_PLUTONIUM = EP_REGISTRATE.item("encapsulated_plutonium", Item::new).lang("Encapsulated Plutonium").register();
    public static ItemEntry<Item> ENRICHED_PLUTONIUM_NUGGET = EP_REGISTRATE.item("enriched_plutonium_nugget", Item::new).lang("Enriched Plutonium Nugget").register();
    public static ItemEntry<Item> ENRICHED_PLUTONIUM = EP_REGISTRATE.item("enriched_plutonium", Item::new).lang("Enriched Plutonium").register();

    public static ItemEntry<ComponentItem> NEUTRON_REFLECTOR = EP_REGISTRATE.item("reactor_component.neutron_reflector", ComponentItem::create)
            .lang("Neutron Reflector")
            .onRegister(attach(new ReflectorBehavior(3000)))
            .register();
    public static ItemEntry<ComponentItem> THICK_NEUTRON_REFLECTOR = EP_REGISTRATE.item("reactor_component.thick_neutron_reflector", ComponentItem::create)
            .lang("Thick Neutron Reflector")
            .onRegister(attach(new ReflectorBehavior(12000)))
            .register();
    public static ItemEntry<ComponentItem> IRIDIUM_REFLECTOR = EP_REGISTRATE.item("reactor_component.iridium_reflector", ComponentItem::create)
            .lang("Iridium Reflector")
            .onRegister(attach(new ReflectorBehavior(-1)))
            .register();
    public static ItemEntry<ComponentItem> PLATING = EP_REGISTRATE.item("reactor_component.plating", ComponentItem::create)
            .lang("Plating")
            .onRegister(attach(new PlatingBehavior(1000, 0.95F)))
            .register();
    public static ItemEntry<ComponentItem> CONTAINMENT_PLATING = EP_REGISTRATE.item("reactor_component.containment_plating", ComponentItem::create)
            .lang("Containment Plating")
            .onRegister(attach(new PlatingBehavior(500, 0.9F)))
            .register();
    public static ItemEntry<ComponentItem> HEAT_PLATING = EP_REGISTRATE.item("reactor_component.heat_plating", ComponentItem::create)
            .lang("Heat Plating")
            .onRegister(attach(new PlatingBehavior(1700, 0.99F)))
            .register();
    public static ItemEntry<ComponentItem> HEAT_EXCHANGER = EP_REGISTRATE.item("reactor_component.heat_exchanger", ComponentItem::create)
            .lang("Heat Exchanger")
            .onRegister(attach(new ExchangerBehavior(2500, 12, 4)))
            .register();
    public static ItemEntry<ComponentItem> REACTOR_HEAT_EXCHANGER = EP_REGISTRATE.item("reactor_component.reactor_heat_exchanger", ComponentItem::create)
            .lang("Reactor Heat Exchanger")
            .onRegister(attach(new ExchangerBehavior(5000, 0, 72)))
            .register();
    public static ItemEntry<ComponentItem> COMPONENT_HEAT_EXCHANGER = EP_REGISTRATE.item("reactor_component.component_heat_exchanger", ComponentItem::create)
            .lang("Component Heat Exchanger")
            .onRegister(attach(new ExchangerBehavior(5000, 36, 0)))
            .register();
    public static ItemEntry<ComponentItem> ADVANCED_HEAT_EXCHANGER = EP_REGISTRATE.item("reactor_component.advanced_heat_exchanger", ComponentItem::create)
            .lang("Advanced Heat Exchanger")
            .onRegister(attach(new ExchangerBehavior(10000, 24, 8)))
            .register();
    public static ItemEntry<ComponentItem> HEAT_VENT = EP_REGISTRATE.item("reactor_component.heat_vent", ComponentItem::create)
            .lang("Heat Vent")
            .onRegister(attach(new VentBehavior(1000, 6, 0, 0)))
            .register();
    public static ItemEntry<ComponentItem> REACTOR_HEAT_VENT = EP_REGISTRATE.item("reactor_component.reactor_heat_vent", ComponentItem::create)
            .lang("Reactor Heat Vent")
            .onRegister(attach(new VentBehavior(1000, 5, 5, 0)))
            .register();
    public static ItemEntry<ComponentItem> COMPONENT_HEAT_VENT = EP_REGISTRATE.item("reactor_component.component_heat_vent", ComponentItem::create)
            .lang("Component Heat Vent")
            .onRegister(attach(new VentBehavior(-1, 0, 0, 4)))
            .register();
    public static ItemEntry<ComponentItem> ADVANCED_HEAT_VENT = EP_REGISTRATE.item("reactor_component.advanced_heat_vent", ComponentItem::create)
            .lang("Advanced Heat Vent")
            .onRegister(attach(new VentBehavior(1000, 12, 0, 0)))
            .register();
    public static ItemEntry<ComponentItem> OVERCLOCKED_HEAT_VENT = EP_REGISTRATE.item("reactor_component.overclocked_heat_vent", ComponentItem::create)
            .lang("Overclocked Heat Vent")
            .onRegister(attach(new VentBehavior(1000, 20, 36, 0)))
            .register();
    public static ItemEntry<ComponentItem> WATER_COOLANT_CELL_10K = EP_REGISTRATE.item("reactor_component.water_coolant_cell_10k", ComponentItem::create)
            .lang("Water Coolant Cell 10k")
            .onRegister(attach(new CoolantCellBehavior(10000)))
            .register();
    public static ItemEntry<ComponentItem> WATER_COOLANT_CELL_30K = EP_REGISTRATE.item("reactor_component.water_coolant_cell_30k", ComponentItem::create)
            .lang("Water Coolant Cell 30k")
            .onRegister(attach(new CoolantCellBehavior(30000)))
            .register();
    public static ItemEntry<ComponentItem> WATER_COOLANT_CELL_60K = EP_REGISTRATE.item("reactor_component.water_coolant_cell_60k", ComponentItem::create)
            .lang("Water Coolant Cell 60k")
            .onRegister(attach(new CoolantCellBehavior(60000)))
            .register();
    public static ItemEntry<ComponentItem> HELIUM_COOLANT_CELL_60K = EP_REGISTRATE.item("reactor_component.helium_coolant_cell_60k", ComponentItem::create)
            .lang("Helium Coolant Cell 60k")
            .onRegister(attach(new CoolantCellBehavior(60000)))
            .register();
    public static ItemEntry<ComponentItem> HELIUM_COOLANT_CELL_180K = EP_REGISTRATE.item("reactor_component.helium_coolant_cell_180k", ComponentItem::create)
            .lang("Helium Coolant Cell 180k")
            .onRegister(attach(new CoolantCellBehavior(180000)))
            .register();
    public static ItemEntry<ComponentItem> HELIUM_COOLANT_CELL_360K = EP_REGISTRATE.item("reactor_component.helium_coolant_cell_360k", ComponentItem::create)
            .lang("Helium Coolant Cell 360k")
            .onRegister(attach(new CoolantCellBehavior(360000)))
            .register();
    public static ItemEntry<ComponentItem> NAK_COOLANT_CELL_60K = EP_REGISTRATE.item("reactor_component.nak_coolant_cell_60k", ComponentItem::create)
            .lang("Nak Coolant Cell 60k")
            .onRegister(attach(new CoolantCellBehavior(60000)))
            .register();
    public static ItemEntry<ComponentItem> NAK_COOLANT_CELL_180K = EP_REGISTRATE.item("reactor_component.nak_coolant_cell_180k", ComponentItem::create)
            .lang("Nak Coolant Cell 180k")
            .onRegister(attach(new CoolantCellBehavior(180000)))
            .register();
    public static ItemEntry<ComponentItem> NAK_COOLANT_CELL_360K = EP_REGISTRATE.item("reactor_component.nak_coolant_cell_360k", ComponentItem::create)
            .lang("Nak Coolant Cell 360k")
            .onRegister(attach(new CoolantCellBehavior(360000)))
            .register();

    public static ItemEntry<ComponentItem> ROD_URANIUM = EP_REGISTRATE.item("reactor_component.rod_uranium", ComponentItem::create)
            .lang("Rod Uranium")
            .onRegister(attach(new FuelRodBehavior(1, 1, 1, 1, false)))
            .register();
    public static ItemEntry<ComponentItem> ROD_DUAL_URANIUM = EP_REGISTRATE.item("reactor_component.rod_dual_uranium", ComponentItem::create)
            .lang("Rod Dual Uranium")
            .onRegister(attach(new FuelRodBehavior(1, 1, 1, 1, false)))
            .register();
    public static ItemEntry<ComponentItem> ROD_QUAD_URANIUM = EP_REGISTRATE.item("reactor_component.rod_quad_uranium", ComponentItem::create)
            .lang("Rod Quad Uranium")
            .onRegister(attach(new FuelRodBehavior(1, 1, 1, 1, false)))
            .register();
    public static ItemEntry<ComponentItem> ROD_URANIUM_MOX = EP_REGISTRATE.item("reactor_component.rod_uranium_mox", ComponentItem::create)
            .lang("Rod Uranium Mox")
            .onRegister(attach(new FuelRodBehavior(1, 1, 1, 1, false)))
            .register();
    public static ItemEntry<ComponentItem> ROD_DUAL_URANIUM_MOX = EP_REGISTRATE.item("reactor_component.rod_dual_uranium_mox", ComponentItem::create)
            .lang("Rod Dual Uranium Mox")
            .onRegister(attach(new FuelRodBehavior(1, 1, 1, 1, false)))
            .register();
    public static ItemEntry<ComponentItem> ROD_QUAD_URANIUM_MOX = EP_REGISTRATE.item("reactor_component.rod_quad_uranium_mox", ComponentItem::create)
            .lang("Rod Quad Uranium Mox")
            .onRegister(attach(new FuelRodBehavior(1, 1, 1, 1, false)))
            .register();
    public static ItemEntry<ComponentItem> ROD_THORIUM = EP_REGISTRATE.item("reactor_component.rod_thorium", ComponentItem::create)
            .lang("Rod Thorium")
            .onRegister(attach(new FuelRodBehavior(1, 1, 1, 1, false)))
            .register();
    public static ItemEntry<ComponentItem> ROD_DUAL_THORIUM = EP_REGISTRATE.item("reactor_component.rod_dual_thorium", ComponentItem::create)
            .lang("Rod Dual Thorium")
            .onRegister(attach(new FuelRodBehavior(1, 1, 1, 1, false)))
            .register();
    public static ItemEntry<ComponentItem> ROD_QUAD_THORIUM = EP_REGISTRATE.item("reactor_component.rod_quad_thorium", ComponentItem::create)
            .lang("Rod Quad Thorium")
            .onRegister(attach(new FuelRodBehavior(1, 1, 1, 1, false)))
            .register();
    public static ItemEntry<ComponentItem> ROD_NAQUADAH = EP_REGISTRATE.item("reactor_component.rod_naquadah", ComponentItem::create)
            .lang("Rod Naquadah")
            .onRegister(attach(new FuelRodBehavior(1, 1, 1, 1, false)))
            .register();
    public static ItemEntry<ComponentItem> ROD_DUAL_NAQUADAH = EP_REGISTRATE.item("reactor_component.rod_dual_naquadah", ComponentItem::create)
            .lang("Rod Dual Naquadah")
            .onRegister(attach(new FuelRodBehavior(1, 1, 1, 1, false)))
            .register();
    public static ItemEntry<ComponentItem> ROD_QUAD_NAQUADAH = EP_REGISTRATE.item("reactor_component.rod_quad_naquadah", ComponentItem::create)
            .lang("Rod Quad Naquadah")
            .onRegister(attach(new FuelRodBehavior(1, 1, 1, 1, false)))
            .register();
    public static ItemEntry<ComponentItem> ROD_NAQUADRIA = EP_REGISTRATE.item("reactor_component.rod_naquadria", ComponentItem::create)
            .lang("Rod Naquadria")
            .onRegister(attach(new FuelRodBehavior(1, 1, 1, 1, false)))
            .register();
    public static ItemEntry<ComponentItem> ROD_DUAL_NAQUADRIA = EP_REGISTRATE.item("reactor_component.rod_dual_naquadria", ComponentItem::create)
            .lang("Rod Dual Naquadria")
            .onRegister(attach(new FuelRodBehavior(1, 1, 1, 1, false)))
            .register();
    public static ItemEntry<ComponentItem> ROD_QUAD_NAQUADRIA = EP_REGISTRATE.item("reactor_component.rod_quad_naquadria", ComponentItem::create)
            .lang("Rod Quad Naquadria")
            .onRegister(attach(new FuelRodBehavior(1, 1, 1, 1, false)))
            .register();
    public static ItemEntry<ComponentItem> ROD_ENRICHED_PLUTONIUM = EP_REGISTRATE.item("reactor_component.rod_enriched_plutonium", ComponentItem::create)
            .lang("Rod Enriched Plutonium")
            .onRegister(attach(new FuelRodBehavior(1, 1, 1, 1, false)))
            .register();
    public static ItemEntry<ComponentItem> ROD_DUAL_ENRICHED_PLUTONIUM = EP_REGISTRATE.item("reactor_component.rod_dual_enriched_plutonium", ComponentItem::create)
            .lang("Rod Dual Enriched Plutonium")
            .onRegister(attach(new FuelRodBehavior(1, 1, 1, 1, false)))
            .register();
    public static ItemEntry<ComponentItem> ROD_QUAD_ENRICHED_PLUTONIUM = EP_REGISTRATE.item("reactor_component.rod_quad_enriched_plutonium", ComponentItem::create)
            .lang("Rod Quad Enriched Plutonium")
            .onRegister(attach(new FuelRodBehavior(1, 1, 1, 1, false)))
            .register();
    public static ItemEntry<ComponentItem> ROD_ENRICHED_URANIUM = EP_REGISTRATE.item("reactor_component.rod_enriched_uranium", ComponentItem::create)
            .lang("Rod Enriched Uranium")
            .onRegister(attach(new FuelRodBehavior(1, 1, 1, 1, false)))
            .register();
    public static ItemEntry<ComponentItem> ROD_DUAL_ENRICHED_URANIUM = EP_REGISTRATE.item("reactor_component.rod_dual_enriched_uranium", ComponentItem::create)
            .lang("Rod Dual Enriched Uranium")
            .onRegister(attach(new FuelRodBehavior(1, 1, 1, 1, false)))
            .register();
    public static ItemEntry<ComponentItem> ROD_QUAD_ENRICHED_URANIUM = EP_REGISTRATE.item("reactor_component.rod_quad_enriched_uranium", ComponentItem::create)
            .lang("Rod Quad Enriched Uranium")
            .onRegister(attach(new FuelRodBehavior(1, 1, 1, 1, false)))
            .register();
    public static ItemEntry<ComponentItem> ROD_LIQUID_URANIUM = EP_REGISTRATE.item("reactor_component.rod_liquid_uranium", ComponentItem::create)
            .lang("Rod Liquid Uranium")
            .onRegister(attach(new FuelRodBehavior(1, 1, 1, 1, false)))
            .register();
    public static ItemEntry<ComponentItem> ROD_DUAL_LIQUID_URANIUM = EP_REGISTRATE.item("reactor_component.rod_dual_liquid_uranium", ComponentItem::create)
            .lang("Rod Dual Liquid Uranium")
            .onRegister(attach(new FuelRodBehavior(1, 1, 1, 1, false)))
            .register();
    public static ItemEntry<ComponentItem> ROD_QUAD_LIQUID_URANIUM = EP_REGISTRATE.item("reactor_component.rod_quad_liquid_uranium", ComponentItem::create)
            .lang("Rod Quad Liquid Uranium")
            .onRegister(attach(new FuelRodBehavior(1, 1, 1, 1, false)))
            .register();
    public static ItemEntry<ComponentItem> ROD_LIQUID_PLUTONIUM = EP_REGISTRATE.item("reactor_component.rod_liquid_plutonium", ComponentItem::create)
            .lang("Rod Luquid Plutonium")
            .onRegister(attach(new FuelRodBehavior(1, 1, 1, 1, false)))
            .register();
    public static ItemEntry<ComponentItem> ROD_DUAL_LIQUID_PLUTONIUM = EP_REGISTRATE.item("reactor_component.rod_dual_liquid_plutonium", ComponentItem::create)
            .lang("Rod Dual Luquid Plutonium")
            .onRegister(attach(new FuelRodBehavior(1, 1, 1, 1, false)))
            .register();
    public static ItemEntry<ComponentItem> ROD_QUAD_LIQUID_PLUTONIUM = EP_REGISTRATE.item("reactor_component.rod_quad_liquid_plutonium", ComponentItem::create)
            .lang("Rod Quad Luquid Plutonium")
            .onRegister(attach(new FuelRodBehavior(1, 1, 1, 1, false)))
            .register();

    public static ItemEntry<Item> ROD_EMPTY = EP_REGISTRATE.item("rod_empty", Item::new).lang("Empty Fuel Rod").register();
    public static ItemEntry<Item> ROD_ADVANCED_EMPTY = EP_REGISTRATE.item("rod_advanced_empty", Item::new).lang("Empty Advanced Fuel Rod").register();
    public static ItemEntry<Item> ROD_URANIUM_DEPLETED = EP_REGISTRATE.item("rod_uranium_depleted", Item::new).lang("Rod Uranium Depleted").register();
    public static ItemEntry<Item> ROD_DUAL_URANIUM_DEPLETED = EP_REGISTRATE.item("rod_dual_uranium_depleted", Item::new).lang("Rod Dual Uranium Depleted").register();
    public static ItemEntry<Item> ROD_QUAD_URANIUM_DEPLETED = EP_REGISTRATE.item("rod_quad_uranium_depleted", Item::new).lang("Rod Quad Uranium Depleted").register();
    public static ItemEntry<Item> ROD_URANIUM_MOX_DEPLETED = EP_REGISTRATE.item("rod_uranium_mox_depleted", Item::new).lang("Rod Uranium Mox Depleted").register();
    public static ItemEntry<Item> ROD_DUAL_URANIUM_MOX_DEPLETED = EP_REGISTRATE.item("rod_dual_uranium_mox_depleted", Item::new).lang("Rod Dual Uranium Mox Depleted").register();
    public static ItemEntry<Item> ROD_QUAD_URANIUM_MOX_DEPLETED = EP_REGISTRATE.item("rod_quad_uranium_mox_depleted", Item::new).lang("Rod Quad Uranium Mox Depleted").register();
    public static ItemEntry<Item> ROD_THORIUM_DEPLETED = EP_REGISTRATE.item("rod_thorium_depleted", Item::new).lang("Rod Thorium Depleted").register();
    public static ItemEntry<Item> ROD_DUAL_THORIUM_DEPLETED = EP_REGISTRATE.item("rod_dual_thorium_depleted", Item::new).lang("Rod Dual Thorium Depleted").register();
    public static ItemEntry<Item> ROD_QUAD_THORIUM_DEPLETED = EP_REGISTRATE.item("rod_quad_thorium_depleted", Item::new).lang("Rod Quad Thorium Depleted").register();
    public static ItemEntry<Item> ROD_NAQUADAH_DEPLETED = EP_REGISTRATE.item("rod_naquadah_depleted", Item::new).lang("Rod Naquadah Depleted").register();
    public static ItemEntry<Item> ROD_DUAL_NAQUADAH_DEPLETED = EP_REGISTRATE.item("rod_dual_naquadah_depleted", Item::new).lang("Rod Dual Naquadah Depleted").register();
    public static ItemEntry<Item> ROD_QUAD_NAQUADAH_DEPLETED = EP_REGISTRATE.item("rod_quad_naquadah_depleted", Item::new).lang("Rod Quad Naquadah Depleted").register();
    public static ItemEntry<Item> ROD_NAQUADRIA_DEPLETED = EP_REGISTRATE.item("rod_naquadria_depleted", Item::new).lang("Rod Naquadria Depleted").register();
    public static ItemEntry<Item> ROD_DUAL_NAQUADRIA_DEPLETED = EP_REGISTRATE.item("rod_dual_naquadria_depleted", Item::new).lang("Rod Dual Naquadria Depleted").register();
    public static ItemEntry<Item> ROD_QUAD_NAQUADRIA_DEPLETED = EP_REGISTRATE.item("rod_quad_naquadria_depleted", Item::new).lang("Rod Quad Naquadria Depleted").register();
    public static ItemEntry<Item> ROD_ENRICHED_PLUTONIUM_DEPLETED = EP_REGISTRATE.item("rod_enriched_plutonium_depleted", Item::new).lang("Rod Enriched Plutonium Depleted").register();
    public static ItemEntry<Item> ROD_DUAL_ENRICHED_PLUTONIUM_DEPLETED = EP_REGISTRATE.item("rod_dual_enriched_plutonium_depleted", Item::new).lang("Rod Dual Enriched Plutonium Depleted").register();
    public static ItemEntry<Item> ROD_QUAD_ENRICHED_PLUTONIUM_DEPLETED = EP_REGISTRATE.item("rod_quad_enriched_plutonium_depleted", Item::new).lang("Rod Quad Enriched Plutonium Depleted").register();
    public static ItemEntry<Item> ROD_ENRICHED_URANIUM_DEPLETED = EP_REGISTRATE.item("rod_enriched_uranium_depleted", Item::new).lang("Rod Enriched Uranium Depleted").register();
    public static ItemEntry<Item> ROD_DUAL_ENRICHED_URANIUM_DEPLETED = EP_REGISTRATE.item("rod_dual_enriched_uranium_depleted", Item::new).lang("Rod Dual Enriched Uranium Depleted").register();
    public static ItemEntry<Item> ROD_QUAD_ENRICHED_URANIUM_DEPLETED = EP_REGISTRATE.item("rod_quad_enriched_uranium_depleted", Item::new).lang("Rod Quad Enriched Uranium Depleted").register();
    public static ItemEntry<Item> ROD_LIQUID_URANIUM_DEPLETED = EP_REGISTRATE.item("rod_liquid_uranium_depleted", Item::new).lang("Rod Liquid Uranium Depleted").register();
    public static ItemEntry<Item> ROD_DUAL_LIQUID_URANIUM_DEPLETED = EP_REGISTRATE.item("rod_dual_liquid_uranium_depleted", Item::new).lang("Rod Dual Liquid Uranium Depleted").register();
    public static ItemEntry<Item> ROD_QUAD_LIQUID_URANIUM_DEPLETED = EP_REGISTRATE.item("rod_quad_liquid_uranium_depleted", Item::new).lang("Rod Quad Liquid Uranium Depleted").register();
    public static ItemEntry<Item> ROD_LIQUID_PLUTONIUM_DEPLETED = EP_REGISTRATE.item("rod_liquid_plutonium_depleted", Item::new).lang("Rod Liquid Plutonium Depleted").register();
    public static ItemEntry<Item> ROD_DUAL_LIQUID_PLUTONIUM_DEPLETED = EP_REGISTRATE.item("rod_dual_liquid_plutonium_depleted", Item::new).lang("Rod Dual Liquid Plutonium Depleted").register();
    public static ItemEntry<Item> ROD_QUAD_LIQUID_PLUTONIUM_DEPLETED = EP_REGISTRATE.item("rod_quad_liquid_plutonium_depleted", Item::new).lang("Rod Quad Liquid Plutonium Depleted").register();

    public final static ItemEntry<ComponentItem> RADIOACTIVE_WASTE = registerItemWithTooltip("radioactive_waste", ComponentItem::create, 1).lang("Radioactive Waste").register();

    private EPPhysicsItems() {/**/}

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
