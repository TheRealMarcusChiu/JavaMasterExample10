package junit.exception;

import org.junit.Test;

/**
 * Created by marcus.chiu on 9/23/16.
 */
public class TestException {

    @Test(expected = ArithmeticException.class)
    public void testPrintMessage() {
        throw new ArithmeticException();
    }
}
