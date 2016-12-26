package file_io.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStream {

    public static void main(String[] args) {
        String workingDirectory = System.getProperty("user.dir");
        String resourceFolder = workingDirectory + "/src/main/resources/";

        String targetPath = resourceFolder + "JesusChrist.jpg";
        String destinationPath = resourceFolder + "God.jpg";
        System.out.println("target: " + targetPath);
        System.out.println("dest: " + destinationPath);

        FileStream fileStream = new FileStream();
        fileStream.copy(targetPath, destinationPath);
    }

    public void copy(String targetPath, String destinationPath) {
        try (FileInputStream in = new FileInputStream(targetPath);
             FileOutputStream out = new FileOutputStream(destinationPath)){

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
