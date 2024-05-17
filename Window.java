import java.awt.BorderLayout;
import javax.swing.JFrame;
import java.awt.image.BufferedImage;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.Dimension;

/**
 * Window class that generates 
 * 
 */
public class Window {
    private JFrame frame;
    private BufferedImage image;
    private Canvas canvas;
    private BufferStrategy bs;
    private Graphics g;

    int w, h;
    float s;
    String t;

    public Window(int width, int height, float scale, String title){
        w = width;
        h = height;
        s = scale;
        t = title;

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

        canvas.createBufferStrategy(2);
        bs = canvas.getBufferStrategy();
        g = bs.getDrawGraphics();
    }
    
    public void update(){ // Draw the image to the canvas and use the buffer strategy
        g.drawImage(image, 0, 0, canvas.getWidth(), canvas.getHeight(), null);
        bs.show();
    }
}
