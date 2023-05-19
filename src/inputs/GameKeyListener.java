package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashSet;

public class GameKeyListener implements KeyListener {
    private static final HashSet<Integer> gameKeys = new HashSet<Integer>(){{
        add(KeyEvent.VK_UP);
        add(KeyEvent.VK_DOWN);
        add(KeyEvent.VK_LEFT);
        add(KeyEvent.VK_RIGHT);
        add(KeyEvent.VK_Q);
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
        while (isFetchingKeys){
            sleep(100);
        }
        keysCurrentlyPressed.add(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keysCurrentlyPressed.remove(e.getKeyCode());
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
                if (gameKeys.contains(key))
                    onlyMovementKeys.add(key);
            }
            keysCurrentlyPressed = onlyMovementKeys;
            return toReturn;
        }
        catch(RuntimeException re) {
            //just in case we get a one-in-a-million race condition between retrieving/fetching keys
            isFetchingKeys = false;
            return new ArrayList<Integer>();
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
}
