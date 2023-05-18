package engine;

import main.GameWindow;

public class Engine {
    boolean start = true;
    private static GameWindow gameWindow;
    public Engine (GameWindow gameWindow){
        Engine.gameWindow = gameWindow;
    }
    public void runGame(){
        while(start) {
            this.handlePlayerInput();
            gameWindow.refresh();
        }
    }

    private void handlePlayerInput(){
        ArrayList<Integer> keysPressed = gameWindow.getKeysPressed();
    }
}
