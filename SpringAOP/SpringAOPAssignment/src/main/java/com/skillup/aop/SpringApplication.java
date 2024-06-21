package com.skillup.aop;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;

public class SpringApplication {

    public static void main(String[] args) {
        var container = new AnnotationConfigApplicationContext(AppConfig.class);

        Employee bean = container.getBean(Employee.class);

        bean.work();
    }
}

