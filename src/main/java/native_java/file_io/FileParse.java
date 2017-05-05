package native_java.file_io;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileParse {

    /**
     * Scans File and returns a String format of the file
     * @param file
     * @return
     */
    public String scannerWay(File file) {
        String string = "";

        try (Scanner scanner = new Scanner(file)) {

            StringBuilder result = new StringBuilder("");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();

            string = result.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return string;
    }
}
