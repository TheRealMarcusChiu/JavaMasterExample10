package third.party.google_guava;

import com.google.common.base.Preconditions;
import org.junit.Test;

public class PreconditionsExample {

    public void greet(String greeting) throws IllegalArgumentException {
        Preconditions.checkArgument(greeting != null, "Null greeting");
        Preconditions.checkArgument(greeting.equals("Hello, World!"), "not a string");
    }

    @Test(expected = IllegalArgumentException.class)
    public void failure1() {
        PreconditionsExample preconditionsExample = new PreconditionsExample();
        preconditionsExample.greet(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void failure2() {
        PreconditionsExample preconditionsExample = new PreconditionsExample();
        preconditionsExample.greet("Bugs Bunny");
    }

    @Test
    public void success() {
        PreconditionsExample preconditionsExample = new PreconditionsExample();
        preconditionsExample.greet("Hello, World!");
    }
}
