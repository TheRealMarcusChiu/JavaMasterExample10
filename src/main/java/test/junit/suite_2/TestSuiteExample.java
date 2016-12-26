package test.junit.suite_2;

import junit.framework.TestResult;
import junit.framework.TestSuite;

/**
 * Created by marcus.chiu on 9/23/16.
 */
public class TestSuiteExample {
    public void main () {
        System.out.println("TestSuiteExample started");

        //add the tests into the suite
        TestSuite suite = new TestSuite(AssertExample.class, TestCaseExample.class, TestResultExample.class);
        TestResult result = new TestResult();
        suite.run(result);
        System.out.println("TestSuiteExample number of test cases: " + result.runCount());

        System.out.println("TestSuiteExample ended");
    }
}
