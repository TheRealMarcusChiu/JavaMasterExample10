package memcached;

import net.spy.memcached.MemcachedClient;

import java.net.InetSocketAddress;
import java.util.concurrent.Future;

public class j_Delete {

    public static void main(String[] args) {
        try {
            // Connecting to Memcached server on localhost
            MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
            System.out.println("Connection to server sucessful.");

            // add data to memcached server
            Future fo = mcc.set("tutorialspoint", 900, "World's largest online tutorials library");

            // print status of set method
            System.out.println("set status:" + fo.get());

            // retrieve and check the value from cache
            System.out.println("tutorialspoint value in cache - " + mcc.get("tutorialspoint"));

            // try to add data with existing key
            fo = mcc.delete("tutorialspoint");

            // print status of delete method
            System.out.println("delete status:" + fo.get());

            // retrieve and check the value from cache
            System.out.println("tutorialspoint value in cache - " + mcc.get("codingground"));

            // Shutdowns the memcached client
            mcc.shutdown();

        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
