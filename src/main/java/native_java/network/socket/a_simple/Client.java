package native_java.network.socket.a_simple;

import java.io.*;
import java.net.Socket;

public class Client {

    public static String host = "localhost";
    public static int port = 8080;

    public static void main(String [] args) {

        try {
            System.out.println("Connecting to " + host + " on port " + port);
            Socket client = new Socket(host, port);

            System.out.println("Just connected to " + client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);

            out.writeUTF("Hello from " + client.getLocalSocketAddress());
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);

            System.out.println("Server says " + in.readUTF());
            client.close();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
