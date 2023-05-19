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
            case RIGHT_KEY -> moveRight();
            case LEFT_KEY -> moveLeft();
            case Q_KEY -> Player.setHp(0);
        }
    }

    @Override
    public void updateplayerX() {
        player.setX(player.getX() + velx);
    }


    public void moveRight() {
        if (velx<6){
            velx++;
        }
    }

    public void moveLeft() {
        if (velx>-6){
            velx--;
        }
    }

    public void moveUp() {
        player.setY(player.getY() +20);
    }
}
