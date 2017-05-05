package third.party.aspect_oriented_programming.spring.after;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component // tells spring boot to load this
public class AfterExample {

    @After("execution(* third.party.aspect_oriented_programming.spring.after.Operation.*(..))") //applying pointcut on After advice
    public void myadvice(JoinPoint joinPoint) //it is advice (After advice)
    {
        System.out.println("additional concern");
        System.out.println("Method Signature: "  + joinPoint.getSignature());
    }
}
