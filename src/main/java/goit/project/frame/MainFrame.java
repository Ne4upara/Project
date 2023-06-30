package goit.project.frame;

import goit.project.servis.ResizeImage;
import javax.swing.*;
import java.awt.*;
import java.nio.charset.StandardCharsets;

public class MainFrame extends JFrame {

        public void Viem1() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.GRAY);
        JLabel label = new JLabel(new String("Вітаю вас в грі \"Города\"".getBytes(), StandardCharsets.UTF_8));
        label.setFont(new Font("Arial", Font.PLAIN, 16));
        label.setBounds(110, 0, 200, 30);
        ImageIcon icon = new ImageIcon("Citi\\src\\main\\resources\\Fire.gif");
        Image resizedImage = new ResizeImage().resizeImage(icon, 200, 30);
        ImageIcon resIcon = new ImageIcon(resizedImage);
        JButton button = new JButton(resIcon);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setText(new String("Натисні, щоб почати грати.".getBytes(), StandardCharsets.UTF_8));
        button.setForeground(Color.ORANGE);
        button.setVerticalTextPosition(AbstractButton.CENTER);
        button.setHorizontalTextPosition(AbstractButton.CENTER);
        button.setFont(new Font("Arial", Font.PLAIN, 12));
        button.setFont(button.getFont().deriveFont(Font.BOLD));
        button.setBounds(100, 30, 200, 30);
        button.addActionListener(e -> {
            new MainFrame().Viem2();
            dispose();
        });
        setTitle(new String("Вітаю".getBytes(), StandardCharsets.UTF_8));
        add(label);
        add(button);
        add(panel);
        setSize(400, 110);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public void Viem2() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.GRAY);
        JButton button = new JButton();
        button.setText(new String("Зробити хід".getBytes(), StandardCharsets.UTF_8));
        button.setBounds(25, 150, 200, 40);
        button.addActionListener(e -> dispose());
        JTextField textField = new JTextField(10);
        textField.setBounds(25, 70, 200, 40);
        JLabel label1 = new JLabel(new String("Введіть назву міста".getBytes(), StandardCharsets.UTF_8));
        label1.setBounds(250, 70, 200, 40);
        JLabel label2 = new JLabel(new String("Компьтер каже:".getBytes(), StandardCharsets.UTF_8));
        label2.setBounds(250, 150, 200, 40);

//        JTextArea textArea = new JTextArea();
//        textArea.setBounds(250,150,200,40);
        setTitle(new String("Гра ГОРОДА".getBytes(), StandardCharsets.UTF_8));
        panel.add(button);
        panel.add(textField);
        panel.add(label1);
        panel.add(label2);
        add(panel);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

}
