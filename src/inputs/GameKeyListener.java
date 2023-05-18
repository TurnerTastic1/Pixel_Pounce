package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashSet;

public class GameKeyListener implements KeyListener {
    private static final HashSet<Integer> movementKeys = new HashSet<Integer>(){{
        add(KeyEvent.VK_UP);
        add(KeyEvent.VK_DOWN);
        add(KeyEvent.VK_LEFT);
        add(KeyEvent.VK_RIGHT);
    }};
    private HashSet<Integer> keysCurrentlyPressed;
    private Boolean isFetchingKeys = false;

    public GameKeyListener() {
        keysCurrentlyPressed = new HashSet<Integer>();
    }

    public HashSet<Integer> getKeysCurrentlyPressed() {
        return keysCurrentlyPressed;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keysCurrentlyPressed.add(e.getKeyCode());
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP -> System.out.println("Up pressed");
            case KeyEvent.VK_DOWN -> System.out.println("Down pressed");
            case KeyEvent.VK_LEFT -> System.out.println("Left pressed");
            case KeyEvent.VK_RIGHT -> System.out.println("Right pressed");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public ArrayList<Integer> getKeysPressed(){
        isFetchingKeys = true;
        try{
            ArrayList<Integer> toReturn = new ArrayList<Integer>(keysCurrentlyPressed);
            HashSet<Integer> onlyMovementKeys = new HashSet<Integer>();
            //create a copy of what's currently pressed to avoid concurrent modification
            HashSet<Integer> currentPressCopy = new HashSet<Integer>(keysCurrentlyPressed);
            isFetchingKeys = false;
            //Remove any non-movement keys from the Set of keys currently pushed down
            //so they are not registered on subsequent checks by the game
            //Movement-specific keys remain in the Set to ensure smooth/reactive movement
            for (Integer key : currentPressCopy){
                if (movementKeys.contains(key))
                    onlyMovementKeys.add(key);
            }
            keysCurrentlyPressed = onlyMovementKeys;
            return toReturn;
        }
        catch(RuntimeException re){
            //just in case we get a one-in-a-million race condition between retrieving/fetching keys
            isFetchingKeys=false;
            return new ArrayList<Integer>();
        }
    }
}
