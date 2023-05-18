package main;

import engine.Engine;

public class Game {
    private GameWindow gameWindow;
    private Engine engine;
    private entities.Player player;
    public Game() {

        gameWindow = new GameWindow();
        gameWindow.requestFocus();
        engine = new Engine(gameWindow);



        player = new entities.Player();

    }

    public void start(){
        engine.runGame();
    }
}
