package com.teknopar.springboot.cruddemo.service.abstracts;

import com.teknopar.springboot.cruddemo.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    void deleteById(int id);

}
