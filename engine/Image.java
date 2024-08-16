package engine;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

// Image class.
public class Image {
    private int w;
    private int h;

    private int[] p; // Pixel Array

    public Image (String file){
        BufferedImage image = null;
        
        try {
            image = ImageIO.read(Image.class.getResourceAsStream(file));
        } catch (IOException e){
            e.getMessage();
        }
        
        w = image.getWidth();
        h = image.getHeight();
        p = image.getRGB(0, 0,w, h, null, 0, w);
    }

    // Getters.
    public int getW(){ return w; }
    public int getH(){ return h; }
    public int[] getP(){ return p; }
}
