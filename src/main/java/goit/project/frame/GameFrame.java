package goit.project.frame;

import goit.project.servis.ResizeImage;

import javax.swing.*;
import java.awt.*;
import java.nio.charset.StandardCharsets;
import java.util.TreeMap;
import static goit.project.servis.Coder.UTF_8;

public class GameFrame extends JFrame{
    private String inputWord;

    public GameFrame gameFrame() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setOpaque(false);

        JTextField textField = new JTextField(10);
        textField.setBounds(25, 70, 200, 40);
        panel.add(textField);

        JLabel label1 = new JLabel(UTF_8("Введіть назву міста"));
        label1.setBounds(250, 70, 200, 40);
        panel.add(label1);
        JLabel label2 = new JLabel(UTF_8("Компьтер каже:"));
        label2.setBounds(250, 150, 200, 40);
        panel.add(label2);
        JLabel label3 = new JLabel();
        label3.setBounds(100,210,300,30);
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        label3.setFont(new Font("Comic", Font.CENTER_BASELINE, 16));
        label3.setForeground(Color.RED);
        panel.add(label3);

        JButton button = new JButton();
        button.setText(UTF_8("Зробити хід"));
        button.setBounds(25, 150, 200, 40);
        button.addActionListener(e -> {
            inputWord = textField.getText();
            label3.setText(wordCheck(inputWord));
            textField.setText("");
        });
        panel.add(button);

        ImageIcon icon = new ImageIcon("src\\main\\resources\\Sea.gif");
        Image resizedImage = new ResizeImage().resizeImage(icon, 500, 300);
        ImageIcon resIcon = new ImageIcon(resizedImage);
        JLabel backgroundLabel = new JLabel(resIcon);
        backgroundLabel.setBounds(0, 0, 500, 300);
        panel.add(backgroundLabel);

        setTitle(UTF_8("Гра ГОРОДА"));
        getContentPane().add(panel);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        return this;
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
            String over = "lose";
            new GameOverFrame().gameOverFrame(gameFrame(), over);
//            dispose();

        } else if (inputWord.equals("4")) {// команда віграть
            String over = "vin";
            new GameOverFrame().gameOverFrame(gameFrame(), over);
        } else {
            r = UTF_8("Введіте коректную назву міста.");
        }
        return r;
    }
}
