package native_java.java_8.base64;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * There are 3 types of Base64 encoding:
 *
 * Simple − Output is mapped to a set of characters lying in A-Za-z0-9+/.
 *          The encoder does not add any line feed in output, and the decoder rejects any character other than A-Za-z0-9+/.
 *
 * URL    − Output is mapped to set of characters lying in A-Za-z0-9+_. Output is URL and filename safe.
 *
 * MIME   − Output is mapped to MIME friendly format. Output is represented in lines of no more than 76 characters each,
 *          and uses a carriage return '\r' followed by a linefeed '\n' as the line separator.
 *          No line separator is present to the end of the encoded output.
 */
public class Main {

    public static void main(String args[]) {
        try {

            String originalString = "TutorialsPoint?java8?for marcus chiu and he will do something about this phenomena. right?";
            System.out.println("Original String: " + originalString);

            byte[] originalBytes = originalString.getBytes("utf-8");

            System.out.println("\nENCODE");

            // BASIC encoder
            String base64basicEncodedString = Base64.getEncoder().encodeToString(originalBytes);
            System.out.println("Base64 Encoded String (Basic) : " + base64basicEncodedString);

            // URL encoder
            String base64urlEncodedString = Base64.getUrlEncoder().encodeToString(originalBytes);
            System.out.println("Base64 Encoded String (URL)   : " + base64urlEncodedString);

            // MIME encoder
            String base64mimeEncodedString = Base64.getMimeEncoder().encodeToString(originalBytes);
            System.out.println("Base64 Encoded String (MIME)  : " + base64mimeEncodedString);


            System.out.println("\nDECODE");

            // BASIC decoder
            byte[] base64basicDecodedBytes = Base64.getDecoder().decode(base64basicEncodedString);
            System.out.println("Base64 Decoded String (Basic) : " + new String(base64basicDecodedBytes, "utf-8"));

            // URL decoder
            byte[] base64urlDecodedBytes = Base64.getUrlDecoder().decode(base64urlEncodedString);
            System.out.println("Base64 Decoded String (URL)   : " + new String(base64urlDecodedBytes, "utf-8"));

            // MIME decoder
            byte[] base64mimeDecodedBytes = Base64.getMimeDecoder().decode(base64basicEncodedString);
            System.out.println("Base64 Decoded String (MIME)  : " + new String(base64mimeDecodedBytes, "utf-8"));


        } catch (UnsupportedEncodingException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
}
