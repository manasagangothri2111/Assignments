package com.cts.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {

		var container = new AnnotationConfigApplicationContext(AppConfig.class);

		Employee bean = container.getBean(Employee.class);

		bean.work();

//		bean.login();
	}
}
