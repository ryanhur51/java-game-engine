package game;

import engine.Game;
import engine.GameLoop;
import engine.Renderer;

public class GameManager extends Game {
    // Initializing game objects 
    private Background background = new Background();
    private Player player = new Player();
    private Pipe pipe = new Pipe(800, (int)((Math.random() * -250) - 200));
    // TODO create an array list for the infintiely scrolling pipes
    
    public GameManager(){
    }

    @Override
    public void update(GameLoop gl) {
        if (player.getIsLost() == true){
            return;
        } 

        background.update();
        player.update(gl);

        if (player.getIsStart()){
            pipe.update();
        } 
    }

    @Override
    public void render(GameLoop gl, Renderer r) {
        background.render(r);
        player.render(r);
        pipe.render(r);
    }

    public static void main(String[]args){
        GameLoop gl = new GameLoop(new GameManager());
        gl.start();
    }
    
}
