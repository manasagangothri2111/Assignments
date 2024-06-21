package com.cts.aop;

import java.util.concurrent.TimeUnit;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Greetings {

	@Before("execution(* com.cts.aop.Employee.work())")
	public void greeting() {
		System.out.println("Good Morning!");
	}

	@After("execution(* com.cts.aop.Employee.work())")
	public void goodbye() {
		System.out.println("Good Bye!!");
	}

	@Around("execution(* com.cts.aop.Employee.work())")
	public void loginAdvice(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.nanoTime();
		Object obj = pjp.proceed();
		long end = System.nanoTime();
		String methodName = pjp.getSignature().getName();
		System.out.println(methodName + " took " + TimeUnit.NANOSECONDS.toMillis(end - start) + "ms of Execution Time");
	}
}
