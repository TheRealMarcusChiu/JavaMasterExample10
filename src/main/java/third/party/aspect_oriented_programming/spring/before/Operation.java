package third.party.aspect_oriented_programming.spring.before;

import org.springframework.stereotype.Component;

@Component
public class Operation {

    public void test() {
        System.out.println("test() method invoked");
    }

    public Integer returnOne() {
        System.out.println("returnOne() method invoked");
        return 1;
    }

    public Integer returnTwo() {
        System.out.println("returnTwo() method invoked");
        return 2;
    }
}
