package View;

import Controller.StudentController;
import Model.Student;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentForm extends JFrame{
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

    public StudentForm() {
        setTitle("Cadastro de Estudante");
        setBounds(500, 300, 380, 450);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setVisible(true);
        getContentPane().add(studentPanel);

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = firstNameInput.getText();
                String lastname = lastNameInput.getText();
                String course = courseInput.getText();
                Integer np1 = Integer.parseInt(np1Input.getText());
                Integer np2 = Integer.parseInt(np2Input.getText());
                Integer repositionNote = Integer.parseInt(repositionNoteInput.getText());
                Integer examNote = Integer.parseInt(examNoteInput.getText());


//                if (np1 == "") {
//                    PopupMessage popUp = new PopupMessage("Error: np1 note is missing");
//                    popUp.getContentPane();
//                } else if (np2 == "") {
//                    PopupMessage popUp = new PopupMessage("Error: np2 note is missing");
//                    popUp.getContentPane();                }
//                if (checkBox1.isSelected()) {
//                    Integer repositionNote = Integer.parseInt(repositionNoteInput.getText());
//                    if (np1 == null || np2 == null) {
//                        Student stdData = new Student(name, lastname, course, Integer.parseInt(np1), Integer.parseInt(np2), repositionNote, null);
//                        return;
//                    }
//                }

//                if ((np1 + np2)/ 2 < 6) {
//                    System.out.println((np1 + np2)/ 2 >= 6);
//                    Integer examNote = Integer.parseInt(examNoteInput.getText());
//                    return;
//                }

                Student stdData = new Student(name, lastname, course, np1, np2, repositionNote, examNote);
                controller.createStudent(stdData);
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }

    public static void main(String[] args) {
        StudentForm studentForm = new StudentForm();
    }
}
