package generics.e_bounded;

import java.io.Serializable;
import java.util.Collection;

public class ExampleBoundedGenerics {

    /**
     * The extends keyword restricts the type parameter to
     * be a subclass of some other class or to implement one
     * or more interfaces.
     *
     * The bounds are not limited to single constraints and could be
     * combined using the & operator. There could be multiple interfaces
     * specified but only single class is allowed. The combination
     * of class and interfaces is also possible
     *
     * @param generic - can only take in an object that implements Serializable
     *                and Runnable interfaces
     * @param <T>
     */
    public<T extends Runnable & Serializable> void test1(T generic) {
        generic.run();
    }

    /**
     * In contrast to extends, the super keyword restricts the
     * type parameter to be a superclass of some other class.
     * @param objects
     */
    public void test2(final Collection<? super Integer> objects) {
        // Some implementation here
    }

    /**
     * Method store requires its type parameter T to implement the Serializable
     * interface in order for the method to perform the desired action. It is also
     * possible to use other type parameter as a bound for extends keyword.
     * @param initial
     * @param next
     * @param <T>
     * @param <J>
     */
    public<T, J extends T> void test2(final T initial, final J next) {
        // Some implementation here
    }
}
