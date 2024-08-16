package game;

import engine.Image;
import engine.Renderer;
import engine.GameLoop;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

// PLayer game object (bird).
public class Player extends GameObject {
    private int posX;
    private int posY;
    private boolean isLost;
    private boolean isStart;

    private double gravity;
    private double jumpHeight;
    private double jumpChange;

    private Image image;

    // Constructor
    public Player(){
        posY = 250;
        posX = 100;
        isLost = false;
        isStart = false;

        gravity = 0.48;
        jumpHeight = 8.3;
        jumpChange = 0;

        image = new Image("/res/player.png");
    }

    @Override
    public void update(GameLoop gl){
        if (gl.getInput().isKeyDown(KeyEvent.VK_SPACE) || gl.getInput().isMouseButtonDown(MouseEvent.BUTTON1) == true){
            isStart = true;
            jumpChange = -jumpHeight;     
        }
        if (!isStart){
            return;
        }
        if (posY + jumpChange < 600){
            posY += jumpChange;
            jumpChange += gravity;
        }
        if (posY >= 585){
            isLost = true;
        } else if (posY < 0){
            posY -= jumpChange;
        }
        if (isLost){
            while (posY <= 585){
                System.out.println("hi");
                posY += 20;
            }
            return;
        }
    }

    @Override
    public void render(GameLoop gl, Renderer r){
        r.drawImage(image, posX, posY, 0.09);
    }

    // Getters and Setters. 
    public boolean isLost(){ return isLost; }
    public void setIsLost(boolean isLost){ this.isLost = isLost; }

    public boolean isStart(){ return isStart; } 
    public void setIsStart(boolean isStart){ this.isStart = isStart; }

    public int getPosX(){ return posX; }
    public void setPosX(int posX){ this.posX = posX; }

    public int getPosY(){ return posY; }
    public void setPosY(int posY){ this.posY = posY; }
}
