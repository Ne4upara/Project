package goit.project.frame;

import javax.swing.*;
import java.awt.*;
import java.nio.charset.StandardCharsets;
import java.util.TreeMap;

public class GameFrame extends JFrame{

    private String inputWord;

    public void gameFrame() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.GRAY);

        JTextField textField = new JTextField(10);
        textField.setBounds(25, 70, 200, 40);
        JLabel label1 = new JLabel(new String("Введіть назву міста".getBytes(), StandardCharsets.UTF_8));
        label1.setBounds(250, 70, 200, 40);
        JLabel label2 = new JLabel(new String("Компьтер каже:".getBytes(), StandardCharsets.UTF_8));
        label2.setBounds(250, 150, 200, 40);
        JLabel label3 = new JLabel();
        label3.setBounds(100,210,300,30);
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        label3.setFont(new Font("Comic", Font.CENTER_BASELINE, 16));
        label3.setForeground(Color.RED);
        JButton button = new JButton();
        button.setText(new String("Зробити хід".getBytes(), StandardCharsets.UTF_8));
        button.setBounds(25, 150, 200, 40);
        button.addActionListener(e -> {
            inputWord = textField.getText();
        //wordCheck(inputWord);
            label3.setText(wordCheck(inputWord));
        });


        setTitle(new String("Гра ГОРОДА".getBytes(), StandardCharsets.UTF_8));
        panel.add(button);
        panel.add(textField);
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        add(panel);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private String wordCheck (String s) {
        //заглушка на мап реализацию
        TreeMap <String, Integer> test = new TreeMap<>();
        test.put ("ff" , 0);
        test.put ("dd" , 1);


        String r = "";


        if (inputWord.isEmpty()) {//пусто ли
            r = new String("Введіте назву міста.".getBytes(), StandardCharsets.UTF_8);
        } else if (test.containsKey(inputWord)) {//есть ли слово
            if (0 == test.get(inputWord)) {//значение слова 0
                r = new String("Відповідь прийнята".getBytes(), StandardCharsets.UTF_8);

            } else {
                r = new String("Такое місто є".getBytes(), StandardCharsets.UTF_8);
            }
        } else {
            r = new String("Введіте коректную назву міста.".getBytes(), StandardCharsets.UTF_8);
        }
        return r;
    }
}
