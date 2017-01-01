package memcached;

import net.spy.memcached.MemcachedClient;

import java.net.InetSocketAddress;
import java.util.concurrent.Future;

public class e_Append {

    public static void main(String[] args) {
        try {
            // Connecting to Memcached server on localhost
            MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
            System.out.println("Connection to server successful.");

            // add data to memcached server
            Future fo = mcc.set("tutorialspoint", 900, "Free Education");

            // print status of set method
            System.out.println("set status:" + fo.get());

            // retrieve and check the value from cache
            System.out.println("tutorialspoint value in cache - " + mcc.get("tutorialspoint"));

            // try to add data with existing key
            fo = mcc.append("tutorialspoint", " for All");

            // print status of set method
            System.out.println("append status:" + fo.get());

            // retrieve and check the value from cache
            System.out.println("tutorialspoint value in cache - " + mcc.get("tutorialspoint"));

            // Shutdowns the memcached client
            mcc.shutdown();

        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
