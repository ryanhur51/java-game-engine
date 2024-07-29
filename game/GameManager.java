package game;

import java.awt.event.KeyEvent;

import engine.Game;
import engine.GameLoop;
import engine.Image;
import engine.Renderer;

public class GameManager extends Game {

    private Background background = new Background();
    private Player player = new Player();


    public GameManager(){
        
    }

    @Override
    public void update(GameLoop gl) {
        // if (gl.getInput().isKeyDown(KeyEvent.VK_A)){
        //     System.out.println("A was pressed");
        // }

        background.update();
        player.update(gl);
        
        if (player.getIsLost() == true){
           // System.out.println("over");
        }
        
    }

    @Override
    public void render(GameLoop gl, Renderer r) {
        
        background.render(r);
        player.render(r);
        
    }

    public static void main(String[]args){
        GameLoop gl = new GameLoop(new GameManager());
        gl.start();
    }
    
}
