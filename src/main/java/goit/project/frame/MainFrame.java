package goit.project.frame;

import javax.swing.*;
import java.awt.*;

public class MainFrame {

    public static void Viem1() {
        JFrame frame = new JFrame("Вітаю");
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        JLabel label = new JLabel("Прівіт");
        label.setFont(new Font("Arial", Font.PLAIN, 16));
        JButton button = new JButton();
        button.setText("Start");
        button.addActionListener(e -> {Viem2();
            frame.dispose();});

        panel.add(label);
        panel.add(button);
        frame.add(panel);
        frame.setSize(400, 100);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
