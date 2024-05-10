package cn.gtcommunity.epimorphism.api.block.property;

import cn.gtcommunity.epimorphism.utils.DirectionalConnectivity;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;

import java.util.Collection;
import java.util.Set;
import java.util.function.Predicate;

public final class EnhancePropertyConfiguration {
    public static EnhancePropertyConfiguration empty() {
        return EMPTY;
    }

    public static Builder builder() {
        return new Builder();
    }

    private final Set<EnhanceProperty<?>> properties;

    private EnhancePropertyConfiguration(Set<EnhanceProperty<?>> properties) {
        this.properties = ImmutableSet.copyOf(properties);
    }

    public boolean has(EnhanceProperty<?> property) {
        return this.properties.contains(property);
    }

    public StateDefinition.Builder<Block, BlockState> fillStateContainer(StateDefinition.Builder<Block, BlockState> builder) {
        this.properties.forEach((prop) -> prop.apply(builder));
        return builder;
    }

    public BlockState defineDefault(BlockState state) {
        for(EnhanceProperty<?> property : this.properties) {
            state = property.apply(state);
        }
        return state;
    }

    public BlockState handleMirror(BlockState state, Mirror mirror) {
        for(EnhanceProperty<?> property : this.properties) {
            state = property.mirror(state, mirror);
        }
        return state;
    }

    public BlockState handleRotation(BlockState state, Rotation rotation) {
        for(EnhanceProperty<?> property : this.properties) {
            state = property.rotate(state, rotation);
        }
        return state;
    }

    public boolean isWaterLoggable() {
        return this.has(EnhanceProperty.Defaults.waterlogged());
    }

    public boolean isLavaLoggable() {
        return this.has(EnhanceProperty.Defaults.lavalogged());
    }

    public boolean isFluidLoggable() {
        return this.has(EnhanceProperty.Defaults.fluidlogged());
    }

    private static final EnhancePropertyConfiguration EMPTY = builder().build();

    public static final class Builder {
        private final Set<EnhanceProperty<?>> properties;

        private Builder() {
            this.properties = Sets.newIdentityHashSet();
        }

        public EnhancePropertyConfiguration build() {
            return new EnhancePropertyConfiguration(this.properties);
        }

        public Builder add(String name, boolean defaultValue) {
            return this.add(EnhanceProperty.Creators.create(name, defaultValue));
        }

        public Builder add(String name, int def, int min, int max) {
            return this.add(EnhanceProperty.Creators.create(name, def, min, max));
        }

        public Builder add(String name, Direction defaultValue) {
            return this.add(EnhanceProperty.Creators.create(name, defaultValue));
        }

        public Builder addHorizontals(String name, Direction defaultValue) {
            return this.add(EnhanceProperty.Creators.createHorizontals(name, defaultValue));
        }

        public Builder add(String name, Direction.Axis defaultValue) {
            return this.add(EnhanceProperty.Creators.create(name, defaultValue));
        }

        public Builder addHorizontals(String name, Direction.Axis defaultValue) {
            return this.add(EnhanceProperty.Creators.createHorizontals(name, defaultValue));
        }

        public Builder add(String name, DirectionalConnectivity defaultValue) {
            return this.add(EnhanceProperty.Creators.create(name, defaultValue));
        }

        public <T extends Enum<T> & StringRepresentable> Builder add(String name, Class<T> valueClass, T defaultValue) {
            return this.add(EnhanceProperty.Creators.create(EnumProperty.create(name, valueClass), defaultValue));
        }

        public <T extends Enum<T> & StringRepresentable> Builder add(String name, Class<T> valueClass, T defaultValue, Collection<T> allowedValues) {
            return this.add(EnhanceProperty.Creators.create(EnumProperty.create(name, valueClass, allowedValues), defaultValue));
        }

        public <T extends Enum<T> & StringRepresentable> Builder add(String name, Class<T> valueClass, T defaultValue, T... allowedValues) {
            return this.add(EnhanceProperty.Creators.create(EnumProperty.create(name, valueClass, allowedValues), defaultValue));
        }

        public <T extends Enum<T> & StringRepresentable> Builder add(String name, Class<T> valueClass, T defaultValue, Predicate<T> allowedValues) {
            return this.add(EnhanceProperty.Creators.create(EnumProperty.create(name, valueClass, allowedValues), defaultValue));
        }

        public <T extends Comparable<T>> Builder add(Property<T> property, T defaultValue) {
            return add(EnhanceProperty.Creators.create(property, defaultValue, MirrorHandler.Handlers.defaultHandler(), RotationHandler.Handlers.defaultHandler()));
        }

        public <T extends Comparable<T>> Builder add(Property<T> property, T defaultValue, MirrorHandler<T> mirrorHandler) {
            return add(EnhanceProperty.Creators.create(property, defaultValue, mirrorHandler, RotationHandler.Handlers.defaultHandler()));
        }

        public Builder add(DirectionProperty property, Direction defaultValue) {
            return this.add(EnhanceProperty.Creators.create(property, defaultValue, MirrorHandler.Handlers.direction(), RotationHandler.Handlers.direction()));
        }

        public Builder add(EnumProperty<Direction.Axis> property, Direction.Axis defaultValue) {
            return this.add(EnhanceProperty.Creators.create(property, defaultValue, RotationHandler.Handlers.axis()));
        }

        public <T extends Comparable<T>> Builder add(Property<T> property, T defaultValue, RotationHandler<T> rotationHandler) {
            return this.add(EnhanceProperty.Creators.create(property, defaultValue, MirrorHandler.Handlers.defaultHandler(), rotationHandler));
        }

        public <T extends Comparable<T>> Builder add(Property<T> property, T defaultValue, MirrorHandler<T> mirrorHandler, RotationHandler<T> rotationHandler) {
            return this.add(EnhanceProperty.Creators.create(property, defaultValue, mirrorHandler, rotationHandler));
        }

        public <T extends Comparable<T>> Builder add(EnhanceProperty<T> property) {
            this.properties.add(property);
            return this;
        }

        public Builder waterloggable() {
            return this.add(EnhanceProperty.Defaults.waterlogged());
        }

        public Builder lavaloggable() {
            return this.add(EnhanceProperty.Defaults.lavalogged());
        }

        public Builder fluidloggable() {
            return this.add(EnhanceProperty.Defaults.fluidlogged());
        }

        public Builder connectivity() {
            return this.add(EnhanceProperty.Defaults.connectivity());
        }
    }
}
