package project.utilities;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class ResizeImage {

    public ImageIcon resizeIcon(String file, int width, int height) {
        try (InputStream inputStream = getClass().getResourceAsStream(file)){
            BufferedImage image = ImageIO.read(inputStream);
            Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_DEFAULT);
            ImageIcon resIcon = new ImageIcon(resizedImage);
            return resIcon;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
