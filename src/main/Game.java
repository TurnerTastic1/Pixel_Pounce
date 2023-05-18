package main;

public class Game {
    private GameWindow gameWindow;
    private entities.Player player;
    public Game() {

        gameWindow = new GameWindow();
        gameWindow.requestFocus();

        player = new entities.Player();

    }
}
