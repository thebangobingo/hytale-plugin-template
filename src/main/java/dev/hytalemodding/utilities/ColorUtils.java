package dev.hytalemodding.utilities;

import java.awt.Color;

public class ColorUtils {

    /**
     * Convert Color to hex string
     * Example: Color.RED -> "#ff0000"
     */
    public static String toHex(Color color) {
        return String.format("#%02x%02x%02x",
                color.getRed(),
                color.getGreen(),
                color.getBlue()
        );
    }

    /**
     * Parse hex string to Color
     * Example: "#ff0000" -> Color.RED
     */
    public static Color fromHex(String hex) {
        hex = hex.replace("#", "");
        return new Color(
                Integer.parseInt(hex.substring(0, 2), 16),
                Integer.parseInt(hex.substring(2, 4), 16),
                Integer.parseInt(hex.substring(4, 6), 16)
        );
    }

    /**
     * Interpolate between two colors
     * @param ratio 0.0 to 1.0
     */
    public static Color lerp(Color start, Color end, double ratio) {
        ratio = Math.max(0, Math.min(1, ratio)); // Clamp 0-1

        int r = (int) (start.getRed() + ratio * (end.getRed() - start.getRed()));
        int g = (int) (start.getGreen() + ratio * (end.getGreen() - start.getGreen()));
        int b = (int) (start.getBlue() + ratio * (end.getBlue() - start.getBlue()));

        return new Color(r, g, b);
    }
}