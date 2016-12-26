package test.junit.suite_2;

import junit.framework.TestCase;
import org.junit.*;

/**
 * Created by marcus.chiu on 9/23/16.
 */
public class TestCaseExample extends TestCase {
    protected double fValue1;
    protected double fValue2;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("TestCaseExample @BeforeClass: beforeClass()");
    }

    @Before
    public void setUp() {
        System.out.println("TestCaseExample @Before: setUp()");
        fValue1 = 2.0;
        fValue2 = 3.0;
    }

    @Test
    public void testAdd() {
        System.out.println("TestCaseExample @Test");

        //count the number of test cases
        System.out.println("TestCaseExample No of Test Case = "+ this.countTestCases());

        //test getName
        String name = this.getName();
        System.out.println("TestCaseExample Test Case Name = "+ name);

        //test setName
        this.setName("testNewAdd");
        String newName = this.getName();
        System.out.println("TestCaseExample Updated Test Case Name = "+ newName);

        //toString
        System.out.println("TestCaseExample String representation of TestCase = " + toString());
    }

    //tearDown used to close the connection or clean up activities
    @After
    public void tearDown(  ) {
        System.out.println("TestCaseExample @After: tearDown()");
    }

    @AfterClass
    public static void afterClass(  ) {
        System.out.println("TestCaseExample @AfterClass: afterClass()");
    }
}
