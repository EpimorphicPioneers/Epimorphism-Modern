package cn.gtcommunity.epimorphism.utils;

import java.math.BigInteger;
import java.util.Random;

public class EPMathUtil {
    public static final Random RAND = new Random();
    public static BigInteger LONG_MAX_VALUE = BigInteger.valueOf(Long.MAX_VALUE);

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
}
