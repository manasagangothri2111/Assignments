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

    @Before("execution(* com.skillup.aop.Employee.work())")
    public void logBefore(JoinPoint jp){
        Object[] args = jp.getArgs();
        String methodName = jp.getSignature().getName();
        Logger LOGGER = LoggerFactory.getLogger(jp.getClass());

        LOGGER.debug("MethodName > "+methodName+"  args"+args.toString());

    }
    @AfterReturning(value = "execution(* com.skillup.aop.Employee.work())", returning = "result")
    public void logAfter(JoinPoint joinPoint, Object result) {
        Logger LOGGER = LoggerFactory.getLogger(joinPoint.getClass());
        String methodName = joinPoint.getSignature().getName();
        LOGGER.debug("MethodName > "+methodName+"  result"+result);
    }
    @AfterThrowing(pointcut = "execution(* com.skillup.aop.Employee.work())", throwing = "exception")
    public void logException(JoinPoint joinPoint, Throwable exception) {
        String methodName = joinPoint.getSignature().getName();
        Logger LOGGER = LoggerFactory.getLogger(joinPoint.getClass());
        LOGGER.error("MethodName > "+methodName+"  exception >"+exception);
    }
    @Around(value = "execution(* com.skillup.aop.Employee.work())")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        String methodName = joinPoint.getSignature().getName();
        Logger LOGGER = LoggerFactory.getLogger(joinPoint.getClass());
        LOGGER.info("MethodName > "+methodName+"  Args >"+args);
        Object result = joinPoint.proceed();
        LOGGER.info("MethodName > "+methodName+"  result >"+result);
        return result;
    }
}
