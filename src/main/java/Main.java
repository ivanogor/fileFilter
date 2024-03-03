import java.io.*;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        final File INPUT_FILE = Path.of("src", "in", "test.txt").toFile();
        final File OUTPUT_FILE_FOR_FLOATS = Path.of("src", "out", "floats.txt").toFile();
        final File OUTPUT_FILE_FOR_INTEGERS = Path.of("src", "out", "integers.txt").toFile();
        final File OUTPUT_FILE_FOR_STRINGS = Path.of("src", "out", "strings.txt").toFile();



        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE));
             BufferedWriter floatsWriter = new BufferedWriter(new FileWriter(OUTPUT_FILE_FOR_FLOATS));
             BufferedWriter integersWriter = new BufferedWriter(new FileWriter(OUTPUT_FILE_FOR_INTEGERS));
             BufferedWriter stringsWriter = new BufferedWriter(new FileWriter(OUTPUT_FILE_FOR_STRINGS))) {
            List<String> lines = reader.lines().toList();

            for (String line : lines) {
                if (Pattern.matches("-?\\d+", line)) {
                    integersWriter.write(line);
                    integersWriter.newLine();
                } else if (Pattern.matches("-?\\d+(\\.\\d+)?([eE][+-]?\\d+)?", line)) {
                    floatsWriter.write(line);
                    floatsWriter.newLine();
                } else {
                    stringsWriter.write(line);
                    stringsWriter.newLine();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
