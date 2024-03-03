package cn.gtcommunity.epimorphism.utils;

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class EPMathUtil {
    public static final Random RAND = new Random();
    public static BigInteger LONG_MAX_VALUE = BigInteger.valueOf(Long.MAX_VALUE);

    public static int K = 1000;
    public static int M = 1000000;

    public static int clamp(int value, int min, int max) {
        if (value < min) {
            return min;
        }else {
            return Math.min(value, max);
        }
    }

    public static double clamp(double value, double min, double max) {
        if (value < min) {
            return min;
        }else {
            return Math.min(value, max);
        }
    }

    public static long getLongNumber(BigInteger number) {
        if (number != null) {
            return number.compareTo(EPMathUtil.LONG_MAX_VALUE) >= 0 ? Long.MAX_VALUE : number.longValue();
        }
        return 0;
    }

    public static ThreadLocalRandom LocalRandom() {
        return ThreadLocalRandom.current();
    }
}
