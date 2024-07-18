package engine;

//import java.awt.event.KeyEvent;

// GameLoop class which contains the classes needed for game development and updates the thread.   
public class GameLoop implements Runnable{
    private Thread thread; 
    private Window window;
    private Renderer renderer;
    private Input input;

    private boolean running = false; 
    private final double FPS = 1.0/60.0;

    public GameLoop(){
    }


    // Initializes window, thread, renderer, and the input
    public void start(){
        window = new Window(320, 240, 1f, "Java Game Engine");
        thread = new Thread(this);
        renderer = new Renderer(window);
        input = new Input(window);

        thread.run();
    }

    public void stop(){
    }


    // Main gameloop
    public void run(){ 
        running = true;
        boolean render = false; 

        double currentTime = 0; // Time recorded at the start of the interation. 
        double lastTime = System.nanoTime() / 1000000000.0; // Time recorded at the end of the previous loop iteration. 
        double elapsedTime = 0;
        double unprocessedTime = 0;

        // double frameTime = 0;
        // int frames = 0;
        // int fps = 0;

        while (running == true){
            render = false;
            currentTime = System.nanoTime() / 1000000000.0; 
            elapsedTime = currentTime - lastTime;
            lastTime = currentTime; // Update lastTime to be able to loop properly. 
            unprocessedTime += elapsedTime;
            //frameTime += elapsedTime;

             // Processing and printing the frames per second. 
            while (unprocessedTime >= FPS){
                unprocessedTime -= FPS;
                render = true; 

                input.update();
                // if (frameTime >= 1.0){
                //     frameTime = 0;
                //     fps = frames;
                //     frames = 0;
                //     System.out.println(fps);
                // }
            }


            // Render new frames.
            if (render == true){
                renderer.clear();
                window.update();
                // frames++;
            }
        }
    }

    public static void main (String[]args){
        GameLoop gl = new GameLoop();
        gl.start();
    }
}