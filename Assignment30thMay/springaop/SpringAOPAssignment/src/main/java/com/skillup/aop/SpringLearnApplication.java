package com.skillup.aop;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;

public class SpringLearnApplication {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Employee emp = context.getBean("emp",Employee.class);
        System.out.println("Reading bean "+ emp.toString());
        emp.work();
        printMethod();


    }
    public static void printMethod(){

    }
}