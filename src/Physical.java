package src;

import Utilities.DisplayImages;

import javax.swing.*;
import java.util.Objects;
import java.util.Random;

public class Physical implements Award {
    public static String[] prizes = {"Flat screen TV", "Free ice cream for a year", "MacBook Pro", "iPhone 14 Max", "Airpods"};
    public static JLabel e;

    public static int getRandomPrize() {
        Random random = new Random();
        return random.nextInt(5);
    }

    @Override
    public int displayWinnings(Players player, boolean isTrue) {
        int thePrize = getRandomPrize();
        if (isTrue) {
            System.out.println(prizes[thePrize]);
            GUI.textArea.append(player + " is the winner! \n" +
                    prizes[thePrize] + " is your prize! \n\n");
            if (Objects.equals(prizes[thePrize], "Flat screen TV")) {
                ImageIcon i = DisplayImages.resizeImage("Resources/images/tv.jpg");
                e = new JLabel(i);
                GUI.gbc.gridy = 0;
                GUI.contentPanel.add(e);
            }
            if (Objects.equals(prizes[thePrize], "Free ice cream for a year")) {
                ImageIcon i = DisplayImages.resizeImage("Resources/images/ic.jpg");
                e = new JLabel(i);
                GUI.gbc.gridy = 0;
                GUI.contentPanel.add(e);
            }
            if (Objects.equals(prizes[thePrize], "MacBook Pro")) {
                ImageIcon i = DisplayImages.resizeImage("Resources/images/mbp.jpg");
                e = new JLabel(i);
                GUI.gbc.gridy = 0;
                GUI.contentPanel.add(e);
            }
            if (Objects.equals(prizes[thePrize], "iPhone 14 Max")) {
                ImageIcon i = DisplayImages.resizeImage("Resources/images/i14.jpg");
                e = new JLabel(i);
                GUI.gbc.gridy = 0;
                GUI.contentPanel.add(e);
            }
            if (Objects.equals(prizes[thePrize], "Airpods")) {
                ImageIcon i = DisplayImages.resizeImage("Resources/images/ap.jpg");
                e = new JLabel(i);
                GUI.gbc.gridy = 0;
                GUI.contentPanel.add(e);
            }
        } else {
            GUI.textArea.append(player + " is incorrect! \n" +
                    prizes[thePrize] + " could have been your prize! \n\n");
        }
        return 0;
    }
}
