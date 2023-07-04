package goit.project.frame;

import goit.project.servis.ResizeImage;

import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static goit.project.servis.Coder.UTF_8;

public class GameOverFrame extends JFrame {

private GameFrame gameFrame;

private String file;

    public void setFile(String file) {
        this.file = file;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    private String finish;

    private String over;


    public void gameOverFrame (GameFrame gameFrame, String over){
        this.gameFrame = gameFrame;
        this.over = over;

        switch (over) {
            case "lose": {
                setFile("src\\main\\resources\\GameOver.png");
                setFinish(UTF_8("Ви програли з рахунком 10"));
                break;
            }
            case "vin": {
                setFile("src\\main\\resources\\vin.jpg");
                setFinish(UTF_8("Мої вітання, Ви виграли!"));
                break;
            }
            default:
                break;
        }

        JDialog dialog = new JDialog(this, UTF_8("Кінець гри"), true);
        dialog.setSize(500, 350);
        dialog.setLocationRelativeTo(null);
        JPanel panel = new JPanel(new BorderLayout());
        getContentPane().add(panel);


        ImageIcon icon = new ImageIcon(file);
        Image resizedImage = new ResizeImage().resizeImage(icon, 250, 300);
        ImageIcon resIcon = new ImageIcon(resizedImage);
        JLabel imageLabel = new JLabel(resIcon);

        panel.add(imageLabel, BorderLayout.WEST);


        JPanel rightPanel = new JPanel(new GridBagLayout());
        panel.add(rightPanel, BorderLayout.CENTER);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 10, 10);

        JLabel textLabel = new JLabel(finish);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        rightPanel.add(textLabel, gbc);

        JButton button1 = new JButton(UTF_8("Почати заново."));
        gbc.gridy = 1;
        button1.addActionListener(e -> {
            gameFrame.dispose();
            new MainFrame().mainFrame();
            dispose();
        });
        rightPanel.add(button1, gbc);

        JButton button2 = new JButton(UTF_8("Закрити і вийті"));
        gbc.gridy = 2;
        button2.addActionListener(e -> {
           gameFrame.dispose();
            dispose();

        });
        rightPanel.add(button2, gbc);

        setVisible(true);

        dialog.getContentPane().add(panel);
        dialog.setResizable(false);
        dialog.setVisible(true);

    }
}
