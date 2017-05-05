package third.party.test.junit.time;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Created by marcus.chiu on 9/23/16.
 */
public class TestRunner {
    public static void main(String args[]) {
        Result result = JUnitCore.runClasses(JunitTimeTest.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }
}
