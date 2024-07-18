package game;

import java.awt.event.KeyEvent;

import engine.Game;
import engine.GameLoop;
import engine.Renderer;
import engine.Window;

public class GameManager extends Game {
    public GameManager(){

    }

    @Override
    public void update(GameLoop gl) {
        if (gl.getInput().isKeyDown(KeyEvent.VK_A)){
            System.out.println("A was pressed");
        }
    }

    @Override
    public void render(Window window, Renderer r) {
       
    }

    public static void main(String[]args){
        GameLoop gl = new GameLoop(new GameManager());
        gl.start();
    }
    
}
