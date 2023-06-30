package goit.project.frame;

import javax.swing.*;
import java.awt.*;
import java.nio.charset.StandardCharsets;

public class MainFrame extends JFrame {

    public void Viem1() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        JLabel label = new JLabel(new String("Вітаю вас в грі \"Города\"".getBytes(), StandardCharsets.UTF_8));
        label.setFont(new Font("Arial", Font.PLAIN, 16));
        label.setBounds(110, 0, 200, 30);
        JButton button = new JButton();
        button.setText(new String("Натисні, щоб почати грати.".getBytes(), StandardCharsets.UTF_8));
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
