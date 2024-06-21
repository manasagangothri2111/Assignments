package com.cts.aop;

import org.springframework.stereotype.Component;

@Component
public class Employee {

	public void work() {
		System.out.println("Employee works on a project!");
	}

	public void login() {
		System.out.println("login works");
	}
}