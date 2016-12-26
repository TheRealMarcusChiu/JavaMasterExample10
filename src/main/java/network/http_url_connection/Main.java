package network.http_url_connection;

import org.junit.Test;

public class Main {

    IHttpURLConnectionExample httpURLConnectionExample = new HttpURLConnectionExample();

    String responseString;

    @Test
    public void get() {
        responseString = httpURLConnectionExample.executeGet("http://www.google.com/search?q=mkyong");
        System.out.println(responseString);
    }

    @Test
    public void post() {
        String targetURL = "https://httpbin.org/post";
        String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";
        responseString = httpURLConnectionExample.executePost(targetURL, urlParameters);
        System.out.println(responseString);
    }

    @Test
    public void put() {
        String targetURL = "https://httpbin.org/put";
        String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";
        responseString = httpURLConnectionExample.executePut(targetURL, urlParameters);
        System.out.println(responseString);
    }

    @Test
    public void delete() {
        String targetURL = "https://httpbin.org/delete";
        String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";
        responseString = httpURLConnectionExample.executeDelete(targetURL, urlParameters);
        System.out.println(responseString);
    }

}
