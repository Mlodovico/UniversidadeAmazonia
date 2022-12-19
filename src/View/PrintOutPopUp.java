package View;

import Controller.PrintOutController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class PrintOutPopUp extends JFrame {
    private JRadioButton printStudentsButton;
    private JRadioButton printCoursesButton;
    private JRadioButton printStudentsPCoursesButton;
    private JButton cancelButton;
    private JButton printOutButton;
    private JPanel printOutPanel;

    public PrintOutPopUp() {
        PrintOutController controller = new PrintOutController();
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
                try {
                    controller.printOutFile(printStudentsButton.isSelected(), printCoursesButton.isSelected(), printStudentsPCoursesButton.isSelected());

                    Window win = SwingUtilities.getWindowAncestor((JComponent) e.getSource());
                    win.dispose();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public static void main(String[] args) {
        PrintOutPopUp printOutPopUp = new PrintOutPopUp();
    }
}
