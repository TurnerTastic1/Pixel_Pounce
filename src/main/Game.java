package main;

import engine.Runner;

import entities.*;

import java.util.ArrayList;

public class Game {
    private GameWindow gameWindow;
    private final Runner engine;
    private Player player;
    private Enemy slime;
    private ArrayList<Entity> displayList;
    public Game() {
        initData();

        gameWindow = new GameWindow(displayList);
        gameWindow.requestFocus();

        engine = new Runner(gameWindow, player);
    }

    public void initData() {
        displayList = new ArrayList<Entity>();
        player = new entities.Player();
        slime = new entities.Enemy("resources/sprites/Slime1.png");
        displayList.add(player);
        displayList.add(slime);
    }

    public void start() {
        engine.runGame();
        engine.exitGame();
    }
}
