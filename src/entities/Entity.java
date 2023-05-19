package entities;

public abstract class Entity {
    private String imageName;
    private int height;
    private int width;
    protected double x,y;
    private boolean isVisible;

    public Entity(String imageName, int height, int width, double x, double y, boolean isVisible) {
        this.imageName = imageName;
        this.height = height;
        this.width = width;
        this.x = x;
        this.y = y;
        this.isVisible = isVisible;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public boolean isVisible() {
        return isVisible;
    }

    /* semantics... set visible implies it will be visible? setVisibility? */
    public void setVisible(boolean visible) {
        isVisible = visible;
    }


    /**
     * Update the player positions and attributes, effects, etc
     */
    public abstract void update();

    /**
     * For the graphics?
     */
    public abstract void render();
}
