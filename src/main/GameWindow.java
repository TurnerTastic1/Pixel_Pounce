package main;

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


    public GameWindow() {
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



    // * * Image loading * * //
    public void refresh() {
        frame.repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D)g;

        ensureImagesLoaded();

        drawEntities(g);
    }

    private void drawEntities(Graphics g) {
//        System.out.println("Drawing entity: " + loadedImages.get("player"));
        g.drawImage(loadedImages.get("player"), 0, 0, 100, 100, null);
    }

    private void ensureImagesLoaded(){
        try {
            String path = "src/sprites/player.png";
            loadedImages.put("player", readImage(path));
        } catch (Exception e) {
            System.out.println("Error loading images: " + e);
        }
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
