package network.http_url_connection;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class HttpURLConnectionExample implements IHttpURLConnectionExample {

    /**
     *
     * @param targetURL - example "http://www.google.com/search?q=mkyong"
     * @return
     */
    @Override
    public String executeGet(String targetURL) {
        String responseString = "";

        try {
            URL obj = new URL(targetURL);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

            // optional default is GET
            connection.setRequestMethod("GET");

            //add request header
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Content-Length", Integer.toString(0));
            connection.setRequestProperty("Content-Language", "en-US");
            connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

            connection.setUseCaches(false);
            connection.setDoOutput(true);

            // Response Code
            int responseCode = connection.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + targetURL);
            System.out.println("Response Code : " + responseCode);

            // Get Response
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            responseString = response.toString();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return responseString;
    }

    @Override
    public String executePost(String targetURL, String parameters) {
        String responseString = "";

        HttpURLConnection connection = null;
        try {
            URL obj = new URL(targetURL);
            connection = (HttpURLConnection) obj.openConnection();

            // add request header
            connection.setRequestMethod("POST");

            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Content-Length", Integer.toString(parameters.getBytes().length));
            connection.setRequestProperty("Content-Language", "en-US");
            connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

            connection.setUseCaches(false);
            connection.setDoOutput(true);

            // Send post request
            connection.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes(parameters);
            wr.flush();
            wr.close();

            // Response Code
            int responseCode = connection.getResponseCode();
            System.out.println("\nSending 'POST' request to URL : " + targetURL);
            System.out.println("Post parameters : " + parameters);
            System.out.println("Response Code : " + responseCode);

            // Get Response
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
                response.append("\n");
            }
            in.close();

            responseString = response.toString();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }

        return responseString;
    }

    @Override
    public String executePut(String targetURL, String parameters) {
        String responseString = "";

        HttpURLConnection connection = null;
        try {
            URL obj = new URL(targetURL);
            connection = (HttpURLConnection) obj.openConnection();

            // add request header
            connection.setRequestMethod("PUT");

            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Content-Length", Integer.toString(parameters.getBytes().length));
            connection.setRequestProperty("Content-Language", "en-US");
            connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

            connection.setUseCaches(false);
            connection.setDoOutput(true);

            // Send post request
            connection.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes(parameters);
            wr.flush();
            wr.close();

            // Response Code
            int responseCode = connection.getResponseCode();
            System.out.println("\nSending 'PUT' request to URL : " + targetURL);
            System.out.println("Put parameters : " + parameters);
            System.out.println("Response Code : " + responseCode);

            // Get Response
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
                response.append("\n");
            }
            in.close();

            responseString = response.toString();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }

        return responseString;
    }

    @Override
    public String executeDelete(String targetURL, String parameters) {
        String responseString = "";

        HttpURLConnection connection = null;
        try {
            URL obj = new URL(targetURL);
            connection = (HttpURLConnection) obj.openConnection();

            // add request header
            connection.setRequestMethod("DELETE");

            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Content-Length", Integer.toString(parameters.getBytes().length));
            connection.setRequestProperty("Content-Language", "en-US");
            connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

            connection.setUseCaches(false);
            connection.setDoOutput(true);

            // Send post request
            connection.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes(parameters);
            wr.flush();
            wr.close();

            // Response Code
            int responseCode = connection.getResponseCode();
            System.out.println("\nSending 'DELETE' request to URL : " + targetURL);
            System.out.println("Delete parameters : " + parameters);
            System.out.println("Response Code : " + responseCode);

            // Get Response
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
                response.append("\n");
            }
            in.close();

            responseString = response.toString();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }

        return responseString;
    }

}
