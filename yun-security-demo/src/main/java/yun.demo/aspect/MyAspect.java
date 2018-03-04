package yun.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author yzhang
 * @date 2018/3/4 20:44
 * @desc
 */
@Aspect
@Component
public class MyAspect {

    @Pointcut("execution(* yun.demo.controller.UserController.*(..))")
    public void object(){}


    @Around("object()")
    public Object beforeAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        System.out.println("MyAspect round。。。。。。。");
        for(Object o:args){
            System.out.println(o);
        }
        Object proceed = joinPoint.proceed();
        return proceed;
    }
}
