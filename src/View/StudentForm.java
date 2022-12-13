package View;

import Controller.StudentController;
import Model.CSV;
import Model.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;

public class StudentForm extends JFrame {
    StudentController controller = new StudentController();
    private JTextField firstNameInput;
    private JTextField lastNameInput;
    private JTextField np1Input;
    private JTextField np2Input;
    private JButton createButton;
    private JButton cancelButton;
    private JCheckBox checkBox1;
    private JPanel studentPanel;
    private JTextField courseInput;
    private JTextField repositionNoteInput;
    private JTextField examNoteInput;

    public StudentForm(DefaultTableModel defaultTableModel, JTable studentTable) {
        setTitle("Cadastro de Estudante");
        setBounds(500, 300, 380, 450);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setVisible(true);
        getContentPane().add(studentPanel);

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student student = new Student();
                CSV csv = new CSV();

                student.setName(firstNameInput.getText() + " " + lastNameInput.getText());
                student.setCourse(courseInput.getText());
                student.setNp1(Integer.parseInt(np1Input.getText()));
                student.setNp2(Integer.parseInt(np2Input.getText()));
                student.setRepositionNote(Integer.parseInt(repositionNoteInput.getText()));
                student.setExamNote(Integer.parseInt(examNoteInput.getText()));

//                controller.createStudent(student);
                defaultTableModel.addRow(new Object[]{student.getName(), student.getNp1(), student.getNp2(), student.getExamNote(), student.getRepositionNote()});

                    csv.write("/Users/murilolodovico/Desktop/university/APS/2/Universidade Amazonia/src/CSV_STUDENTS_PER_COURSE_DATA.csv",student, "studentPerCourseData");


//                if ((np1 + np2) / 2 >= 6) {
//                    Student stdData = new Student(
//                            name,
//                            lastname,
//                            course,
//                            np1,
//                            np2,
//                            0,
//                            0
//                    );
//
//                    controller.createStudent(stdData);
//                    PopupMessage popupMessage = new PopupMessage("Estudante cadastrado com sucesso");
//                    Window win = SwingUtilities.getWindowAncestor((JComponent) e.getSource());
//                    win.dispose();
//                } else {
//                    if(examNote != 0) {
//                        Student stdData = new Student(
//                                name,
//                                lastname,
//                                course,
//                                np1,
//                                np2,
//                                0,
//                                examNote
//                        );
//
//                        controller.getStudentList();
//                        controller.createStudent(stdData);
//                        PopupMessage popupMessage = new PopupMessage("Estudante cadastrado com sucesso");
//                        Window win = SwingUtilities.getWindowAncestor((JComponent) e.getSource());
//                        win.dispose();
//                        return;
//                    }
//
//                    PopupMessage popupMessage = new PopupMessage("Nota de exame final requisitada");
//                }

            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Window win = SwingUtilities.getWindowAncestor((JComponent) e.getSource());
                win.dispose();
            }
        });
        np1Input.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ke) {
                String value = np1Input.getText();
                int l = value.length();
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
                    if (l < 2) {
                        np1Input.setEditable(true);
                    } else {
                        np1Input.setText("0");

                        PopupMessage message = new PopupMessage("Enter only 2 characters(0-10)");
                        message.getContentPane();
                    }
                } else {
                    PopupMessage message = new PopupMessage("Enter only numeric digits(0-9)");
                    message.getContentPane();
                }
            }
        });
        np2Input.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ke) {
                String value = np2Input.getText();
                int l = value.length();
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
                    if (l < 2) {
                        np2Input.setEditable(true);
                    } else {
                        np2Input.setText("0");

                        PopupMessage message = new PopupMessage("Enter only 2 characters(0-10)");
                        message.getContentPane();
                    }
                } else {
                    PopupMessage message = new PopupMessage("Enter only numeric digits(0-9)");
                    message.getContentPane();
                }
            }
        });
    }

    public StudentForm() {

    }

    public static void main(String[] args) {
        StudentForm studentForm = new StudentForm();
    }
}
