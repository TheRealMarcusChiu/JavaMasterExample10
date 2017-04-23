package aspect_oriented_programming.spring.around;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component // tells spring boot to load this
public class AroundExample {

    @Around("execution(* Operation.*(..))") //applying pointcut on Around advice
    public void myadvice(ProceedingJoinPoint joinPoint) throws Throwable //it is advice (Around advice)
    {
        System.out.println("logAround() is running!");
        System.out.println("hijacked method : " + joinPoint.getSignature().getName());
        System.out.println("hijacked arguments : " + Arrays.toString(joinPoint.getArgs()));

        System.out.println("Around before is running!");
        joinPoint.proceed(); //continue on the intercepted method
        System.out.println("Around after is running!");

        System.out.println("******");
    }
}
