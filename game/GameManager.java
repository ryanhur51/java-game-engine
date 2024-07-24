package game;

import java.awt.event.KeyEvent;

import engine.Game;
import engine.GameLoop;
import engine.Renderer;
import engine.Window;
import engine.graphics.Image;

public class GameManager extends Game {

    private Image image;
    public GameManager(){
        image = new Image("/resources/hi.jpg");
    }

    @Override
    public void update(GameLoop gl) {
        if (gl.getInput().isKeyDown(KeyEvent.VK_A)){
            System.out.println("A was pressed");
        }
    }

    @Override
    public void render(GameLoop gl, Renderer r) {
        r.drawImage(image, 0, 0);
    }

    public static void main(String[]args){
        GameLoop gl = new GameLoop(new GameManager());
        gl.start();
    }
    
}
