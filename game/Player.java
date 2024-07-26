package game;

import engine.Image;
import engine.Renderer;
import engine.GameLoop;

import java.awt.event.KeyEvent;


public class Player {
    private int posX;
    private int posY;

    private int fallSpeed;
    private Image image;

    public Player(){
        
        posY = 0;
        posX = 150;

        fallSpeed = 10;
        image = new Image("/res/player.png");
    }

    public void update(){
        posY += fallSpeed;
    }

    public void render(Renderer r){
        r.drawImage(image, posX, posY, 0.1);
    }

    public int getPosY(){
        return posY;
    }
}
