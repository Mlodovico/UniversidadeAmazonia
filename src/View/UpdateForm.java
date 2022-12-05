package View;

import Model.Student;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UpdateForm extends JFrame {
    private JPanel studentPanel;
    private JTextField firstNameInput;
    private JTextField lastNameInput;
    private JTextField np1Input;
    private JTextField np2Input;
    private JButton createButton;
    private JButton cancelButton;
    private JTextField repositionNoteInput;
    private JTextField examNoteInput;
    private JCheckBox checkBox1;
    private JTextField courseInput;

    public UpdateForm() {
        setTitle("Atualizacao de Estudante");
        setBounds(500, 300, 380, 450);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setVisible(true);
        getContentPane().add(studentPanel);
    }

    public static void main(String[] args) {
        UpdateForm updateForm = new UpdateForm();
    }

}
