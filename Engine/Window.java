package Engine;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import java.awt.image.BufferedImage;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.Dimension;

public class Window {
    private JFrame frame;
    private BufferedImage image;
    private Canvas canvas;
    private Graphics graphics; 
    private BufferStrategy bs;

    public Window(){
        int width = 320;
        int height = 240;
        float scale = 1f;
        String title = "Java Game Engine";

        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        canvas = new Canvas();
        Dimension d = new Dimension ((int)(width * scale), (int)(height * scale));
        canvas.setPreferredSize(d); //keep it the same size 
        canvas.setMaximumSize(d);
        canvas.setMinimumSize(d);

        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(canvas, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
    
}
