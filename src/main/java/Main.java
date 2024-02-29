import java.io.*;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final File INPUT_FILE = Path.of("src", "in", "test.txt").toFile();
        final File OUTPUT_FILE_FOR_FLOATS = Path.of("src", "out", "floats.txt").toFile();
        final File OUTPUT_FILE_FOR_INTEGERS = Path.of("src", "out", "integers.txt").toFile();
        final File OUTPUT_FILE_FOR_STRINGS = Path.of("src", "out", "strings.txt").toFile();


        try (Scanner scanner = new Scanner(INPUT_FILE);
             BufferedWriter floatsWriter = new BufferedWriter(new FileWriter(OUTPUT_FILE_FOR_FLOATS));
             BufferedWriter integersWriter = new BufferedWriter(new FileWriter(OUTPUT_FILE_FOR_INTEGERS));
             BufferedWriter stringsWriter = new BufferedWriter(new FileWriter(OUTPUT_FILE_FOR_STRINGS))) {

            while (scanner.hasNext()) {
                if(scanner.hasNextFloat()) {
                    floatsWriter.write(Float.toString(scanner.nextFloat()));
                    floatsWriter.newLine();
                } else if (scanner.hasNextInt()) {
                    integersWriter.write(Integer.toString(scanner.nextInt()));
                }
                else {
                    stringsWriter.write(scanner.next());
                    stringsWriter.newLine();
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
