package junit.suite_1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//Junit Suite Test
@RunWith(Suite.class)
@Suite.SuiteClasses(
    { TestJunit1.class, TestJunit2.class }
)
public class JunitTestSuite {
}
