package Model;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class Table {

    private DefaultTableModel tableModel;

    public Table(String[] columns) {
        tableModel = new DefaultTableModel();
        for(String column : columns) {
            tableModel.addColumn(column);
        }
    }

    public void fillStudentTable(List<Student> studentList) {
        for(Student student : studentList) {
            tableModel.addRow(new Object[]{student.getName(), student.getNp1(), student.getNp2(), student.getExamNote(), student.getRepositionNote()});
        }
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }
}
