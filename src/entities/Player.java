package entities;

public class Player extends Entity{
    private static final String imgName = "resources/sprites/player.png";
    private static final int PLAYER_WIDTH = 8*5;
    private static final int PLAYER_HEIGHT = 15*5;

    // Change these values to change the player's starting position ** Not final **
    private static final double PLAYER_X = 50;
    private static final double PLAYER_Y = 100;
    private static final boolean PLAYER_VISIBLE = true;
    private static int hp = 1;
    public Player(String imageName, int height, int width, double x, double y, boolean isVisible) {
        super(imgName, PLAYER_HEIGHT, PLAYER_WIDTH, PLAYER_X, PLAYER_Y, PLAYER_VISIBLE);
    }

    public Player() {
        super(imgName, PLAYER_HEIGHT, PLAYER_WIDTH, PLAYER_X, PLAYER_Y, PLAYER_VISIBLE);
    }

    public int getHp() {
    	return hp;
    }

    public static void setHp(int hp) {
    	Player.hp = hp;
    }

    @Override
    public void update() {

    }

    @Override
    public void render() {

    }

}
