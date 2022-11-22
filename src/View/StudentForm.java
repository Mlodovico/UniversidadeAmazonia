package View;

import Controller.StudentController;
import Model.Student;

import javax.swing.*;
import java.awt.*;
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
                Integer np1 = Integer.parseInt(np1Input.getText());
                Integer np2 = Integer.parseInt(np2Input.getText());
                Integer repositionNote = Integer.parseInt(repositionNoteInput.getText());
                Integer examNote = Integer.parseInt(examNoteInput.getText());

                if (checkBox1.isSelected() == true) {
                    Student stdData = new Student(
                            name,
                            lastname,
                            course,
                            np1,
                            np2,
                            repositionNote,
                            examNote
                    );

                    controller.createStudent(stdData);
                    return;
                }

                if ((np1 + np2) / 2 >= 6) {
                    Student stdData = new Student(
                            name,
                            lastname,
                            course,
                            np1,
                            np2,
                            0,
                            0
                    );

                    controller.createStudent(stdData);
                    PopupMessage popupMessage = new PopupMessage("Estudante cadastrado com sucesso");
                    Window win = SwingUtilities.getWindowAncestor((JComponent) e.getSource());
                    win.dispose();
                }

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
