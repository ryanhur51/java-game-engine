package game;

import engine.Image;
import engine.Renderer;
import engine.GameLoop;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Player {
    private int posX;
    private int posY;
    private boolean isLost;
    private boolean isStart;

    private double gravity;
    private double jumpHeight;
    private double jumpChange;

    private Image image;

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

    public void render(Renderer r){
        r.drawImage(image, posX, posY, 0.09);
    }

    public boolean isLost(){
        return isLost;
    }
    
    public void setIsLost(boolean isLost){
        this.isLost = isLost;
    }

    public boolean isStart(){
        return isStart;
    } 

    public int getPosY(){
        return posY;
    }
    public int getPosX(){
        return posX;
    }

}
