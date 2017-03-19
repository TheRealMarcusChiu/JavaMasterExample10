package generics.b_class;

import org.junit.Test;

public class ExampleGenericsTest {

    @Test
    public void testToString() {
        String string;

        // Integer example
        ExampleGenerics<Integer> exampleGenericsInteger = new ExampleGenerics<>();
        string = exampleGenericsInteger.genericToString(123456789);
        System.out.println(string);

        // String example
        ExampleGenerics<String> exampleGenericsString = new ExampleGenerics<>();
        string = exampleGenericsString.genericToString("Hello, World!");
        System.out.println(string);
    }
}
