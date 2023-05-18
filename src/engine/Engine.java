package engine;

import main.GameWindow;

public class Engine {
    boolean start = true;
    private static GameWindow gameWindow;
    public Engine (GameWindow gameWindow){
        this.gameWindow = gameWindow;
    }
    public void runGame(){
        while(start) {
            handlePlayerInupt();
            gameWindow.refresh();
        }
    }

    private void handlePlayerInupt(){

    }
}
