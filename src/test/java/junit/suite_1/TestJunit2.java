package junit.suite_1;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by marcus.chiu on 9/22/16.
 */
public class TestJunit2 {
    String message = "Robert";

    @Test
    public void testTwo() {
        System.out.println("Inside testTwo()");
        assertEquals(message, message);
    }
}
