package game;

import engine.Image;
import engine.Renderer;

public class Background {
    private int posX;
    private int speed;
    private Image image;
    
    public Background(){
        posX = 0;
        speed = 4;
        image = new Image("/res/background.png");
    }

    public void update(){
        posX -= speed;
        if (posX < -340){
            posX = 0;
        }
    }

    public void render(Renderer r){
        r.drawImage(image, posX, 0, 1.5);
    }

    public int getX(){
        return posX;
    }
    public void setX(int num){
        this.posX = num;
    }

    public Image getImage(){
        return image;
    }
    public void setImage(Image image){
        this.image = image;
    }



}
