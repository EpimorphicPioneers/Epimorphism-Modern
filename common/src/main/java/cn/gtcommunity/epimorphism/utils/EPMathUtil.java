package cn.gtcommunity.epimorphism.utils;

public class EPMathUtil {
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
