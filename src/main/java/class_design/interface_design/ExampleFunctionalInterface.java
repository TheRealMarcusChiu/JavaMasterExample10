package class_design.interface_design;

/**
 * The functional interfaces are a different story and they are proven
 * to be very helpful add-on to the language. Basically, the functional
 * interface is the interface with just a single abstract method declared in it.
 * The Runnable interface from Java standard library is a good example of this concept:
 */
@FunctionalInterface
public interface ExampleFunctionalInterface {
    // public abstract
    void exampleFunction();
}
