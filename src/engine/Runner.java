package engine;

import entities.Player;
import main.GameWindow;

public class Runner extends Engine{
    private final Player player;
    public Runner(GameWindow gameWindow, Player player) {
        super(gameWindow);
        this.player = player;
    }

    protected boolean isGameOver() {
        return player.getHp() <= 0;
    }

    @Override
    public void handleKeyPress(Integer key) {
        switch (key) {
            case UP_KEY -> moveUp();
            case RIGHT_KEY -> isRightTrue = true;
            case LEFT_KEY -> isLeftTrue = true;
            case Q_KEY -> Player.setHp(0);
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
