package memcached;

import net.spy.memcached.CASValue;
import net.spy.memcached.MemcachedClient;

import java.net.InetSocketAddress;
import java.util.concurrent.Future;

public class i_GetCAS {

    public static void main(String[] args) {
        try{
            // Connecting to Memcached server on localhost
            MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
            System.out.println("Connection to server sucessful.");

            // add data to memcached server
            Future fo = mcc.set("tutorialspoint", 900, "Free Education");

            // print status of set method
            System.out.println("set status:" + fo.get());

            // retrieve value stored for tutorialspoint from cache
            System.out.println("tutorialspoint value in cache - " + mcc.get("tutorialspoint"));

            // obtain CAS token value using gets method
            CASValue casValue = mcc.gets("tutorialspoint");

            // display CAS token value
            System.out.println("CAS value in cache - " + casValue);

            // Shutdowns the memcached client
            mcc.shutdown();

        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
