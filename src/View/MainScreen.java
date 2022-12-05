package View;

import Controller.StudentController;
import Model.Student;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainScreen extends JFrame {
    StudentController controller = new StudentController();
    private JButton createButton;
    private JButton deleteButton;
    private JButton updateButton;
    private JPanel mainPanel;
    private JTable table1;

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

                ArrayList<Student> list = controller.getStudentList();
                System.out.println(list);
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e);
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateForm updForm = new UpdateForm();
                updForm.getContentPane();
            }
        });
    }

    public static void main(String[] args) {
        MainScreen mainScreen = new MainScreen();
    }
}
