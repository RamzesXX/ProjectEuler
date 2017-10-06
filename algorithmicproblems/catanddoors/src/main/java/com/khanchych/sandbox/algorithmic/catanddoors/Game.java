package com.khanchych.sandbox.algorithmic.catanddoors;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Game extends JPanel implements MouseListener {

    public static final int PICTURE_WIDTH = 150;
    public static final int Y = 35;
    private static BufferedImage CLOSED_DOOR;
    private static BufferedImage OPEN_DOOR;
    private static BufferedImage OPEN_DOOR_WITH_MOUSE;
    private boolean showHint;
    private boolean drawHint;

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
        this.drawHint = true;
        Button button = new Button("Начать с начала");
        button.setBounds(0, 0, 80, 20);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                catAndDoors.init();
                lastCheckedPosition = 0;
                repaint();
            }
        });
        this.add(button);
        Checkbox checkbox = new Checkbox("Показывать подсказку");
        checkbox.setState(showHint);
        checkbox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                showHint = e.getStateChange() == ItemEvent.SELECTED;
                repaint();
            }
        });
        this.add(checkbox);
    }

    public static void main(String[] args) {
        final Game game = new Game();
        final JFrame frame = new JFrame();

        frame.setResizable(false);
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

        g2.clearRect(0, 330, 1050, 50);
        for (int i = 0; i < catAndDoors.getDoors(); i++) {
            if (catAndDoors.getCatPosition() == i + 1 && drawHint && showHint) {
                g2.drawOval(75 + i * PICTURE_WIDTH, 300 + Y, 5, 5);
            }
            if (i + 1 == lastCheckedPosition) {
                image = catAndDoors.isGameFinished() ? OPEN_DOOR_WITH_MOUSE : OPEN_DOOR;
            } else {
                image = CLOSED_DOOR;
            }
            g2.drawImage(image, i * PICTURE_WIDTH, Y, null);
        }
        g2.drawString("Попыток использовано:" + catAndDoors.getAttemptCount(), 0, 360);
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
        drawHint = false;
        this.repaint();
        th = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                }
                if (!catAndDoors.isGameFinished()) {
                    lastCheckedPosition = 0;
                    drawHint = true;
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
