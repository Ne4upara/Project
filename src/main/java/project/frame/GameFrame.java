package project.frame;

import lombok.Getter;
import lombok.Setter;
import project.gameLogic.ScoreCounter;
import project.utilities.ResizeImage;
import project.gameLogic.GameLogic;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

;

public class GameFrame extends JFrame{
    private String inputWord;
    @Getter
    @Setter
    private String outputWord = "";
    private JLabel titleForComp;
    private JLabel answerError;
    private GameLogic gameLogic;
    private ResizeImage resizeImage;
    private GameOverFrame gameOver;

    public GameFrame gameFrame() {
        gameLogic = new GameLogic();
        resizeImage = new ResizeImage();
        gameOver = new GameOverFrame();
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setOpaque(false);

        JTextField enterWord = new JTextField(10);
        enterWord.setBounds(25, 70, 200, 40);
        panel.add(enterWord);

        JLabel titleForPeople = new JLabel("Введіть назву міста");
        titleForPeople.setBounds(250, 70, 200, 40);
        panel.add(titleForPeople);
        this.titleForComp = new JLabel("Комп'ютер: " + getOutputWord());
        titleForComp.setBounds(250, 150, 200, 40);
        titleForComp.setFont(new Font("Comic", Font.CENTER_BASELINE, 14));
        panel.add(titleForComp);
        this.answerError = new JLabel();
        answerError.setBounds(100,210,300,30);
        answerError.setHorizontalAlignment(SwingConstants.CENTER);
        answerError.setFont(new Font("Comic", Font.CENTER_BASELINE, 16));
        answerError.setForeground(Color.RED);
        panel.add(answerError);

        JButton button = new JButton();
        button.setText("Зробити хід");
        button.setBounds(25, 150, 200, 40);
        button.setContentAreaFilled(false);
        button.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
                answerError.setText("");
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                button.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
                inputWord = enterWord.getText();
                wordCheck(inputWord);
                enterWord.setText("");
            }}) ;
        panel.add(button);

        JLabel backgroundLabel = new JLabel(resizeImage.resizeIcon("/Sea.gif", 500, 300));
        backgroundLabel.setBounds(0, 0, 500, 300);
        panel.add(backgroundLabel);

        setTitle("Гра ГОРОДА");
        getContentPane().add(panel);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        return this;
    }

    private void wordCheck (String s) {
        if (s.isEmpty())  answerError.setText("Введіте коректную назву міста.");
        else if (s.equals("Help")) gameOver.gameOverFrame(gameFrame(), "lose");
        else if (s.equals("4iter")) gameOver.gameOverFrame(gameFrame(), "vin");
        else {
            String out = gameLogic.isValidWord(s);
            switch (out){
                case "error" -> this.answerError.setText("Такого міста нема");
                case "is" -> this.answerError.setText("Місто вже використалось");
                case "vin" -> gameOver.gameOverFrame(gameFrame(), "vin");
                case "lose" -> gameOver.gameOverFrame(gameFrame(), "lose");
                case "first_not_found" -> this.answerError.setText("Ви водите слово, не на ту букву");
                default -> {
                    setOutputWord(out);
                    this.titleForComp.setText("Комп'ютер: " + getOutputWord());
                }
            }
        }
    }
}
