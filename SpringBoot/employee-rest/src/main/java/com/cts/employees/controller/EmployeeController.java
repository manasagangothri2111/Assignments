package com.cts.employees.controller;

import org.hibernate.annotations.GeneratorType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @GetMapping("/getMessage")
    public String getMessage(){
        return "HelloWorld";
    }
}
