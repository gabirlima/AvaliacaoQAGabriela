package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SchemaReader {

    public static final String DATA = "src/test/resources/data/";

    public static List<String> getCamposSchema(String file, String type) {
        List<String> campos = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(type + file))) {
            stream.collect(Collectors.toCollection(() -> campos));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return campos;
    }
}
