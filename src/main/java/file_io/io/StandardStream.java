package file_io.io;

import java.io.IOException;
import java.io.InputStreamReader;

public class StandardStream {

    public static void main(String args[]) {
        try (InputStreamReader cin = new InputStreamReader(System.in)){
            System.err.println("Enter characters, 'q' to quit.");

            char c;
            do {
                c = (char) cin.read();
                System.out.print(c);
            } while(c != 'q');

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
