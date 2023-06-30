package goit.project.frame;

import javax.swing.*;
import java.awt.*;
import java.nio.charset.StandardCharsets;

public class MainFrame {

    public static void Viem1() {
        JFrame frame = new JFrame(new String("Вітаю".getBytes(), StandardCharsets.UTF_8));
        JPanel panel = new JPanel();
        panel.setLayout(null);
        JLabel label = new JLabel(new String("Вітаю вас в грі \"Города\"".getBytes(), StandardCharsets.UTF_8));
        label.setFont(new Font("Arial", Font.PLAIN, 16));
        label.setBounds(110, 0, 200, 30);
        JButton button = new JButton();
        button.setBounds(100, 30, 200 , 30);
        button.setText(new String("Натисні, щоб почати грати.".getBytes(), StandardCharsets.UTF_8));
        button.addActionListener(e -> {Viem2();
            frame.dispose();});

        panel.add(label);
        panel.add(button);
        frame.add(panel);
        frame.setSize(400, 100);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static void Viem2() {
        JFrame frame = new JFrame("Hello");

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        JButton button = new JButton("Кнопка");
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        panel.add(button, constraints);

        JTextField textField = new JTextField(10);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        panel.add(textField, constraints);

        JLabel label1 = new JLabel("Вывод 1");
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        panel.add(label1, constraints);

        JLabel label2 = new JLabel("Вывод 2");
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        panel.add(label2, constraints);



        frame.add(panel);
        frame.setSize(400, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


}
