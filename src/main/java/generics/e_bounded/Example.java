package generics.e_bounded;

import java.io.Serializable;

public class Example implements Runnable, Serializable {
    @Override
    public void run() {
        System.out.println("Hello, World");
    }
}
