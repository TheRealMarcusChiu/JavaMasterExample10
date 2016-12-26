package test.junit.exception;

import org.junit.Test;

/**
 * Created by marcus.chiu on 9/23/16.
 */
public class TestException {
    String message = "Robert";

    @Test(expected = ArithmeticException.class)
    public void testPrintMessage() {
        System.out.println("Inside testPrintMessage()");
    }

    @Test
    public void testSalutationMessage() {
        System.out.println("Inside testSalutationMessage()");
        message = "Hi!" + "Robert";
    }
}
