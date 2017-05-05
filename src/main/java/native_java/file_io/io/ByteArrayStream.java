package native_java.file_io.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayStream {

    public static void main(String[] args) {
        byte byteArray [] = null;

        // Output Write
        try (ByteArrayOutputStream bOutput = new ByteArrayOutputStream(12)) {
            while( bOutput.size() < 10 ) {
                // Gets the inputs from the user
                bOutput.write("hello".getBytes());
            }
            byteArray = bOutput.toByteArray();
            System.out.println("Print the content");

            for(int x = 0 ; x < byteArray.length; x++) {
                // printing the characters
                System.out.print((char)byteArray[x]  + " ");
            }
            System.out.println("   ");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Input Read
        try (ByteArrayInputStream bInput = new ByteArrayInputStream(byteArray)) {
            System.out.println("Converting characters to Upper case " );

            for(int y = 0 ; y < 1; y++) {
                int c;
                while(( c = bInput.read())!= -1) {
                    System.out.println(Character.toUpperCase((char)c));
                }
                bInput.reset();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
