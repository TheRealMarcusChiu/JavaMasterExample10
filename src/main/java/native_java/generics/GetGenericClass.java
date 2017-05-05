package native_java.generics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GetGenericClass {

    /**
     * As you already know from the section Limitation of generics, it is
     * not possible to get the class of the generic type parameter. One simple
     * trick to work-around that is to require additional argument to be passed,
     * Class< T >, in places where it is necessary to know the class of
     * the type parameter T.
     * @param action
     * @param clazz
     * @param <T>
     */
    public< T > void genericClass(final T action, final Class<T> clazz) {
        // Some implementation here
        System.out.println("class name: " + clazz.toString());
    }

    @Test
    public void testGenericClass() {
        GetGenericClass getGenericClass = new GetGenericClass();

        List<Integer> listInteger = new ArrayList<>();
        getGenericClass.genericClass(listInteger, List.class);

        String string = "Hello, World!";
        getGenericClass.genericClass(string, String.class);

        // would not compile because types are different between the 2 parameters
        // getGenericClass.genericClass(string, List.class);
    }
}
