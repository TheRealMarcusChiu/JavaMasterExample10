package generics.e_bounded;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ExampleBoundedGenericsTest {

    @Test
    public void testExtends() {
        Example example = new Example();
        ExampleBoundedGenerics exampleBoundedGenerics = new ExampleBoundedGenerics();

        // example is an object that implements Serializable and Runnable
        exampleBoundedGenerics.test1(example);

        // below does not work, because it does not satisfy the bounded types
//        exampleBoundedGenerics.test1("String");
//        exampleBoundedGenerics.test1(1);
    }

    @Test
    public void testSuper() {
        ExampleBoundedGenerics exampleBoundedGenerics = new ExampleBoundedGenerics();

        // listInteger<Integer> Integer satisfies the type parameter because it is a superclass of Integer
        List<Integer> listInteger = new ArrayList<>();
        exampleBoundedGenerics.test2(listInteger);

        // would not work, because it does not satisfy the bounded types
//        List<String> listString = new ArrayList<>();
//        exampleBoundedGenerics.test2(listString);
    }
}
