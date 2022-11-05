package Controller;

import Model.Student;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class StudentController {

    public void createStudent(Student std) {
        try {
            System.out.println(std);
            List<Student> list = new ArrayList<>();

            if (std.getName() != "") {
                if(std.getNp1() != null && std.getNp2() != null) {
                        var lowerThanAverageCalc = (std.getNp1() + std.getNp2()) / 2;

                        if (lowerThanAverageCalc >= 6) {
                            list.add(std);
                        } else {
                            if (std.getExamNote() != null) {
                                //calc to declare final note
                            }
                        }

                } else {
                    System.out.println("NP1 must be declared");
                }
            } else {
                System.out.println("Name is obligatory");
            }
        } catch (Exception err) {
            System.out.println("Error: " + err);
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
