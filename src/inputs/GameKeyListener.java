package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameKeyListener implements KeyListener {
    @Override
    public void keyPressed(KeyEvent e) {
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
}
