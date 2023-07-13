package project.frame;

import lombok.Setter;
import project.utilities.ResizeImage;

import javax.swing.*;
import java.awt.*;

public class GameOverFrame extends JFrame {

    private GameFrame gameFrame;
    @Setter
    private String file;
    @Setter
    private String finish;
    private String over;
    private ResizeImage resizeImage;
    private int count;


    public void gameOverFrame(GameFrame gameFrame, String over, int count) {
        this.gameFrame = gameFrame;
        this.over = over;
        this.count = count;
        resizeImage = new ResizeImage();
        over();
        overFrame();
    }

    private void over() {
        switch (over) {
            case "lose" -> {
                setFile("/GameOver.png");
                setFinish("Ви проигралы. ");
            }
            case "vin" -> {
                setFile("/vin.jpg");
                setFinish("Ви Виграли. ");
            }
        }
    }

    private void overFrame() {

        JDialog dialog = new JDialog(this, "Кінець гри", true);
        dialog.setSize(500, 350);
        dialog.setLocationRelativeTo(null);
        JPanel panel = new JPanel(new BorderLayout());
        getContentPane().add(panel);

        JLabel imageLabel = new JLabel(resizeImage.resizeIcon(file, 250, 300));
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
        JLabel textLabel1 = new JLabel("Ви вікористали ( " + count + " ) слів.");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        rightPanel.add(textLabel1, gbc);

        JButton buttonRestart = new JButton("Почати заново.");
        gbc.gridy = 2;
        buttonRestart.addActionListener(e -> {
            gameFrame.dispose();
            new MainFrame().mainFrame();
            dispose();
        });
        rightPanel.add(buttonRestart, gbc);
        JButton buttonClose = new JButton("Закрити і вийті.");
        gbc.gridy = 3;
        buttonClose.addActionListener(e -> {
            gameFrame.dispose();
            dispose();
        });
        rightPanel.add(buttonClose, gbc);
        setVisible(true);
        dialog.getContentPane().add(panel);
        dialog.setResizable(false);
        dialog.setVisible(true);
    }
}
