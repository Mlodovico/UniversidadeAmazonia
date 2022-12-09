package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrintOutPopUp extends JFrame {
    private JRadioButton printStudentsButton;
    private JRadioButton printCoursesButton;
    private JRadioButton printStudentsPCoursesButton;
    private JButton cancelButton;
    private JButton printOutButton;
    private JPanel printOutPanel;

    public PrintOutPopUp() {
        setTitle("Impressao de dados");
        setBounds(500, 300, 380, 450);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        getContentPane().add(printOutPanel);
        setVisible(true);


        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Window win = SwingUtilities.getWindowAncestor((JComponent) e.getSource());
                win.dispose();
            }
        });
        printOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        PrintOutPopUp printOutPopUp = new PrintOutPopUp();
    }
}
