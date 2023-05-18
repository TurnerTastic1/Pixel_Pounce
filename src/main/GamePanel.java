package main;

import inputs.GameKeyListener;
import inputs.GameMouseListener;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    public GamePanel() {
        addKeyListener(new GameKeyListener());
        addMouseListener(new GameMouseListener());
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.fillRect(100, 100, 200, 200);
    }
}
