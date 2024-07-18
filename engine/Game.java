package engine;

public abstract class Game {
    public abstract void update(GameLoop gl);
    public abstract void render(Window window, Renderer r);
}   
