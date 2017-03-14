package class_design.anonymous_class;

import org.junit.Test;

public class ExampleAnonymousClass {

    /**
     * Old Way
     */
    @Test
    public void test() {
        new Thread(
            // Example of creating anonymous class which implements
            // Runnable Functional Interface
            new Runnable() {
                @Override
                public void run() {
                    System.out.println("Hello, World!");
                }
            }
        ).start();
    }

    /**
     * New Way
     */
    @Test
    public void testLambda() {
        new Thread( () -> System.out.println("Hello, World! ONE")).start();

        new Thread( () -> {
            System.out.println("Hello, World! ONE");
            System.out.println("Hello, World! TWO");
        }).start();
    }
}
