package engine;

import entities.Entity;
import main.GameWindow;
import java.awt.event.KeyEvent;

import java.util.ArrayList;

public abstract class Engine {
    public static final int UP_KEY = KeyEvent.VK_UP;// move the player up
    public static final int DOWN_KEY = KeyEvent.VK_DOWN;// .... down
    public static final int LEFT_KEY = KeyEvent.VK_LEFT;// .... left
    public static final int RIGHT_KEY = KeyEvent.VK_RIGHT;// .... right
    public static final int SPACE_KEY = KeyEvent.VK_SPACE;// .... right
    public static boolean leftTrue = false;
    public static boolean rightTrue = false;
    // A collection of all the movement keys
    public static final int[] MOVEMENT_KEYS = { UP_KEY, DOWN_KEY, LEFT_KEY, RIGHT_KEY };

    protected ArrayList<Entity> displayList;

    public double velx=0;
    public double vely=0;
    public boolean isLeftTrue;

    public boolean isRightTrue;

    private static GameWindow gameWindow;
    public Engine (GameWindow gameWindow){
        Engine.gameWindow = gameWindow;
    }
    public void runGame() {
        boolean start = true;
        while(start) {
            this.handlePlayerInput();
            gameWindow.refresh();
            try {
                Thread.sleep(1000/60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void handlePlayerInput(){
        ArrayList<Integer> keysPressed = gameWindow.getKeysPressed();

        for (Integer key : keysPressed) {
            this.handleKeyPress(key); // handle each key individually
        }
    }

    private void sleep(long nanosToSleep){
        if (nanosToSleep <= 0)
            return;
        long start = System.nanoTime();
        while (System.nanoTime() - start < nanosToSleep){
            try {
                Thread.sleep(0, 5000);
            }
            catch(Exception e) {
                //shouldn't ever reach here, but try/catch is necessary due to
                //Java's implementation of Thread.sleep function
            }
        }
    }

    public abstract void handleKeyPress(Integer key);
}
