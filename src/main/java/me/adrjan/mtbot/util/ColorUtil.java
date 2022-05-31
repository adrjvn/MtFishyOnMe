package me.adrjan.mtbot.util;

import lombok.experimental.UtilityClass;

import java.awt.*;
import java.awt.image.BufferedImage;

@UtilityClass
public class ColorUtil {

    public static final int COLOR_OFFSET = 3_000;

    public static int countColor(BufferedImage bi, Color color) {
        int minX = bi.getMinX();
        int minY = bi.getMinY();
        int width = bi.getWidth();
        int height = bi.getHeight();

        int x1 = minX + width;
        int y1 = minY + height;

        int count = 0;
        for (int x = minX; x < x1; x++) {
            for (int y = minY; y < y1; y++) {
                Color pixel = new Color(bi.getRGB(x, y));
                if (similarTo(color, pixel, COLOR_OFFSET)) count++;
            }
        }
        return count;
    }

    public static boolean similarTo(Color c, Color other, double offset) {
        double distance = (c.getRed() - other.getRed()) * (c.getRed() - other.getRed()) + (c.getGreen() - other.getGreen()) * (c.getGreen() - other.getGreen()) + (c.getBlue() - other.getBlue()) * (c.getBlue() - other.getBlue());
        return distance < offset;
    }
}