package game;

import engine.Game;
import engine.GameLoop;
import engine.Renderer;
import engine.Window;

public class GameManager extends Game {

    @Override
    public void update(Window window) {

    }

    @Override
    public void render(Window window, Renderer r) {
       
    }

    public static void main(String[]args){
        GameLoop gl = new GameLoop(new GameManager());
        gl.start();
    }
    
}
