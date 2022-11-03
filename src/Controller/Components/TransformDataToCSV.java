package Controller.Components;

import Model.Course;
import Model.Student;

public class TransformDataToCSV {
    String dataFormatted = new String();

    public String formatStudentData(Student std) {
        dataFormatted = std.getId() + ": " + std.getName();
        return dataFormatted;
    }

    public String formatCoursesData(Course course) {
        dataFormatted = course.getName() + ": " + course.getLevel() + ": " + course.getYear();
        return dataFormatted;
    }
}
