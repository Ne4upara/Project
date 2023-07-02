package goit.project.frame;

import javax.swing.*;
import java.awt.*;
import java.nio.charset.StandardCharsets;
import java.util.TreeMap;
import static goit.project.servis.Coder.UTF_8;

public class GameFrame extends JFrame{

    private String inputWord;

    public void gameFrame() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.GRAY);

        JTextField textField = new JTextField(10);
        textField.setBounds(25, 70, 200, 40);
        JLabel label1 = new JLabel(UTF_8("Введіть назву міста"));
        label1.setBounds(250, 70, 200, 40);
        JLabel label2 = new JLabel(UTF_8("Компьтер каже:"));
        label2.setBounds(250, 150, 200, 40);
        JLabel label3 = new JLabel();
        label3.setBounds(100,210,300,30);
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        label3.setFont(new Font("Comic", Font.CENTER_BASELINE, 16));
        label3.setForeground(Color.RED);
        JButton button = new JButton();
        button.setText(UTF_8("Зробити хід"));
        button.setBounds(25, 150, 200, 40);
        button.addActionListener(e -> {
            inputWord = textField.getText();
        //wordCheck(inputWord);
            label3.setText(wordCheck(inputWord));
        });


        setTitle(UTF_8("Гра ГОРОДА"));
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
            r = UTF_8("Введіте назву міста.");
        } else if (test.containsKey(inputWord)) {//есть ли слово
            if (0 == test.get(inputWord)) {//значение слова 0
                r = UTF_8("Відповідь прийнята");

            } else {
                r = UTF_8("Такое місто є");
            }
        } else if (inputWord.equals("Help")){ // команда здатса и проиграть
            new Test().test();
            gameFrame() ;
        } else if (inputWord.equals("4iter")) {// команда віграть
            new Test().test();
        } else {
            r = UTF_8("Введіте коректную назву міста.");
        }
        return r;
    }
}
