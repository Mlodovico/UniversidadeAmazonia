package Controller;

import Model.Student;

import java.security.cert.Extension;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentController {
    List<Student> studentList = new ArrayList<>();

    public void createStudent(Student std) {
        try {
            studentList.add(std);
            System.out.println(std.getName());
            System.out.println("LISTA ESTUDANTES: " + studentList);
        } catch (Exception err) {
            System.out.println("Error: " + err);
        }
    }

    public ArrayList<Student> getStudentList() {
        try {
            System.out.println(studentList);
            return (ArrayList<Student>) studentList;
        } catch (Exception err) {
            System.out.println("Error: " + err);
            return null;
        }
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
