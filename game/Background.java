package game;

import engine.Image;
import engine.Renderer;

public class Background {
    private int x;

    private Image image;
    
    public Background(Renderer r){
        image = new Image("/res/background.png");
        r.drawImage(image, 0, 0, 1.5);
        x = 0;
    }

    public void update(){
        System.out.println(x);
        x += 10;

        if (x > 100){
            x = 0;
        }
    }

    public int getX(){
        return x;
    }
    public void setX(int num){
        this.x = num;
    }



}
