package dev.hytalemodding.utilities;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class NumberUtils {

    private static final String[] SUFFIXES = {"", "k", "m", "b", "t", "q", "Q"};
    private static final DecimalFormat FORMAT;

    static {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        FORMAT = new DecimalFormat("#.##", symbols);
    }

    /**
     * Format large numbers with suffixes
     * Examples:
     *   1000 -> "1k"
     *   1500 -> "1.5k"
     *   1000000 -> "1m"
     *   1234567 -> "1.23m"
     */
    public static String formatNumber(double value) {
        if (Double.isNaN(value) || Double.isInfinite(value)) {
            return String.valueOf(value);
        }

        double absValue = Math.abs(value);

        int suffixIndex = 0;
        if (absValue >= 1000) {
            suffixIndex = (int) (Math.log10(absValue) / 3);
            suffixIndex = Math.min(suffixIndex, SUFFIXES.length - 1);
        }

        double scaledValue = value / Math.pow(1000, suffixIndex);
        String formatted = FORMAT.format(scaledValue);

        return formatted + SUFFIXES[suffixIndex];
    }
}
