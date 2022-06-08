import lib.Picture;
import lib.Pixel;

import java.awt.*;
import java.util.ArrayList;

public class Gradient {
    private boolean m_oneImage;
    private Picture m_pSingular;
    private Picture m_p1;
    private Picture m_p2;
    private int MIN_HEIGHT = 100;

    public Gradient(Picture pSingular) {
        m_pSingular = new Picture(pSingular);
        m_oneImage = true;
    }

    public Gradient(Picture p1, Picture p2) {
        m_p1 = new Picture(p1);
        m_p2 = new Picture(p2);
        m_oneImage = true;
    }


    private ArrayList<Pixel> getUniquePixels(Picture pSingular){
        ArrayList<Color> uniqueList = new ArrayList<Color>();
        ArrayList<Pixel> pixelList = new ArrayList<Pixel>();
        Pixel[][] pixelArray = pSingular.getPixels2D();

        for(Pixel[] pA : pixelArray){
            for(Pixel p : pA){
                Color currColor = p.getColor();
                if(!uniqueList.contains(currColor)) {
                    uniqueList.add(currColor);
                    pixelList.add(p);
                }
            }
        }

        return pixelList;
    }

    private Picture createPicture(Picture pSingular){
        int max = getUniquePixels(pSingular).size();
        int height = max / 2;
        int width = max - height;
        return new Picture(height, width);
    }

//    private Picture createPicture(Picture p1, Picture p2){
//
//    }

    private Picture addPixels(Picture picture, ArrayList<Pixel> pixelList){
        Picture p = new Picture(picture);
        Pixel[][] pixels = p.getPixels2D();
        int counter = 0;

        for(int row = 0; row < p.getHeight(); row++) {
            for (int col = 0; col < p.getWidth(); col++) {
                if(counter < pixelList.size()) {
                    pixels[row][col].setColor(pixelList.get(counter).getColor());
//                    System.out.println(pixels[row][col].getColor());
                    counter++;
                } else {
                    pixels[row][col].setColor(new Color(0, 0, 0, 1));
                }
            }
        }
        return p;
    }

    public static void main(String[] args) {
        Picture plasma = new Picture("Plasma.jpeg");
        Gradient g = new Gradient(plasma);
        g.addPixels(g.createPicture(plasma), g.getUniquePixels(plasma)).explore();
//
//      plasma.explore();
    }

}
