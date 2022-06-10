import lib.Picture;
import lib.Pixel;

import java.awt.*;

public class Vibrant {
    private boolean m_oneImage;
    private Picture m_pSingular;
    private Picture m_p1;
    private Picture m_p2;
    private int MIN_HEIGHT = 100;

    public Vibrant(Picture pSingular) {
        m_pSingular = new Picture(pSingular);
        m_oneImage = true;
    }

    /**
     *
     * @param p1: Has to be BIGGER than p2
     * @param p2: Has to be SMALLER than p2
     */
    public Vibrant(Picture p1, Picture p2) {
        m_p1 = new Picture(p1);
        m_p2 = new Picture(p2);
        m_oneImage = false;
    }

    public Picture setVibrant(){
        if(m_oneImage) {
            Picture p = new Picture(m_pSingular);
            Pixel[][] pixelArray = p.getPixels2D();

            for (Pixel[] pA : pixelArray) {
                for (Pixel pix : pA) {
                    pix.setColor(Utils.max(pix.getColor()));
                }
            }
            return p;
        } else {
            Picture p1 = new Picture(m_p1);
            Picture p2 = new Picture(m_p2);

            Pixel[][] p1Array = p1.getPixels2D();
            Pixel[][] p2Array = p2.getPixels2D();

            for(int i = 0; i < p1Array.length; i++){
                for (int j = 0; j < p1Array[0].length; j++){
                    Color p1Col = p1Array[i][j].getColor();
                    if(i < p2.getWidth() && j < p2.getHeight()){
                        Color p2Col = p2Array[i][j].getColor();
                        Color avgCol = Utils.getAvg(p1Col,p2Col);
                        p1Array[i][j].setColor(Utils.max(avgCol));
                        p1Array[i][j].setColor(avgCol);
                    } else {
//                        p1Array[i][j].setColor(p1Col);
                        p1Array[i][j].setColor(Utils.max(p1Col));
                    }
                }
            }
            return p1;
        }
    }

    public static void main(String[] args) {
        Picture bigPic = new Picture("Plasma.jpeg");
        Picture smallPic = new Picture ("Caleb.jpeg");
        bigPic.explore();
        smallPic.explore();
        Vibrant v = new Vibrant(smallPic, bigPic);
        v.setVibrant().explore();
    }
}
