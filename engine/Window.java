package engine;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import java.awt.image.BufferedImage;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.Dimension;

/**
 * Window Class generates the window using the awt library (Abstract Window Toolkit). 
 */
public class Window {
    private JFrame frame;
    private BufferedImage image;
    private Canvas canvas;
    private BufferStrategy bs;
    private Graphics g;

    private int w, h;
    private float s;
    private String t;

    public Window(int width, int height, float scale, String title){
        w = width;
        h = height;
        s = scale;
        t = title;

        // Create buffered image. 
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // Creating canvas.
        canvas = new Canvas();
        Dimension d = new Dimension ((int)(width * scale), (int)(height * scale));
        canvas.setPreferredSize(d); // Keep it the same size 
        canvas.setMaximumSize(d);
        canvas.setMinimumSize(d);

        // Creating frame.
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(canvas, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        // Creating buffer strategy. 
        canvas.createBufferStrategy(2);
        bs = canvas.getBufferStrategy();
        g = bs.getDrawGraphics();
    }
    
    /**
     * Renders the window by drawing it onto the screen with the buffer strategy. 
     */
    public void update(){ 
        g.drawImage(image, 0, 0, canvas.getWidth(), canvas.getHeight(), null);
        bs.show();
    }

    /**
     * Getters and Setters
     */
    public int getWidth(){
        return w;
    }
    public int getHeight(){
        return h;
    }
    public float getScale(){
        return s;
    }
    public String getTitle(){
        return t;
    }
    public BufferedImage getImage(){
        return image; 
    }
    public Canvas getCanvas(){
        return canvas; 
    }
    public JFrame getFrame(){
        return frame;
    }
}
