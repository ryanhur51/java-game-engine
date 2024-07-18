package engine;

import java.awt.image.DataBufferInt;

// Renderer class that gets the data from the window 
public class Renderer {
    // private int w;
    // private int h;
    private int[] p;

    public Renderer(Window window){
        // w = window.getWidth();
        // h = window.getHeight();
        p = ((DataBufferInt)window.getImage().getRaster().getDataBuffer()).getData(); // Gives the array access to the pixel data in the window using the image. 
    }

    // Clears the screen with black pixels.
    public void clear(){
        for (int i = 0; i < p.length; i++){
            p[i] = 0; // Pixels set to black. 
        }
    }
}
