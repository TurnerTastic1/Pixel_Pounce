package inputs;

import java.awt.event.MouseListener;

public class GameMouseListener implements MouseListener {
    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        System.out.println("Mouse clicked");
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        System.out.println("Mouse pressed");
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
        System.out.println("Mouse released");
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
        System.out.println("Mouse entered");
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
        System.out.println("Mouse exited");
    }
}
