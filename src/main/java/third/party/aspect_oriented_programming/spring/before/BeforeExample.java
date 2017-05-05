package third.party.aspect_oriented_programming.spring.before;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component // tells spring boot to load this
public class BeforeExample {

    @Before("execution(* third.party.aspect_oriented_programming.spring.before.Operation.*(..))") //applying pointcut on Before advice
    public void myadvice(JoinPoint jp) //it is advice (Before advice)
    {
        System.out.println("additional concern");
        System.out.println("Method Signature: "  + jp.getSignature());
    }
}
