package file_io.io;

import java.io.*;

public class DataStream {

    public static void main(String[] args) {
        String workingDirectory = System.getProperty("user.dir");
        String resourceFolder = workingDirectory + "/src/main/resources/";

        String targetPath = resourceFolder + "-.txt";
        String destinationPath = resourceFolder + "two.txt";
        System.out.println("target: " + targetPath);
        System.out.println("dest: " + destinationPath);

        try (InputStream inputStream = new FileInputStream(targetPath);
             OutputStream outputStream = new FileOutputStream(destinationPath)) {

            DataStream dataStream = new DataStream();
            dataStream.copy(inputStream, outputStream);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void copy(InputStream inputStream, OutputStream outputStream) {

        try (DataInputStream dataIn = new DataInputStream(inputStream);
             DataOutputStream dataOut = new DataOutputStream(outputStream)) {

            while(dataIn.available() > 0) {
                // read/write as UTF-8
//                String k = dataIn.readUTF();
//                dataOut.writeUTF(k);

                // read/write as UTF-8
                byte b = dataIn.readByte();
                dataOut.writeByte(b);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
