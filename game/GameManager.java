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
    private int pipeSpawnTimer = 60; // Tracks the time or frames until the next pipe spawn
    private final int pipeSpawnInterval = 60;
    
    public GameManager(){
    }

    @Override
    public void update(GameLoop gl) {
        // if (player.isLost()) {
        //     return;
        // } 
    
        background.update();
        player.update(gl);
    
        if (player.isStart()) {
           
            pipeSpawnTimer++;
            if (pipeSpawnTimer >= pipeSpawnInterval) {
                list.add(new Pipe(600 + 100 * counter, (int)((Math.random() * -250) - 200)));
                counter++;
                pipeSpawnTimer = 0; // Reset the timer after spawning.
            }
            if (list.get(0).getPosX() < -80) { 
                list.remove(0);
            }
            for (int i = 0; i < list.size(); i++) {
                list.get(i).update();
            }
            getCollision();
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

    public boolean getCollision(){
        if (player.getPosX() > list.get(0).getPosX() - 55 && player.getPosX() < list.get(0).getPosX() + 55){
            //System.out.println("player posY: " + player.getPosY() + "\n" + "pipe posY: " + (list.get(0).getPosY() + 550) + "\n");
            if (player.getPosY() < list.get(0).getPosY() + 715 && player.getPosY() > list.get(0).getPosY() + 550){
                
            } else {
                player.setIsLost(true);
            }
        }
        return true;
    }

    public static void main(String[]args){
        GameLoop gl = new GameLoop(new GameManager());
        gl.start();
    }
    
}
