package junit.suite_2;

import junit.framework.AssertionFailedError;
import junit.framework.TestResult;
import org.junit.*;

/**
 * Created by marcus.chiu on 9/23/16.
 */
public class TestResultExample extends TestResult {
    // add the error
    public synchronized void addError(Test test, Throwable t) {
        super.addError((junit.framework.Test) test, t);
    }

    // add the failure
    public synchronized void addFailure(Test test, AssertionFailedError t) {
        super.addFailure((junit.framework.Test) test, t);
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("TestResultExample @BeforeClass: beforeClass()");
    }

    @Before
    public void setUp() {
        System.out.println("TestResultExample @Before: setUp");
    }

    @Test
    public void testAdd() {
        // add any test
        System.out.println("TestResultExample @Test");
    }

    @After
    public void tearDown() {
        System.out.println("TestResultExample @After: tearDown");
    }

    // Marks that the test run should stop.
    public synchronized void stop() {
        //stop the test here
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("TestResultExample @AfterClass: afterClass()");
    }
}
