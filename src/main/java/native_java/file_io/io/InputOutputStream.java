package native_java.file_io.io;

import java.io.*;

public class InputOutputStream {

    public static void main(String[] args) {
        String workingDirectory = System.getProperty("user.dir");
        String resourceFolder = workingDirectory + "/src/main/resources/";

        String targetPath = resourceFolder + "test.txt";
        System.out.println("target: " + targetPath);

        try (OutputStream out = new FileOutputStream(targetPath);
             InputStream in = new FileInputStream(targetPath)){

            byte byteArray[] = "hello".getBytes();
            for(byte b : byteArray) {
                out.write(b);
            }

            int size = in.available();
            for(int i = 0; i < size; i++) {
                System.out.print((char)in.read() + "  ");
            }

        }catch(IOException e) {
            e.printStackTrace();
        }
    }

}
