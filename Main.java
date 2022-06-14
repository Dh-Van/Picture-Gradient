import lib.Picture;
import lib.Pixel;

import java.awt.*;

public class Main {

    private static final Picture PLASMA = new Picture("Plasma.jpeg");
    private static final Picture CALEB = new Picture ("Caleb.jpeg");
    private static final Picture RED_SHADES = new Picture("ShadesRed.png");
    private static final Picture LANDSCAPE = new Picture("landscape1.jpg");

    public static void main(String[] args) {
        System.out.printf("PLASMA:\tWidth: %d\tHeight: %d\n", PLASMA.getWidth(), PLASMA.getHeight());
        System.out.printf("CALEB:\tWidth: %d\tHeight: %d\n", CALEB.getWidth(), CALEB.getHeight());
        System.out.printf("RED_SHADES:\tWidth: %d\tHeight: %d\n", RED_SHADES.getWidth(), RED_SHADES.getHeight());
        System.out.printf("LANDSCAPE:\tWidth: %d\tHeight: %d\n", LANDSCAPE.getWidth(), LANDSCAPE.getHeight());

        combine(RED_SHADES, CALEB, false).show();

    }

    /**
     * Creates an image with the highest R, G or B values set for each pixel
     * @param pSingular The image to use
     * @return The image with the new values set
     */
    public static Picture setVibrant(Picture pSingular){
        Picture p = new Picture(pSingular);
        Pixel[][] pixelArray = p.getPixels2D();

        for (Pixel[] pA : pixelArray) {
            for (Pixel pix : pA) {
                pix.setColor(Utils.max(pix.getColor()));
            }
        }
        return p;
    }

    /**
     * Combines p1 and p2. p1 has to be BIGGER than p2 in both width and height
     * @param p1 The bigger picture
     * @param p2 The smaller picture
     * @param vibrant Set to true if the new image should have the R, G, and B values maxed
     * @return New image with p2 combined with p1.
     */
    public static Picture combine(Picture p1, Picture p2, boolean vibrant){

        if(!Utils.isBigger(p1, p2)) return p1;

        Picture ret = new Picture(p2.getHeight(), p2.getWidth());
        Pixel[][] retArray = ret.getPixels2D();
        Pixel[][] p1Array = p1.getPixels2D();
        Pixel[][] p2Array = p2.getPixels2D();


        for(int i = 0; i < p1Array.length; i++){
            for (int j = 0; j < p1Array[0].length; j++){
                Color p1Col = p1Array[i][j].getColor();
                if(i < p2.getHeight() && j < p2.getWidth()){
                    Color p2Col = p2Array[i][j].getColor();
                    Color avgCol = Utils.getAvg(p1Col,p2Col);
                    if(vibrant) retArray[i][j].setColor(Utils.max(avgCol));
                    else retArray[i][j].setColor(avgCol);
                }
            }
        }
        return ret;
    }
}
