package google_guava;

import com.google.common.base.Preconditions;
import org.junit.Test;

public class PreconditionsExample {

    public void greet(String greeting) throws IllegalArgumentException {
        Preconditions.checkArgument(greeting != null, "Null greeting");
    }

    @Test(expected = IllegalArgumentException.class)
    public void failure() {
        PreconditionsExample preconditionsExample = new PreconditionsExample();
        preconditionsExample.greet(null);
    }

    @Test
    public void success() {
        PreconditionsExample preconditionsExample = new PreconditionsExample();
        preconditionsExample.greet("hello");
    }
}
