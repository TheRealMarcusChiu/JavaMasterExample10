package native_java.network.url.a_url_processing;

import java.io.IOException;
import java.net.URL;

public class UrlDemo {

    public static void main(String [] args) {
        try {
            URL url = new URL("https://www.amrood.com/index.htm?language=en#j2se");

            System.out.println("URL is: " + url.toString());
            System.out.println("protocol is: " + url.getProtocol());
            System.out.println("authority is: " + url.getAuthority());
            System.out.println("file name is: " + url.getFile());
            System.out.println("host is: " + url.getHost());
            System.out.println("path is: " + url.getPath());
            System.out.println("port is: " + url.getPort());
            System.out.println("default port is: " + url.getDefaultPort());
            System.out.println("query is: " + url.getQuery());
            System.out.println("ref is: " + url.getRef());

            //public URLConnection openConnection() throws IOException
            //Opens a connection to the URL, allowing a client to communicate with the resource.
            // url.openConnection();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
