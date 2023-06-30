package goit.project.servis;

import javax.swing.*;
import java.awt.*;

public class ResizeImage {

    public Image resizeImage(ImageIcon icon, int width, int height) {
        Image image = icon.getImage();
        Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_DEFAULT);
        return resizedImage;
    }
}
