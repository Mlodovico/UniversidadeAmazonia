package Model;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CSV {
    public static List<List<String>> read(String path) throws FileNotFoundException {

        List<List<String>> records = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                records.add(Arrays.asList(values));
            }

            return records;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(String path, int selectedRow) throws IOException {
        File file = new File(path);
        List<List<String>> records = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                records.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(int selectedRow, Object data) {
        String path = "/Users/murilolodovico/Desktop/university/APS/2/Universidade Amazonia/src/CSV_STUDENTS_PER_COURSE_DATA.csv";

        try(BufferedReader br = new BufferedReader(new FileReader(path))) {

        } catch (IOException err) {
            throw new RuntimeException(err);
        }
    }

    public void write(String path, Student student, String csvType) {
        List<String[]> dataLines = new ArrayList<>();
        File file = new File(path);

        if(csvType.equals("studentData")) {
            dataLines.add(new String[]{student.getId(),student.getName()});

            try(PrintWriter pw = new PrintWriter(new FileOutputStream(file, true))) {
                dataLines.stream()
                        .map(this::convertToCSV)
                        .forEach(pw::println);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        if(csvType.equals("studentPerCourseData")) {
            dataLines.add(new String[]{student.getId(), String.valueOf(student.getNp1()), String.valueOf(student.getNp2()), String.valueOf(student.getExamNote()), String.valueOf(student.getRepositionNote())});

            try(PrintWriter pw = new PrintWriter(new FileOutputStream(file, true))) {
                dataLines.stream()
                        .map(this::convertToCSV)
                        .forEach(pw::println);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        if(csvType.equals("courseData")) {

            int level = (int)Math.floor(Math.random()*(7-2+1)+2);
            int year = (int)Math.floor(Math.random()*(10-1+1)+2);

            dataLines.add(new String[]{student.getCourse(), String.valueOf(level), String.valueOf(year)});

            try(PrintWriter pw = new PrintWriter(new FileOutputStream(file, true))) {
                dataLines.stream()
                        .map(this::convertToCSV)
                        .forEach(pw::println);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private String convertToCSV(String[] data) {
        return Stream.of(data)
                .map(this::escapeSpecialCharacters)
                .collect(Collectors.joining(";"));
    }

    private String escapeSpecialCharacters(String data) {
        String escapedData = data.replaceAll("\\R", " ");
        if (data.contains(",") || data.contains("\"") || data.contains("'")) {
            data = data.replace("\"", "\"\"");
            escapedData = "\"" + data + "\"";
        }
        return escapedData;
    }
}
