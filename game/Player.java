package game;

import engine.Image;
import engine.Renderer;
import engine.GameLoop;

import java.awt.event.KeyEvent;


public class Player {
    private int posX;
    private int posY;
    private boolean isLost;

    private double gravity;
    private double jumpHeight;
    private double jumpChange;

    private Image image;
    private GameLoop gl;

    public Player(){
        posY = 0;
        posX = 100;
        isLost = false;

        gravity = 0.48;
        jumpHeight = 8.5;
        jumpChange = 0;

        image = new Image("/res/player.png");
    }

    public void update(GameLoop gl){
        if (gl.getInput().isKeyDown(KeyEvent.VK_SPACE)){
            jumpChange = -jumpHeight;     
        }
        if (posY + jumpChange < 600){
            posY += jumpChange;
            jumpChange += gravity;
        }
        if (posY > 585){
            isLost = true;
        }
    }

    public void render(Renderer r){
        r.drawImage(image, posX, posY, 0.09);
    }

    public boolean getIsLost(){
        return isLost;
    }
}
