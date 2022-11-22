package Controller;

import Model.Student;

import java.security.cert.Extension;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class StudentController {
    List<Student> list = new ArrayList<>();

    public void createStudent(Student std) {
        try {
            list.add(std);
            System.out.println(std.getName());
        } catch (Exception err) {
            System.out.println("Error: " + err);
        }
    }

    public Student getStudentList() {
        try {
            System.out.println(list);
            return (Student) list;
        } catch (Exception err) {
            System.out.println("Error: " + err);
            return null;
        }
    }

    public void deleteStudent() {
        try {

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
