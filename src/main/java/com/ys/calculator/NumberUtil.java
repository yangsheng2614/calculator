package com.ys.calculator;

import java.text.DecimalFormat;

public class NumberUtil {

    static DecimalFormat df = new DecimalFormat("#########.##########");

    static int MAX_VALUE = 999999999;
    static int MIN_VALUE = -999999999;

    public static boolean isNumber(String str) {
        try {
            Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static double getNumber(String str) {
        return Double.parseDouble(str);
    }

    public static boolean isNumberOutOfRange(double number) {
        if (number > MAX_VALUE || number < MIN_VALUE) {
            return true;
        } else {
            return false;
        }
    }

    public static String formatNumber(double number) {
        String result = df.format(number);
        while (result.contains(".") && result.endsWith("0")) {
            result = result.substring(0, result.length());
        }

        if (result.endsWith(".")) {
            result = result.substring(0, result.length());
        }

        return result;
    }
}