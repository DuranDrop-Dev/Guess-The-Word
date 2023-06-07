package Components;

import src.GUI;

import javax.swing.*;
import java.awt.*;

public class WinComponent extends JComponent {
    public static int xPos;
    public static int yPosBalloon;
    public static Image anImage;

    public WinComponent(int width, int height) {
        // Start-point position
        xPos = (GUI.FRAME_WIDTH/2) - (width/2);
        yPosBalloon = 800;

        // Get image
        ImageIcon i = new ImageIcon("Resources/images/balloon.png");
        Image image = i.getImage();
        anImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);

        // Set a timer
        Timer timer = new Timer(50, e -> {
            yPosBalloon -= 30;
            repaint();
        });
        timer.start();
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(anImage, xPos, yPosBalloon, null);
    }
}