package file_io.io;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriter {

    public static void main(String[] args) {
        String workingDirectory = System.getProperty("user.dir");
        String resourceFolder = workingDirectory + "/src/main/resources/";

        // images not working because FileReader/Writer are Character Streams
//        String targetPath = resourceFolder + "JesusChrist.jpg";
//        String destinationPath = resourceFolder + "JesusChrist_copy.jpg";
        String targetPath = resourceFolder + "-.txt";
        String destinationPath = resourceFolder + "two.txt";
        System.out.println("target: " + targetPath);
        System.out.println("dest: " + destinationPath);

        FileReaderWriter fileReaderWriter = new FileReaderWriter();
        fileReaderWriter.copy(targetPath, destinationPath);
    }

    /**
     * FileReader/Writer performs input and output for 16-bit unicode
     * FileReader extends InputStreamReader
     * FileWriter extends OutputStreamWriter
     * @param targetPath
     * @param destinationPath
     */
    public void copy(String targetPath, String destinationPath) {
        try (FileReader in = new FileReader(targetPath);
             FileWriter out = new FileWriter(destinationPath)){

            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
