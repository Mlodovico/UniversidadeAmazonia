package Controller;

import Model.CSV;
import Model.Course;
import Model.Student;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class StudentController {

    List<Student> studentList;
    CSV csv = new CSV();

    public StudentController() {
        this.studentList = new ArrayList<>();
    }

    public Integer getValidNote(String note) {
        if(!note.replaceAll("\\s+", "").equals("null")) {
            return Integer.parseInt(note.replaceAll("\\s+", ""));
        }

        return 0;
    }
    public StudentController(List<List<String>> studentListByCSV, List<List<String>> studentPerCourseListByCSV) {
        List<Student> students = new ArrayList<>();
        List<Course> courses = new ArrayList<>();

        for (int i = 1; i < studentListByCSV.size(); i ++) {
            Student student = new Student();

            student.setId(studentListByCSV.get(i).get(0));
            student.setName(studentListByCSV.get(i).get(1));
            student.setNp1(getValidNote(studentPerCourseListByCSV.get(i).get(1)));
            student.setNp2(getValidNote(studentPerCourseListByCSV.get(i).get(2)));
            student.setExamNote(getValidNote(studentPerCourseListByCSV.get(i).get(3)));
            student.setRepositionNote(getValidNote(studentPerCourseListByCSV.get(i).get(4)));

            students.add(student);
        }

        this.studentList = students;
    }

    public void createStudent(DefaultTableModel defaultTableModel, Student student) {
        try {
            defaultTableModel.addRow(new Object[]{student.getName(), student.getNp1(), student.getNp2(), student.getExamNote(), student.getRepositionNote()});
            csv.write("/Users/murilolodovico/Desktop/university/APS/2/Universidade Amazonia/src/CSV_STUDENTS_PER_COURSE_DATA.csv",student, "studentPerCourseData");
            csv.write("/Users/murilolodovico/Desktop/university/APS/2/Universidade Amazonia/src/CSV_STUDENT_DATA.csv", student, "studentData");
            csv.write("/Users/murilolodovico/Desktop/university/APS/2/Universidade Amazonia/src/CSV_COURSES_DATA.csv", student, "courseData");
        } catch (Exception err) {
            System.out.println("Error: " + err);
        }
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void deleteStudent(String id) {
        try {
            for (int i = 0; i == studentList.size(); i++) {

                Student std = studentList.get(i);

                if (std.getId() == id) {
                    studentList.remove(i);
                    System.out.println("Success delete");
                    return;
                }
            }
        } catch (Exception err) {
            System.out.println("Error: " + err);
        }
    }

    public void updateStudent() {
        try {

        } catch (Exception err) {
            System.out.println("Error: " + err);
        }
    }
}
