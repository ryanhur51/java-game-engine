package game;

import java.util.ArrayList;

import engine.Game;
import engine.GameLoop;
import engine.Renderer;

public class GameManager extends Game {
    // Initializing game objects 
    private Background background = new Background();
    private Player player = new Player();
    private ArrayList<Pipe> list = new ArrayList<Pipe>();
    private int counter = 0;
    
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
            if (list.size() < 3){
                list.add(new Pipe(600 + 300 * counter, (int)((Math.random() * -250) - 200)));
                counter++;
            } 
            if (list.get(0).getPosX() < -80){ 
                list.add(new Pipe(600 + 300 * counter, (int)((Math.random() * -250) - 200)));
                list.remove(0);
            }
            for (int i = 0; i < list.size(); i++){
                list.get(i).update();
            }
            System.out.println(counter);
        }
    }

    @Override
    public void render(GameLoop gl, Renderer r) {
        background.render(r);
        player.render(r);
        for (int i = 0; i < list.size(); i++){
            list.get(i).render(r);
        }
    }

    public static void main(String[]args){
        GameLoop gl = new GameLoop(new GameManager());
        gl.start();
    }
    
}
