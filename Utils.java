import java.awt.*;

public class Utils {

    /**
     * Return true if the rbg of a is +- inverval of the rgb og b
     */
    public static boolean inRange(Color a, Color b, int interval){

        // a = rgb(100, 100, 100)
        // b = rgb(123, 105, 142)

        int redLow = a.getRed() - interval;
        int redHigh = a.getRed() + interval;
        int blueLow = a.getBlue() - interval;
        int blueHigh = a.getBlue() + interval;
        int greenLow = a.getGreen() - interval;
        int greenHigh = a.getGreen() + interval;

        if(inRange(a.getRed(), redLow, redHigh) && inRange(a.getBlue(), blueLow, blueHigh) && inRange(a.getGreen(), greenLow, greenHigh)){
            return true;
        }

        return false;

    }


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

    public static Color getAvg(Color c1, Color c2){
        int red = (c1.getRed() + c2.getRed()) / 2;
        int green = (c1.getGreen() + c2.getGreen()) / 2;
        int blue = (c1.getBlue() + c2.getBlue()) / 2;

        return new Color(red, green, blue);
    }

    public static boolean inRange(int a, int low, int high){
        return a >= low && a <= high;
    }

}
