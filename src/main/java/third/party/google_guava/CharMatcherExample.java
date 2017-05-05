package third.party.google_guava;

import com.google.common.base.CharMatcher;
import org.junit.Test;

public class CharMatcherExample {

    @Test
    public void test() {

        String s = "asdfghjkl";

        if(CharMatcher.ASCII.matchesAllOf(s)) {
            System.out.println("matches");
        } else {
            System.out.println("not matches");
        }
    }
}
