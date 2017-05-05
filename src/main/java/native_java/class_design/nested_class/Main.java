package native_java.class_design.nested_class;

import org.junit.Test;

public class Main {

    @Test
    public void testCreateInnerClassObject() {
        ExampleInnerClass exampleInnerClass = new ExampleInnerClass();
        ExampleInnerClass.InnerClass innerClass = exampleInnerClass.new InnerClass();
    }

    @Test
    public void testCreateStaticNestedObject() {
        ExampleNestedStaticClass.NestedStaticClass nestedStaticClass = new ExampleNestedStaticClass.NestedStaticClass();
    }
}
