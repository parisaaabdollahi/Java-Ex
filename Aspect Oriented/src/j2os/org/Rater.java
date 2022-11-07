package j2os.org;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class Rater {
    @Around("execution(* j2os.org.Student.*(..))")
    public  void  monitor(ProceedingJoinPoint point) throws Throwable {
        System.out.println("hey monitoring");
point.proceed();
        System.out.println("bye monitoring");
    }

}
