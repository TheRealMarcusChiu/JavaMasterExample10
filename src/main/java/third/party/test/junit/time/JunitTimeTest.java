package third.party.test.junit.time;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.model.TestTimedOutException;

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

    /**
     * this is expected to fail
     */
    @Test(timeout = 1000)
    @Ignore
    public void testTimeFailure() {
        try {
            sleep(2000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
