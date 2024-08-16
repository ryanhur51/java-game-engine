package game;

import engine.GameLoop;
import engine.Renderer;

// Abstract class for all game objects.
public abstract class GameObject {
    public abstract void update(GameLoop gl);
    public abstract void render(GameLoop gl, Renderer r);
}
