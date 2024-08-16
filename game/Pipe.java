package game;

import engine.Image;
import engine.Renderer;
import engine.GameLoop;

// Pipe gameobject. 
public class Pipe extends GameObject{
    private Image image;
    private int posX;
    private int posY; //posY can range from -450 to -200
    private int speed;

    // Constructor
    public Pipe(int x, int y){
        image = new Image("/res/pipe.png");
        posX = x;
        posY = y;
        speed = 4; 
    }

    @Override
    public void update(GameLoop gl){
        posX -= speed;
    }

    @Override
    public void render(GameLoop gl, Renderer r){
        r.drawImage(image, posX, posY, 1);
        // r.drawRect(posX, posY+550, 77, 165, 0x12312312);
    }

    // Getters and Setters
    public int getPosX(){ return posX; }
    public void setPosX(int posX){ this.posX = posX; }

    public int getPosY(){ return posY; }

}
