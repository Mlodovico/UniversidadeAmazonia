package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreen extends JFrame {
    private JButton createButton;
    private JButton deleteButton;
    private JButton updateButton;
    private JPanel mainPanel;

    public MainScreen() {
        setContentPane(mainPanel);
        setBounds(500, 500, 800, 450);
        setTitle("Interface Universidade Amazonia");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudentForm stdForm = new StudentForm();
                stdForm.getContentPane();
            }
        });
    }

    public static void main(String[] args) {
        MainScreen mainScreen = new MainScreen();
    }
}
