package file_io.io;

import java.io.*;

public class InputOutputStreamReaderWriter {

    public static void main(String[] args) {
        String workingDirectory = System.getProperty("user.dir");
        String resourceFolder = workingDirectory + "/src/main/resources/";

        // images not working because Reader/Writer are Character Streams
        String targetPath = resourceFolder + "-.txt";
        String destinationPath = resourceFolder + "two.txt";
        System.out.println("target: " + targetPath);
        System.out.println("dest: " + destinationPath);

        try (InputStream inputStream = new FileInputStream(targetPath);
             OutputStream outputStream = new FileOutputStream(destinationPath)) {

            InputOutputStreamReaderWriter inputOutputStreamReaderWriter = new InputOutputStreamReaderWriter();
            inputOutputStreamReaderWriter.copy(inputStream, outputStream);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reader/Writer performs input and output for 16-bit unicode
     * @param inputStream
     * @param outputStream
     */
    public void copy(InputStream inputStream, OutputStream outputStream) {
        try (InputStreamReader in = new InputStreamReader(inputStream);
             OutputStreamWriter out = new OutputStreamWriter(outputStream)){

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
