package engine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

// Input class which implements the different interfaces for the mouse and keyboard
public class Input implements KeyListener, MouseListener, MouseMotionListener{
    // Keyboard inputs.
    private boolean[] keysCurrent = new boolean[104];
    private boolean[] keysElapsed = new boolean[104];

    // Mouse inputs.
    private boolean[] mouseButtonCurrent = new boolean[3]; 
    private boolean[] mouseButtonElapsed = new boolean[3];

    // Cursor position.
    private int mouseX; 
    private int mouseY;
    
    private Window window; 

    // Constructor
    public Input(Window window){
        this.window = window;
        mouseX = 0;
        mouseY = 0;

        window.getCanvas().addKeyListener(this);
        window.getCanvas().addMouseListener(this);
        window.getCanvas().addMouseMotionListener(this);
    }


    public void update(){
        for (int i = 0; i < keysCurrent.length; i++){
            keysElapsed[i] = keysCurrent[i];
        }

        for (int i = 0; i < mouseButtonCurrent.length; i++){
            mouseButtonElapsed[i] = mouseButtonCurrent[i];
        }
    }


    // Many of these methods are required for the interface to work properly
    public boolean isKey(int keyCode){
        return keysCurrent[keyCode];
    }

    public boolean isKeyUp(int keyCode){
        return !keysCurrent[keyCode] && keysElapsed[keyCode];
    }

    public boolean isKeyDown(int keyCode){
        return keysCurrent[keyCode] && !keysElapsed[keyCode];
    }

    public boolean isMouseButton(int keyCode){
        return mouseButtonCurrent[keyCode];
    }

    public boolean isMouseButtonUp(int keyCode){
        return !mouseButtonCurrent[keyCode] && mouseButtonElapsed[keyCode];
    }

    public boolean isMouseButtonDown(int keyCode){
        return mouseButtonCurrent[keyCode] && !mouseButtonElapsed[keyCode];
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = (int)(e.getX() / window.getScale());
        mouseY = (int)(e.getY() / window.getScale());
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseButtonCurrent[e.getButton()] = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseButtonCurrent[e.getButton()] = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keysCurrent[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keysCurrent[e.getKeyCode()] = false;
    }

    /**
     * Getters and setters. 
     */
    public int getMouseX(){
        return mouseX;
    }
    public int getMouseY(){
        return mouseY;
    }
}
