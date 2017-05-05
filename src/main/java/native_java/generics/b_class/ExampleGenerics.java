package native_java.generics.b_class;

public class ExampleGenerics< T > {

    public String genericToString(final T generic) {
        return "String value: " + generic.toString();
    }
}
