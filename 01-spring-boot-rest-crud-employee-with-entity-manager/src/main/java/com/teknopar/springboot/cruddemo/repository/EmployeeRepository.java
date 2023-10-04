package com.teknopar.springboot.cruddemo.repository;

import com.teknopar.springboot.cruddemo.model.Employee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    void deleteById(int id);

}
