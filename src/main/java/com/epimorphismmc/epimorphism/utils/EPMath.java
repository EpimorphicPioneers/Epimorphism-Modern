package com.epimorphismmc.epimorphism.utils;

public class EPMath {

    /**
     * @param values to find the mean of
     * @return the mean value
     */
    public static long mean(long[] values) {
        if (values.length == 0L) return 0L;

        long sum = 0L;
        for (long v : values) sum += v;
        return sum / values.length;
    }
}
