package main;

import javax.swing.*;

public class GameWindow {
    private JFrame frame;

    public GameWindow(GamePanel gamePanel) {
        frame = new JFrame("Game");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        frame.add(gamePanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
