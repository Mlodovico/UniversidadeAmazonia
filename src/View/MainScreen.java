package View;

import Controller.StudentController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreen extends JFrame {
    StudentController controller = new StudentController();
    private JButton createButton;
    private JButton deleteButton;
    private JButton updateButton;
    private JPanel mainPanel;
    private JTable studentTable;
    private JButton printOutButton;

    public MainScreen() {
        setContentPane(mainPanel);
        setBounds(500, 500, 800, 450);
        setTitle("Interface Universidade Amazonia");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        Object [][] data = controller.getStudentList();
        System.out.println(data);

        studentTable.setModel(new DefaultTableModel(
                data,
                new String [] {"Complete Name", "Course", "NP1", "NP2", "Exam Note", "Reposition Note"}
        ));

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudentForm stdForm = new StudentForm();
                stdForm.getContentPane();
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
