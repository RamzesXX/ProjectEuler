package com.khanchych.sandbox.algorithmic.catanddoors;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Game extends JPanel implements MouseListener {

    public static final int PICTURE_WIDTH = 150;
    private static BufferedImage CLOSED_DOOR;
    private static BufferedImage OPEN_DOOR;
    private static BufferedImage OPEN_DOOR_WITH_MOUSE;

    static {
        ClassLoader classLoader = Game.class.getClassLoader();

        try {
            CLOSED_DOOR = ImageIO.read(classLoader.getResourceAsStream("ClosedDoor.jpg"));
            OPEN_DOOR = ImageIO.read(classLoader.getResourceAsStream("OpenDoor.jpg"));
            OPEN_DOOR_WITH_MOUSE = ImageIO.read(classLoader.getResourceAsStream("OpenDoorWithMouse.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private CatAndDoors catAndDoors;
    private int lastCheckedPosition;
    private Thread th;

    public Game() {
        this.catAndDoors = new CatAndDoors(7);

    }

    public static void main(String[] args) {
        final Game game = new Game();
        final JFrame frame = new JFrame();


        frame.setContentPane(game);
        frame.addMouseListener(game);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1050, 400);
        frame.setVisible(true);
    }


    @Override
    public void paint(Graphics g) {
        BufferedImage image;
        Graphics2D g2 = (Graphics2D) g.create();

        for (int i = 0; i < catAndDoors.getDoors(); i++) {
            if (i + 1 == lastCheckedPosition) {
                image = catAndDoors.isGameFinished() ? OPEN_DOOR_WITH_MOUSE : OPEN_DOOR;
            } else {
                image = CLOSED_DOOR;
            }
            g2.drawImage(image, i * PICTURE_WIDTH, 0, null);
        }
    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        if (!catAndDoors.isGameFinished()) {
            lastCheckedPosition = 1 + e.getX() / PICTURE_WIDTH;
            try {
                catAndDoors.check(lastCheckedPosition);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        this.repaint();
        th = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                }
                if (!catAndDoors.isGameFinished()) {
                    lastCheckedPosition = 0;
                    repaint();
                }
            }
        });
        th.start();
    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }
}
