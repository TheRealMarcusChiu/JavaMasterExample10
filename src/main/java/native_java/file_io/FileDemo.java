package native_java.file_io;

import org.junit.Test;

import java.io.File;

public class FileDemo {

    @Test
    public void fileDemo() {
        FileDemo fileDemo = new FileDemo();

        String workingDirectory = System.getProperty("user.dir");
        String resourceFolder = workingDirectory + "/src/main/resources/";
        String targetPath = resourceFolder + "-.txt";

        fileDemo.fileDemo(targetPath);
    }

    @Test
    public void listDirectories() {
        FileDemo fileDemo = new FileDemo();

        String workingDirectory = System.getProperty("user.dir");
        String resourceFolder = workingDirectory + "/src/main/resources/";

        fileDemo.listDirectories(resourceFolder);
    }

    public void fileDemo(String targetPath) {
        try {
            File f = new File(targetPath);

            boolean bool = f.canExecute();
            System.out.println("executable: "+ bool);

            String a = f.getAbsolutePath();
            System.out.println("absolute  path: " + a);

            a = f.getCanonicalPath();
            System.out.println("canonical path: " + a);

            long l = f.length();
            System.out.println("length: " + l);

            bool = f.canRead();
            System.out.println("readable: " + bool);

            bool = f.canWrite();
            System.out.println("writable: " + bool);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void listDirectories(String targetPath) {
        String[] paths;

        try {
            File file = new File(targetPath);

            // array of files and directories
            paths = file.list();

            // for each name in the path array
            for(String path:paths) {
                System.out.println(path);
            }

        }catch(Exception e) {
            e.printStackTrace();
        }
    }

}
