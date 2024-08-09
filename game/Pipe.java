package game;

import engine.Image;
import engine.Renderer;
import java.util.Random;

public class Pipe {

    private Image image;
    private int posX;
    private int posY; //posY can range from -450 to -200
    private int speed;

    public Pipe(int x, int y){
        image = new Image("/res/pipe.png");
        posX = x;
        posY = 
        speed = 4; 
    }

    public void update(){
        posX -= speed;
    }

    public void render(Renderer r){
        r.drawImage(image, posX, posY, 1);
    }
}
