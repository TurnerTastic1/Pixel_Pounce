package engine;

import entities.Player;
import main.GameWindow;

public class Runner extends Engine{
    private final Player player;
    public Runner(GameWindow gameWindow, Player player) {
        super(gameWindow);
        this.player = player;
    }

    @Override
    public void handleKeyPress(Integer key) {
        switch (key) {
            case UP_KEY -> moveUp();
            case RIGHT_KEY -> moveRight();
            case LEFT_KEY -> moveLeft();
        }
    }

    public void moveRight() {
        player.setX(player.getX() + 20);
    }

    public void moveLeft() {
        player.setX(player.getX() - 20);
    }

    public void moveUp() {
        player.setY(player.getY() - 20);
    }
}
