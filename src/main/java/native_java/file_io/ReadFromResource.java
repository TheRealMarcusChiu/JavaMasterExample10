package native_java.file_io;

import org.junit.Test;

import java.io.File;

public class ReadFromResource {

    @Test
    public void readFromResource() {
        ReadFromResource readFromResource = new ReadFromResource();
        FileParse fileParse = new FileParse();

        String path = "-.txt";
        File file = readFromResource.getFile(path);

        String string = fileParse.scannerWay(file);
        System.out.println(string);
    }

    /**
     * Reads from the Resource Folder based on the String path
     * @param path - root from resource folder
     * @return
     */
    public File getFile(String path) {
        ClassLoader classLoader = getClass().getClassLoader();
        return new File(classLoader.getResource(path).getFile());
    }

}
