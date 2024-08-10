package com.epimorphismmc.epimorphism.common.data.items;

import com.epimorphismmc.epimorphism.Epimorphism;
import com.epimorphismmc.epimorphism.common.data.EPCreativeModeTabs;
import com.epimorphismmc.epimorphism.common.data.EPModels;
import com.epimorphismmc.epimorphism.common.item.behaviors.reactor.CoolantCellBehavior;
import com.epimorphismmc.epimorphism.common.item.behaviors.reactor.ExchangerBehavior;
import com.epimorphismmc.epimorphism.common.item.behaviors.reactor.FuelRodBehavior;
import com.epimorphismmc.epimorphism.common.item.behaviors.reactor.PlatingBehavior;
import com.epimorphismmc.epimorphism.common.item.behaviors.reactor.ReflectorBehavior;
import com.epimorphismmc.epimorphism.common.item.behaviors.reactor.VentBehavior;

import com.gregtechceu.gtceu.api.item.ComponentItem;
import com.gregtechceu.gtceu.common.item.TooltipBehavior;

import com.lowdragmc.lowdraglib.utils.LocalizationUtils;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.builders.ItemBuilder;
import com.tterrag.registrate.util.entry.ItemEntry;

import static com.epimorphismmc.epimorphism.EpimorphismCommon.registrate;
import static com.epimorphismmc.epimorphism.common.data.EPItems.*;
import static com.gregtechceu.gtceu.common.data.GTItems.*;

public class EPPhysicsItems {

    static {
        registrate().creativeModeTab(() -> EPCreativeModeTabs.EP_PHYSICS);
    }

    //  High Energy Physics Items
    public static final ItemEntry<ComponentItem> PLASMA_CONTAINMENT_CELL =
            registerItemWithTooltip("plasma_containment_cell", 1).register();
    public static final ItemEntry<ComponentItem> RHENIUM_PLASMA_CONTAINMENT_CELL =
            registerItemWithTooltip("rhenium_plasma_containment_cell", 1).register();
    public static final ItemEntry<ComponentItem> NEUTRON_PLASMA_CONTAINMENT_CELL =
            registerItemWithTooltip("neutron_plasma_containment_cell", 1).register();
    public static final ItemEntry<ComponentItem> HYPOGEN_PLASMA_CONTAINMENT_CELL =
            registerItemWithTooltip("hypogen_plasma_containment_cell", 1).register();
    public static final ItemEntry<ComponentItem> ACTINIUM_SUPERHYDRIDE_PLASMA_CONTAINMENT_CELL =
            registerItemWithTooltip("actinium_superhydride_plasma_containment_cell", 1)
                    .register();
    public static final ItemEntry<ComponentItem> QUANTUM_ANOMALY =
            registerItemWithTooltip("quantum_anomaly", 1).register();

    //  Particle Capsule
    public static final ItemEntry<ComponentItem> EMPTY_PARTICLE_CAPSULE = registerItemWithTooltip(
                    "empty_particle_capsule", 1)
            .model(EPModels.simpleCustomModel(
                    new ResourceLocation("item/generated"),
                    Epimorphism.id("item/particle_capsule/capsule_base")))
            .register();
    public static final ItemEntry<ComponentItem> TOP_QUARK_PARTICLE_CAPSULE = registerParticleCapsule(
                    "top_quark", ParticleType.QUARK)
            .lang("Top Quark Capsule")
            .register();
    public static final ItemEntry<ComponentItem> BOTTOM_QUARK_PARTICLE_CAPSULE =
            registerParticleCapsule("bottom_quark", ParticleType.QUARK)
                    .lang("Bottom Quark Capsule")
                    .register();
    public static final ItemEntry<ComponentItem> UP_QUARK_PARTICLE_CAPSULE = registerParticleCapsule(
                    "up_quark", ParticleType.QUARK)
            .lang("Up Quark Capsule")
            .register();
    public static final ItemEntry<ComponentItem> DOWN_QUARK_PARTICLE_CAPSULE =
            registerParticleCapsule("down_quark", ParticleType.QUARK)
                    .lang("Down Quark Capsule")
                    .register();
    public static final ItemEntry<ComponentItem> CHARM_QUARK_PARTICLE_CAPSULE =
            registerParticleCapsule("charm_quark", ParticleType.QUARK)
                    .lang("Charm Quark Capsule")
                    .register();
    public static final ItemEntry<ComponentItem> STRANGE_QUARK_PARTICLE_CAPSULE =
            registerParticleCapsule("strange_quark", ParticleType.QUARK)
                    .lang("Strange Quark Capsule")
                    .register();
    public static final ItemEntry<ComponentItem> ELECTRON_PARTICLE_CAPSULE = registerParticleCapsule(
                    "electron", ParticleType.LEPTON)
            .lang("Electron Capsule")
            .register();
    public static final ItemEntry<ComponentItem> ELECTRON_NEUTRINO_PARTICLE_CAPSULE =
            registerParticleCapsule("electron_neutrino", ParticleType.LEPTON)
                    .lang("Electron Neutrino Capsule")
                    .register();
    public static final ItemEntry<ComponentItem> MUON_PARTICLE_CAPSULE =
            registerParticleCapsule("muon", ParticleType.LEPTON).lang("Muon Capsule").register();
    public static final ItemEntry<ComponentItem> MUON_NEUTRINO_PARTICLE_CAPSULE =
            registerParticleCapsule("muon_neutrino", ParticleType.LEPTON)
                    .lang("Muon Neutrino Capsule")
                    .register();
    public static final ItemEntry<ComponentItem> TAUON_PARTICLE_CAPSULE = registerParticleCapsule(
                    "tauon", ParticleType.LEPTON)
            .lang("Tauon Capsule")
            .register();
    public static final ItemEntry<ComponentItem> TAU_NEUTRINO_PARTICLE_CAPSULE =
            registerParticleCapsule("tau_neutrino", ParticleType.LEPTON)
                    .lang("Tau Neutrino Capsule")
                    .register();
    public static final ItemEntry<ComponentItem> GRAVITON_PARTICLE_CAPSULE = registerParticleCapsule(
                    "graviton", ParticleType.BOSON)
            .lang("Graviton Capsule")
            .register();
    public static final ItemEntry<ComponentItem> GLUON_PARTICLE_CAPSULE =
            registerParticleCapsule("gluon", ParticleType.BOSON).lang("Gluon Capsule").register();
    public static final ItemEntry<ComponentItem> PHOTON_PARTICLE_CAPSULE = registerParticleCapsule(
                    "photon", ParticleType.BOSON)
            .lang("Photon Capsule")
            .register();
    public static final ItemEntry<ComponentItem> W_BOSON_PARTICLE_CAPSULE = registerParticleCapsule(
                    "w_boson", ParticleType.BOSON)
            .lang("W Boson Capsule")
            .register();
    public static final ItemEntry<ComponentItem> Z_BOSON_PARTICLE_CAPSULE = registerParticleCapsule(
                    "z_boson", ParticleType.BOSON)
            .lang("Z Boson Capsule")
            .register();
    public static final ItemEntry<ComponentItem> HIGGS_BOSON_PARTICLE_CAPSULE =
            registerParticleCapsule("higgs_boson", ParticleType.BOSON)
                    .lang("Higgs Boson Capsule")
                    .register();
    public static final ItemEntry<ComponentItem> PROTON_PARTICLE_CAPSULE = registerParticleCapsule(
                    "proton", ParticleType.BARYON)
            .lang("Proton Capsule")
            .register();
    public static final ItemEntry<ComponentItem> NEUTRON_PARTICLE_CAPSULE = registerParticleCapsule(
                    "neutron", ParticleType.BARYON)
            .lang("Neutron Capsule")
            .register();
    public static final ItemEntry<ComponentItem> PARTICLE_CAPSULE = registerParticleCapsule(
                    "lambda_baryon", ParticleType.BARYON)
            .lang("Lambda Baryon Capsule")
            .register();
    public static final ItemEntry<ComponentItem> OMEGA_BARYON_PARTICLE_CAPSULE =
            registerParticleCapsule("omega_baryon", ParticleType.BARYON)
                    .lang("Omega Baryon Capsule")
                    .register();
    public static final ItemEntry<ComponentItem> PI_MESON_PARTICLE_CAPSULE = registerParticleCapsule(
                    "pi_meson", ParticleType.MESON)
            .lang("Pi Meson Capsule")
            .register();
    public static final ItemEntry<ComponentItem> ETA_MESON_PARTICLE_CAPSULE = registerParticleCapsule(
                    "eta_meson", ParticleType.MESON)
            .lang("Eta Meson Capsule")
            .register();
    public static final ItemEntry<ComponentItem> KERR_BLACK_HOLE_PARTICLE_CAPSULE =
            registerParticleCapsule("kerr_black_hole").lang("Kerr Black Hole Capsule").register();

    //  Nuclear Physics items
    public static ItemEntry<Item> NEUTRON_SOURCE =
            registrate().item("neutron_source", Item::new).lang("Neutron Source").register();
    public static ItemEntry<ComponentItem> ELECTRON_SOURCE =
            registerItemWithTooltip("electron_source", 1).register();
    public static ItemEntry<Item> PLATE_RADIATION_PROTECTION = registrate()
            .item("plate_radiation_protection", Item::new)
            .lang("Radiation Protection Plate")
            .register();
    public static ItemEntry<Item> ADV_PLATE_RADIATION_PROTECTION = registrate()
            .item("advanced_plate_radiation_protection", Item::new)
            .lang("Advanced Radiation Protection Plate")
            .register();
    public static ItemEntry<Item> ENCAPSULATED_URANIUM = registrate()
            .item("encapsulated_uranium", Item::new)
            .lang("Encapsulated Uranium")
            .register();
    public static ItemEntry<Item> ENRICHED_URANIUM_NUGGET = registrate()
            .item("enriched_uranium_nugget", Item::new)
            .lang("Enriched Uranium Nugget")
            .register();
    public static ItemEntry<Item> ENRICHED_URANIUM =
            registrate().item("enriched_uranium", Item::new).lang("Enriched Uranium").register();
    public static ItemEntry<Item> ENCAPSULATED_THORIUM = registrate()
            .item("encapsulated_thorium", Item::new)
            .lang("Encapsulated Thorium")
            .register();
    public static ItemEntry<Item> ENRICHED_THORIUM_NUGGET = registrate()
            .item("enriched_thorium_nugget", Item::new)
            .lang("Enriched Thorium Nugget")
            .register();
    public static ItemEntry<Item> ENRICHED_THORIUM =
            registrate().item("enriched_thorium", Item::new).lang("Enriched Thorium").register();
    public static ItemEntry<Item> ENCAPSULATED_PLUTONIUM = registrate()
            .item("encapsulated_plutonium", Item::new)
            .lang("Encapsulated Plutonium")
            .register();
    public static ItemEntry<Item> ENRICHED_PLUTONIUM_NUGGET = registrate()
            .item("enriched_plutonium_nugget", Item::new)
            .lang("Enriched Plutonium Nugget")
            .register();
    public static ItemEntry<Item> ENRICHED_PLUTONIUM = registrate()
            .item("enriched_plutonium", Item::new)
            .lang("Enriched Plutonium")
            .register();

    public static ItemEntry<ComponentItem> NEUTRON_REFLECTOR = registerReactorComponent(
                    "neutron_reflector")
            .lang("Neutron Reflector")
            .onRegister(attach(new ReflectorBehavior(3000)))
            .register();
    public static ItemEntry<ComponentItem> THICK_NEUTRON_REFLECTOR = registerReactorComponent(
                    "thick_neutron_reflector")
            .lang("Thick Neutron Reflector")
            .onRegister(attach(new ReflectorBehavior(12000)))
            .register();
    public static ItemEntry<ComponentItem> IRIDIUM_REFLECTOR = registerReactorComponent(
                    "iridium_reflector")
            .lang("Iridium Reflector")
            .onRegister(attach(new ReflectorBehavior(-1)))
            .register();
    public static ItemEntry<ComponentItem> PLATING = registerReactorComponent("plating")
            .lang("Plating")
            .onRegister(attach(new PlatingBehavior(1000, 0.95F)))
            .register();
    public static ItemEntry<ComponentItem> CONTAINMENT_PLATING = registerReactorComponent(
                    "containment_plating")
            .lang("Containment Plating")
            .onRegister(attach(new PlatingBehavior(500, 0.9F)))
            .register();
    public static ItemEntry<ComponentItem> HEAT_PLATING = registerReactorComponent("heat_plating")
            .lang("Heat Plating")
            .onRegister(attach(new PlatingBehavior(1700, 0.99F)))
            .register();
    public static ItemEntry<ComponentItem> HEAT_EXCHANGER = registerReactorComponent("heat_exchanger")
            .lang("Heat Exchanger")
            .onRegister(attach(new ExchangerBehavior(2500, 12, 4)))
            .register();
    public static ItemEntry<ComponentItem> REACTOR_HEAT_EXCHANGER = registerReactorComponent(
                    "reactor_heat_exchanger")
            .lang("Reactor Heat Exchanger")
            .onRegister(attach(new ExchangerBehavior(5000, 0, 72)))
            .register();
    public static ItemEntry<ComponentItem> COMPONENT_HEAT_EXCHANGER = registerReactorComponent(
                    "component_heat_exchanger")
            .lang("Component Heat Exchanger")
            .onRegister(attach(new ExchangerBehavior(5000, 36, 0)))
            .register();
    public static ItemEntry<ComponentItem> ADVANCED_HEAT_EXCHANGER = registerReactorComponent(
                    "advanced_heat_exchanger")
            .lang("Advanced Heat Exchanger")
            .onRegister(attach(new ExchangerBehavior(10000, 24, 8)))
            .register();
    public static ItemEntry<ComponentItem> HEAT_VENT = registerReactorComponent("heat_vent")
            .lang("Heat Vent")
            .onRegister(attach(new VentBehavior(1000, 6, 0, 0)))
            .register();
    public static ItemEntry<ComponentItem> REACTOR_HEAT_VENT = registerReactorComponent(
                    "reactor_heat_vent")
            .lang("Reactor Heat Vent")
            .onRegister(attach(new VentBehavior(1000, 5, 5, 0)))
            .register();
    public static ItemEntry<ComponentItem> COMPONENT_HEAT_VENT = registerReactorComponent(
                    "component_heat_vent")
            .lang("Component Heat Vent")
            .onRegister(attach(new VentBehavior(-1, 0, 0, 4)))
            .register();
    public static ItemEntry<ComponentItem> ADVANCED_HEAT_VENT = registerReactorComponent(
                    "advanced_heat_vent")
            .lang("Advanced Heat Vent")
            .onRegister(attach(new VentBehavior(1000, 12, 0, 0)))
            .register();
    public static ItemEntry<ComponentItem> OVERCLOCKED_HEAT_VENT = registerReactorComponent(
                    "overclocked_heat_vent")
            .lang("Overclocked Heat Vent")
            .onRegister(attach(new VentBehavior(1000, 20, 36, 0)))
            .register();
    public static ItemEntry<ComponentItem> WATER_COOLANT_CELL_10K = registerReactorComponent(
                    "water_coolant_cell_10k")
            .lang("Water Coolant Cell 10k")
            .onRegister(attach(new CoolantCellBehavior(10000)))
            .register();
    public static ItemEntry<ComponentItem> WATER_COOLANT_CELL_30K = registerReactorComponent(
                    "water_coolant_cell_30k")
            .lang("Water Coolant Cell 30k")
            .onRegister(attach(new CoolantCellBehavior(30000)))
            .register();
    public static ItemEntry<ComponentItem> WATER_COOLANT_CELL_60K = registerReactorComponent(
                    "water_coolant_cell_60k")
            .lang("Water Coolant Cell 60k")
            .onRegister(attach(new CoolantCellBehavior(60000)))
            .register();
    public static ItemEntry<ComponentItem> HELIUM_COOLANT_CELL_60K = registerReactorComponent(
                    "helium_coolant_cell_60k")
            .lang("Helium Coolant Cell 60k")
            .onRegister(attach(new CoolantCellBehavior(60000)))
            .register();
    public static ItemEntry<ComponentItem> HELIUM_COOLANT_CELL_180K = registerReactorComponent(
                    "helium_coolant_cell_180k")
            .lang("Helium Coolant Cell 180k")
            .onRegister(attach(new CoolantCellBehavior(180000)))
            .register();
    public static ItemEntry<ComponentItem> HELIUM_COOLANT_CELL_360K = registerReactorComponent(
                    "helium_coolant_cell_360k")
            .lang("Helium Coolant Cell 360k")
            .onRegister(attach(new CoolantCellBehavior(360000)))
            .register();
    public static ItemEntry<ComponentItem> NAK_COOLANT_CELL_60K = registerReactorComponent(
                    "nak_coolant_cell_60k")
            .lang("Nak Coolant Cell 60k")
            .onRegister(attach(new CoolantCellBehavior(60000)))
            .register();
    public static ItemEntry<ComponentItem> NAK_COOLANT_CELL_180K = registerReactorComponent(
                    "nak_coolant_cell_180k")
            .lang("Nak Coolant Cell 180k")
            .onRegister(attach(new CoolantCellBehavior(180000)))
            .register();
    public static ItemEntry<ComponentItem> NAK_COOLANT_CELL_360K = registerReactorComponent(
                    "nak_coolant_cell_360k")
            .lang("Nak Coolant Cell 360k")
            .onRegister(attach(new CoolantCellBehavior(360000)))
            .register();

    public static ItemEntry<ComponentItem> ROD_URANIUM = registerReactorComponent("rod_uranium")
            .lang("Rod Uranium")
            .onRegister(attach(new FuelRodBehavior(1, 1, 1, 1, false)))
            .register();
    public static ItemEntry<ComponentItem> ROD_DUAL_URANIUM = registerReactorComponent(
                    "rod_dual_uranium")
            .lang("Rod Dual Uranium")
            .onRegister(attach(new FuelRodBehavior(1, 1, 1, 1, false)))
            .register();
    public static ItemEntry<ComponentItem> ROD_QUAD_URANIUM = registerReactorComponent(
                    "rod_quad_uranium")
            .lang("Rod Quad Uranium")
            .onRegister(attach(new FuelRodBehavior(1, 1, 1, 1, false)))
            .register();
    public static ItemEntry<ComponentItem> ROD_URANIUM_MOX = registerReactorComponent(
                    "rod_uranium_mox")
            .lang("Rod Uranium Mox")
            .onRegister(attach(new FuelRodBehavior(1, 1, 1, 1, false)))
            .register();
    public static ItemEntry<ComponentItem> ROD_DUAL_URANIUM_MOX = registerReactorComponent(
                    "rod_dual_uranium_mox")
            .lang("Rod Dual Uranium Mox")
            .onRegister(attach(new FuelRodBehavior(1, 1, 1, 1, false)))
            .register();
    public static ItemEntry<ComponentItem> ROD_QUAD_URANIUM_MOX = registerReactorComponent(
                    "rod_quad_uranium_mox")
            .lang("Rod Quad Uranium Mox")
            .onRegister(attach(new FuelRodBehavior(1, 1, 1, 1, false)))
            .register();
    public static ItemEntry<ComponentItem> ROD_THORIUM = registerReactorComponent("rod_thorium")
            .lang("Rod Thorium")
            .onRegister(attach(new FuelRodBehavior(1, 1, 1, 1, false)))
            .register();
    public static ItemEntry<ComponentItem> ROD_DUAL_THORIUM = registerReactorComponent(
                    "rod_dual_thorium")
            .lang("Rod Dual Thorium")
            .onRegister(attach(new FuelRodBehavior(1, 1, 1, 1, false)))
            .register();
    public static ItemEntry<ComponentItem> ROD_QUAD_THORIUM = registerReactorComponent(
                    "rod_quad_thorium")
            .lang("Rod Quad Thorium")
            .onRegister(attach(new FuelRodBehavior(1, 1, 1, 1, false)))
            .register();
    public static ItemEntry<ComponentItem> ROD_NAQUADAH = registerReactorComponent("rod_naquadah")
            .lang("Rod Naquadah")
            .onRegister(attach(new FuelRodBehavior(1, 1, 1, 1, false)))
            .register();
    public static ItemEntry<ComponentItem> ROD_DUAL_NAQUADAH = registerReactorComponent(
                    "rod_dual_naquadah")
            .lang("Rod Dual Naquadah")
            .onRegister(attach(new FuelRodBehavior(1, 1, 1, 1, false)))
            .register();
    public static ItemEntry<ComponentItem> ROD_QUAD_NAQUADAH = registerReactorComponent(
                    "rod_quad_naquadah")
            .lang("Rod Quad Naquadah")
            .onRegister(attach(new FuelRodBehavior(1, 1, 1, 1, false)))
            .register();
    public static ItemEntry<ComponentItem> ROD_NAQUADRIA = registerReactorComponent("rod_naquadria")
            .lang("Rod Naquadria")
            .onRegister(attach(new FuelRodBehavior(1, 1, 1, 1, false)))
            .register();
    public static ItemEntry<ComponentItem> ROD_DUAL_NAQUADRIA = registerReactorComponent(
                    "rod_dual_naquadria")
            .lang("Rod Dual Naquadria")
            .onRegister(attach(new FuelRodBehavior(1, 1, 1, 1, false)))
            .register();
    public static ItemEntry<ComponentItem> ROD_QUAD_NAQUADRIA = registerReactorComponent(
                    "rod_quad_naquadria")
            .lang("Rod Quad Naquadria")
            .onRegister(attach(new FuelRodBehavior(1, 1, 1, 1, false)))
            .register();
    public static ItemEntry<ComponentItem> ROD_ENRICHED_PLUTONIUM = registerReactorComponent(
                    "rod_enriched_plutonium")
            .lang("Rod Enriched Plutonium")
            .onRegister(attach(new FuelRodBehavior(1, 1, 1, 1, false)))
            .register();
    public static ItemEntry<ComponentItem> ROD_DUAL_ENRICHED_PLUTONIUM = registerReactorComponent(
                    "rod_dual_enriched_plutonium")
            .lang("Rod Dual Enriched Plutonium")
            .onRegister(attach(new FuelRodBehavior(1, 1, 1, 1, false)))
            .register();
    public static ItemEntry<ComponentItem> ROD_QUAD_ENRICHED_PLUTONIUM = registerReactorComponent(
                    "rod_quad_enriched_plutonium")
            .lang("Rod Quad Enriched Plutonium")
            .onRegister(attach(new FuelRodBehavior(1, 1, 1, 1, false)))
            .register();
    public static ItemEntry<ComponentItem> ROD_ENRICHED_URANIUM = registerReactorComponent(
                    "rod_enriched_uranium")
            .lang("Rod Enriched Uranium")
            .onRegister(attach(new FuelRodBehavior(1, 1, 1, 1, false)))
            .register();
    public static ItemEntry<ComponentItem> ROD_DUAL_ENRICHED_URANIUM = registerReactorComponent(
                    "rod_dual_enriched_uranium")
            .lang("Rod Dual Enriched Uranium")
            .onRegister(attach(new FuelRodBehavior(1, 1, 1, 1, false)))
            .register();
    public static ItemEntry<ComponentItem> ROD_QUAD_ENRICHED_URANIUM = registerReactorComponent(
                    "rod_quad_enriched_uranium")
            .lang("Rod Quad Enriched Uranium")
            .onRegister(attach(new FuelRodBehavior(1, 1, 1, 1, false)))
            .register();
    public static ItemEntry<ComponentItem> ROD_LIQUID_URANIUM = registerReactorComponent(
                    "rod_liquid_uranium")
            .lang("Rod Liquid Uranium")
            .onRegister(attach(new FuelRodBehavior(1, 1, 1, 1, false)))
            .register();
    public static ItemEntry<ComponentItem> ROD_DUAL_LIQUID_URANIUM = registerReactorComponent(
                    "rod_dual_liquid_uranium")
            .lang("Rod Dual Liquid Uranium")
            .onRegister(attach(new FuelRodBehavior(1, 1, 1, 1, false)))
            .register();
    public static ItemEntry<ComponentItem> ROD_QUAD_LIQUID_URANIUM = registerReactorComponent(
                    "rod_quad_liquid_uranium")
            .lang("Rod Quad Liquid Uranium")
            .onRegister(attach(new FuelRodBehavior(1, 1, 1, 1, false)))
            .register();
    public static ItemEntry<ComponentItem> ROD_LIQUID_PLUTONIUM = registerReactorComponent(
                    "rod_liquid_plutonium")
            .lang("Rod Luquid Plutonium")
            .onRegister(attach(new FuelRodBehavior(1, 1, 1, 1, false)))
            .register();
    public static ItemEntry<ComponentItem> ROD_DUAL_LIQUID_PLUTONIUM = registerReactorComponent(
                    "rod_dual_liquid_plutonium")
            .lang("Rod Dual Luquid Plutonium")
            .onRegister(attach(new FuelRodBehavior(1, 1, 1, 1, false)))
            .register();
    public static ItemEntry<ComponentItem> ROD_QUAD_LIQUID_PLUTONIUM = registerReactorComponent(
                    "rod_quad_liquid_plutonium")
            .lang("Rod Quad Luquid Plutonium")
            .onRegister(attach(new FuelRodBehavior(1, 1, 1, 1, false)))
            .register();

    public static ItemEntry<Item> ROD_EMPTY =
            registerItem("rod_empty").lang("Empty Fuel Rod").register();
    public static ItemEntry<Item> ROD_ADVANCED_EMPTY =
            registerItem("rod_advanced_empty").lang("Empty Advanced Fuel Rod").register();
    public static ItemEntry<Item> ROD_URANIUM_DEPLETED =
            registerItem("rod_uranium_depleted").lang("Rod Uranium Depleted").register();
    public static ItemEntry<Item> ROD_DUAL_URANIUM_DEPLETED = registerItem(
                    "rod_dual_uranium_depleted")
            .lang("Rod Dual Uranium Depleted")
            .register();
    public static ItemEntry<Item> ROD_QUAD_URANIUM_DEPLETED = registerItem(
                    "rod_quad_uranium_depleted")
            .lang("Rod Quad Uranium Depleted")
            .register();
    public static ItemEntry<Item> ROD_URANIUM_MOX_DEPLETED =
            registerItem("rod_uranium_mox_depleted").lang("Rod Uranium Mox Depleted").register();
    public static ItemEntry<Item> ROD_DUAL_URANIUM_MOX_DEPLETED = registerItem(
                    "rod_dual_uranium_mox_depleted")
            .lang("Rod Dual Uranium Mox Depleted")
            .register();
    public static ItemEntry<Item> ROD_QUAD_URANIUM_MOX_DEPLETED = registerItem(
                    "rod_quad_uranium_mox_depleted")
            .lang("Rod Quad Uranium Mox Depleted")
            .register();
    public static ItemEntry<Item> ROD_THORIUM_DEPLETED =
            registerItem("rod_thorium_depleted").lang("Rod Thorium Depleted").register();
    public static ItemEntry<Item> ROD_DUAL_THORIUM_DEPLETED = registerItem(
                    "rod_dual_thorium_depleted")
            .lang("Rod Dual Thorium Depleted")
            .register();
    public static ItemEntry<Item> ROD_QUAD_THORIUM_DEPLETED = registerItem(
                    "rod_quad_thorium_depleted")
            .lang("Rod Quad Thorium Depleted")
            .register();
    public static ItemEntry<Item> ROD_NAQUADAH_DEPLETED =
            registerItem("rod_naquadah_depleted").lang("Rod Naquadah Depleted").register();
    public static ItemEntry<Item> ROD_DUAL_NAQUADAH_DEPLETED = registerItem(
                    "rod_dual_naquadah_depleted")
            .lang("Rod Dual Naquadah Depleted")
            .register();
    public static ItemEntry<Item> ROD_QUAD_NAQUADAH_DEPLETED = registerItem(
                    "rod_quad_naquadah_depleted")
            .lang("Rod Quad Naquadah Depleted")
            .register();
    public static ItemEntry<Item> ROD_NAQUADRIA_DEPLETED =
            registerItem("rod_naquadria_depleted").lang("Rod Naquadria Depleted").register();
    public static ItemEntry<Item> ROD_DUAL_NAQUADRIA_DEPLETED = registerItem(
                    "rod_dual_naquadria_depleted")
            .lang("Rod Dual Naquadria Depleted")
            .register();
    public static ItemEntry<Item> ROD_QUAD_NAQUADRIA_DEPLETED = registerItem(
                    "rod_quad_naquadria_depleted")
            .lang("Rod Quad Naquadria Depleted")
            .register();
    public static ItemEntry<Item> ROD_ENRICHED_PLUTONIUM_DEPLETED = registerItem(
                    "rod_enriched_plutonium_depleted")
            .lang("Rod Enriched Plutonium Depleted")
            .register();
    public static ItemEntry<Item> ROD_DUAL_ENRICHED_PLUTONIUM_DEPLETED = registerItem(
                    "rod_dual_enriched_plutonium_depleted")
            .lang("Rod Dual Enriched Plutonium Depleted")
            .register();
    public static ItemEntry<Item> ROD_QUAD_ENRICHED_PLUTONIUM_DEPLETED = registerItem(
                    "rod_quad_enriched_plutonium_depleted")
            .lang("Rod Quad Enriched Plutonium Depleted")
            .register();
    public static ItemEntry<Item> ROD_ENRICHED_URANIUM_DEPLETED = registerItem(
                    "rod_enriched_uranium_depleted")
            .lang("Rod Enriched Uranium Depleted")
            .register();
    public static ItemEntry<Item> ROD_DUAL_ENRICHED_URANIUM_DEPLETED = registerItem(
                    "rod_dual_enriched_uranium_depleted")
            .lang("Rod Dual Enriched Uranium Depleted")
            .register();
    public static ItemEntry<Item> ROD_QUAD_ENRICHED_URANIUM_DEPLETED = registerItem(
                    "rod_quad_enriched_uranium_depleted")
            .lang("Rod Quad Enriched Uranium Depleted")
            .register();
    public static ItemEntry<Item> ROD_LIQUID_URANIUM_DEPLETED = registerItem(
                    "rod_liquid_uranium_depleted")
            .lang("Rod Liquid Uranium Depleted")
            .register();
    public static ItemEntry<Item> ROD_DUAL_LIQUID_URANIUM_DEPLETED = registerItem(
                    "rod_dual_liquid_uranium_depleted")
            .lang("Rod Dual Liquid Uranium Depleted")
            .register();
    public static ItemEntry<Item> ROD_QUAD_LIQUID_URANIUM_DEPLETED = registerItem(
                    "rod_quad_liquid_uranium_depleted")
            .lang("Rod Quad Liquid Uranium Depleted")
            .register();
    public static ItemEntry<Item> ROD_LIQUID_PLUTONIUM_DEPLETED = registerItem(
                    "rod_liquid_plutonium_depleted")
            .lang("Rod Liquid Plutonium Depleted")
            .register();
    public static ItemEntry<Item> ROD_DUAL_LIQUID_PLUTONIUM_DEPLETED = registerItem(
                    "rod_dual_liquid_plutonium_depleted")
            .lang("Rod Dual Liquid Plutonium Depleted")
            .register();
    public static ItemEntry<Item> ROD_QUAD_LIQUID_PLUTONIUM_DEPLETED = registerItem(
                    "rod_quad_liquid_plutonium_depleted")
            .lang("Rod Quad Liquid Plutonium Depleted")
            .register();

    public static final ItemEntry<ComponentItem> RADIOACTIVE_WASTE =
            registerItemWithTooltip("radioactive_waste", 1).register();

    private EPPhysicsItems() {
        /**/
    }

    public static void init() {}

    private static ItemBuilder<ComponentItem, Registrate> registerParticleCapsule(
            String name, ParticleType particleType) {
        return registrate()
                .item(name + "_particle_capsule", ComponentItem::create)
                .model(EPModels.simpleCustomModel(
                        new ResourceLocation("item/generated"),
                        Epimorphism.id("item/particle_capsule/capsule_base"),
                        Epimorphism.id("item/particle_capsule/" + name)))
                .onRegister(attach(new TooltipBehavior(lines -> lines.add(Component.translatable(
                        "epimorphism.universal.particle_type.desc", particleType.getText())))));
    }

    private static ItemBuilder<ComponentItem, Registrate> registerParticleCapsule(String name) {
        return registrate()
                .item(name + "_particle_capsule", ComponentItem::create)
                .model(EPModels.simpleCustomModel(
                        new ResourceLocation("item/generated"),
                        Epimorphism.id("item/particle_capsule/capsule_base"),
                        Epimorphism.id("item/particle_capsule/" + name)));
    }

    private static ItemBuilder<ComponentItem, Registrate> registerReactorComponent(String name) {
        return registrate()
                .item(name, ComponentItem::create)
                .model(EPModels.simpleCustomModel(
                        new ResourceLocation("item/generated"),
                        Epimorphism.id("item/reactor_component/" + name)));
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
