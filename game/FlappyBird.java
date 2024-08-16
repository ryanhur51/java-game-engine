package game;

import java.util.ArrayList;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import engine.Game;
import engine.GameLoop;
import engine.Renderer;

public class FlappyBird extends Game {
    private Background background = new Background();
    private Player player = new Player();
    private ArrayList<Pipe> list = new ArrayList<Pipe>();
    private int counter = 0;
    private int pipeSpawnTimer = 60; // Tracks the time or frames until the next pipe spawn
    private final int pipeSpawnInterval = 60;
    
    // Constructor 
    public FlappyBird(){
    }

    @Override
    public void update(GameLoop gl) {
        if (player.isLost()) {
            player.setIsStart(false);

            // Reset mechanic.
            if (gl.getInput().isKeyDown(KeyEvent.VK_SPACE) || gl.getInput().isMouseButtonDown(MouseEvent.BUTTON1) == true){
                list.clear();
                pipeSpawnTimer = 60; 
                counter = 0;
                player.setPosY(250);
                player.setIsLost(false);
            }
            return;
        } 
        
        background.update(gl);
        player.update(gl);
    
        // Spawn pipes mechanic.
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
                list.get(i).update(gl);
            }
            getCollision();
        }
    }

    @Override
    public void render(GameLoop gl, Renderer r) {
        background.render(gl, r);
        player.render(gl, r);
        for (int i = 0; i < list.size(); i++){
            list.get(i).render(gl, r);
        }
    }

    // Method to determine whether the player has collided with the pipes.
    public void getCollision(){
        if (player.getPosX() > list.get(0).getPosX() - 55 && player.getPosX() < list.get(0).getPosX() + 55){
            if (player.getPosY() < list.get(0).getPosY() + 674 && player.getPosY() > list.get(0).getPosY() + 550){
                return;
            } else {
                player.setIsLost(true);
            }
        }
    }

    public static void main(String[]args){
        GameLoop gl = new GameLoop(new FlappyBird());
        gl.start();
    }
}
