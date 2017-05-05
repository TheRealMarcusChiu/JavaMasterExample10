package native_java.generics.c_method;

import org.junit.Test;

import java.util.ArrayList;

public class ExampleGenericsTest {

    @Test
    public void testConcreteMethod() {
        ExampleGenerics exampleGenerics = new ExampleGenerics();
        exampleGenerics.performAction("Hello, World!");
        exampleGenerics.performAction(1);
    }

    @Test
    public void testStaticMethod() {
        ExampleGenerics.printCollectionSize(new ArrayList<>());
    }
}
