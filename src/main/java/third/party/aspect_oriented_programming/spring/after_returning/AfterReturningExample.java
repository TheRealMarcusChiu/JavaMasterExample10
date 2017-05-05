package third.party.aspect_oriented_programming.spring.after_returning;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component // tells spring boot to load this
public class AfterReturningExample {

    @AfterReturning(
            pointcut = "execution(* third.party.aspect_oriented_programming.spring.after_returning.Operation.*(..))", //applying pointcut on AfterReturning advice
            returning= "result")
    public void myadvice(JoinPoint joinPoint, Object result) //it is advice (AfterReturning advice)
    {
        System.out.println("logAfterReturning() is running!");
        System.out.println("hijacked : " + joinPoint.getSignature().getName());
        System.out.println("Method returned value is : " + result);
        System.out.println("******");
    }
}
