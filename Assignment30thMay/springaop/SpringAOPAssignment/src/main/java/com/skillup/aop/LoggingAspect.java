package com.skillup.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("execution(* com.skillup.aop.*.*(..))")
    public void logmethod(){}

    @Before("logmethod()")
    public void logBefore(JoinPoint jp){
        System.out.println("logbefore");
        Object[] args = jp.getArgs();
        String methodName = jp.getSignature().getName();
        LOGGER.info("MethodName > "+methodName+"  args"+args.toString());

    }
    @AfterReturning(pointcut = "logmethod()", returning = "result")
    public void logAfter(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        LOGGER.info("MethodName > "+methodName+"  result"+result);
    }
    @AfterThrowing(pointcut = "logmethod()", throwing = "exception")
    public void logException(JoinPoint joinPoint, Throwable exception) {
        String methodName = joinPoint.getSignature().getName();
        LOGGER.error("MethodName > "+methodName+"  exception >"+exception);
    }
    @Around(value = "logmethod()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        String methodName = joinPoint.getSignature().getName();
        LOGGER.info("MethodName > "+methodName+"  Args >"+args);
        Object result = joinPoint.proceed();
        LOGGER.info("MethodName > "+methodName+"  result >"+result);
        return result;
    }
}
