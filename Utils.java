import lib.Picture;

import java.awt.*;
import java.util.Vector;

public class Utils {
    /**
     * Maxes the R, G, or B values of a color, white if they are all equal and >= 128, black if they are all equal and < 128
     * @param c Color passed in to max out
     * @return Maxed out color
     */
    public static Color max(Color c){
        int red = c.getRed();
        int blue = c.getBlue();
        int green = c.getGreen();

        if(red == blue && red == green){
            if(red >= 128) return Color.WHITE;
            if(red < 128) return Color.BLACK;
        }

        if(red >= blue && red > green) return Color.RED;
        if(blue > red && blue >= green) return Color.BLUE;
        if(green > blue && green >= red) return Color.GREEN;

        return Color.WHITE;
    }

    /**
     * Returns the average color from 2 different colors
     * @param c1 Color 1
     * @param c2 Color 2
     * @return Average of Color 1 and Color 2
     */
    public static Color getAvg(Color c1, Color c2){
        int red = (c1.getRed() + c2.getRed()) / 2;
        int green = (c1.getGreen() + c2.getGreen()) / 2;
        int blue = (c1.getBlue() + c2.getBlue()) / 2;

        return new Color(red, green, blue);
    }

    public static boolean isBigger(Picture p1, Picture p2){
        return p1.getHeight() > p2.getHeight() && p1.getWidth() > p2.getWidth();
    }
}
