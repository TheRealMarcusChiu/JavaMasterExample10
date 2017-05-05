package native_java.generics.d_wild.card;

import java.io.Serializable;
import java.util.Collection;

public class WildCard {

    /**
     * If the type parameter is not of the interest of the generic class,
     * interface or method, it could be replaced by the ? wildcard.
     *
     * The method store does not really care what type parameters it is
     * being called with, the only thing it needs to ensure that every
     * type implements Serializable interface
     * @param objects
     */
    public void wildCard(final Collection<? extends Serializable> objects) {
        // Some implementation here
    }

    /**
     * Or, if this is not of any importance, the wildcard without bounds could be used instead
     * @param objects
     */
    public void store(final Collection<?> objects) {
        // Some implementation here
    }
}
