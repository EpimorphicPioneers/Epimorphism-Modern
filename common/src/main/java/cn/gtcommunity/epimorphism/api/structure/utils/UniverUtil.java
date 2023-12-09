package cn.gtcommunity.epimorphism.api.structure.utils;

import java.util.function.Supplier;

public class UniverUtil {
    //  Utils
    public static <T> T getOrDefault(T value, Supplier<T> defaultSupplier) {
        if (value == null) return defaultSupplier.get();
        return value;
    }
}
