package project.frame;

import project.utilities.ResizeImage;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
        private ResizeImage resizeImage;

        public void mainFrame(){
                startFrame();
        }
        private void startFrame() {
        resizeImage= new ResizeImage();
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.GRAY);

        JLabel greetings = new JLabel("Вітаю вас в грі \"Города\"");
        greetings.setFont(new Font("Arial", Font.ROMAN_BASELINE, 16));
        greetings.setBounds(100, 0, 200, 30);
        greetings.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel copyright = new JLabel("\u00A9" + "Team-4 Go IT");
        copyright.setFont(new Font("Arial", Font.PLAIN, 9));
        copyright.setBounds(315, 50, 200, 30);

        JButton startButton = new JButton(resizeImage.resizeIcon("/Fire.gif", 200, 30));
        startButton.setBorderPainted(false);
        startButton.setContentAreaFilled(false);
        startButton.setText("Натисні, щоб почати грати.");
        startButton.setForeground(Color.ORANGE);
        startButton.setVerticalTextPosition(AbstractButton.CENTER);
        startButton.setHorizontalTextPosition(AbstractButton.CENTER);
        startButton.setFont(new Font("Arial", Font.PLAIN, 12));
        startButton.setFont(startButton.getFont().deriveFont(Font.BOLD));
        startButton.setBounds(100, 30, 200, 30);
        startButton.addActionListener(e -> {
            new GameFrame().gameFrame();
            dispose();
        });
        setTitle("Вітаю");
        add(greetings);
        add(copyright);
        add(startButton);
        add(panel);
        setSize(400, 110);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
}

