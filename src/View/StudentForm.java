package View;

import Controller.StudentController;
import Model.Student;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
                String np1 = np1Input.getText();
                String np2 = np2Input.getText();
                String repositionNote = repositionNoteInput.getText();
                Integer examNote = Integer.parseInt(examNoteInput.getText());

                if (np1 == "0") {
                    System.out.println("Alooo");
                }


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

                Student stdData = new Student(
                        name,
                        lastname,
                        course,
                        Integer.parseInt(np1),
                        Integer.parseInt(np2),
                        Integer.parseInt(repositionNote),
                        examNote
                );

                controller.createStudent(stdData);
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                        np1Input.setEditable(false);
                        PopupMessage message = new PopupMessage("Enter only 2 characters(0-10)");
                        message.getContentPane();
                    }
                } else {
                    np1Input.setEditable(false);
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
                        np2Input.setEditable(false);

                        np2Input.setText("Enter only 2 characters(0-10)");
                    }
                } else {
                    np2Input.setEditable(false);
                    np2Input.setText("Enter only numeric digits(0-9)");
                }
            }
        });
    }

    public static void main(String[] args) {
        StudentForm studentForm = new StudentForm();
    }
}
