package third.party.memcached;

import net.spy.memcached.MemcachedClient;

import java.net.InetSocketAddress;
import java.util.concurrent.Future;

public class b_Set {

    // make sure to start memcached server locally on default port 11211
    public static void main(String args[]) {
        try{
            // Connecting to Memcached server on localhost on default port 11211
            MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));

            // now set data into memcached server
            // key, expiration seconds, value
            String key = "tutorialspoint";
            Integer expireInSeconds = 10;
            String value = "Free Education";
            Future fo = mcc.set(key, expireInSeconds, value);

            // print status of set method
            System.out.println("set status: " + fo.get());

            // retrieve and check the value from cache
            System.out.println("tutorialspoint value in cache: " + mcc.get(key));

            // Shutdowns the memcached client
            mcc.shutdown();

        }catch(Exception ex){
            System.out.println( ex.getMessage() );
        }
    }

}
