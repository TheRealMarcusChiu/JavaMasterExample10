package test.junit.suite_2;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * Created by marcus.chiu on 9/23/16.
 */
public class AssertExample {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("AssertExample @BeforeClass: beforeClass()");
    }

    @Before
    public void setUp() {
        System.out.println("AssertExample @Before: setUp");
    }

    @Test
    public void assertTest() {
        System.out.println("AssertExample @Test");

        int num = 5;
        String str = "Hello, World!";
        String str2 = null;

        //check for null
        assertNull(str2);
        assertNotNull(str);

        //assertEquals("expected", "actual");
        assertEquals("Hello, World!", str);
        assertNotEquals("hello, world", str);

        //check for boolean condition
        assertFalse(num > 6);
        assertTrue(num < 10);

        //fails a test with no notification
        //fail();
    }

    @After
    public void tearDown() {
        System.out.println("AssertExample @After: tearDown");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("AssertExample @AfterClass: afterClass()");
    }
}
