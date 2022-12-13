package View;

import Controller.StudentController;
import Model.CSV;
import Model.Student;
import Model.Table;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class MainScreen extends JFrame {
    private JButton createButton;
    private JButton deleteButton;
    private JButton updateButton;
    private JPanel mainPanel;
    private JTable studentTable;
    private JButton printOutButton;

    public void updateTable(DefaultTableModel defaultTableModel) {
        studentTable.setModel(defaultTableModel);
    }

    public MainScreen() throws FileNotFoundException {

        List<List<String>> student = CSV.read("/Users/murilolodovico/Desktop/university/APS/2/Universidade Amazonia/src/CSV_STUDENT_DATA.csv");
        List<List<String>> studentPerCourse = CSV.read("/Users/murilolodovico/Desktop/university/APS/2/Universidade Amazonia/src/CSV_STUDENTS_PER_COURSE_DATA.csv");


        setContentPane(mainPanel);
        setBounds(500, 500, 800, 450);
        setTitle("Interface Universidade Amazonia");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        StudentController controller = new StudentController(student, studentPerCourse);
        List<Student> data = controller.getStudentList();

        Table defaultTableModel = new Table(new String[] {"Nome Completo", "NP1", "NP2", "Nota de exame", "Nota de reposicao"});
        defaultTableModel.fillStudentTable(data);

        updateTable(defaultTableModel.getTableModel());

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudentForm stdForm = new StudentForm(defaultTableModel.getTableModel(), studentTable);
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
        printOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PrintOutPopUp printOutView = new PrintOutPopUp();
            }
        });
    }

    public static void main(String[] args) throws FileNotFoundException {
        MainScreen mainScreen = new MainScreen();
    }
}
