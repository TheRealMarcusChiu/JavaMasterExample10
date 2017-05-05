package third.party.aspect_oriented_programming.spring.after_throwing;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component // tells spring boot to load this
public class AfterThrowingExample {

    @AfterThrowing(
            pointcut = "execution(* third.party.aspect_oriented_programming.spring.after_throwing.Operation.*(..))", //applying pointcut on AfterThrowing advice
            throwing = "error")
    public void myadvice(JoinPoint joinPoint, Throwable error) //it is advice (AfterThrowing advice)
    {
        System.out.println("logAfterThrowing() is running!");
        System.out.println("hijacked : " + joinPoint.getSignature().getName());
        System.out.println("Exception : " + error);
        System.out.println("******");
    }
}
