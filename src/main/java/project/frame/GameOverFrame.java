package project.frame;

import lombok.Getter;
import lombok.Setter;
import project.gameLogic.ScoreCounter;
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
    @Setter
    @Getter
    private int player = 0;
    @Setter
    @Getter
    private int comp = 0;



    private ScoreCounter scoreCounter;

    public void gameOverFrame (ScoreCounter scoreCounter){
        this.scoreCounter = scoreCounter;
//        this.player = player;
//        this.comp = comp;
    }

    public void gameOverFrame (GameFrame gameFrame, String over) {
        this.gameFrame = gameFrame;
        this.over = over;
        resizeImage = new ResizeImage();
        overFrame();
    }
        private void overFrame(){
    //надо получить очки с плайерскоре и компскоре
        
        switch (over){
            case "lose" -> {setFile("/GameOver.png");
            setFinish("Ви проигралы. Ваш счет:");
            }
            case "vin" -> {setFile("/vin.jpg");
            setFinish("Ви Виграли. Ваш счет:");
            }
        }
            System.out.println("getPlayer() = " + scoreCounter.getPlayerScore());
            JDialog dialog = new JDialog(this, "Кінець гри", true);
        dialog.setSize(500, 350);
        dialog.setLocationRelativeTo(null);
        JPanel panel = new JPanel(new BorderLayout());
        getContentPane().add(panel);

        JLabel imageLabel = new JLabel(resizeImage.resizeIcon(file, 250 , 300));
        panel.add(imageLabel, BorderLayout.WEST);
        JPanel rightPanel = new JPanel(new GridBagLayout());
        panel.add(rightPanel, BorderLayout.CENTER);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 10, 10);

        JLabel textLabel = new JLabel(finish);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
//        gbc.gridheight = 2;
        rightPanel.add(textLabel, gbc);
        JLabel textLabel1 = new JLabel("Ви ( " + scoreCounter.getPlayerScore() +
                " ) - Компьютер ( " + scoreCounter.getComputerScore() + " )");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        rightPanel.add(textLabel1, gbc);

        JButton button1 = new JButton("Почати заново.");
        gbc.gridy = 2;
//        gbc.gridheight = 2;
//        gbc.gridwidth = 5;
        button1.addActionListener(e -> {
            gameFrame.dispose();
            new MainFrame().mainFrame();
            dispose();
        });
        rightPanel.add(button1, gbc);
        JButton button2 = new JButton("Закрити і вийті.");
        gbc.gridy = 3;
//        gbc.gridwidth = 5;
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
