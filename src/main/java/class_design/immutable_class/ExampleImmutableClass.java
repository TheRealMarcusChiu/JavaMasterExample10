package class_design.immutable_class;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * Immutability is becoming more and more important in the software development nowadays.
 * The rise of multi-core systems has raised a lot of concerns related to data sharing and
 * concurrency (in the part 9, Concurrency best practices, we are going to discuss in details
 * those topics). But the one thing definitely emerged: less (or even absence of) mutable
 * state leads to better scalability and simpler reasoning about the systems.
 *
 * Unfortunately, the Java language does not provide strong support for class immutability.
 * However using a combination of techniques it is possible to design classes which are immutable.
 *
 * Even this small example gives a good idea that immutability is not a first class citizen in Java yet.
 * Things can get really complicated if an immutable class has fields referencing another class instances.
 * Those classes should also be immutable however there is no simple way to enforce that.
 */
public class ExampleImmutableClass {

    /**
     * First and foremost, all fields of the class should be final. It is a good start but
     * does not guarantee immutability alone.
     */
    private final long id;
    private final String[] arrayOfStrings;
    private final Collection< String > collectionOfString;

    /**
     * Secondly, follow the proper initialization: if the field is the reference to a collection or
     * an array, do not assign those fields directly from constructor arguments, make the copies
     * instead. It will guarantee that state of the collection or array will not be changed from outside.
     */
    public ExampleImmutableClass( final long id, final String[] arrayOfStrings, final Collection< String > collectionOfString) {
        this.id = id;
        this.arrayOfStrings = Arrays.copyOf( arrayOfStrings, arrayOfStrings.length );
        this.collectionOfString = new ArrayList<>( collectionOfString );
    }

    /**
     * And lastly, provide the proper accessors (getters). For the collection, the immutable view
     * should be exposed using Collections.unmodifiableXxx wrappers.
     */

    public long getID() {
        return id;
    }

    public String[] getArrayOfStrings() {
        return Arrays.copyOf( arrayOfStrings, arrayOfStrings.length );
    }

    public Collection<String> getCollectionOfString() {
        return Collections.unmodifiableCollection( collectionOfString );
    }
}
