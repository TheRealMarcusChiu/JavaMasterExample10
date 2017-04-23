package aspect_oriented_programming.spring.after;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

    // Not needed because @SpringBootApplication scans the root directory of this file
//    @Bean
//    public Operation operation() {
//        System.out.println("creating operation bean");
//        return new Operation();
//    }

    public static void main(String[] args) {
        final ApplicationContext applicationContext = SpringApplication.run(Application.class, args);

        // get the operation bean
        Operation operation = applicationContext.getBean(Operation.class);
        operation.test();
    }
}
