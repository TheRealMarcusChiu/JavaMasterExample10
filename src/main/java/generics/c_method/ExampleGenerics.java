package generics.c_method;

import java.util.Collection;

/**
 * There are no restrictions on which methods can use generic types,
 * they could be concrete, abstract, static or final. Here is a couple of examples:
 */
public class ExampleGenerics {

    public<T> void performAction(T generic) {
        // Implementation here
        System.out.println("String value: " + generic.toString());
    }

    static<T> void printCollectionSize(final Collection<T> generic) {
        // Implementation here
        System.out.println("Size of Collection: " + generic.size());
    }

    // protected abstract< T, R > R performAction( final T action );
}
