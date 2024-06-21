package com.cts.employees.repository;

import com.cts.employees.EmployeeNotFoundException;
import com.cts.employees.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
  //custom query methods
    Employee findByEmail();
    List<Employee> fetchEmployees();

    Employee fetchEmployeeByID(Integer Id) throws EmployeeNotFoundException;

    String delEmployeeByID(Integer empId) throws EmployeeNotFoundException;

    Employee updateEmployee(int empId, Employee updateEmp) throws EmployeeNotFoundException;


}
