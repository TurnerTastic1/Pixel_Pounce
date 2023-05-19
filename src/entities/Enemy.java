package entities;

public class Enemy extends Entity{
    private static final String imgName = "src/sprites/player.png";
    private static final int PLAYER_WIDTH = 8*5;
    private static final int PLAYER_HEIGHT = 15*5;

    // Change these values to change the player's starting position ** Not final **
    private static final double PLAYER_X = 100;
    private static final double PLAYER_Y = 50;
    private static final boolean PLAYER_VISIBLE = true;
    public Enemy(String imageName, int height, int width, double x, double y, boolean isVisible) {
        super(imgName, PLAYER_HEIGHT, PLAYER_WIDTH, PLAYER_X, PLAYER_Y, PLAYER_VISIBLE);
    }

    public Enemy() {
        super(imgName, PLAYER_HEIGHT, PLAYER_WIDTH, PLAYER_X, PLAYER_Y, PLAYER_VISIBLE);
    }

    public Enemy(String imgName) {
        super(imgName, PLAYER_HEIGHT, PLAYER_WIDTH, PLAYER_X, PLAYER_Y, PLAYER_VISIBLE);
    }

    @Override
    public void update() {

    }

    @Override
    public void render() {

    }
}
