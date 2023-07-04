package goit.project.frame;

import goit.project.servis.ResizeImage;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import static goit.project.servis.Coder.UTF_8;

public class MainFrame extends JFrame {

        public void mainFrame() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.GRAY);
        JLabel label = new JLabel(UTF_8("Вітаю вас в грі \"Города\""));
        label.setFont(new Font("Arial", Font.PLAIN, 16));
        label.setBounds(110, 0, 200, 30);
        JLabel label1 = new JLabel("\u00A9" + "Team-4 Go IT");
        label1.setFont(new Font("Arial", Font.PLAIN, 9));
        label1.setBounds(315, 50, 200, 30);
        ImageIcon icon = new ImageIcon("src\\main\\resources\\Fire.gif");
        Image resizedImage = new ResizeImage().resizeImage(icon, 200, 30);
        ImageIcon resIcon = new ImageIcon(resizedImage);
        JButton button = new JButton(resIcon);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setText(UTF_8("Натисні, щоб почати грати."));
        button.setForeground(Color.ORANGE);
        button.setVerticalTextPosition(AbstractButton.CENTER);
        button.setHorizontalTextPosition(AbstractButton.CENTER);
        button.setFont(new Font("Arial", Font.PLAIN, 12));
        button.setFont(button.getFont().deriveFont(Font.BOLD));
        button.setBounds(100, 30, 200, 30);
        button.addActionListener(e -> {
            new GameFrame().gameFrame();
            dispose();
        });
        setTitle(UTF_8("Вітаю"));
        add(label);
        add(label1);
        add(button);
        add(panel);
        setSize(400, 110);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
}
