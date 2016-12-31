package memcached;

import net.spy.memcached.MemcachedClient;

import java.net.InetSocketAddress;

public class a_SimpleClient {

    // make sure to start memcached server locally on default port 11211
    public static void main(String args[]) {
        try{
            // Connecting to Memcached server on localhost on default port 11211
            MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));

            // Shutdowns the memcached client
            mcc.shutdown();

        }catch(Exception ex){
            System.out.println( ex.getMessage() );
        }
    }
}
