package goit.project.frame;

import goit.project.servis.ResizeImage;
import javax.swing.*;
import java.awt.*;
import java.nio.charset.StandardCharsets;

public class MainFrame1 extends JFrame {        

    public void Viem3(){
        JDialog dialog = new JDialog(this, "Третье окно", true);
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(Color.GRAY);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel label = new JLabel("Третье окно");
        label.setFont(new Font("Arial", Font.PLAIN, 16));

        JButton button = new JButton("Закрыть");
        button.setForeground(Color.ORANGE);
        button.setFont(new Font("Arial", Font.PLAIN, 12));
        button.setFont(button.getFont().deriveFont(Font.BOLD));

        JTextArea textArea = new JTextArea();
        textArea.setPreferredSize(new Dimension(400, 200));

        button.addActionListener(e -> {
            dialog.dispose();
            setVisible(true);
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(label, gbc);

        gbc.gridy = 1;
        panel.add(textArea, gbc);

        gbc.gridy = 2;
        panel.add(button, gbc);

        dialog.add(panel);
        dialog.setSize(400, 300);
        dialog.setLocationRelativeTo(this);
        dialog.setResizable(false);
        dialog.setVisible(true);
        dialog.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);


    }

}
