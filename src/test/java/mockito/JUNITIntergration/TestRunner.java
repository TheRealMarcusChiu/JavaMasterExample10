package mockito.JUNITIntergration;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Created by marcus.chiu on 9/23/16.
 */
public class TestRunner {
    public void main () {
        //Result result = JUnitCore.runClasses(MathApplicationTester.class);
        Result result = JUnitCore.runClasses(MathApplicationTester2.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }
}
