package View;

import javax.swing.*;

public class StudentForm extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton createButton;
    private JButton cancelButton;
    private JCheckBox checkBox1;
    private JPanel studentPanel;

    public StudentForm() {
        setTitle("Cadastro de Estudante");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        getContentPane().add(studentPanel);
    }

    public static void main(String[] args) {
        StudentForm studentForm = new StudentForm();
    }
}
