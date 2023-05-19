package main;

import engine.TickedEngine;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.start();

        /* ticked alternative */
        TickedEngine engine = new TickedEngine();

        /* create player objects, render, etc */
        engine.start();

        /* create external methods for TickedEngine::@35 to update and render */

        //engine.interrupt(); /* for pausing */
        //engine.run(); /* unpause */
    }
}