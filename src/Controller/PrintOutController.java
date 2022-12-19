package Controller;

import java.io.*;

public class PrintOutController {
    public void printOutFile(boolean studentFileSecected, boolean courseFileSelected, boolean studentPerCourseFileSelected) throws IOException {
        String home = System.getProperty("user.home");

        if (studentFileSecected == true) {
            File sourceLocation = new File("/Users/murilolodovico/Desktop/university/APS/2/Universidade Amazonia/src/CSV_STUDENT_DATA.csv");
            File targetLocation = new File(home + "/Downloads/" + "studentFile" + ".csv");

            InputStream in = new FileInputStream(sourceLocation);
            OutputStream out = new FileOutputStream(targetLocation);

            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
            out.close();
        }

        if (courseFileSelected == true) {
            File courseSourceLocation = new File("/Users/murilolodovico/Desktop/university/APS/2/Universidade Amazonia/src/CSV_COURSES_DATA.csv");
            File courseTargetLocation = new File(home + "/Downloads/" + "courseFile" + ".csv");

            InputStream in = new FileInputStream(courseSourceLocation);
            OutputStream out = new FileOutputStream(courseTargetLocation);

            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
            out.close();
        }

        if (studentPerCourseFileSelected == true) {
            File studentPCourseSourceLocation = new File("/Users/murilolodovico/Desktop/university/APS/2/Universidade Amazonia/src/CSV_STUDENTS_PER_COURSE_DATA.csv");
            File studentPCourseTargetLocation = new File(home + "/Downloads/" + "studentPerCourseFile" + ".csv");

            InputStream in = new FileInputStream(studentPCourseSourceLocation);
            OutputStream out = new FileOutputStream(studentPCourseTargetLocation);

            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
            out.close();
        }
    }
}
