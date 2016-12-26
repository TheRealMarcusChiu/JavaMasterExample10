package url_connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionExample implements IURLConnectionExample {

    @Override
    public String executeURLConnection(String targetURL) {
        String responseString = "";

        try {
            URL yahoo = new URL(targetURL);
            URLConnection yc = yahoo.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));

            String inputLine;
            StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
                response.append(inputLine);
                response.append('\r');
            }
            in.close();

            responseString = response.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return responseString;
    }

}
