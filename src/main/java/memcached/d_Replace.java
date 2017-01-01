package memcached;

import net.spy.memcached.MemcachedClient;

import java.net.InetSocketAddress;
import java.util.concurrent.Future;

public class d_Replace {

    public static void main(String[] args) {
        try {
            //Connecting to Memcached server on localhost
            MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
            System.out.println("Connection to server successful.");

            // First add a key and value
            Future fo = mcc.set("tutorialspoint", 900, "Free Education");

            // print status of add method
            System.out.println("add status:" + fo.get());

            // retrieve and check the value from cache
            System.out.println("tutorialspoint value in cache - " + mcc.get("tutorialspoint"));

            // adding a new key to memcached server
            fo = mcc.replace("tutorialspoint", 900, "Largest Tutorials' Library");

            // print status of set method
            System.out.println("replace status:" + fo.get());

            // retrieve and check the value from cache
            System.out.println("tutorialspoint value in cache - " + mcc.get("tutorialspoint"));

            // Shutdowns the memcached client
            mcc.shutdown();

        }catch(Exception ex){
            System.out.println( ex.getMessage() );
        }
    }
}
