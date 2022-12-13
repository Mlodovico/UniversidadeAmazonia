package Controller.Hooks;

import Model.Student;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TransformDataToCSV {
    List<String> studentList = new ArrayList<>();

    public String escapeSpecialCharacters(String data) {
        String escapedData = data.replaceAll("\\R", " ");
        if (data.contains(",") || data.contains("\"") || data.contains("'")) {
            data = data.replace("\"", "\"\"");
            escapedData = "\"" + data + "\"";
        }
        return escapedData;
    }

    public String convertToCSV(String[] data) {
        return Stream.of(data)
                .map(this::escapeSpecialCharacters)
                .collect(Collectors.joining(";"));
    }

//    public void givenDataArray_whenConvertToCSV_thenOutputCreated() throws IOException {
//        File csvOutputFile = new File("CSV_FILE");
//        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
//            studentList.stream()
//                    .map(this::convertToCSV)
//                    .forEach(pw::println);
//        }
//        assertTrue(csvOutputFile.exists());
//    }
}
