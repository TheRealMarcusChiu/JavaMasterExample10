package junit.suite_1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by marcus.chiu on 9/22/16.
 */
public class TestJunit1 {
    String message = "robert";

    public String getMessage(String message) {
        return message;
    }

    @Test
    public void testOne() {
        System.out.println("Inside testOne()");
        assertEquals(message, getMessage(message));
    }
}
