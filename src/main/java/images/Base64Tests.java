package images;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

import java.io.*;

/**
 * Java8 has finally got it own Base64 encoder/decoder
 * this is
 */
public class Base64Tests {

    public static String encodeFileToBase64Binary(File file) {

        String string = null;

        try (FileInputStream fileInputStreamReader = new FileInputStream(file)) {
            byte[] bytes = new byte[(int)file.length()];
            fileInputStreamReader.read(bytes);
            string = new String(Base64.encodeBase64(bytes), "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return string;
    }

    public static File decodeBase64BinaryToFile(String prefix, String suffix, String string) throws IOException {

        File file = File.createTempFile(prefix, suffix);
        file.deleteOnExit();

        byte[] data = Base64.decodeBase64(string);
        try (OutputStream stream = new FileOutputStream(file)) {
            stream.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return file;
    }

    @Test
    public void test() throws Exception {
        // get image file from resource directory
        ClassLoader classLoader = getClass().getClassLoader();
        File image = new File(classLoader.getResource("girl.jpg").getFile());

        // encode image file as Base64 String
        String base64 = encodeFileToBase64Binary(image);
        System.out.println("Base64 String: " + base64);

        // decode Base64 String into image file
        image = decodeBase64BinaryToFile("girl-copy", "jpg", base64);

        // encode image file as Base64 String
        base64 = encodeFileToBase64Binary(image);
        System.out.println("Base64 String: " + base64);
    }
}
