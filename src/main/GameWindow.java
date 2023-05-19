package main;

import entities.Entity;
import inputs.GameKeyListener;
import inputs.GameMouseListener;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class GameWindow extends JComponent{
    private JFrame frame;
    private GameKeyListener keyListener = new GameKeyListener();
    private GameMouseListener mouseListener = new GameMouseListener();

    private HashMap<String, Image> loadedImages;
    private ArrayList<Entity> displayList;


    public GameWindow(ArrayList<Entity> displayList) {
        this.displayList = displayList;

        initLogic();
        initFrame();
    }

    private void initLogic() {
        this.loadedImages = new HashMap<String, Image>();
    }

    private void initFrame() {
        frame = new JFrame("Game");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(this);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        addKeyListener(keyListener);
        addMouseListener(mouseListener);
    }


    // * * Key handling * * //
    public ArrayList<Integer>  getKeysPressed(){
        return keyListener.getKeysPressed();
    }

    // Refresh the window to show any updates to the game
    public void refresh() {
        frame.repaint();
    }

    // Dispose of the window when the game is over
    public void dispose() {
        frame.dispose();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D)g;

        ensureImagesLoaded();

        drawEntities(g);
    }

    private void drawEntities(Graphics g) {
        for (Entity entity : displayList) {
            try {
                Entity e = entity;
                Image img = loadedImages.get(e.getImageName());
                //Draw each entity per its image name, coordinates, and dimensions
                g.drawImage(img, (int) e.getX(), (int) e.getY(), (int) e.getWidth(), (int) e.getHeight(), null);
            } catch (RuntimeException re) {
                //just in case... since students will be modifying the arraylist
            }
        }
    }

    // * * Image loading * * //
    private void ensureImagesLoaded(){
        for (Entity entity : displayList) {
            try {
                Entity e = entity;
                String imageName = e.getImageName();
                if (imageName != null && !loadedImages.containsKey(imageName))
                    loadedImages.put(imageName, readImage(imageName));
            } catch (RuntimeException re) {
                //just in case... since students will be modifying the arraylist
            }
        }
//        try {
//            String path = "src/sprites/player.png";
//            loadedImages.put("player", readImage(path));
//        } catch (Exception e) {
//            System.out.println("Error loading images: " + e);
//        }
    }

    public void preLoadImages() {
        try {
            String path = "src/sprites/player.png";
            loadedImages.put("player", new ImageIcon(path).getImage());
        } catch (Exception e) {
            System.out.println("Error pre-loading images");
        }
    }

    public static Image readImage(String filename){
        if (filename == null)
            return null;
        //need to use URL to allow for animated gifs to animate properly
//        URL imageResource = GamePanel.class.getResource(filename);
//        if (imageResource == null){
//            System.err.println("Unable to read image file: " + filename);
//            return null;
//        }
        return new ImageIcon(filename).getImage();
    }
}
