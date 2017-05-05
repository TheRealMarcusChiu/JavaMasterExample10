package third.party.aspect_oriented_programming.spring.after_throwing;

import org.springframework.stereotype.Component;

@Component
public class Operation {

    public void throwNothing() {
        System.out.println("throwNothing() method invoked");
    }

    public void throwError() throws Exception {
        System.out.println("throwError() method invoked");
        throw new Exception();
    }
}
