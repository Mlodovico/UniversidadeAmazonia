package Controller;

import Model.Student;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

class student extends Student {
    public String name;
    public Integer np1;
    public Integer np2;
    public Integer repositionNote;
    public Integer examNote;

    public student(String name, Integer np1, Integer np2, Integer repositionNote, Integer examNote) {
        super(name, np1, np2, repositionNote, examNote);
    }
};
public class StudentController {

    public void createStudent(student std) {
        try {
            List<Student> list = new ArrayList<>();

            if (std.name != "") {
                if(std.np1 != null && std.np2 != null) {
                        var lowerThanAverageCalc = (std.np1 + std.np2) / 2;

                        if (lowerThanAverageCalc >= 6) {
                            list.add(std);
                        } else {
                            if (std.examNote != null) {
                                
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
