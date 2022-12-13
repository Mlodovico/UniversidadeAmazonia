package Controller;

import Controller.Hooks.TransformDataToCSV;
import Model.Course;
import Model.Student;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class StudentController {

    List<Student> studentList;
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

    public void createStudent(Student std) {
        try {
            studentList.add(std);
            System.out.println(studentList);
        } catch (Exception err) {
            System.out.println("Error: " + err);
        }
    }

//    public void givenDataArray_whenConvertToCSV_thenOutputCreated() throws IOException {
//        File csvOutputFile = new File(CSV_FILE_NAME);
//        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
//            studentList.stream()
//                    .map(this::csvConvert)
//                    .forEach(pw::println);
//        }
//        assertTrue(csvOutputFile.exists());
//    }

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
