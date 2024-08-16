package game;

import engine.Image;
import engine.Renderer;
import engine.GameLoop;

// Background game object 
public class Background extends GameObject{
    private int posX;
    private int speed;
    private Image image;
    
    //Constructor
    public Background(){
        posX = 0;
        speed = 4;
        image = new Image("/res/background.png");
    }

    @Override
    public void update(GameLoop gl){
        posX -= speed;
        if (posX < -347){
            posX = 0;
        }
    }

    @Override
    public void render(GameLoop gl, Renderer r){
        r.drawImage(image, posX, 0, 1.5);
    }

    // Getters and setters.
    public int getX(){ return posX; }
    public void setX(int num){ this.posX = num; }

    public Image getImage(){ return image; }
    public void setImage(Image image){ this.image = image; }
}
