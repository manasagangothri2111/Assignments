package com.skillup.aop;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;

public class SpringLearnApplication {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
        SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
        String date = "31/05/2022";
        try {
            System.out.println("dateformat :  " + format.parse(date));
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        //second question
        ApplicationContext context1 = new ClassPathXmlApplicationContext("date-format.xml");
        Student st = context1.getBean("student",Student.class);
        System.out.println("Setter Injection > "+st.getName()+"\n"+st.getGender()+"\n"+st.getGrade());
        ((ClassPathXmlApplicationContext)context1).close();
        //3 question : Reading Properties file
        PropertiesDemo propertiesDemo = context.getBean("prop", PropertiesDemo.class);
        System.out.println("Reading Property file"+ propertiesDemo);
        //4. byType bean implementation
        Employee emp = context.getBean("emp",Employee.class);
        System.out.println("Reading bean "+ emp.toString());

        //5. Cat and Dog bean implementation
        Animal cat = context.getBean("cat",Cat.class);
        System.out.println("Cat "+ cat.toString());
        Animal dog = context.getBean("dog",Dog.class);
        System.out.println("Dog "+ dog.toString());

    }
}
