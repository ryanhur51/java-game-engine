package engine;

import java.awt.image.DataBufferInt;
import engine.graphics.Image;

// Renderer class that gets the data from the window 
public class Renderer {
    private int pW;
    private int pH;
    private int[] p;

    public Renderer(Window window){
        pW = window.getWidth();
        pH = window.getHeight();
        p = ((DataBufferInt)window.getImage().getRaster().getDataBuffer()).getData(); // Gives the array access to the pixel data in the window using the image. 
    }

    // Clears the screen with black pixels.
    public void clear(){
        for (int i = 0; i < p.length; i++){
            p[i] = 0; // Pixels set to black. 
        }
    }

    public void setPixel(int x, int y, int val){
        if ((x < 0 || x >= pW || y < 0 || y >= pH) || val == 0xff461B46){ //0xff461B46 is an arbitrary color which represents as a "don't render" color/value. 
            return;
        }
        p[x + y * pW] = val;
    }

    public void drawImage(Image image, int offsetX, int offsetY){
        for (int x = 0; x < image.getW(); x++){
            for (int y = 0; y < image.getH(); y++){
                setPixel(x + offsetX, y + offsetY, image.getP()[x + y * image.getW()]);
            }
        }
    }
}
