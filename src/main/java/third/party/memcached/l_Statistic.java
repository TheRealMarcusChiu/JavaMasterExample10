package third.party.memcached;

import net.spy.memcached.MemcachedClient;

import java.net.InetSocketAddress;

public class l_Statistic {

    public static void main(String[] args) {
        try {
            // Connecting to Memcached server on localhost
            MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));

            System.out.println("Connection to server successful.");

            // display statistics about memcached
            System.out.println("Memcached Statistics - " + mcc.getStats());

            // Shutdowns the memcached client
            mcc.shutdown();

        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
