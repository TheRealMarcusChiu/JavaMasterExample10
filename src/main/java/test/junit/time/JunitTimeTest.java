package test.junit.time;

import org.junit.Test;

import static java.lang.Thread.sleep;

/**
 * Created by marcus.chiu on 9/23/16.
 */
public class JunitTimeTest {

    @Test(timeout = 2000)
    public void testTimeSuccess() {
        try {
            sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 1000)
    public void testTimeFailure() {
        try {
            sleep(2000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
