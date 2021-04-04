package native_java.concurrent.exectorservice;

import java.util.concurrent.TimeUnit;

public class DefaultRunnable implements Runnable {
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            System.out.println("INTERRUPTED");
            e.printStackTrace();
        }
    }
}
