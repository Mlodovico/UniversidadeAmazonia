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

                String name = firstNameInput.getText();
                String lastname = lastNameInput.getName();
                Integer np1 = Integer.parseInt(np1Input.getText());
                Integer np2 = Integer.parseInt(np2Input.getText());
                Integer examNote = Integer.parseInt(examNoteInput.getText());
                Integer repositionNote = Integer.parseInt(repositionNoteInput.getText());

//                student.setName(firstNameInput.getText() + " " + lastNameInput.getText());
//                student.setCourse(courseInput.getText());
//                student.setNp1(np1);
//                student.setNp2(Integer.parseInt(np2Input.getText()));
//                student.setRepositionNote(Integer.parseInt(repositionNoteInput.getText()));
//                student.setExamNote(Integer.parseInt(examNoteInput.getText()));

                if (firstNameInput.getText().equals("") || lastNameInput.getText().equals("")) {
                    PopupMessage popupMessage = new PopupMessage("Nome e sobrenome obrigatorios");
                    return;
                }

                if (courseInput.getText().equals("")) {
                    PopupMessage popupMessage = new PopupMessage("Curso obrigatorio");
                    return;
                }

                if ((np1 + np2) / 2 >= 6) {
                    student.setName(firstNameInput.getText() + " " + lastNameInput.getText());
                    student.setCourse(courseInput.getText());
                    student.setNp1(np1);
                    student.setNp2(np2);
                    student.setRepositionNote(0);
                    student.setExamNote(0);

                    controller.createStudent(defaultTableModel, student);

                    PopupMessage popupMessage = new PopupMessage("Estudante cadastrado com sucesso");
                    Window win = SwingUtilities.getWindowAncestor((JComponent) e.getSource());
                    win.dispose();
                } else {
                    if(examNote != 0) {
                        student.setName(firstNameInput.getText() + " " + lastNameInput.getText());
                        student.setCourse(courseInput.getText());
                        student.setNp1(np1);
                        student.setNp2(np2);
                        student.setRepositionNote(0);
                        student.setExamNote(examNote);

                        controller.createStudent(defaultTableModel, student);

                        PopupMessage popupMessage = new PopupMessage("Estudante cadastrado com sucesso");

                        Window win = SwingUtilities.getWindowAncestor((JComponent) e.getSource());
                        win.dispose();
                        return;
                    }

                    PopupMessage popupMessage = new PopupMessage("Nota de exame final requisitada");
                }

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
