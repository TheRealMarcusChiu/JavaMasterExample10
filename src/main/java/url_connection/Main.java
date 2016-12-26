package url_connection;

import org.junit.Test;

public class Main {

    private IURLConnectionExample urlConnectionExample = new URLConnectionExample();

    @Test
    public void execute() {
        String responseString = urlConnectionExample.executeURLConnection("https://yahoo.com/");
        System.out.println(responseString);
    }
}
