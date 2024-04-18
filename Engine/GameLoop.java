package Engine;

public class GameLoop implements Runnable{
    private Thread thread; 
    private boolean running = false; 
    private final double FPS = 1.0/60.0;

    public GameLoop(){

    }
    public void start(){
        thread = new Thread(this);
        thread.run();
    }

    public void stop(){

    }

    public void run(){ 
        running = true;
        boolean render = false;
        double startTime = 0;
        double finalTime = System.nanoTime() / 1000000000.0;
        double elapsedTime = 0;
        double unprocessedTime = 0;

        double frameTime = 0;
        int frames = 0;
        int fps = 0;

        while (running == true){
            render = false;
            startTime = System.nanoTime() / 1000000000.0; //milliseconds
            elapsedTime = startTime - finalTime;
            finalTime = startTime;
            unprocessedTime += elapsedTime;

            frameTime += elapsedTime;

            while (unprocessedTime >= FPS){
                unprocessedTime -= FPS;
                render = true;

                if (frameTime >= 1.0){
                    frameTime = 0;
                    fps = frames;
                    frames = 0;
                    System.out.println(fps);
                }
            }

            if(render == true){
                frames++;
            } else {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main (String[]args){
        GameLoop gl = new GameLoop();
        gl.start();
    }
}