package Utilities;

import javax.swing.*;
import java.awt.*;

public class DisplayImages {
    public static ImageIcon resizeImage(String path){
        ImageIcon i = new ImageIcon(path);
        Image image = i.getImage();
        Image resizedImage = image.getScaledInstance(80, 130, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }
}
