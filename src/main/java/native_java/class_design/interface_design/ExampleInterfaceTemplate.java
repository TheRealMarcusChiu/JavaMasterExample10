package native_java.class_design.interface_design;

/**
 * In object-oriented programming, the concept of interfaces
 * forms the basics of contract-driven (or contract-based)
 * development. In a nutshell, interfaces define the set of
 * methods (contract) and every class which claims to support
 * this particular interface must provide the implementation
 * of those methods: a pretty simple, but powerful idea.
 */
public interface ExampleInterfaceTemplate {

    // implicitly public static and final
    String CONSTANT = "CONSTANT";

    // implicitly public
    enum InnerEnum {
        E1, E2;
    }

    // implicitly public
    class InnerClass {
    }

    // implicitly public
    interface InnerInterface {
        void performInnerAction();
    }

    // implicitly public abstract
    void performAction();

    /**
     * An interface can mark a method with the default
     * keyword and provide the implementation for it.
     * (new feature of Java 8)
     */
    default void performDefaulAction() {
        // Implementation here
    }

    /**
     * interfaces may also include static methods
     */
    static void createAction() {
        // Implementation here
    }
}
