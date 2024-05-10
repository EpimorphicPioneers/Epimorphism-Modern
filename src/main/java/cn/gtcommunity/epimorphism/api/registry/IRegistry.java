package cn.gtcommunity.epimorphism.api.registry;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public interface IRegistry<K, V extends IRegisterable<K>> {
    boolean containKey(K key);

    boolean containValue(V value);

    @Nullable
    V get(K key);

    void register(V value);

    boolean remove(V value);

    Set<V> values();

    Set<K> keys();

    Set<Map.Entry<K, V>> entries();

    int count();

    @NotNull
    Stream<V> stream();

}
