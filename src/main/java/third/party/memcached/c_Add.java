package third.party.memcached;

import net.spy.memcached.MemcachedClient;

import java.net.InetSocketAddress;
import java.util.concurrent.Future;

public class c_Add {

    public static void main(String[] args) {

        try{

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
            fo = mcc.add("tutorialspoint", 900, "memcached");

            // print status of set method
            System.out.println("add status:" + fo.get());

            // adding a new key to memcached server
            fo = mcc.add("codingground", 900, "All Free Compilers");

            // print status of set method
            System.out.println("add status:" + fo.get());

            // retrieve and check the value from cache
            System.out.println("codingground value in cache - " + mcc.get("codingground"));

            // Shutdowns the memcached client
            mcc.shutdown();

        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
