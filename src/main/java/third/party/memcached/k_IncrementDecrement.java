package third.party.memcached;

import net.spy.memcached.MemcachedClient;

import java.net.InetSocketAddress;
import java.util.concurrent.Future;

public class k_IncrementDecrement {

    public static void main(String[] args) {
        try {
            // Connecting to Memcached server on localhost
            MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
            System.out.println("Connection to server sucessful.");

            // add numerical data to memcached server
            Future fo = mcc.set("number", 900, "1000");

            // print status of set method
            System.out.println("set status:" + fo.get());

            // retrieve and check the value from cache
            System.out.println("value in cache - " + mcc.get("number"));

            // increment and check the value from cache
            System.out.println("value in cache after increment - " + mcc.incr("number", 111));

            // decrement and check the value from cache
            System.out.println("value in cache after decrement - " + mcc.decr("number", 112));

            // Shutdowns the memcached client
            mcc.shutdown();

        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
