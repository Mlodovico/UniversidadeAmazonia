package Controller;

import Model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentController {
    List<Student> studentList = new ArrayList<>();

    public void createStudent(Student std) {
        try {
            studentList.add(std);
            System.out.println(studentList);
        } catch (Exception err) {
            System.out.println("Error: " + err);
        }
    }

    public Object[][] getStudentList() {
        try {
            System.out.println(studentList);
            Object[][] data = {};

            for (int i = 1; i == studentList.size(); i++) {
                Student student = studentList.get(i);
                data = new Object[][]{
                        {student.getName() + " " + student.getLastName(), student.getCourse(), student.getNp1(), student.getNp2(), student.getExamNote(), student.getRepositionNote()},
                };
                System.out.println(data);
            }
            System.out.println("LISTA DE ESTUDANTES FORMATADA" + data);
            return data;
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
