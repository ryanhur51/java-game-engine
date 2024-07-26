package engine;

//import java.awt.event.KeyEvent;

// GameLoop class which contains the classes needed for game development and updates the thread.   
public class GameLoop implements Runnable{
    private Thread thread; 
    private Window window;
    private Renderer renderer;
    private Input input;
    private Game game;

    private boolean running = false; 
    private final double frameTime = 1.0/60.0;

    public GameLoop(Game game){
        this.game = game;
    }


    // Initializes window, thread, renderer, and the input
    public void start(){
        window = new Window(400, 680, 1f, "Java Game Engine");
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
        double startTime = System.nanoTime() / 1000000000.0; // Time recorded at the end of the previous loop iteration. Divided by 1e9 to convert nanoseconds into seconds
        double elapsedTime = 0;
        double capTime = 0;

        while (running == true){
            render = false;
            currentTime = System.nanoTime() / 1000000000.0; 
            elapsedTime = currentTime - startTime;
            startTime = currentTime; // Update startTime to be able to loop properly. 
            capTime += elapsedTime;
            //frameTime += elapsedTime;

             // Processing and printing the frames per second. 
            while (capTime >= frameTime){
                capTime = capTime - frameTime;
                render = true; 

                game.update(this);
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
                game.render(this, renderer);
                window.update();
                // frames++;
            }
        }
    }

    public Input getInput(){
        return input;
    }
}