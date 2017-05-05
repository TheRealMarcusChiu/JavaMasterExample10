package native_java.java_8.lambda;

import org.junit.Test;

public class LambdaGreeting {

    interface GreetingService {
        void sayMessage(String message);
    }

    @Test
    public void test() {
        //with parenthesis
        GreetingService greetService1 = message ->
                System.out.println("Hello " + message);

        //without parenthesis
        GreetingService greetService2 = (message) ->
                System.out.println("Hello " + message + ". My Name is Marcus");

        greetService1.sayMessage("Mahesh");
        greetService2.sayMessage("Suresh");
    }

    @Test
    public void test2() {
        String salutation = "Hello! ";
        GreetingService greeting = message -> System.out.println(salutation + message);
        greeting.sayMessage("Marcus");
    }
}
